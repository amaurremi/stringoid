package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class PlayerRef
  extends d
  implements Player
{
  private final PlayerLevelInfo MX;
  private final PlayerColumnNames Ng;
  private final MostRecentGameInfoRef Nh;
  
  public PlayerRef(DataHolder paramDataHolder, int paramInt)
  {
    this(paramDataHolder, paramInt, null);
  }
  
  public PlayerRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt);
    this.Ng = new PlayerColumnNames(paramString);
    this.Nh = new MostRecentGameInfoRef(paramDataHolder, paramInt, this.Ng);
    int i;
    if (gV())
    {
      paramInt = getInteger(this.Ng.RY);
      i = getInteger(this.Ng.Sb);
      paramString = new PlayerLevel(paramInt, getLong(this.Ng.RZ), getLong(this.Ng.Sa));
      if (paramInt == i) {
        break label178;
      }
    }
    label178:
    for (paramDataHolder = new PlayerLevel(i, getLong(this.Ng.Sa), getLong(this.Ng.Sc));; paramDataHolder = paramString)
    {
      this.MX = new PlayerLevelInfo(getLong(this.Ng.RX), getLong(this.Ng.Sd), paramString, paramDataHolder);
      return;
      this.MX = null;
      return;
    }
  }
  
  private boolean gV()
  {
    if (ax(this.Ng.RX)) {}
    while (getLong(this.Ng.RX) == -1L) {
      return false;
    }
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return PlayerEntity.a(this, paramObject);
  }
  
  public Player freeze()
  {
    return new PlayerEntity(this);
  }
  
  public int gS()
  {
    return getInteger(this.Ng.RV);
  }
  
  public boolean gT()
  {
    return getBoolean(this.Ng.Sf);
  }
  
  public MostRecentGameInfo gU()
  {
    if (ax(this.Ng.Sg)) {
      return null;
    }
    return this.Nh;
  }
  
  public String getDisplayName()
  {
    return getString(this.Ng.RP);
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    a(this.Ng.RP, paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    return aw(this.Ng.RS);
  }
  
  public String getHiResImageUrl()
  {
    return getString(this.Ng.RT);
  }
  
  public Uri getIconImageUri()
  {
    return aw(this.Ng.RQ);
  }
  
  public String getIconImageUrl()
  {
    return getString(this.Ng.RR);
  }
  
  public long getLastPlayedWithTimestamp()
  {
    if ((!av(this.Ng.RW)) || (ax(this.Ng.RW))) {
      return -1L;
    }
    return getLong(this.Ng.RW);
  }
  
  public PlayerLevelInfo getLevelInfo()
  {
    return this.MX;
  }
  
  public String getPlayerId()
  {
    return getString(this.Ng.RO);
  }
  
  public long getRetrievedTimestamp()
  {
    return getLong(this.Ng.RU);
  }
  
  public String getTitle()
  {
    return getString(this.Ng.Se);
  }
  
  public void getTitle(CharArrayBuffer paramCharArrayBuffer)
  {
    a(this.Ng.Se, paramCharArrayBuffer);
  }
  
  public boolean hasHiResImage()
  {
    return getHiResImageUri() != null;
  }
  
  public boolean hasIconImage()
  {
    return getIconImageUri() != null;
  }
  
  public int hashCode()
  {
    return PlayerEntity.a(this);
  }
  
  public String toString()
  {
    return PlayerEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((PlayerEntity)freeze()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/PlayerRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */