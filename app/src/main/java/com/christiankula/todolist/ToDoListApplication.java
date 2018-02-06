package com.christiankula.todolist;

import android.app.Application;

import com.christiankula.todolist.injection.components.DaggerToDoListComponent;
import com.christiankula.todolist.injection.components.ToDoListComponent;
import com.christiankula.todolist.injection.modules.ToDoListModule;

public class ToDoListApplication extends Application {

    private final ToDoListComponent component = createComponent();

    protected ToDoListComponent createComponent() {
        if (component == null) {
            return DaggerToDoListComponent.builder()
                    .toDoListModule(new ToDoListModule())
                    .build();
        } else {
            throw new IllegalStateException("You can't recreate a component for ToDoListApplication");
        }
    }

    public ToDoListComponent getComponent() {
        return component;
    }
}
