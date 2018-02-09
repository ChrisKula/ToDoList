package com.christiankula.todolist.injection.components;

import com.christiankula.todolist.edittodo.EditToDoActivity;
import com.christiankula.todolist.todolist.ToDoListActivity;

public interface ApplicationComponent {
    void inject(ToDoListActivity target);

    void inject(EditToDoActivity target);
}
