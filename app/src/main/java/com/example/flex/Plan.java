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

public class Plan implements Parcelable {
    private Exercise exercise;
    private int minutes;
    private boolean isCompleted;
    private String day;

    protected Plan(Parcel in) {
        exercise = in.readParcelable(Exercise.class.getClassLoader());
        minutes = in.readInt();
        isCompleted = in.readByte() != 0;
        day = in.readString();
    }

    public static final Creator<Plan> CREATOR = new Creator<Plan>() {
        @Override
        public Plan createFromParcel(Parcel in) {
            return new Plan(in);
        }

        @Override
        public Plan[] newArray(int size) {
            return new Plan[size];
        }
    };

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Plan(Exercise exercise, int minutes, boolean isCompleted, String day) {
        this.exercise = exercise;
        this.minutes = minutes;
        this.isCompleted = isCompleted;
        this.day = day;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(exercise, i);
        parcel.writeInt(minutes);
        parcel.writeByte((byte) (isCompleted ? 1 : 0));
        parcel.writeString(day);
    }
}
