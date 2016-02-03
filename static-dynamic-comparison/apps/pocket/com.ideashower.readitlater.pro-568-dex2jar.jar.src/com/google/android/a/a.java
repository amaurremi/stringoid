package com.google.android.a;

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
  extends IntentService
{
  private static PowerManager.WakeLock a;
  private static final Object b = a.class;
  private static int d = 0;
  private static final Random e = new Random();
  private static final int f = (int)TimeUnit.SECONDS.toMillis(3600L);
  private static final String g = Long.toBinaryString(e.nextLong());
  private final String[] c;
  
  protected a()
  {
    this(getName("DynamicSenderIds"), null);
  }
  
  private a(String paramString, String[] paramArrayOfString)
  {
    super(paramString);
    this.c = paramArrayOfString;
  }
  
  protected a(String... paramVarArgs)
  {
    this(getName(paramVarArgs), paramVarArgs);
  }
  
  private static String getName(String paramString)
  {
    paramString = new StringBuilder().append("GCMIntentService-").append(paramString).append("-");
    int i = d + 1;
    d = i;
    paramString = i;
    Log.v("GCMBaseIntentService", "Intent service name: " + paramString);
    return paramString;
  }
  
  private static String getName(String[] paramArrayOfString)
  {
    return getName(c.a(paramArrayOfString));
  }
  
  private void handleRegistration(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("registration_id");
    String str2 = paramIntent.getStringExtra("error");
    paramIntent = paramIntent.getStringExtra("unregistered");
    Log.d("GCMBaseIntentService", "handleRegistration: registrationId = " + str1 + ", error = " + str2 + ", unregistered = " + paramIntent);
    if (str1 != null)
    {
      c.i(paramContext);
      c.a(paramContext, str1);
      onRegistered(paramContext, str1);
    }
    int i;
    do
    {
      return;
      if (paramIntent != null)
      {
        c.i(paramContext);
        onUnregistered(paramContext, c.h(paramContext));
        return;
      }
      Log.d("GCMBaseIntentService", "Registration error: " + str2);
      if (!"SERVICE_NOT_AVAILABLE".equals(str2)) {
        break label291;
      }
      if (!onRecoverableError(paramContext, str2)) {
        break;
      }
      i = c.j(paramContext);
      int j = i / 2;
      j = e.nextInt(i) + j;
      Log.d("GCMBaseIntentService", "Scheduling registration retry, backoff = " + j + " (" + i + ")");
      paramIntent = new Intent("com.google.android.gcm.intent.RETRY");
      paramIntent.putExtra("token", g);
      paramIntent = PendingIntent.getBroadcast(paramContext, 0, paramIntent, 0);
      ((AlarmManager)paramContext.getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + j, paramIntent);
    } while (i >= f);
    c.a(paramContext, i * 2);
    return;
    Log.d("GCMBaseIntentService", "Not retrying failed operation");
    return;
    label291:
    onError(paramContext, str2);
  }
  
  static void runIntentInService(Context paramContext, Intent paramIntent, String paramString)
  {
    synchronized (b)
    {
      if (a == null) {
        a = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, "GCM_LIB");
      }
      Log.v("GCMBaseIntentService", "Acquiring wakelock");
      a.acquire();
      paramIntent.setClassName(paramContext, paramString);
      paramContext.startService(paramIntent);
      return;
    }
  }
  
  protected String[] getSenderIds(Context paramContext)
  {
    if (this.c == null) {
      throw new IllegalStateException("sender id not set on constructor");
    }
    return this.c;
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
        c.e(localContext1);
        handleRegistration(localContext1, ???);
      }
    }
    finally
    {
      for (;;)
      {
        String str;
        synchronized (b)
        {
          Context localContext1;
          if (a != null)
          {
            Log.v("GCMBaseIntentService", "Releasing wakelock");
            a.release();
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
        synchronized (b)
        {
          if (a != null)
          {
            Log.v("GCMBaseIntentService", "Releasing wakelock");
            a.release();
            throw localContext2;
            Log.e("GCMBaseIntentService", "Received unknown special message: " + str);
            continue;
            onMessage(localContext2, ???);
            continue;
            if (!str.equals("com.google.android.gcm.intent.RETRY")) {
              continue;
            }
            ??? = ???.getStringExtra("token");
            if (!g.equals(???))
            {
              Log.e("GCMBaseIntentService", "Received invalid token: " + ???);
              for (;;)
              {
                synchronized (b)
                {
                  if (a != null)
                  {
                    Log.v("GCMBaseIntentService", "Releasing wakelock");
                    a.release();
                    return;
                  }
                }
                Log.e("GCMBaseIntentService", "Wakelock reference is null");
              }
            }
            if (c.g(localContext3))
            {
              c.d(localContext3);
              continue;
            }
            c.b(localContext3, getSenderIds(localContext3));
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */