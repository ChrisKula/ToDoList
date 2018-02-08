package com.christiankula.todolist.injection.components;

import com.christiankula.todolist.injection.modules.ApplicationModule;
import com.christiankula.todolist.injection.modules.DateTimePatternModule;
import com.christiankula.todolist.injection.modules.NewToDoModule;
import com.christiankula.todolist.injection.modules.PersistenceModule;
import com.christiankula.todolist.injection.modules.ToDoListModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ToDoListModule.class, NewToDoModule.class, PersistenceModule.class,
        DateTimePatternModule.class})
public interface ToDoListComponent extends ApplicationComponent {

}
