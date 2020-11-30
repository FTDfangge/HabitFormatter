package com.example.habitformatter.Classes;

import java.util.ArrayList;

public class Task {
    private String classification;
    private String taskName;
    private ArrayList<String> stepList;

    public Task(String classification, String taskName)
    {
        this.classification=classification;
        this.taskName=taskName;
    }


    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public ArrayList<String> getStepList()
    {
        return stepList;
    }
}
