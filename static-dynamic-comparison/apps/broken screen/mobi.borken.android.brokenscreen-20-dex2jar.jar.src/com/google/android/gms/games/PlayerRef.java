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
  private final PlayerLevelInfo MU;
  private final PlayerColumnNames Nd;
  private final MostRecentGameInfoRef Ne;
  
  public PlayerRef(DataHolder paramDataHolder, int paramInt)
  {
    this(paramDataHolder, paramInt, null);
  }
  
  public PlayerRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt);
    this.Nd = new PlayerColumnNames(paramString);
    this.Ne = new MostRecentGameInfoRef(paramDataHolder, paramInt, this.Nd);
    int i;
    if (gQ())
    {
      paramInt = getInteger(this.Nd.RV);
      i = getInteger(this.Nd.RY);
      paramString = new PlayerLevel(paramInt, getLong(this.Nd.RW), getLong(this.Nd.RX));
      if (paramInt == i) {
        break label178;
      }
    }
    label178:
    for (paramDataHolder = new PlayerLevel(i, getLong(this.Nd.RX), getLong(this.Nd.RZ));; paramDataHolder = paramString)
    {
      this.MU = new PlayerLevelInfo(getLong(this.Nd.RU), getLong(this.Nd.Sa), paramString, paramDataHolder);
      return;
      this.MU = null;
      return;
    }
  }
  
  private boolean gQ()
  {
    if (ax(this.Nd.RU)) {}
    while (getLong(this.Nd.RU) == -1L) {
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
  
  public int gN()
  {
    return getInteger(this.Nd.RS);
  }
  
  public boolean gO()
  {
    return getBoolean(this.Nd.Sc);
  }
  
  public MostRecentGameInfo gP()
  {
    if (ax(this.Nd.Sd)) {
      return null;
    }
    return this.Ne;
  }
  
  public String getDisplayName()
  {
    return getString(this.Nd.RM);
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    a(this.Nd.RM, paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    return aw(this.Nd.RP);
  }
  
  public String getHiResImageUrl()
  {
    return getString(this.Nd.RQ);
  }
  
  public Uri getIconImageUri()
  {
    return aw(this.Nd.RN);
  }
  
  public String getIconImageUrl()
  {
    return getString(this.Nd.RO);
  }
  
  public long getLastPlayedWithTimestamp()
  {
    if ((!av(this.Nd.RT)) || (ax(this.Nd.RT))) {
      return -1L;
    }
    return getLong(this.Nd.RT);
  }
  
  public PlayerLevelInfo getLevelInfo()
  {
    return this.MU;
  }
  
  public String getPlayerId()
  {
    return getString(this.Nd.RL);
  }
  
  public long getRetrievedTimestamp()
  {
    return getLong(this.Nd.RR);
  }
  
  public String getTitle()
  {
    return getString(this.Nd.Sb);
  }
  
  public void getTitle(CharArrayBuffer paramCharArrayBuffer)
  {
    a(this.Nd.Sb, paramCharArrayBuffer);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/PlayerRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */