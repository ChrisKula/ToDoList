package com.christiankula.todolist.injection.modules;


import com.christiankula.todolist.persistence.ToDoDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PersistenceModule {

    @Provides
    @Singleton
    ToDoDao provideToDoDao() {
        return new ToDoDao();
    }
}
