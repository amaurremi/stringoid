package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.Requests.SendRequestResult;

final class ct
  extends b
  implements Requests.SendRequestResult
{
  private final GameRequest a;
  
  /* Error */
  ct(com.google.android.gms.common.data.DataHolder paramDataHolder)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 12	com/google/android/gms/common/api/b:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
    //   5: new 14	com/google/android/gms/games/request/GameRequestBuffer
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 15	com/google/android/gms/games/request/GameRequestBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 19	com/google/android/gms/games/request/GameRequestBuffer:getCount	()I
    //   18: ifle +28 -> 46
    //   21: aload_0
    //   22: aload_1
    //   23: iconst_0
    //   24: invokevirtual 23	com/google/android/gms/games/request/GameRequestBuffer:get	(I)Ljava/lang/Object;
    //   27: checkcast 25	com/google/android/gms/games/request/GameRequest
    //   30: invokeinterface 29 1 0
    //   35: checkcast 25	com/google/android/gms/games/request/GameRequest
    //   38: putfield 31	com/google/android/gms/games/internal/ct:a	Lcom/google/android/gms/games/request/GameRequest;
    //   41: aload_1
    //   42: invokevirtual 35	com/google/android/gms/games/request/GameRequestBuffer:close	()V
    //   45: return
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 31	com/google/android/gms/games/internal/ct:a	Lcom/google/android/gms/games/request/GameRequest;
    //   51: goto -10 -> 41
    //   54: astore_2
    //   55: aload_1
    //   56: invokevirtual 35	com/google/android/gms/games/request/GameRequestBuffer:close	()V
    //   59: aload_2
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	ct
    //   0	61	1	paramDataHolder	com.google.android.gms.common.data.DataHolder
    //   54	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	41	54	finally
    //   46	51	54	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */