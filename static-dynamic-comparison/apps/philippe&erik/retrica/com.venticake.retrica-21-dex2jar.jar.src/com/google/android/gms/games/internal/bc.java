package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;

final class bc
  extends b
  implements Leaderboards.LoadScoresResult
{
  private final LeaderboardEntity a;
  private final LeaderboardScoreBuffer b;
  
  /* Error */
  bc(com.google.android.gms.common.data.DataHolder paramDataHolder1, com.google.android.gms.common.data.DataHolder paramDataHolder2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokespecial 15	com/google/android/gms/common/api/b:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
    //   5: new 17	com/google/android/gms/games/leaderboard/LeaderboardBuffer
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 18	com/google/android/gms/games/leaderboard/LeaderboardBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 22	com/google/android/gms/games/leaderboard/LeaderboardBuffer:getCount	()I
    //   18: ifle +40 -> 58
    //   21: aload_0
    //   22: aload_1
    //   23: iconst_0
    //   24: invokevirtual 26	com/google/android/gms/games/leaderboard/LeaderboardBuffer:get	(I)Ljava/lang/Object;
    //   27: checkcast 28	com/google/android/gms/games/leaderboard/Leaderboard
    //   30: invokeinterface 32 1 0
    //   35: checkcast 34	com/google/android/gms/games/leaderboard/LeaderboardEntity
    //   38: putfield 36	com/google/android/gms/games/internal/bc:a	Lcom/google/android/gms/games/leaderboard/LeaderboardEntity;
    //   41: aload_1
    //   42: invokevirtual 40	com/google/android/gms/games/leaderboard/LeaderboardBuffer:close	()V
    //   45: aload_0
    //   46: new 42	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer
    //   49: dup
    //   50: aload_2
    //   51: invokespecial 43	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
    //   54: putfield 45	com/google/android/gms/games/internal/bc:b	Lcom/google/android/gms/games/leaderboard/LeaderboardScoreBuffer;
    //   57: return
    //   58: aload_0
    //   59: aconst_null
    //   60: putfield 36	com/google/android/gms/games/internal/bc:a	Lcom/google/android/gms/games/leaderboard/LeaderboardEntity;
    //   63: goto -22 -> 41
    //   66: astore_2
    //   67: aload_1
    //   68: invokevirtual 40	com/google/android/gms/games/leaderboard/LeaderboardBuffer:close	()V
    //   71: aload_2
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	bc
    //   0	73	1	paramDataHolder1	com.google.android.gms.common.data.DataHolder
    //   0	73	2	paramDataHolder2	com.google.android.gms.common.data.DataHolder
    // Exception table:
    //   from	to	target	type
    //   14	41	66	finally
    //   58	63	66	finally
  }
  
  public Leaderboard getLeaderboard()
  {
    return this.a;
  }
  
  public LeaderboardScoreBuffer getScores()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */