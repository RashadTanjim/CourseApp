package com.programminghero.courseapp.model;

public class PlayListModelClass {

    String number,title,time;

    public PlayListModelClass(String number, String title, String time) {
        this.number = number;
        this.title = title;
        this.time = time;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}