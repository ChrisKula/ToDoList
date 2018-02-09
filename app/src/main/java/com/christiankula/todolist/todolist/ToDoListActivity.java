package com.christiankula.todolist.todolist;

import static com.christiankula.todolist.edittodo.EditToDoActivity.TODO_EXTRA_KEY;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.christiankula.todolist.R;
import com.christiankula.todolist.ToDoListApplication;
import com.christiankula.todolist.edittodo.EditToDoActivity;
import com.christiankula.todolist.models.ToDo;
import com.christiankula.todolist.todolist.mvp.ToDoListMvp;
import com.christiankula.todolist.utils.ViewUtils;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ToDoListActivity extends AppCompatActivity implements ToDoListMvp.View, ToDoAdapter.OnItemClickListener {

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

        toDoAdapter.setOnItemClickListener(this);
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

    @Override
    public void startEditToDoActivity() {
        startEditToDoActivity(null);
    }

    @Override
    public void startEditToDoActivity(ToDo toDo) {
        Intent intent = new Intent(this, EditToDoActivity.class);

        if (toDo != null) {
            intent.putExtra(TODO_EXTRA_KEY, Parcels.wrap(toDo));
        }

        startActivity(intent);
    }

    @OnClick(R.id.todolist_fab_new_todo)
    void onNewToDoFabClick() {
        presenter.onNewToDoFabClick();
    }

    @Override
    public void onItemClick(ToDo toDo) {
        presenter.onToDoItemClick(toDo);
    }
}
