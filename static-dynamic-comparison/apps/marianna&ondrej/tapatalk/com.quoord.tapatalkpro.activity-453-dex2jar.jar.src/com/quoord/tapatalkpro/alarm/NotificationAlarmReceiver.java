package com.quoord.tapatalkpro.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationAlarmReceiver
        extends BroadcastReceiver {
    private static PendingIntent currentAlarmIntent = null;

    public static void startAlarm1(Context paramContext) {
        PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext, 0, new Intent(paramContext, NotificationAlarmReceiver.class), 0);
        ((AlarmManager) paramContext.getSystemService("alarm")).setRepeating(0, System.currentTimeMillis() + 10000L, 60000L, localPendingIntent);
        currentAlarmIntent = localPendingIntent;
    }

    public static void startAlarm2(Context paramContext) {
        PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext, 0, new Intent(paramContext, NotificationAlarmReceiver.class), 0);
        ((AlarmManager) paramContext.getSystemService("alarm")).setRepeating(0, System.currentTimeMillis() + 10000L, 60000L, localPendingIntent);
        currentAlarmIntent = localPendingIntent;
    }

    public static void stopAlarm(Context paramContext) {
        if (currentAlarmIntent != null) {
            ((AlarmManager) paramContext.getSystemService("alarm")).cancel(currentAlarmIntent);
            currentAlarmIntent = null;
        }
    }

    public void onReceive(Context paramContext, Intent paramIntent) {
        NotificationAlarmService.setupPings(paramContext);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/alarm/NotificationAlarmReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */