package com.christiankula.todolist.mvp;

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();
}
