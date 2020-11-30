package com.example.habitformatter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResetSucActivity extends AppCompatActivity {
    Button sucBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_suc);
        sucBtn = findViewById(R.id.login);
        sucBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResetSucActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}