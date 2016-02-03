package com.quoord.tapatalkpro.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.preference.PreferenceManager;

public class NotificationAlarmService
        extends WakefulIntentService {
    private final Binder binder = new LocalBinder();
    private String currentUser = null;
    private IAlarmListener mCallback = null;

    public NotificationAlarmService() {
        super("TapatalkService");
    }

    public static void cancelPings(Context paramContext) {
        ((AlarmManager) paramContext.getSystemService("alarm")).cancel(makePendingIntentAlarm(paramContext));
    }

    private static PendingIntent makePendingIntentAlarm(Context paramContext) {
        return PendingIntent.getBroadcast(paramContext, 0, new Intent(paramContext, PingsOnAlarmReceiver.class), 0);
    }

    public static void setupPings(Context paramContext) {
        PreferenceManager.getDefaultSharedPreferences(paramContext);
        if (NotificationSetting.getNotificationFlag(paramContext)) {
            ((AlarmManager) paramContext.getSystemService("alarm")).setRepeating(2, SystemClock.elapsedRealtime() + 7200000, 7200000, makePendingIntentAlarm(paramContext));
        }
    }

    void doWakefulWork(Intent paramIntent) {
        NotificationAdapter.checkNotification(this, true);
    }

    public String getCurrentUser() {
        return this.currentUser;
    }

    public IBinder onBind(Intent paramIntent) {
        return this.binder;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void updatePm(String paramString) {
        this.mCallback.newPmStatus(paramString);
    }

    public class LocalBinder
            extends Binder
            implements IAlarmMonitor {
        public LocalBinder() {
        }

        public void registerAccount(String paramString1, String paramString2, IAlarmListener paramIAlarmListener) {
            NotificationAlarmService.this.currentUser = (paramString1 + paramString2);
            NotificationAlarmService.this.mCallback = paramIAlarmListener;
        }

        public void removeAccount(IAlarmListener paramIAlarmListener) {
            NotificationAlarmService.this.mCallback = null;
            NotificationAlarmService.this.currentUser = null;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/alarm/NotificationAlarmService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */