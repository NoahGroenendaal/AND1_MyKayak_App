package com.example.mykayak_v2;

public class KayakResponse {
    private String id;
    private String name;
    private Attributes attributes;

    public ApiKayak getKayak(){
        return new ApiKayak(id, name, attributes.length);
    }

    private class Attributes {
        private String length;
    }

}
