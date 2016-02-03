package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.hn;
import com.google.android.gms.internal.il;

public final class LeaderboardScoreEntity
  implements LeaderboardScore
{
  private final String SA;
  private final String SB;
  private final String SC;
  private final long Sr;
  private final String Ss;
  private final String St;
  private final long Su;
  private final long Sv;
  private final String Sw;
  private final Uri Sx;
  private final Uri Sy;
  private final PlayerEntity Sz;
  
  public LeaderboardScoreEntity(LeaderboardScore paramLeaderboardScore)
  {
    this.Sr = paramLeaderboardScore.getRank();
    this.Ss = ((String)hn.f(paramLeaderboardScore.getDisplayRank()));
    this.St = ((String)hn.f(paramLeaderboardScore.getDisplayScore()));
    this.Su = paramLeaderboardScore.getRawScore();
    this.Sv = paramLeaderboardScore.getTimestampMillis();
    this.Sw = paramLeaderboardScore.getScoreHolderDisplayName();
    this.Sx = paramLeaderboardScore.getScoreHolderIconImageUri();
    this.Sy = paramLeaderboardScore.getScoreHolderHiResImageUri();
    Object localObject = paramLeaderboardScore.getScoreHolder();
    if (localObject == null) {}
    for (localObject = null;; localObject = (PlayerEntity)((Player)localObject).freeze())
    {
      this.Sz = ((PlayerEntity)localObject);
      this.SA = paramLeaderboardScore.getScoreTag();
      this.SB = paramLeaderboardScore.getScoreHolderIconImageUrl();
      this.SC = paramLeaderboardScore.getScoreHolderHiResImageUrl();
      return;
    }
  }
  
  static int a(LeaderboardScore paramLeaderboardScore)
  {
    return hl.hashCode(new Object[] { Long.valueOf(paramLeaderboardScore.getRank()), paramLeaderboardScore.getDisplayRank(), Long.valueOf(paramLeaderboardScore.getRawScore()), paramLeaderboardScore.getDisplayScore(), Long.valueOf(paramLeaderboardScore.getTimestampMillis()), paramLeaderboardScore.getScoreHolderDisplayName(), paramLeaderboardScore.getScoreHolderIconImageUri(), paramLeaderboardScore.getScoreHolderHiResImageUri(), paramLeaderboardScore.getScoreHolder() });
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
      if ((!hl.equal(Long.valueOf(((LeaderboardScore)paramObject).getRank()), Long.valueOf(paramLeaderboardScore.getRank()))) || (!hl.equal(((LeaderboardScore)paramObject).getDisplayRank(), paramLeaderboardScore.getDisplayRank())) || (!hl.equal(Long.valueOf(((LeaderboardScore)paramObject).getRawScore()), Long.valueOf(paramLeaderboardScore.getRawScore()))) || (!hl.equal(((LeaderboardScore)paramObject).getDisplayScore(), paramLeaderboardScore.getDisplayScore())) || (!hl.equal(Long.valueOf(((LeaderboardScore)paramObject).getTimestampMillis()), Long.valueOf(paramLeaderboardScore.getTimestampMillis()))) || (!hl.equal(((LeaderboardScore)paramObject).getScoreHolderDisplayName(), paramLeaderboardScore.getScoreHolderDisplayName())) || (!hl.equal(((LeaderboardScore)paramObject).getScoreHolderIconImageUri(), paramLeaderboardScore.getScoreHolderIconImageUri())) || (!hl.equal(((LeaderboardScore)paramObject).getScoreHolderHiResImageUri(), paramLeaderboardScore.getScoreHolderHiResImageUri())) || (!hl.equal(((LeaderboardScore)paramObject).getScoreHolder(), paramLeaderboardScore.getScoreHolder()))) {
        break;
      }
      bool1 = bool2;
    } while (hl.equal(((LeaderboardScore)paramObject).getScoreTag(), paramLeaderboardScore.getScoreTag()));
    return false;
  }
  
  static String b(LeaderboardScore paramLeaderboardScore)
  {
    hl.a locala = hl.e(paramLeaderboardScore).a("Rank", Long.valueOf(paramLeaderboardScore.getRank())).a("DisplayRank", paramLeaderboardScore.getDisplayRank()).a("Score", Long.valueOf(paramLeaderboardScore.getRawScore())).a("DisplayScore", paramLeaderboardScore.getDisplayScore()).a("Timestamp", Long.valueOf(paramLeaderboardScore.getTimestampMillis())).a("DisplayName", paramLeaderboardScore.getScoreHolderDisplayName()).a("IconImageUri", paramLeaderboardScore.getScoreHolderIconImageUri()).a("IconImageUrl", paramLeaderboardScore.getScoreHolderIconImageUrl()).a("HiResImageUri", paramLeaderboardScore.getScoreHolderHiResImageUri()).a("HiResImageUrl", paramLeaderboardScore.getScoreHolderHiResImageUrl());
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
    return this.Ss;
  }
  
  public void getDisplayRank(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.Ss, paramCharArrayBuffer);
  }
  
  public String getDisplayScore()
  {
    return this.St;
  }
  
  public void getDisplayScore(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.St, paramCharArrayBuffer);
  }
  
  public long getRank()
  {
    return this.Sr;
  }
  
  public long getRawScore()
  {
    return this.Su;
  }
  
  public Player getScoreHolder()
  {
    return this.Sz;
  }
  
  public String getScoreHolderDisplayName()
  {
    if (this.Sz == null) {
      return this.Sw;
    }
    return this.Sz.getDisplayName();
  }
  
  public void getScoreHolderDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (this.Sz == null)
    {
      il.b(this.Sw, paramCharArrayBuffer);
      return;
    }
    this.Sz.getDisplayName(paramCharArrayBuffer);
  }
  
  public Uri getScoreHolderHiResImageUri()
  {
    if (this.Sz == null) {
      return this.Sy;
    }
    return this.Sz.getHiResImageUri();
  }
  
  public String getScoreHolderHiResImageUrl()
  {
    if (this.Sz == null) {
      return this.SC;
    }
    return this.Sz.getHiResImageUrl();
  }
  
  public Uri getScoreHolderIconImageUri()
  {
    if (this.Sz == null) {
      return this.Sx;
    }
    return this.Sz.getIconImageUri();
  }
  
  public String getScoreHolderIconImageUrl()
  {
    if (this.Sz == null) {
      return this.SB;
    }
    return this.Sz.getIconImageUrl();
  }
  
  public String getScoreTag()
  {
    return this.SA;
  }
  
  public long getTimestampMillis()
  {
    return this.Sv;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public LeaderboardScore ix()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardScoreEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */