/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.flex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity implements PlanAdapter.RemovePlan {
    private RecyclerView edit_RV;
    private Button btn_add;
    private TextView day ,if_empty;

    private PlanAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        edit_RV=findViewById(R.id.edit_RV);
        btn_add=findViewById(R.id.edit_btn_add_plan);
        day=findViewById(R.id.edit_txt_day);
        if_empty=findViewById(R.id.edit_if_empty);

        Intent intent =getIntent();
        if(intent!=null){
            String Day = intent.getStringExtra("day");
            if(Day!=null){
                day.setText(Day);
                ArrayList<Plan> plans = getPlanByDay(Day);
                if(plans.size()!=0){
                    if_empty.setVisibility(View.GONE);
                    edit_RV.setVisibility(View.VISIBLE);

                    adapter=new PlanAdapter(this);
                    adapter.setPlans(plans);
                    adapter.setType("edit");
                    edit_RV.setAdapter(adapter);
                    edit_RV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
                }
                else {
                    if_empty.setVisibility(View.VISIBLE);
                    if_empty.setText("There's no plan for "+ Day);
                    edit_RV.setVisibility(View.GONE);
                }

            }
        }
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(EditActivity.this,AllExerciseActivity.class);
//                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent1);
            }
        });
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
    public void removePlan(Plan plan) {
        if(Utils.getInstance().removePlan(plan)){
            Toast.makeText(this, "Exercise removed successfully", Toast.LENGTH_SHORT).show();
            adapter.setPlans(getPlanByDay(plan.getDay()));

        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, PlanActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}