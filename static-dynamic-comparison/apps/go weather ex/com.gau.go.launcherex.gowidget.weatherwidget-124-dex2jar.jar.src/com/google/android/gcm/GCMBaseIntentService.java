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
  extends IntentService
{
  private static final String EXTRA_TOKEN = "token";
  private static final Object LOCK = GCMBaseIntentService.class;
  private static final int MAX_BACKOFF_MS = (int)TimeUnit.SECONDS.toMillis(3600L);
  public static final String TAG = "GCMBaseIntentService";
  private static final String TOKEN = Long.toBinaryString(sRandom.nextLong());
  private static final String WAKELOCK_KEY = "GCM_LIB";
  private static int sCounter = 0;
  private static final Random sRandom = new Random();
  private static PowerManager.WakeLock sWakeLock;
  private final String[] mSenderIds;
  
  protected GCMBaseIntentService()
  {
    this(getName("DynamicSenderIds"), null);
  }
  
  private GCMBaseIntentService(String paramString, String[] paramArrayOfString)
  {
    super(paramString);
    this.mSenderIds = paramArrayOfString;
  }
  
  protected GCMBaseIntentService(String... paramVarArgs)
  {
    this(getName(paramVarArgs), paramVarArgs);
  }
  
  private static String getName(String paramString)
  {
    paramString = new StringBuilder().append("GCMIntentService-").append(paramString).append("-");
    int i = sCounter + 1;
    sCounter = i;
    paramString = i;
    Log.v("GCMBaseIntentService", "Intent service name: " + paramString);
    return paramString;
  }
  
  private static String getName(String[] paramArrayOfString)
  {
    return getName(GCMRegistrar.getFlatSenderIds(paramArrayOfString));
  }
  
  private void handleRegistration(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("registration_id");
    String str2 = paramIntent.getStringExtra("error");
    paramIntent = paramIntent.getStringExtra("unregistered");
    Log.d("GCMBaseIntentService", "handleRegistration: registrationId = " + str1 + ", error = " + str2 + ", unregistered = " + paramIntent);
    if (str1 != null)
    {
      GCMRegistrar.resetBackoff(paramContext);
      GCMRegistrar.setRegistrationId(paramContext, str1);
      onRegistered(paramContext, str1);
    }
    int i;
    do
    {
      return;
      if (paramIntent != null)
      {
        GCMRegistrar.resetBackoff(paramContext);
        onUnregistered(paramContext, GCMRegistrar.clearRegistrationId(paramContext));
        return;
      }
      Log.d("GCMBaseIntentService", "Registration error: " + str2);
      if (!"SERVICE_NOT_AVAILABLE".equals(str2)) {
        break label287;
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
      ((AlarmManager)paramContext.getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + j, paramIntent);
    } while (i >= MAX_BACKOFF_MS);
    GCMRegistrar.setBackoff(paramContext, i * 2);
    return;
    Log.d("GCMBaseIntentService", "Not retrying failed operation");
    return;
    label287:
    onError(paramContext, str2);
  }
  
  static void runIntentInService(Context paramContext, Intent paramIntent, String paramString)
  {
    synchronized (LOCK)
    {
      if (sWakeLock == null) {
        sWakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, "GCM_LIB");
      }
      Log.v("GCMBaseIntentService", "Acquiring wakelock");
      sWakeLock.acquire();
      paramIntent.setClassName(paramContext, paramString);
      paramContext.startService(paramIntent);
      return;
    }
  }
  
  protected String[] getSenderIds(Context paramContext)
  {
    if (this.mSenderIds == null) {
      throw new IllegalStateException("sender id not set on constructor");
    }
    return this.mSenderIds;
  }
  
  protected void onDeletedMessages(Context paramContext, int paramInt) {}
  
  protected abstract void onError(Context paramContext, String paramString);
  
  public final void onHandleIntent(Intent arg1)
  {
    try
    {
      localContext1 = getApplicationContext();
      str = ???.getAction();
      if (str.equals("com.google.android.c2dm.intent.REGISTRATION"))
      {
        GCMRegistrar.setRetryBroadcastReceiver(localContext1);
        handleRegistration(localContext1, ???);
      }
    }
    finally
    {
      for (;;)
      {
        String str;
        synchronized (LOCK)
        {
          Context localContext1;
          if (sWakeLock != null)
          {
            Log.v("GCMBaseIntentService", "Releasing wakelock");
            sWakeLock.release();
            return;
            if (str.equals("com.google.android.c2dm.intent.RECEIVE"))
            {
              str = ???.getStringExtra("message_type");
              if (str != null) {
                if (str.equals("deleted_messages"))
                {
                  ??? = ???.getStringExtra("total_deleted");
                  if (??? == null) {
                    continue;
                  }
                  try
                  {
                    int i = Integer.parseInt(???);
                    Log.v("GCMBaseIntentService", "Received deleted messages notification: " + i);
                    onDeletedMessages(localContext1, i);
                  }
                  catch (NumberFormatException localNumberFormatException)
                  {
                    Log.e("GCMBaseIntentService", "GCM returned invalid number of deleted messages: " + ???);
                  }
                  continue;
                  localContext2 = finally;
                }
              }
            }
          }
        }
        synchronized (LOCK)
        {
          if (sWakeLock != null)
          {
            Log.v("GCMBaseIntentService", "Releasing wakelock");
            sWakeLock.release();
            throw localContext2;
            Log.e("GCMBaseIntentService", "Received unknown special message: " + str);
            continue;
            onMessage(localContext2, ???);
            continue;
            if (!str.equals("com.google.android.gcm.intent.RETRY")) {
              continue;
            }
            ??? = ???.getStringExtra("token");
            if (!TOKEN.equals(???))
            {
              Log.e("GCMBaseIntentService", "Received invalid token: " + ???);
              for (;;)
              {
                synchronized (LOCK)
                {
                  if (sWakeLock != null)
                  {
                    Log.v("GCMBaseIntentService", "Releasing wakelock");
                    sWakeLock.release();
                    return;
                  }
                }
                Log.e("GCMBaseIntentService", "Wakelock reference is null");
              }
            }
            if (GCMRegistrar.isRegistered(localContext3))
            {
              GCMRegistrar.internalUnregister(localContext3);
              continue;
            }
            GCMRegistrar.internalRegister(localContext3, getSenderIds(localContext3));
            continue;
            Log.e("GCMBaseIntentService", "Wakelock reference is null");
            continue;
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          Log.e("GCMBaseIntentService", "Wakelock reference is null");
        }
      }
    }
  }
  
  protected abstract void onMessage(Context paramContext, Intent paramIntent);
  
  protected boolean onRecoverableError(Context paramContext, String paramString)
  {
    return true;
  }
  
  protected abstract void onRegistered(Context paramContext, String paramString);
  
  protected abstract void onUnregistered(Context paramContext, String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gcm/GCMBaseIntentService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */