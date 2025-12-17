package com.example.userauthapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class ForgetActivity extends AppCompatActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_forget);

        db = new DatabaseHelper(this);

        EditText e = findViewById(R.id.email);
        EditText p = findViewById(R.id.newPassword);
        Button u = findViewById(R.id.update);
        Button d = findViewById(R.id.delete);

        u.setOnClickListener(v ->
                Toast.makeText(this,
                        db.updatePassword(e.getText().toString(), p.getText().toString())
                                ? "Password Updated" : "Error",
                        Toast.LENGTH_SHORT).show());

        d.setOnClickListener(v ->
                Toast.makeText(this,
                        db.deleteUser(e.getText().toString())
                                ? "Account Deleted" : "Error",
                        Toast.LENGTH_SHORT).show());
    }
}
