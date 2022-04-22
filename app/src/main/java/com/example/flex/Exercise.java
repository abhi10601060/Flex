/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.flex;

import android.os.Parcel;
import android.os.Parcelable;

public class Exercise implements Parcelable {
    private int id;
    private String name;
    private String imageurl;
    private String short_description;
    private String long_description;

    public Exercise(int id, String name, String imageurl, String short_description, String long_description) {
        this.id = id;
        this.name = name;
        this.imageurl = imageurl;
        this.short_description = short_description;
        this.long_description = long_description;
    }

    protected Exercise(Parcel in) {
        id = in.readInt();
        name = in.readString();
        imageurl = in.readString();
        short_description = in.readString();
        long_description = in.readString();
    }

    public static final Creator<Exercise> CREATOR = new Creator<Exercise>() {
        @Override
        public Exercise createFromParcel(Parcel in) {
            return new Exercise(in);
        }

        @Override
        public Exercise[] newArray(int size) {
            return new Exercise[size];
        }
    };

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

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", short_description='" + short_description + '\'' +
                ", long_description='" + long_description + '\'' +
                '}';
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getLong_description() {
        return long_description;
    }

    public void setLong_description(String long_description) {
        this.long_description = long_description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(imageurl);
        parcel.writeString(short_description);
        parcel.writeString(long_description);
    }
}
