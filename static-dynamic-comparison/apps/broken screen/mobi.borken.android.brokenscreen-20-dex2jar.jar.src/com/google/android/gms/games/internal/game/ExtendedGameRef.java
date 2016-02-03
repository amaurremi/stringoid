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
  private final GameRef RB;
  private final SnapshotMetadataRef RC;
  private final int RD;
  
  ExtendedGameRef(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.RB = new GameRef(paramDataHolder, paramInt1);
    this.RD = paramInt2;
    if ((av("external_snapshot_id")) && (!ax("external_snapshot_id")))
    {
      this.RC = new SnapshotMetadataRef(paramDataHolder, paramInt1);
      return;
    }
    this.RC = null;
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
    return this.RB;
  }
  
  public ArrayList<GameBadge> hL()
  {
    int i = 0;
    if (this.DD.c("badge_title", this.Ez, this.DD.ae(this.Ez)) == null) {
      return new ArrayList(0);
    }
    ArrayList localArrayList = new ArrayList(this.RD);
    while (i < this.RD)
    {
      localArrayList.add(new GameBadgeRef(this.DD, this.Ez + i));
      i += 1;
    }
    return localArrayList;
  }
  
  public int hM()
  {
    return getInteger("availability");
  }
  
  public boolean hN()
  {
    return getBoolean("owned");
  }
  
  public int hO()
  {
    return getInteger("achievement_unlocked_count");
  }
  
  public long hP()
  {
    return getLong("last_played_server_time");
  }
  
  public long hQ()
  {
    return getLong("price_micros");
  }
  
  public String hR()
  {
    return getString("formatted_price");
  }
  
  public long hS()
  {
    return getLong("full_price_micros");
  }
  
  public String hT()
  {
    return getString("formatted_full_price");
  }
  
  public SnapshotMetadata hU()
  {
    return this.RC;
  }
  
  public ExtendedGame hW()
  {
    return new ExtendedGameEntity(this);
  }
  
  public int hashCode()
  {
    return ExtendedGameEntity.a(this);
  }
  
  public String toString()
  {
    return ExtendedGameEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((ExtendedGameEntity)hW()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/internal/game/ExtendedGameRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */