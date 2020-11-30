package com.example.habitformatter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class resetActivity extends AppCompatActivity {
    private Button login;
    private Button register;
    private Button resend;
    private Button confirm;
    private EditText vcode;
    private EditText npsw;
    private EditText cfmnpsw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        login=findViewById(R.id.login);

        resend=findViewById(R.id.resend);
        confirm=findViewById(R.id.confirm);
        vcode=findViewById(R.id.vcode);

        npsw=findViewById(R.id.npsw);
        cfmnpsw=findViewById(R.id.cfmnpsw);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vcodeString = vcode.getText().toString();
                Log.d("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH",vcodeString);
                if (vcodeString.equals("0324")) {
                    Intent intent = new Intent(resetActivity.this, ResetSucActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    new AlertDialog.Builder(resetActivity.this)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle("验证码有误")
                            .setMessage("请重新确认邮件中的验证码")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    vcode.setText("");
                                }

                            }).create().show();
                }
            }
        });
    }
}