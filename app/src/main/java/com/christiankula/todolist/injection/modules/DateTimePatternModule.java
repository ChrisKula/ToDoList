package com.christiankula.todolist.injection.modules;


import android.content.Context;

import com.christiankula.todolist.R;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DateTimePatternModule {

    public static final String DATE_PATTERN_NAME = "DATE_PATTERN";
    public static final String TIME_PATTERN_NAME = "TIME_PATTERN";


    @Named(DATE_PATTERN_NAME)
    @Provides
    @Singleton
    String provideDatePattern(Context context) {
        return context.getString(R.string.date_format);
    }

    @Named(TIME_PATTERN_NAME)
    @Provides
    @Singleton
    String provideTimePattern(Context context) {
        return context.getString(R.string.time_format);
    }
}
