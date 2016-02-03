package com.google.android.gms.analytics;

import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

class an
  extends TimerTask
{
  private an(al paramal) {}
  
  public void run()
  {
    if ((al.b(this.a) == am.b) && (al.e(this.a).isEmpty()) && (al.f(this.a) + al.g(this.a) < al.h(this.a).a()))
    {
      aa.C("Disconnecting due to inactivity");
      al.i(this.a);
      return;
    }
    al.j(this.a).schedule(new an(this.a), al.g(this.a));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */