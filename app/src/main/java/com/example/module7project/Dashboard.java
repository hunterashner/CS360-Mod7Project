package com.example.module7project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Dashboard {

    public static float userCurrentWeight;
    public static SimpleDateFormat date;
    public static float userGoalWeight;
    public static TextView dashPoundsToGoal;
    public static TextView dateView;

    public Dashboard(){}

    public static void doInitilization(AppCompatActivity activity){
        activity.setContentView(R.layout.activity_dashboard);
        dateView = (TextView) activity.findViewById(R.id.dashDateView);
        Message.message(activity.getApplicationContext(), "dashboard on create called");
        date = new SimpleDateFormat("MM.dd.yyyy");
        dateView.setText(date.format(new Date()));
        userCurrentWeight = 250;
        userGoalWeight = 235;
        dashPoundsToGoal = (TextView) activity.findViewById(R.id.dashPoundsToGoal);
        dashPoundsToGoal.setText(userCurrentWeight - userGoalWeight + " Lbs. From Goal!");
    }
}