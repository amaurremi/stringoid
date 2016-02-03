package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import java.util.ArrayList;

public final class b
  extends com.google.android.gms.common.data.b
  implements Leaderboard
{
  private final Game vG;
  private final int vH;
  
  b(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.vH = paramInt2;
    this.vG = new com.google.android.gms.games.b(paramDataHolder, paramInt1);
  }
  
  public Leaderboard dp()
  {
    return new a(this);
  }
  
  public boolean equals(Object paramObject)
  {
    return a.a(this, paramObject);
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
    return this.vG;
  }
  
  public Uri getIconImageUri()
  {
    return L("board_icon_image_uri");
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
    ArrayList localArrayList = new ArrayList(this.vH);
    int i = 0;
    while (i < this.vH)
    {
      localArrayList.add(new g(this.nE, this.nG + i));
      i += 1;
    }
    return localArrayList;
  }
  
  public int hashCode()
  {
    return a.a(this);
  }
  
  public String toString()
  {
    return a.b(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/games/leaderboard/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */