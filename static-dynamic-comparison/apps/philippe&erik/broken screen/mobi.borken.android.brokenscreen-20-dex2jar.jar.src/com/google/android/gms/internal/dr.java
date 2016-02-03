package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;

public abstract class dr
  extends en
{
  private final dt nc;
  private final dq.a pR;
  
  public dr(dt paramdt, dq.a parama)
  {
    this.nc = paramdt;
    this.pR = parama;
  }
  
  private static dv a(dx paramdx, dt paramdt)
  {
    try
    {
      paramdx = paramdx.b(paramdt);
      return paramdx;
    }
    catch (RemoteException paramdx)
    {
      ev.c("Could not fetch ad response from ad request service.", paramdx);
      return null;
    }
    catch (NullPointerException paramdx)
    {
      ev.c("Could not fetch ad response from ad request service due to an Exception.", paramdx);
      return null;
    }
    catch (SecurityException paramdx)
    {
      ev.c("Could not fetch ad response from ad request service due to an Exception.", paramdx);
    }
    return null;
  }
  
  /* Error */
  public final void bc()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 51	com/google/android/gms/internal/dr:bo	()Lcom/google/android/gms/internal/dx;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +27 -> 33
    //   9: new 53	com/google/android/gms/internal/dv
    //   12: dup
    //   13: iconst_0
    //   14: invokespecial 56	com/google/android/gms/internal/dv:<init>	(I)V
    //   17: astore_1
    //   18: aload_0
    //   19: invokevirtual 59	com/google/android/gms/internal/dr:bn	()V
    //   22: aload_0
    //   23: getfield 23	com/google/android/gms/internal/dr:pR	Lcom/google/android/gms/internal/dq$a;
    //   26: aload_1
    //   27: invokeinterface 64 2 0
    //   32: return
    //   33: aload_1
    //   34: aload_0
    //   35: getfield 21	com/google/android/gms/internal/dr:nc	Lcom/google/android/gms/internal/dt;
    //   38: invokestatic 66	com/google/android/gms/internal/dr:a	(Lcom/google/android/gms/internal/dx;Lcom/google/android/gms/internal/dt;)Lcom/google/android/gms/internal/dv;
    //   41: astore_2
    //   42: aload_2
    //   43: astore_1
    //   44: aload_2
    //   45: ifnonnull -27 -> 18
    //   48: new 53	com/google/android/gms/internal/dv
    //   51: dup
    //   52: iconst_0
    //   53: invokespecial 56	com/google/android/gms/internal/dv:<init>	(I)V
    //   56: astore_1
    //   57: goto -39 -> 18
    //   60: astore_1
    //   61: aload_0
    //   62: invokevirtual 59	com/google/android/gms/internal/dr:bn	()V
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	dr
    //   4	53	1	localObject1	Object
    //   60	6	1	localObject2	Object
    //   41	4	2	localdv	dv
    // Exception table:
    //   from	to	target	type
    //   0	5	60	finally
    //   9	18	60	finally
    //   33	42	60	finally
    //   48	57	60	finally
  }
  
  public abstract void bn();
  
  public abstract dx bo();
  
  public final void onStop()
  {
    bn();
  }
  
  public static final class a
    extends dr
  {
    private final Context mContext;
    
    public a(Context paramContext, dt paramdt, dq.a parama)
    {
      super(parama);
      this.mContext = paramContext;
    }
    
    public void bn() {}
    
    public dx bo()
    {
      az localaz = new az();
      return dy.a(this.mContext, localaz, new bk(), new ef());
    }
  }
  
  public static final class b
    extends dr
    implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener
  {
    private final Object lq = new Object();
    private final dq.a pR;
    private final ds pS;
    
    public b(Context paramContext, dt paramdt, dq.a parama)
    {
      super(parama);
      this.pR = parama;
      this.pS = new ds(paramContext, this, this, paramdt.kO.sv);
      this.pS.connect();
    }
    
    public void bn()
    {
      synchronized (this.lq)
      {
        if ((this.pS.isConnected()) || (this.pS.isConnecting())) {
          this.pS.disconnect();
        }
        return;
      }
    }
    
    public dx bo()
    {
      synchronized (this.lq)
      {
        try
        {
          dx localdx = this.pS.br();
          return localdx;
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
      this.pR.a(new dv(0));
    }
    
    public void onDisconnected()
    {
      ev.z("Disconnected from remote ad request service.");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/dr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */