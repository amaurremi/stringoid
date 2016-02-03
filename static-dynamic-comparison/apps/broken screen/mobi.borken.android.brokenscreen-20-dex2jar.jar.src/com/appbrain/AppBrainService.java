package com.appbrain;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.appbrain.a.cg;
import com.appbrain.a.cq;
import com.appbrain.a.r;

public class AppBrainService
  extends IntentService
{
  public AppBrainService()
  {
    super("AppBrain service");
  }
  
  private static void a(Context paramContext, long paramLong)
  {
    PendingIntent localPendingIntent = PendingIntent.getService(paramContext, 0, new Intent(paramContext, AppBrainService.class), 0);
    paramContext = (AlarmManager)paramContext.getSystemService("alarm");
    if (paramContext == null) {}
    do
    {
      return;
      paramContext.cancel(localPendingIntent);
    } while (paramLong == 0L);
    paramContext.setInexactRepeating(1, System.currentTimeMillis() + Math.max(paramLong / 4L, 300000L), paramLong, localPendingIntent);
  }
  
  public void onCreate()
  {
    super.onCreate();
    AppBrain.initApp(this);
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent == null) {}
    Context localContext;
    do
    {
      return;
      localContext = getApplicationContext();
      Object localObject1;
      if (paramIntent.hasExtra("event"))
      {
        localObject1 = paramIntent.getStringExtra("event");
        cq.a(paramIntent.getStringExtra("key"), (String)localObject1);
      }
      if ("com.appbrain.CHECK".equals(paramIntent.getAction()))
      {
        Object localObject2 = getApplicationContext();
        int i = cg.a((Context)localObject2);
        localObject1 = (AlarmManager)((Context)localObject2).getSystemService("alarm");
        if (localObject1 != null)
        {
          Intent localIntent = new Intent((Context)localObject2, AppBrainService.class);
          localIntent.setAction("com.appbrain.CHECK");
          localObject2 = PendingIntent.getService((Context)localObject2, 0, localIntent, 0);
          long l1 = SystemClock.elapsedRealtime();
          long l2 = i;
          ((AlarmManager)localObject1).cancel((PendingIntent)localObject2);
          if (i != 0) {
            ((AlarmManager)localObject1).setRepeating(3, l1 + l2 * 1000L, i * 1000L, (PendingIntent)localObject2);
          }
        }
      }
    } while (r.a(localContext, paramIntent));
    if (cq.b(localContext))
    {
      a(localContext, 0L);
      return;
    }
    a(localContext, 1800000L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/AppBrainService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */