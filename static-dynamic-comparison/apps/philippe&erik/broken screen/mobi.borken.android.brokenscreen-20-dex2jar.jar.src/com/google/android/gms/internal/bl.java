package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import java.util.Iterator;
import java.util.List;

public final class bl
{
  private final bu kz;
  private final Object lq = new Object();
  private final Context mContext;
  private final dt nc;
  private final bn nd;
  private boolean ne = false;
  private bq nf;
  
  public bl(Context paramContext, dt paramdt, bu parambu, bn parambn)
  {
    this.mContext = paramContext;
    this.nc = paramdt;
    this.kz = parambu;
    this.nd = parambn;
  }
  
  public br a(long paramLong1, long paramLong2)
  {
    ev.z("Starting mediation.");
    Object localObject2 = this.nd.np.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      bm localbm = (bm)((Iterator)localObject2).next();
      ev.B("Trying mediation network: " + localbm.nj);
      Iterator localIterator = localbm.nk.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        synchronized (this.lq)
        {
          if (this.ne)
          {
            localObject2 = new br(-1);
            return (br)localObject2;
          }
          this.nf = new bq(this.mContext, str, this.kz, this.nd, localbm, this.nc.pV, this.nc.kR, this.nc.kO);
          ??? = this.nf.b(paramLong1, paramLong2);
          if (((br)???).nJ == 0)
          {
            ev.z("Adapter succeeded.");
            return (br)???;
          }
        }
        if (((br)???).nL != null) {
          eu.ss.post(new Runnable()
          {
            public void run()
            {
              try
              {
                localObject1.nL.destroy();
                return;
              }
              catch (RemoteException localRemoteException)
              {
                ev.c("Could not destroy mediation adapter.", localRemoteException);
              }
            }
          });
        }
      }
    }
    return new br(1);
  }
  
  public void cancel()
  {
    synchronized (this.lq)
    {
      this.ne = true;
      if (this.nf != null) {
        this.nf.cancel();
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */