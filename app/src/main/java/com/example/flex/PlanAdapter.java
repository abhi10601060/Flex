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

import javax.xml.namespace.QName;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.ViewHolder> {
    ArrayList<Plan> plans = new ArrayList<>();
    private Context context;

    public PlanAdapter(Context context) {
        this.context = context;
    }

    public void setPlans(ArrayList<Plan> plans) {
        this.plans = plans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plan_cardview,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(plans.get(position).getExercise().getName());
        holder.time.setText("Duration : "+plans.get(position).getMinutes() + " Minutes");

        Glide.with(context)
                .load(plans.get(position).getExercise().getImageurl())
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return plans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name , time;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.plan_card_name);
            time=itemView.findViewById(R.id.plan_card_time_txt);
            image=itemView.findViewById(R.id.plan_card_image);

        }
    }
}
