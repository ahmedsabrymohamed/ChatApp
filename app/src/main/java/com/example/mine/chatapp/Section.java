package com.example.mine.chatapp;

/**
 * Created by mine on 04/09/17.
 */

public class Section {
    public String name;
    public String departmentCode;
    public String sectionCode;
    public String manager;
    public String closed;

    public Section(String name, String departmentCode, String sectionCode, String manager, String closed) {
        this.name = name;
        this.departmentCode = departmentCode;
        this.sectionCode = sectionCode;
        this.manager = manager;
        this.closed = closed;
    }

    public Section() {
        this.name = " ";
        this.departmentCode = " ";
        this.sectionCode = " ";
        this.manager = " ";
        this.closed = " ";
    }

}
