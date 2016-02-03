package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.il;

public final class GameEntity
  extends GamesDowngradeableSafeParcel
  implements Game
{
  public static final Parcelable.Creator<GameEntity> CREATOR = new GameEntityCreatorCompat();
  private final String Lk;
  private final String MA;
  private final String MB;
  private final boolean MC;
  private final boolean MD;
  private final boolean ME;
  private final String Mk;
  private final String Ml;
  private final String Mm;
  private final String Mn;
  private final Uri Mo;
  private final Uri Mp;
  private final Uri Mq;
  private final boolean Mr;
  private final boolean Ms;
  private final String Mt;
  private final int Mu;
  private final int Mv;
  private final int Mw;
  private final boolean Mx;
  private final boolean My;
  private final String Mz;
  private final int xJ;
  private final String zM;
  
  GameEntity(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Uri paramUri1, Uri paramUri2, Uri paramUri3, boolean paramBoolean1, boolean paramBoolean2, String paramString7, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean3, boolean paramBoolean4, String paramString8, String paramString9, String paramString10, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    this.xJ = paramInt1;
    this.zM = paramString1;
    this.Lk = paramString2;
    this.Mk = paramString3;
    this.Ml = paramString4;
    this.Mm = paramString5;
    this.Mn = paramString6;
    this.Mo = paramUri1;
    this.Mz = paramString8;
    this.Mp = paramUri2;
    this.MA = paramString9;
    this.Mq = paramUri3;
    this.MB = paramString10;
    this.Mr = paramBoolean1;
    this.Ms = paramBoolean2;
    this.Mt = paramString7;
    this.Mu = paramInt2;
    this.Mv = paramInt3;
    this.Mw = paramInt4;
    this.Mx = paramBoolean3;
    this.My = paramBoolean4;
    this.MC = paramBoolean5;
    this.MD = paramBoolean6;
    this.ME = paramBoolean7;
  }
  
  public GameEntity(Game paramGame)
  {
    this.xJ = 4;
    this.zM = paramGame.getApplicationId();
    this.Mk = paramGame.getPrimaryCategory();
    this.Ml = paramGame.getSecondaryCategory();
    this.Mm = paramGame.getDescription();
    this.Mn = paramGame.getDeveloperName();
    this.Lk = paramGame.getDisplayName();
    this.Mo = paramGame.getIconImageUri();
    this.Mz = paramGame.getIconImageUrl();
    this.Mp = paramGame.getHiResImageUri();
    this.MA = paramGame.getHiResImageUrl();
    this.Mq = paramGame.getFeaturedImageUri();
    this.MB = paramGame.getFeaturedImageUrl();
    this.Mr = paramGame.gH();
    this.Ms = paramGame.gJ();
    this.Mt = paramGame.gK();
    this.Mu = paramGame.gL();
    this.Mv = paramGame.getAchievementTotalCount();
    this.Mw = paramGame.getLeaderboardCount();
    this.Mx = paramGame.isRealTimeMultiplayerEnabled();
    this.My = paramGame.isTurnBasedMultiplayerEnabled();
    this.MC = paramGame.isMuted();
    this.MD = paramGame.gI();
    this.ME = paramGame.areSnapshotsEnabled();
  }
  
  static int a(Game paramGame)
  {
    return hl.hashCode(new Object[] { paramGame.getApplicationId(), paramGame.getDisplayName(), paramGame.getPrimaryCategory(), paramGame.getSecondaryCategory(), paramGame.getDescription(), paramGame.getDeveloperName(), paramGame.getIconImageUri(), paramGame.getHiResImageUri(), paramGame.getFeaturedImageUri(), Boolean.valueOf(paramGame.gH()), Boolean.valueOf(paramGame.gJ()), paramGame.gK(), Integer.valueOf(paramGame.gL()), Integer.valueOf(paramGame.getAchievementTotalCount()), Integer.valueOf(paramGame.getLeaderboardCount()), Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled()), Boolean.valueOf(paramGame.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(paramGame.isMuted()), Boolean.valueOf(paramGame.gI()), Boolean.valueOf(paramGame.areSnapshotsEnabled()) });
  }
  
  static boolean a(Game paramGame, Object paramObject)
  {
    boolean bool2 = true;
    if (!(paramObject instanceof Game)) {
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (paramGame == paramObject);
    paramObject = (Game)paramObject;
    boolean bool3;
    if ((hl.equal(((Game)paramObject).getApplicationId(), paramGame.getApplicationId())) && (hl.equal(((Game)paramObject).getDisplayName(), paramGame.getDisplayName())) && (hl.equal(((Game)paramObject).getPrimaryCategory(), paramGame.getPrimaryCategory())) && (hl.equal(((Game)paramObject).getSecondaryCategory(), paramGame.getSecondaryCategory())) && (hl.equal(((Game)paramObject).getDescription(), paramGame.getDescription())) && (hl.equal(((Game)paramObject).getDeveloperName(), paramGame.getDeveloperName())) && (hl.equal(((Game)paramObject).getIconImageUri(), paramGame.getIconImageUri())) && (hl.equal(((Game)paramObject).getHiResImageUri(), paramGame.getHiResImageUri())) && (hl.equal(((Game)paramObject).getFeaturedImageUri(), paramGame.getFeaturedImageUri())) && (hl.equal(Boolean.valueOf(((Game)paramObject).gH()), Boolean.valueOf(paramGame.gH()))) && (hl.equal(Boolean.valueOf(((Game)paramObject).gJ()), Boolean.valueOf(paramGame.gJ()))) && (hl.equal(((Game)paramObject).gK(), paramGame.gK())) && (hl.equal(Integer.valueOf(((Game)paramObject).gL()), Integer.valueOf(paramGame.gL()))) && (hl.equal(Integer.valueOf(((Game)paramObject).getAchievementTotalCount()), Integer.valueOf(paramGame.getAchievementTotalCount()))) && (hl.equal(Integer.valueOf(((Game)paramObject).getLeaderboardCount()), Integer.valueOf(paramGame.getLeaderboardCount()))) && (hl.equal(Boolean.valueOf(((Game)paramObject).isRealTimeMultiplayerEnabled()), Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled()))))
    {
      bool3 = ((Game)paramObject).isTurnBasedMultiplayerEnabled();
      if ((!paramGame.isTurnBasedMultiplayerEnabled()) || (!hl.equal(Boolean.valueOf(((Game)paramObject).isMuted()), Boolean.valueOf(paramGame.isMuted()))) || (!hl.equal(Boolean.valueOf(((Game)paramObject).gI()), Boolean.valueOf(paramGame.gI())))) {
        break label459;
      }
    }
    label459:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (hl.equal(Boolean.valueOf(bool3), Boolean.valueOf(bool1)))
      {
        bool1 = bool2;
        if (hl.equal(Boolean.valueOf(((Game)paramObject).areSnapshotsEnabled()), Boolean.valueOf(paramGame.areSnapshotsEnabled()))) {
          break;
        }
      }
      return false;
    }
  }
  
  static String b(Game paramGame)
  {
    return hl.e(paramGame).a("ApplicationId", paramGame.getApplicationId()).a("DisplayName", paramGame.getDisplayName()).a("PrimaryCategory", paramGame.getPrimaryCategory()).a("SecondaryCategory", paramGame.getSecondaryCategory()).a("Description", paramGame.getDescription()).a("DeveloperName", paramGame.getDeveloperName()).a("IconImageUri", paramGame.getIconImageUri()).a("IconImageUrl", paramGame.getIconImageUrl()).a("HiResImageUri", paramGame.getHiResImageUri()).a("HiResImageUrl", paramGame.getHiResImageUrl()).a("FeaturedImageUri", paramGame.getFeaturedImageUri()).a("FeaturedImageUrl", paramGame.getFeaturedImageUrl()).a("PlayEnabledGame", Boolean.valueOf(paramGame.gH())).a("InstanceInstalled", Boolean.valueOf(paramGame.gJ())).a("InstancePackageName", paramGame.gK()).a("AchievementTotalCount", Integer.valueOf(paramGame.getAchievementTotalCount())).a("LeaderboardCount", Integer.valueOf(paramGame.getLeaderboardCount())).a("RealTimeMultiplayerEnabled", Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled())).a("TurnBasedMultiplayerEnabled", Boolean.valueOf(paramGame.isTurnBasedMultiplayerEnabled())).a("AreSnapshotsEnabled", Boolean.valueOf(paramGame.areSnapshotsEnabled())).toString();
  }
  
  public boolean areSnapshotsEnabled()
  {
    return this.ME;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Game freeze()
  {
    return this;
  }
  
  public boolean gH()
  {
    return this.Mr;
  }
  
  public boolean gI()
  {
    return this.MD;
  }
  
  public boolean gJ()
  {
    return this.Ms;
  }
  
  public String gK()
  {
    return this.Mt;
  }
  
  public int gL()
  {
    return this.Mu;
  }
  
  public int getAchievementTotalCount()
  {
    return this.Mv;
  }
  
  public String getApplicationId()
  {
    return this.zM;
  }
  
  public String getDescription()
  {
    return this.Mm;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.Mm, paramCharArrayBuffer);
  }
  
  public String getDeveloperName()
  {
    return this.Mn;
  }
  
  public void getDeveloperName(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.Mn, paramCharArrayBuffer);
  }
  
  public String getDisplayName()
  {
    return this.Lk;
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.Lk, paramCharArrayBuffer);
  }
  
  public Uri getFeaturedImageUri()
  {
    return this.Mq;
  }
  
  public String getFeaturedImageUrl()
  {
    return this.MB;
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
  
  public int getLeaderboardCount()
  {
    return this.Mw;
  }
  
  public String getPrimaryCategory()
  {
    return this.Mk;
  }
  
  public String getSecondaryCategory()
  {
    return this.Ml;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public boolean isMuted()
  {
    return this.MC;
  }
  
  public boolean isRealTimeMultiplayerEnabled()
  {
    return this.Mx;
  }
  
  public boolean isTurnBasedMultiplayerEnabled()
  {
    return this.My;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    Object localObject2 = null;
    if (!fm())
    {
      GameEntityCreator.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.zM);
    paramParcel.writeString(this.Lk);
    paramParcel.writeString(this.Mk);
    paramParcel.writeString(this.Ml);
    paramParcel.writeString(this.Mm);
    paramParcel.writeString(this.Mn);
    Object localObject1;
    if (this.Mo == null)
    {
      localObject1 = null;
      paramParcel.writeString((String)localObject1);
      if (this.Mp != null) {
        break label189;
      }
      localObject1 = null;
      label93:
      paramParcel.writeString((String)localObject1);
      if (this.Mq != null) {
        break label201;
      }
      localObject1 = localObject2;
      label110:
      paramParcel.writeString((String)localObject1);
      if (!this.Mr) {
        break label213;
      }
      paramInt = 1;
      label125:
      paramParcel.writeInt(paramInt);
      if (!this.Ms) {
        break label218;
      }
    }
    label189:
    label201:
    label213:
    label218:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.Mt);
      paramParcel.writeInt(this.Mu);
      paramParcel.writeInt(this.Mv);
      paramParcel.writeInt(this.Mw);
      return;
      localObject1 = this.Mo.toString();
      break;
      localObject1 = this.Mp.toString();
      break label93;
      localObject1 = this.Mq.toString();
      break label110;
      paramInt = 0;
      break label125;
    }
  }
  
  static final class GameEntityCreatorCompat
    extends GameEntityCreator
  {
    public GameEntity bd(Parcel paramParcel)
    {
      if ((GameEntity.b(GameEntity.gM())) || (GameEntity.aQ(GameEntity.class.getCanonicalName()))) {
        return super.bd(paramParcel);
      }
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      String str3 = paramParcel.readString();
      String str4 = paramParcel.readString();
      String str5 = paramParcel.readString();
      String str6 = paramParcel.readString();
      Object localObject1 = paramParcel.readString();
      Object localObject2;
      label90:
      Object localObject3;
      label104:
      boolean bool1;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = paramParcel.readString();
        if (localObject2 != null) {
          break label185;
        }
        localObject2 = null;
        localObject3 = paramParcel.readString();
        if (localObject3 != null) {
          break label195;
        }
        localObject3 = null;
        if (paramParcel.readInt() <= 0) {
          break label205;
        }
        bool1 = true;
        label113:
        if (paramParcel.readInt() <= 0) {
          break label210;
        }
      }
      label185:
      label195:
      label205:
      label210:
      for (boolean bool2 = true;; bool2 = false)
      {
        return new GameEntity(4, str1, str2, str3, str4, str5, str6, (Uri)localObject1, (Uri)localObject2, (Uri)localObject3, bool1, bool2, paramParcel.readString(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), false, false, null, null, null, false, false, false);
        localObject1 = Uri.parse((String)localObject1);
        break;
        localObject2 = Uri.parse((String)localObject2);
        break label90;
        localObject3 = Uri.parse((String)localObject3);
        break label104;
        bool1 = false;
        break label113;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/GameEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */