package com.example.habitformatter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.habitformatter.Classes.SenderToServer;

public class MainActivity extends AppCompatActivity {
    private Button login; //login124
    private Button fgtpsw;
    private Button registerBtn;
    private EditText usrname;
    private EditText psw;

    //test
    //2020/11/30/ljx
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usrname = findViewById(R.id.usrname);
        psw = findViewById(R.id.psw);

        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SenderToServer.sender.sendMsg("login "+usrname.getText().toString()+psw.getText().toString());
                Log.e("---SENDING---",usrname.getText().toString()+psw.getText().toString());

                Intent inten = new Intent(MainActivity.this,HabitChoosing.class);
                startActivity(inten);

            }
        });
        fgtpsw=findViewById(R.id.fgtpsw);
        fgtpsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,resetActivity.class);
                startActivity(intent);

            }
        });

        registerBtn=findViewById(R.id.button3);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);

            }
        });
    }
}