package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;

public abstract class cv
  extends do
{
  private final cx mQ;
  private final cu.a pc;
  
  public cv(cx paramcx, cu.a parama)
  {
    this.mQ = paramcx;
    this.pc = parama;
  }
  
  private static cz a(db paramdb, cx paramcx)
  {
    try
    {
      paramdb = paramdb.b(paramcx);
      return paramdb;
    }
    catch (RemoteException paramdb)
    {
      dw.c("Could not fetch ad response from ad request service.", paramdb);
    }
    return null;
  }
  
  /* Error */
  public final void aY()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 45	com/google/android/gms/internal/cv:bf	()Lcom/google/android/gms/internal/db;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +27 -> 33
    //   9: new 47	com/google/android/gms/internal/cz
    //   12: dup
    //   13: iconst_0
    //   14: invokespecial 50	com/google/android/gms/internal/cz:<init>	(I)V
    //   17: astore_1
    //   18: aload_0
    //   19: invokevirtual 53	com/google/android/gms/internal/cv:be	()V
    //   22: aload_0
    //   23: getfield 23	com/google/android/gms/internal/cv:pc	Lcom/google/android/gms/internal/cu$a;
    //   26: aload_1
    //   27: invokeinterface 58 2 0
    //   32: return
    //   33: aload_1
    //   34: aload_0
    //   35: getfield 21	com/google/android/gms/internal/cv:mQ	Lcom/google/android/gms/internal/cx;
    //   38: invokestatic 60	com/google/android/gms/internal/cv:a	(Lcom/google/android/gms/internal/db;Lcom/google/android/gms/internal/cx;)Lcom/google/android/gms/internal/cz;
    //   41: astore_2
    //   42: aload_2
    //   43: astore_1
    //   44: aload_2
    //   45: ifnonnull -27 -> 18
    //   48: new 47	com/google/android/gms/internal/cz
    //   51: dup
    //   52: iconst_0
    //   53: invokespecial 50	com/google/android/gms/internal/cz:<init>	(I)V
    //   56: astore_1
    //   57: goto -39 -> 18
    //   60: astore_1
    //   61: aload_0
    //   62: invokevirtual 53	com/google/android/gms/internal/cv:be	()V
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	cv
    //   4	53	1	localObject1	Object
    //   60	6	1	localObject2	Object
    //   41	4	2	localcz	cz
    // Exception table:
    //   from	to	target	type
    //   0	5	60	finally
    //   9	18	60	finally
    //   33	42	60	finally
    //   48	57	60	finally
  }
  
  public abstract void be();
  
  public abstract db bf();
  
  public final void onStop()
  {
    be();
  }
  
  public static final class a
    extends cv
  {
    private final Context mContext;
    
    public a(Context paramContext, cx paramcx, cu.a parama)
    {
      super(parama);
      this.mContext = paramContext;
    }
    
    public void be() {}
    
    public db bf()
    {
      ax localax = new ax();
      return dc.a(this.mContext, localax, new bg());
    }
  }
  
  public static final class b
    extends cv
    implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener
  {
    private final Object li = new Object();
    private final cu.a pc;
    private final cw pd;
    
    public b(Context paramContext, cx paramcx, cu.a parama)
    {
      super(parama);
      this.pc = parama;
      this.pd = new cw(paramContext, this, this, paramcx.kK.rs);
      this.pd.connect();
    }
    
    public void be()
    {
      synchronized (this.li)
      {
        if ((this.pd.isConnected()) || (this.pd.isConnecting())) {
          this.pd.disconnect();
        }
        return;
      }
    }
    
    public db bf()
    {
      synchronized (this.li)
      {
        try
        {
          db localdb = this.pd.bi();
          return localdb;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          return null;
        }
      }
    }
    
    public void onConnected(Bundle paramBundle)
    {
      start();
    }
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      this.pc.a(new cz(0));
    }
    
    public void onDisconnected()
    {
      dw.v("Disconnected from remote ad request service.");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */