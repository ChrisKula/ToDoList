package com.christiankula.todolist.newtodo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.christiankula.todolist.R;
import com.christiankula.todolist.ToDoListApplication;

import javax.inject.Inject;

public class NewToDoActivity extends AppCompatActivity implements NewToDoMvp.View {

    private NewToDoMvp.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_to_do);

        ((ToDoListApplication) getApplication()).getComponent().inject(this);
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
    public void setPresenter(NewToDoMvp.Presenter presenter) {
        this.presenter = presenter;
    }
}
