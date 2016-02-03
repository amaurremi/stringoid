package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.dynamic.d;

public final class ae
  implements af.a
{
  private final String BZ;
  private final long Ca;
  private final y Cb;
  private final z Cc;
  private final ab Cd;
  private final db Ce;
  private aj Cf;
  private int Cg = -2;
  private final Context mContext;
  private final ai xU;
  private final Object xV = new Object();
  
  public ae(Context paramContext, String paramString, ai paramai, aa paramaa, y paramy, z paramz, ab paramab, db paramdb)
  {
    this.mContext = paramContext;
    this.BZ = paramString;
    this.xU = paramai;
    if (paramaa.yh != -1L) {}
    for (long l = paramaa.yh;; l = 10000L)
    {
      this.Ca = l;
      this.Cb = paramy;
      this.Cc = paramz;
      this.Cd = paramab;
      this.Ce = paramdb;
      return;
    }
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    for (;;)
    {
      if (this.Cg != -2) {
        return;
      }
      b(paramLong1, paramLong2, paramLong3, paramLong4);
    }
  }
  
  private void a(ad paramad)
  {
    try
    {
      if (this.Ce.FM < 4100000)
      {
        if (this.Cd.xa)
        {
          this.Cf.a(d.J(this.mContext), this.Cc, this.Cb.yf, paramad);
          return;
        }
        this.Cf.a(d.J(this.mContext), this.Cd, this.Cc, this.Cb.yf, paramad);
        return;
      }
    }
    catch (RemoteException paramad)
    {
      ce.c("Could not request ad from mediation adapter.", paramad);
      cu(5);
      return;
    }
    if (this.Cd.xa)
    {
      this.Cf.a(d.J(this.mContext), this.Cc, this.Cb.yf, this.Cb.gT, paramad);
      return;
    }
    this.Cf.a(d.J(this.mContext), this.Cd, this.Cc, this.Cb.yf, this.Cb.gT, paramad);
  }
  
  private void b(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    long l = SystemClock.elapsedRealtime();
    paramLong1 = paramLong2 - (l - paramLong1);
    paramLong2 = paramLong4 - (l - paramLong3);
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L))
    {
      ce.aa("Timed out waiting for adapter.");
      this.Cg = 3;
      return;
    }
    try
    {
      this.xV.wait(Math.min(paramLong1, paramLong2));
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      this.Cg = -1;
    }
  }
  
  private aj ph()
  {
    ce.aa("Instantiating mediation adapter: " + this.BZ);
    try
    {
      aj localaj = this.xU.aA(this.BZ);
      return localaj;
    }
    catch (RemoteException localRemoteException)
    {
      ce.b("Could not instantiate mediation adapter: " + this.BZ, localRemoteException);
    }
    return null;
  }
  
  public af c(long paramLong1, long paramLong2)
  {
    synchronized (this.xV)
    {
      long l = SystemClock.elapsedRealtime();
      final Object localObject2 = new ad();
      cb.Fw.post(new Runnable()
      {
        public void run()
        {
          synchronized (ae.a(ae.this))
          {
            if (ae.b(ae.this) != -2) {
              return;
            }
            ae.a(ae.this, ae.c(ae.this));
            if (ae.d(ae.this) == null)
            {
              ae.this.cu(4);
              return;
            }
          }
          localObject2.a(ae.this);
          ae.a(ae.this, localObject2);
        }
      });
      a(l, this.Ca, paramLong1, paramLong2);
      localObject2 = new af(this.Cb, this.Cf, this.BZ, (ad)localObject2, this.Cg);
      return (af)localObject2;
    }
  }
  
  public void cancel()
  {
    synchronized (this.xV)
    {
      try
      {
        if (this.Cf != null) {
          this.Cf.destroy();
        }
        this.Cg = -1;
        this.xV.notify();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          ce.c("Could not destroy mediation adapter.", localRemoteException);
        }
      }
    }
  }
  
  public void cu(int paramInt)
  {
    synchronized (this.xV)
    {
      this.Cg = paramInt;
      this.xV.notify();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */