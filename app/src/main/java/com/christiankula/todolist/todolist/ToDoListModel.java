package com.christiankula.todolist.todolist;

import com.christiankula.todolist.models.ToDo;
import com.christiankula.todolist.todolist.mvp.ToDoListMvp;

import java.util.ArrayList;
import java.util.List;

public class ToDoListModel implements ToDoListMvp.Model {

    private List<ToDo> toDos;

    public ToDoListModel() {
        toDos = new ArrayList<>();
    }

    @Override
    public List<ToDo> getToDos() {
        return toDos;
    }
}
