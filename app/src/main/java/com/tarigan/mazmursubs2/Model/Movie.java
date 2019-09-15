package com.tarigan.mazmursubs2.Model;


import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class Movie implements Parcelable {
    private int id;
    private String photo;
    private String name;
    private String desc;

    public Movie(JSONObject object){
        try{
            int id = object.getInt("id");
            String photo = "https://image.tmdb.org/t/p/w92"+object.getString("poster_path");
            String name = object.getString("title");
            String desc = object.getString("overview");
            this.id = id;
            this.photo = photo;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.photo);
        dest.writeString(this.name);
        dest.writeString(this.desc);
    }

    protected Movie(Parcel in) {
        this.id = in.readInt();
        this.photo = in.readString();
        this.name = in.readString();
        this.desc = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
