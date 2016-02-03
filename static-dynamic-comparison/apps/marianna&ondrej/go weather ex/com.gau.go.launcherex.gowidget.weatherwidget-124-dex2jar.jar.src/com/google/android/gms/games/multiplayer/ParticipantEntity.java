package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fo.a;
import com.google.android.gms.internal.gm;

public final class ParticipantEntity
  extends GamesDowngradeableSafeParcel
  implements Participant
{
  public static final Parcelable.Creator<ParticipantEntity> CREATOR = new ParticipantEntityCreatorCompat();
  private final String HA;
  private final Uri HF;
  private final Uri HG;
  private final String HQ;
  private final String HR;
  private final String Is;
  private final String Jg;
  private final PlayerEntity LH;
  private final int MB;
  private final boolean MC;
  private final int MD;
  private final ParticipantResult ME;
  private final int xH;
  
  ParticipantEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, int paramInt2, String paramString3, boolean paramBoolean, PlayerEntity paramPlayerEntity, int paramInt3, ParticipantResult paramParticipantResult, String paramString4, String paramString5)
  {
    this.xH = paramInt1;
    this.Jg = paramString1;
    this.HA = paramString2;
    this.HF = paramUri1;
    this.HG = paramUri2;
    this.MB = paramInt2;
    this.Is = paramString3;
    this.MC = paramBoolean;
    this.LH = paramPlayerEntity;
    this.MD = paramInt3;
    this.ME = paramParticipantResult;
    this.HQ = paramString4;
    this.HR = paramString5;
  }
  
  public ParticipantEntity(Participant paramParticipant)
  {
    this.xH = 3;
    this.Jg = paramParticipant.getParticipantId();
    this.HA = paramParticipant.getDisplayName();
    this.HF = paramParticipant.getIconImageUri();
    this.HG = paramParticipant.getHiResImageUri();
    this.MB = paramParticipant.getStatus();
    this.Is = paramParticipant.gi();
    this.MC = paramParticipant.isConnectedToRoom();
    Object localObject = paramParticipant.getPlayer();
    if (localObject == null) {}
    for (localObject = null;; localObject = new PlayerEntity((Player)localObject))
    {
      this.LH = ((PlayerEntity)localObject);
      this.MD = paramParticipant.getCapabilities();
      this.ME = paramParticipant.getResult();
      this.HQ = paramParticipant.getIconImageUrl();
      this.HR = paramParticipant.getHiResImageUrl();
      return;
    }
  }
  
  static int a(Participant paramParticipant)
  {
    return fo.hashCode(new Object[] { paramParticipant.getPlayer(), Integer.valueOf(paramParticipant.getStatus()), paramParticipant.gi(), Boolean.valueOf(paramParticipant.isConnectedToRoom()), paramParticipant.getDisplayName(), paramParticipant.getIconImageUri(), paramParticipant.getHiResImageUri(), Integer.valueOf(paramParticipant.getCapabilities()), paramParticipant.getResult(), paramParticipant.getParticipantId() });
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
      if ((!fo.equal(((Participant)paramObject).getPlayer(), paramParticipant.getPlayer())) || (!fo.equal(Integer.valueOf(((Participant)paramObject).getStatus()), Integer.valueOf(paramParticipant.getStatus()))) || (!fo.equal(((Participant)paramObject).gi(), paramParticipant.gi())) || (!fo.equal(Boolean.valueOf(((Participant)paramObject).isConnectedToRoom()), Boolean.valueOf(paramParticipant.isConnectedToRoom()))) || (!fo.equal(((Participant)paramObject).getDisplayName(), paramParticipant.getDisplayName())) || (!fo.equal(((Participant)paramObject).getIconImageUri(), paramParticipant.getIconImageUri())) || (!fo.equal(((Participant)paramObject).getHiResImageUri(), paramParticipant.getHiResImageUri())) || (!fo.equal(Integer.valueOf(((Participant)paramObject).getCapabilities()), Integer.valueOf(paramParticipant.getCapabilities()))) || (!fo.equal(((Participant)paramObject).getResult(), paramParticipant.getResult()))) {
        break;
      }
      bool1 = bool2;
    } while (fo.equal(((Participant)paramObject).getParticipantId(), paramParticipant.getParticipantId()));
    return false;
  }
  
  static String b(Participant paramParticipant)
  {
    return fo.e(paramParticipant).a("ParticipantId", paramParticipant.getParticipantId()).a("Player", paramParticipant.getPlayer()).a("Status", Integer.valueOf(paramParticipant.getStatus())).a("ClientAddress", paramParticipant.gi()).a("ConnectedToRoom", Boolean.valueOf(paramParticipant.isConnectedToRoom())).a("DisplayName", paramParticipant.getDisplayName()).a("IconImage", paramParticipant.getIconImageUri()).a("IconImageUrl", paramParticipant.getIconImageUrl()).a("HiResImage", paramParticipant.getHiResImageUri()).a("HiResImageUrl", paramParticipant.getHiResImageUrl()).a("Capabilities", Integer.valueOf(paramParticipant.getCapabilities())).a("Result", paramParticipant.getResult()).toString();
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
    return this.MD;
  }
  
  public String getDisplayName()
  {
    if (this.LH == null) {
      return this.HA;
    }
    return this.LH.getDisplayName();
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (this.LH == null)
    {
      gm.b(this.HA, paramCharArrayBuffer);
      return;
    }
    this.LH.getDisplayName(paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    if (this.LH == null) {
      return this.HG;
    }
    return this.LH.getHiResImageUri();
  }
  
  public String getHiResImageUrl()
  {
    if (this.LH == null) {
      return this.HR;
    }
    return this.LH.getHiResImageUrl();
  }
  
  public Uri getIconImageUri()
  {
    if (this.LH == null) {
      return this.HF;
    }
    return this.LH.getIconImageUri();
  }
  
  public String getIconImageUrl()
  {
    if (this.LH == null) {
      return this.HQ;
    }
    return this.LH.getIconImageUrl();
  }
  
  public String getParticipantId()
  {
    return this.Jg;
  }
  
  public Player getPlayer()
  {
    return this.LH;
  }
  
  public ParticipantResult getResult()
  {
    return this.ME;
  }
  
  public int getStatus()
  {
    return this.MB;
  }
  
  public int getVersionCode()
  {
    return this.xH;
  }
  
  public String gi()
  {
    return this.Is;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isConnectedToRoom()
  {
    return this.MC;
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
    if (!eK())
    {
      ParticipantEntityCreator.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.Jg);
    paramParcel.writeString(this.HA);
    Object localObject1;
    if (this.HF == null)
    {
      localObject1 = null;
      label46:
      paramParcel.writeString((String)localObject1);
      if (this.HG != null) {
        break label143;
      }
      localObject1 = localObject2;
      label63:
      paramParcel.writeString((String)localObject1);
      paramParcel.writeInt(this.MB);
      paramParcel.writeString(this.Is);
      if (!this.MC) {
        break label155;
      }
      i = 1;
      label94:
      paramParcel.writeInt(i);
      if (this.LH != null) {
        break label160;
      }
    }
    label143:
    label155:
    label160:
    for (int i = j;; i = 1)
    {
      paramParcel.writeInt(i);
      if (this.LH == null) {
        break;
      }
      this.LH.writeToParcel(paramParcel, paramInt);
      return;
      localObject1 = this.HF.toString();
      break label46;
      localObject1 = this.HG.toString();
      break label63;
      i = 0;
      break label94;
    }
  }
  
  static final class ParticipantEntityCreatorCompat
    extends ParticipantEntityCreator
  {
    public ParticipantEntity av(Parcel paramParcel)
    {
      int i = 1;
      if ((ParticipantEntity.b(ParticipantEntity.gg())) || (ParticipantEntity.az(ParticipantEntity.class.getCanonicalName()))) {
        return super.av(paramParcel);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/games/multiplayer/ParticipantEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */