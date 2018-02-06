package com.christiankula.todolist.mvp;

public interface BaseView<P extends BasePresenter> {
    void setPresenter(P presenter);
}
