package com.example.mine.chatapp;

/**
 * Created by mine on 04/09/17.
 */

public class Division {
    public String divisionCode;
    public String name;
    public String closed;

    public Division(String divisionCode, String name, String closed) {
        this.divisionCode = divisionCode;
        this.name = name;
        this.closed = closed;
    }

    public Division() {
        this.divisionCode = " ";
        this.name = " ";
        this.closed = " ";
    }
}
