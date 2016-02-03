package com.ideashower.readitlater.service;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.x;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.a.h;
import com.ideashower.readitlater.a.m;
import com.ideashower.readitlater.a.v;
import com.ideashower.readitlater.activity.AddActivity;
import com.ideashower.readitlater.activity.GsfActivity;
import com.ideashower.readitlater.activity.GsfDemoCompleteActivity;
import com.ideashower.readitlater.activity.PocketActivity;
import com.ideashower.readitlater.activity.j;
import com.ideashower.readitlater.activity.u;
import com.ideashower.readitlater.h.a;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.h.l;
import com.pocket.gsf.GSFConfiguation;
import com.pocket.widget.f;

public class PocketDemoService
  extends Service
  implements h, j
{
  private static boolean b = false;
  protected Handler a = new Handler();
  private Notification c;
  private int d;
  private GSFConfiguation e;
  private int f;
  private f g;
  private String h;
  
  private void a(int paramInt)
  {
    i.b().a(a.bC, paramInt).a();
  }
  
  public static void a(Context paramContext, GSFConfiguation paramGSFConfiguation, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, PocketDemoService.class);
    localIntent.setAction("com.pocket.service.PocketDemoService.action.startDemo");
    localIntent.putExtra("extra_gsf_app", paramGSFConfiguation);
    localIntent.putExtra("extra_app_name", paramString);
    localIntent.putExtra("extra_start_source", paramInt);
    paramContext.startService(localIntent);
  }
  
  private void a(final GSFConfiguation paramGSFConfiguation, String paramString, int paramInt)
  {
    this.f = paramInt;
    this.e = paramGSFConfiguation;
    this.h = paramString;
    this.d = getResources().getConfiguration().orientation;
    this.e.i();
    this.e.b(this.d);
    a(0);
    g.a(this);
    AddActivity.a(this);
    v.b(paramGSFConfiguation.f(), paramInt);
    this.g = new f(this, paramGSFConfiguation, this.h);
    this.g.b();
    GsfActivity.a(new u()
    {
      public void a()
      {
        if (PocketDemoService.a(PocketDemoService.this) == null) {
          return;
        }
        PocketDemoService.a(PocketDemoService.this).a();
      }
    });
    e();
    b = true;
    g.o().post(new Runnable()
    {
      public void run()
      {
        try
        {
          Intent localIntent = paramGSFConfiguation.a(PocketDemoService.this);
          localIntent.addFlags(277348352);
          PocketDemoService.this.startActivity(localIntent);
          return;
        }
        catch (Throwable localThrowable)
        {
          g.s().a(localThrowable, paramGSFConfiguation.toString());
          throw new RuntimeException(localThrowable);
        }
      }
    });
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    AddActivity.b(this);
    f();
    g();
    if (paramBoolean2) {
      g.b(this);
    }
    if (paramBoolean1) {
      stopSelf();
    }
  }
  
  public static int c()
  {
    return i.a(a.bC);
  }
  
  public static boolean d()
  {
    return b;
  }
  
  private void e()
  {
    Intent localIntent = new Intent(this, PocketDemoService.class);
    localIntent.setAction("com.pocket.service.PocketDemoService.action.cancelDemo");
    this.c = new x(this).c(getString(2131493198)).a(getString(2131493199)).b(getString(2131493197)).a(2130837694).a(System.currentTimeMillis()).a(true).c(true).b(true).a(PendingIntent.getService(this, 0, localIntent, 0)).a();
    ((NotificationManager)getSystemService("notification")).notify(9000, this.c);
  }
  
  private void f()
  {
    if (this.g == null) {
      return;
    }
    this.g.c();
    this.g = null;
    b = false;
  }
  
  private void g()
  {
    ((NotificationManager)getSystemService("notification")).cancel(9000);
    this.c = null;
  }
  
  private void h()
  {
    if (this.g == null) {}
  }
  
  public void a(boolean paramBoolean, Activity paramActivity)
  {
    if (paramBoolean) {}
    Intent localIntent;
    for (int i = 1;; i = -1)
    {
      a(i);
      v.a(this.e.f(), paramBoolean, this.f);
      a(true, true);
      if ((this.f != 1) || (!paramBoolean)) {
        break;
      }
      localIntent = new Intent(paramActivity, GsfDemoCompleteActivity.class);
      localIntent.addFlags(1082130432);
      paramActivity.startActivity(localIntent);
      return;
    }
    if (paramBoolean) {
      localIntent = new Intent(paramActivity, PocketActivity.class);
    }
    for (;;)
    {
      localIntent.addFlags(335544320);
      break;
      localIntent = new Intent(paramActivity, GsfActivity.class);
      localIntent.putExtra("extraSuccess", false);
    }
  }
  
  public boolean a()
  {
    v.d(this.e.f(), this.f);
    a(true, false);
    return true;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation != this.d)
    {
      this.d = paramConfiguration.orientation;
      h();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a(false, true);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent == null) {}
    String str;
    do
    {
      return 1;
      str = paramIntent.getAction();
      if ("com.pocket.service.PocketDemoService.action.startDemo".equals(str))
      {
        f();
        a((GSFConfiguation)paramIntent.getParcelableExtra("extra_gsf_app"), paramIntent.getStringExtra("extra_app_name"), paramIntent.getIntExtra("extra_start_source", 0));
        return 1;
      }
    } while (!"com.pocket.service.PocketDemoService.action.cancelDemo".equals(str));
    v.c(this.e.f(), this.f);
    a(true, true);
    startActivity(new Intent(this, GsfActivity.class).addFlags(335544320));
    return 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/service/PocketDemoService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */