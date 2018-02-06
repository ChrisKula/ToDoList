package com.christiankula.todolist.todolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.christiankula.todolist.R;
import com.christiankula.todolist.todolist.mvp.ToDoListMvp;

public class ToDoListActivity extends AppCompatActivity implements ToDoListMvp.View {

    private ToDoListMvp.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);
    }

    @Override
    public void setPresenter(ToDoListMvp.Presenter presenter) {
        this.presenter = presenter;
    }
}
