package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hk.a;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.ik;

public final class LeaderboardScoreEntity
  implements LeaderboardScore
{
  private final Uri SA;
  private final Uri SB;
  private final PlayerEntity SC;
  private final String SD;
  private final String SE;
  private final String SF;
  private final long Su;
  private final String Sv;
  private final String Sw;
  private final long Sx;
  private final long Sy;
  private final String Sz;
  
  public LeaderboardScoreEntity(LeaderboardScore paramLeaderboardScore)
  {
    this.Su = paramLeaderboardScore.getRank();
    this.Sv = ((String)hm.f(paramLeaderboardScore.getDisplayRank()));
    this.Sw = ((String)hm.f(paramLeaderboardScore.getDisplayScore()));
    this.Sx = paramLeaderboardScore.getRawScore();
    this.Sy = paramLeaderboardScore.getTimestampMillis();
    this.Sz = paramLeaderboardScore.getScoreHolderDisplayName();
    this.SA = paramLeaderboardScore.getScoreHolderIconImageUri();
    this.SB = paramLeaderboardScore.getScoreHolderHiResImageUri();
    Object localObject = paramLeaderboardScore.getScoreHolder();
    if (localObject == null) {}
    for (localObject = null;; localObject = (PlayerEntity)((Player)localObject).freeze())
    {
      this.SC = ((PlayerEntity)localObject);
      this.SD = paramLeaderboardScore.getScoreTag();
      this.SE = paramLeaderboardScore.getScoreHolderIconImageUrl();
      this.SF = paramLeaderboardScore.getScoreHolderHiResImageUrl();
      return;
    }
  }
  
  static int a(LeaderboardScore paramLeaderboardScore)
  {
    return hk.hashCode(new Object[] { Long.valueOf(paramLeaderboardScore.getRank()), paramLeaderboardScore.getDisplayRank(), Long.valueOf(paramLeaderboardScore.getRawScore()), paramLeaderboardScore.getDisplayScore(), Long.valueOf(paramLeaderboardScore.getTimestampMillis()), paramLeaderboardScore.getScoreHolderDisplayName(), paramLeaderboardScore.getScoreHolderIconImageUri(), paramLeaderboardScore.getScoreHolderHiResImageUri(), paramLeaderboardScore.getScoreHolder() });
  }
  
  static boolean a(LeaderboardScore paramLeaderboardScore, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof LeaderboardScore)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramLeaderboardScore == paramObject);
      paramObject = (LeaderboardScore)paramObject;
      if ((!hk.equal(Long.valueOf(((LeaderboardScore)paramObject).getRank()), Long.valueOf(paramLeaderboardScore.getRank()))) || (!hk.equal(((LeaderboardScore)paramObject).getDisplayRank(), paramLeaderboardScore.getDisplayRank())) || (!hk.equal(Long.valueOf(((LeaderboardScore)paramObject).getRawScore()), Long.valueOf(paramLeaderboardScore.getRawScore()))) || (!hk.equal(((LeaderboardScore)paramObject).getDisplayScore(), paramLeaderboardScore.getDisplayScore())) || (!hk.equal(Long.valueOf(((LeaderboardScore)paramObject).getTimestampMillis()), Long.valueOf(paramLeaderboardScore.getTimestampMillis()))) || (!hk.equal(((LeaderboardScore)paramObject).getScoreHolderDisplayName(), paramLeaderboardScore.getScoreHolderDisplayName())) || (!hk.equal(((LeaderboardScore)paramObject).getScoreHolderIconImageUri(), paramLeaderboardScore.getScoreHolderIconImageUri())) || (!hk.equal(((LeaderboardScore)paramObject).getScoreHolderHiResImageUri(), paramLeaderboardScore.getScoreHolderHiResImageUri())) || (!hk.equal(((LeaderboardScore)paramObject).getScoreHolder(), paramLeaderboardScore.getScoreHolder()))) {
        break;
      }
      bool1 = bool2;
    } while (hk.equal(((LeaderboardScore)paramObject).getScoreTag(), paramLeaderboardScore.getScoreTag()));
    return false;
  }
  
  static String b(LeaderboardScore paramLeaderboardScore)
  {
    hk.a locala = hk.e(paramLeaderboardScore).a("Rank", Long.valueOf(paramLeaderboardScore.getRank())).a("DisplayRank", paramLeaderboardScore.getDisplayRank()).a("Score", Long.valueOf(paramLeaderboardScore.getRawScore())).a("DisplayScore", paramLeaderboardScore.getDisplayScore()).a("Timestamp", Long.valueOf(paramLeaderboardScore.getTimestampMillis())).a("DisplayName", paramLeaderboardScore.getScoreHolderDisplayName()).a("IconImageUri", paramLeaderboardScore.getScoreHolderIconImageUri()).a("IconImageUrl", paramLeaderboardScore.getScoreHolderIconImageUrl()).a("HiResImageUri", paramLeaderboardScore.getScoreHolderHiResImageUri()).a("HiResImageUrl", paramLeaderboardScore.getScoreHolderHiResImageUrl());
    if (paramLeaderboardScore.getScoreHolder() == null) {}
    for (Object localObject = null;; localObject = paramLeaderboardScore.getScoreHolder()) {
      return locala.a("Player", localObject).a("ScoreTag", paramLeaderboardScore.getScoreTag()).toString();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public String getDisplayRank()
  {
    return this.Sv;
  }
  
  public void getDisplayRank(CharArrayBuffer paramCharArrayBuffer)
  {
    ik.b(this.Sv, paramCharArrayBuffer);
  }
  
  public String getDisplayScore()
  {
    return this.Sw;
  }
  
  public void getDisplayScore(CharArrayBuffer paramCharArrayBuffer)
  {
    ik.b(this.Sw, paramCharArrayBuffer);
  }
  
  public long getRank()
  {
    return this.Su;
  }
  
  public long getRawScore()
  {
    return this.Sx;
  }
  
  public Player getScoreHolder()
  {
    return this.SC;
  }
  
  public String getScoreHolderDisplayName()
  {
    if (this.SC == null) {
      return this.Sz;
    }
    return this.SC.getDisplayName();
  }
  
  public void getScoreHolderDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (this.SC == null)
    {
      ik.b(this.Sz, paramCharArrayBuffer);
      return;
    }
    this.SC.getDisplayName(paramCharArrayBuffer);
  }
  
  public Uri getScoreHolderHiResImageUri()
  {
    if (this.SC == null) {
      return this.SB;
    }
    return this.SC.getHiResImageUri();
  }
  
  public String getScoreHolderHiResImageUrl()
  {
    if (this.SC == null) {
      return this.SF;
    }
    return this.SC.getHiResImageUrl();
  }
  
  public Uri getScoreHolderIconImageUri()
  {
    if (this.SC == null) {
      return this.SA;
    }
    return this.SC.getIconImageUri();
  }
  
  public String getScoreHolderIconImageUrl()
  {
    if (this.SC == null) {
      return this.SE;
    }
    return this.SC.getIconImageUrl();
  }
  
  public String getScoreTag()
  {
    return this.SD;
  }
  
  public long getTimestampMillis()
  {
    return this.Sy;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public LeaderboardScore iC()
  {
    return this;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return b(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardScoreEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */