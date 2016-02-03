package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.cz;
import com.google.android.gms.internal.cz.a;
import com.google.android.gms.internal.fy;

public final class ParticipantEntity
  extends fy
  implements Participant
{
  public static final Parcelable.Creator<ParticipantEntity> CREATOR = new a();
  private final int qh;
  private final String vT;
  private final int vU;
  private final String vV;
  private final boolean vW;
  private final PlayerEntity vX;
  private final int vY;
  private final ParticipantResult vZ;
  private final String vc;
  private final Uri vh;
  private final Uri vi;
  private final String vt;
  private final String vu;
  
  ParticipantEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, int paramInt2, String paramString3, boolean paramBoolean, PlayerEntity paramPlayerEntity, int paramInt3, ParticipantResult paramParticipantResult, String paramString4, String paramString5)
  {
    this.qh = paramInt1;
    this.vT = paramString1;
    this.vc = paramString2;
    this.vh = paramUri1;
    this.vi = paramUri2;
    this.vU = paramInt2;
    this.vV = paramString3;
    this.vW = paramBoolean;
    this.vX = paramPlayerEntity;
    this.vY = paramInt3;
    this.vZ = paramParticipantResult;
    this.vt = paramString4;
    this.vu = paramString5;
  }
  
  public ParticipantEntity(Participant paramParticipant)
  {
    this.qh = 3;
    this.vT = paramParticipant.oi();
    this.vc = paramParticipant.getDisplayName();
    this.vh = paramParticipant.nC();
    this.vi = paramParticipant.nE();
    this.vU = paramParticipant.getStatus();
    this.vV = paramParticipant.og();
    this.vW = paramParticipant.oh();
    Object localObject = paramParticipant.oj();
    if (localObject == null) {}
    for (localObject = null;; localObject = new PlayerEntity((Player)localObject))
    {
      this.vX = ((PlayerEntity)localObject);
      this.vY = paramParticipant.getCapabilities();
      this.vZ = paramParticipant.ok();
      this.vt = paramParticipant.nD();
      this.vu = paramParticipant.nF();
      return;
    }
  }
  
  static int a(Participant paramParticipant)
  {
    return cz.hashCode(new Object[] { paramParticipant.oj(), Integer.valueOf(paramParticipant.getStatus()), paramParticipant.og(), Boolean.valueOf(paramParticipant.oh()), paramParticipant.getDisplayName(), paramParticipant.nC(), paramParticipant.nE(), Integer.valueOf(paramParticipant.getCapabilities()), paramParticipant.ok() });
  }
  
  static boolean a(Participant paramParticipant, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Participant)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramParticipant == paramObject);
      paramObject = (Participant)paramObject;
      if ((!cz.b(((Participant)paramObject).oj(), paramParticipant.oj())) || (!cz.b(Integer.valueOf(((Participant)paramObject).getStatus()), Integer.valueOf(paramParticipant.getStatus()))) || (!cz.b(((Participant)paramObject).og(), paramParticipant.og())) || (!cz.b(Boolean.valueOf(((Participant)paramObject).oh()), Boolean.valueOf(paramParticipant.oh()))) || (!cz.b(((Participant)paramObject).getDisplayName(), paramParticipant.getDisplayName())) || (!cz.b(((Participant)paramObject).nC(), paramParticipant.nC())) || (!cz.b(((Participant)paramObject).nE(), paramParticipant.nE())) || (!cz.b(Integer.valueOf(((Participant)paramObject).getCapabilities()), Integer.valueOf(paramParticipant.getCapabilities())))) {
        break;
      }
      bool1 = bool2;
    } while (cz.b(((Participant)paramObject).ok(), paramParticipant.ok()));
    return false;
  }
  
  static String b(Participant paramParticipant)
  {
    return cz.M(paramParticipant).a("Player", paramParticipant.oj()).a("Status", Integer.valueOf(paramParticipant.getStatus())).a("ClientAddress", paramParticipant.og()).a("ConnectedToRoom", Boolean.valueOf(paramParticipant.oh())).a("DisplayName", paramParticipant.getDisplayName()).a("IconImage", paramParticipant.nC()).a("IconImageUrl", paramParticipant.nD()).a("HiResImage", paramParticipant.nE()).a("HiResImageUrl", paramParticipant.nF()).a("Capabilities", Integer.valueOf(paramParticipant.getCapabilities())).a("Result", paramParticipant.ok()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public int getCapabilities()
  {
    return this.vY;
  }
  
  public String getDisplayName()
  {
    if (this.vX == null) {
      return this.vc;
    }
    return this.vX.getDisplayName();
  }
  
  public int getStatus()
  {
    return this.vU;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public int lX()
  {
    return this.qh;
  }
  
  public Uri nC()
  {
    if (this.vX == null) {
      return this.vh;
    }
    return this.vX.nC();
  }
  
  public String nD()
  {
    if (this.vX == null) {
      return this.vt;
    }
    return this.vX.nD();
  }
  
  public Uri nE()
  {
    if (this.vX == null) {
      return this.vi;
    }
    return this.vX.nE();
  }
  
  public String nF()
  {
    if (this.vX == null) {
      return this.vu;
    }
    return this.vX.nF();
  }
  
  public String og()
  {
    return this.vV;
  }
  
  public boolean oh()
  {
    return this.vW;
  }
  
  public String oi()
  {
    return this.vT;
  }
  
  public Player oj()
  {
    return this.vX;
  }
  
  public ParticipantResult ok()
  {
    return this.vZ;
  }
  
  public Participant ol()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject2 = null;
    int j = 0;
    if (!qp())
    {
      f.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.vT);
    paramParcel.writeString(this.vc);
    Object localObject1;
    if (this.vh == null)
    {
      localObject1 = null;
      label46:
      paramParcel.writeString((String)localObject1);
      if (this.vi != null) {
        break label143;
      }
      localObject1 = localObject2;
      label63:
      paramParcel.writeString((String)localObject1);
      paramParcel.writeInt(this.vU);
      paramParcel.writeString(this.vV);
      if (!this.vW) {
        break label155;
      }
      i = 1;
      label94:
      paramParcel.writeInt(i);
      if (this.vX != null) {
        break label160;
      }
    }
    label143:
    label155:
    label160:
    for (int i = j;; i = 1)
    {
      paramParcel.writeInt(i);
      if (this.vX == null) {
        break;
      }
      this.vX.writeToParcel(paramParcel, paramInt);
      return;
      localObject1 = this.vh.toString();
      break label46;
      localObject1 = this.vi.toString();
      break label63;
      i = 0;
      break label94;
    }
  }
  
  static final class a
    extends f
  {
    public ParticipantEntity Z(Parcel paramParcel)
    {
      int i = 1;
      if ((ParticipantEntity.a(ParticipantEntity.nR())) || (ParticipantEntity.aw(ParticipantEntity.class.getCanonicalName()))) {
        return super.Z(paramParcel);
      }
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      Object localObject1 = paramParcel.readString();
      Object localObject2;
      label68:
      int j;
      String str3;
      boolean bool;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = paramParcel.readString();
        if (localObject2 != null) {
          break label151;
        }
        localObject2 = null;
        j = paramParcel.readInt();
        str3 = paramParcel.readString();
        if (paramParcel.readInt() <= 0) {
          break label161;
        }
        bool = true;
        label89:
        if (paramParcel.readInt() <= 0) {
          break label167;
        }
        label96:
        if (i == 0) {
          break label172;
        }
      }
      label151:
      label161:
      label167:
      label172:
      for (paramParcel = (PlayerEntity)PlayerEntity.CREATOR.createFromParcel(paramParcel);; paramParcel = null)
      {
        return new ParticipantEntity(3, str1, str2, (Uri)localObject1, (Uri)localObject2, j, str3, bool, paramParcel, 7, null, null, null);
        localObject1 = Uri.parse((String)localObject1);
        break;
        localObject2 = Uri.parse((String)localObject2);
        break label68;
        bool = false;
        break label89;
        i = 0;
        break label96;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/multiplayer/ParticipantEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */