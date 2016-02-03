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

public abstract class a
        extends IntentService {
    private static PowerManager.WakeLock a;
    private static final Object b = a.class;
    private static int d = 0;
    private static final Random e = new Random();
    private static final int f = (int) TimeUnit.SECONDS.toMillis(3600L);
    private static final String g = Long.toBinaryString(e.nextLong());
    private final String[] c;

    protected a() {
        this(a("DynamicSenderIds"), null);
    }

    private a(String paramString, String[] paramArrayOfString) {
        super(paramString);
        this.c = paramArrayOfString;
    }

    protected a(String... paramVarArgs) {
        this(a(paramVarArgs), paramVarArgs);
    }

    private static String a(String paramString) {
        paramString = new StringBuilder().append("GCMIntentService-").append(paramString).append("-");
        int i = d + 1;
        d = i;
        paramString = i;
        Log.v("GCMBaseIntentService", "Intent service name: " + paramString);
        return paramString;
    }

    private static String a(String[] paramArrayOfString) {
        return a(b.a(paramArrayOfString));
    }

    static void a(Context paramContext, Intent paramIntent, String paramString) {
        synchronized (b) {
            if (a == null) {
                a = ((PowerManager) paramContext.getSystemService("power")).newWakeLock(1, "GCM_LIB");
            }
            Log.v("GCMBaseIntentService", "Acquiring wakelock");
            a.acquire();
            paramIntent.setClassName(paramContext, paramString);
            paramContext.startService(paramIntent);
            return;
        }
    }

    private void b(Context paramContext, Intent paramIntent) {
        String str1 = paramIntent.getStringExtra("registration_id");
        String str2 = paramIntent.getStringExtra("error");
        paramIntent = paramIntent.getStringExtra("unregistered");
        Log.d("GCMBaseIntentService", "handleRegistration: registrationId = " + str1 + ", error = " + str2 + ", unregistered = " + paramIntent);
        if (str1 != null) {
            b.l(paramContext);
            b.a(paramContext, str1);
            a(paramContext, str1);
        }
        int i;
        do {
            return;
            if (paramIntent != null) {
                b.l(paramContext);
                b(paramContext, b.i(paramContext));
                return;
            }
            Log.d("GCMBaseIntentService", "Registration error: " + str2);
            if (!"SERVICE_NOT_AVAILABLE".equals(str2)) {
                break label291;
            }
            if (!d(paramContext, str2)) {
                break;
            }
            i = b.m(paramContext);
            int j = i / 2;
            j = e.nextInt(i) + j;
            Log.d("GCMBaseIntentService", "Scheduling registration retry, backoff = " + j + " (" + i + ")");
            paramIntent = new Intent("com.google.android.gcm.intent.RETRY");
            paramIntent.putExtra("token", g);
            paramIntent = PendingIntent.getBroadcast(paramContext, 0, paramIntent, 0);
            ((AlarmManager) paramContext.getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + j, paramIntent);
        } while (i >= f);
        b.a(paramContext, i * 2);
        return;
        Log.d("GCMBaseIntentService", "Not retrying failed operation");
        return;
        label291:
        c(paramContext, str2);
    }

    protected void a(Context paramContext, int paramInt) {
    }

    protected abstract void a(Context paramContext, Intent paramIntent);

    protected abstract void a(Context paramContext, String paramString);

    protected String[] a(Context paramContext) {
        if (this.c == null) {
            throw new IllegalStateException("sender id not set on constructor");
        }
        return this.c;
    }

    protected abstract void b(Context paramContext, String paramString);

    protected abstract void c(Context paramContext, String paramString);

    protected boolean d(Context paramContext, String paramString) {
        return true;
    }

    public final void onHandleIntent(Intent arg1) {
        try {
            localContext1 = getApplicationContext();
            str =???.getAction();
            if (str.equals("com.google.android.c2dm.intent.REGISTRATION")) {
                b.f(localContext1);
                b(localContext1, ???);
            }
        } finally {
            for (; ; ) {
                String str;
                synchronized (b) {
                    Context localContext1;
                    if (a != null) {
                        Log.v("GCMBaseIntentService", "Releasing wakelock");
                        a.release();
                        return;
                        if (str.equals("com.google.android.c2dm.intent.RECEIVE")) {
                            str =???.getStringExtra("message_type");
                            if (str != null) {
                                if (str.equals("deleted_messages")) {
                                    ???=???.getStringExtra("total_deleted");
                                    if (???==null){
                                        continue;
                                    }
                                    try {
                                        int i = Integer.parseInt( ???);
                                        Log.v("GCMBaseIntentService", "Received deleted messages notification: " + i);
                                        a(localContext1, i);
                                    } catch (NumberFormatException localNumberFormatException) {
                                        Log.e("GCMBaseIntentService", "GCM returned invalid number of deleted messages: " + ? ??)
                                        ;
                                    }
                                    continue;
                                    localContext2 =finally;
                                }
                            }
                        }
                    }
                }
                synchronized (b) {
                    if (a != null) {
                        Log.v("GCMBaseIntentService", "Releasing wakelock");
                        a.release();
                        throw localContext2;
                        Log.e("GCMBaseIntentService", "Received unknown special message: " + str);
                        continue;
                        a(localContext2, ???);
                        continue;
                        if (!str.equals("com.google.android.gcm.intent.RETRY")) {
                            continue;
                        }
                        ???=???.getStringExtra("token");
                        if (!g.equals( ???))
                        {
                            Log.e("GCMBaseIntentService", "Received invalid token: " + ? ??);
                            for (; ; ) {
                                synchronized (b) {
                                    if (a != null) {
                                        Log.v("GCMBaseIntentService", "Releasing wakelock");
                                        a.release();
                                        return;
                                    }
                                }
                                Log.e("GCMBaseIntentService", "Wakelock reference is null");
                            }
                        }
                        if (b.h(localContext3)) {
                            b.e(localContext3);
                            continue;
                        }
                        b.b(localContext3, a(localContext3));
                        continue;
                        Log.e("GCMBaseIntentService", "Wakelock reference is null");
                        continue;
                        localObject1 =finally;
                        throw ((Throwable) localObject1);
                    }
                    Log.e("GCMBaseIntentService", "Wakelock reference is null");
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/google/android/gcm/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */