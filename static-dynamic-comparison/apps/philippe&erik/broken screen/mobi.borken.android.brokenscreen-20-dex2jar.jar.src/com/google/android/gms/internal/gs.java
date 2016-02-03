package com.google.android.gms.internal;

import android.os.SystemClock;
import org.json.JSONObject;

public final class gs
{
  private static final go BD = new go("RequestTracker");
  public static final Object CK = new Object();
  private long CG;
  private long CH;
  private long CI;
  private gr CJ;
  
  public gs(long paramLong)
  {
    this.CG = paramLong;
    this.CH = -1L;
    this.CI = 0L;
  }
  
  private void ep()
  {
    this.CH = -1L;
    this.CJ = null;
    this.CI = 0L;
  }
  
  public void a(long paramLong, gr paramgr)
  {
    synchronized (CK)
    {
      gr localgr = this.CJ;
      long l = this.CH;
      this.CH = paramLong;
      this.CJ = paramgr;
      this.CI = SystemClock.elapsedRealtime();
      if (localgr != null) {
        localgr.n(l);
      }
      return;
    }
  }
  
  public boolean b(long paramLong, int paramInt, JSONObject paramJSONObject)
  {
    boolean bool = true;
    gr localgr = null;
    for (;;)
    {
      synchronized (CK)
      {
        if ((this.CH != -1L) && (this.CH == paramLong))
        {
          BD.b("request %d completed", new Object[] { Long.valueOf(this.CH) });
          localgr = this.CJ;
          ep();
          if (localgr != null) {
            localgr.a(paramLong, paramInt, paramJSONObject);
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
    synchronized (CK)
    {
      if (this.CH != -1L) {
        ep();
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
      synchronized (CK)
      {
        if ((this.CH != -1L) && (paramLong - this.CI >= this.CG))
        {
          BD.b("request %d timed out", new Object[] { Long.valueOf(this.CH) });
          paramLong = this.CH;
          gr localgr = this.CJ;
          ep();
          if (localgr != null) {
            localgr.a(paramLong, paramInt, null);
          }
          return bool;
        }
      }
      bool = false;
      Object localObject2 = null;
      paramLong = l;
    }
  }
  
  public boolean eq()
  {
    for (;;)
    {
      synchronized (CK)
      {
        if (this.CH != -1L)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean p(long paramLong)
  {
    for (;;)
    {
      synchronized (CK)
      {
        if ((this.CH != -1L) && (this.CH == paramLong))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/gs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */