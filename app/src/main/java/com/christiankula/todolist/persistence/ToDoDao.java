package com.christiankula.todolist.persistence;


import android.support.annotation.Nullable;
import android.util.SparseArray;

import com.christiankula.todolist.models.ToDo;
import com.christiankula.todolist.utils.ListUtils;

import java.util.List;

public class ToDoDao {

    private int toDoCounter = 1;

    private SparseArray<ToDo> toDos;

    public ToDoDao() {
        toDos = new SparseArray<>();
    }

    public void saveOrUpdate(ToDo toDo) {
        if (toDo.getId() == 0) {
            toDo.setId(toDoCounter);
            toDoCounter++;
        }

        toDos.put(toDo.getId(), toDo);
    }

    @Nullable
    public ToDo getToDoById(int id) {
        return toDos.get(id);
    }

    public void removeToDo(int id) {
        toDos.delete(id);
    }

    public List<ToDo> getAllToDos() {
        return ListUtils.asList(toDos);
    }
}
