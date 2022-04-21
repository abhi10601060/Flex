package com.example.flex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class AllExerciseActivity extends AppCompatActivity {
    private RecyclerView all_exercise_RV ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_exercise);

        all_exercise_RV = findViewById(R.id.all_Exercise_RV);

    }
}