package com.christiankula.todolist.persistence;


import android.support.annotation.Nullable;
import android.util.SparseArray;

import com.christiankula.todolist.models.ToDo;
import com.christiankula.todolist.utils.ListUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public class ToDoDao {

    private int toDoCounter = 1;

    private SparseArray<ToDo> toDos;

    private BehaviorSubject<List<ToDo>> toDosSubject;

    public ToDoDao() {
        toDos = new SparseArray<>();

        toDosSubject = BehaviorSubject.create();
    }

    public void saveOrUpdate(ToDo toDo) {
        if (toDo.getId() == 0) {
            toDo.setId(toDoCounter);
            toDoCounter++;
        }

        toDos.put(toDo.getId(), toDo);

        toDosSubject.onNext(asList());
    }

    @Nullable
    public ToDo getToDoById(int id) {
        return toDos.get(id);
    }

    public void removeToDo(int id) {
        toDos.delete(id);

        toDosSubject.onNext(asList());
    }

    public Observable<List<ToDo>> observeToDos() {
        return toDosSubject;
    }

    private List<ToDo> asList() {
        return ListUtils.asList(toDos);
    }
}
