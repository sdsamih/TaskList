package com.example.tasklist;

public class Task {
    private String name;
    private int id;

    public Task(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}