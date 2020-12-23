package com.example.sanafinalproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class CustomObject {
    @SerializedName("login")
    @Expose
    private String login;

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
