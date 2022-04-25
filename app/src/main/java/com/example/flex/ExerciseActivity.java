/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.flex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.security.PublicKey;

public class ExerciseActivity extends AppCompatActivity implements PlanDialog.PassPlan {
    private Button btn_add ;
    private ImageView exercise_img;
    private TextView long_desc , exercise_name;

    public  static  final  String EXERCISE_KEY ="Exercise";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        btn_add = findViewById(R.id.btn_add_to_plan);
        exercise_img = findViewById(R.id.exercise_image);
        long_desc= findViewById(R.id.txt_long_description);
        exercise_name = findViewById(R.id.txt_Exercise_name);


        Intent intent = getIntent();
        if(intent!= null){
            Exercise exercise = intent.getParcelableExtra(EXERCISE_KEY);
            if(exercise!= null ){
                exercise_name.setText(exercise.getName());
                long_desc.setText((exercise.getLong_description()));
                Glide.with(this)
                        .load(exercise.getImageurl())
                        .into(exercise_img);
                btn_add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PlanDialog dialog = new PlanDialog();
                        Bundle bundle = new Bundle();
                        bundle.putParcelable(EXERCISE_KEY,exercise);
                        dialog.setArguments(bundle);
                        dialog.show(getSupportFragmentManager(),"plan dialog");

                    }
                });
            }
        }


    }

    @Override
    public void getPlan(Plan plan) {
        if(plan!=null){
            if(Utils.getInstance().addPlan(plan)){
                Toast.makeText(this, plan.getExercise().getName()+" Added to plan", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,PlanActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }

        }
    }
}