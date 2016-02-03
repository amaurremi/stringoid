package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hk.a;
import com.google.android.gms.internal.ik;

public final class PlayerEntity
  extends GamesDowngradeableSafeParcel
  implements Player
{
  public static final Parcelable.Creator<PlayerEntity> CREATOR = new c();
  private final String HY;
  private final String Ln;
  private final String MC;
  private final String MD;
  private final String MS;
  private final long MT;
  private final int MU;
  private final long MV;
  private final MostRecentGameInfoEntity MW;
  private final PlayerLevelInfo MX;
  private final boolean MY;
  private final Uri Mr;
  private final Uri Ms;
  private final int xM;
  
  PlayerEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, long paramLong1, int paramInt2, long paramLong2, String paramString3, String paramString4, String paramString5, MostRecentGameInfoEntity paramMostRecentGameInfoEntity, PlayerLevelInfo paramPlayerLevelInfo, boolean paramBoolean)
  {
    this.xM = paramInt1;
    this.MS = paramString1;
    this.Ln = paramString2;
    this.Mr = paramUri1;
    this.MC = paramString3;
    this.Ms = paramUri2;
    this.MD = paramString4;
    this.MT = paramLong1;
    this.MU = paramInt2;
    this.MV = paramLong2;
    this.HY = paramString5;
    this.MY = paramBoolean;
    this.MW = paramMostRecentGameInfoEntity;
    this.MX = paramPlayerLevelInfo;
  }
  
  public PlayerEntity(Player paramPlayer)
  {
    this.xM = 10;
    this.MS = paramPlayer.getPlayerId();
    this.Ln = paramPlayer.getDisplayName();
    this.Mr = paramPlayer.getIconImageUri();
    this.MC = paramPlayer.getIconImageUrl();
    this.Ms = paramPlayer.getHiResImageUri();
    this.MD = paramPlayer.getHiResImageUrl();
    this.MT = paramPlayer.getRetrievedTimestamp();
    this.MU = paramPlayer.gS();
    this.MV = paramPlayer.getLastPlayedWithTimestamp();
    this.HY = paramPlayer.getTitle();
    this.MY = paramPlayer.gT();
    Object localObject = paramPlayer.gU();
    if (localObject == null)
    {
      localObject = null;
      this.MW = ((MostRecentGameInfoEntity)localObject);
      this.MX = paramPlayer.getLevelInfo();
      gx.c(this.MS);
      gx.c(this.Ln);
      if (this.MT <= 0L) {
        break label190;
      }
    }
    label190:
    for (boolean bool = true;; bool = false)
    {
      gx.A(bool);
      return;
      localObject = new MostRecentGameInfoEntity((MostRecentGameInfo)localObject);
      break;
    }
  }
  
  static int a(Player paramPlayer)
  {
    return hk.hashCode(new Object[] { paramPlayer.getPlayerId(), paramPlayer.getDisplayName(), paramPlayer.getIconImageUri(), paramPlayer.getHiResImageUri(), Long.valueOf(paramPlayer.getRetrievedTimestamp()), paramPlayer.getTitle(), paramPlayer.getLevelInfo() });
  }
  
  static boolean a(Player paramPlayer, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Player)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramPlayer == paramObject);
      paramObject = (Player)paramObject;
      if ((!hk.equal(((Player)paramObject).getPlayerId(), paramPlayer.getPlayerId())) || (!hk.equal(((Player)paramObject).getDisplayName(), paramPlayer.getDisplayName())) || (!hk.equal(((Player)paramObject).getIconImageUri(), paramPlayer.getIconImageUri())) || (!hk.equal(((Player)paramObject).getHiResImageUri(), paramPlayer.getHiResImageUri())) || (!hk.equal(Long.valueOf(((Player)paramObject).getRetrievedTimestamp()), Long.valueOf(paramPlayer.getRetrievedTimestamp()))) || (!hk.equal(((Player)paramObject).getTitle(), paramPlayer.getTitle()))) {
        break;
      }
      bool1 = bool2;
    } while (hk.equal(((Player)paramObject).getLevelInfo(), paramPlayer.getLevelInfo()));
    return false;
  }
  
  static String b(Player paramPlayer)
  {
    return hk.e(paramPlayer).a("PlayerId", paramPlayer.getPlayerId()).a("DisplayName", paramPlayer.getDisplayName()).a("IconImageUri", paramPlayer.getIconImageUri()).a("IconImageUrl", paramPlayer.getIconImageUrl()).a("HiResImageUri", paramPlayer.getHiResImageUri()).a("HiResImageUrl", paramPlayer.getHiResImageUrl()).a("RetrievedTimestamp", Long.valueOf(paramPlayer.getRetrievedTimestamp())).a("Title", paramPlayer.getTitle()).a("LevelInfo", paramPlayer.getLevelInfo()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Player freeze()
  {
    return this;
  }
  
  public int gS()
  {
    return this.MU;
  }
  
  public boolean gT()
  {
    return this.MY;
  }
  
  public MostRecentGameInfo gU()
  {
    return this.MW;
  }
  
  public String getDisplayName()
  {
    return this.Ln;
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    ik.b(this.Ln, paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    return this.Ms;
  }
  
  public String getHiResImageUrl()
  {
    return this.MD;
  }
  
  public Uri getIconImageUri()
  {
    return this.Mr;
  }
  
  public String getIconImageUrl()
  {
    return this.MC;
  }
  
  public long getLastPlayedWithTimestamp()
  {
    return this.MV;
  }
  
  public PlayerLevelInfo getLevelInfo()
  {
    return this.MX;
  }
  
  public String getPlayerId()
  {
    return this.MS;
  }
  
  public long getRetrievedTimestamp()
  {
    return this.MT;
  }
  
  public String getTitle()
  {
    return this.HY;
  }
  
  public void getTitle(CharArrayBuffer paramCharArrayBuffer)
  {
    ik.b(this.HY, paramCharArrayBuffer);
  }
  
  public int getVersionCode()
  {
    return this.xM;
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
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject2 = null;
    if (!fr())
    {
      PlayerEntityCreator.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.MS);
    paramParcel.writeString(this.Ln);
    if (this.Mr == null)
    {
      localObject1 = null;
      paramParcel.writeString((String)localObject1);
      if (this.Ms != null) {
        break label82;
      }
    }
    label82:
    for (Object localObject1 = localObject2;; localObject1 = this.Ms.toString())
    {
      paramParcel.writeString((String)localObject1);
      paramParcel.writeLong(this.MT);
      return;
      localObject1 = this.Mr.toString();
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/PlayerEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */