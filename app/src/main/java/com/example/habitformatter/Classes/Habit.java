package com.example.habitformatter.Classes;

import android.media.Image;

import java.sql.Time;

public class Habit {
    public Time startTime; //开始时间
    public Time endingTime; //结束时间
    public String habitName="未命名习惯"; //习惯名称
    public int habitTag=-1; //标记习惯的tag
    public String request="暂无要求"; //要求
    public String cycle; //打卡周期
    public String testCycle; //测评周期
    public int testTimeInCycle; //测评周期内要求次数
    public Image requiredImage; //打卡凭证
    public int requiredNumberOfCycle=0;

    public Habit()
    {

    }

    public void setHabit(String habitName){
        switch (habitName){
            case "按时作息":{
                habitTag=1; this.habitName="按时作息";this.request="8小时睡眠/天，5次/周，起床后半小时内打卡";startTime=new Time(5,0,0);
                endingTime=new Time(9,0,0);cycle="1d"; testCycle="7d";requiredNumberOfCycle=15; testTimeInCycle=5;
                break;
            }
            case "有氧运动":{
                habitTag=2; this.habitName="有氧运动";this.request="一天一次， 40-60分钟/次，心率120-150/分，4次/周";startTime=new Time(0,0,0);
                endingTime=new Time(23,59,59);cycle="1d"; testCycle="7d";requiredNumberOfCycle=15; testTimeInCycle=4;
                break;
            }
            case "按时早餐":{
                habitTag=3; this.habitName="按时早餐";this.request="5次/周，早上9点前打卡，同时上传食物图片";startTime=new Time(5,0,0);
                endingTime=new Time(9,0,0);cycle="1d"; testCycle="7d";requiredNumberOfCycle=15; testTimeInCycle=5;
                break;
            }
            case "定量喝水":{
                habitTag=4; this.habitName="定量喝水";this.request="任选一种app测算每天喝水量（是没有任何溶质的水）";startTime=new Time(0,0,0);
                endingTime=new Time(23,59,59);cycle="1d"; testCycle="7d";requiredNumberOfCycle=15; testTimeInCycle=5;
                break;
            }
            case "戒饮料":{
                habitTag=5; this.habitName="戒饮料";this.request="第2-4周，1升/周；第5-7周，0.5升/周；第8-10周，0.2升/周；第11-13周，0.1升/周；第14-16周，完全不喝饮料。";startTime=new Time(0,0,0);
                endingTime=new Time(23,0,0);cycle="1d"; testCycle="7d";requiredNumberOfCycle=15; testTimeInCycle=1;
                break;
            }
            case "戒烟":{
                habitTag=6; this.habitName="戒烟";this.request="15周时间缓慢戒烟，每天睡前打卡，统一标准如下：第2-4周，4-5包/；第5-7周，3包/周；第8-10周，2包/周；第11-13周，1包/周；第14-16周，0.5包/周或完全不抽。";startTime=new Time(0,0,0);
                endingTime=new Time(23,0,0);cycle="1d"; testCycle="7d";requiredNumberOfCycle=15; testTimeInCycle=7;
                break;
            }
            case "阅读":{
                habitTag=7; this.habitName="阅读";this.request="所学专业之外的书籍，内容不限，1本/10天，每读完一本打卡一次，读书10本；";startTime=new Time(0,0,0);
                endingTime=new Time(23,0,0);cycle="10d"; testCycle="10d";requiredNumberOfCycle=10; testTimeInCycle=1;
                break;
            }
        }
    }
}
