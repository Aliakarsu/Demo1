package com.example.demo.model;


public class Model {


    private long id;

    private String name;

    public Model(String name) {
        this.name = name;
    }

    public Model() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
