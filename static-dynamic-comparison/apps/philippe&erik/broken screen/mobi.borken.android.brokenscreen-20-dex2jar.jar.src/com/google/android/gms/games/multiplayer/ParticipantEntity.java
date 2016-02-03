package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.il;

public final class ParticipantEntity
  extends GamesDowngradeableSafeParcel
  implements Participant
{
  public static final Parcelable.Creator<ParticipantEntity> CREATOR = new ParticipantEntityCreatorCompat();
  private final int Am;
  private final String Lk;
  private final String MA;
  private final Uri Mo;
  private final Uri Mp;
  private final String Mz;
  private final PlayerEntity Ng;
  private final String Nk;
  private final String On;
  private final int SY;
  private final boolean SZ;
  private final ParticipantResult Ta;
  private final int xJ;
  
  ParticipantEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, int paramInt2, String paramString3, boolean paramBoolean, PlayerEntity paramPlayerEntity, int paramInt3, ParticipantResult paramParticipantResult, String paramString4, String paramString5)
  {
    this.xJ = paramInt1;
    this.On = paramString1;
    this.Lk = paramString2;
    this.Mo = paramUri1;
    this.Mp = paramUri2;
    this.SY = paramInt2;
    this.Nk = paramString3;
    this.SZ = paramBoolean;
    this.Ng = paramPlayerEntity;
    this.Am = paramInt3;
    this.Ta = paramParticipantResult;
    this.Mz = paramString4;
    this.MA = paramString5;
  }
  
  public ParticipantEntity(Participant paramParticipant)
  {
    this.xJ = 3;
    this.On = paramParticipant.getParticipantId();
    this.Lk = paramParticipant.getDisplayName();
    this.Mo = paramParticipant.getIconImageUri();
    this.Mp = paramParticipant.getHiResImageUri();
    this.SY = paramParticipant.getStatus();
    this.Nk = paramParticipant.gR();
    this.SZ = paramParticipant.isConnectedToRoom();
    Object localObject = paramParticipant.getPlayer();
    if (localObject == null) {}
    for (localObject = null;; localObject = new PlayerEntity((Player)localObject))
    {
      this.Ng = ((PlayerEntity)localObject);
      this.Am = paramParticipant.getCapabilities();
      this.Ta = paramParticipant.getResult();
      this.Mz = paramParticipant.getIconImageUrl();
      this.MA = paramParticipant.getHiResImageUrl();
      return;
    }
  }
  
  static int a(Participant paramParticipant)
  {
    return hl.hashCode(new Object[] { paramParticipant.getPlayer(), Integer.valueOf(paramParticipant.getStatus()), paramParticipant.gR(), Boolean.valueOf(paramParticipant.isConnectedToRoom()), paramParticipant.getDisplayName(), paramParticipant.getIconImageUri(), paramParticipant.getHiResImageUri(), Integer.valueOf(paramParticipant.getCapabilities()), paramParticipant.getResult(), paramParticipant.getParticipantId() });
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
      if ((!hl.equal(((Participant)paramObject).getPlayer(), paramParticipant.getPlayer())) || (!hl.equal(Integer.valueOf(((Participant)paramObject).getStatus()), Integer.valueOf(paramParticipant.getStatus()))) || (!hl.equal(((Participant)paramObject).gR(), paramParticipant.gR())) || (!hl.equal(Boolean.valueOf(((Participant)paramObject).isConnectedToRoom()), Boolean.valueOf(paramParticipant.isConnectedToRoom()))) || (!hl.equal(((Participant)paramObject).getDisplayName(), paramParticipant.getDisplayName())) || (!hl.equal(((Participant)paramObject).getIconImageUri(), paramParticipant.getIconImageUri())) || (!hl.equal(((Participant)paramObject).getHiResImageUri(), paramParticipant.getHiResImageUri())) || (!hl.equal(Integer.valueOf(((Participant)paramObject).getCapabilities()), Integer.valueOf(paramParticipant.getCapabilities()))) || (!hl.equal(((Participant)paramObject).getResult(), paramParticipant.getResult()))) {
        break;
      }
      bool1 = bool2;
    } while (hl.equal(((Participant)paramObject).getParticipantId(), paramParticipant.getParticipantId()));
    return false;
  }
  
  static String b(Participant paramParticipant)
  {
    return hl.e(paramParticipant).a("ParticipantId", paramParticipant.getParticipantId()).a("Player", paramParticipant.getPlayer()).a("Status", Integer.valueOf(paramParticipant.getStatus())).a("ClientAddress", paramParticipant.gR()).a("ConnectedToRoom", Boolean.valueOf(paramParticipant.isConnectedToRoom())).a("DisplayName", paramParticipant.getDisplayName()).a("IconImage", paramParticipant.getIconImageUri()).a("IconImageUrl", paramParticipant.getIconImageUrl()).a("HiResImage", paramParticipant.getHiResImageUri()).a("HiResImageUrl", paramParticipant.getHiResImageUrl()).a("Capabilities", Integer.valueOf(paramParticipant.getCapabilities())).a("Result", paramParticipant.getResult()).toString();
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
  
  public String gR()
  {
    return this.Nk;
  }
  
  public int getCapabilities()
  {
    return this.Am;
  }
  
  public String getDisplayName()
  {
    if (this.Ng == null) {
      return this.Lk;
    }
    return this.Ng.getDisplayName();
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (this.Ng == null)
    {
      il.b(this.Lk, paramCharArrayBuffer);
      return;
    }
    this.Ng.getDisplayName(paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    if (this.Ng == null) {
      return this.Mp;
    }
    return this.Ng.getHiResImageUri();
  }
  
  public String getHiResImageUrl()
  {
    if (this.Ng == null) {
      return this.MA;
    }
    return this.Ng.getHiResImageUrl();
  }
  
  public Uri getIconImageUri()
  {
    if (this.Ng == null) {
      return this.Mo;
    }
    return this.Ng.getIconImageUri();
  }
  
  public String getIconImageUrl()
  {
    if (this.Ng == null) {
      return this.Mz;
    }
    return this.Ng.getIconImageUrl();
  }
  
  public String getParticipantId()
  {
    return this.On;
  }
  
  public Player getPlayer()
  {
    return this.Ng;
  }
  
  public ParticipantResult getResult()
  {
    return this.Ta;
  }
  
  public int getStatus()
  {
    return this.SY;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isConnectedToRoom()
  {
    return this.SZ;
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
    if (!fm())
    {
      ParticipantEntityCreator.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.On);
    paramParcel.writeString(this.Lk);
    Object localObject1;
    if (this.Mo == null)
    {
      localObject1 = null;
      label46:
      paramParcel.writeString((String)localObject1);
      if (this.Mp != null) {
        break label143;
      }
      localObject1 = localObject2;
      label63:
      paramParcel.writeString((String)localObject1);
      paramParcel.writeInt(this.SY);
      paramParcel.writeString(this.Nk);
      if (!this.SZ) {
        break label155;
      }
      i = 1;
      label94:
      paramParcel.writeInt(i);
      if (this.Ng != null) {
        break label160;
      }
    }
    label143:
    label155:
    label160:
    for (int i = j;; i = 1)
    {
      paramParcel.writeInt(i);
      if (this.Ng == null) {
        break;
      }
      this.Ng.writeToParcel(paramParcel, paramInt);
      return;
      localObject1 = this.Mo.toString();
      break label46;
      localObject1 = this.Mp.toString();
      break label63;
      i = 0;
      break label94;
    }
  }
  
  static final class ParticipantEntityCreatorCompat
    extends ParticipantEntityCreator
  {
    public ParticipantEntity bm(Parcel paramParcel)
    {
      int i = 1;
      if ((ParticipantEntity.b(ParticipantEntity.gM())) || (ParticipantEntity.aQ(ParticipantEntity.class.getCanonicalName()))) {
        return super.bm(paramParcel);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/multiplayer/ParticipantEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */