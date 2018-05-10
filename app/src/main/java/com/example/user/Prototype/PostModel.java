package com.example.user.Prototype;

public class PostModel {
    private String strSubject;
    private String dateTime;
    private String strName;

    public PostModel(String strSubject, String dateTime, String strName) {
        this.strSubject = strSubject;
        this.dateTime = dateTime;
        this.strName = strName;
    }

    public String getStrSubject() {
        return strSubject;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getStrName() {
        return strName;
    }
}
