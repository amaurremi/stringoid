package com.quoord.tapatalkpro.bean;

import android.app.Activity;
import android.content.res.Resources;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class Banner {
    public boolean displayBanner = true;
    private boolean success = false;
    public RelativeLayout view;

    public static void addBanner(Activity paramActivity, ArrayList<Object> paramArrayList) {
        if ((paramArrayList.size() > 0) && (paramActivity.getResources().getBoolean(2131558401)) && (paramArrayList.size() % RebrandingConfig.banner_num == 1)) {
            paramActivity = new Banner();
            paramActivity.displayBanner = true;
            paramArrayList.add(paramActivity);
        }
    }

    public static void addThreadBanner(Activity paramActivity, ArrayList<Object> paramArrayList) {
        if ((paramArrayList.size() > 0) && (paramActivity.getResources().getBoolean(2131558401))) {
            paramActivity = new Banner();
            paramActivity.displayBanner = true;
            paramArrayList.add(paramActivity);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/Banner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */