/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.flex;

import static com.example.flex.ExerciseActivity.EXERCISE_KEY;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import javax.xml.namespace.QName;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.ViewHolder> {
    private ArrayList<Plan> plans = new ArrayList<>();
    private Context context;
    private  String type = "";

    public interface RemovePlan{
        void removePlan(Plan plan);
    }

    private RemovePlan removePlan;


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

        if(plans.get(position).isCompleted()==true){
            holder.checked_circle.setVisibility(View.VISIBLE);
            holder.circle.setVisibility(View.GONE);
        }
        else {
            holder.checked_circle.setVisibility(View.GONE);
            holder.circle.setVisibility(View.VISIBLE);
        }
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ExerciseActivity.class);
                intent.putExtra(EXERCISE_KEY,plans.get(holder.getAdapterPosition()).getExercise());
                context.startActivity(intent);
            }
        });

        if(type.equals("edit")){
            holder.circle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context)
                            .setTitle("Finished")
                            .setMessage("Have you finished "+plans.get(holder.getAdapterPosition()).getExercise().getName()+".")
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    for(Plan p : plans){
                                        if(p.equals(plans.get(holder.getAdapterPosition()))){
                                            p.setCompleted(true);
                                            Toast.makeText(context, "You have completed "+plans.get(holder.getAdapterPosition()).getExercise().getName() , Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    notifyDataSetChanged();
                                }
                            });
                    builder.create().show();
                }
            }); holder.checked_circle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context)
                            .setTitle("Reset")
                            .setMessage("Do you want to reset "+plans.get(holder.getAdapterPosition()).getExercise().getName()+".")
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    for(Plan p : plans){
                                        if(p.equals(plans.get(holder.getAdapterPosition()))){
                                            p.setCompleted(false);
                                            Toast.makeText(context, "You have unchecked "+plans.get(holder.getAdapterPosition()).getExercise().getName() , Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    notifyDataSetChanged();
                                }
                            });
                    builder.create().show();
                }
            });

            holder.parent.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context)
                            .setTitle("Remove")
                            .setMessage("Are you sure , you want to remove this exercise from your plan.")
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    try {
                                        removePlan = (RemovePlan) context;
                                        removePlan.removePlan(plans.get(holder.getAdapterPosition()));
                                        notifyDataSetChanged();
                                    }
                                    catch (ClassCastException e){
                                        e.printStackTrace();
                                    }
                                }
                            });
                    builder.create().show();
                    return true;
                }
            });


        }



    }

    @Override
    public int getItemCount() {
        return plans.size();
    }

    public void setType(String type) {
        this.type = type;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name , time;
        private ImageView image , circle, checked_circle;
        private RelativeLayout parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.plan_card_name);
            time=itemView.findViewById(R.id.plan_card_time_txt);
            image=itemView.findViewById(R.id.plan_card_image);
            circle = itemView.findViewById(R.id.img_unchecked_circle);
            checked_circle = itemView.findViewById(R.id.img_checked_circle);
            parent= itemView.findViewById(R.id.parent_RL);


        }
    }
}
