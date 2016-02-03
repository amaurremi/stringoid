package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.b;
import com.google.android.gms.common.c.a;
import com.google.android.gms.common.c.b;

public abstract class ay
  extends br
{
  private final ax.a Dw;
  private final cd xT;
  
  public ay(cd paramcd, ax.a parama)
  {
    this.xT = paramcd;
    this.Dw = parama;
  }
  
  private static cf a(bc parambc, cd paramcd)
  {
    try
    {
      parambc = parambc.b(paramcd);
      return parambc;
    }
    catch (RemoteException parambc)
    {
      ce.c("Could not fetch ad response from ad request service.", parambc);
    }
    return null;
  }
  
  public abstract void lA();
  
  public final void onStop()
  {
    lA();
  }
  
  public abstract bc pA();
  
  /* Error */
  public final void py()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 49	com/google/android/gms/internal/ay:pA	()Lcom/google/android/gms/internal/bc;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +27 -> 33
    //   9: new 51	com/google/android/gms/internal/cf
    //   12: dup
    //   13: iconst_0
    //   14: invokespecial 54	com/google/android/gms/internal/cf:<init>	(I)V
    //   17: astore_1
    //   18: aload_0
    //   19: invokevirtual 44	com/google/android/gms/internal/ay:lA	()V
    //   22: aload_0
    //   23: getfield 23	com/google/android/gms/internal/ay:Dw	Lcom/google/android/gms/internal/ax$a;
    //   26: aload_1
    //   27: invokeinterface 59 2 0
    //   32: return
    //   33: aload_1
    //   34: aload_0
    //   35: getfield 21	com/google/android/gms/internal/ay:xT	Lcom/google/android/gms/internal/cd;
    //   38: invokestatic 61	com/google/android/gms/internal/ay:a	(Lcom/google/android/gms/internal/bc;Lcom/google/android/gms/internal/cd;)Lcom/google/android/gms/internal/cf;
    //   41: astore_2
    //   42: aload_2
    //   43: astore_1
    //   44: aload_2
    //   45: ifnonnull -27 -> 18
    //   48: new 51	com/google/android/gms/internal/cf
    //   51: dup
    //   52: iconst_0
    //   53: invokespecial 54	com/google/android/gms/internal/cf:<init>	(I)V
    //   56: astore_1
    //   57: goto -39 -> 18
    //   60: astore_1
    //   61: aload_0
    //   62: invokevirtual 44	com/google/android/gms/internal/ay:lA	()V
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	ay
    //   4	53	1	localObject1	Object
    //   60	6	1	localObject2	Object
    //   41	4	2	localcf	cf
    // Exception table:
    //   from	to	target	type
    //   0	5	60	finally
    //   9	18	60	finally
    //   33	42	60	finally
    //   48	57	60	finally
  }
  
  public static final class a
    extends ay
  {
    private final Context mContext;
    
    public a(Context paramContext, cd paramcd, ax.a parama)
    {
      super(parama);
      this.mContext = paramContext;
    }
    
    public void lA() {}
    
    public bc pA()
    {
      return bd.a(this.mContext, new w());
    }
  }
  
  public static final class b
    extends ay
    implements c.a, c.b
  {
    private final ax.a Dw;
    private final az Dx;
    private final Object xV = new Object();
    
    public b(Context paramContext, cd paramcd, ax.a parama)
    {
      super(parama);
      this.Dw = parama;
      this.Dx = new az(paramContext, this, this, paramcd.CY.FM);
      this.Dx.connect();
    }
    
    public void a(Bundle paramBundle)
    {
      start();
    }
    
    public void a(b paramb)
    {
      this.Dw.a(new cf(0));
    }
    
    public void lA()
    {
      synchronized (this.xV)
      {
        if ((this.Dx.isConnected()) || (this.Dx.isConnecting())) {
          this.Dx.disconnect();
        }
        return;
      }
    }
    
    public void onDisconnected()
    {
      ce.aG("Disconnected from remote ad request service.");
    }
    
    public bc pA()
    {
      synchronized (this.xV)
      {
        try
        {
          bc localbc = this.Dx.pB();
          return localbc;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          return null;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */