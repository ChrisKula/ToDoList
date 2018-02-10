package com.christiankula.todolist.todolist;

import com.christiankula.todolist.models.ToDo;
import com.christiankula.todolist.persistence.ToDoDao;
import com.christiankula.todolist.todolist.mvp.ToDoListMvp;

import java.util.List;

import io.reactivex.Observable;

public class ToDoListModel implements ToDoListMvp.Model {

    private ToDoDao toDoDao;

    public ToDoListModel(ToDoDao toDoDao) {
        this.toDoDao = toDoDao;
    }

    @Override
    public void removeToDo(ToDo toDo) {
        toDoDao.removeToDo(toDo.getId());
    }

    @Override
    public Observable<List<ToDo>> observeToDos() {
        return toDoDao.observeToDos();
    }
}
