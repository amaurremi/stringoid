package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hk.a;
import com.google.android.gms.internal.ik;

public final class GameEntity
  extends GamesDowngradeableSafeParcel
  implements Game
{
  public static final Parcelable.Creator<GameEntity> CREATOR = new a();
  private final String Ln;
  private final boolean MA;
  private final boolean MB;
  private final String MC;
  private final String MD;
  private final String ME;
  private final boolean MF;
  private final boolean MG;
  private final boolean MH;
  private final String Mn;
  private final String Mo;
  private final String Mp;
  private final String Mq;
  private final Uri Mr;
  private final Uri Ms;
  private final Uri Mt;
  private final boolean Mu;
  private final boolean Mv;
  private final String Mw;
  private final int Mx;
  private final int My;
  private final int Mz;
  private final int xM;
  private final String zP;
  
  GameEntity(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Uri paramUri1, Uri paramUri2, Uri paramUri3, boolean paramBoolean1, boolean paramBoolean2, String paramString7, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean3, boolean paramBoolean4, String paramString8, String paramString9, String paramString10, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    this.xM = paramInt1;
    this.zP = paramString1;
    this.Ln = paramString2;
    this.Mn = paramString3;
    this.Mo = paramString4;
    this.Mp = paramString5;
    this.Mq = paramString6;
    this.Mr = paramUri1;
    this.MC = paramString8;
    this.Ms = paramUri2;
    this.MD = paramString9;
    this.Mt = paramUri3;
    this.ME = paramString10;
    this.Mu = paramBoolean1;
    this.Mv = paramBoolean2;
    this.Mw = paramString7;
    this.Mx = paramInt2;
    this.My = paramInt3;
    this.Mz = paramInt4;
    this.MA = paramBoolean3;
    this.MB = paramBoolean4;
    this.MF = paramBoolean5;
    this.MG = paramBoolean6;
    this.MH = paramBoolean7;
  }
  
  public GameEntity(Game paramGame)
  {
    this.xM = 4;
    this.zP = paramGame.getApplicationId();
    this.Mn = paramGame.getPrimaryCategory();
    this.Mo = paramGame.getSecondaryCategory();
    this.Mp = paramGame.getDescription();
    this.Mq = paramGame.getDeveloperName();
    this.Ln = paramGame.getDisplayName();
    this.Mr = paramGame.getIconImageUri();
    this.MC = paramGame.getIconImageUrl();
    this.Ms = paramGame.getHiResImageUri();
    this.MD = paramGame.getHiResImageUrl();
    this.Mt = paramGame.getFeaturedImageUri();
    this.ME = paramGame.getFeaturedImageUrl();
    this.Mu = paramGame.gM();
    this.Mv = paramGame.gO();
    this.Mw = paramGame.gP();
    this.Mx = paramGame.gQ();
    this.My = paramGame.getAchievementTotalCount();
    this.Mz = paramGame.getLeaderboardCount();
    this.MA = paramGame.isRealTimeMultiplayerEnabled();
    this.MB = paramGame.isTurnBasedMultiplayerEnabled();
    this.MF = paramGame.isMuted();
    this.MG = paramGame.gN();
    this.MH = paramGame.areSnapshotsEnabled();
  }
  
  static int a(Game paramGame)
  {
    return hk.hashCode(new Object[] { paramGame.getApplicationId(), paramGame.getDisplayName(), paramGame.getPrimaryCategory(), paramGame.getSecondaryCategory(), paramGame.getDescription(), paramGame.getDeveloperName(), paramGame.getIconImageUri(), paramGame.getHiResImageUri(), paramGame.getFeaturedImageUri(), Boolean.valueOf(paramGame.gM()), Boolean.valueOf(paramGame.gO()), paramGame.gP(), Integer.valueOf(paramGame.gQ()), Integer.valueOf(paramGame.getAchievementTotalCount()), Integer.valueOf(paramGame.getLeaderboardCount()), Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled()), Boolean.valueOf(paramGame.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(paramGame.isMuted()), Boolean.valueOf(paramGame.gN()), Boolean.valueOf(paramGame.areSnapshotsEnabled()) });
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
    if ((hk.equal(((Game)paramObject).getApplicationId(), paramGame.getApplicationId())) && (hk.equal(((Game)paramObject).getDisplayName(), paramGame.getDisplayName())) && (hk.equal(((Game)paramObject).getPrimaryCategory(), paramGame.getPrimaryCategory())) && (hk.equal(((Game)paramObject).getSecondaryCategory(), paramGame.getSecondaryCategory())) && (hk.equal(((Game)paramObject).getDescription(), paramGame.getDescription())) && (hk.equal(((Game)paramObject).getDeveloperName(), paramGame.getDeveloperName())) && (hk.equal(((Game)paramObject).getIconImageUri(), paramGame.getIconImageUri())) && (hk.equal(((Game)paramObject).getHiResImageUri(), paramGame.getHiResImageUri())) && (hk.equal(((Game)paramObject).getFeaturedImageUri(), paramGame.getFeaturedImageUri())) && (hk.equal(Boolean.valueOf(((Game)paramObject).gM()), Boolean.valueOf(paramGame.gM()))) && (hk.equal(Boolean.valueOf(((Game)paramObject).gO()), Boolean.valueOf(paramGame.gO()))) && (hk.equal(((Game)paramObject).gP(), paramGame.gP())) && (hk.equal(Integer.valueOf(((Game)paramObject).gQ()), Integer.valueOf(paramGame.gQ()))) && (hk.equal(Integer.valueOf(((Game)paramObject).getAchievementTotalCount()), Integer.valueOf(paramGame.getAchievementTotalCount()))) && (hk.equal(Integer.valueOf(((Game)paramObject).getLeaderboardCount()), Integer.valueOf(paramGame.getLeaderboardCount()))) && (hk.equal(Boolean.valueOf(((Game)paramObject).isRealTimeMultiplayerEnabled()), Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled()))))
    {
      bool3 = ((Game)paramObject).isTurnBasedMultiplayerEnabled();
      if ((!paramGame.isTurnBasedMultiplayerEnabled()) || (!hk.equal(Boolean.valueOf(((Game)paramObject).isMuted()), Boolean.valueOf(paramGame.isMuted()))) || (!hk.equal(Boolean.valueOf(((Game)paramObject).gN()), Boolean.valueOf(paramGame.gN())))) {
        break label459;
      }
    }
    label459:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (hk.equal(Boolean.valueOf(bool3), Boolean.valueOf(bool1)))
      {
        bool1 = bool2;
        if (hk.equal(Boolean.valueOf(((Game)paramObject).areSnapshotsEnabled()), Boolean.valueOf(paramGame.areSnapshotsEnabled()))) {
          break;
        }
      }
      return false;
    }
  }
  
  static String b(Game paramGame)
  {
    return hk.e(paramGame).a("ApplicationId", paramGame.getApplicationId()).a("DisplayName", paramGame.getDisplayName()).a("PrimaryCategory", paramGame.getPrimaryCategory()).a("SecondaryCategory", paramGame.getSecondaryCategory()).a("Description", paramGame.getDescription()).a("DeveloperName", paramGame.getDeveloperName()).a("IconImageUri", paramGame.getIconImageUri()).a("IconImageUrl", paramGame.getIconImageUrl()).a("HiResImageUri", paramGame.getHiResImageUri()).a("HiResImageUrl", paramGame.getHiResImageUrl()).a("FeaturedImageUri", paramGame.getFeaturedImageUri()).a("FeaturedImageUrl", paramGame.getFeaturedImageUrl()).a("PlayEnabledGame", Boolean.valueOf(paramGame.gM())).a("InstanceInstalled", Boolean.valueOf(paramGame.gO())).a("InstancePackageName", paramGame.gP()).a("AchievementTotalCount", Integer.valueOf(paramGame.getAchievementTotalCount())).a("LeaderboardCount", Integer.valueOf(paramGame.getLeaderboardCount())).a("RealTimeMultiplayerEnabled", Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled())).a("TurnBasedMultiplayerEnabled", Boolean.valueOf(paramGame.isTurnBasedMultiplayerEnabled())).a("AreSnapshotsEnabled", Boolean.valueOf(paramGame.areSnapshotsEnabled())).toString();
  }
  
  public boolean areSnapshotsEnabled()
  {
    return this.MH;
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
  
  public boolean gM()
  {
    return this.Mu;
  }
  
  public boolean gN()
  {
    return this.MG;
  }
  
  public boolean gO()
  {
    return this.Mv;
  }
  
  public String gP()
  {
    return this.Mw;
  }
  
  public int gQ()
  {
    return this.Mx;
  }
  
  public int getAchievementTotalCount()
  {
    return this.My;
  }
  
  public String getApplicationId()
  {
    return this.zP;
  }
  
  public String getDescription()
  {
    return this.Mp;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    ik.b(this.Mp, paramCharArrayBuffer);
  }
  
  public String getDeveloperName()
  {
    return this.Mq;
  }
  
  public void getDeveloperName(CharArrayBuffer paramCharArrayBuffer)
  {
    ik.b(this.Mq, paramCharArrayBuffer);
  }
  
  public String getDisplayName()
  {
    return this.Ln;
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    ik.b(this.Ln, paramCharArrayBuffer);
  }
  
  public Uri getFeaturedImageUri()
  {
    return this.Mt;
  }
  
  public String getFeaturedImageUrl()
  {
    return this.ME;
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
  
  public int getLeaderboardCount()
  {
    return this.Mz;
  }
  
  public String getPrimaryCategory()
  {
    return this.Mn;
  }
  
  public String getSecondaryCategory()
  {
    return this.Mo;
  }
  
  public int getVersionCode()
  {
    return this.xM;
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
    return this.MF;
  }
  
  public boolean isRealTimeMultiplayerEnabled()
  {
    return this.MA;
  }
  
  public boolean isTurnBasedMultiplayerEnabled()
  {
    return this.MB;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    Object localObject2 = null;
    if (!fr())
    {
      GameEntityCreator.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.zP);
    paramParcel.writeString(this.Ln);
    paramParcel.writeString(this.Mn);
    paramParcel.writeString(this.Mo);
    paramParcel.writeString(this.Mp);
    paramParcel.writeString(this.Mq);
    Object localObject1;
    if (this.Mr == null)
    {
      localObject1 = null;
      paramParcel.writeString((String)localObject1);
      if (this.Ms != null) {
        break label189;
      }
      localObject1 = null;
      label93:
      paramParcel.writeString((String)localObject1);
      if (this.Mt != null) {
        break label201;
      }
      localObject1 = localObject2;
      label110:
      paramParcel.writeString((String)localObject1);
      if (!this.Mu) {
        break label213;
      }
      paramInt = 1;
      label125:
      paramParcel.writeInt(paramInt);
      if (!this.Mv) {
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
      paramParcel.writeString(this.Mw);
      paramParcel.writeInt(this.Mx);
      paramParcel.writeInt(this.My);
      paramParcel.writeInt(this.Mz);
      return;
      localObject1 = this.Mr.toString();
      break;
      localObject1 = this.Ms.toString();
      break label93;
      localObject1 = this.Mt.toString();
      break label110;
      paramInt = 0;
      break label125;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/GameEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */