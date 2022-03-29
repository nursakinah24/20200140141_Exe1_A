package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btLogin;
    EditText logname, logpassword;
    String name, password;
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btLogin = findViewById(R.id.btLogin);
        logname = findViewById(R.id.logName);
        logpassword = findViewById(R.id.logPassword);
        register = findViewById(R.id.Register);

        btLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                validation();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);

                startActivity(intent);
            }
        });
    }

    public void validation(){
        name = logname.getText().toString();
        password = logpassword.getText().toString();

        String nama = "Kina";
        String pass = "141";

        if (name.isEmpty() && password.isEmpty())
        {
            logname.setError("Email Required!");
            logpassword.setError("Password Required!");
        } else {
            if (name.equals(nama) && password.equals(pass)) {
                Toast t = Toast.makeText(getApplicationContext(),
                        "Login Success." , Toast.LENGTH_LONG);
                t.show();
                Bundle b = new Bundle();
                b.putString("a", name.trim());
                Intent i = new Intent(getApplicationContext(), TaskActivity.class);

                i.putExtras(b);

                startActivity(i);
            } else if (!name.equals(name) && password.equals(pass)) {
                Toast t = Toast.makeText(getApplicationContext(),
                        "Invalid Name", Toast.LENGTH_LONG);
                t.show();
            } else if (name.equals(name) && !password.equals(pass)) {
                Toast t = Toast.makeText(getApplicationContext(),
                        "Invalid Password", Toast.LENGTH_LONG);
                t.show();
            } else {
                Toast t = Toast.makeText(getApplicationContext(),
                        "Invalid Name and Password", Toast.LENGTH_LONG);
                t.show();
            }
        }
    }

}