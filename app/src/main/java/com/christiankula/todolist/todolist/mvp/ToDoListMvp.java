package com.christiankula.todolist.todolist.mvp;


import com.christiankula.todolist.models.ToDo;
import com.christiankula.todolist.mvp.BasePresenter;
import com.christiankula.todolist.mvp.BaseView;

import java.util.List;

public interface ToDoListMvp {

    interface Model {
        List<ToDo> getToDos();
    }

    interface View extends BaseView<Presenter> {
        void displayToDos(List<ToDo> toDos);

        void setToDosListVisibility(boolean visible);

        void setNoToDosMessageVisibility(boolean visible);

        void startNewToDoActivity();
    }

    interface Presenter extends BasePresenter<View> {
        void onNewToDoFabClick();
    }
}
