package com.example.habitformatter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.habitformatter.Classes.User;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class TaskMain extends AppCompatActivity {
    private static final long DAY = 1000 * 60 * 60 * 24;
    private Date currentDate=new Date(System.currentTimeMillis());
    private Date semesterStartDate = new Date();


    private TextView timeTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_main);

        timeTextView=findViewById(R.id.timeTextView);
        timeTextView.setText(getSchoolYear()+" school year ,"+getSemester()+"th semester "+getWeekNum()+"th week and day is "+currentDate.getDay());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(TaskMain.this,R.layout.activity_task_main,User.getSingletonInstance().getTaskNameArrayList());
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    private String getSchoolYear()
    {
        String schoolYear=null;

        if (currentDate.getMonth()<=8)
            schoolYear=(currentDate.getYear()-1+1900)+" to "+(currentDate.getYear()+1900);
        else
            schoolYear=(currentDate.getYear()+1900)+" to "+(currentDate.getYear()+1+1900);
        return schoolYear;
    }

    private int getSemester()
    {
        int semester=0;
        if ((currentDate.getMonth()>=8) && (currentDate.getMonth()<=11) || (currentDate.getMonth()==0))
            semester=1;
        else
            semester=2;
        return semester;
    }

    private int getWeekNum()
    {
        int weekNum=0;
        weekNum= (int) getDifferWeek(semesterStartDate,currentDate)+1;
        return weekNum;
    }



    private boolean isCurrentInTimeScope(Date beginDate, Date endDate)
    {
        boolean isIn = false;
        if (currentDate.after(beginDate) && currentDate.before(endDate))
            isIn = true;
        else
            isIn = false;

        return isIn;
    }

    public static long getTimeDistance(Date beginDate, Date endDate) {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(beginDate);
        fromCalendar.set(Calendar.HOUR_OF_DAY, fromCalendar.getMinimum(Calendar.HOUR_OF_DAY));
        fromCalendar.set(Calendar.MINUTE, fromCalendar.getMinimum(Calendar.MINUTE));
        fromCalendar.set(Calendar.SECOND, fromCalendar.getMinimum(Calendar.SECOND));
        fromCalendar.set(Calendar.MILLISECOND, fromCalendar.getMinimum(Calendar.MILLISECOND));

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        toCalendar.set(Calendar.HOUR_OF_DAY, fromCalendar.getMinimum(Calendar.HOUR_OF_DAY));
        toCalendar.set(Calendar.MINUTE, fromCalendar.getMinimum(Calendar.MINUTE));
        toCalendar.set(Calendar.SECOND, fromCalendar.getMinimum(Calendar.SECOND));
        toCalendar.set(Calendar.MILLISECOND, fromCalendar.getMinimum(Calendar.MILLISECOND));

        long dayDistance = (toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / DAY;
        dayDistance = Math.abs(dayDistance);

        return dayDistance;
    }


    public static long getDifferWeek(Date startTime, Date endTime) {
        Date startFirstDayOfWeek = getMonday(startTime); // 获取这天所在的周的第一天
        Date endFirstDayOfWeek = getMonday(endTime);

        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startFirstDayOfWeek);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endFirstDayOfWeek);

        long dayOffset = getTimeDistance(startFirstDayOfWeek, endFirstDayOfWeek);

        long weekOffset = dayOffset / 7;
        return weekOffset;
    }

    public static Date   getMonday(Date date)   {
        Calendar   cal   =   Calendar.getInstance();
        cal.setTime(date);
        int   dayOfWeek   =   cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE,   (dayOfWeek   -   1)   *   (-1));
        return   cal.getTime();
    }

    public static long getDifferMonth(Date fromDate, Date toDate) {
        Calendar fromDateCal = Calendar.getInstance();
        Calendar toDateCal = Calendar.getInstance();
        fromDateCal.setTime(fromDate);
        toDateCal.setTime(toDate);

        int fromYear =  fromDateCal.get(Calendar.YEAR);
        int toYear = toDateCal.get((Calendar.YEAR));
        if (fromYear == toYear) {
            return Math.abs(fromDateCal.get(Calendar.MONTH) - toDateCal.get(Calendar.MONTH));
        } else {
            int fromMonth = 12 - (fromDateCal.get(Calendar.MONTH) + 1);
            int toMonth = toDateCal.get(Calendar.MONTH) + 1;
            return Math.abs(toYear - fromYear - 1) * 12 + fromMonth + toMonth;
        }
    }
}