package com.google.android.gms.internal;

import android.os.RemoteException;

public abstract class dq
  extends em
{
  private final ds ne;
  private final dp.a pT;
  
  public dq(ds paramds, dp.a parama)
  {
    this.ne = paramds;
    this.pT = parama;
  }
  
  private static du a(dw paramdw, ds paramds)
  {
    try
    {
      paramdw = paramdw.b(paramds);
      return paramdw;
    }
    catch (RemoteException paramdw)
    {
      eu.c("Could not fetch ad response from ad request service.", paramdw);
      return null;
    }
    catch (NullPointerException paramdw)
    {
      eu.c("Could not fetch ad response from ad request service due to an Exception.", paramdw);
      return null;
    }
    catch (SecurityException paramdw)
    {
      eu.c("Could not fetch ad response from ad request service due to an Exception.", paramdw);
    }
    return null;
  }
  
  /* Error */
  public final void bh()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 47	com/google/android/gms/internal/dq:bt	()Lcom/google/android/gms/internal/dw;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +27 -> 33
    //   9: new 49	com/google/android/gms/internal/du
    //   12: dup
    //   13: iconst_0
    //   14: invokespecial 52	com/google/android/gms/internal/du:<init>	(I)V
    //   17: astore_1
    //   18: aload_0
    //   19: invokevirtual 55	com/google/android/gms/internal/dq:bs	()V
    //   22: aload_0
    //   23: getfield 17	com/google/android/gms/internal/dq:pT	Lcom/google/android/gms/internal/dp$a;
    //   26: aload_1
    //   27: invokeinterface 60 2 0
    //   32: return
    //   33: aload_1
    //   34: aload_0
    //   35: getfield 15	com/google/android/gms/internal/dq:ne	Lcom/google/android/gms/internal/ds;
    //   38: invokestatic 62	com/google/android/gms/internal/dq:a	(Lcom/google/android/gms/internal/dw;Lcom/google/android/gms/internal/ds;)Lcom/google/android/gms/internal/du;
    //   41: astore_2
    //   42: aload_2
    //   43: astore_1
    //   44: aload_2
    //   45: ifnonnull -27 -> 18
    //   48: new 49	com/google/android/gms/internal/du
    //   51: dup
    //   52: iconst_0
    //   53: invokespecial 52	com/google/android/gms/internal/du:<init>	(I)V
    //   56: astore_1
    //   57: goto -39 -> 18
    //   60: astore_1
    //   61: aload_0
    //   62: invokevirtual 55	com/google/android/gms/internal/dq:bs	()V
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	dq
    //   4	53	1	localObject1	Object
    //   60	6	1	localObject2	Object
    //   41	4	2	localdu	du
    // Exception table:
    //   from	to	target	type
    //   0	5	60	finally
    //   9	18	60	finally
    //   33	42	60	finally
    //   48	57	60	finally
  }
  
  public abstract void bs();
  
  public abstract dw bt();
  
  public final void onStop()
  {
    bs();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/dq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */