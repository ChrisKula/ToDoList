package com.christiankula.todolist.todolist.mvp;


import com.christiankula.todolist.mvp.BasePresenter;
import com.christiankula.todolist.mvp.BaseView;

public interface ToDoListMvp {

    interface Model {

    }

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter<View> {

    }
}
