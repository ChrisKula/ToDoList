package com.christiankula.todolist.edittodo;

import static com.christiankula.todolist.injection.modules.NewToDoModule.SIMPLE_DATE_FORMAT;
import static com.christiankula.todolist.injection.modules.NewToDoModule.TIME_DATE_FORMAT;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.christiankula.todolist.R;
import com.christiankula.todolist.ToDoListApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditToDoActivity extends AppCompatActivity implements EditToDoMvp.View, TextWatcher {

    @BindView(R.id.newtodo_et_description)
    EditText etDescription;

    @BindView(R.id.newtodo_tv_date)
    TextView tvDate;

    @BindView(R.id.newtodo_tv_time)
    TextView tvTime;

    @Named(SIMPLE_DATE_FORMAT)
    @Inject
    SimpleDateFormat dateFormat;

    @Named(TIME_DATE_FORMAT)
    @Inject
    SimpleDateFormat timeFormat;

    private EditToDoMvp.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_to_do);

        ((ToDoListApplication) getApplication()).getComponent().inject(this);

        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        presenter.onViewAttached(this);

        etDescription.addTextChangedListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

        etDescription.removeTextChangedListener(this);

        presenter.onViewDetached();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_new_todo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.newtodo_menu_item_save:
                presenter.onSaveToDoMenuItemClick();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Inject
    @Override
    public void setPresenter(EditToDoMvp.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void close() {
        finish();
    }

    @Override
    public void setExpirationDate(Date date) {
        tvDate.setText(dateFormat.format(date));
    }

    @Override
    public void setExpirationTime(Date time) {
        tvTime.setText(timeFormat.format(time));
    }

    @Override
    public void showDatePickerDialog(int year, int month, int dayOfMonth) {
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                presenter.onToDoDateSet(year, month, dayOfMonth);
            }
        }, year, month, dayOfMonth).show();
    }

    @Override
    public void showTimePickerDialog(int hour, int minute) {
        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                presenter.onToDoTimeSet(hourOfDay, minute);
            }
        }, hour, minute, true).show();
    }

    @Override
    public void showDescriptionEmptyErrorToast() {
        Toast.makeText(this, "Description empty", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.newtodo_tv_date)
    void onToDoDateTap() {
        presenter.onToDoDateTap();
    }

    @OnClick(R.id.newtodo_tv_time)
    void onToDoTimeTap() {
        presenter.onToDoTimeTap();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        presenter.onToDoDescriptionChanged(s.toString());
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
