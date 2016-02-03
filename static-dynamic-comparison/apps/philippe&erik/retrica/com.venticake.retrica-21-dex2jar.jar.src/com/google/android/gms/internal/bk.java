package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import java.util.Iterator;
import java.util.List;

public final class bk
{
  private final bt kB;
  private final Object ls = new Object();
  private final Context mContext;
  private final ds ne;
  private final bm nf;
  private boolean ng = false;
  private bp nh;
  
  public bk(Context paramContext, ds paramds, bt parambt, bm parambm)
  {
    this.mContext = paramContext;
    this.ne = paramds;
    this.kB = parambt;
    this.nf = parambm;
  }
  
  public bq a(long paramLong1, long paramLong2)
  {
    eu.z("Starting mediation.");
    Object localObject2 = this.nf.nr.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      bl localbl = (bl)((Iterator)localObject2).next();
      eu.B("Trying mediation network: " + localbl.nl);
      Iterator localIterator = localbl.nm.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        synchronized (this.ls)
        {
          if (this.ng)
          {
            localObject2 = new bq(-1);
            return (bq)localObject2;
          }
          this.nh = new bp(this.mContext, str, this.kB, this.nf, localbl, this.ne.pX, this.ne.kT, this.ne.kQ);
          ??? = this.nh.b(paramLong1, paramLong2);
          if (((bq)???).nL == 0)
          {
            eu.z("Adapter succeeded.");
            return (bq)???;
          }
        }
        if (((bq)???).nN != null) {
          et.sv.post(new Runnable()
          {
            public void run()
            {
              try
              {
                localObject1.nN.destroy();
                return;
              }
              catch (RemoteException localRemoteException)
              {
                eu.c("Could not destroy mediation adapter.", localRemoteException);
              }
            }
          });
        }
      }
    }
    return new bq(1);
  }
  
  public void cancel()
  {
    synchronized (this.ls)
    {
      this.ng = true;
      if (this.nh != null) {
        this.nh.cancel();
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */