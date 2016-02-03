package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardScoreBuffer
  extends DataBuffer<LeaderboardScore>
{
  private final LeaderboardScoreBufferHeader abn;
  
  public LeaderboardScoreBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    this.abn = new LeaderboardScoreBufferHeader(paramDataHolder.gz());
  }
  
  public LeaderboardScore get(int paramInt)
  {
    return new LeaderboardScoreRef(this.IC, paramInt);
  }
  
  public LeaderboardScoreBufferHeader ly()
  {
    return this.abn;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */