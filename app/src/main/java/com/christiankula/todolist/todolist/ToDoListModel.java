package com.christiankula.todolist.todolist;

import com.christiankula.todolist.models.ToDo;
import com.christiankula.todolist.persistence.ToDoDao;
import com.christiankula.todolist.todolist.mvp.ToDoListMvp;

import java.util.List;

public class ToDoListModel implements ToDoListMvp.Model {

    private ToDoDao toDoDao;

    public ToDoListModel(ToDoDao toDoDao) {
        this.toDoDao = toDoDao;
    }

    @Override
    public List<ToDo> getToDos() {
        return toDoDao.getAllToDos();
    }
}
