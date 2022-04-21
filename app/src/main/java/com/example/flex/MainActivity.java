package com.example.flex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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



    }
}