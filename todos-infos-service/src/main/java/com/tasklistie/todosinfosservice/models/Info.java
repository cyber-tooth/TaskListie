package com.tasklistie.todosinfosservice.models;

public class Info {

    private String todoID;
    private String category;
    private boolean favorite;

    public Info(String todoID, String category, boolean favorite) {
        this.todoID = todoID;
        this.category = category;
        this.favorite = favorite;
    }

    public String getTodoID() {
        return todoID;
    }

    public void setTodoID(String todoID) {
        this.todoID = todoID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
