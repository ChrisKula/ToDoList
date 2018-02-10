package com.christiankula.todolist.todolist.mvp;


import com.christiankula.todolist.models.ToDo;
import com.christiankula.todolist.mvp.BasePresenter;
import com.christiankula.todolist.mvp.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface ToDoListMvp {

    interface Model {
        void removeToDo(ToDo toDo);

        Observable<List<ToDo>> observeToDos();
    }

    interface View extends BaseView<Presenter> {
        void displayToDos(List<ToDo> toDos);

        void setToDosListVisibility(boolean visible);

        void setNoToDosMessageVisibility(boolean visible);

        void startEditToDoActivity();

        void startEditToDoActivity(ToDo toDo);
    }

    interface Presenter extends BasePresenter<View> {
        void onNewToDoFabClick();

        void onToDoItemClick(ToDo toDo);

        void onToDoRemoved(ToDo toDo);
    }
}
