package com.example.mykayak_v2;

public class ApiKayak {


    private String attributes;
    private String id;
    private String name;

    public ApiKayak(String name, String attribute, String id) {
        this.name = name;
        this.attributes = attribute;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getAttribute() {
        return attributes;
    }

    public String getId() {
        return id;
    }


}
