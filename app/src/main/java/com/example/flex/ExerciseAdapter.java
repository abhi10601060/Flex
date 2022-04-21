/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.flex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ViewHolder> {
    private ArrayList<Exercise> exercises;
    private Context context ;

    public ExerciseAdapter( Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercise_cardview,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.exercise_name.setText(exercises.get(position).getName());
        holder.short_desc.setText(exercises.get(position).getShort_description());
        Glide.with(context)
                .load(exercises.get(position).getImageurl())
                .into(holder.exercise_image);

    }



    @Override
    public int getItemCount() {
        return exercises.size();
    }
    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder {
        private TextView exercise_name , short_desc;
        private ImageView exercise_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            exercise_name = itemView.findViewById(R.id.txt_exercise_name);
            short_desc=itemView.findViewById(R.id.txt_short_description);
            exercise_image =itemView.findViewById(R.id.img_exercise);
        }
    }
}
