package com.google.android.gcm;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.util.Log;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class GCMBaseIntentService
        extends IntentService {
    private static final String EXTRA_TOKEN = "token";
    private static final Object LOCK = GCMBaseIntentService.class;
    private static final int MAX_BACKOFF_MS = (int) TimeUnit.SECONDS.toMillis(3600L);
    public static final String TAG = "GCMBaseIntentService";
    private static final String TOKEN = Long.toBinaryString(sRandom.nextLong());
    private static final String WAKELOCK_KEY = "GCM_LIB";
    private static int sCounter = 0;
    private static final Random sRandom = new Random();
    private static PowerManager.WakeLock sWakeLock;
    private final String mSenderId;

    protected GCMBaseIntentService(String paramString) {
        super(i);
        this.mSenderId = paramString;
    }

    private void handleRegistration(Context paramContext, Intent paramIntent) {
        String str1 = paramIntent.getStringExtra("registration_id");
        String str2 = paramIntent.getStringExtra("error");
        paramIntent = paramIntent.getStringExtra("unregistered");
        Log.d("GCMBaseIntentService", "handleRegistration: registrationId = " + str1 + ", error = " + str2 + ", unregistered = " + paramIntent);
        if (str1 != null) {
            GCMRegistrar.resetBackoff(paramContext);
            GCMRegistrar.setRegistrationId(paramContext, str1);
            onRegistered(paramContext, str1);
        }
        int i;
        do {
            return;
            if (paramIntent != null) {
                GCMRegistrar.resetBackoff(paramContext);
                onUnregistered(paramContext, GCMRegistrar.clearRegistrationId(paramContext));
                return;
            }
            Log.d("GCMBaseIntentService", "Registration error: " + str2);
            if (!"SERVICE_NOT_AVAILABLE".equals(str2)) {
                break label278;
            }
            if (!onRecoverableError(paramContext, str2)) {
                break;
            }
            i = GCMRegistrar.getBackoff(paramContext);
            int j = i / 2 + sRandom.nextInt(i);
            Log.d("GCMBaseIntentService", "Scheduling registration retry, backoff = " + j + " (" + i + ")");
            paramIntent = new Intent("com.google.android.gcm.intent.RETRY");
            paramIntent.putExtra("token", TOKEN);
            paramIntent = PendingIntent.getBroadcast(paramContext, 0, paramIntent, 0);
            ((AlarmManager) paramContext.getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + j, paramIntent);
        } while (i >= MAX_BACKOFF_MS);
        GCMRegistrar.setBackoff(paramContext, i * 2);
        return;
        Log.d("GCMBaseIntentService", "Not retrying failed operation");
        return;
        label278:
        onError(paramContext, str2);
    }

    static void runIntentInService(Context paramContext, Intent paramIntent, String paramString) {
        synchronized (LOCK) {
            if (sWakeLock == null) {
                sWakeLock = ((PowerManager) paramContext.getSystemService("power")).newWakeLock(1, "GCM_LIB");
            }
            sWakeLock.acquire();
            paramIntent.setClassName(paramContext, paramString);
            paramContext.startService(paramIntent);
            return;
        }
    }

    protected void onDeletedMessages(Context paramContext, int paramInt) {
    }

    protected abstract void onError(Context paramContext, String paramString);

    public final void onHandleIntent(Intent arg1) {
        try {
            localContext1 = getApplicationContext();
            str =???.getAction();
            if (str.equals("com.google.android.c2dm.intent.REGISTRATION")) {
                handleRegistration(localContext1, ???);
            }
        } finally {
            synchronized (LOCK) {
                for (; ; ) {
                    Context localContext1;
                    String str;
                    if (sWakeLock != null) {
                        sWakeLock.release();
                    }
                    return;
                    if (str.equals("com.google.android.c2dm.intent.RECEIVE")) {
                        str =???.getStringExtra("message_type");
                        if (str != null) {
                            if (!str.equals("deleted_messages")) {
                                continue;
                            }
                            ???=???.getStringExtra("total_deleted");
                            if (???==null){
                                continue;
                            }
                            try {
                                onDeletedMessages(localContext1, Integer.parseInt( ? ??));
                            } catch (NumberFormatException???){
                            }
                            continue;
                        }
                        onMessage(localContext1, ???);
                        continue;
                        localObject1 =finally;
                    }
                    synchronized (LOCK) {
                        if (sWakeLock != null) {
                            sWakeLock.release();
                        }
                        throw ((Throwable) localObject1);
                        if (!str.equals("com.google.android.gcm.intent.RETRY")) {
                            continue;
                        }
                        ???=???.getStringExtra("token");
                        boolean bool = TOKEN.equals( ???);
                        if (!bool) {
                            synchronized (LOCK) {
                                if (sWakeLock != null) {
                                    sWakeLock.release();
                                }
                                return;
                            }
                        }
                        if (GCMRegistrar.isRegistered(localContext2)) {
                            GCMRegistrar.internalUnregister(localContext2);
                            continue;
                        }
                        GCMRegistrar.internalRegister(localContext2, new String[]{this.mSenderId});
                    }
                }
            }
        }
    }

    protected abstract void onMessage(Context paramContext, Intent paramIntent);

    protected boolean onRecoverableError(Context paramContext, String paramString) {
        return true;
    }

    protected abstract void onRegistered(Context paramContext, String paramString);

    protected abstract void onUnregistered(Context paramContext, String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gcm/GCMBaseIntentService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */