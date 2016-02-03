package com.ideashower.readitlater.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.ContextThemeWrapper;
import android.widget.Toast;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.h.i;
import com.pocket.c.e;
import com.pocket.stats.f;
import java.util.concurrent.atomic.AtomicBoolean;

public class WakefulAppService
  extends Service
{
  private static final Object b = new Object();
  private static WakefulAppService c;
  private static PowerManager d;
  private static PowerManager.WakeLock e;
  private static Toast f;
  private static final AtomicBoolean g = new AtomicBoolean(false);
  protected Handler a = new Handler();
  private int h = 0;
  private final d i;
  
  public WakefulAppService()
  {
    synchronized (b)
    {
      c = this;
      this.i = new d(this, null);
      return;
    }
  }
  
  private static PowerManager a(Context paramContext)
  {
    synchronized (b)
    {
      if (d == null) {
        d = (PowerManager)paramContext.getSystemService("power");
      }
      paramContext = d;
      return paramContext;
    }
  }
  
  @SuppressLint({"ShowToast"})
  public static Toast a(Context paramContext, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      Object localObject1;
      synchronized (b)
      {
        localObject1 = f;
        if (localObject1 == null)
        {
          if (c != null)
          {
            localObject1 = c;
            paramContext = Toast.makeText(new ContextThemeWrapper((Context)localObject1, 2131558456), paramInt1, paramInt2);
            if (i.a(com.ideashower.readitlater.h.a.bn)) {
              paramContext.setGravity(81, 0, (int)g.c().getResources().getDimension(2131296257));
            }
            f = paramContext;
            return paramContext;
          }
          localObject1 = paramContext;
          if (paramContext != null) {
            continue;
          }
          return null;
        }
      }
      ((Toast)localObject1).setDuration(paramInt2);
      ((Toast)localObject1).setText(paramInt1);
      paramContext = (Context)localObject1;
    }
  }
  
  public static void a()
  {
    Context localContext = g.c();
    synchronized (b)
    {
      if (c == null)
      {
        localContext.startService(new Intent(localContext, WakefulAppService.class));
        return;
      }
      a("context start");
    }
  }
  
  public static void a(int paramInt1, final int paramInt2)
  {
    g.a(new Runnable()
    {
      public void run()
      {
        synchronized ()
        {
          if (WakefulAppService.f() != null) {
            Toast.makeText(WakefulAppService.f(), this.a, paramInt2).show();
          }
          return;
        }
      }
    });
  }
  
  public static void a(Toast paramToast, Context paramContext)
  {
    paramToast.setGravity(81, 0, paramContext.getResources().getDimensionPixelSize(2131296391));
  }
  
  public static void a(String paramString)
  {
    g.set(true);
  }
  
  public static void b()
  {
    synchronized (b)
    {
      if (c != null)
      {
        c.d();
        b(false, c);
        g.h();
        c.stopSelf();
        c = null;
        if ((g.y()) && (e != null) && (e.isHeld())) {
          throw new RuntimeException("wake lock still held at shutdown");
        }
      }
    }
  }
  
  @SuppressLint({"Wakelock"})
  private static void b(boolean paramBoolean, Context paramContext)
  {
    synchronized (b)
    {
      if (e == null)
      {
        e = a(paramContext).newWakeLock(1, "com.ideashower.readitlater");
        e.setReferenceCounted(false);
      }
      if (paramBoolean)
      {
        e.acquire();
        return;
      }
      e.release();
    }
  }
  
  public static void c()
  {
    if (!g.y()) {
      return;
    }
    synchronized (b)
    {
      if (c != null) {
        c.i.a();
      }
      return;
    }
  }
  
  private static boolean i()
  {
    return (g.j()) || (e.n()) || (com.pocket.m.a.j()) || (com.ideashower.readitlater.db.operation.d.g()) || (a.a()) || (f.a());
  }
  
  protected void d()
  {
    this.h = 3;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.i.run();
  }
  
  public void onDestroy()
  {
    synchronized (b)
    {
      c = null;
      if ((g.y()) && (e != null) && (e.isHeld())) {
        throw new RuntimeException("wake lock still held at onDestory");
      }
    }
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getAction();
      if ((paramIntent != null) && (paramIntent.startsWith("com.ideashower.readitlater.service.action.")))
      {
        if (!paramIntent.equals("com.ideashower.readitlater.service.action.cancel")) {
          break label45;
        }
        com.ideashower.readitlater.i.a.d();
        e.a(false);
        com.pocket.m.a.d();
      }
    }
    for (;;)
    {
      return 1;
      label45:
      if (!paramIntent.equals("com.ideashower.readitlater.service.action.delay")) {
        if (paramIntent.equals("com.ideashower.readitlater.service.action.pause"))
        {
          com.ideashower.readitlater.i.a.a(this);
          com.ideashower.readitlater.i.a.b();
          e.a(false);
          com.pocket.m.a.d();
        }
        else if (paramIntent.equals("com.ideashower.readitlater.service.action.resume"))
        {
          com.ideashower.readitlater.i.a.f();
          com.pocket.m.a.b(false);
          com.ideashower.readitlater.i.a.b();
          continue;
          a("onStartCommand");
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/service/WakefulAppService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */