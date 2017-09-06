package com.example.mine.chatapp;

/**
 * Created by mine on 04/09/17.
 */

public class JobLevel {
    public String levelCode;
    public String name;

    public JobLevel(String levelCode, String name) {
        this.levelCode = levelCode;
        this.name = name;
    }

    public JobLevel() {
        this.levelCode = " ";
        this.name = " ";
    }
}
