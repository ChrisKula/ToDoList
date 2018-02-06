package com.christiankula.todolist.injection.components;

import com.christiankula.todolist.injection.modules.ToDoListModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ToDoListModule.class)
public interface ToDoListComponent extends ApplicationComponent {

}
