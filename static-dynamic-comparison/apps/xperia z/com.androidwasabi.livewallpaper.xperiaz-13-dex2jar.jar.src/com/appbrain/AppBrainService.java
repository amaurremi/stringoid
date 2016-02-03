package com.appbrain;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.appbrain.a.aa;
import com.appbrain.a.ae;
import com.appbrain.a.al;
import com.appbrain.a.am;
import com.appbrain.a.d;
import com.appbrain.e.b;
import com.appbrain.e.c;
import com.appbrain.e.h;
import com.appbrain.e.q;
import com.appbrain.e.r;

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
    e.b(this);
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent == null) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = getApplicationContext();
    } while (d.a((Context)localObject1, paramIntent));
    int i;
    Object localObject2;
    if (paramIntent.hasExtra("ip"))
    {
      localObject1 = paramIntent.getStringExtra("ip");
      i = paramIntent.getIntExtra("cp2", 0);
      paramIntent = q.n();
      localObject2 = b.l();
      ((c)localObject2).a((String)localObject1);
      ((c)localObject2).a(i);
      paramIntent.a((c)localObject2);
      try
      {
        ae.a(this, am.a(this).a(paramIntent.d()).h());
        return;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
    }
    if (paramIntent.hasExtra("event"))
    {
      localObject2 = paramIntent.getStringExtra("event");
      al.a(paramIntent.getStringExtra("key"), (String)localObject2);
    }
    if ("com.appbrain.CHECK".equals(paramIntent.getAction()))
    {
      localObject2 = getApplicationContext();
      i = aa.a((Context)localObject2);
      paramIntent = (AlarmManager)((Context)localObject2).getSystemService("alarm");
      if (paramIntent != null)
      {
        Intent localIntent = new Intent((Context)localObject2, AppBrainService.class);
        localIntent.setAction("com.appbrain.CHECK");
        localObject2 = PendingIntent.getService((Context)localObject2, 0, localIntent, 0);
        long l1 = SystemClock.elapsedRealtime();
        long l2 = i;
        paramIntent.cancel((PendingIntent)localObject2);
        if (i != 0) {
          paramIntent.setRepeating(3, l1 + l2 * 1000L, i * 1000L, (PendingIntent)localObject2);
        }
      }
    }
    if (al.b((Context)localObject1))
    {
      a((Context)localObject1, 0L);
      return;
    }
    a((Context)localObject1, 1800000L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/AppBrainService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */