package com.google.android.gms.games.leaderboard;

import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.ee.a;
import com.google.android.gms.internal.gc;
import com.google.android.gms.internal.ge;

public final class f
  implements LeaderboardVariant
{
  private final int vV;
  private final int vW;
  private final boolean vX;
  private final long vY;
  private final String vZ;
  private final long wa;
  private final String wb;
  private final String wc;
  private final long wd;
  private final String we;
  private final String wf;
  private final String wg;
  
  public f(LeaderboardVariant paramLeaderboardVariant)
  {
    this.vV = paramLeaderboardVariant.getTimeSpan();
    this.vW = paramLeaderboardVariant.getCollection();
    this.vX = paramLeaderboardVariant.hasPlayerInfo();
    this.vY = paramLeaderboardVariant.getRawPlayerScore();
    this.vZ = paramLeaderboardVariant.getDisplayPlayerScore();
    this.wa = paramLeaderboardVariant.getPlayerRank();
    this.wb = paramLeaderboardVariant.getDisplayPlayerRank();
    this.wc = paramLeaderboardVariant.getPlayerScoreTag();
    this.wd = paramLeaderboardVariant.getNumScores();
    this.we = paramLeaderboardVariant.dt();
    this.wf = paramLeaderboardVariant.du();
    this.wg = paramLeaderboardVariant.dv();
  }
  
  static int a(LeaderboardVariant paramLeaderboardVariant)
  {
    return ee.hashCode(new Object[] { Integer.valueOf(paramLeaderboardVariant.getTimeSpan()), Integer.valueOf(paramLeaderboardVariant.getCollection()), Boolean.valueOf(paramLeaderboardVariant.hasPlayerInfo()), Long.valueOf(paramLeaderboardVariant.getRawPlayerScore()), paramLeaderboardVariant.getDisplayPlayerScore(), Long.valueOf(paramLeaderboardVariant.getPlayerRank()), paramLeaderboardVariant.getDisplayPlayerRank(), Long.valueOf(paramLeaderboardVariant.getNumScores()), paramLeaderboardVariant.dt(), paramLeaderboardVariant.dv(), paramLeaderboardVariant.du() });
  }
  
  static boolean a(LeaderboardVariant paramLeaderboardVariant, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof LeaderboardVariant)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramLeaderboardVariant == paramObject);
      paramObject = (LeaderboardVariant)paramObject;
      if ((!ee.equal(Integer.valueOf(((LeaderboardVariant)paramObject).getTimeSpan()), Integer.valueOf(paramLeaderboardVariant.getTimeSpan()))) || (!ee.equal(Integer.valueOf(((LeaderboardVariant)paramObject).getCollection()), Integer.valueOf(paramLeaderboardVariant.getCollection()))) || (!ee.equal(Boolean.valueOf(((LeaderboardVariant)paramObject).hasPlayerInfo()), Boolean.valueOf(paramLeaderboardVariant.hasPlayerInfo()))) || (!ee.equal(Long.valueOf(((LeaderboardVariant)paramObject).getRawPlayerScore()), Long.valueOf(paramLeaderboardVariant.getRawPlayerScore()))) || (!ee.equal(((LeaderboardVariant)paramObject).getDisplayPlayerScore(), paramLeaderboardVariant.getDisplayPlayerScore())) || (!ee.equal(Long.valueOf(((LeaderboardVariant)paramObject).getPlayerRank()), Long.valueOf(paramLeaderboardVariant.getPlayerRank()))) || (!ee.equal(((LeaderboardVariant)paramObject).getDisplayPlayerRank(), paramLeaderboardVariant.getDisplayPlayerRank())) || (!ee.equal(Long.valueOf(((LeaderboardVariant)paramObject).getNumScores()), Long.valueOf(paramLeaderboardVariant.getNumScores()))) || (!ee.equal(((LeaderboardVariant)paramObject).dt(), paramLeaderboardVariant.dt())) || (!ee.equal(((LeaderboardVariant)paramObject).dv(), paramLeaderboardVariant.dv()))) {
        break;
      }
      bool1 = bool2;
    } while (ee.equal(((LeaderboardVariant)paramObject).du(), paramLeaderboardVariant.du()));
    return false;
  }
  
  static String b(LeaderboardVariant paramLeaderboardVariant)
  {
    ee.a locala = ee.e(paramLeaderboardVariant).a("TimeSpan", ge.aG(paramLeaderboardVariant.getTimeSpan())).a("Collection", gc.aG(paramLeaderboardVariant.getCollection()));
    if (paramLeaderboardVariant.hasPlayerInfo())
    {
      localObject = Long.valueOf(paramLeaderboardVariant.getRawPlayerScore());
      locala = locala.a("RawPlayerScore", localObject);
      if (!paramLeaderboardVariant.hasPlayerInfo()) {
        break label191;
      }
      localObject = paramLeaderboardVariant.getDisplayPlayerScore();
      label76:
      locala = locala.a("DisplayPlayerScore", localObject);
      if (!paramLeaderboardVariant.hasPlayerInfo()) {
        break label197;
      }
      localObject = Long.valueOf(paramLeaderboardVariant.getPlayerRank());
      label103:
      locala = locala.a("PlayerRank", localObject);
      if (!paramLeaderboardVariant.hasPlayerInfo()) {
        break label203;
      }
    }
    label191:
    label197:
    label203:
    for (Object localObject = paramLeaderboardVariant.getDisplayPlayerRank();; localObject = "none")
    {
      return locala.a("DisplayPlayerRank", localObject).a("NumScores", Long.valueOf(paramLeaderboardVariant.getNumScores())).a("TopPageNextToken", paramLeaderboardVariant.dt()).a("WindowPageNextToken", paramLeaderboardVariant.dv()).a("WindowPagePrevToken", paramLeaderboardVariant.du()).toString();
      localObject = "none";
      break;
      localObject = "none";
      break label76;
      localObject = "none";
      break label103;
    }
  }
  
  public String dt()
  {
    return this.we;
  }
  
  public String du()
  {
    return this.wf;
  }
  
  public String dv()
  {
    return this.wg;
  }
  
  public LeaderboardVariant dw()
  {
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public int getCollection()
  {
    return this.vW;
  }
  
  public String getDisplayPlayerRank()
  {
    return this.wb;
  }
  
  public String getDisplayPlayerScore()
  {
    return this.vZ;
  }
  
  public long getNumScores()
  {
    return this.wd;
  }
  
  public long getPlayerRank()
  {
    return this.wa;
  }
  
  public String getPlayerScoreTag()
  {
    return this.wc;
  }
  
  public long getRawPlayerScore()
  {
    return this.vY;
  }
  
  public int getTimeSpan()
  {
    return this.vV;
  }
  
  public boolean hasPlayerInfo()
  {
    return this.vX;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/games/leaderboard/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */