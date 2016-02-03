package com.mobileapptracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

import java.net.URLDecoder;

public class Tracker
        extends BroadcastReceiver {
    public void onReceive(Context paramContext, Intent paramIntent) {
        if (paramIntent != null) {
        }
        try {
            if (paramIntent.getAction().equals("com.android.vending.INSTALL_REFERRER")) {
                paramIntent = paramIntent.getStringExtra("referrer");
                if (paramIntent != null) {
                    paramIntent = URLDecoder.decode(paramIntent, "UTF-8");
                    Log.d("MobileAppTracker", "MAT received referrer " + paramIntent);
                    paramContext.getSharedPreferences("mat_referrer", 0).edit().putString("referrer", paramIntent).commit();
                    paramContext = g.a();
                    if (paramContext != null) {
                        paramContext.d();
                    }
                }
            }
            return;
        } catch (Exception paramContext) {
            paramContext.printStackTrace();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mobileapptracker/Tracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */