package com.example.sanafinalproject;

import android.os.Parcel;
import android.os.Parcelable;

public class Custom implements Parcelable{

    private String name;
    private String login;
    private String full_name;



    private CustomObject custom;
    public Custom(String name, String login, String full_name, CustomObject custom ) {
        this.name = name;
        this.login = login;
        this.full_name = full_name;
        this.custom = custom;
    }

    protected Custom(Parcel in) {
        name = in.readString();
        login = in.readString();
        full_name = in.readString();

    }
    public static final Creator<Custom> CREATOR = new Parcelable.Creator<Custom>() {
        @Override
        public Custom createFromParcel(Parcel in) {
            return new Custom(in);
        }
        @Override
        public Custom[] newArray(int size) {
            return new Custom[size];
        }
    };
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public CustomObject getCustom() {
        return custom;
    }

    public void setOwner(CustomObject Custom) {
        this.custom = custom;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(login);
        dest.writeString(full_name);
        //dest.writeString(String.valueOf(custom));//1
    }
}


