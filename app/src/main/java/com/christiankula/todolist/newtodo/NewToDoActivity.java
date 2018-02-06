package com.christiankula.todolist.newtodo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.christiankula.todolist.R;

public class NewToDoActivity extends AppCompatActivity implements NewToDoMvp.View {

    private NewToDoMvp.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_to_do);
    }

    @Override
    public void setPresenter(NewToDoMvp.Presenter presenter) {
        this.presenter = presenter;
    }
}
