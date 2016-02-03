package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.cz;
import com.google.android.gms.internal.cz.a;
import com.google.android.gms.internal.fy;

public final class GameEntity
  extends fy
  implements Game
{
  public static final Parcelable.Creator<GameEntity> CREATOR = new a();
  private final int qh;
  private final String qi;
  private final String vc;
  private final String vd;
  private final String ve;
  private final String vf;
  private final String vg;
  private final Uri vh;
  private final Uri vi;
  private final Uri vj;
  private final boolean vk;
  private final boolean vl;
  private final String vm;
  private final int vn;
  private final int vo;
  private final int vp;
  private final boolean vq;
  private final boolean vr;
  private final String vt;
  private final String vu;
  private final String vv;
  private final boolean vw;
  
  GameEntity(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Uri paramUri1, Uri paramUri2, Uri paramUri3, boolean paramBoolean1, boolean paramBoolean2, String paramString7, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean3, boolean paramBoolean4, String paramString8, String paramString9, String paramString10, boolean paramBoolean5)
  {
    this.qh = paramInt1;
    this.qi = paramString1;
    this.vc = paramString2;
    this.vd = paramString3;
    this.ve = paramString4;
    this.vf = paramString5;
    this.vg = paramString6;
    this.vh = paramUri1;
    this.vt = paramString8;
    this.vi = paramUri2;
    this.vu = paramString9;
    this.vj = paramUri3;
    this.vv = paramString10;
    this.vk = paramBoolean1;
    this.vl = paramBoolean2;
    this.vm = paramString7;
    this.vn = paramInt2;
    this.vo = paramInt3;
    this.vp = paramInt4;
    this.vq = paramBoolean3;
    this.vr = paramBoolean4;
    this.vw = paramBoolean5;
  }
  
  public GameEntity(Game paramGame)
  {
    this.qh = 2;
    this.qi = paramGame.lY();
    this.vd = paramGame.nz();
    this.ve = paramGame.nA();
    this.vf = paramGame.getDescription();
    this.vg = paramGame.nB();
    this.vc = paramGame.getDisplayName();
    this.vh = paramGame.nC();
    this.vt = paramGame.nD();
    this.vi = paramGame.nE();
    this.vu = paramGame.nF();
    this.vj = paramGame.nG();
    this.vv = paramGame.nH();
    this.vk = paramGame.nI();
    this.vl = paramGame.nJ();
    this.vm = paramGame.nK();
    this.vn = paramGame.nL();
    this.vo = paramGame.nM();
    this.vp = paramGame.nN();
    this.vq = paramGame.nO();
    this.vr = paramGame.nP();
    this.vw = paramGame.isMuted();
  }
  
  static int a(Game paramGame)
  {
    return cz.hashCode(new Object[] { paramGame.lY(), paramGame.getDisplayName(), paramGame.nz(), paramGame.nA(), paramGame.getDescription(), paramGame.nB(), paramGame.nC(), paramGame.nE(), paramGame.nG(), Boolean.valueOf(paramGame.nI()), Boolean.valueOf(paramGame.nJ()), paramGame.nK(), Integer.valueOf(paramGame.nL()), Integer.valueOf(paramGame.nM()), Integer.valueOf(paramGame.nN()), Boolean.valueOf(paramGame.nO()), Boolean.valueOf(paramGame.nP()), Boolean.valueOf(paramGame.isMuted()) });
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
    if ((cz.b(((Game)paramObject).lY(), paramGame.lY())) && (cz.b(((Game)paramObject).getDisplayName(), paramGame.getDisplayName())) && (cz.b(((Game)paramObject).nz(), paramGame.nz())) && (cz.b(((Game)paramObject).nA(), paramGame.nA())) && (cz.b(((Game)paramObject).getDescription(), paramGame.getDescription())) && (cz.b(((Game)paramObject).nB(), paramGame.nB())) && (cz.b(((Game)paramObject).nC(), paramGame.nC())) && (cz.b(((Game)paramObject).nE(), paramGame.nE())) && (cz.b(((Game)paramObject).nG(), paramGame.nG())) && (cz.b(Boolean.valueOf(((Game)paramObject).nI()), Boolean.valueOf(paramGame.nI()))) && (cz.b(Boolean.valueOf(((Game)paramObject).nJ()), Boolean.valueOf(paramGame.nJ()))) && (cz.b(((Game)paramObject).nK(), paramGame.nK())) && (cz.b(Integer.valueOf(((Game)paramObject).nL()), Integer.valueOf(paramGame.nL()))) && (cz.b(Integer.valueOf(((Game)paramObject).nM()), Integer.valueOf(paramGame.nM()))) && (cz.b(Integer.valueOf(((Game)paramObject).nN()), Integer.valueOf(paramGame.nN()))) && (cz.b(Boolean.valueOf(((Game)paramObject).nO()), Boolean.valueOf(paramGame.nO()))))
    {
      bool4 = ((Game)paramObject).nP();
      if ((!paramGame.nP()) || (!cz.b(Boolean.valueOf(((Game)paramObject).isMuted()), Boolean.valueOf(paramGame.isMuted())))) {
        break label414;
      }
    }
    label414:
    for (boolean bool2 = true;; bool2 = false)
    {
      bool1 = bool3;
      if (cz.b(Boolean.valueOf(bool4), Boolean.valueOf(bool2))) {
        break;
      }
      return false;
    }
  }
  
  static String b(Game paramGame)
  {
    return cz.M(paramGame).a("ApplicationId", paramGame.lY()).a("DisplayName", paramGame.getDisplayName()).a("PrimaryCategory", paramGame.nz()).a("SecondaryCategory", paramGame.nA()).a("Description", paramGame.getDescription()).a("DeveloperName", paramGame.nB()).a("IconImageUri", paramGame.nC()).a("IconImageUrl", paramGame.nD()).a("HiResImageUri", paramGame.nE()).a("HiResImageUrl", paramGame.nF()).a("FeaturedImageUri", paramGame.nG()).a("FeaturedImageUrl", paramGame.nH()).a("PlayEnabledGame", Boolean.valueOf(paramGame.nI())).a("InstanceInstalled", Boolean.valueOf(paramGame.nJ())).a("InstancePackageName", paramGame.nK()).a("AchievementTotalCount", Integer.valueOf(paramGame.nM())).a("LeaderboardCount", Integer.valueOf(paramGame.nN())).a("RealTimeMultiplayerEnabled", Boolean.valueOf(paramGame.nO())).a("TurnBasedMultiplayerEnabled", Boolean.valueOf(paramGame.nP())).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public String getDescription()
  {
    return this.vf;
  }
  
  public String getDisplayName()
  {
    return this.vc;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isMuted()
  {
    return this.vw;
  }
  
  public int lX()
  {
    return this.qh;
  }
  
  public String lY()
  {
    return this.qi;
  }
  
  public String nA()
  {
    return this.ve;
  }
  
  public String nB()
  {
    return this.vg;
  }
  
  public Uri nC()
  {
    return this.vh;
  }
  
  public String nD()
  {
    return this.vt;
  }
  
  public Uri nE()
  {
    return this.vi;
  }
  
  public String nF()
  {
    return this.vu;
  }
  
  public Uri nG()
  {
    return this.vj;
  }
  
  public String nH()
  {
    return this.vv;
  }
  
  public boolean nI()
  {
    return this.vk;
  }
  
  public boolean nJ()
  {
    return this.vl;
  }
  
  public String nK()
  {
    return this.vm;
  }
  
  public int nL()
  {
    return this.vn;
  }
  
  public int nM()
  {
    return this.vo;
  }
  
  public int nN()
  {
    return this.vp;
  }
  
  public boolean nO()
  {
    return this.vq;
  }
  
  public boolean nP()
  {
    return this.vr;
  }
  
  public Game nQ()
  {
    return this;
  }
  
  public String nz()
  {
    return this.vd;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    Object localObject2 = null;
    if (!qp())
    {
      a.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.qi);
    paramParcel.writeString(this.vc);
    paramParcel.writeString(this.vd);
    paramParcel.writeString(this.ve);
    paramParcel.writeString(this.vf);
    paramParcel.writeString(this.vg);
    Object localObject1;
    if (this.vh == null)
    {
      localObject1 = null;
      paramParcel.writeString((String)localObject1);
      if (this.vi != null) {
        break label189;
      }
      localObject1 = null;
      label93:
      paramParcel.writeString((String)localObject1);
      if (this.vj != null) {
        break label201;
      }
      localObject1 = localObject2;
      label110:
      paramParcel.writeString((String)localObject1);
      if (!this.vk) {
        break label213;
      }
      paramInt = 1;
      label125:
      paramParcel.writeInt(paramInt);
      if (!this.vl) {
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
      paramParcel.writeString(this.vm);
      paramParcel.writeInt(this.vn);
      paramParcel.writeInt(this.vo);
      paramParcel.writeInt(this.vp);
      return;
      localObject1 = this.vh.toString();
      break;
      localObject1 = this.vi.toString();
      break label93;
      localObject1 = this.vj.toString();
      break label110;
      paramInt = 0;
      break label125;
    }
  }
  
  static final class a
    extends a
  {
    public GameEntity W(Parcel paramParcel)
    {
      if ((GameEntity.a(GameEntity.nR())) || (GameEntity.aw(GameEntity.class.getCanonicalName()))) {
        return super.W(paramParcel);
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
          break label183;
        }
        localObject2 = null;
        localObject3 = paramParcel.readString();
        if (localObject3 != null) {
          break label193;
        }
        localObject3 = null;
        if (paramParcel.readInt() <= 0) {
          break label203;
        }
        bool1 = true;
        label113:
        if (paramParcel.readInt() <= 0) {
          break label208;
        }
      }
      label183:
      label193:
      label203:
      label208:
      for (boolean bool2 = true;; bool2 = false)
      {
        return new GameEntity(2, str1, str2, str3, str4, str5, str6, (Uri)localObject1, (Uri)localObject2, (Uri)localObject3, bool1, bool2, paramParcel.readString(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), false, false, null, null, null, false);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/GameEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */