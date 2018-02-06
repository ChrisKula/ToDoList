package com.christiankula.todolist.todolist;

import com.christiankula.todolist.todolist.mvp.ToDoListMvp;


public class ToDoListPresenter implements ToDoListMvp.Presenter {

    private ToDoListMvp.View view;
    private ToDoListMvp.Model model;

    public ToDoListPresenter(ToDoListMvp.Model model) {
        this.model = model;
    }

    @Override
    public void attachView(ToDoListMvp.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }
}
