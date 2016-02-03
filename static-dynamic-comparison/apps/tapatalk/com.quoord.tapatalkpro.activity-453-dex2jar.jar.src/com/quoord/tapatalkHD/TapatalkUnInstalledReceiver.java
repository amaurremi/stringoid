package com.quoord.tapatalkHD;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class TapatalkUnInstalledReceiver
        extends BroadcastReceiver {
    public void onReceive(Context paramContext, Intent paramIntent) {
        if (paramIntent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
            paramContext = paramIntent.getDataString();
            Log.i("lijing", "安装了 :" + paramContext);
        }
        if ("android.intent.action.PACKAGE_REMOVED".equals(paramIntent.getAction())) {
            paramContext = paramIntent.getDataString();
            Log.i("lijing", "卸载了 :" + paramContext);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkHD/TapatalkUnInstalledReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */