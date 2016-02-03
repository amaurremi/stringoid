package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.ee.a;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.fm;

public final class ParticipantEntity
  extends fm
  implements Participant
{
  public static final Parcelable.Creator<ParticipantEntity> CREATOR = new a();
  private final int kg;
  private final String qa;
  private final Uri sL;
  private final Uri sM;
  private final String up;
  private final int wr;
  private final String ws;
  private final boolean wt;
  private final PlayerEntity wu;
  private final int wv;
  private final ParticipantResult ww;
  
  ParticipantEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, int paramInt2, String paramString3, boolean paramBoolean, PlayerEntity paramPlayerEntity, int paramInt3, ParticipantResult paramParticipantResult)
  {
    this.kg = paramInt1;
    this.up = paramString1;
    this.qa = paramString2;
    this.sL = paramUri1;
    this.sM = paramUri2;
    this.wr = paramInt2;
    this.ws = paramString3;
    this.wt = paramBoolean;
    this.wu = paramPlayerEntity;
    this.wv = paramInt3;
    this.ww = paramParticipantResult;
  }
  
  public ParticipantEntity(Participant paramParticipant)
  {
    this.kg = 2;
    this.up = paramParticipant.getParticipantId();
    this.qa = paramParticipant.getDisplayName();
    this.sL = paramParticipant.getIconImageUri();
    this.sM = paramParticipant.getHiResImageUri();
    this.wr = paramParticipant.getStatus();
    this.ws = paramParticipant.dy();
    this.wt = paramParticipant.isConnectedToRoom();
    Object localObject = paramParticipant.getPlayer();
    if (localObject == null) {}
    for (localObject = null;; localObject = new PlayerEntity((Player)localObject))
    {
      this.wu = ((PlayerEntity)localObject);
      this.wv = paramParticipant.getCapabilities();
      this.ww = paramParticipant.getResult();
      return;
    }
  }
  
  static int a(Participant paramParticipant)
  {
    return ee.hashCode(new Object[] { paramParticipant.getPlayer(), Integer.valueOf(paramParticipant.getStatus()), paramParticipant.dy(), Boolean.valueOf(paramParticipant.isConnectedToRoom()), paramParticipant.getDisplayName(), paramParticipant.getIconImageUri(), paramParticipant.getHiResImageUri(), Integer.valueOf(paramParticipant.getCapabilities()), paramParticipant.getResult() });
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
      if ((!ee.equal(((Participant)paramObject).getPlayer(), paramParticipant.getPlayer())) || (!ee.equal(Integer.valueOf(((Participant)paramObject).getStatus()), Integer.valueOf(paramParticipant.getStatus()))) || (!ee.equal(((Participant)paramObject).dy(), paramParticipant.dy())) || (!ee.equal(Boolean.valueOf(((Participant)paramObject).isConnectedToRoom()), Boolean.valueOf(paramParticipant.isConnectedToRoom()))) || (!ee.equal(((Participant)paramObject).getDisplayName(), paramParticipant.getDisplayName())) || (!ee.equal(((Participant)paramObject).getIconImageUri(), paramParticipant.getIconImageUri())) || (!ee.equal(((Participant)paramObject).getHiResImageUri(), paramParticipant.getHiResImageUri())) || (!ee.equal(Integer.valueOf(((Participant)paramObject).getCapabilities()), Integer.valueOf(paramParticipant.getCapabilities())))) {
        break;
      }
      bool1 = bool2;
    } while (ee.equal(((Participant)paramObject).getResult(), paramParticipant.getResult()));
    return false;
  }
  
  static String b(Participant paramParticipant)
  {
    return ee.e(paramParticipant).a("Player", paramParticipant.getPlayer()).a("Status", Integer.valueOf(paramParticipant.getStatus())).a("ClientAddress", paramParticipant.dy()).a("ConnectedToRoom", Boolean.valueOf(paramParticipant.isConnectedToRoom())).a("DisplayName", paramParticipant.getDisplayName()).a("IconImage", paramParticipant.getIconImageUri()).a("HiResImage", paramParticipant.getHiResImageUri()).a("Capabilities", Integer.valueOf(paramParticipant.getCapabilities())).a("Result", paramParticipant.getResult()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String dy()
  {
    return this.ws;
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
    return this.wv;
  }
  
  public String getDisplayName()
  {
    if (this.wu == null) {
      return this.qa;
    }
    return this.wu.getDisplayName();
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (this.wu == null)
    {
      fc.b(this.qa, paramCharArrayBuffer);
      return;
    }
    this.wu.getDisplayName(paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    if (this.wu == null) {
      return this.sM;
    }
    return this.wu.getHiResImageUri();
  }
  
  public Uri getIconImageUri()
  {
    if (this.wu == null) {
      return this.sL;
    }
    return this.wu.getIconImageUri();
  }
  
  public String getParticipantId()
  {
    return this.up;
  }
  
  public Player getPlayer()
  {
    return this.wu;
  }
  
  public ParticipantResult getResult()
  {
    return this.ww;
  }
  
  public int getStatus()
  {
    return this.wr;
  }
  
  public int getVersionCode()
  {
    return this.kg;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isConnectedToRoom()
  {
    return this.wt;
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
    if (!bN())
    {
      c.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.up);
    paramParcel.writeString(this.qa);
    Object localObject1;
    if (this.sL == null)
    {
      localObject1 = null;
      label46:
      paramParcel.writeString((String)localObject1);
      if (this.sM != null) {
        break label143;
      }
      localObject1 = localObject2;
      label63:
      paramParcel.writeString((String)localObject1);
      paramParcel.writeInt(this.wr);
      paramParcel.writeString(this.ws);
      if (!this.wt) {
        break label155;
      }
      i = 1;
      label94:
      paramParcel.writeInt(i);
      if (this.wu != null) {
        break label160;
      }
    }
    label143:
    label155:
    label160:
    for (int i = j;; i = 1)
    {
      paramParcel.writeInt(i);
      if (this.wu == null) {
        break;
      }
      this.wu.writeToParcel(paramParcel, paramInt);
      return;
      localObject1 = this.sL.toString();
      break label46;
      localObject1 = this.sM.toString();
      break label63;
      i = 0;
      break label94;
    }
  }
  
  static final class a
    extends c
  {
    public ParticipantEntity ab(Parcel paramParcel)
    {
      int i = 1;
      if ((ParticipantEntity.b(ParticipantEntity.da())) || (ParticipantEntity.ad(ParticipantEntity.class.getCanonicalName()))) {
        return super.ab(paramParcel);
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
          break label149;
        }
        localObject2 = null;
        j = paramParcel.readInt();
        str3 = paramParcel.readString();
        if (paramParcel.readInt() <= 0) {
          break label159;
        }
        bool = true;
        label89:
        if (paramParcel.readInt() <= 0) {
          break label165;
        }
        label96:
        if (i == 0) {
          break label170;
        }
      }
      label149:
      label159:
      label165:
      label170:
      for (paramParcel = (PlayerEntity)PlayerEntity.CREATOR.createFromParcel(paramParcel);; paramParcel = null)
      {
        return new ParticipantEntity(2, str1, str2, (Uri)localObject1, (Uri)localObject2, j, str3, bool, paramParcel, 7, null);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/games/multiplayer/ParticipantEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */