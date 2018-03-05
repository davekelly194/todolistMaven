package com.todolist;

import java.util.Date;

public class Task {
    private String id;
    private String title;
    private String description;
    private String dueDate;

    public String getId() {
        return id;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDueDate() { return dueDate; }

    public void setDueDate(String dueDate) { this.dueDate = dueDate; }

}
