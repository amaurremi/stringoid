package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;
import com.google.android.gms.games.Player;

public final class e
  extends b
  implements LeaderboardScore
{
  private final com.google.android.gms.games.d vU;
  
  e(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
    this.vU = new com.google.android.gms.games.d(paramDataHolder, paramInt);
  }
  
  public LeaderboardScore ds()
  {
    return new d(this);
  }
  
  public boolean equals(Object paramObject)
  {
    return d.a(this, paramObject);
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
    if (M("external_player_id")) {
      return null;
    }
    return this.vU;
  }
  
  public String getScoreHolderDisplayName()
  {
    if (M("external_player_id")) {
      return getString("default_display_name");
    }
    return this.vU.getDisplayName();
  }
  
  public void getScoreHolderDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (M("external_player_id"))
    {
      a("default_display_name", paramCharArrayBuffer);
      return;
    }
    this.vU.getDisplayName(paramCharArrayBuffer);
  }
  
  public Uri getScoreHolderHiResImageUri()
  {
    if (M("external_player_id")) {
      return null;
    }
    return this.vU.getHiResImageUri();
  }
  
  public Uri getScoreHolderIconImageUri()
  {
    if (M("external_player_id")) {
      return L("default_display_image_uri");
    }
    return this.vU.getIconImageUri();
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
    return d.a(this);
  }
  
  public String toString()
  {
    return d.b(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/games/leaderboard/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */