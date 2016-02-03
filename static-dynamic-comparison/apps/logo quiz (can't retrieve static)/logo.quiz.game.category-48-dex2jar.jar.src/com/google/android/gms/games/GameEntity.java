package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.jv;

public final class GameEntity
  extends GamesDowngradeableSafeParcel
  implements Game
{
  public static final Parcelable.Creator<GameEntity> CREATOR = new GameEntityCreatorCompat();
  private final int BR;
  private final String Ez;
  private final String Nz;
  private final String Tg;
  private final String UT;
  private final String UU;
  private final String UV;
  private final Uri UW;
  private final Uri UX;
  private final Uri UY;
  private final boolean UZ;
  private final boolean Va;
  private final String Vb;
  private final int Vc;
  private final int Vd;
  private final int Ve;
  private final boolean Vf;
  private final boolean Vg;
  private final String Vh;
  private final String Vi;
  private final String Vj;
  private final boolean Vk;
  private final boolean Vl;
  private final boolean Vm;
  private final String Vn;
  
  GameEntity(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Uri paramUri1, Uri paramUri2, Uri paramUri3, boolean paramBoolean1, boolean paramBoolean2, String paramString7, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean3, boolean paramBoolean4, String paramString8, String paramString9, String paramString10, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, String paramString11)
  {
    this.BR = paramInt1;
    this.Ez = paramString1;
    this.Nz = paramString2;
    this.UT = paramString3;
    this.UU = paramString4;
    this.Tg = paramString5;
    this.UV = paramString6;
    this.UW = paramUri1;
    this.Vh = paramString8;
    this.UX = paramUri2;
    this.Vi = paramString9;
    this.UY = paramUri3;
    this.Vj = paramString10;
    this.UZ = paramBoolean1;
    this.Va = paramBoolean2;
    this.Vb = paramString7;
    this.Vc = paramInt2;
    this.Vd = paramInt3;
    this.Ve = paramInt4;
    this.Vf = paramBoolean3;
    this.Vg = paramBoolean4;
    this.Vk = paramBoolean5;
    this.Vl = paramBoolean6;
    this.Vm = paramBoolean7;
    this.Vn = paramString11;
  }
  
  public GameEntity(Game paramGame)
  {
    this.BR = 5;
    this.Ez = paramGame.getApplicationId();
    this.UT = paramGame.getPrimaryCategory();
    this.UU = paramGame.getSecondaryCategory();
    this.Tg = paramGame.getDescription();
    this.UV = paramGame.getDeveloperName();
    this.Nz = paramGame.getDisplayName();
    this.UW = paramGame.getIconImageUri();
    this.Vh = paramGame.getIconImageUrl();
    this.UX = paramGame.getHiResImageUri();
    this.Vi = paramGame.getHiResImageUrl();
    this.UY = paramGame.getFeaturedImageUri();
    this.Vj = paramGame.getFeaturedImageUrl();
    this.UZ = paramGame.jL();
    this.Va = paramGame.jN();
    this.Vb = paramGame.jO();
    this.Vc = paramGame.jP();
    this.Vd = paramGame.getAchievementTotalCount();
    this.Ve = paramGame.getLeaderboardCount();
    this.Vf = paramGame.isRealTimeMultiplayerEnabled();
    this.Vg = paramGame.isTurnBasedMultiplayerEnabled();
    this.Vk = paramGame.isMuted();
    this.Vl = paramGame.jM();
    this.Vm = paramGame.areSnapshotsEnabled();
    this.Vn = paramGame.getThemeColor();
  }
  
  static int a(Game paramGame)
  {
    return m.hashCode(new Object[] { paramGame.getApplicationId(), paramGame.getDisplayName(), paramGame.getPrimaryCategory(), paramGame.getSecondaryCategory(), paramGame.getDescription(), paramGame.getDeveloperName(), paramGame.getIconImageUri(), paramGame.getHiResImageUri(), paramGame.getFeaturedImageUri(), Boolean.valueOf(paramGame.jL()), Boolean.valueOf(paramGame.jN()), paramGame.jO(), Integer.valueOf(paramGame.jP()), Integer.valueOf(paramGame.getAchievementTotalCount()), Integer.valueOf(paramGame.getLeaderboardCount()), Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled()), Boolean.valueOf(paramGame.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(paramGame.isMuted()), Boolean.valueOf(paramGame.jM()), Boolean.valueOf(paramGame.areSnapshotsEnabled()), paramGame.getThemeColor() });
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
    if ((m.equal(((Game)paramObject).getApplicationId(), paramGame.getApplicationId())) && (m.equal(((Game)paramObject).getDisplayName(), paramGame.getDisplayName())) && (m.equal(((Game)paramObject).getPrimaryCategory(), paramGame.getPrimaryCategory())) && (m.equal(((Game)paramObject).getSecondaryCategory(), paramGame.getSecondaryCategory())) && (m.equal(((Game)paramObject).getDescription(), paramGame.getDescription())) && (m.equal(((Game)paramObject).getDeveloperName(), paramGame.getDeveloperName())) && (m.equal(((Game)paramObject).getIconImageUri(), paramGame.getIconImageUri())) && (m.equal(((Game)paramObject).getHiResImageUri(), paramGame.getHiResImageUri())) && (m.equal(((Game)paramObject).getFeaturedImageUri(), paramGame.getFeaturedImageUri())) && (m.equal(Boolean.valueOf(((Game)paramObject).jL()), Boolean.valueOf(paramGame.jL()))) && (m.equal(Boolean.valueOf(((Game)paramObject).jN()), Boolean.valueOf(paramGame.jN()))) && (m.equal(((Game)paramObject).jO(), paramGame.jO())) && (m.equal(Integer.valueOf(((Game)paramObject).jP()), Integer.valueOf(paramGame.jP()))) && (m.equal(Integer.valueOf(((Game)paramObject).getAchievementTotalCount()), Integer.valueOf(paramGame.getAchievementTotalCount()))) && (m.equal(Integer.valueOf(((Game)paramObject).getLeaderboardCount()), Integer.valueOf(paramGame.getLeaderboardCount()))) && (m.equal(Boolean.valueOf(((Game)paramObject).isRealTimeMultiplayerEnabled()), Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled()))))
    {
      bool3 = ((Game)paramObject).isTurnBasedMultiplayerEnabled();
      if ((!paramGame.isTurnBasedMultiplayerEnabled()) || (!m.equal(Boolean.valueOf(((Game)paramObject).isMuted()), Boolean.valueOf(paramGame.isMuted()))) || (!m.equal(Boolean.valueOf(((Game)paramObject).jM()), Boolean.valueOf(paramGame.jM())))) {
        break label477;
      }
    }
    label477:
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((m.equal(Boolean.valueOf(bool3), Boolean.valueOf(bool1))) && (m.equal(Boolean.valueOf(((Game)paramObject).areSnapshotsEnabled()), Boolean.valueOf(paramGame.areSnapshotsEnabled()))))
      {
        bool1 = bool2;
        if (m.equal(((Game)paramObject).getThemeColor(), paramGame.getThemeColor())) {
          break;
        }
      }
      return false;
    }
  }
  
  static String b(Game paramGame)
  {
    return m.h(paramGame).a("ApplicationId", paramGame.getApplicationId()).a("DisplayName", paramGame.getDisplayName()).a("PrimaryCategory", paramGame.getPrimaryCategory()).a("SecondaryCategory", paramGame.getSecondaryCategory()).a("Description", paramGame.getDescription()).a("DeveloperName", paramGame.getDeveloperName()).a("IconImageUri", paramGame.getIconImageUri()).a("IconImageUrl", paramGame.getIconImageUrl()).a("HiResImageUri", paramGame.getHiResImageUri()).a("HiResImageUrl", paramGame.getHiResImageUrl()).a("FeaturedImageUri", paramGame.getFeaturedImageUri()).a("FeaturedImageUrl", paramGame.getFeaturedImageUrl()).a("PlayEnabledGame", Boolean.valueOf(paramGame.jL())).a("InstanceInstalled", Boolean.valueOf(paramGame.jN())).a("InstancePackageName", paramGame.jO()).a("AchievementTotalCount", Integer.valueOf(paramGame.getAchievementTotalCount())).a("LeaderboardCount", Integer.valueOf(paramGame.getLeaderboardCount())).a("RealTimeMultiplayerEnabled", Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled())).a("TurnBasedMultiplayerEnabled", Boolean.valueOf(paramGame.isTurnBasedMultiplayerEnabled())).a("AreSnapshotsEnabled", Boolean.valueOf(paramGame.areSnapshotsEnabled())).a("ThemeColor", paramGame.getThemeColor()).toString();
  }
  
  public boolean areSnapshotsEnabled()
  {
    return this.Vm;
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
  
  public int getAchievementTotalCount()
  {
    return this.Vd;
  }
  
  public String getApplicationId()
  {
    return this.Ez;
  }
  
  public String getDescription()
  {
    return this.Tg;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    jv.b(this.Tg, paramCharArrayBuffer);
  }
  
  public String getDeveloperName()
  {
    return this.UV;
  }
  
  public void getDeveloperName(CharArrayBuffer paramCharArrayBuffer)
  {
    jv.b(this.UV, paramCharArrayBuffer);
  }
  
  public String getDisplayName()
  {
    return this.Nz;
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    jv.b(this.Nz, paramCharArrayBuffer);
  }
  
  public Uri getFeaturedImageUri()
  {
    return this.UY;
  }
  
  public String getFeaturedImageUrl()
  {
    return this.Vj;
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
  
  public int getLeaderboardCount()
  {
    return this.Ve;
  }
  
  public String getPrimaryCategory()
  {
    return this.UT;
  }
  
  public String getSecondaryCategory()
  {
    return this.UU;
  }
  
  public String getThemeColor()
  {
    return this.Vn;
  }
  
  public int getVersionCode()
  {
    return this.BR;
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
    return this.Vk;
  }
  
  public boolean isRealTimeMultiplayerEnabled()
  {
    return this.Vf;
  }
  
  public boolean isTurnBasedMultiplayerEnabled()
  {
    return this.Vg;
  }
  
  public boolean jL()
  {
    return this.UZ;
  }
  
  public boolean jM()
  {
    return this.Vl;
  }
  
  public boolean jN()
  {
    return this.Va;
  }
  
  public String jO()
  {
    return this.Vb;
  }
  
  public int jP()
  {
    return this.Vc;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    Object localObject2 = null;
    if (!gQ())
    {
      GameEntityCreator.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.Ez);
    paramParcel.writeString(this.Nz);
    paramParcel.writeString(this.UT);
    paramParcel.writeString(this.UU);
    paramParcel.writeString(this.Tg);
    paramParcel.writeString(this.UV);
    Object localObject1;
    if (this.UW == null)
    {
      localObject1 = null;
      paramParcel.writeString((String)localObject1);
      if (this.UX != null) {
        break label189;
      }
      localObject1 = null;
      label93:
      paramParcel.writeString((String)localObject1);
      if (this.UY != null) {
        break label201;
      }
      localObject1 = localObject2;
      label110:
      paramParcel.writeString((String)localObject1);
      if (!this.UZ) {
        break label213;
      }
      paramInt = 1;
      label125:
      paramParcel.writeInt(paramInt);
      if (!this.Va) {
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
      paramParcel.writeString(this.Vb);
      paramParcel.writeInt(this.Vc);
      paramParcel.writeInt(this.Vd);
      paramParcel.writeInt(this.Ve);
      return;
      localObject1 = this.UW.toString();
      break;
      localObject1 = this.UX.toString();
      break label93;
      localObject1 = this.UY.toString();
      break label110;
      paramInt = 0;
      break label125;
    }
  }
  
  static final class GameEntityCreatorCompat
    extends GameEntityCreator
  {
    public GameEntity cd(Parcel paramParcel)
    {
      if ((GameEntity.b(GameEntity.jQ())) || (GameEntity.bt(GameEntity.class.getCanonicalName()))) {
        return super.cd(paramParcel);
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
          break label186;
        }
        localObject2 = null;
        localObject3 = paramParcel.readString();
        if (localObject3 != null) {
          break label196;
        }
        localObject3 = null;
        if (paramParcel.readInt() <= 0) {
          break label206;
        }
        bool1 = true;
        label113:
        if (paramParcel.readInt() <= 0) {
          break label211;
        }
      }
      label186:
      label196:
      label206:
      label211:
      for (boolean bool2 = true;; bool2 = false)
      {
        return new GameEntity(5, str1, str2, str3, str4, str5, str6, (Uri)localObject1, (Uri)localObject2, (Uri)localObject3, bool1, bool2, paramParcel.readString(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), false, false, null, null, null, false, false, false, null);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/GameEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */