package com.google.android.gms.analytics;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

class d
  implements a
{
  private boolean b = false;
  private int c = 0;
  private long d = -1L;
  private boolean e = false;
  private long f;
  private ad g;
  
  public d(final Tracker paramTracker)
  {
    this.g = new ad()
    {
      public long a()
      {
        return System.currentTimeMillis();
      }
    };
  }
  
  private void e()
  {
    GoogleAnalytics localGoogleAnalytics = GoogleAnalytics.di();
    if (localGoogleAnalytics == null)
    {
      aa.A("GoogleAnalytics isn't initialized for the Tracker!");
      return;
    }
    if ((this.d >= 0L) || (this.b))
    {
      localGoogleAnalytics.a(Tracker.b(this.a));
      return;
    }
    localGoogleAnalytics.b(Tracker.b(this.a));
  }
  
  public long a()
  {
    return this.d;
  }
  
  public void a(long paramLong)
  {
    this.d = paramLong;
    e();
  }
  
  public void a(Activity paramActivity)
  {
    u.a().a(u.a.we);
    if ((this.c == 0) && (d())) {
      this.e = true;
    }
    this.c += 1;
    HashMap localHashMap;
    Tracker localTracker;
    if (this.b)
    {
      localHashMap = new HashMap();
      localHashMap.put("&t", "screenview");
      u.a().a(true);
      localTracker = this.a;
      if (Tracker.c(this.a) == null) {
        break label121;
      }
    }
    label121:
    for (paramActivity = Tracker.c(this.a).a(paramActivity);; paramActivity = paramActivity.getClass().getCanonicalName())
    {
      localTracker.set("&cd", paramActivity);
      this.a.send(localHashMap);
      u.a().a(false);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    e();
  }
  
  public void b(Activity paramActivity)
  {
    u.a().a(u.a.wf);
    this.c -= 1;
    this.c = Math.max(0, this.c);
    if (this.c == 0) {
      this.f = this.g.a();
    }
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    boolean bool = this.e;
    this.e = false;
    return bool;
  }
  
  boolean d()
  {
    return this.g.a() >= this.f + Math.max(1000L, this.d);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */