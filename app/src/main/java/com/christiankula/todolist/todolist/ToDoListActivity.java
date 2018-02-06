package com.christiankula.todolist.todolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.christiankula.todolist.R;
import com.christiankula.todolist.ToDoListApplication;
import com.christiankula.todolist.models.ToDo;
import com.christiankula.todolist.todolist.mvp.ToDoListMvp;
import com.christiankula.todolist.utils.ViewUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ToDoListActivity extends AppCompatActivity implements ToDoListMvp.View {

    @BindView(R.id.todolist_tv_no_todos)
    TextView tvNoToDos;

    @BindView(R.id.todolist_rv_todos)
    RecyclerView rvToDos;

    private ToDoListMvp.Presenter presenter;

    @Inject
    ToDoAdapter toDoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);

        ((ToDoListApplication) getApplication()).getComponent().inject(this);
        ButterKnife.bind(this);

        initToDosRecyclerView();
    }

    @Override
    protected void onStart() {
        super.onStart();

        presenter.onViewAttached(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

        presenter.onViewDetached();
    }

    @Inject
    @Override
    public void setPresenter(ToDoListMvp.Presenter presenter) {
        this.presenter = presenter;
    }

    private void initToDosRecyclerView() {
        rvToDos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvToDos.setAdapter(toDoAdapter);
    }

    @Override
    public void displayToDos(List<ToDo> toDos) {
        toDoAdapter.updateToDos(toDos);
    }

    @Override
    public void setToDosListVisibility(boolean visible) {
        ViewUtils.setViewVisibility(rvToDos, visible);
    }

    @Override
    public void setNoToDosMessageVisibility(boolean visible) {
        ViewUtils.setViewVisibility(tvNoToDos, visible);
    }
}