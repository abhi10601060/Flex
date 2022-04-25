/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.flex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.resources.TextAppearance;

import java.util.ArrayList;

public class PlanActivity extends AppCompatActivity {
    private RelativeLayout if_empty;
    private NestedScrollView not_empty;
    private TextView monday_edit,tuesday_edit,wednesday_edit,thursday_edit,friday_edit,saturday_edit,sunday_edit;
    private RecyclerView monday_RV, tuesday_RV,wednesday_RV,thursday_RV,friday_RV,saturday_RV,sunday_RV;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        viewinit();
        setView();

    }
    private void viewinit(){
        monday_edit=findViewById(R.id.txt_monday_edit);
        tuesday_edit=findViewById(R.id.txt_tuesday_edit);
        wednesday_edit=findViewById(R.id.txt_wednesday_edit);
        thursday_edit=findViewById(R.id.txt_thursday_edit);
        friday_edit=findViewById(R.id.txt_friday_edit);
        saturday_edit=findViewById(R.id.txt_saturday_edit);
        sunday_edit=findViewById(R.id.txt_sunday_edit);

        monday_RV=findViewById(R.id.RV_monday);
        tuesday_RV=findViewById(R.id.RV_tuesday);
        wednesday_RV=findViewById(R.id.RV_wednesday);
        thursday_RV=findViewById(R.id.RV_thursday);
        friday_RV=findViewById(R.id.RV_friday);
        saturday_RV=findViewById(R.id.RV_saturday);
        sunday_RV=findViewById(R.id.RV_sunday);

        if_empty=findViewById(R.id.if_empty_RL);
        not_empty=findViewById(R.id.parent_nsv);

        btnAdd = findViewById(R.id.btn_add_plan);

    }
    private void setView(){
        ArrayList<Plan>plans = Utils.getInstance().getPlans();
        if(plans!=null){
            if(plans.size()!=0){
                if_empty.setVisibility(View.GONE);
                not_empty.setVisibility(View.VISIBLE);

                PlanAdapter mondayAdapter = new PlanAdapter(this);
                mondayAdapter.setPlans(getPlanByDay("Monday"));
                monday_RV.setAdapter(mondayAdapter);
                monday_RV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

                PlanAdapter tuesdayAdapter = new PlanAdapter(this);
                tuesdayAdapter.setPlans(getPlanByDay("Tuesday"));
                tuesday_RV.setAdapter(tuesdayAdapter);
                tuesday_RV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

                PlanAdapter wednesdayAdapter = new PlanAdapter(this);
                wednesdayAdapter.setPlans(getPlanByDay("Wednesday"));
                wednesday_RV.setAdapter(wednesdayAdapter);
                wednesday_RV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

                PlanAdapter thursdayAdapter = new PlanAdapter(this);
                thursdayAdapter.setPlans(getPlanByDay("Thursday"));
                thursday_RV.setAdapter(thursdayAdapter);
                thursday_RV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

                PlanAdapter fridayAdapter = new PlanAdapter(this);
                fridayAdapter.setPlans(getPlanByDay("Friday"));
                friday_RV.setAdapter(fridayAdapter);
                friday_RV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

                PlanAdapter saturdayAdapter = new PlanAdapter(this);
                saturdayAdapter.setPlans(getPlanByDay("Saturday"));
                saturday_RV.setAdapter(saturdayAdapter);
                saturday_RV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

                PlanAdapter sundayAdapter = new PlanAdapter(this);
                sundayAdapter.setPlans(getPlanByDay("Sunday"));
                sunday_RV.setAdapter(sundayAdapter);
                sunday_RV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

            }
            else{
                if_empty.setVisibility(View.VISIBLE);
                not_empty.setVisibility(View.GONE);
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(PlanActivity.this,AllExerciseActivity.class);
                        startActivity(intent);
                    }
                });

            }

        }else{
           if_empty.setVisibility(View.VISIBLE);
           not_empty.setVisibility(View.GONE);
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(PlanActivity.this,AllExerciseActivity.class);
                    startActivity(intent);
                }
            });

        }
    }
    private ArrayList<Plan> getPlanByDay(String day){
        ArrayList<Plan> plans = Utils.getInstance().getPlans();
        ArrayList<Plan> ans = new ArrayList<>();

        for(Plan p: plans){
            if(p.getDay().toString().equals(day)){
                ans.add(p);
            }
        }
        return ans;

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}