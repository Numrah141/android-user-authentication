package com.example.userauthapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

public class LoginActivity extends AppCompatActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);

        EditText e = findViewById(R.id.loginEmail);
        EditText p = findViewById(R.id.loginPassword);
        Button s = findViewById(R.id.signIn);
        TextView f = findViewById(R.id.forgetPassword);

        s.setOnClickListener(v -> {
            if (db.login(e.getText().toString(), p.getText().toString())) {
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Wrong Email or Password", Toast.LENGTH_SHORT).show();
            }
        });

        f.setOnClickListener(v ->
                startActivity(new Intent(this, ForgetActivity.class)));
    }
}
