package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;

public final class LeaderboardVariantEntity
  implements LeaderboardVariant
{
  private final int abB;
  private final int abC;
  private final boolean abD;
  private final long abE;
  private final String abF;
  private final long abG;
  private final String abH;
  private final String abI;
  private final long abJ;
  private final String abK;
  private final String abL;
  private final String abM;
  
  public LeaderboardVariantEntity(LeaderboardVariant paramLeaderboardVariant)
  {
    this.abB = paramLeaderboardVariant.getTimeSpan();
    this.abC = paramLeaderboardVariant.getCollection();
    this.abD = paramLeaderboardVariant.hasPlayerInfo();
    this.abE = paramLeaderboardVariant.getRawPlayerScore();
    this.abF = paramLeaderboardVariant.getDisplayPlayerScore();
    this.abG = paramLeaderboardVariant.getPlayerRank();
    this.abH = paramLeaderboardVariant.getDisplayPlayerRank();
    this.abI = paramLeaderboardVariant.getPlayerScoreTag();
    this.abJ = paramLeaderboardVariant.getNumScores();
    this.abK = paramLeaderboardVariant.lB();
    this.abL = paramLeaderboardVariant.lC();
    this.abM = paramLeaderboardVariant.lD();
  }
  
  static int a(LeaderboardVariant paramLeaderboardVariant)
  {
    return m.hashCode(new Object[] { Integer.valueOf(paramLeaderboardVariant.getTimeSpan()), Integer.valueOf(paramLeaderboardVariant.getCollection()), Boolean.valueOf(paramLeaderboardVariant.hasPlayerInfo()), Long.valueOf(paramLeaderboardVariant.getRawPlayerScore()), paramLeaderboardVariant.getDisplayPlayerScore(), Long.valueOf(paramLeaderboardVariant.getPlayerRank()), paramLeaderboardVariant.getDisplayPlayerRank(), Long.valueOf(paramLeaderboardVariant.getNumScores()), paramLeaderboardVariant.lB(), paramLeaderboardVariant.lD(), paramLeaderboardVariant.lC() });
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
      if ((!m.equal(Integer.valueOf(((LeaderboardVariant)paramObject).getTimeSpan()), Integer.valueOf(paramLeaderboardVariant.getTimeSpan()))) || (!m.equal(Integer.valueOf(((LeaderboardVariant)paramObject).getCollection()), Integer.valueOf(paramLeaderboardVariant.getCollection()))) || (!m.equal(Boolean.valueOf(((LeaderboardVariant)paramObject).hasPlayerInfo()), Boolean.valueOf(paramLeaderboardVariant.hasPlayerInfo()))) || (!m.equal(Long.valueOf(((LeaderboardVariant)paramObject).getRawPlayerScore()), Long.valueOf(paramLeaderboardVariant.getRawPlayerScore()))) || (!m.equal(((LeaderboardVariant)paramObject).getDisplayPlayerScore(), paramLeaderboardVariant.getDisplayPlayerScore())) || (!m.equal(Long.valueOf(((LeaderboardVariant)paramObject).getPlayerRank()), Long.valueOf(paramLeaderboardVariant.getPlayerRank()))) || (!m.equal(((LeaderboardVariant)paramObject).getDisplayPlayerRank(), paramLeaderboardVariant.getDisplayPlayerRank())) || (!m.equal(Long.valueOf(((LeaderboardVariant)paramObject).getNumScores()), Long.valueOf(paramLeaderboardVariant.getNumScores()))) || (!m.equal(((LeaderboardVariant)paramObject).lB(), paramLeaderboardVariant.lB())) || (!m.equal(((LeaderboardVariant)paramObject).lD(), paramLeaderboardVariant.lD()))) {
        break;
      }
      bool1 = bool2;
    } while (m.equal(((LeaderboardVariant)paramObject).lC(), paramLeaderboardVariant.lC()));
    return false;
  }
  
  static String b(LeaderboardVariant paramLeaderboardVariant)
  {
    m.a locala = m.h(paramLeaderboardVariant).a("TimeSpan", TimeSpan.dH(paramLeaderboardVariant.getTimeSpan())).a("Collection", LeaderboardCollection.dH(paramLeaderboardVariant.getCollection()));
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
      return locala.a("DisplayPlayerRank", localObject).a("NumScores", Long.valueOf(paramLeaderboardVariant.getNumScores())).a("TopPageNextToken", paramLeaderboardVariant.lB()).a("WindowPageNextToken", paramLeaderboardVariant.lD()).a("WindowPagePrevToken", paramLeaderboardVariant.lC()).toString();
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
    return this.abC;
  }
  
  public String getDisplayPlayerRank()
  {
    return this.abH;
  }
  
  public String getDisplayPlayerScore()
  {
    return this.abF;
  }
  
  public long getNumScores()
  {
    return this.abJ;
  }
  
  public long getPlayerRank()
  {
    return this.abG;
  }
  
  public String getPlayerScoreTag()
  {
    return this.abI;
  }
  
  public long getRawPlayerScore()
  {
    return this.abE;
  }
  
  public int getTimeSpan()
  {
    return this.abB;
  }
  
  public boolean hasPlayerInfo()
  {
    return this.abD;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String lB()
  {
    return this.abK;
  }
  
  public String lC()
  {
    return this.abL;
  }
  
  public String lD()
  {
    return this.abM;
  }
  
  public LeaderboardVariant lE()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardVariantEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */