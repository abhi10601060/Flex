package com.example.flex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_see_all , btn_see_plan , btn_about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_see_all = findViewById( R.id.btn_see_all);
        btn_see_plan = findViewById(R.id.btn_see_plan);
        btn_about = findViewById(R.id.btn_about);

        btn_see_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllExerciseActivity.class);
                startActivity(intent);
            }
        });





    }
}