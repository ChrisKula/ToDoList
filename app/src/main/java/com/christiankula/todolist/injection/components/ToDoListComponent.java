package com.christiankula.todolist.injection.components;

import com.christiankula.todolist.injection.modules.NewToDoModule;
import com.christiankula.todolist.injection.modules.ToDoListModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ToDoListModule.class, NewToDoModule.class})
public interface ToDoListComponent extends ApplicationComponent {

}
