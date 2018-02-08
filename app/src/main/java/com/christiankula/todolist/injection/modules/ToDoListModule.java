package com.christiankula.todolist.injection.modules;

import com.christiankula.todolist.persistence.ToDoDao;
import com.christiankula.todolist.todolist.ToDoAdapter;
import com.christiankula.todolist.todolist.ToDoListModel;
import com.christiankula.todolist.todolist.ToDoListPresenter;
import com.christiankula.todolist.todolist.mvp.ToDoListMvp;

import dagger.Module;
import dagger.Provides;

@Module
public class ToDoListModule {

    @Provides
    ToDoListMvp.Model provideModel(ToDoDao toDoDao) {
        return new ToDoListModel(toDoDao);
    }

    @Provides
    ToDoListMvp.Presenter providePresenter(ToDoListMvp.Model model) {
        return new ToDoListPresenter(model);
    }

    @Provides
    ToDoAdapter provideToDoAdapter() {
        return new ToDoAdapter();
    }
}
