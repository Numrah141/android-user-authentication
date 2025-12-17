package com.example.userauthapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

public class SignupActivity extends AppCompatActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.MainActivity);

        db = new DatabaseHelper(this);

        EditText u = findViewById(R.id.username);
        EditText e = findViewById(R.id.email);
        EditText p = findViewById(R.id.password);
        EditText d = findViewById(R.id.dob);
        Button s = findViewById(R.id.signup);

        s.setOnClickListener(v -> {
            if (db.insertUser(
                    u.getText().toString(),
                    e.getText().toString(),
                    p.getText().toString(),
                    d.getText().toString())) {

                Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity.class));
            }
        });
    }
}
