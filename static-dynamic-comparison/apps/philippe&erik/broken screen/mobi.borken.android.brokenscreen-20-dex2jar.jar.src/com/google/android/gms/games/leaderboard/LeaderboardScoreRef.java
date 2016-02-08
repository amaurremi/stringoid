package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class LeaderboardScoreRef
  extends d
  implements LeaderboardScore
{
  private final PlayerRef SD;
  
  LeaderboardScoreRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
    this.SD = new PlayerRef(paramDataHolder, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    return LeaderboardScoreEntity.a(this, paramObject);
  }
  
  public String getDisplayRank()
  {
    return getString("display_rank");
  }
  
  public void getDisplayRank(CharArrayBuffer paramCharArrayBuffer)
  {
    a("display_rank", paramCharArrayBuffer);
  }
  
  public String getDisplayScore()
  {
    return getString("display_score");
  }
  
  public void getDisplayScore(CharArrayBuffer paramCharArrayBuffer)
  {
    a("display_score", paramCharArrayBuffer);
  }
  
  public long getRank()
  {
    return getLong("rank");
  }
  
  public long getRawScore()
  {
    return getLong("raw_score");
  }
  
  public Player getScoreHolder()
  {
    if (ax("external_player_id")) {
      return null;
    }
    return this.SD;
  }
  
  public String getScoreHolderDisplayName()
  {
    if (ax("external_player_id")) {
      return getString("default_display_name");
    }
    return this.SD.getDisplayName();
  }
  
  public void getScoreHolderDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (ax("external_player_id"))
    {
      a("default_display_name", paramCharArrayBuffer);
      return;
    }
    this.SD.getDisplayName(paramCharArrayBuffer);
  }
  
  public Uri getScoreHolderHiResImageUri()
  {
    if (ax("external_player_id")) {
      return null;
    }
    return this.SD.getHiResImageUri();
  }
  
  public String getScoreHolderHiResImageUrl()
  {
    if (ax("external_player_id")) {
      return null;
    }
    return this.SD.getHiResImageUrl();
  }
  
  public Uri getScoreHolderIconImageUri()
  {
    if (ax("external_player_id")) {
      return aw("default_display_image_uri");
    }
    return this.SD.getIconImageUri();
  }
  
  public String getScoreHolderIconImageUrl()
  {
    if (ax("external_player_id")) {
      return getString("default_display_image_url");
    }
    return this.SD.getIconImageUrl();
  }
  
  public String getScoreTag()
  {
    return getString("score_tag");
  }
  
  public long getTimestampMillis()
  {
    return getLong("achieved_timestamp");
  }
  
  public int hashCode()
  {
    return LeaderboardScoreEntity.a(this);
  }
  
  public LeaderboardScore ix()
  {
    return new LeaderboardScoreEntity(this);
  }
  
  public String toString()
  {
    return LeaderboardScoreEntity.b(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardScoreRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */