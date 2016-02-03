package com.google.android.gms.games.leaderboard;

import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hk.a;

public final class LeaderboardVariantEntity
  implements LeaderboardVariant
{
  private final int SH;
  private final int SI;
  private final boolean SJ;
  private final long SK;
  private final String SL;
  private final long SM;
  private final String SN;
  private final String SO;
  private final long SP;
  private final String SQ;
  private final String SR;
  private final String SS;
  
  public LeaderboardVariantEntity(LeaderboardVariant paramLeaderboardVariant)
  {
    this.SH = paramLeaderboardVariant.getTimeSpan();
    this.SI = paramLeaderboardVariant.getCollection();
    this.SJ = paramLeaderboardVariant.hasPlayerInfo();
    this.SK = paramLeaderboardVariant.getRawPlayerScore();
    this.SL = paramLeaderboardVariant.getDisplayPlayerScore();
    this.SM = paramLeaderboardVariant.getPlayerRank();
    this.SN = paramLeaderboardVariant.getDisplayPlayerRank();
    this.SO = paramLeaderboardVariant.getPlayerScoreTag();
    this.SP = paramLeaderboardVariant.getNumScores();
    this.SQ = paramLeaderboardVariant.iD();
    this.SR = paramLeaderboardVariant.iE();
    this.SS = paramLeaderboardVariant.iF();
  }
  
  static int a(LeaderboardVariant paramLeaderboardVariant)
  {
    return hk.hashCode(new Object[] { Integer.valueOf(paramLeaderboardVariant.getTimeSpan()), Integer.valueOf(paramLeaderboardVariant.getCollection()), Boolean.valueOf(paramLeaderboardVariant.hasPlayerInfo()), Long.valueOf(paramLeaderboardVariant.getRawPlayerScore()), paramLeaderboardVariant.getDisplayPlayerScore(), Long.valueOf(paramLeaderboardVariant.getPlayerRank()), paramLeaderboardVariant.getDisplayPlayerRank(), Long.valueOf(paramLeaderboardVariant.getNumScores()), paramLeaderboardVariant.iD(), paramLeaderboardVariant.iF(), paramLeaderboardVariant.iE() });
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
      if ((!hk.equal(Integer.valueOf(((LeaderboardVariant)paramObject).getTimeSpan()), Integer.valueOf(paramLeaderboardVariant.getTimeSpan()))) || (!hk.equal(Integer.valueOf(((LeaderboardVariant)paramObject).getCollection()), Integer.valueOf(paramLeaderboardVariant.getCollection()))) || (!hk.equal(Boolean.valueOf(((LeaderboardVariant)paramObject).hasPlayerInfo()), Boolean.valueOf(paramLeaderboardVariant.hasPlayerInfo()))) || (!hk.equal(Long.valueOf(((LeaderboardVariant)paramObject).getRawPlayerScore()), Long.valueOf(paramLeaderboardVariant.getRawPlayerScore()))) || (!hk.equal(((LeaderboardVariant)paramObject).getDisplayPlayerScore(), paramLeaderboardVariant.getDisplayPlayerScore())) || (!hk.equal(Long.valueOf(((LeaderboardVariant)paramObject).getPlayerRank()), Long.valueOf(paramLeaderboardVariant.getPlayerRank()))) || (!hk.equal(((LeaderboardVariant)paramObject).getDisplayPlayerRank(), paramLeaderboardVariant.getDisplayPlayerRank())) || (!hk.equal(Long.valueOf(((LeaderboardVariant)paramObject).getNumScores()), Long.valueOf(paramLeaderboardVariant.getNumScores()))) || (!hk.equal(((LeaderboardVariant)paramObject).iD(), paramLeaderboardVariant.iD())) || (!hk.equal(((LeaderboardVariant)paramObject).iF(), paramLeaderboardVariant.iF()))) {
        break;
      }
      bool1 = bool2;
    } while (hk.equal(((LeaderboardVariant)paramObject).iE(), paramLeaderboardVariant.iE()));
    return false;
  }
  
  static String b(LeaderboardVariant paramLeaderboardVariant)
  {
    hk.a locala = hk.e(paramLeaderboardVariant).a("TimeSpan", TimeSpan.cm(paramLeaderboardVariant.getTimeSpan())).a("Collection", LeaderboardCollection.cm(paramLeaderboardVariant.getCollection()));
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
      return locala.a("DisplayPlayerRank", localObject).a("NumScores", Long.valueOf(paramLeaderboardVariant.getNumScores())).a("TopPageNextToken", paramLeaderboardVariant.iD()).a("WindowPageNextToken", paramLeaderboardVariant.iF()).a("WindowPagePrevToken", paramLeaderboardVariant.iE()).toString();
      localObject = "none";
      break;
      localObject = "none";
      break label76;
      localObject = "none";
      break label103;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public int getCollection()
  {
    return this.SI;
  }
  
  public String getDisplayPlayerRank()
  {
    return this.SN;
  }
  
  public String getDisplayPlayerScore()
  {
    return this.SL;
  }
  
  public long getNumScores()
  {
    return this.SP;
  }
  
  public long getPlayerRank()
  {
    return this.SM;
  }
  
  public String getPlayerScoreTag()
  {
    return this.SO;
  }
  
  public long getRawPlayerScore()
  {
    return this.SK;
  }
  
  public int getTimeSpan()
  {
    return this.SH;
  }
  
  public boolean hasPlayerInfo()
  {
    return this.SJ;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public String iD()
  {
    return this.SQ;
  }
  
  public String iE()
  {
    return this.SR;
  }
  
  public String iF()
  {
    return this.SS;
  }
  
  public LeaderboardVariant iG()
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardVariantEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */