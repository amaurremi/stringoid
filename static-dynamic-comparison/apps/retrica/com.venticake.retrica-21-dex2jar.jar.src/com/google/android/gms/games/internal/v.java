package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;

final class v
  implements Notifications.GameMuteStatusLoadResult
{
  private final Status a;
  private final String b;
  private final boolean c;
  
  /* Error */
  public v(com.google.android.gms.common.data.DataHolder paramDataHolder)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 17	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: new 19	com/google/android/gms/common/api/Status
    //   8: dup
    //   9: aload_1
    //   10: invokevirtual 25	com/google/android/gms/common/data/DataHolder:getStatusCode	()I
    //   13: invokespecial 28	com/google/android/gms/common/api/Status:<init>	(I)V
    //   16: putfield 30	com/google/android/gms/games/internal/v:a	Lcom/google/android/gms/common/api/Status;
    //   19: aload_1
    //   20: invokevirtual 33	com/google/android/gms/common/data/DataHolder:getCount	()I
    //   23: ifle +32 -> 55
    //   26: aload_0
    //   27: aload_1
    //   28: ldc 35
    //   30: iconst_0
    //   31: iconst_0
    //   32: invokevirtual 38	com/google/android/gms/common/data/DataHolder:c	(Ljava/lang/String;II)Ljava/lang/String;
    //   35: putfield 40	com/google/android/gms/games/internal/v:b	Ljava/lang/String;
    //   38: aload_0
    //   39: aload_1
    //   40: ldc 42
    //   42: iconst_0
    //   43: iconst_0
    //   44: invokevirtual 46	com/google/android/gms/common/data/DataHolder:d	(Ljava/lang/String;II)Z
    //   47: putfield 48	com/google/android/gms/games/internal/v:c	Z
    //   50: aload_1
    //   51: invokevirtual 51	com/google/android/gms/common/data/DataHolder:close	()V
    //   54: return
    //   55: aload_0
    //   56: aconst_null
    //   57: putfield 40	com/google/android/gms/games/internal/v:b	Ljava/lang/String;
    //   60: aload_0
    //   61: iconst_0
    //   62: putfield 48	com/google/android/gms/games/internal/v:c	Z
    //   65: goto -15 -> 50
    //   68: astore_2
    //   69: aload_1
    //   70: invokevirtual 51	com/google/android/gms/common/data/DataHolder:close	()V
    //   73: aload_2
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	v
    //   0	75	1	paramDataHolder	com.google.android.gms.common.data.DataHolder
    //   68	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	50	68	finally
    //   55	65	68	finally
  }
  
  public Status getStatus()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */