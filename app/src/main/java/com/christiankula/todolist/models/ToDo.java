package com.christiankula.todolist.models;

import java.util.Date;

public class ToDo {

    private String description;

    private Date expirationDate;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ToDo toDo = (ToDo) o;

        return description.equals(toDo.description) && expirationDate.equals(toDo.expirationDate);
    }

    @Override
    public int hashCode() {
        int result = description.hashCode();
        result = 31 * result + expirationDate.hashCode();

        return result;
    }
}
