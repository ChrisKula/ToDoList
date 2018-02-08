package com.christiankula.todolist.injection.modules;


import static com.christiankula.todolist.injection.modules.DateTimePatternModule.DATE_PATTERN_NAME;
import static com.christiankula.todolist.injection.modules.DateTimePatternModule.TIME_PATTERN_NAME;

import com.christiankula.todolist.newtodo.NewToDoModel;
import com.christiankula.todolist.newtodo.NewToDoMvp;
import com.christiankula.todolist.newtodo.NewToDoPresenter;
import com.christiankula.todolist.persistence.ToDoDao;

import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NewToDoModule {

    public static final String TIME_DATE_FORMAT = "TIME_DATE_FORMAT";
    public static final String SIMPLE_DATE_FORMAT = "SIMPLE_DATE_FORMAT";

    @Provides
    NewToDoMvp.Model provideModel(ToDoDao toDoDao) {
        return new NewToDoModel(toDoDao);
    }

    @Provides
    NewToDoMvp.Presenter providePresenter(NewToDoMvp.Model model) {
        return new NewToDoPresenter(model);
    }


    @Named(SIMPLE_DATE_FORMAT)
    @Singleton
    @Provides
    SimpleDateFormat provideSimpleDateFormat(@Named(DATE_PATTERN_NAME) String datePattern) {
        return new SimpleDateFormat(datePattern, Locale.getDefault());
    }

    @Named(TIME_DATE_FORMAT)
    @Singleton
    @Provides
    SimpleDateFormat provideSimpleTimeFormat(@Named(TIME_PATTERN_NAME) String timePattern) {
        return new SimpleDateFormat(timePattern, Locale.getDefault());
    }
}
