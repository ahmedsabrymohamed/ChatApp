package com.example.mine.chatapp;

/**
 * Created by mine on 04/09/17.
 */

public class Position {
    public String name;
    public String positionCode;
    public String closed;
    public String levelCode;

    public Position(String name, String positionCode, String closed, String levelCode) {
        this.name = name;
        this.positionCode = positionCode;
        this.closed = closed;
        this.levelCode = levelCode;
    }

    public Position() {
        this.name = " ";
        this.positionCode = " ";
        this.closed = " ";
        this.levelCode = " ";
    }
}
