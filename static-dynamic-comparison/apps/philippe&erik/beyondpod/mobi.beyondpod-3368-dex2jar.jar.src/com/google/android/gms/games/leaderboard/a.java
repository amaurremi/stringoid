package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.ee.a;
import com.google.android.gms.internal.fc;
import java.util.ArrayList;

public final class a
  implements Leaderboard
{
  private final String qa;
  private final Uri sL;
  private final String vD;
  private final int vE;
  private final ArrayList<f> vF;
  private final Game vG;
  
  public a(Leaderboard paramLeaderboard)
  {
    this.vD = paramLeaderboard.getLeaderboardId();
    this.qa = paramLeaderboard.getDisplayName();
    this.sL = paramLeaderboard.getIconImageUri();
    this.vE = paramLeaderboard.getScoreOrder();
    Object localObject = paramLeaderboard.getGame();
    if (localObject == null) {}
    for (localObject = null;; localObject = new GameEntity((Game)localObject))
    {
      this.vG = ((Game)localObject);
      paramLeaderboard = paramLeaderboard.getVariants();
      int j = paramLeaderboard.size();
      this.vF = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        this.vF.add((f)((LeaderboardVariant)paramLeaderboard.get(i)).freeze());
        i += 1;
      }
    }
  }
  
  static int a(Leaderboard paramLeaderboard)
  {
    return ee.hashCode(new Object[] { paramLeaderboard.getLeaderboardId(), paramLeaderboard.getDisplayName(), paramLeaderboard.getIconImageUri(), Integer.valueOf(paramLeaderboard.getScoreOrder()), paramLeaderboard.getVariants() });
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
      if ((!ee.equal(((Leaderboard)paramObject).getLeaderboardId(), paramLeaderboard.getLeaderboardId())) || (!ee.equal(((Leaderboard)paramObject).getDisplayName(), paramLeaderboard.getDisplayName())) || (!ee.equal(((Leaderboard)paramObject).getIconImageUri(), paramLeaderboard.getIconImageUri())) || (!ee.equal(Integer.valueOf(((Leaderboard)paramObject).getScoreOrder()), Integer.valueOf(paramLeaderboard.getScoreOrder())))) {
        break;
      }
      bool1 = bool2;
    } while (ee.equal(((Leaderboard)paramObject).getVariants(), paramLeaderboard.getVariants()));
    return false;
  }
  
  static String b(Leaderboard paramLeaderboard)
  {
    return ee.e(paramLeaderboard).a("LeaderboardId", paramLeaderboard.getLeaderboardId()).a("DisplayName", paramLeaderboard.getDisplayName()).a("IconImageUri", paramLeaderboard.getIconImageUri()).a("ScoreOrder", Integer.valueOf(paramLeaderboard.getScoreOrder())).a("Variants", paramLeaderboard.getVariants()).toString();
  }
  
  public Leaderboard dp()
  {
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public String getDisplayName()
  {
    return this.qa;
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    fc.b(this.qa, paramCharArrayBuffer);
  }
  
  public Game getGame()
  {
    return this.vG;
  }
  
  public Uri getIconImageUri()
  {
    return this.sL;
  }
  
  public String getLeaderboardId()
  {
    return this.vD;
  }
  
  public int getScoreOrder()
  {
    return this.vE;
  }
  
  public ArrayList<LeaderboardVariant> getVariants()
  {
    return new ArrayList(this.vF);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/games/leaderboard/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */