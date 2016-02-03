package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import java.util.Iterator;
import java.util.List;

public final class x
{
  private final Context mContext;
  private final cd xT;
  private final ai xU;
  private final Object xV = new Object();
  private final aa xW;
  private boolean xX = false;
  private ae xY;
  
  public x(Context paramContext, cd paramcd, ai paramai, aa paramaa)
  {
    this.mContext = paramContext;
    this.xT = paramcd;
    this.xU = paramai;
    this.xW = paramaa;
  }
  
  public af b(long paramLong1, long paramLong2)
  {
    ce.aG("Starting mediation.");
    Object localObject2 = this.xW.yg.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      y localy = (y)((Iterator)localObject2).next();
      ce.aa("Trying mediation network: " + localy.yb);
      Iterator localIterator = localy.yc.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        synchronized (this.xV)
        {
          if (this.xX)
          {
            localObject2 = new af(-1);
            return (af)localObject2;
          }
          this.xY = new ae(this.mContext, str, this.xU, this.xW, localy, this.xT.DB, this.xT.DC, this.xT.CY);
          ??? = this.xY.c(paramLong1, paramLong2);
          if (((af)???).Cj == 0)
          {
            ce.aG("Adapter succeeded.");
            return (af)???;
          }
        }
        if (((af)???).Cl != null) {
          cb.Fw.post(new Runnable()
          {
            public void run()
            {
              try
              {
                localObject1.Cl.destroy();
                return;
              }
              catch (RemoteException localRemoteException)
              {
                ce.c("Could not destroy mediation adapter.", localRemoteException);
              }
            }
          });
        }
      }
    }
    return new af(1);
  }
  
  public void cancel()
  {
    synchronized (this.xV)
    {
      this.xX = true;
      if (this.xY != null) {
        this.xY.cancel();
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */