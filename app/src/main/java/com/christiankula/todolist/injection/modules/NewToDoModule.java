package com.christiankula.todolist.injection.modules;


import static com.christiankula.todolist.injection.modules.DateTimePatternModule.DATE_PATTERN_NAME;
import static com.christiankula.todolist.injection.modules.DateTimePatternModule.TIME_PATTERN_NAME;

import com.christiankula.todolist.edittodo.EditToDoModel;
import com.christiankula.todolist.edittodo.EditToDoMvp;
import com.christiankula.todolist.edittodo.EditToDoPresenter;
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
    EditToDoMvp.Model provideModel(ToDoDao toDoDao) {
        return new EditToDoModel(toDoDao);
    }

    @Provides
    EditToDoMvp.Presenter providePresenter(EditToDoMvp.Model model) {
        return new EditToDoPresenter(model);
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
