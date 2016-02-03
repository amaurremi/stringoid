package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.dynamic.c;

public final class ax
  implements ay.a
{
  private final bb ed;
  private final v eq;
  private final String fR;
  private final long fS;
  private final at fT;
  private final x fU;
  private final cu fV;
  private bc fW;
  private int fX = -2;
  private final Object fx = new Object();
  private final Context mContext;
  
  public ax(Context paramContext, String paramString, bb parambb, au paramau, at paramat, v paramv, x paramx, cu paramcu)
  {
    this.mContext = paramContext;
    this.fR = paramString;
    this.ed = parambb;
    if (paramau.fJ != -1L) {}
    for (long l = paramau.fJ;; l = 10000L)
    {
      this.fS = l;
      this.fT = paramat;
      this.eq = paramv;
      this.fU = paramx;
      this.fV = paramcu;
      return;
    }
  }
  
  private bc V()
  {
    ct.t("Instantiating mediation adapter: " + this.fR);
    try
    {
      bc localbc = this.ed.l(this.fR);
      return localbc;
    }
    catch (RemoteException localRemoteException)
    {
      ct.a("Could not instantiate mediation adapter: " + this.fR, localRemoteException);
    }
    return null;
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    for (;;)
    {
      if (this.fX != -2) {
        return;
      }
      b(paramLong1, paramLong2, paramLong3, paramLong4);
    }
  }
  
  private void a(aw paramaw)
  {
    try
    {
      if (this.fV.iL < 4100000)
      {
        if (this.fU.eG)
        {
          this.fW.a(c.h(this.mContext), this.eq, this.fT.fH, paramaw);
          return;
        }
        this.fW.a(c.h(this.mContext), this.fU, this.eq, this.fT.fH, paramaw);
        return;
      }
    }
    catch (RemoteException paramaw)
    {
      ct.b("Could not request ad from mediation adapter.", paramaw);
      f(5);
      return;
    }
    if (this.fU.eG)
    {
      this.fW.a(c.h(this.mContext), this.eq, this.fT.fH, this.fT.adJson, paramaw);
      return;
    }
    this.fW.a(c.h(this.mContext), this.fU, this.eq, this.fT.fH, this.fT.adJson, paramaw);
  }
  
  private void b(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    long l = SystemClock.elapsedRealtime();
    paramLong1 = paramLong2 - (l - paramLong1);
    paramLong2 = paramLong4 - (l - paramLong3);
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L))
    {
      ct.t("Timed out waiting for adapter.");
      this.fX = 3;
      return;
    }
    try
    {
      this.fx.wait(Math.min(paramLong1, paramLong2));
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      this.fX = -1;
    }
  }
  
  public ay b(long paramLong1, long paramLong2)
  {
    synchronized (this.fx)
    {
      long l = SystemClock.elapsedRealtime();
      final Object localObject2 = new aw();
      cs.iI.post(new Runnable()
      {
        public void run()
        {
          synchronized (ax.a(ax.this))
          {
            if (ax.b(ax.this) != -2) {
              return;
            }
            ax.a(ax.this, ax.c(ax.this));
            if (ax.d(ax.this) == null)
            {
              ax.this.f(4);
              return;
            }
          }
          localObject2.a(ax.this);
          ax.a(ax.this, localObject2);
        }
      });
      a(l, this.fS, paramLong1, paramLong2);
      localObject2 = new ay(this.fT, this.fW, this.fR, (aw)localObject2, this.fX);
      return (ay)localObject2;
    }
  }
  
  public void cancel()
  {
    synchronized (this.fx)
    {
      try
      {
        if (this.fW != null) {
          this.fW.destroy();
        }
        this.fX = -1;
        this.fx.notify();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          ct.b("Could not destroy mediation adapter.", localRemoteException);
        }
      }
    }
  }
  
  public void f(int paramInt)
  {
    synchronized (this.fx)
    {
      this.fX = paramInt;
      this.fx.notify();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */