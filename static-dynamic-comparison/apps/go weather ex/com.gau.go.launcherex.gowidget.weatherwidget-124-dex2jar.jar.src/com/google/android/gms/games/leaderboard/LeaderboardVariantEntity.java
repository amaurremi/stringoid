package com.google.android.gms.games.leaderboard;

import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fo.a;

public final class LeaderboardVariantEntity
  implements LeaderboardVariant
{
  private final int Mh;
  private final int Mi;
  private final boolean Mj;
  private final long Mk;
  private final String Ml;
  private final long Mm;
  private final String Mn;
  private final String Mo;
  private final long Mp;
  private final String Mq;
  private final String Mr;
  private final String Ms;
  
  public LeaderboardVariantEntity(LeaderboardVariant paramLeaderboardVariant)
  {
    this.Mh = paramLeaderboardVariant.getTimeSpan();
    this.Mi = paramLeaderboardVariant.getCollection();
    this.Mj = paramLeaderboardVariant.hasPlayerInfo();
    this.Mk = paramLeaderboardVariant.getRawPlayerScore();
    this.Ml = paramLeaderboardVariant.getDisplayPlayerScore();
    this.Mm = paramLeaderboardVariant.getPlayerRank();
    this.Mn = paramLeaderboardVariant.getDisplayPlayerRank();
    this.Mo = paramLeaderboardVariant.getPlayerScoreTag();
    this.Mp = paramLeaderboardVariant.getNumScores();
    this.Mq = paramLeaderboardVariant.hG();
    this.Mr = paramLeaderboardVariant.hH();
    this.Ms = paramLeaderboardVariant.hI();
  }
  
  static int a(LeaderboardVariant paramLeaderboardVariant)
  {
    return fo.hashCode(new Object[] { Integer.valueOf(paramLeaderboardVariant.getTimeSpan()), Integer.valueOf(paramLeaderboardVariant.getCollection()), Boolean.valueOf(paramLeaderboardVariant.hasPlayerInfo()), Long.valueOf(paramLeaderboardVariant.getRawPlayerScore()), paramLeaderboardVariant.getDisplayPlayerScore(), Long.valueOf(paramLeaderboardVariant.getPlayerRank()), paramLeaderboardVariant.getDisplayPlayerRank(), Long.valueOf(paramLeaderboardVariant.getNumScores()), paramLeaderboardVariant.hG(), paramLeaderboardVariant.hI(), paramLeaderboardVariant.hH() });
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
      if ((!fo.equal(Integer.valueOf(((LeaderboardVariant)paramObject).getTimeSpan()), Integer.valueOf(paramLeaderboardVariant.getTimeSpan()))) || (!fo.equal(Integer.valueOf(((LeaderboardVariant)paramObject).getCollection()), Integer.valueOf(paramLeaderboardVariant.getCollection()))) || (!fo.equal(Boolean.valueOf(((LeaderboardVariant)paramObject).hasPlayerInfo()), Boolean.valueOf(paramLeaderboardVariant.hasPlayerInfo()))) || (!fo.equal(Long.valueOf(((LeaderboardVariant)paramObject).getRawPlayerScore()), Long.valueOf(paramLeaderboardVariant.getRawPlayerScore()))) || (!fo.equal(((LeaderboardVariant)paramObject).getDisplayPlayerScore(), paramLeaderboardVariant.getDisplayPlayerScore())) || (!fo.equal(Long.valueOf(((LeaderboardVariant)paramObject).getPlayerRank()), Long.valueOf(paramLeaderboardVariant.getPlayerRank()))) || (!fo.equal(((LeaderboardVariant)paramObject).getDisplayPlayerRank(), paramLeaderboardVariant.getDisplayPlayerRank())) || (!fo.equal(Long.valueOf(((LeaderboardVariant)paramObject).getNumScores()), Long.valueOf(paramLeaderboardVariant.getNumScores()))) || (!fo.equal(((LeaderboardVariant)paramObject).hG(), paramLeaderboardVariant.hG())) || (!fo.equal(((LeaderboardVariant)paramObject).hI(), paramLeaderboardVariant.hI()))) {
        break;
      }
      bool1 = bool2;
    } while (fo.equal(((LeaderboardVariant)paramObject).hH(), paramLeaderboardVariant.hH()));
    return false;
  }
  
  static String b(LeaderboardVariant paramLeaderboardVariant)
  {
    fo.a locala = fo.e(paramLeaderboardVariant).a("TimeSpan", TimeSpan.bd(paramLeaderboardVariant.getTimeSpan())).a("Collection", LeaderboardCollection.bd(paramLeaderboardVariant.getCollection()));
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
      return locala.a("DisplayPlayerRank", localObject).a("NumScores", Long.valueOf(paramLeaderboardVariant.getNumScores())).a("TopPageNextToken", paramLeaderboardVariant.hG()).a("WindowPageNextToken", paramLeaderboardVariant.hI()).a("WindowPagePrevToken", paramLeaderboardVariant.hH()).toString();
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
    return this.Mi;
  }
  
  public String getDisplayPlayerRank()
  {
    return this.Mn;
  }
  
  public String getDisplayPlayerScore()
  {
    return this.Ml;
  }
  
  public long getNumScores()
  {
    return this.Mp;
  }
  
  public long getPlayerRank()
  {
    return this.Mm;
  }
  
  public String getPlayerScoreTag()
  {
    return this.Mo;
  }
  
  public long getRawPlayerScore()
  {
    return this.Mk;
  }
  
  public int getTimeSpan()
  {
    return this.Mh;
  }
  
  public String hG()
  {
    return this.Mq;
  }
  
  public String hH()
  {
    return this.Mr;
  }
  
  public String hI()
  {
    return this.Ms;
  }
  
  public LeaderboardVariant hJ()
  {
    return this;
  }
  
  public boolean hasPlayerInfo()
  {
    return this.Mj;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardVariantEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */