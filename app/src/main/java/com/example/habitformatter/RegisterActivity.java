package com.example.habitformatter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText usrname;
    private EditText idnum;
    private EditText psw;
    private EditText cfmpsw;
    private Button register;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usrname=findViewById(R.id.usrname);
        idnum=findViewById(R.id.idnum);
        psw=findViewById(R.id.psw);
        cfmpsw=findViewById(R.id.cfmpsw);
        register=findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"注册成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this,HabitChoosing.class);
                startActivity(intent);
                finish();
            }
        });

        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}