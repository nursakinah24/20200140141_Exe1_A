package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity {
    EditText edName, edEmail, edPass, edRepass;
    Button btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnReg = findViewById(R.id.btRegister);
        edName = findViewById(R.id.regName);
        edEmail = findViewById(R.id.regEmail);
        edPass = findViewById(R.id.regPass);
        edRepass = findViewById(R.id.regRepass);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edName.getText().toString().isEmpty() && edEmail.getText().toString().isEmpty()){
                    edName.setError("Name Required!");
                    edEmail.setError("Email Required!");
                } else if(edName.getText().toString().isEmpty()){
                    edName.setError("Name Required!");
                } else if(edEmail.getText().toString().isEmpty()){
                    edEmail.setError("Email Required!");
                } else if (!edPass.getText().toString().equals(edRepass.getText().toString())){
                    Snackbar.make(view, "Password and Repassword Must be Same!", Snackbar.LENGTH_LONG).show();
                } else if(edName.getText().toString().equals(edName.getText().toString()) && edEmail.getText().toString().equals(edEmail.getText().toString()) && edPass.getText().toString().equals(edRepass.getText().toString())) {

                    Toast.makeText(getApplicationContext(), "Register Success", Toast.LENGTH_LONG).show();

                    Bundle b = new Bundle();

                    b.putString("a", edName.getText().toString().trim());

                    Intent in = new Intent(getApplicationContext(), TaskActivity.class);

                    in.putExtras(b);

                    startActivity(in);
                }
            }
        });

    }
}