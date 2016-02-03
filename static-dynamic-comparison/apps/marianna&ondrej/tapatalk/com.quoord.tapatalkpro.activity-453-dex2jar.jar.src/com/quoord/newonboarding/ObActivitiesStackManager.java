package com.quoord.newonboarding;

import android.app.Activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObActivitiesStackManager {
    private static ObActivitiesStackManager uniqueInstance = null;
    private List<Activity> activities = new ArrayList();

    public static ObActivitiesStackManager getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ObActivitiesStackManager();
        }
        return uniqueInstance;
    }

    public void addActivity(Activity paramActivity) {
        this.activities.add(paramActivity);
    }

    public void finishActivities() {
        Iterator localIterator = this.activities.iterator();
        for (; ; ) {
            if (!localIterator.hasNext()) {
                return;
            }
            Activity localActivity = (Activity) localIterator.next();
            try {
                if (!localActivity.isFinishing()) {
                    localActivity.finish();
                }
            } catch (Exception localException) {
            }
        }
    }

    public void finishSearchAndRecommend(ObRecommendListActivity paramObRecommendListActivity) {
        paramObRecommendListActivity.finish();
        paramObRecommendListActivity = this.activities.iterator();
        for (; ; ) {
            if (!paramObRecommendListActivity.hasNext()) {
                return;
            }
            Activity localActivity = (Activity) paramObRecommendListActivity.next();
            try {
                if ((!localActivity.isFinishing()) && ((localActivity instanceof ObSearchActivity))) {
                    localActivity.finish();
                }
            } catch (Exception localException) {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/newonboarding/ObActivitiesStackManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */