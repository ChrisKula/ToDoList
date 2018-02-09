package com.christiankula.todolist.edittodo;

import com.christiankula.todolist.models.ToDo;
import com.christiankula.todolist.persistence.ToDoDao;

import java.util.Date;

public class EditToDoModel implements EditToDoMvp.Model {

    private ToDo editedTodo;

    private ToDoDao toDoDao;

    public EditToDoModel(ToDoDao toDoDao) {
        this.toDoDao = toDoDao;
    }

    @Override
    public void initEditedToDo() {
        this.editedTodo = new ToDo();
    }

    @Override
    public void setEditedTodo(ToDo toDo) {
        this.editedTodo = toDo;
    }

    @Override
    public String getToDoDescription() {
        return this.editedTodo.getDescription();
    }

    @Override
    public void setToDoDescription(String description) {
        this.editedTodo.setDescription(description);
    }

    @Override
    public Date getToDoDate() {
        return editedTodo.getExpirationDate();
    }

    @Override
    public void setToDoDate(Date expirationDate) {
        this.editedTodo.setExpirationDate(expirationDate);
    }

    @Override
    public void saveToDo() {
        toDoDao.saveOrUpdate(editedTodo);
    }
}
