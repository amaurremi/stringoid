package com.quoord.tapatalkpro.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class PingsOnAlarmReceiver
        extends BroadcastReceiver {
    public void onReceive(Context paramContext, Intent paramIntent) {
        WakefulIntentService.acquireStaticLock(paramContext);
        paramContext.startService(new Intent(paramContext, NotificationAlarmService.class));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/alarm/PingsOnAlarmReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */