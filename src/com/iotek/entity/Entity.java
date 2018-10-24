package com.iotek.entity;

import java.util.List;

public class Entity {
    private int id;
    private String name;
    private List<User> strList;

    public List<User> getStrList() {
        return strList;
    }

    public void setStrList(List<User> strList) {
        this.strList = strList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}