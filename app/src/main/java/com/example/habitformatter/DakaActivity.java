package com.example.habitformatter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.habitformatter.Classes.Habit;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DakaActivity extends AppCompatActivity {
    TextView titleText;
    String habitName;
    TextView habitNameText,requestText,timeText,needEvidenceText;
    Button confirmBtn;
    public static final String EXTRA_MESSAGE1="com.example.myapplication_008.MESSAGE";
    public static final String EXTRA_MESSAGE2="com.example.myapplication_009.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daka);
        final Intent intent = getIntent();
        habitName = intent.getStringExtra(DakaRecordActivity.EXTRA_MESSAGE);
        Habit habit = new Habit();
        habit.setHabit(habitName);

        habitNameText=findViewById(R.id.textView15);
        requestText = findViewById(R.id.textView16);
        timeText = findViewById(R.id.textView17);
        needEvidenceText = findViewById(R.id.textView18);

        habitNameText.setText("正在养成的习惯是： "+habit.habitName);
        requestText.setText("要求："+habit.request);
        timeText.setText("请在打卡当天以下时间段内打卡，否则打卡无效 ："+habit.startTime.toString() + " → "+habit.endingTime.toString());
        needEvidenceText.setText("不需要凭证");

        titleText=findViewById(R.id.textView12);
        long time = System.currentTimeMillis();
        //将long类型的时间转换成日历格式
        Date data = new Date(time);
        // 转换格式，年月日时分秒 星期  的格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 EEE");
        //显示在textview上，通过转换格式
        titleText.append(" \n\n本次打卡时间为：\n"+simpleDateFormat.format(data));

        confirmBtn = findViewById(R.id.button5);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DakaActivity.this,DakaActivity2.class);
                intent1.putExtra(EXTRA_MESSAGE1,"T");
                intent1.putExtra(EXTRA_MESSAGE2,habitName);
                startActivity(intent1);
                finish();
            }
        });
    }
}