package com.christiankula.todolist.newtodo;


public class NewToDoPresenter implements NewToDoMvp.Presenter {

    private NewToDoMvp.View view;
    private NewToDoMvp.Model model;

    public NewToDoPresenter(NewToDoMvp.Model model) {
        this.model = model;
    }

    @Override
    public void onViewAttached(NewToDoMvp.View view) {
        this.view = view;
    }

    @Override
    public void onViewDetached() {
        this.view = null;
    }
}
