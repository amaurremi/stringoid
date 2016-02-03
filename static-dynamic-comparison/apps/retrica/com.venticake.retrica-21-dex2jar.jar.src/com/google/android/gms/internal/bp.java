package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.dynamic.e;

public final class bp
  implements bq.a
{
  private final bt kB;
  private final ai lh;
  private final Object ls = new Object();
  private final Context mContext;
  private final String nC;
  private final long nD;
  private final bl nE;
  private final al nF;
  private final ev nG;
  private bu nH;
  private int nI = -2;
  
  public bp(Context paramContext, String paramString, bt parambt, bm parambm, bl parambl, ai paramai, al paramal, ev paramev)
  {
    this.mContext = paramContext;
    if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(paramString))
    {
      this.nC = b(parambl);
      this.kB = parambt;
      if (parambm.ns == -1L) {
        break label108;
      }
    }
    label108:
    for (long l = parambm.ns;; l = 10000L)
    {
      this.nD = l;
      this.nE = parambl;
      this.lh = paramai;
      this.nF = paramal;
      this.nG = paramev;
      return;
      this.nC = paramString;
      break;
    }
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    for (;;)
    {
      if (this.nI != -2) {
        return;
      }
      b(paramLong1, paramLong2, paramLong3, paramLong4);
    }
  }
  
  private void a(bo parambo)
  {
    try
    {
      if (this.nG.sy < 4100000)
      {
        if (this.nF.mf)
        {
          this.nH.a(e.h(this.mContext), this.lh, this.nE.nq, parambo);
          return;
        }
        this.nH.a(e.h(this.mContext), this.nF, this.lh, this.nE.nq, parambo);
        return;
      }
    }
    catch (RemoteException parambo)
    {
      eu.c("Could not request ad from mediation adapter.", parambo);
      g(5);
      return;
    }
    if (this.nF.mf)
    {
      this.nH.a(e.h(this.mContext), this.lh, this.nE.nq, this.nE.nk, parambo);
      return;
    }
    this.nH.a(e.h(this.mContext), this.nF, this.lh, this.nE.nq, this.nE.nk, parambo);
  }
  
  private bu aP()
  {
    eu.B("Instantiating mediation adapter: " + this.nC);
    try
    {
      bu localbu = this.kB.m(this.nC);
      return localbu;
    }
    catch (RemoteException localRemoteException)
    {
      eu.a("Could not instantiate mediation adapter: " + this.nC, localRemoteException);
    }
    return null;
  }
  
  private String b(bl parambl)
  {
    try
    {
      if ((!TextUtils.isEmpty(parambl.no)) && (CustomEvent.class.isAssignableFrom(Class.forName(parambl.no, false, bp.class.getClassLoader())))) {
        return "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
      }
    }
    catch (ClassNotFoundException parambl)
    {
      eu.D("Could not create custom event adapter.");
    }
    return "com.google.ads.mediation.customevent.CustomEventAdapter";
  }
  
  private void b(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    long l = SystemClock.elapsedRealtime();
    paramLong1 = paramLong2 - (l - paramLong1);
    paramLong2 = paramLong4 - (l - paramLong3);
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L))
    {
      eu.B("Timed out waiting for adapter.");
      this.nI = 3;
      return;
    }
    try
    {
      this.ls.wait(Math.min(paramLong1, paramLong2));
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      this.nI = -1;
    }
  }
  
  public bq b(long paramLong1, long paramLong2)
  {
    synchronized (this.ls)
    {
      long l = SystemClock.elapsedRealtime();
      final Object localObject2 = new bo();
      et.sv.post(new Runnable()
      {
        public void run()
        {
          synchronized (bp.a(bp.this))
          {
            if (bp.b(bp.this) != -2) {
              return;
            }
            bp.a(bp.this, bp.c(bp.this));
            if (bp.d(bp.this) == null)
            {
              bp.this.g(4);
              return;
            }
          }
          localObject2.a(bp.this);
          bp.a(bp.this, localObject2);
        }
      });
      a(l, this.nD, paramLong1, paramLong2);
      localObject2 = new bq(this.nE, this.nH, this.nC, (bo)localObject2, this.nI);
      return (bq)localObject2;
    }
  }
  
  public void cancel()
  {
    synchronized (this.ls)
    {
      try
      {
        if (this.nH != null) {
          this.nH.destroy();
        }
        this.nI = -1;
        this.ls.notify();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          eu.c("Could not destroy mediation adapter.", localRemoteException);
        }
      }
    }
  }
  
  public void g(int paramInt)
  {
    synchronized (this.ls)
    {
      this.nI = paramInt;
      this.ls.notify();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */