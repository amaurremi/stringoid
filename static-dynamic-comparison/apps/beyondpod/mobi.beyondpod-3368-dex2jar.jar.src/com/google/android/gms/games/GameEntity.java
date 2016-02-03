package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.ee.a;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.fm;

public final class GameEntity
  extends fm
  implements Game
{
  public static final Parcelable.Creator<GameEntity> CREATOR = new a();
  private final int kg;
  private final String kh;
  private final String qa;
  private final String sH;
  private final String sI;
  private final String sJ;
  private final String sK;
  private final Uri sL;
  private final Uri sM;
  private final Uri sN;
  private final boolean sO;
  private final boolean sP;
  private final String sQ;
  private final int sR;
  private final int sS;
  private final int sT;
  private final boolean sU;
  private final boolean sV;
  
  GameEntity(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Uri paramUri1, Uri paramUri2, Uri paramUri3, boolean paramBoolean1, boolean paramBoolean2, String paramString7, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.kg = paramInt1;
    this.kh = paramString1;
    this.qa = paramString2;
    this.sH = paramString3;
    this.sI = paramString4;
    this.sJ = paramString5;
    this.sK = paramString6;
    this.sL = paramUri1;
    this.sM = paramUri2;
    this.sN = paramUri3;
    this.sO = paramBoolean1;
    this.sP = paramBoolean2;
    this.sQ = paramString7;
    this.sR = paramInt2;
    this.sS = paramInt3;
    this.sT = paramInt4;
    this.sU = paramBoolean3;
    this.sV = paramBoolean4;
  }
  
  public GameEntity(Game paramGame)
  {
    this.kg = 2;
    this.kh = paramGame.getApplicationId();
    this.sH = paramGame.getPrimaryCategory();
    this.sI = paramGame.getSecondaryCategory();
    this.sJ = paramGame.getDescription();
    this.sK = paramGame.getDeveloperName();
    this.qa = paramGame.getDisplayName();
    this.sL = paramGame.getIconImageUri();
    this.sM = paramGame.getHiResImageUri();
    this.sN = paramGame.getFeaturedImageUri();
    this.sO = paramGame.isPlayEnabledGame();
    this.sP = paramGame.isInstanceInstalled();
    this.sQ = paramGame.getInstancePackageName();
    this.sR = paramGame.getGameplayAclStatus();
    this.sS = paramGame.getAchievementTotalCount();
    this.sT = paramGame.getLeaderboardCount();
    this.sU = paramGame.isRealTimeMultiplayerEnabled();
    this.sV = paramGame.isTurnBasedMultiplayerEnabled();
  }
  
  static int a(Game paramGame)
  {
    return ee.hashCode(new Object[] { paramGame.getApplicationId(), paramGame.getDisplayName(), paramGame.getPrimaryCategory(), paramGame.getSecondaryCategory(), paramGame.getDescription(), paramGame.getDeveloperName(), paramGame.getIconImageUri(), paramGame.getHiResImageUri(), paramGame.getFeaturedImageUri(), Boolean.valueOf(paramGame.isPlayEnabledGame()), Boolean.valueOf(paramGame.isInstanceInstalled()), paramGame.getInstancePackageName(), Integer.valueOf(paramGame.getGameplayAclStatus()), Integer.valueOf(paramGame.getAchievementTotalCount()), Integer.valueOf(paramGame.getLeaderboardCount()), Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled()), Boolean.valueOf(paramGame.isTurnBasedMultiplayerEnabled()) });
  }
  
  static boolean a(Game paramGame, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Game)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramGame == paramObject);
      paramObject = (Game)paramObject;
      if ((!ee.equal(((Game)paramObject).getApplicationId(), paramGame.getApplicationId())) || (!ee.equal(((Game)paramObject).getDisplayName(), paramGame.getDisplayName())) || (!ee.equal(((Game)paramObject).getPrimaryCategory(), paramGame.getPrimaryCategory())) || (!ee.equal(((Game)paramObject).getSecondaryCategory(), paramGame.getSecondaryCategory())) || (!ee.equal(((Game)paramObject).getDescription(), paramGame.getDescription())) || (!ee.equal(((Game)paramObject).getDeveloperName(), paramGame.getDeveloperName())) || (!ee.equal(((Game)paramObject).getIconImageUri(), paramGame.getIconImageUri())) || (!ee.equal(((Game)paramObject).getHiResImageUri(), paramGame.getHiResImageUri())) || (!ee.equal(((Game)paramObject).getFeaturedImageUri(), paramGame.getFeaturedImageUri())) || (!ee.equal(Boolean.valueOf(((Game)paramObject).isPlayEnabledGame()), Boolean.valueOf(paramGame.isPlayEnabledGame()))) || (!ee.equal(Boolean.valueOf(((Game)paramObject).isInstanceInstalled()), Boolean.valueOf(paramGame.isInstanceInstalled()))) || (!ee.equal(((Game)paramObject).getInstancePackageName(), paramGame.getInstancePackageName())) || (!ee.equal(Integer.valueOf(((Game)paramObject).getGameplayAclStatus()), Integer.valueOf(paramGame.getGameplayAclStatus()))) || (!ee.equal(Integer.valueOf(((Game)paramObject).getAchievementTotalCount()), Integer.valueOf(paramGame.getAchievementTotalCount()))) || (!ee.equal(Integer.valueOf(((Game)paramObject).getLeaderboardCount()), Integer.valueOf(paramGame.getLeaderboardCount()))) || (!ee.equal(Boolean.valueOf(((Game)paramObject).isRealTimeMultiplayerEnabled()), Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled())))) {
        break;
      }
      bool1 = bool2;
    } while (ee.equal(Boolean.valueOf(((Game)paramObject).isTurnBasedMultiplayerEnabled()), Boolean.valueOf(paramGame.isTurnBasedMultiplayerEnabled())));
    return false;
  }
  
  static String b(Game paramGame)
  {
    return ee.e(paramGame).a("ApplicationId", paramGame.getApplicationId()).a("DisplayName", paramGame.getDisplayName()).a("PrimaryCategory", paramGame.getPrimaryCategory()).a("SecondaryCategory", paramGame.getSecondaryCategory()).a("Description", paramGame.getDescription()).a("DeveloperName", paramGame.getDeveloperName()).a("IconImageUri", paramGame.getIconImageUri()).a("HiResImageUri", paramGame.getHiResImageUri()).a("FeaturedImageUri", paramGame.getFeaturedImageUri()).a("PlayEnabledGame", Boolean.valueOf(paramGame.isPlayEnabledGame())).a("InstanceInstalled", Boolean.valueOf(paramGame.isInstanceInstalled())).a("InstancePackageName", paramGame.getInstancePackageName()).a("GameplayAclStatus", Integer.valueOf(paramGame.getGameplayAclStatus())).a("AchievementTotalCount", Integer.valueOf(paramGame.getAchievementTotalCount())).a("LeaderboardCount", Integer.valueOf(paramGame.getLeaderboardCount())).a("RealTimeMultiplayerEnabled", Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled())).a("TurnBasedMultiplayerEnabled", Boolean.valueOf(paramGame.isTurnBasedMultiplayerEnabled())).toString();
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
    return this.sS;
  }
  
  public String getApplicationId()
  {
    return this.kh;
  }
  
  public String getDescription()
  {
    return this.sJ;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    fc.b(this.sJ, paramCharArrayBuffer);
  }
  
  public String getDeveloperName()
  {
    return this.sK;
  }
  
  public void getDeveloperName(CharArrayBuffer paramCharArrayBuffer)
  {
    fc.b(this.sK, paramCharArrayBuffer);
  }
  
  public String getDisplayName()
  {
    return this.qa;
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    fc.b(this.qa, paramCharArrayBuffer);
  }
  
  public Uri getFeaturedImageUri()
  {
    return this.sN;
  }
  
  public int getGameplayAclStatus()
  {
    return this.sR;
  }
  
  public Uri getHiResImageUri()
  {
    return this.sM;
  }
  
  public Uri getIconImageUri()
  {
    return this.sL;
  }
  
  public String getInstancePackageName()
  {
    return this.sQ;
  }
  
  public int getLeaderboardCount()
  {
    return this.sT;
  }
  
  public String getPrimaryCategory()
  {
    return this.sH;
  }
  
  public String getSecondaryCategory()
  {
    return this.sI;
  }
  
  public int getVersionCode()
  {
    return this.kg;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public boolean isInstanceInstalled()
  {
    return this.sP;
  }
  
  public boolean isPlayEnabledGame()
  {
    return this.sO;
  }
  
  public boolean isRealTimeMultiplayerEnabled()
  {
    return this.sU;
  }
  
  public boolean isTurnBasedMultiplayerEnabled()
  {
    return this.sV;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    Object localObject2 = null;
    if (!bN())
    {
      a.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.kh);
    paramParcel.writeString(this.qa);
    paramParcel.writeString(this.sH);
    paramParcel.writeString(this.sI);
    paramParcel.writeString(this.sJ);
    paramParcel.writeString(this.sK);
    Object localObject1;
    if (this.sL == null)
    {
      localObject1 = null;
      paramParcel.writeString((String)localObject1);
      if (this.sM != null) {
        break label189;
      }
      localObject1 = null;
      label93:
      paramParcel.writeString((String)localObject1);
      if (this.sN != null) {
        break label201;
      }
      localObject1 = localObject2;
      label110:
      paramParcel.writeString((String)localObject1);
      if (!this.sO) {
        break label213;
      }
      paramInt = 1;
      label125:
      paramParcel.writeInt(paramInt);
      if (!this.sP) {
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
      paramParcel.writeString(this.sQ);
      paramParcel.writeInt(this.sR);
      paramParcel.writeInt(this.sS);
      paramParcel.writeInt(this.sT);
      return;
      localObject1 = this.sL.toString();
      break;
      localObject1 = this.sM.toString();
      break label93;
      localObject1 = this.sN.toString();
      break label110;
      paramInt = 0;
      break label125;
    }
  }
  
  static final class a
    extends a
  {
    public GameEntity Y(Parcel paramParcel)
    {
      if ((GameEntity.b(GameEntity.da())) || (GameEntity.ad(GameEntity.class.getCanonicalName()))) {
        return super.Y(paramParcel);
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
          break label179;
        }
        localObject2 = null;
        localObject3 = paramParcel.readString();
        if (localObject3 != null) {
          break label189;
        }
        localObject3 = null;
        if (paramParcel.readInt() <= 0) {
          break label199;
        }
        bool1 = true;
        label113:
        if (paramParcel.readInt() <= 0) {
          break label204;
        }
      }
      label179:
      label189:
      label199:
      label204:
      for (boolean bool2 = true;; bool2 = false)
      {
        return new GameEntity(2, str1, str2, str3, str4, str5, str6, (Uri)localObject1, (Uri)localObject2, (Uri)localObject3, bool1, bool2, paramParcel.readString(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), false, false);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/games/GameEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */