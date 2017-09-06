package com.example.mine.chatapp;

import java.util.List;

/**
 * Created by mine on 27/08/17.
 */

public class ChatData {
    private List<Massage> massages;
    private List<Massage> users;
    private String groupName;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Massage> getMassages() {
        return massages;
    }

    public void setMassages(List<Massage> massages) {
        this.massages = massages;
    }

    public List<Massage> getUsers() {
        return users;
    }

    public void setUsers(List<Massage> users) {
        this.users = users;
    }
}
