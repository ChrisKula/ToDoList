package com.christiankula.todolist.newtodo;


import com.christiankula.todolist.models.ToDo;

import java.util.Calendar;

public class NewToDoPresenter implements NewToDoMvp.Presenter {

    private NewToDoMvp.View view;
    private NewToDoMvp.Model model;

    public NewToDoPresenter(NewToDoMvp.Model model) {
        this.model = model;
    }

    @Override
    public void onViewAttached(NewToDoMvp.View view) {
        this.view = view;

        setupDateTimeViews();
    }

    private void setupDateTimeViews() {
        Calendar dateTime = Calendar.getInstance();

        if (dateTime.get(Calendar.MINUTE) < 30) {
            dateTime.set(Calendar.MINUTE, 30);
        } else {
            dateTime.add(Calendar.HOUR, 1);
            dateTime.set(Calendar.MINUTE, 0);
        }

        setDateTimeViews(dateTime);
    }

    private void setDateTimeViews(Calendar date) {
        this.view.setExpirationDate(date.getTime());
        this.view.setExpirationTime(date.getTime());

        this.model.setToDoDateTime(date);
    }

    @Override
    public void onViewDetached() {
        this.view = null;
    }

    @Override
    public void onToDoDateTap() {
        Calendar c = this.model.getToDoDateTime();

        this.view.showDatePickerDialog(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public void onToDoTimeTap() {
        Calendar c = this.model.getToDoDateTime();

        this.view.showTimePickerDialog(c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE));
    }

    @Override
    public void onToDoDateSet(int year, int month, int dayOfMonth) {
        Calendar d = this.model.getToDoDateTime();

        d.set(year, month, dayOfMonth);

        setDateTimeViews(d);
    }

    @Override
    public void onToDoTimeSet(int hourOfDay, int minute) {
        Calendar d = this.model.getToDoDateTime();

        d.set(Calendar.HOUR_OF_DAY, hourOfDay);
        d.set(Calendar.MINUTE, minute);

        setDateTimeViews(d);
    }

    @Override
    public void onToDoDescriptionChanged(String description) {
        this.model.setToDoDescription(description);
    }

    @Override
    public void onSaveToDoMenuItemClick() {
        String toDoDescription = this.model.getToDoDescription();

        if (toDoDescription.isEmpty()) {
            this.view.showDescriptionEmptyErrorToast();
        } else {
            ToDo toDo = new ToDo();

            toDo.setDescription(toDoDescription);
            toDo.setExpirationDate(this.model.getToDoDateTime().getTime());

            this.model.saveToDo(toDo);
            this.view.close();
        }
    }
}
