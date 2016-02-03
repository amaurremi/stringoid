package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class LeaderboardVariantRef
  extends d
  implements LeaderboardVariant
{
  LeaderboardVariantRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    return LeaderboardVariantEntity.a(this, paramObject);
  }
  
  public int getCollection()
  {
    return getInteger("collection");
  }
  
  public String getDisplayPlayerRank()
  {
    return getString("player_display_rank");
  }
  
  public String getDisplayPlayerScore()
  {
    return getString("player_display_score");
  }
  
  public long getNumScores()
  {
    if (ax("total_scores")) {
      return -1L;
    }
    return getLong("total_scores");
  }
  
  public long getPlayerRank()
  {
    if (ax("player_rank")) {
      return -1L;
    }
    return getLong("player_rank");
  }
  
  public String getPlayerScoreTag()
  {
    return getString("player_score_tag");
  }
  
  public long getRawPlayerScore()
  {
    if (ax("player_raw_score")) {
      return -1L;
    }
    return getLong("player_raw_score");
  }
  
  public int getTimeSpan()
  {
    return getInteger("timespan");
  }
  
  public boolean hasPlayerInfo()
  {
    return !ax("player_raw_score");
  }
  
  public int hashCode()
  {
    return LeaderboardVariantEntity.a(this);
  }
  
  public String iA()
  {
    return getString("window_page_token_next");
  }
  
  public LeaderboardVariant iB()
  {
    return new LeaderboardVariantEntity(this);
  }
  
  public String iy()
  {
    return getString("top_page_token_next");
  }
  
  public String iz()
  {
    return getString("window_page_token_prev");
  }
  
  public String toString()
  {
    return LeaderboardVariantEntity.b(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardVariantRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */