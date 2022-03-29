package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView textTask, textTime, textType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textTask = findViewById(R.id.tvtaskName);
        textTime = findViewById(R.id.tvtypeName);
        textType = findViewById(R.id.tvtimeName);

        Bundle bundle = getIntent().getExtras();

        String task = bundle.getString("b");
        String type = bundle.getString("c");
        String time = bundle.getString("d");

        textTask.setText(task);
        textType.setText(type);
        textTime.setText(time);
    }
}