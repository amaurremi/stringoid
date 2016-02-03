package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.dynamic.e;

public final class bq
  implements br.a
{
  private final bu kz;
  private final aj lf;
  private final Object lq = new Object();
  private final Context mContext;
  private final String nA;
  private final long nB;
  private final bm nC;
  private final am nD;
  private final ew nE;
  private bv nF;
  private int nG = -2;
  
  public bq(Context paramContext, String paramString, bu parambu, bn parambn, bm parambm, aj paramaj, am paramam, ew paramew)
  {
    this.mContext = paramContext;
    if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(paramString))
    {
      this.nA = b(parambm);
      this.kz = parambu;
      if (parambn.nq == -1L) {
        break label108;
      }
    }
    label108:
    for (long l = parambn.nq;; l = 10000L)
    {
      this.nB = l;
      this.nC = parambm;
      this.lf = paramaj;
      this.nD = paramam;
      this.nE = paramew;
      return;
      this.nA = paramString;
      break;
    }
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    for (;;)
    {
      if (this.nG != -2) {
        return;
      }
      b(paramLong1, paramLong2, paramLong3, paramLong4);
    }
  }
  
  private void a(bp parambp)
  {
    try
    {
      if (this.nE.sv < 4100000)
      {
        if (this.nD.md)
        {
          this.nF.a(e.h(this.mContext), this.lf, this.nC.no, parambp);
          return;
        }
        this.nF.a(e.h(this.mContext), this.nD, this.lf, this.nC.no, parambp);
        return;
      }
    }
    catch (RemoteException parambp)
    {
      ev.c("Could not request ad from mediation adapter.", parambp);
      g(5);
      return;
    }
    if (this.nD.md)
    {
      this.nF.a(e.h(this.mContext), this.lf, this.nC.no, this.nC.ni, parambp);
      return;
    }
    this.nF.a(e.h(this.mContext), this.nD, this.lf, this.nC.no, this.nC.ni, parambp);
  }
  
  private bv aK()
  {
    ev.B("Instantiating mediation adapter: " + this.nA);
    try
    {
      bv localbv = this.kz.m(this.nA);
      return localbv;
    }
    catch (RemoteException localRemoteException)
    {
      ev.a("Could not instantiate mediation adapter: " + this.nA, localRemoteException);
    }
    return null;
  }
  
  private String b(bm parambm)
  {
    try
    {
      if ((!TextUtils.isEmpty(parambm.nm)) && (CustomEvent.class.isAssignableFrom(Class.forName(parambm.nm, false, bq.class.getClassLoader())))) {
        return "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
      }
    }
    catch (ClassNotFoundException parambm)
    {
      ev.D("Could not create custom event adapter.");
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
      ev.B("Timed out waiting for adapter.");
      this.nG = 3;
      return;
    }
    try
    {
      this.lq.wait(Math.min(paramLong1, paramLong2));
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      this.nG = -1;
    }
  }
  
  public br b(long paramLong1, long paramLong2)
  {
    synchronized (this.lq)
    {
      long l = SystemClock.elapsedRealtime();
      final Object localObject2 = new bp();
      eu.ss.post(new Runnable()
      {
        public void run()
        {
          synchronized (bq.a(bq.this))
          {
            if (bq.b(bq.this) != -2) {
              return;
            }
            bq.a(bq.this, bq.c(bq.this));
            if (bq.d(bq.this) == null)
            {
              bq.this.g(4);
              return;
            }
          }
          localObject2.a(bq.this);
          bq.a(bq.this, localObject2);
        }
      });
      a(l, this.nB, paramLong1, paramLong2);
      localObject2 = new br(this.nC, this.nF, this.nA, (bp)localObject2, this.nG);
      return (br)localObject2;
    }
  }
  
  public void cancel()
  {
    synchronized (this.lq)
    {
      try
      {
        if (this.nF != null) {
          this.nF.destroy();
        }
        this.nG = -1;
        this.lq.notify();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          ev.c("Could not destroy mediation adapter.", localRemoteException);
        }
      }
    }
  }
  
  public void g(int paramInt)
  {
    synchronized (this.lq)
    {
      this.nG = paramInt;
      this.lq.notify();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */