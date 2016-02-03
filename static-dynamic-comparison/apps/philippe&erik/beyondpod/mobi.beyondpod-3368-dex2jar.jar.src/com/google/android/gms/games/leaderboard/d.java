package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.ee.a;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.fc;

public final class d
  implements LeaderboardScore
{
  private final long vK;
  private final String vL;
  private final String vM;
  private final long vN;
  private final long vO;
  private final String vP;
  private final Uri vQ;
  private final Uri vR;
  private final PlayerEntity vS;
  private final String vT;
  
  public d(LeaderboardScore paramLeaderboardScore)
  {
    this.vK = paramLeaderboardScore.getRank();
    this.vL = ((String)eg.f(paramLeaderboardScore.getDisplayRank()));
    this.vM = ((String)eg.f(paramLeaderboardScore.getDisplayScore()));
    this.vN = paramLeaderboardScore.getRawScore();
    this.vO = paramLeaderboardScore.getTimestampMillis();
    this.vP = paramLeaderboardScore.getScoreHolderDisplayName();
    this.vQ = paramLeaderboardScore.getScoreHolderIconImageUri();
    this.vR = paramLeaderboardScore.getScoreHolderHiResImageUri();
    Object localObject = paramLeaderboardScore.getScoreHolder();
    if (localObject == null) {}
    for (localObject = null;; localObject = (PlayerEntity)((Player)localObject).freeze())
    {
      this.vS = ((PlayerEntity)localObject);
      this.vT = paramLeaderboardScore.getScoreTag();
      return;
    }
  }
  
  static int a(LeaderboardScore paramLeaderboardScore)
  {
    return ee.hashCode(new Object[] { Long.valueOf(paramLeaderboardScore.getRank()), paramLeaderboardScore.getDisplayRank(), Long.valueOf(paramLeaderboardScore.getRawScore()), paramLeaderboardScore.getDisplayScore(), Long.valueOf(paramLeaderboardScore.getTimestampMillis()), paramLeaderboardScore.getScoreHolderDisplayName(), paramLeaderboardScore.getScoreHolderIconImageUri(), paramLeaderboardScore.getScoreHolderHiResImageUri(), paramLeaderboardScore.getScoreHolder() });
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
      if ((!ee.equal(Long.valueOf(((LeaderboardScore)paramObject).getRank()), Long.valueOf(paramLeaderboardScore.getRank()))) || (!ee.equal(((LeaderboardScore)paramObject).getDisplayRank(), paramLeaderboardScore.getDisplayRank())) || (!ee.equal(Long.valueOf(((LeaderboardScore)paramObject).getRawScore()), Long.valueOf(paramLeaderboardScore.getRawScore()))) || (!ee.equal(((LeaderboardScore)paramObject).getDisplayScore(), paramLeaderboardScore.getDisplayScore())) || (!ee.equal(Long.valueOf(((LeaderboardScore)paramObject).getTimestampMillis()), Long.valueOf(paramLeaderboardScore.getTimestampMillis()))) || (!ee.equal(((LeaderboardScore)paramObject).getScoreHolderDisplayName(), paramLeaderboardScore.getScoreHolderDisplayName())) || (!ee.equal(((LeaderboardScore)paramObject).getScoreHolderIconImageUri(), paramLeaderboardScore.getScoreHolderIconImageUri())) || (!ee.equal(((LeaderboardScore)paramObject).getScoreHolderHiResImageUri(), paramLeaderboardScore.getScoreHolderHiResImageUri())) || (!ee.equal(((LeaderboardScore)paramObject).getScoreHolder(), paramLeaderboardScore.getScoreHolder()))) {
        break;
      }
      bool1 = bool2;
    } while (ee.equal(((LeaderboardScore)paramObject).getScoreTag(), paramLeaderboardScore.getScoreTag()));
    return false;
  }
  
  static String b(LeaderboardScore paramLeaderboardScore)
  {
    ee.a locala = ee.e(paramLeaderboardScore).a("Rank", Long.valueOf(paramLeaderboardScore.getRank())).a("DisplayRank", paramLeaderboardScore.getDisplayRank()).a("Score", Long.valueOf(paramLeaderboardScore.getRawScore())).a("DisplayScore", paramLeaderboardScore.getDisplayScore()).a("Timestamp", Long.valueOf(paramLeaderboardScore.getTimestampMillis())).a("DisplayName", paramLeaderboardScore.getScoreHolderDisplayName()).a("IconImageUri", paramLeaderboardScore.getScoreHolderIconImageUri()).a("HiResImageUri", paramLeaderboardScore.getScoreHolderHiResImageUri());
    if (paramLeaderboardScore.getScoreHolder() == null) {}
    for (Object localObject = null;; localObject = paramLeaderboardScore.getScoreHolder()) {
      return locala.a("Player", localObject).a("ScoreTag", paramLeaderboardScore.getScoreTag()).toString();
    }
  }
  
  public LeaderboardScore ds()
  {
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public String getDisplayRank()
  {
    return this.vL;
  }
  
  public void getDisplayRank(CharArrayBuffer paramCharArrayBuffer)
  {
    fc.b(this.vL, paramCharArrayBuffer);
  }
  
  public String getDisplayScore()
  {
    return this.vM;
  }
  
  public void getDisplayScore(CharArrayBuffer paramCharArrayBuffer)
  {
    fc.b(this.vM, paramCharArrayBuffer);
  }
  
  public long getRank()
  {
    return this.vK;
  }
  
  public long getRawScore()
  {
    return this.vN;
  }
  
  public Player getScoreHolder()
  {
    return this.vS;
  }
  
  public String getScoreHolderDisplayName()
  {
    if (this.vS == null) {
      return this.vP;
    }
    return this.vS.getDisplayName();
  }
  
  public void getScoreHolderDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (this.vS == null)
    {
      fc.b(this.vP, paramCharArrayBuffer);
      return;
    }
    this.vS.getDisplayName(paramCharArrayBuffer);
  }
  
  public Uri getScoreHolderHiResImageUri()
  {
    if (this.vS == null) {
      return this.vR;
    }
    return this.vS.getHiResImageUri();
  }
  
  public Uri getScoreHolderIconImageUri()
  {
    if (this.vS == null) {
      return this.vQ;
    }
    return this.vS.getIconImageUri();
  }
  
  public String getScoreTag()
  {
    return this.vT;
  }
  
  public long getTimestampMillis()
  {
    return this.vO;
  }
  
  public int hashCode()
  {
    return a(this);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/games/leaderboard/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */