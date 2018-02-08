package com.christiankula.todolist.newtodo;

import com.christiankula.todolist.models.ToDo;
import com.christiankula.todolist.mvp.BasePresenter;
import com.christiankula.todolist.mvp.BaseView;

import java.util.Calendar;
import java.util.Date;

public interface NewToDoMvp {

    interface Model {
        /**
         * Returns a copy of the date & time set
         */
        Calendar getToDoDateTime();

        void setToDoDateTime(Calendar now);

        String getToDoDescription();

        void setToDoDescription(String description);

        void saveToDo(ToDo toDo);
    }

    interface View extends BaseView<Presenter> {
        void setExpirationDate(Date date);

        void setExpirationTime(Date time);

        void showDatePickerDialog(int year, int month, int dayOfMonth);

        void showTimePickerDialog(int hour, int minute);

        void close();

        void showDescriptionEmptyErrorToast();
    }

    interface Presenter extends BasePresenter<View> {
        void onToDoDateTap();

        void onToDoTimeTap();

        void onToDoDateSet(int year, int month, int dayOfMonth);

        void onToDoTimeSet(int hourOfDay, int minute);

        void onToDoDescriptionChanged(String description);

        void onSaveToDoMenuItemClick();
    }
}
