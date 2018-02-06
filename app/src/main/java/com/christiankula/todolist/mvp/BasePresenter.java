package com.christiankula.todolist.mvp;

public interface BasePresenter<V extends BaseView> {

    void onViewAttached(V view);

    void onViewDetached();
}
