package com.example.exercise1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class TaskActivity extends AppCompatActivity {

    TextView textNama;
    EditText txtTask, txtType, txtTime;
    FloatingActionButton btSave;
    String task, type, time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        textNama = findViewById(R.id.txtNama);

        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("a");

        textNama.setText(nama);

        txtTask = findViewById(R.id.edTask);
        txtType = findViewById(R.id.edType);
        txtTime = findViewById(R.id.edTime);
        btSave = findViewById(R.id.fabSave);

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task = txtTask.getText().toString();
                type = txtType.getText().toString();
                time = txtTime.getText().toString();

                if (task.isEmpty() && type.isEmpty() && time.isEmpty()){
                    Toast.makeText(getApplicationContext(), "All data Required", Toast.LENGTH_LONG).show();
                } else if(type.isEmpty() && time.isEmpty()){
                    txtType.setError("Task Type Required");
                    txtTime.setError("Task Time Required");
                } else if (type.isEmpty()) {
                    txtType.setError("Task Type Required");
                } else if (time.isEmpty()) {
                    txtTime.setError("Task Time Required");
                }else if(task.equals(task) && type.equals(type) && time.equals(time)) {
                    Toast.makeText(getApplicationContext(), "Task Added!", Toast.LENGTH_LONG).show();

                    Bundle b = new Bundle();
                    b.putString("b", task.trim());
                    b.putString("c", type.trim());
                    b.putString("d", time.trim());
                    Intent ii = new Intent(getApplicationContext(), ResultActivity.class);
                    ii.putExtras(b);
                    startActivity(ii);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        task = txtTask.getText().toString();
        type = txtType.getText().toString();
        time = txtTime.getText().toString();

        if (item.getItemId() == R.id.logout) {
            Intent iii = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(iii);
        }else if (task.isEmpty() && time.isEmpty() && type.isEmpty()){
            Toast.makeText(getApplicationContext(), "All data is required!", Toast.LENGTH_LONG).show();
        }else if(task.isEmpty() && time.isEmpty()){
            txtType.setError("Task Type Required");
            txtTime.setError("Task Time Required");
        }else if (type.isEmpty()) {
            txtType.setError("Task Type Required");
        } else if (time.isEmpty()) {
            txtTime.setError("Task Time Required");
        }else if(item.getItemId() == R.id.submit && task.equals(task) && type.equals(type) && time.equals(time)) {
            Toast.makeText(getApplicationContext(), "Task Added!", Toast.LENGTH_LONG).show();

            Bundle b = new Bundle();

            b.putString("b", task.trim());
            b.putString("c", type.trim());
            b.putString("d", time.trim());

            Intent ii = new Intent(getApplicationContext(), ResultActivity.class);

            ii.putExtras(b);

            startActivity(ii);
        }
        return super.onOptionsItemSelected(item);
    }
}