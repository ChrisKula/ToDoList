package com.christiankula.todolist.todolist;

import com.christiankula.todolist.models.ToDo;
import com.christiankula.todolist.todolist.mvp.ToDoListMvp;

import java.util.List;


public class ToDoListPresenter implements ToDoListMvp.Presenter {

    private ToDoListMvp.View view;
    private ToDoListMvp.Model model;

    public ToDoListPresenter(ToDoListMvp.Model model) {
        this.model = model;
    }

    @Override
    public void onViewAttached(ToDoListMvp.View view) {
        this.view = view;

        List<ToDo> toDos = model.getToDos();

        if (toDos.isEmpty()) {
            this.view.setNoToDosMessageVisibility(true);
            this.view.setToDosListVisibility(false);
        } else {
            this.view.displayToDos(model.getToDos());

            this.view.setNoToDosMessageVisibility(false);
            this.view.setToDosListVisibility(true);
        }
    }

    @Override
    public void onViewDetached() {
        view = null;
    }
}
