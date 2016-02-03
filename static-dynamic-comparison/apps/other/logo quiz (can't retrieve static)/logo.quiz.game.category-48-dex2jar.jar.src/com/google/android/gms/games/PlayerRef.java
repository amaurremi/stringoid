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
  private final PlayerLevelInfo VE;
  private final PlayerColumnNames VN;
  private final MostRecentGameInfoRef VO;
  
  public PlayerRef(DataHolder paramDataHolder, int paramInt)
  {
    this(paramDataHolder, paramInt, null);
  }
  
  public PlayerRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt);
    this.VN = new PlayerColumnNames(paramString);
    this.VO = new MostRecentGameInfoRef(paramDataHolder, paramInt, this.VN);
    int i;
    if (jT())
    {
      paramInt = getInteger(this.VN.aaR);
      i = getInteger(this.VN.aaU);
      paramString = new PlayerLevel(paramInt, getLong(this.VN.aaS), getLong(this.VN.aaT));
      if (paramInt == i) {
        break label178;
      }
    }
    label178:
    for (paramDataHolder = new PlayerLevel(i, getLong(this.VN.aaT), getLong(this.VN.aaV));; paramDataHolder = paramString)
    {
      this.VE = new PlayerLevelInfo(getLong(this.VN.aaQ), getLong(this.VN.aaW), paramString, paramDataHolder);
      return;
      this.VE = null;
      return;
    }
  }
  
  private boolean jT()
  {
    if (aS(this.VN.aaQ)) {}
    while (getLong(this.VN.aaQ) == -1L) {
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
  
  public String getDisplayName()
  {
    return getString(this.VN.aaI);
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    a(this.VN.aaI, paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    return aR(this.VN.aaL);
  }
  
  public String getHiResImageUrl()
  {
    return getString(this.VN.aaM);
  }
  
  public Uri getIconImageUri()
  {
    return aR(this.VN.aaJ);
  }
  
  public String getIconImageUrl()
  {
    return getString(this.VN.aaK);
  }
  
  public long getLastPlayedWithTimestamp()
  {
    if ((!aQ(this.VN.aaP)) || (aS(this.VN.aaP))) {
      return -1L;
    }
    return getLong(this.VN.aaP);
  }
  
  public PlayerLevelInfo getLevelInfo()
  {
    return this.VE;
  }
  
  public String getPlayerId()
  {
    return getString(this.VN.aaH);
  }
  
  public long getRetrievedTimestamp()
  {
    return getLong(this.VN.aaN);
  }
  
  public String getTitle()
  {
    return getString(this.VN.aaX);
  }
  
  public void getTitle(CharArrayBuffer paramCharArrayBuffer)
  {
    a(this.VN.aaX, paramCharArrayBuffer);
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
    return PlayerEntity.b(this);
  }
  
  public boolean isProfileVisible()
  {
    return getBoolean(this.VN.aaZ);
  }
  
  public int jR()
  {
    return getInteger(this.VN.aaO);
  }
  
  public MostRecentGameInfo jS()
  {
    if (aS(this.VN.aba)) {
      return null;
    }
    return this.VO;
  }
  
  public String toString()
  {
    return PlayerEntity.c(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((PlayerEntity)freeze()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/PlayerRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */