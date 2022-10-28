package com.example.uiwidgettest.collector;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {

    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        Log.i("ActivityCollector", "finish all activities");
        for(Activity activity: activities) {
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
