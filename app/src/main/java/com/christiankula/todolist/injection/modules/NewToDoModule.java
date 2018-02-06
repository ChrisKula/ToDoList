package com.christiankula.todolist.injection.modules;


import com.christiankula.todolist.newtodo.NewToDoModel;
import com.christiankula.todolist.newtodo.NewToDoMvp;
import com.christiankula.todolist.newtodo.NewToDoPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NewToDoModule {

    @Singleton
    @Provides
    NewToDoMvp.Model provideModel() {
        return new NewToDoModel();
    }

    @Singleton
    @Provides
    NewToDoMvp.Presenter providePresenter(NewToDoMvp.Model model) {
        return new NewToDoPresenter(model);
    }
}
