package com.christiankula.todolist.edittodo;

import com.christiankula.todolist.models.ToDo;
import com.christiankula.todolist.mvp.BasePresenter;
import com.christiankula.todolist.mvp.BaseView;

import java.util.Date;

public interface EditToDoMvp {

    interface Model {
        void initEditedToDo();

        void setEditedTodo(ToDo toDo);

        String getToDoDescription();

        void setToDoDescription(String description);

        Date getToDoDate();

        void setToDoDate(Date expirationDate);

        void saveToDo();
    }

    interface View extends BaseView<Presenter> {
        void setToDoDescription(String description);

        void setExpirationDate(Date date);

        void setExpirationTime(Date time);

        void showDatePickerDialog(int year, int month, int dayOfMonth);

        void showTimePickerDialog(int hour, int minute);

        void close();

        void showDescriptionEmptyErrorToast();

        void showToDoSetInPastErrorToast();

        void setTitleToEditToDo();

        void setTitleToNewToDo();

        ToDo getToDoFromIntent();
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
