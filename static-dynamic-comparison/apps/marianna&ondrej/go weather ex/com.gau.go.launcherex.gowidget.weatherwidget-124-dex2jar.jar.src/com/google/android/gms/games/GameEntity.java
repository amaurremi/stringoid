package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fo.a;
import com.google.android.gms.internal.gm;

public final class GameEntity
  extends GamesDowngradeableSafeParcel
  implements Game
{
  public static final Parcelable.Creator<GameEntity> CREATOR = new GameEntityCreatorCompat();
  private final String HA;
  private final String HB;
  private final String HC;
  private final String HD;
  private final String HE;
  private final Uri HF;
  private final Uri HG;
  private final Uri HH;
  private final boolean HI;
  private final boolean HJ;
  private final String HK;
  private final int HL;
  private final int HM;
  private final int HN;
  private final boolean HO;
  private final boolean HP;
  private final String HQ;
  private final String HR;
  private final String HS;
  private final boolean HT;
  private final boolean HU;
  private final int xH;
  private final String xI;
  
  GameEntity(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Uri paramUri1, Uri paramUri2, Uri paramUri3, boolean paramBoolean1, boolean paramBoolean2, String paramString7, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean3, boolean paramBoolean4, String paramString8, String paramString9, String paramString10, boolean paramBoolean5, boolean paramBoolean6)
  {
    this.xH = paramInt1;
    this.xI = paramString1;
    this.HA = paramString2;
    this.HB = paramString3;
    this.HC = paramString4;
    this.HD = paramString5;
    this.HE = paramString6;
    this.HF = paramUri1;
    this.HQ = paramString8;
    this.HG = paramUri2;
    this.HR = paramString9;
    this.HH = paramUri3;
    this.HS = paramString10;
    this.HI = paramBoolean1;
    this.HJ = paramBoolean2;
    this.HK = paramString7;
    this.HL = paramInt2;
    this.HM = paramInt3;
    this.HN = paramInt4;
    this.HO = paramBoolean3;
    this.HP = paramBoolean4;
    this.HT = paramBoolean5;
    this.HU = paramBoolean6;
  }
  
  public GameEntity(Game paramGame)
  {
    this.xH = 3;
    this.xI = paramGame.getApplicationId();
    this.HB = paramGame.getPrimaryCategory();
    this.HC = paramGame.getSecondaryCategory();
    this.HD = paramGame.getDescription();
    this.HE = paramGame.getDeveloperName();
    this.HA = paramGame.getDisplayName();
    this.HF = paramGame.getIconImageUri();
    this.HQ = paramGame.getIconImageUrl();
    this.HG = paramGame.getHiResImageUri();
    this.HR = paramGame.getHiResImageUrl();
    this.HH = paramGame.getFeaturedImageUri();
    this.HS = paramGame.getFeaturedImageUrl();
    this.HI = paramGame.gb();
    this.HJ = paramGame.gd();
    this.HK = paramGame.ge();
    this.HL = paramGame.gf();
    this.HM = paramGame.getAchievementTotalCount();
    this.HN = paramGame.getLeaderboardCount();
    this.HO = paramGame.isRealTimeMultiplayerEnabled();
    this.HP = paramGame.isTurnBasedMultiplayerEnabled();
    this.HT = paramGame.isMuted();
    this.HU = paramGame.gc();
  }
  
  static int a(Game paramGame)
  {
    return fo.hashCode(new Object[] { paramGame.getApplicationId(), paramGame.getDisplayName(), paramGame.getPrimaryCategory(), paramGame.getSecondaryCategory(), paramGame.getDescription(), paramGame.getDeveloperName(), paramGame.getIconImageUri(), paramGame.getHiResImageUri(), paramGame.getFeaturedImageUri(), Boolean.valueOf(paramGame.gb()), Boolean.valueOf(paramGame.gd()), paramGame.ge(), Integer.valueOf(paramGame.gf()), Integer.valueOf(paramGame.getAchievementTotalCount()), Integer.valueOf(paramGame.getLeaderboardCount()), Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled()), Boolean.valueOf(paramGame.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(paramGame.isMuted()), Boolean.valueOf(paramGame.gc()) });
  }
  
  static boolean a(Game paramGame, Object paramObject)
  {
    boolean bool3 = true;
    boolean bool1;
    if (!(paramObject instanceof Game)) {
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool3;
    } while (paramGame == paramObject);
    paramObject = (Game)paramObject;
    boolean bool4;
    if ((fo.equal(((Game)paramObject).getApplicationId(), paramGame.getApplicationId())) && (fo.equal(((Game)paramObject).getDisplayName(), paramGame.getDisplayName())) && (fo.equal(((Game)paramObject).getPrimaryCategory(), paramGame.getPrimaryCategory())) && (fo.equal(((Game)paramObject).getSecondaryCategory(), paramGame.getSecondaryCategory())) && (fo.equal(((Game)paramObject).getDescription(), paramGame.getDescription())) && (fo.equal(((Game)paramObject).getDeveloperName(), paramGame.getDeveloperName())) && (fo.equal(((Game)paramObject).getIconImageUri(), paramGame.getIconImageUri())) && (fo.equal(((Game)paramObject).getHiResImageUri(), paramGame.getHiResImageUri())) && (fo.equal(((Game)paramObject).getFeaturedImageUri(), paramGame.getFeaturedImageUri())) && (fo.equal(Boolean.valueOf(((Game)paramObject).gb()), Boolean.valueOf(paramGame.gb()))) && (fo.equal(Boolean.valueOf(((Game)paramObject).gd()), Boolean.valueOf(paramGame.gd()))) && (fo.equal(((Game)paramObject).ge(), paramGame.ge())) && (fo.equal(Integer.valueOf(((Game)paramObject).gf()), Integer.valueOf(paramGame.gf()))) && (fo.equal(Integer.valueOf(((Game)paramObject).getAchievementTotalCount()), Integer.valueOf(paramGame.getAchievementTotalCount()))) && (fo.equal(Integer.valueOf(((Game)paramObject).getLeaderboardCount()), Integer.valueOf(paramGame.getLeaderboardCount()))) && (fo.equal(Boolean.valueOf(((Game)paramObject).isRealTimeMultiplayerEnabled()), Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled()))))
    {
      bool4 = ((Game)paramObject).isTurnBasedMultiplayerEnabled();
      if ((!paramGame.isTurnBasedMultiplayerEnabled()) || (!fo.equal(Boolean.valueOf(((Game)paramObject).isMuted()), Boolean.valueOf(paramGame.isMuted()))) || (!fo.equal(Boolean.valueOf(((Game)paramObject).gc()), Boolean.valueOf(paramGame.gc())))) {
        break label438;
      }
    }
    label438:
    for (boolean bool2 = true;; bool2 = false)
    {
      bool1 = bool3;
      if (fo.equal(Boolean.valueOf(bool4), Boolean.valueOf(bool2))) {
        break;
      }
      return false;
    }
  }
  
  static String b(Game paramGame)
  {
    return fo.e(paramGame).a("ApplicationId", paramGame.getApplicationId()).a("DisplayName", paramGame.getDisplayName()).a("PrimaryCategory", paramGame.getPrimaryCategory()).a("SecondaryCategory", paramGame.getSecondaryCategory()).a("Description", paramGame.getDescription()).a("DeveloperName", paramGame.getDeveloperName()).a("IconImageUri", paramGame.getIconImageUri()).a("IconImageUrl", paramGame.getIconImageUrl()).a("HiResImageUri", paramGame.getHiResImageUri()).a("HiResImageUrl", paramGame.getHiResImageUrl()).a("FeaturedImageUri", paramGame.getFeaturedImageUri()).a("FeaturedImageUrl", paramGame.getFeaturedImageUrl()).a("PlayEnabledGame", Boolean.valueOf(paramGame.gb())).a("InstanceInstalled", Boolean.valueOf(paramGame.gd())).a("InstancePackageName", paramGame.ge()).a("AchievementTotalCount", Integer.valueOf(paramGame.getAchievementTotalCount())).a("LeaderboardCount", Integer.valueOf(paramGame.getLeaderboardCount())).a("RealTimeMultiplayerEnabled", Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled())).a("TurnBasedMultiplayerEnabled", Boolean.valueOf(paramGame.isTurnBasedMultiplayerEnabled())).toString();
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
  
  public boolean gb()
  {
    return this.HI;
  }
  
  public boolean gc()
  {
    return this.HU;
  }
  
  public boolean gd()
  {
    return this.HJ;
  }
  
  public String ge()
  {
    return this.HK;
  }
  
  public int getAchievementTotalCount()
  {
    return this.HM;
  }
  
  public String getApplicationId()
  {
    return this.xI;
  }
  
  public String getDescription()
  {
    return this.HD;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    gm.b(this.HD, paramCharArrayBuffer);
  }
  
  public String getDeveloperName()
  {
    return this.HE;
  }
  
  public void getDeveloperName(CharArrayBuffer paramCharArrayBuffer)
  {
    gm.b(this.HE, paramCharArrayBuffer);
  }
  
  public String getDisplayName()
  {
    return this.HA;
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    gm.b(this.HA, paramCharArrayBuffer);
  }
  
  public Uri getFeaturedImageUri()
  {
    return this.HH;
  }
  
  public String getFeaturedImageUrl()
  {
    return this.HS;
  }
  
  public Uri getHiResImageUri()
  {
    return this.HG;
  }
  
  public String getHiResImageUrl()
  {
    return this.HR;
  }
  
  public Uri getIconImageUri()
  {
    return this.HF;
  }
  
  public String getIconImageUrl()
  {
    return this.HQ;
  }
  
  public int getLeaderboardCount()
  {
    return this.HN;
  }
  
  public String getPrimaryCategory()
  {
    return this.HB;
  }
  
  public String getSecondaryCategory()
  {
    return this.HC;
  }
  
  public int getVersionCode()
  {
    return this.xH;
  }
  
  public int gf()
  {
    return this.HL;
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
    return this.HT;
  }
  
  public boolean isRealTimeMultiplayerEnabled()
  {
    return this.HO;
  }
  
  public boolean isTurnBasedMultiplayerEnabled()
  {
    return this.HP;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    Object localObject2 = null;
    if (!eK())
    {
      GameEntityCreator.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.xI);
    paramParcel.writeString(this.HA);
    paramParcel.writeString(this.HB);
    paramParcel.writeString(this.HC);
    paramParcel.writeString(this.HD);
    paramParcel.writeString(this.HE);
    Object localObject1;
    if (this.HF == null)
    {
      localObject1 = null;
      paramParcel.writeString((String)localObject1);
      if (this.HG != null) {
        break label189;
      }
      localObject1 = null;
      label93:
      paramParcel.writeString((String)localObject1);
      if (this.HH != null) {
        break label201;
      }
      localObject1 = localObject2;
      label110:
      paramParcel.writeString((String)localObject1);
      if (!this.HI) {
        break label213;
      }
      paramInt = 1;
      label125:
      paramParcel.writeInt(paramInt);
      if (!this.HJ) {
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
      paramParcel.writeString(this.HK);
      paramParcel.writeInt(this.HL);
      paramParcel.writeInt(this.HM);
      paramParcel.writeInt(this.HN);
      return;
      localObject1 = this.HF.toString();
      break;
      localObject1 = this.HG.toString();
      break label93;
      localObject1 = this.HH.toString();
      break label110;
      paramInt = 0;
      break label125;
    }
  }
  
  static final class GameEntityCreatorCompat
    extends GameEntityCreator
  {
    public GameEntity an(Parcel paramParcel)
    {
      if ((GameEntity.b(GameEntity.gg())) || (GameEntity.az(GameEntity.class.getCanonicalName()))) {
        return super.an(paramParcel);
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
          break label184;
        }
        localObject2 = null;
        localObject3 = paramParcel.readString();
        if (localObject3 != null) {
          break label194;
        }
        localObject3 = null;
        if (paramParcel.readInt() <= 0) {
          break label204;
        }
        bool1 = true;
        label113:
        if (paramParcel.readInt() <= 0) {
          break label209;
        }
      }
      label184:
      label194:
      label204:
      label209:
      for (boolean bool2 = true;; bool2 = false)
      {
        return new GameEntity(3, str1, str2, str3, str4, str5, str6, (Uri)localObject1, (Uri)localObject2, (Uri)localObject3, bool1, bool2, paramParcel.readString(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), false, false, null, null, null, false, false);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/games/GameEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */