package com.christiankula.todolist.newtodo;

import com.christiankula.todolist.models.ToDo;
import com.christiankula.todolist.persistence.ToDoDao;

import java.util.Calendar;

public class NewToDoModel implements NewToDoMvp.Model {

    private String toDoDescription;
    private Calendar toDoDateTime;

    private ToDoDao toDoDao;

    public NewToDoModel(ToDoDao toDoDao) {
        this.toDoDao = toDoDao;

        this.toDoDescription = "";
        this.toDoDateTime = Calendar.getInstance();
    }

    @Override
    public void setToDoDateTime(Calendar toDoDateTime) {
        this.toDoDateTime = toDoDateTime;
    }

    @Override
    public Calendar getToDoDateTime() {
        return (Calendar) toDoDateTime.clone();
    }

    @Override
    public void setToDoDescription(String description) {
        this.toDoDescription = description;
    }

    @Override
    public String getToDoDescription() {
        return toDoDescription;
    }

    @Override
    public void saveToDo(ToDo toDo) {
        toDoDao.saveOrUpdate(toDo);
    }
}
