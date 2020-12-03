package com.example.mykayak_v2;

import java.util.jar.Attributes;

public class Kayaks {

    private String mName;
    private int mLogo;

    public Kayaks(String name, int logo) {
        mName = name;
        mLogo = logo;
    }

    public static void setValue(Kayaks kayak) {
    }

    public int getLogo() {
        return mLogo;
    }

    public String getName() {
        return mName;
    }




}
