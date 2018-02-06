package com.christiankula.todolist.newtodo;

import com.christiankula.todolist.mvp.BasePresenter;
import com.christiankula.todolist.mvp.BaseView;

public interface NewToDoMvp {

    interface Model {

    }

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter<View> {

    }

}
