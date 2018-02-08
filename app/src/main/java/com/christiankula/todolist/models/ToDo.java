package com.christiankula.todolist.models;

import java.util.Date;

public class ToDo {

    private int id;

    private String description;

    private Date expirationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

        return id == toDo.id && (description != null ? description.equals(toDo.description) : toDo.description == null) && (expirationDate != null ? expirationDate.equals(toDo.expirationDate) : toDo.expirationDate == null);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
        return result;
    }
}
