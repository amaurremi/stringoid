package com.ideashower.readitlater.i;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.h.l;
import com.ideashower.readitlater.service.OnAlarmReceiver;
import com.ideashower.readitlater.service.WakefulAppService;
import com.ideashower.readitlater.util.m;

public class a
  implements com.pocket.m.e
{
  protected static Notification a;
  protected static PendingIntent b;
  protected static final StringBuilder c;
  protected static final String d;
  protected static final String e;
  protected static final String f;
  protected static boolean g = false;
  protected static long h;
  private static NotificationManager i;
  private static int j;
  private static int k;
  private static boolean l = false;
  private static final a m;
  private static final String n = g.m().getString(2131493536);
  private static final String o = g.m().getString(2131493535);
  private static final int p;
  
  static
  {
    d = g.m().getString(2131493537);
    e = g.m().getString(2131493292);
    f = g.m().getString(2131493534);
    p = 2130837694;
    c = new StringBuilder(n.length() + o.length() + 10);
    m = j();
    a(true);
  }
  
  protected a()
  {
    com.pocket.m.a.a(this);
  }
  
  private static void a(int paramInt)
  {
    i.b().a(com.ideashower.readitlater.h.a.am, paramInt).a(com.ideashower.readitlater.h.a.an, System.currentTimeMillis()).a();
  }
  
  public static void a(Context paramContext)
  {
    int i1 = k - j;
    a(i1);
    g = false;
    if (i1 == 0) {
      m.c();
    }
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    Intent localIntent = new Intent(paramContext, OnAlarmReceiver.class);
    localIntent.putExtra("checkPause", true);
    paramContext = PendingIntent.getBroadcast(paramContext, 108, localIntent, 134217728);
    localAlarmManager.cancel(paramContext);
    localAlarmManager.set(1, System.currentTimeMillis() + 1800000L, paramContext);
  }
  
  public static boolean a(boolean paramBoolean)
  {
    int i1 = h();
    if ((i1 != 0) && (paramBoolean) && (!i())) {
      b();
    }
    return i1 != 0;
  }
  
  public static void b()
  {
    int i3 = 1;
    int i1;
    int i2;
    if (a(false))
    {
      i1 = k;
      i2 = j;
      if (i3 == 0) {
        break label211;
      }
      if (a == null) {
        break label130;
      }
      m.b(i2, i1);
    }
    for (;;)
    {
      k();
      do
      {
        return;
        if (g)
        {
          i1 = 0;
          i2 = 0;
          break;
        }
        if (!com.pocket.m.a.f()) {
          break label117;
        }
        i2 = com.pocket.m.a.o();
        i1 = com.pocket.m.a.n();
      } while ((i2 == j) && (i1 == k));
      k = i1;
      j = i2;
      if (i1 > 0)
      {
        l = true;
        break;
      }
      if (l)
      {
        i3 = 0;
        break;
      }
      l = false;
      break;
      label117:
      l = false;
      i3 = 0;
      i1 = 0;
      i2 = 0;
      break;
      label130:
      Intent localIntent = new Intent(g.c(), WakefulAppService.class);
      localIntent.setAction("com.ideashower.readitlater.service.action.cancel");
      b = PendingIntent.getService(g.c(), 0, localIntent, 268435456);
      m.e();
      h = System.currentTimeMillis();
      a = m.a(i2, i1);
      i = (NotificationManager)g.c().getSystemService("notification");
      m.b(i2, i1);
    }
    label211:
    m.c();
  }
  
  public static void d()
  {
    g = false;
    a(0);
    m.c();
  }
  
  public static void f()
  {
    g = true;
    a(0);
  }
  
  public static void g()
  {
    g = false;
  }
  
  protected static int h()
  {
    return i.a(com.ideashower.readitlater.h.a.am);
  }
  
  public static boolean i()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a(false))
    {
      bool1 = bool2;
      if (m.a(i.a(com.ideashower.readitlater.h.a.an), 1800000L, false))
      {
        d();
        com.pocket.m.a.d();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static a j()
  {
    if (com.ideashower.readitlater.util.a.i()) {
      return new b();
    }
    return new a();
  }
  
  private static void k()
  {
    try
    {
      if (a != null)
      {
        i.notify(42, a);
        return;
      }
      m.c();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.ideashower.readitlater.util.e.a(localThrowable, true);
    }
  }
  
  public Notification a(int paramInt1, int paramInt2)
  {
    paramInt1 = p;
    if (g.j()) {}
    for (Object localObject = d;; localObject = null)
    {
      localObject = new Notification(paramInt1, (CharSequence)localObject, System.currentTimeMillis());
      ((Notification)localObject).flags = (((Notification)localObject).flags | 0x2 | 0x10 | 0x8);
      return (Notification)localObject;
    }
  }
  
  public void a() {}
  
  public void b(int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0) {}
    for (String str = d;; str = paramInt1 + " " + n + " " + paramInt2 + " " + o)
    {
      a.setLatestEventInfo(g.c(), str, f, b);
      return;
      c.setLength(0);
    }
  }
  
  protected void c()
  {
    if (a != null)
    {
      i.cancel(42);
      b = null;
      a = null;
      a(0);
      g = false;
    }
    while (!a(false)) {
      return;
    }
    g = false;
    a(0);
  }
  
  protected void e() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/i/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */