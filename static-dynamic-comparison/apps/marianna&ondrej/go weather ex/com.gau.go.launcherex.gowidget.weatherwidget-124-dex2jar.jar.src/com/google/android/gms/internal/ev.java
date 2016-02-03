package com.google.android.gms.internal;

import android.os.SystemClock;
import org.json.JSONObject;

public final class ev
{
  public static final Object Ab = new Object();
  private static final er zb = new er("RequestTracker");
  private eu Aa;
  private long zX;
  private long zY;
  private long zZ;
  
  public ev(long paramLong)
  {
    this.zX = paramLong;
    this.zY = -1L;
    this.zZ = 0L;
  }
  
  private void dT()
  {
    this.zY = -1L;
    this.Aa = null;
    this.zZ = 0L;
  }
  
  public void a(long paramLong, eu parameu)
  {
    synchronized (Ab)
    {
      eu localeu = this.Aa;
      long l = this.zY;
      this.zY = paramLong;
      this.Aa = parameu;
      this.zZ = SystemClock.elapsedRealtime();
      if (localeu != null) {
        localeu.l(l);
      }
      return;
    }
  }
  
  public boolean b(long paramLong, int paramInt, JSONObject paramJSONObject)
  {
    boolean bool = true;
    eu localeu = null;
    for (;;)
    {
      synchronized (Ab)
      {
        if ((this.zY != -1L) && (this.zY == paramLong))
        {
          zb.b("request %d completed", new Object[] { Long.valueOf(this.zY) });
          localeu = this.Aa;
          dT();
          if (localeu != null) {
            localeu.a(paramLong, paramInt, paramJSONObject);
          }
          return bool;
        }
      }
      bool = false;
    }
  }
  
  public boolean c(long paramLong, int paramInt)
  {
    return b(paramLong, paramInt, null);
  }
  
  public void clear()
  {
    synchronized (Ab)
    {
      if (this.zY != -1L) {
        dT();
      }
      return;
    }
  }
  
  public boolean d(long paramLong, int paramInt)
  {
    boolean bool = true;
    long l = 0L;
    for (;;)
    {
      synchronized (Ab)
      {
        if ((this.zY != -1L) && (paramLong - this.zZ >= this.zX))
        {
          zb.b("request %d timed out", new Object[] { Long.valueOf(this.zY) });
          paramLong = this.zY;
          eu localeu = this.Aa;
          dT();
          if (localeu != null) {
            localeu.a(paramLong, paramInt, null);
          }
          return bool;
        }
      }
      bool = false;
      Object localObject2 = null;
      paramLong = l;
    }
  }
  
  public boolean dU()
  {
    for (;;)
    {
      synchronized (Ab)
      {
        if (this.zY != -1L)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean n(long paramLong)
  {
    for (;;)
    {
      synchronized (Ab)
      {
        if ((this.zY != -1L) && (this.zY == paramLong))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/ev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */