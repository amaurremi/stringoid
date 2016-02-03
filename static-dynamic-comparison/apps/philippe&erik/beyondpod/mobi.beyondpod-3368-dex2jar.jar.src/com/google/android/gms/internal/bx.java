package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;

public abstract class bx
  extends cm
{
  private final bz fw;
  private final bw.a hn;
  
  public bx(bz parambz, bw.a parama)
  {
    this.fw = parambz;
    this.hn = parama;
  }
  
  private static cb a(cd paramcd, bz parambz)
  {
    try
    {
      paramcd = paramcd.b(parambz);
      return paramcd;
    }
    catch (RemoteException paramcd)
    {
      ct.b("Could not fetch ad response from ad request service.", paramcd);
    }
    return null;
  }
  
  /* Error */
  public final void ai()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 44	com/google/android/gms/internal/bx:al	()Lcom/google/android/gms/internal/cd;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +27 -> 33
    //   9: new 46	com/google/android/gms/internal/cb
    //   12: dup
    //   13: iconst_0
    //   14: invokespecial 49	com/google/android/gms/internal/cb:<init>	(I)V
    //   17: astore_1
    //   18: aload_0
    //   19: invokevirtual 52	com/google/android/gms/internal/bx:ak	()V
    //   22: aload_0
    //   23: getfield 23	com/google/android/gms/internal/bx:hn	Lcom/google/android/gms/internal/bw$a;
    //   26: aload_1
    //   27: invokeinterface 57 2 0
    //   32: return
    //   33: aload_1
    //   34: aload_0
    //   35: getfield 21	com/google/android/gms/internal/bx:fw	Lcom/google/android/gms/internal/bz;
    //   38: invokestatic 59	com/google/android/gms/internal/bx:a	(Lcom/google/android/gms/internal/cd;Lcom/google/android/gms/internal/bz;)Lcom/google/android/gms/internal/cb;
    //   41: astore_2
    //   42: aload_2
    //   43: astore_1
    //   44: aload_2
    //   45: ifnonnull -27 -> 18
    //   48: new 46	com/google/android/gms/internal/cb
    //   51: dup
    //   52: iconst_0
    //   53: invokespecial 49	com/google/android/gms/internal/cb:<init>	(I)V
    //   56: astore_1
    //   57: goto -39 -> 18
    //   60: astore_1
    //   61: aload_0
    //   62: invokevirtual 52	com/google/android/gms/internal/bx:ak	()V
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	bx
    //   4	53	1	localObject1	Object
    //   60	6	1	localObject2	Object
    //   41	4	2	localcb	cb
    // Exception table:
    //   from	to	target	type
    //   0	5	60	finally
    //   9	18	60	finally
    //   33	42	60	finally
    //   48	57	60	finally
  }
  
  public abstract void ak();
  
  public abstract cd al();
  
  public final void onStop()
  {
    ak();
  }
  
  public static final class a
    extends bx
  {
    private final Context mContext;
    
    public a(Context paramContext, bz parambz, bw.a parama)
    {
      super(parama);
      this.mContext = paramContext;
    }
    
    public void ak() {}
    
    public cd al()
    {
      return ce.a(this.mContext, new ar());
    }
  }
  
  public static final class b
    extends bx
    implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener
  {
    private final Object fx = new Object();
    private final bw.a hn;
    private final by ho;
    
    public b(Context paramContext, bz parambz, bw.a parama)
    {
      super(parama);
      this.hn = parama;
      this.ho = new by(paramContext, this, this, parambz.ej.iL);
      this.ho.connect();
    }
    
    public void ak()
    {
      synchronized (this.fx)
      {
        if ((this.ho.isConnected()) || (this.ho.isConnecting())) {
          this.ho.disconnect();
        }
        return;
      }
    }
    
    public cd al()
    {
      synchronized (this.fx)
      {
        try
        {
          cd localcd = this.ho.ao();
          return localcd;
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
      this.hn.a(new cb(0));
    }
    
    public void onDisconnected()
    {
      ct.r("Disconnected from remote ad request service.");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */