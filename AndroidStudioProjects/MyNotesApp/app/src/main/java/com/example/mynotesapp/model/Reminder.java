package com.example.mynotesapp.model;

public class Reminder {

    private String remDescriptiojn;

    private String rTime;

    public Reminder() {
    }

    public Reminder(String remDescriptiojn, String rTime) {
        this.remDescriptiojn = remDescriptiojn;
        this.rTime = rTime;
    }

    public String getRemDescriptiojn() {
        return remDescriptiojn;
    }

    public void setRemDescriptiojn(String remDescriptiojn) {
        this.remDescriptiojn = remDescriptiojn;
    }

    public String getrTime() {
        return rTime;
    }

    public void setrTime(String rTime) {
        this.rTime = rTime;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "remDescriptiojn='" + remDescriptiojn + '\'' +
                ", rTime='" + rTime + '\'' +
                '}';
    }
}
