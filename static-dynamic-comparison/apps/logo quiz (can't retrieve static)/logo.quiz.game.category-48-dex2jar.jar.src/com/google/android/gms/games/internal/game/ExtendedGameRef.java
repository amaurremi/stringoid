package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataRef;
import java.util.ArrayList;

public class ExtendedGameRef
  extends d
  implements ExtendedGame
{
  private final GameRef aam;
  private final SnapshotMetadataRef aay;
  private final int aaz;
  
  ExtendedGameRef(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.aam = new GameRef(paramDataHolder, paramInt1);
    this.aaz = paramInt2;
    if ((aQ("external_snapshot_id")) && (!aS("external_snapshot_id")))
    {
      this.aay = new SnapshotMetadataRef(paramDataHolder, paramInt1);
      return;
    }
    this.aay = null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return ExtendedGameEntity.a(this, paramObject);
  }
  
  public Game getGame()
  {
    return this.aam;
  }
  
  public int hashCode()
  {
    return ExtendedGameEntity.a(this);
  }
  
  public ArrayList<GameBadge> kO()
  {
    int i = 0;
    if (this.IC.c("badge_title", this.JQ, this.IC.ar(this.JQ)) == null) {
      return new ArrayList(0);
    }
    ArrayList localArrayList = new ArrayList(this.aaz);
    while (i < this.aaz)
    {
      localArrayList.add(new GameBadgeRef(this.IC, this.JQ + i));
      i += 1;
    }
    return localArrayList;
  }
  
  public int kP()
  {
    return getInteger("availability");
  }
  
  public boolean kQ()
  {
    return getBoolean("owned");
  }
  
  public int kR()
  {
    return getInteger("achievement_unlocked_count");
  }
  
  public long kS()
  {
    return getLong("last_played_server_time");
  }
  
  public long kT()
  {
    return getLong("price_micros");
  }
  
  public String kU()
  {
    return getString("formatted_price");
  }
  
  public long kV()
  {
    return getLong("full_price_micros");
  }
  
  public String kW()
  {
    return getString("formatted_full_price");
  }
  
  public SnapshotMetadata kX()
  {
    return this.aay;
  }
  
  public ExtendedGame kZ()
  {
    return new ExtendedGameEntity(this);
  }
  
  public String toString()
  {
    return ExtendedGameEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((ExtendedGameEntity)kZ()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/internal/game/ExtendedGameRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */