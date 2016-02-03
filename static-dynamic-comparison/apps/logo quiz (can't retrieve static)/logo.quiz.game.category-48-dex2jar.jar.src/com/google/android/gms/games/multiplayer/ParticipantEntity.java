package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.jv;

public final class ParticipantEntity
  extends GamesDowngradeableSafeParcel
  implements Participant
{
  public static final Parcelable.Creator<ParticipantEntity> CREATOR = new ParticipantEntityCreatorCompat();
  private final int BR;
  private final int EZ;
  private final int Fa;
  private final String Nz;
  private final Uri UW;
  private final Uri UX;
  private final PlayerEntity VW;
  private final String Vh;
  private final String Vi;
  private final String Wf;
  private final String Xg;
  private final boolean abV;
  private final ParticipantResult abW;
  
  ParticipantEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, int paramInt2, String paramString3, boolean paramBoolean, PlayerEntity paramPlayerEntity, int paramInt3, ParticipantResult paramParticipantResult, String paramString4, String paramString5)
  {
    this.BR = paramInt1;
    this.Xg = paramString1;
    this.Nz = paramString2;
    this.UW = paramUri1;
    this.UX = paramUri2;
    this.Fa = paramInt2;
    this.Wf = paramString3;
    this.abV = paramBoolean;
    this.VW = paramPlayerEntity;
    this.EZ = paramInt3;
    this.abW = paramParticipantResult;
    this.Vh = paramString4;
    this.Vi = paramString5;
  }
  
  public ParticipantEntity(Participant paramParticipant)
  {
    this.BR = 3;
    this.Xg = paramParticipant.getParticipantId();
    this.Nz = paramParticipant.getDisplayName();
    this.UW = paramParticipant.getIconImageUri();
    this.UX = paramParticipant.getHiResImageUri();
    this.Fa = paramParticipant.getStatus();
    this.Wf = paramParticipant.jU();
    this.abV = paramParticipant.isConnectedToRoom();
    Object localObject = paramParticipant.getPlayer();
    if (localObject == null) {}
    for (localObject = null;; localObject = new PlayerEntity((Player)localObject))
    {
      this.VW = ((PlayerEntity)localObject);
      this.EZ = paramParticipant.getCapabilities();
      this.abW = paramParticipant.getResult();
      this.Vh = paramParticipant.getIconImageUrl();
      this.Vi = paramParticipant.getHiResImageUrl();
      return;
    }
  }
  
  static int a(Participant paramParticipant)
  {
    return m.hashCode(new Object[] { paramParticipant.getPlayer(), Integer.valueOf(paramParticipant.getStatus()), paramParticipant.jU(), Boolean.valueOf(paramParticipant.isConnectedToRoom()), paramParticipant.getDisplayName(), paramParticipant.getIconImageUri(), paramParticipant.getHiResImageUri(), Integer.valueOf(paramParticipant.getCapabilities()), paramParticipant.getResult(), paramParticipant.getParticipantId() });
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
      if ((!m.equal(((Participant)paramObject).getPlayer(), paramParticipant.getPlayer())) || (!m.equal(Integer.valueOf(((Participant)paramObject).getStatus()), Integer.valueOf(paramParticipant.getStatus()))) || (!m.equal(((Participant)paramObject).jU(), paramParticipant.jU())) || (!m.equal(Boolean.valueOf(((Participant)paramObject).isConnectedToRoom()), Boolean.valueOf(paramParticipant.isConnectedToRoom()))) || (!m.equal(((Participant)paramObject).getDisplayName(), paramParticipant.getDisplayName())) || (!m.equal(((Participant)paramObject).getIconImageUri(), paramParticipant.getIconImageUri())) || (!m.equal(((Participant)paramObject).getHiResImageUri(), paramParticipant.getHiResImageUri())) || (!m.equal(Integer.valueOf(((Participant)paramObject).getCapabilities()), Integer.valueOf(paramParticipant.getCapabilities()))) || (!m.equal(((Participant)paramObject).getResult(), paramParticipant.getResult()))) {
        break;
      }
      bool1 = bool2;
    } while (m.equal(((Participant)paramObject).getParticipantId(), paramParticipant.getParticipantId()));
    return false;
  }
  
  static String b(Participant paramParticipant)
  {
    return m.h(paramParticipant).a("ParticipantId", paramParticipant.getParticipantId()).a("Player", paramParticipant.getPlayer()).a("Status", Integer.valueOf(paramParticipant.getStatus())).a("ClientAddress", paramParticipant.jU()).a("ConnectedToRoom", Boolean.valueOf(paramParticipant.isConnectedToRoom())).a("DisplayName", paramParticipant.getDisplayName()).a("IconImage", paramParticipant.getIconImageUri()).a("IconImageUrl", paramParticipant.getIconImageUrl()).a("HiResImage", paramParticipant.getHiResImageUri()).a("HiResImageUrl", paramParticipant.getHiResImageUrl()).a("Capabilities", Integer.valueOf(paramParticipant.getCapabilities())).a("Result", paramParticipant.getResult()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Participant freeze()
  {
    return this;
  }
  
  public int getCapabilities()
  {
    return this.EZ;
  }
  
  public String getDisplayName()
  {
    if (this.VW == null) {
      return this.Nz;
    }
    return this.VW.getDisplayName();
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (this.VW == null)
    {
      jv.b(this.Nz, paramCharArrayBuffer);
      return;
    }
    this.VW.getDisplayName(paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    if (this.VW == null) {
      return this.UX;
    }
    return this.VW.getHiResImageUri();
  }
  
  public String getHiResImageUrl()
  {
    if (this.VW == null) {
      return this.Vi;
    }
    return this.VW.getHiResImageUrl();
  }
  
  public Uri getIconImageUri()
  {
    if (this.VW == null) {
      return this.UW;
    }
    return this.VW.getIconImageUri();
  }
  
  public String getIconImageUrl()
  {
    if (this.VW == null) {
      return this.Vh;
    }
    return this.VW.getIconImageUrl();
  }
  
  public String getParticipantId()
  {
    return this.Xg;
  }
  
  public Player getPlayer()
  {
    return this.VW;
  }
  
  public ParticipantResult getResult()
  {
    return this.abW;
  }
  
  public int getStatus()
  {
    return this.Fa;
  }
  
  public int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isConnectedToRoom()
  {
    return this.abV;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String jU()
  {
    return this.Wf;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject2 = null;
    int j = 0;
    if (!gQ())
    {
      ParticipantEntityCreator.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.Xg);
    paramParcel.writeString(this.Nz);
    Object localObject1;
    if (this.UW == null)
    {
      localObject1 = null;
      label46:
      paramParcel.writeString((String)localObject1);
      if (this.UX != null) {
        break label143;
      }
      localObject1 = localObject2;
      label63:
      paramParcel.writeString((String)localObject1);
      paramParcel.writeInt(this.Fa);
      paramParcel.writeString(this.Wf);
      if (!this.abV) {
        break label155;
      }
      i = 1;
      label94:
      paramParcel.writeInt(i);
      if (this.VW != null) {
        break label160;
      }
    }
    label143:
    label155:
    label160:
    for (int i = j;; i = 1)
    {
      paramParcel.writeInt(i);
      if (this.VW == null) {
        break;
      }
      this.VW.writeToParcel(paramParcel, paramInt);
      return;
      localObject1 = this.UW.toString();
      break label46;
      localObject1 = this.UX.toString();
      break label63;
      i = 0;
      break label94;
    }
  }
  
  static final class ParticipantEntityCreatorCompat
    extends ParticipantEntityCreator
  {
    public ParticipantEntity cm(Parcel paramParcel)
    {
      int i = 1;
      if ((ParticipantEntity.b(ParticipantEntity.jQ())) || (ParticipantEntity.bt(ParticipantEntity.class.getCanonicalName()))) {
        return super.cm(paramParcel);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/multiplayer/ParticipantEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */