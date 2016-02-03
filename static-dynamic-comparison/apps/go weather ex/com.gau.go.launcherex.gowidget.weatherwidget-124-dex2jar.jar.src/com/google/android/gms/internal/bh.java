package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import java.util.Iterator;
import java.util.List;

public final class bh
{
  private final bq ky;
  private final Object li = new Object();
  private final Context mContext;
  private final cx mQ;
  private final bj mR;
  private boolean mS = false;
  private bm mT;
  
  public bh(Context paramContext, cx paramcx, bq parambq, bj parambj)
  {
    this.mContext = paramContext;
    this.mQ = paramcx;
    this.ky = parambq;
    this.mR = parambj;
  }
  
  public bn a(long paramLong1, long paramLong2)
  {
    dw.v("Starting mediation.");
    Object localObject2 = this.mR.nc.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      bi localbi = (bi)((Iterator)localObject2).next();
      dw.x("Trying mediation network: " + localbi.mX);
      Iterator localIterator = localbi.mY.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        synchronized (this.li)
        {
          if (this.mS)
          {
            localObject2 = new bn(-1);
            return (bn)localObject2;
          }
          this.mT = new bm(this.mContext, str, this.ky, this.mR, localbi, this.mQ.pg, this.mQ.kN, this.mQ.kK);
          ??? = this.mT.b(paramLong1, paramLong2);
          if (((bn)???).nw == 0)
          {
            dw.v("Adapter succeeded.");
            return (bn)???;
          }
        }
        if (((bn)???).ny != null) {
          dv.rp.post(new Runnable()
          {
            public void run()
            {
              try
              {
                localObject1.ny.destroy();
                return;
              }
              catch (RemoteException localRemoteException)
              {
                dw.c("Could not destroy mediation adapter.", localRemoteException);
              }
            }
          });
        }
      }
    }
    return new bn(1);
  }
  
  public void cancel()
  {
    synchronized (this.li)
    {
      this.mS = true;
      if (this.mT != null) {
        this.mT.cancel();
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */