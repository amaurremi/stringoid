package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.a;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.internal.jv;

public final class PlayerEntity
  extends GamesDowngradeableSafeParcel
  implements Player
{
  public static final Parcelable.Creator<PlayerEntity> CREATOR = new PlayerEntityCreatorCompat();
  private final int BR;
  private final String No;
  private final String Nz;
  private final Uri UW;
  private final Uri UX;
  private final long VA;
  private final int VB;
  private final long VC;
  private final MostRecentGameInfoEntity VD;
  private final PlayerLevelInfo VE;
  private final boolean VF;
  private final String Vh;
  private final String Vi;
  private final String Vz;
  
  PlayerEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, long paramLong1, int paramInt2, long paramLong2, String paramString3, String paramString4, String paramString5, MostRecentGameInfoEntity paramMostRecentGameInfoEntity, PlayerLevelInfo paramPlayerLevelInfo, boolean paramBoolean)
  {
    this.BR = paramInt1;
    this.Vz = paramString1;
    this.Nz = paramString2;
    this.UW = paramUri1;
    this.Vh = paramString3;
    this.UX = paramUri2;
    this.Vi = paramString4;
    this.VA = paramLong1;
    this.VB = paramInt2;
    this.VC = paramLong2;
    this.No = paramString5;
    this.VF = paramBoolean;
    this.VD = paramMostRecentGameInfoEntity;
    this.VE = paramPlayerLevelInfo;
  }
  
  public PlayerEntity(Player paramPlayer)
  {
    this.BR = 11;
    this.Vz = paramPlayer.getPlayerId();
    this.Nz = paramPlayer.getDisplayName();
    this.UW = paramPlayer.getIconImageUri();
    this.Vh = paramPlayer.getIconImageUrl();
    this.UX = paramPlayer.getHiResImageUri();
    this.Vi = paramPlayer.getHiResImageUrl();
    this.VA = paramPlayer.getRetrievedTimestamp();
    this.VB = paramPlayer.jR();
    this.VC = paramPlayer.getLastPlayedWithTimestamp();
    this.No = paramPlayer.getTitle();
    this.VF = paramPlayer.isProfileVisible();
    Object localObject = paramPlayer.jS();
    if (localObject == null)
    {
      localObject = null;
      this.VD = ((MostRecentGameInfoEntity)localObject);
      this.VE = paramPlayer.getLevelInfo();
      a.f(this.Vz);
      a.f(this.Nz);
      if (this.VA <= 0L) {
        break label190;
      }
    }
    label190:
    for (boolean bool = true;; bool = false)
    {
      a.I(bool);
      return;
      localObject = new MostRecentGameInfoEntity((MostRecentGameInfo)localObject);
      break;
    }
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
      if ((!m.equal(((Player)paramObject).getPlayerId(), paramPlayer.getPlayerId())) || (!m.equal(((Player)paramObject).getDisplayName(), paramPlayer.getDisplayName())) || (!m.equal(((Player)paramObject).getIconImageUri(), paramPlayer.getIconImageUri())) || (!m.equal(((Player)paramObject).getHiResImageUri(), paramPlayer.getHiResImageUri())) || (!m.equal(Long.valueOf(((Player)paramObject).getRetrievedTimestamp()), Long.valueOf(paramPlayer.getRetrievedTimestamp()))) || (!m.equal(((Player)paramObject).getTitle(), paramPlayer.getTitle()))) {
        break;
      }
      bool1 = bool2;
    } while (m.equal(((Player)paramObject).getLevelInfo(), paramPlayer.getLevelInfo()));
    return false;
  }
  
  static int b(Player paramPlayer)
  {
    return m.hashCode(new Object[] { paramPlayer.getPlayerId(), paramPlayer.getDisplayName(), paramPlayer.getIconImageUri(), paramPlayer.getHiResImageUri(), Long.valueOf(paramPlayer.getRetrievedTimestamp()), paramPlayer.getTitle(), paramPlayer.getLevelInfo() });
  }
  
  static String c(Player paramPlayer)
  {
    return m.h(paramPlayer).a("PlayerId", paramPlayer.getPlayerId()).a("DisplayName", paramPlayer.getDisplayName()).a("IconImageUri", paramPlayer.getIconImageUri()).a("IconImageUrl", paramPlayer.getIconImageUrl()).a("HiResImageUri", paramPlayer.getHiResImageUri()).a("HiResImageUrl", paramPlayer.getHiResImageUrl()).a("RetrievedTimestamp", Long.valueOf(paramPlayer.getRetrievedTimestamp())).a("Title", paramPlayer.getTitle()).a("LevelInfo", paramPlayer.getLevelInfo()).toString();
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
  
  public String getDisplayName()
  {
    return this.Nz;
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    jv.b(this.Nz, paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    return this.UX;
  }
  
  public String getHiResImageUrl()
  {
    return this.Vi;
  }
  
  public Uri getIconImageUri()
  {
    return this.UW;
  }
  
  public String getIconImageUrl()
  {
    return this.Vh;
  }
  
  public long getLastPlayedWithTimestamp()
  {
    return this.VC;
  }
  
  public PlayerLevelInfo getLevelInfo()
  {
    return this.VE;
  }
  
  public String getPlayerId()
  {
    return this.Vz;
  }
  
  public long getRetrievedTimestamp()
  {
    return this.VA;
  }
  
  public String getTitle()
  {
    return this.No;
  }
  
  public void getTitle(CharArrayBuffer paramCharArrayBuffer)
  {
    jv.b(this.No, paramCharArrayBuffer);
  }
  
  public int getVersionCode()
  {
    return this.BR;
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
    return b(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public boolean isProfileVisible()
  {
    return this.VF;
  }
  
  public int jR()
  {
    return this.VB;
  }
  
  public MostRecentGameInfo jS()
  {
    return this.VD;
  }
  
  public String toString()
  {
    return c(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject2 = null;
    if (!gQ())
    {
      PlayerEntityCreator.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.Vz);
    paramParcel.writeString(this.Nz);
    if (this.UW == null)
    {
      localObject1 = null;
      paramParcel.writeString((String)localObject1);
      if (this.UX != null) {
        break label82;
      }
    }
    label82:
    for (Object localObject1 = localObject2;; localObject1 = this.UX.toString())
    {
      paramParcel.writeString((String)localObject1);
      paramParcel.writeLong(this.VA);
      return;
      localObject1 = this.UW.toString();
      break;
    }
  }
  
  static final class PlayerEntityCreatorCompat
    extends PlayerEntityCreator
  {
    public PlayerEntity ce(Parcel paramParcel)
    {
      if ((PlayerEntity.b(PlayerEntity.jQ())) || (PlayerEntity.bt(PlayerEntity.class.getCanonicalName()))) {
        return super.ce(paramParcel);
      }
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      Object localObject1 = paramParcel.readString();
      Object localObject2 = paramParcel.readString();
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject2 != null) {
          break label98;
        }
      }
      label98:
      for (localObject2 = null;; localObject2 = Uri.parse((String)localObject2))
      {
        return new PlayerEntity(11, str1, str2, (Uri)localObject1, (Uri)localObject2, paramParcel.readLong(), -1, -1L, null, null, null, null, null, true);
        localObject1 = Uri.parse((String)localObject1);
        break;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/PlayerEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */