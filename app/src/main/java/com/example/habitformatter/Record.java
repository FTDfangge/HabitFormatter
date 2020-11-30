package com.example.habitformatter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

public class Record extends AppCompatActivity {

    ExpandableListView mExpandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        mExpandableListView = findViewById(R.id.expandablelistview);

        List<String> groupList = new ArrayList<>();
        groupList.add("       第一周期");
        groupList.add("       第二周期");
        groupList.add("       第三周期");

        List<List<String>> childList = new ArrayList<>();
        List<String> childList1 = new ArrayList<>();
        childList1.add("First punch time clock");
        childList1.add("Second punch time clock");
        childList1.add("Third punch time clock");
        List<String> childList2 = new ArrayList<>();
        childList2.add("First punch time clock");
        childList2.add("Second punch time clock");
        childList2.add("Third punch time clock");
        List<String> childList3 = new ArrayList<>();
        childList3.add("First punch time clock");
        childList3.add("Second punch time clock");
        childList3.add("Third punch time clock");

        childList.add(childList1);
        childList.add(childList2);
        childList.add(childList3);

        PunchAdapter punchAdapter = new PunchAdapter(groupList, childList);
        mExpandableListView.setAdapter(punchAdapter);

        mExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {//一级点击监听
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                //如果你处理了并且消费了点击返回true,这是一个基本的防止onTouch事件向下或者向上传递的返回机制
                return false;
            }
        });

        mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {//二级点击监听
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                //如果你处理了并且消费了点击返回true
                return false;
            }
        });
    }
}