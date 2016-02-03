package com.quoord.tapatalkpro.alarm;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public abstract class WakefulIntentService
        extends IntentService {
    public static final String LOCK_NAME_STATIC = "com.quoord.tapatalkpro";
    public static final String TAG = "WakefulIntentService";
    private static PowerManager.WakeLock lockStatic = null;

    public WakefulIntentService(String paramString) {
        super(paramString);
    }

    public static void acquireStaticLock(Context paramContext) {
        getLock(paramContext).acquire();
    }

    private static PowerManager.WakeLock getLock(Context paramContext) {
        try {
            if (lockStatic == null) {
                lockStatic = ((PowerManager) paramContext.getSystemService("power")).newWakeLock(1, "com.quoord.tapatalkpro");
                lockStatic.setReferenceCounted(true);
            }
            paramContext = lockStatic;
            return paramContext;
        } finally {
        }
    }

    abstract void doWakefulWork(Intent paramIntent);

    protected final void onHandleIntent(Intent paramIntent) {
        doWakefulWork(paramIntent);
        getLock(this).release();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/alarm/WakefulIntentService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */