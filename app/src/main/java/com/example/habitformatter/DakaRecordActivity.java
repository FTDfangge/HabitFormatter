package com.example.habitformatter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DakaRecordActivity extends AppCompatActivity {
    private long mExitTime;
    Button btn_record;
    Button btn_choose;
    Button dakaBtn;
    TextView timeText;
    TextView msgText;
    CheckBox checkBox1,checkBox2,checkBox3;
    String isDaka="F";
    String msggfromHabitChoosing,msgFromDaka,msgg;
    public static final String EXTRA_MESSAGE="com.example.myapplication_002.MESSAGE";

    public static final int MSG_ONE = 1;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //通过消息的内容msg.what  分别更新ui
            switch (msg.what) {
                case MSG_ONE:
                    //获取到系统当前时间 long类型
                    long time = System.currentTimeMillis();
                    //将long类型的时间转换成日历格式
                    Date data = new Date(time);
                    // 转换格式，年月日时分秒 星期  的格式
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 EEE");
                    //显示在textview上，通过转换格式
                    timeText.setText(simpleDateFormat.format(data));
                    break;
                default:
                    break;
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daka_record);

        timeText=findViewById(R.id.textView);
        checkBox1=findViewById(R.id.checkBox3);
        checkBox2=findViewById(R.id.checkBox4);
        checkBox3=findViewById(R.id.checkBox5);

        new TimeThread().start();

        Intent intent = getIntent();


        if (!intent.getStringExtra(HabitChoosing.EXTRA_MESSAGE).isEmpty())
            msggfromHabitChoosing=intent.getStringExtra(HabitChoosing.EXTRA_MESSAGE);



            if (isDaka.equals("T")){
                checkBox1.setChecked(true);
                checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (checkBox1.isChecked()){}
                        else checkBox1.setChecked(true);
                    }
                });

            }
            else {


                checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (checkBox1.isChecked()){
                            checkBox1.setChecked(false);
                            new AlertDialog.Builder(DakaRecordActivity.this)
                                    .setIcon(android.R.drawable.ic_dialog_alert)
                                    .setTitle("不能这样打卡哦")
                                    .setMessage("进行打卡请点击下方“进行本次打卡”按钮进行打卡")
                                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int whichButton) {

                                        }

                                    }).create().show();
                        }
                    }
                });


            }


        msgText=findViewById(R.id.textView10);
        if (msggfromHabitChoosing.equals(null)) {
            msgText.setText("您选择的习惯为：" + msgFromDaka);
            msgg = msgFromDaka;
        }
        else {
            msgText.setText("您选择的习惯为：" + msggfromHabitChoosing);
            msgg = msggfromHabitChoosing;
        }

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox2.isChecked()){
                    checkBox2.setChecked(false);
                    new AlertDialog.Builder(DakaRecordActivity.this)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle("不能这样打卡哦")
                            .setMessage("进行打卡请点击下方“进行本次打卡”按钮进行打卡")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {

                                }

                            }).create().show();
                }
            }
        });

        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox3.isChecked()){
                    checkBox3.setChecked(false);
                    new AlertDialog.Builder(DakaRecordActivity.this)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle("不能这样打卡哦")
                            .setMessage("进行打卡请点击下方“进行本次打卡”按钮进行打卡")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {

                                }

                            }).create().show();
                }
            }
        });


        btn_record = findViewById(R.id.btn_record);
        btn_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DakaRecordActivity.this,Record.class);
                startActivity(intent);
            }
        });

        btn_choose = findViewById(R.id.btn_choose);
        btn_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DakaRecordActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("不行啊")
                        .setMessage("你已经选择了习惯了，要坚持下去哦\n\n如果要更改习惯养成方案，请通过邮件联系管理员:18301058@bjtu.edu.com")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                            }

                        }).create().show();
            }
        });

        dakaBtn = findViewById(R.id.button4);
        dakaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isDaka.equals("T")) {
                    Intent intent1 = new Intent(DakaRecordActivity.this, DakaActivity.class);
                    String msg = msgg;
                    intent1.putExtra(EXTRA_MESSAGE, msg);
                    startActivity(intent1);
                }
                else if(isDaka.equals("T")){
                    new AlertDialog.Builder(DakaRecordActivity.this)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle("一天只能打卡一次哦")
                            .setMessage("今天已经打过卡了，明天再来吧")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {

                                }

                            }).create().show();
                }
            }
        });




    }

    public class TimeThread extends Thread {
        //重写run方法
        @Override
        public void run() {
            super.run();
            do {
                try {
                    //每隔一秒 发送一次消息
                    Thread.sleep(1000);
                    Message msg = new Message();
                    //消息内容 为MSG_ONE
                    msg.what = MSG_ONE;
                    //发送
                    handler.sendMessage(msg);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);
        }
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
                System.exit(0);
            }
            return true;
        }
        return true;
    }
}
