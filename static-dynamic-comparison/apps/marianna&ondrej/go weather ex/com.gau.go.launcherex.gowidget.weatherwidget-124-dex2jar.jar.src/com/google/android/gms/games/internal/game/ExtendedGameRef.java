package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

public class ExtendedGameRef
  extends b
  implements ExtendedGame
{
  private final GameRef LD;
  private final int LE;
  
  ExtendedGameRef(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.LD = new GameRef(paramDataHolder, paramInt1);
    this.LE = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return ExtendedGameEntity.a(this, paramObject);
  }
  
  public ArrayList<GameBadge> gW()
  {
    int i = 0;
    if (this.BB.getString("badge_title", this.BD, this.BB.G(this.BD)) == null) {
      return new ArrayList(0);
    }
    ArrayList localArrayList = new ArrayList(this.LE);
    while (i < this.LE)
    {
      localArrayList.add(new GameBadgeRef(this.BB, this.BD + i));
      i += 1;
    }
    return localArrayList;
  }
  
  public int gX()
  {
    return getInteger("availability");
  }
  
  public boolean gY()
  {
    return getBoolean("owned");
  }
  
  public int gZ()
  {
    return getInteger("achievement_unlocked_count");
  }
  
  public Game getGame()
  {
    return this.LD;
  }
  
  public long ha()
  {
    return getLong("last_played_server_time");
  }
  
  public int hashCode()
  {
    return ExtendedGameEntity.a(this);
  }
  
  public long hb()
  {
    return getLong("price_micros");
  }
  
  public String hc()
  {
    return getString("formatted_price");
  }
  
  public long hd()
  {
    return getLong("full_price_micros");
  }
  
  public String he()
  {
    return getString("formatted_full_price");
  }
  
  public ExtendedGame hg()
  {
    return new ExtendedGameEntity(this);
  }
  
  public String toString()
  {
    return ExtendedGameEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((ExtendedGameEntity)hg()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/games/internal/game/ExtendedGameRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */