package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hk.a;
import com.google.android.gms.internal.ik;

public final class ParticipantEntity
  extends GamesDowngradeableSafeParcel
  implements Participant
{
  public static final Parcelable.Creator<ParticipantEntity> CREATOR = new b();
  private final int Ap;
  private final String Ln;
  private final String MC;
  private final String MD;
  private final Uri Mr;
  private final Uri Ms;
  private final PlayerEntity Nj;
  private final String Nn;
  private final String Oq;
  private final int Tb;
  private final boolean Tc;
  private final ParticipantResult Td;
  private final int xM;
  
  ParticipantEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, int paramInt2, String paramString3, boolean paramBoolean, PlayerEntity paramPlayerEntity, int paramInt3, ParticipantResult paramParticipantResult, String paramString4, String paramString5)
  {
    this.xM = paramInt1;
    this.Oq = paramString1;
    this.Ln = paramString2;
    this.Mr = paramUri1;
    this.Ms = paramUri2;
    this.Tb = paramInt2;
    this.Nn = paramString3;
    this.Tc = paramBoolean;
    this.Nj = paramPlayerEntity;
    this.Ap = paramInt3;
    this.Td = paramParticipantResult;
    this.MC = paramString4;
    this.MD = paramString5;
  }
  
  public ParticipantEntity(Participant paramParticipant)
  {
    this.xM = 3;
    this.Oq = paramParticipant.getParticipantId();
    this.Ln = paramParticipant.getDisplayName();
    this.Mr = paramParticipant.getIconImageUri();
    this.Ms = paramParticipant.getHiResImageUri();
    this.Tb = paramParticipant.getStatus();
    this.Nn = paramParticipant.gW();
    this.Tc = paramParticipant.isConnectedToRoom();
    Object localObject = paramParticipant.getPlayer();
    if (localObject == null) {}
    for (localObject = null;; localObject = new PlayerEntity((Player)localObject))
    {
      this.Nj = ((PlayerEntity)localObject);
      this.Ap = paramParticipant.getCapabilities();
      this.Td = paramParticipant.getResult();
      this.MC = paramParticipant.getIconImageUrl();
      this.MD = paramParticipant.getHiResImageUrl();
      return;
    }
  }
  
  static int a(Participant paramParticipant)
  {
    return hk.hashCode(new Object[] { paramParticipant.getPlayer(), Integer.valueOf(paramParticipant.getStatus()), paramParticipant.gW(), Boolean.valueOf(paramParticipant.isConnectedToRoom()), paramParticipant.getDisplayName(), paramParticipant.getIconImageUri(), paramParticipant.getHiResImageUri(), Integer.valueOf(paramParticipant.getCapabilities()), paramParticipant.getResult(), paramParticipant.getParticipantId() });
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
      if ((!hk.equal(((Participant)paramObject).getPlayer(), paramParticipant.getPlayer())) || (!hk.equal(Integer.valueOf(((Participant)paramObject).getStatus()), Integer.valueOf(paramParticipant.getStatus()))) || (!hk.equal(((Participant)paramObject).gW(), paramParticipant.gW())) || (!hk.equal(Boolean.valueOf(((Participant)paramObject).isConnectedToRoom()), Boolean.valueOf(paramParticipant.isConnectedToRoom()))) || (!hk.equal(((Participant)paramObject).getDisplayName(), paramParticipant.getDisplayName())) || (!hk.equal(((Participant)paramObject).getIconImageUri(), paramParticipant.getIconImageUri())) || (!hk.equal(((Participant)paramObject).getHiResImageUri(), paramParticipant.getHiResImageUri())) || (!hk.equal(Integer.valueOf(((Participant)paramObject).getCapabilities()), Integer.valueOf(paramParticipant.getCapabilities()))) || (!hk.equal(((Participant)paramObject).getResult(), paramParticipant.getResult()))) {
        break;
      }
      bool1 = bool2;
    } while (hk.equal(((Participant)paramObject).getParticipantId(), paramParticipant.getParticipantId()));
    return false;
  }
  
  static String b(Participant paramParticipant)
  {
    return hk.e(paramParticipant).a("ParticipantId", paramParticipant.getParticipantId()).a("Player", paramParticipant.getPlayer()).a("Status", Integer.valueOf(paramParticipant.getStatus())).a("ClientAddress", paramParticipant.gW()).a("ConnectedToRoom", Boolean.valueOf(paramParticipant.isConnectedToRoom())).a("DisplayName", paramParticipant.getDisplayName()).a("IconImage", paramParticipant.getIconImageUri()).a("IconImageUrl", paramParticipant.getIconImageUrl()).a("HiResImage", paramParticipant.getHiResImageUri()).a("HiResImageUrl", paramParticipant.getHiResImageUrl()).a("Capabilities", Integer.valueOf(paramParticipant.getCapabilities())).a("Result", paramParticipant.getResult()).toString();
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
  
  public String gW()
  {
    return this.Nn;
  }
  
  public int getCapabilities()
  {
    return this.Ap;
  }
  
  public String getDisplayName()
  {
    if (this.Nj == null) {
      return this.Ln;
    }
    return this.Nj.getDisplayName();
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (this.Nj == null)
    {
      ik.b(this.Ln, paramCharArrayBuffer);
      return;
    }
    this.Nj.getDisplayName(paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    if (this.Nj == null) {
      return this.Ms;
    }
    return this.Nj.getHiResImageUri();
  }
  
  public String getHiResImageUrl()
  {
    if (this.Nj == null) {
      return this.MD;
    }
    return this.Nj.getHiResImageUrl();
  }
  
  public Uri getIconImageUri()
  {
    if (this.Nj == null) {
      return this.Mr;
    }
    return this.Nj.getIconImageUri();
  }
  
  public String getIconImageUrl()
  {
    if (this.Nj == null) {
      return this.MC;
    }
    return this.Nj.getIconImageUrl();
  }
  
  public String getParticipantId()
  {
    return this.Oq;
  }
  
  public Player getPlayer()
  {
    return this.Nj;
  }
  
  public ParticipantResult getResult()
  {
    return this.Td;
  }
  
  public int getStatus()
  {
    return this.Tb;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isConnectedToRoom()
  {
    return this.Tc;
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
    int j = 0;
    if (!fr())
    {
      ParticipantEntityCreator.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.Oq);
    paramParcel.writeString(this.Ln);
    Object localObject1;
    if (this.Mr == null)
    {
      localObject1 = null;
      label46:
      paramParcel.writeString((String)localObject1);
      if (this.Ms != null) {
        break label143;
      }
      localObject1 = localObject2;
      label63:
      paramParcel.writeString((String)localObject1);
      paramParcel.writeInt(this.Tb);
      paramParcel.writeString(this.Nn);
      if (!this.Tc) {
        break label155;
      }
      i = 1;
      label94:
      paramParcel.writeInt(i);
      if (this.Nj != null) {
        break label160;
      }
    }
    label143:
    label155:
    label160:
    for (int i = j;; i = 1)
    {
      paramParcel.writeInt(i);
      if (this.Nj == null) {
        break;
      }
      this.Nj.writeToParcel(paramParcel, paramInt);
      return;
      localObject1 = this.Mr.toString();
      break label46;
      localObject1 = this.Ms.toString();
      break label63;
      i = 0;
      break label94;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/multiplayer/ParticipantEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */