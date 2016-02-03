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
  private final GameRef RE;
  private final SnapshotMetadataRef RF;
  private final int RG;
  
  ExtendedGameRef(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.RE = new GameRef(paramDataHolder, paramInt1);
    this.RG = paramInt2;
    if ((av("external_snapshot_id")) && (!ax("external_snapshot_id")))
    {
      this.RF = new SnapshotMetadataRef(paramDataHolder, paramInt1);
      return;
    }
    this.RF = null;
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
    return this.RE;
  }
  
  public ArrayList<GameBadge> hQ()
  {
    int i = 0;
    if (this.DG.c("badge_title", this.EC, this.DG.ae(this.EC)) == null) {
      return new ArrayList(0);
    }
    ArrayList localArrayList = new ArrayList(this.RG);
    while (i < this.RG)
    {
      localArrayList.add(new GameBadgeRef(this.DG, this.EC + i));
      i += 1;
    }
    return localArrayList;
  }
  
  public int hR()
  {
    return getInteger("availability");
  }
  
  public boolean hS()
  {
    return getBoolean("owned");
  }
  
  public int hT()
  {
    return getInteger("achievement_unlocked_count");
  }
  
  public long hU()
  {
    return getLong("last_played_server_time");
  }
  
  public long hV()
  {
    return getLong("price_micros");
  }
  
  public String hW()
  {
    return getString("formatted_price");
  }
  
  public long hX()
  {
    return getLong("full_price_micros");
  }
  
  public String hY()
  {
    return getString("formatted_full_price");
  }
  
  public SnapshotMetadata hZ()
  {
    return this.RF;
  }
  
  public int hashCode()
  {
    return ExtendedGameEntity.a(this);
  }
  
  public ExtendedGame ib()
  {
    return new ExtendedGameEntity(this);
  }
  
  public String toString()
  {
    return ExtendedGameEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((ExtendedGameEntity)ib()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/game/ExtendedGameRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */