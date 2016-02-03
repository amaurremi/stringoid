package com.google.android.gms.internal;

import android.os.SystemClock;
import org.json.JSONObject;

public final class gr
{
  private static final gn BG = new gn("RequestTracker");
  public static final Object CN = new Object();
  private long CJ;
  private long CK;
  private long CL;
  private gq CM;
  
  public gr(long paramLong)
  {
    this.CJ = paramLong;
    this.CK = -1L;
    this.CL = 0L;
  }
  
  private void eu()
  {
    this.CK = -1L;
    this.CM = null;
    this.CL = 0L;
  }
  
  public void a(long paramLong, gq paramgq)
  {
    synchronized (CN)
    {
      gq localgq = this.CM;
      long l = this.CK;
      this.CK = paramLong;
      this.CM = paramgq;
      this.CL = SystemClock.elapsedRealtime();
      if (localgq != null) {
        localgq.n(l);
      }
      return;
    }
  }
  
  public boolean b(long paramLong, int paramInt, JSONObject paramJSONObject)
  {
    boolean bool = true;
    gq localgq = null;
    for (;;)
    {
      synchronized (CN)
      {
        if ((this.CK != -1L) && (this.CK == paramLong))
        {
          BG.b("request %d completed", new Object[] { Long.valueOf(this.CK) });
          localgq = this.CM;
          eu();
          if (localgq != null) {
            localgq.a(paramLong, paramInt, paramJSONObject);
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
    synchronized (CN)
    {
      if (this.CK != -1L) {
        eu();
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
      synchronized (CN)
      {
        if ((this.CK != -1L) && (paramLong - this.CL >= this.CJ))
        {
          BG.b("request %d timed out", new Object[] { Long.valueOf(this.CK) });
          paramLong = this.CK;
          gq localgq = this.CM;
          eu();
          if (localgq != null) {
            localgq.a(paramLong, paramInt, null);
          }
          return bool;
        }
      }
      bool = false;
      Object localObject2 = null;
      paramLong = l;
    }
  }
  
  public boolean ev()
  {
    for (;;)
    {
      synchronized (CN)
      {
        if (this.CK != -1L)
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
      synchronized (CN)
      {
        if ((this.CK != -1L) && (this.CK == paramLong))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/gr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */