package com.google.android.gms.internal;

import android.os.SystemClock;
import org.json.JSONObject;

public final class do
{
  private static final dk lA = new dk("RequestTracker");
  public static final Object mw = new Object();
  private long ms;
  private long mt;
  private long mu;
  private dn mv;
  
  public do(long paramLong)
  {
    this.ms = paramLong;
    this.mt = -1L;
    this.mu = 0L;
  }
  
  private void be()
  {
    this.mt = -1L;
    this.mv = null;
    this.mu = 0L;
  }
  
  public void a(long paramLong, dn paramdn)
  {
    synchronized (mw)
    {
      dn localdn = this.mv;
      long l = this.mt;
      this.mt = paramLong;
      this.mv = paramdn;
      this.mu = SystemClock.elapsedRealtime();
      if (localdn != null) {
        localdn.g(l);
      }
      return;
    }
  }
  
  public boolean b(long paramLong, int paramInt, JSONObject paramJSONObject)
  {
    boolean bool = true;
    dn localdn = null;
    for (;;)
    {
      synchronized (mw)
      {
        if ((this.mt != -1L) && (this.mt == paramLong))
        {
          lA.b("request %d completed", new Object[] { Long.valueOf(this.mt) });
          localdn = this.mv;
          be();
          if (localdn != null) {
            localdn.a(paramLong, paramInt, paramJSONObject);
          }
          return bool;
        }
      }
      bool = false;
    }
  }
  
  public boolean bf()
  {
    for (;;)
    {
      synchronized (mw)
      {
        if (this.mt != -1L)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean c(long paramLong, int paramInt)
  {
    return b(paramLong, paramInt, null);
  }
  
  public void clear()
  {
    synchronized (mw)
    {
      if (this.mt != -1L) {
        be();
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
      synchronized (mw)
      {
        if ((this.mt != -1L) && (paramLong - this.mu >= this.ms))
        {
          lA.b("request %d timed out", new Object[] { Long.valueOf(this.mt) });
          paramLong = this.mt;
          dn localdn = this.mv;
          be();
          if (localdn != null) {
            localdn.a(paramLong, paramInt, null);
          }
          return bool;
        }
      }
      bool = false;
      Object localObject2 = null;
      paramLong = l;
    }
  }
  
  public boolean i(long paramLong)
  {
    for (;;)
    {
      synchronized (mw)
      {
        if ((this.mt != -1L) && (this.mt == paramLong))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/do.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */