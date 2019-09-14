package com.tarigan.mazmursubs2.Model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class Movie {
    private int id;
    private String photo;
    private String name;
    private String desc;

    public Movie(JSONObject object){
        try{
            int id = object.getInt("id");
            String photo = object.getString("poster_path");
            String name = object.getString("title");
            String desc = object.getString("overview");
            this.id = id;
            this.photo = "https://image.tmdb.org/t/p/w185"+photo;
            this.name = name;
            this.desc = desc;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Movie() {
    }
}
