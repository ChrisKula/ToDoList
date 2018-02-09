package com.christiankula.todolist.edittodo;


import com.christiankula.todolist.models.ToDo;

import java.util.Calendar;
import java.util.Date;

public class EditToDoPresenter implements EditToDoMvp.Presenter {

    private EditToDoMvp.View view;
    private EditToDoMvp.Model model;

    public EditToDoPresenter(EditToDoMvp.Model model) {
        this.model = model;
    }

    @Override
    public void onViewAttached(EditToDoMvp.View view) {
        this.view = view;

        ToDo toDo = this.view.getToDoFromIntent();

        if (toDo == null) {
            this.model.initEditedToDo();

            initToDoViews();

            this.view.setTitleToNewToDo();

        } else {
            this.model.setEditedTodo(toDo);

            setupToDoViews(toDo);

            this.view.setTitleToEditToDo();
        }
    }

    @Override
    public void onViewDetached() {
        this.view = null;
    }

    private void initToDoViews() {
        Calendar dateTime = Calendar.getInstance();

        if (dateTime.get(Calendar.MINUTE) < 30) {
            dateTime.set(Calendar.MINUTE, 30);
        } else {
            dateTime.add(Calendar.HOUR, 1);
            dateTime.set(Calendar.MINUTE, 0);
        }

        setDescription("");
        setDateTimeViews(dateTime.getTime());
    }

    private void setupToDoViews(ToDo toDo) {
        setDescription(toDo.getDescription());
        setDateTimeViews(toDo.getExpirationDate());

        this.model.setEditedTodo(toDo);
    }

    private void setDescription(String description) {
        this.view.setToDoDescription(description);

        this.model.setToDoDescription(description);
    }

    private void setDateTimeViews(Date date) {
        this.view.setExpirationDate(date);
        this.view.setExpirationTime(date);

        this.model.setToDoDate(date);
    }

    @Override
    public void onToDoDateTap() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.model.getToDoDate());

        this.view.showDatePickerDialog(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public void onToDoTimeTap() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.model.getToDoDate());

        this.view.showTimePickerDialog(c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE));
    }

    @Override
    public void onToDoDateSet(int year, int month, int dayOfMonth) {
        Calendar d = Calendar.getInstance();

        d.setTime(this.model.getToDoDate());
        d.set(year, month, dayOfMonth);

        setDateTimeViews(d.getTime());
    }

    @Override
    public void onToDoTimeSet(int hourOfDay, int minute) {
        Calendar d = Calendar.getInstance();

        d.setTime(this.model.getToDoDate());

        d.set(Calendar.HOUR_OF_DAY, hourOfDay);
        d.set(Calendar.MINUTE, minute);

        setDateTimeViews(d.getTime());
    }

    @Override
    public void onToDoDescriptionChanged(String description) {
        this.model.setToDoDescription(description);
    }

    @Override
    public void onSaveToDoMenuItemClick() {
        String toDoDescription = this.model.getToDoDescription();
        Date toDoDate = this.model.getToDoDate();

        if (toDoDescription == null || toDoDescription.isEmpty()) {
            this.view.showDescriptionEmptyErrorToast();
        } else if (toDoDate == null || toDoDate.compareTo(new Date()) < 0) {
            this.view.showToDoSetInPastErrorToast();
        } else {
            this.model.saveToDo();
            this.view.close();
        }
    }
}
