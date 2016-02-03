package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.il;

public final class PlayerEntity
  extends GamesDowngradeableSafeParcel
  implements Player
{
  public static final Parcelable.Creator<PlayerEntity> CREATOR = new PlayerEntityCreatorCompat();
  private final String HV;
  private final String Lk;
  private final String MA;
  private final String MP;
  private final long MQ;
  private final int MR;
  private final long MS;
  private final MostRecentGameInfoEntity MT;
  private final PlayerLevelInfo MU;
  private final boolean MV;
  private final Uri Mo;
  private final Uri Mp;
  private final String Mz;
  private final int xJ;
  
  PlayerEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, long paramLong1, int paramInt2, long paramLong2, String paramString3, String paramString4, String paramString5, MostRecentGameInfoEntity paramMostRecentGameInfoEntity, PlayerLevelInfo paramPlayerLevelInfo, boolean paramBoolean)
  {
    this.xJ = paramInt1;
    this.MP = paramString1;
    this.Lk = paramString2;
    this.Mo = paramUri1;
    this.Mz = paramString3;
    this.Mp = paramUri2;
    this.MA = paramString4;
    this.MQ = paramLong1;
    this.MR = paramInt2;
    this.MS = paramLong2;
    this.HV = paramString5;
    this.MV = paramBoolean;
    this.MT = paramMostRecentGameInfoEntity;
    this.MU = paramPlayerLevelInfo;
  }
  
  public PlayerEntity(Player paramPlayer)
  {
    this.xJ = 10;
    this.MP = paramPlayer.getPlayerId();
    this.Lk = paramPlayer.getDisplayName();
    this.Mo = paramPlayer.getIconImageUri();
    this.Mz = paramPlayer.getIconImageUrl();
    this.Mp = paramPlayer.getHiResImageUri();
    this.MA = paramPlayer.getHiResImageUrl();
    this.MQ = paramPlayer.getRetrievedTimestamp();
    this.MR = paramPlayer.gN();
    this.MS = paramPlayer.getLastPlayedWithTimestamp();
    this.HV = paramPlayer.getTitle();
    this.MV = paramPlayer.gO();
    Object localObject = paramPlayer.gP();
    if (localObject == null)
    {
      localObject = null;
      this.MT = ((MostRecentGameInfoEntity)localObject);
      this.MU = paramPlayer.getLevelInfo();
      gy.c(this.MP);
      gy.c(this.Lk);
      if (this.MQ <= 0L) {
        break label190;
      }
    }
    label190:
    for (boolean bool = true;; bool = false)
    {
      gy.A(bool);
      return;
      localObject = new MostRecentGameInfoEntity((MostRecentGameInfo)localObject);
      break;
    }
  }
  
  static int a(Player paramPlayer)
  {
    return hl.hashCode(new Object[] { paramPlayer.getPlayerId(), paramPlayer.getDisplayName(), paramPlayer.getIconImageUri(), paramPlayer.getHiResImageUri(), Long.valueOf(paramPlayer.getRetrievedTimestamp()), paramPlayer.getTitle(), paramPlayer.getLevelInfo() });
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
      if ((!hl.equal(((Player)paramObject).getPlayerId(), paramPlayer.getPlayerId())) || (!hl.equal(((Player)paramObject).getDisplayName(), paramPlayer.getDisplayName())) || (!hl.equal(((Player)paramObject).getIconImageUri(), paramPlayer.getIconImageUri())) || (!hl.equal(((Player)paramObject).getHiResImageUri(), paramPlayer.getHiResImageUri())) || (!hl.equal(Long.valueOf(((Player)paramObject).getRetrievedTimestamp()), Long.valueOf(paramPlayer.getRetrievedTimestamp()))) || (!hl.equal(((Player)paramObject).getTitle(), paramPlayer.getTitle()))) {
        break;
      }
      bool1 = bool2;
    } while (hl.equal(((Player)paramObject).getLevelInfo(), paramPlayer.getLevelInfo()));
    return false;
  }
  
  static String b(Player paramPlayer)
  {
    return hl.e(paramPlayer).a("PlayerId", paramPlayer.getPlayerId()).a("DisplayName", paramPlayer.getDisplayName()).a("IconImageUri", paramPlayer.getIconImageUri()).a("IconImageUrl", paramPlayer.getIconImageUrl()).a("HiResImageUri", paramPlayer.getHiResImageUri()).a("HiResImageUrl", paramPlayer.getHiResImageUrl()).a("RetrievedTimestamp", Long.valueOf(paramPlayer.getRetrievedTimestamp())).a("Title", paramPlayer.getTitle()).a("LevelInfo", paramPlayer.getLevelInfo()).toString();
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
  
  public int gN()
  {
    return this.MR;
  }
  
  public boolean gO()
  {
    return this.MV;
  }
  
  public MostRecentGameInfo gP()
  {
    return this.MT;
  }
  
  public String getDisplayName()
  {
    return this.Lk;
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.Lk, paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    return this.Mp;
  }
  
  public String getHiResImageUrl()
  {
    return this.MA;
  }
  
  public Uri getIconImageUri()
  {
    return this.Mo;
  }
  
  public String getIconImageUrl()
  {
    return this.Mz;
  }
  
  public long getLastPlayedWithTimestamp()
  {
    return this.MS;
  }
  
  public PlayerLevelInfo getLevelInfo()
  {
    return this.MU;
  }
  
  public String getPlayerId()
  {
    return this.MP;
  }
  
  public long getRetrievedTimestamp()
  {
    return this.MQ;
  }
  
  public String getTitle()
  {
    return this.HV;
  }
  
  public void getTitle(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.HV, paramCharArrayBuffer);
  }
  
  public int getVersionCode()
  {
    return this.xJ;
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
    if (!fm())
    {
      PlayerEntityCreator.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.MP);
    paramParcel.writeString(this.Lk);
    if (this.Mo == null)
    {
      localObject1 = null;
      paramParcel.writeString((String)localObject1);
      if (this.Mp != null) {
        break label82;
      }
    }
    label82:
    for (Object localObject1 = localObject2;; localObject1 = this.Mp.toString())
    {
      paramParcel.writeString((String)localObject1);
      paramParcel.writeLong(this.MQ);
      return;
      localObject1 = this.Mo.toString();
      break;
    }
  }
  
  static final class PlayerEntityCreatorCompat
    extends PlayerEntityCreator
  {
    public PlayerEntity be(Parcel paramParcel)
    {
      if ((PlayerEntity.b(PlayerEntity.gM())) || (PlayerEntity.aQ(PlayerEntity.class.getCanonicalName()))) {
        return super.be(paramParcel);
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
        return new PlayerEntity(10, str1, str2, (Uri)localObject1, (Uri)localObject2, paramParcel.readLong(), -1, -1L, null, null, null, null, null, true);
        localObject1 = Uri.parse((String)localObject1);
        break;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/PlayerEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */