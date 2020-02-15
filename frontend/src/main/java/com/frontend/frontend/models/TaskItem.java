package com.frontend.frontend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class TaskItem {

    private long taskID;
    @NotBlank  //means that the text that is submitted should contain something
    private String text;
    private boolean done;
    private long userID;


    public TaskItem() {
    }

    public TaskItem(long taskID, String text, boolean done, long userID) {
        this.taskID = taskID;
        this.text = text;
        this.done = done;
        this.userID=userID;
    }

    // id means it's primary key and generatedvalue that the value should be automatically generated
    @Id
    @GeneratedValue
    public long getTaskID() {
        return taskID;
    }

    public void setTaskID(long taskID) {
        this.taskID = taskID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }
}
