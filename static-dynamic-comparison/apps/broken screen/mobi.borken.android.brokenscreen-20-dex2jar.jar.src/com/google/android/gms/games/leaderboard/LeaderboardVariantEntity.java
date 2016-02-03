package com.google.android.gms.games.leaderboard;

import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;

public final class LeaderboardVariantEntity
  implements LeaderboardVariant
{
  private final int SE;
  private final int SF;
  private final boolean SG;
  private final long SH;
  private final String SI;
  private final long SJ;
  private final String SK;
  private final String SL;
  private final long SM;
  private final String SN;
  private final String SO;
  private final String SP;
  
  public LeaderboardVariantEntity(LeaderboardVariant paramLeaderboardVariant)
  {
    this.SE = paramLeaderboardVariant.getTimeSpan();
    this.SF = paramLeaderboardVariant.getCollection();
    this.SG = paramLeaderboardVariant.hasPlayerInfo();
    this.SH = paramLeaderboardVariant.getRawPlayerScore();
    this.SI = paramLeaderboardVariant.getDisplayPlayerScore();
    this.SJ = paramLeaderboardVariant.getPlayerRank();
    this.SK = paramLeaderboardVariant.getDisplayPlayerRank();
    this.SL = paramLeaderboardVariant.getPlayerScoreTag();
    this.SM = paramLeaderboardVariant.getNumScores();
    this.SN = paramLeaderboardVariant.iy();
    this.SO = paramLeaderboardVariant.iz();
    this.SP = paramLeaderboardVariant.iA();
  }
  
  static int a(LeaderboardVariant paramLeaderboardVariant)
  {
    return hl.hashCode(new Object[] { Integer.valueOf(paramLeaderboardVariant.getTimeSpan()), Integer.valueOf(paramLeaderboardVariant.getCollection()), Boolean.valueOf(paramLeaderboardVariant.hasPlayerInfo()), Long.valueOf(paramLeaderboardVariant.getRawPlayerScore()), paramLeaderboardVariant.getDisplayPlayerScore(), Long.valueOf(paramLeaderboardVariant.getPlayerRank()), paramLeaderboardVariant.getDisplayPlayerRank(), Long.valueOf(paramLeaderboardVariant.getNumScores()), paramLeaderboardVariant.iy(), paramLeaderboardVariant.iA(), paramLeaderboardVariant.iz() });
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
      if ((!hl.equal(Integer.valueOf(((LeaderboardVariant)paramObject).getTimeSpan()), Integer.valueOf(paramLeaderboardVariant.getTimeSpan()))) || (!hl.equal(Integer.valueOf(((LeaderboardVariant)paramObject).getCollection()), Integer.valueOf(paramLeaderboardVariant.getCollection()))) || (!hl.equal(Boolean.valueOf(((LeaderboardVariant)paramObject).hasPlayerInfo()), Boolean.valueOf(paramLeaderboardVariant.hasPlayerInfo()))) || (!hl.equal(Long.valueOf(((LeaderboardVariant)paramObject).getRawPlayerScore()), Long.valueOf(paramLeaderboardVariant.getRawPlayerScore()))) || (!hl.equal(((LeaderboardVariant)paramObject).getDisplayPlayerScore(), paramLeaderboardVariant.getDisplayPlayerScore())) || (!hl.equal(Long.valueOf(((LeaderboardVariant)paramObject).getPlayerRank()), Long.valueOf(paramLeaderboardVariant.getPlayerRank()))) || (!hl.equal(((LeaderboardVariant)paramObject).getDisplayPlayerRank(), paramLeaderboardVariant.getDisplayPlayerRank())) || (!hl.equal(Long.valueOf(((LeaderboardVariant)paramObject).getNumScores()), Long.valueOf(paramLeaderboardVariant.getNumScores()))) || (!hl.equal(((LeaderboardVariant)paramObject).iy(), paramLeaderboardVariant.iy())) || (!hl.equal(((LeaderboardVariant)paramObject).iA(), paramLeaderboardVariant.iA()))) {
        break;
      }
      bool1 = bool2;
    } while (hl.equal(((LeaderboardVariant)paramObject).iz(), paramLeaderboardVariant.iz()));
    return false;
  }
  
  static String b(LeaderboardVariant paramLeaderboardVariant)
  {
    hl.a locala = hl.e(paramLeaderboardVariant).a("TimeSpan", TimeSpan.cm(paramLeaderboardVariant.getTimeSpan())).a("Collection", LeaderboardCollection.cm(paramLeaderboardVariant.getCollection()));
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
      return locala.a("DisplayPlayerRank", localObject).a("NumScores", Long.valueOf(paramLeaderboardVariant.getNumScores())).a("TopPageNextToken", paramLeaderboardVariant.iy()).a("WindowPageNextToken", paramLeaderboardVariant.iA()).a("WindowPagePrevToken", paramLeaderboardVariant.iz()).toString();
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
    return this.SF;
  }
  
  public String getDisplayPlayerRank()
  {
    return this.SK;
  }
  
  public String getDisplayPlayerScore()
  {
    return this.SI;
  }
  
  public long getNumScores()
  {
    return this.SM;
  }
  
  public long getPlayerRank()
  {
    return this.SJ;
  }
  
  public String getPlayerScoreTag()
  {
    return this.SL;
  }
  
  public long getRawPlayerScore()
  {
    return this.SH;
  }
  
  public int getTimeSpan()
  {
    return this.SE;
  }
  
  public boolean hasPlayerInfo()
  {
    return this.SG;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public String iA()
  {
    return this.SP;
  }
  
  public LeaderboardVariant iB()
  {
    return this;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String iy()
  {
    return this.SN;
  }
  
  public String iz()
  {
    return this.SO;
  }
  
  public String toString()
  {
    return b(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardVariantEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */