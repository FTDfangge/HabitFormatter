package com.example.habitformatter.Classes;

import java.util.ArrayList;
import java.util.Iterator;

public class User {
    private static User singletonUser = new User();
    private int studentID=00000000;
    private String password="123456";
    private Habit habit;
    private String identity="User";
    private ArrayList<Task> taskArrayList;

    public User()
    {
        this.studentID=00000000;
        this.password="123456";
    }

    public static User getSingletonInstance()
    {
        return singletonUser;
    }

    public User(int studentID, String password)
    {
        this.studentID=studentID;
        this.password=password;
    }

    public void chooseHabit(int tag)
    {

    }

    public ArrayList<Task> getTaskArrayList() {
        return taskArrayList;
    }

    public ArrayList<String> getTaskNameArrayList(){
        ArrayList <String> taskNameArrayList = new ArrayList<>();
        Iterator<Task> taskIterator = taskArrayList.iterator();
        while (taskIterator.hasNext())
        {
            taskNameArrayList.add(taskIterator.next().getTaskName());
        }

        return taskNameArrayList;
    }
}
