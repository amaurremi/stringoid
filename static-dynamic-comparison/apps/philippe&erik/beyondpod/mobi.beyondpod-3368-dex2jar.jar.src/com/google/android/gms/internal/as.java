package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import java.util.Iterator;
import java.util.List;

public final class as
{
  private final bb ed;
  private ax fA;
  private final bz fw;
  private final Object fx = new Object();
  private final au fy;
  private boolean fz = false;
  private final Context mContext;
  
  public as(Context paramContext, bz parambz, bb parambb, au paramau)
  {
    this.mContext = paramContext;
    this.fw = parambz;
    this.ed = parambb;
    this.fy = paramau;
  }
  
  public ay a(long paramLong1, long paramLong2)
  {
    ct.r("Starting mediation.");
    Object localObject2 = this.fy.fI.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      at localat = (at)((Iterator)localObject2).next();
      ct.t("Trying mediation network: " + localat.fD);
      Iterator localIterator = localat.fE.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        synchronized (this.fx)
        {
          if (this.fz)
          {
            localObject2 = new ay(-1);
            return (ay)localObject2;
          }
          this.fA = new ax(this.mContext, str, this.ed, this.fy, localat, this.fw.hr, this.fw.em, this.fw.ej);
          ??? = this.fA.b(paramLong1, paramLong2);
          if (((ay)???).ga == 0)
          {
            ct.r("Adapter succeeded.");
            return (ay)???;
          }
        }
        if (((ay)???).gc != null) {
          cs.iI.post(new Runnable()
          {
            public void run()
            {
              try
              {
                localObject1.gc.destroy();
                return;
              }
              catch (RemoteException localRemoteException)
              {
                ct.b("Could not destroy mediation adapter.", localRemoteException);
              }
            }
          });
        }
      }
    }
    return new ay(1);
  }
  
  public void cancel()
  {
    synchronized (this.fx)
    {
      this.fz = true;
      if (this.fA != null) {
        this.fA.cancel();
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */