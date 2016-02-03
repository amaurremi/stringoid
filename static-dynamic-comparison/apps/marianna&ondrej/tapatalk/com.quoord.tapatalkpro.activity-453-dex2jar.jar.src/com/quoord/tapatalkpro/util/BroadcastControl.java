package com.quoord.tapatalkpro.util;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;

public class BroadcastControl {
    public static String FINISH_ACTIVITY = "finish";
    Activity activity;
    Context context;
    MyBroadcastReceiver receiver;

    public BroadcastControl(Context paramContext, Activity paramActivity) {
        this.context = paramContext;
        this.activity = paramActivity;
    }

    public void registBroad(String paramString) {
        this.receiver = new MyBroadcastReceiver();
        paramString = new IntentFilter(paramString);
        this.context.registerReceiver(this.receiver, paramString);
    }

    public void unregistBroad() {
        this.context.unregisterReceiver(this.receiver);
    }

    class MyBroadcastReceiver
            extends BroadcastReceiver {
        MyBroadcastReceiver() {
        }

        public void onReceive(Context paramContext, Intent paramIntent) {
            String str = paramIntent.getAction();
            paramContext = null;
            if (paramIntent.getStringExtra("forumId") != null) {
                paramContext = paramIntent.getStringExtra("forumId");
            }
            if (str.equals(BroadcastControl.FINISH_ACTIVITY)) {
                if ((BroadcastControl.this.activity instanceof SlidingMenuActivity)) {
                    ((SlidingMenuActivity) BroadcastControl.this.activity).closeDrawerLay();
                    ((SlidingMenuActivity) BroadcastControl.this.activity).breadcrumBackStack(paramContext);
                }
            } else {
                return;
            }
            BroadcastControl.this.activity.finish();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/BroadcastControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */