package com.christiankula.todolist.injection.modules;

import com.christiankula.todolist.todolist.ToDoAdapter;
import com.christiankula.todolist.todolist.ToDoListModel;
import com.christiankula.todolist.todolist.ToDoListPresenter;
import com.christiankula.todolist.todolist.mvp.ToDoListMvp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ToDoListModule {

    @Provides
    @Singleton
    ToDoListMvp.Model provideModel() {
        return new ToDoListModel();
    }

    @Provides
    @Singleton
    ToDoListMvp.Presenter providePresenter(ToDoListMvp.Model model) {
        return new ToDoListPresenter(model);
    }

    @Provides
    ToDoAdapter provideToDoAdapter() {
        return new ToDoAdapter();
    }
}
