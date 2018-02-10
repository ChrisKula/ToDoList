package com.christiankula.todolist.todolist;

import com.christiankula.todolist.models.ToDo;
import com.christiankula.todolist.todolist.mvp.ToDoListMvp;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class ToDoListPresenter implements ToDoListMvp.Presenter {

    private ToDoListMvp.View view;
    private ToDoListMvp.Model model;

    private Disposable toDosDisposable;

    public ToDoListPresenter(ToDoListMvp.Model model) {
        this.model = model;
    }

    @Override
    public void onViewAttached(ToDoListMvp.View view) {
        this.view = view;

        toDosDisposable = this.model.observeToDos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<ToDo>>() {
                    @Override
                    public void accept(List<ToDo> toDos) throws Exception {
                        if (toDos.isEmpty()) {
                            ToDoListPresenter.this.view.setNoToDosMessageVisibility(true);
                            ToDoListPresenter.this.view.setToDosListVisibility(false);
                        } else {
                            ToDoListPresenter.this.view.displayToDos(toDos);

                            ToDoListPresenter.this.view.setNoToDosMessageVisibility(false);
                            ToDoListPresenter.this.view.setToDosListVisibility(true);
                        }
                    }
                });
    }

    @Override
    public void onViewDetached() {
        if (toDosDisposable != null && !toDosDisposable.isDisposed()) {
            toDosDisposable.dispose();
        }

        view = null;
    }

    @Override
    public void onNewToDoFabClick() {
        this.view.startEditToDoActivity();
    }

    @Override
    public void onToDoItemClick(ToDo toDo) {
        this.view.startEditToDoActivity(toDo);
    }

    @Override
    public void onToDoRemoved(ToDo toDo) {
        this.model.removeToDo(toDo);
    }
}
