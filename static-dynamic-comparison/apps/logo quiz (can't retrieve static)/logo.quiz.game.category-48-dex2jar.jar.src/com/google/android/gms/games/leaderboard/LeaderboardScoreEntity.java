package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.jv;

public final class LeaderboardScoreEntity
  implements LeaderboardScore
{
  private final long abo;
  private final String abp;
  private final String abq;
  private final long abr;
  private final long abs;
  private final String abt;
  private final Uri abu;
  private final Uri abv;
  private final PlayerEntity abw;
  private final String abx;
  private final String aby;
  private final String abz;
  
  public LeaderboardScoreEntity(LeaderboardScore paramLeaderboardScore)
  {
    this.abo = paramLeaderboardScore.getRank();
    this.abp = ((String)n.i(paramLeaderboardScore.getDisplayRank()));
    this.abq = ((String)n.i(paramLeaderboardScore.getDisplayScore()));
    this.abr = paramLeaderboardScore.getRawScore();
    this.abs = paramLeaderboardScore.getTimestampMillis();
    this.abt = paramLeaderboardScore.getScoreHolderDisplayName();
    this.abu = paramLeaderboardScore.getScoreHolderIconImageUri();
    this.abv = paramLeaderboardScore.getScoreHolderHiResImageUri();
    Object localObject = paramLeaderboardScore.getScoreHolder();
    if (localObject == null) {}
    for (localObject = null;; localObject = (PlayerEntity)((Player)localObject).freeze())
    {
      this.abw = ((PlayerEntity)localObject);
      this.abx = paramLeaderboardScore.getScoreTag();
      this.aby = paramLeaderboardScore.getScoreHolderIconImageUrl();
      this.abz = paramLeaderboardScore.getScoreHolderHiResImageUrl();
      return;
    }
  }
  
  static int a(LeaderboardScore paramLeaderboardScore)
  {
    return m.hashCode(new Object[] { Long.valueOf(paramLeaderboardScore.getRank()), paramLeaderboardScore.getDisplayRank(), Long.valueOf(paramLeaderboardScore.getRawScore()), paramLeaderboardScore.getDisplayScore(), Long.valueOf(paramLeaderboardScore.getTimestampMillis()), paramLeaderboardScore.getScoreHolderDisplayName(), paramLeaderboardScore.getScoreHolderIconImageUri(), paramLeaderboardScore.getScoreHolderHiResImageUri(), paramLeaderboardScore.getScoreHolder() });
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
      if ((!m.equal(Long.valueOf(((LeaderboardScore)paramObject).getRank()), Long.valueOf(paramLeaderboardScore.getRank()))) || (!m.equal(((LeaderboardScore)paramObject).getDisplayRank(), paramLeaderboardScore.getDisplayRank())) || (!m.equal(Long.valueOf(((LeaderboardScore)paramObject).getRawScore()), Long.valueOf(paramLeaderboardScore.getRawScore()))) || (!m.equal(((LeaderboardScore)paramObject).getDisplayScore(), paramLeaderboardScore.getDisplayScore())) || (!m.equal(Long.valueOf(((LeaderboardScore)paramObject).getTimestampMillis()), Long.valueOf(paramLeaderboardScore.getTimestampMillis()))) || (!m.equal(((LeaderboardScore)paramObject).getScoreHolderDisplayName(), paramLeaderboardScore.getScoreHolderDisplayName())) || (!m.equal(((LeaderboardScore)paramObject).getScoreHolderIconImageUri(), paramLeaderboardScore.getScoreHolderIconImageUri())) || (!m.equal(((LeaderboardScore)paramObject).getScoreHolderHiResImageUri(), paramLeaderboardScore.getScoreHolderHiResImageUri())) || (!m.equal(((LeaderboardScore)paramObject).getScoreHolder(), paramLeaderboardScore.getScoreHolder()))) {
        break;
      }
      bool1 = bool2;
    } while (m.equal(((LeaderboardScore)paramObject).getScoreTag(), paramLeaderboardScore.getScoreTag()));
    return false;
  }
  
  static String b(LeaderboardScore paramLeaderboardScore)
  {
    m.a locala = m.h(paramLeaderboardScore).a("Rank", Long.valueOf(paramLeaderboardScore.getRank())).a("DisplayRank", paramLeaderboardScore.getDisplayRank()).a("Score", Long.valueOf(paramLeaderboardScore.getRawScore())).a("DisplayScore", paramLeaderboardScore.getDisplayScore()).a("Timestamp", Long.valueOf(paramLeaderboardScore.getTimestampMillis())).a("DisplayName", paramLeaderboardScore.getScoreHolderDisplayName()).a("IconImageUri", paramLeaderboardScore.getScoreHolderIconImageUri()).a("IconImageUrl", paramLeaderboardScore.getScoreHolderIconImageUrl()).a("HiResImageUri", paramLeaderboardScore.getScoreHolderHiResImageUri()).a("HiResImageUrl", paramLeaderboardScore.getScoreHolderHiResImageUrl());
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
    return this.abp;
  }
  
  public void getDisplayRank(CharArrayBuffer paramCharArrayBuffer)
  {
    jv.b(this.abp, paramCharArrayBuffer);
  }
  
  public String getDisplayScore()
  {
    return this.abq;
  }
  
  public void getDisplayScore(CharArrayBuffer paramCharArrayBuffer)
  {
    jv.b(this.abq, paramCharArrayBuffer);
  }
  
  public long getRank()
  {
    return this.abo;
  }
  
  public long getRawScore()
  {
    return this.abr;
  }
  
  public Player getScoreHolder()
  {
    return this.abw;
  }
  
  public String getScoreHolderDisplayName()
  {
    if (this.abw == null) {
      return this.abt;
    }
    return this.abw.getDisplayName();
  }
  
  public void getScoreHolderDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (this.abw == null)
    {
      jv.b(this.abt, paramCharArrayBuffer);
      return;
    }
    this.abw.getDisplayName(paramCharArrayBuffer);
  }
  
  public Uri getScoreHolderHiResImageUri()
  {
    if (this.abw == null) {
      return this.abv;
    }
    return this.abw.getHiResImageUri();
  }
  
  public String getScoreHolderHiResImageUrl()
  {
    if (this.abw == null) {
      return this.abz;
    }
    return this.abw.getHiResImageUrl();
  }
  
  public Uri getScoreHolderIconImageUri()
  {
    if (this.abw == null) {
      return this.abu;
    }
    return this.abw.getIconImageUri();
  }
  
  public String getScoreHolderIconImageUrl()
  {
    if (this.abw == null) {
      return this.aby;
    }
    return this.abw.getIconImageUrl();
  }
  
  public String getScoreTag()
  {
    return this.abx;
  }
  
  public long getTimestampMillis()
  {
    return this.abs;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public LeaderboardScore lA()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardScoreEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */