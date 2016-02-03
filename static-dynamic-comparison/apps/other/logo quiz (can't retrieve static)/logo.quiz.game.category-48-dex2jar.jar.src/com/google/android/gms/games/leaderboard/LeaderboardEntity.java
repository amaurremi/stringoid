package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;

public final class LeaderboardEntity
  implements Leaderboard
{
  private final String Nz;
  private final Uri UW;
  private final String Vh;
  private final String abj;
  private final int abk;
  private final ArrayList<LeaderboardVariantEntity> abl;
  private final Game abm;
  
  public LeaderboardEntity(Leaderboard paramLeaderboard)
  {
    this.abj = paramLeaderboard.getLeaderboardId();
    this.Nz = paramLeaderboard.getDisplayName();
    this.UW = paramLeaderboard.getIconImageUri();
    this.Vh = paramLeaderboard.getIconImageUrl();
    this.abk = paramLeaderboard.getScoreOrder();
    Object localObject = paramLeaderboard.getGame();
    if (localObject == null) {}
    for (localObject = null;; localObject = new GameEntity((Game)localObject))
    {
      this.abm = ((Game)localObject);
      paramLeaderboard = paramLeaderboard.getVariants();
      int j = paramLeaderboard.size();
      this.abl = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        this.abl.add((LeaderboardVariantEntity)((LeaderboardVariant)paramLeaderboard.get(i)).freeze());
        i += 1;
      }
    }
  }
  
  static int a(Leaderboard paramLeaderboard)
  {
    return m.hashCode(new Object[] { paramLeaderboard.getLeaderboardId(), paramLeaderboard.getDisplayName(), paramLeaderboard.getIconImageUri(), Integer.valueOf(paramLeaderboard.getScoreOrder()), paramLeaderboard.getVariants() });
  }
  
  static boolean a(Leaderboard paramLeaderboard, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Leaderboard)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramLeaderboard == paramObject);
      paramObject = (Leaderboard)paramObject;
      if ((!m.equal(((Leaderboard)paramObject).getLeaderboardId(), paramLeaderboard.getLeaderboardId())) || (!m.equal(((Leaderboard)paramObject).getDisplayName(), paramLeaderboard.getDisplayName())) || (!m.equal(((Leaderboard)paramObject).getIconImageUri(), paramLeaderboard.getIconImageUri())) || (!m.equal(Integer.valueOf(((Leaderboard)paramObject).getScoreOrder()), Integer.valueOf(paramLeaderboard.getScoreOrder())))) {
        break;
      }
      bool1 = bool2;
    } while (m.equal(((Leaderboard)paramObject).getVariants(), paramLeaderboard.getVariants()));
    return false;
  }
  
  static String b(Leaderboard paramLeaderboard)
  {
    return m.h(paramLeaderboard).a("LeaderboardId", paramLeaderboard.getLeaderboardId()).a("DisplayName", paramLeaderboard.getDisplayName()).a("IconImageUri", paramLeaderboard.getIconImageUri()).a("IconImageUrl", paramLeaderboard.getIconImageUrl()).a("ScoreOrder", Integer.valueOf(paramLeaderboard.getScoreOrder())).a("Variants", paramLeaderboard.getVariants()).toString();
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public String getDisplayName()
  {
    return this.Nz;
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    jv.b(this.Nz, paramCharArrayBuffer);
  }
  
  public Game getGame()
  {
    return this.abm;
  }
  
  public Uri getIconImageUri()
  {
    return this.UW;
  }
  
  public String getIconImageUrl()
  {
    return this.Vh;
  }
  
  public String getLeaderboardId()
  {
    return this.abj;
  }
  
  public int getScoreOrder()
  {
    return this.abk;
  }
  
  public ArrayList<LeaderboardVariant> getVariants()
  {
    return new ArrayList(this.abl);
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public Leaderboard lx()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */