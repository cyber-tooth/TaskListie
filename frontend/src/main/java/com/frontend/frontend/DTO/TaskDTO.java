package com.frontend.frontend.DTO;

public class TaskDTO {
    private long taskID;
    private String text;
    private boolean done;
    private long userID;

    public TaskDTO() {
    }

    public TaskDTO(long taskID, String text, boolean done, long userID) {
        this.taskID = taskID;
        this.text = text;
        this.done = done;
        this.userID = userID;
    }

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
