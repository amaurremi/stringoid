package com.google.android.gms.internal;

import android.os.RemoteException;
import com.atomic.apps.ringtone.cutter.aa;

public abstract class bh
  extends bI
{
  private final cx a;
  private final bg b;
  
  public bh(cx paramcx, bg parambg)
  {
    this.a = paramcx;
    this.b = parambg;
  }
  
  private static cz a(bo parambo, cx paramcx)
  {
    try
    {
      parambo = parambo.a(paramcx);
      return parambo;
    }
    catch (RemoteException parambo)
    {
      aa.b("Could not fetch ad response from ad request service.", parambo);
    }
    return null;
  }
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 37	com/google/android/gms/internal/bh:d	()Lcom/google/android/gms/internal/bo;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +27 -> 33
    //   9: new 39	com/google/android/gms/internal/cz
    //   12: dup
    //   13: iconst_0
    //   14: invokespecial 42	com/google/android/gms/internal/cz:<init>	(I)V
    //   17: astore_1
    //   18: aload_0
    //   19: invokevirtual 45	com/google/android/gms/internal/bh:c	()V
    //   22: aload_0
    //   23: getfield 17	com/google/android/gms/internal/bh:b	Lcom/google/android/gms/internal/bg;
    //   26: aload_1
    //   27: invokeinterface 50 2 0
    //   32: return
    //   33: aload_1
    //   34: aload_0
    //   35: getfield 15	com/google/android/gms/internal/bh:a	Lcom/google/android/gms/internal/cx;
    //   38: invokestatic 52	com/google/android/gms/internal/bh:a	(Lcom/google/android/gms/internal/bo;Lcom/google/android/gms/internal/cx;)Lcom/google/android/gms/internal/cz;
    //   41: astore_2
    //   42: aload_2
    //   43: astore_1
    //   44: aload_2
    //   45: ifnonnull -27 -> 18
    //   48: new 39	com/google/android/gms/internal/cz
    //   51: dup
    //   52: iconst_0
    //   53: invokespecial 42	com/google/android/gms/internal/cz:<init>	(I)V
    //   56: astore_1
    //   57: goto -39 -> 18
    //   60: astore_1
    //   61: aload_0
    //   62: invokevirtual 45	com/google/android/gms/internal/bh:c	()V
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	bh
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
  
  public final void b_()
  {
    c();
  }
  
  public abstract void c();
  
  public abstract bo d();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */