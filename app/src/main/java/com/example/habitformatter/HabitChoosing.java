package com.example.habitformatter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.habitformatter.Classes.Habit;
import com.example.habitformatter.Classes.SenderToServer;

import java.io.InputStream;

public class HabitChoosing extends AppCompatActivity {
    private long mExitTime;
    Spinner choosingSpinner;
    Habit habit;
    TextView yaoQiuText,jiezhiriqiText,zhouqiText,pingzhengText,cepingzhouqiText,cepingYaoQiuText,cepingcishuText;
    Button checkInfoBtn,ConfirmBtn;

    public static final String EXTRA_MESSAGE="com.example.myapplication_002.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_choosing);

        yaoQiuText=findViewById(R.id.autoCompleteTextView3);
        yaoQiuText.setText("Not Available");
        jiezhiriqiText=findViewById(R.id.autoCompleteTextView4);
        jiezhiriqiText.setText("Not Available");
        zhouqiText=findViewById(R.id.autoCompleteTextView5);
        zhouqiText.setText("Not Available");
        pingzhengText=findViewById(R.id.autoCompleteTextView6);
        pingzhengText.setText("Not Available");
        cepingzhouqiText=findViewById(R.id.autoCompleteTextView7);
        cepingzhouqiText.setText("Not Available");
        cepingYaoQiuText=findViewById(R.id.autoCompleteTextView8);
        cepingYaoQiuText.setText("Not Available");
        cepingcishuText=findViewById(R.id.autoCompleteTextView9);
        cepingcishuText.setText("Not Available");
        checkInfoBtn=findViewById(R.id.button2);
        ConfirmBtn=findViewById(R.id.button);

        new AlertDialog.Builder(HabitChoosing.this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("用户须知")
                .setMessage("习惯养成项目为多个习惯选择一个进行习惯养成。\n（当前版本暂不支持自定义习惯）" +
                        "\n每次打卡都有具体截止时间和打卡周期，比如早餐截止时间为9:00，打卡周期为1天，用户需在每天9点前进行打卡"
                        +"\n\n关于考核：" +
                        "\n比如测评周期为7d，合格次数为5，则用户需要7点打5次卡才算合格"
                +"\n\n本规则解释权归江红老师所有")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }

                }).create().show();
        habit = new Habit();

        choosingSpinner = (Spinner) findViewById(R.id.spinner);
        choosingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String habitName = parent.getSelectedItem().toString();
                Log.d("---------------------------------",habitName);
                habit.setHabit(habitName);
                fillTextview(habit);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        checkInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(HabitChoosing.this)
                        .setTitle("用户须知")
                        .setMessage("习惯养成项目为多个习惯选择一个进行习惯养成。\n（当前版本暂不支持自定义习惯）" +
                                "\n每次打卡都有具体截止时间和打卡周期，比如早餐截止时间为9:00，打卡周期为1天，用户需在每天9点前进行打卡"
                                +"\n\n关于考核：" +
                                "\n比如测评周期为7d，合格次数为5，则用户需要7点打5次卡才算合格"
                                +"\n\n本规则解释权归江红老师所有")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                            }

                        }).create().show();
            }
        });

        ConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(HabitChoosing.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("警告")
                        .setMessage("请确认选择的习惯养成，确认后不可更改哦")
                        .setNegativeButton("再考虑一下", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Intent intent = new Intent(HabitChoosing.this,DakaRecordActivity.class);
                                String msg = habit.habitName;
                                SenderToServer.sender.sendMsg("habitChoosing "+msg);
                                intent.putExtra(EXTRA_MESSAGE,msg);
                                startActivity(intent);
                                finish();
                            }

                        }).create().show();


            }
        });
    }

    public void fillTextview(Habit habit){
        yaoQiuText.setText(habit.request);
        jiezhiriqiText.setText(habit.endingTime.toString());
        zhouqiText.setText(habit.cycle);
        pingzhengText.setText("暂不支持");
        cepingzhouqiText.setText(habit.testCycle);
        cepingYaoQiuText.setText(String.valueOf(habit.testTimeInCycle));
        cepingcishuText.setText(String.valueOf(habit.requiredNumberOfCycle));

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Object mHelperUtils;
                Toast.makeText(this, "再按一次退出APP", Toast.LENGTH_SHORT).show();
                //System.currentTimeMillis()系统当前时间

                mExitTime = System.currentTimeMillis();
            } else {
                android.os.Process.killProcess(android.os.Process.myPid());
                finish();
            }
            return true;
        }
        return true;
    }
}