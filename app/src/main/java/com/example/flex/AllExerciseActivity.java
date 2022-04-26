package com.example.flex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class AllExerciseActivity extends AppCompatActivity {
    private RecyclerView all_exercise_RV ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_exercise);

        all_exercise_RV = findViewById(R.id.all_Exercise_RV);

        ExerciseAdapter adapter = new ExerciseAdapter(this);
        adapter.setExercises(Utils.getInstance().getAllExercises());

        all_exercise_RV.setAdapter(adapter);
        all_exercise_RV.setLayoutManager(new GridLayoutManager(this,2));

    }

}