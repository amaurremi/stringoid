package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

public final class LeaderboardRef
  extends d
  implements Leaderboard
{
  private final int RD;
  private final Game Sp;
  
  LeaderboardRef(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.RD = paramInt2;
    this.Sp = new GameRef(paramDataHolder, paramInt1);
  }
  
  public boolean equals(Object paramObject)
  {
    return LeaderboardEntity.a(this, paramObject);
  }
  
  public String getDisplayName()
  {
    return getString("name");
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    a("name", paramCharArrayBuffer);
  }
  
  public Game getGame()
  {
    return this.Sp;
  }
  
  public Uri getIconImageUri()
  {
    return aw("board_icon_image_uri");
  }
  
  public String getIconImageUrl()
  {
    return getString("board_icon_image_url");
  }
  
  public String getLeaderboardId()
  {
    return getString("external_leaderboard_id");
  }
  
  public int getScoreOrder()
  {
    return getInteger("score_order");
  }
  
  public ArrayList<LeaderboardVariant> getVariants()
  {
    ArrayList localArrayList = new ArrayList(this.RD);
    int i = 0;
    while (i < this.RD)
    {
      localArrayList.add(new LeaderboardVariantRef(this.DD, this.Ez + i));
      i += 1;
    }
    return localArrayList;
  }
  
  public int hashCode()
  {
    return LeaderboardEntity.a(this);
  }
  
  public Leaderboard iu()
  {
    return new LeaderboardEntity(this);
  }
  
  public String toString()
  {
    return LeaderboardEntity.b(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */