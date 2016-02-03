package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;

abstract class df
  extends b
{
  final TurnBasedMatch a;
  
  /* Error */
  df(com.google.android.gms.common.data.DataHolder paramDataHolder)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 10	com/google/android/gms/common/api/b:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
    //   5: new 12	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 13	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 17	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:getCount	()I
    //   18: ifle +28 -> 46
    //   21: aload_0
    //   22: aload_1
    //   23: iconst_0
    //   24: invokevirtual 21	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:get	(I)Ljava/lang/Object;
    //   27: checkcast 23	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch
    //   30: invokeinterface 27 1 0
    //   35: checkcast 23	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch
    //   38: putfield 29	com/google/android/gms/games/internal/df:a	Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;
    //   41: aload_1
    //   42: invokevirtual 33	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:close	()V
    //   45: return
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 29	com/google/android/gms/games/internal/df:a	Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;
    //   51: goto -10 -> 41
    //   54: astore_2
    //   55: aload_1
    //   56: invokevirtual 33	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:close	()V
    //   59: aload_2
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	df
    //   0	61	1	paramDataHolder	com.google.android.gms.common.data.DataHolder
    //   54	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	41	54	finally
    //   46	51	54	finally
  }
  
  public TurnBasedMatch getMatch()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */