package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hk.a;
import com.google.android.gms.internal.hm;
import java.util.ArrayList;

public final class InvitationEntity
  extends GamesDowngradeableSafeParcel
  implements Invitation
{
  public static final Parcelable.Creator<InvitationEntity> CREATOR = new a();
  private final String NQ;
  private final GameEntity Rt;
  private final long SU;
  private final int SV;
  private final ParticipantEntity SW;
  private final ArrayList<ParticipantEntity> SX;
  private final int SY;
  private final int SZ;
  private final int xM;
  
  InvitationEntity(int paramInt1, GameEntity paramGameEntity, String paramString, long paramLong, int paramInt2, ParticipantEntity paramParticipantEntity, ArrayList<ParticipantEntity> paramArrayList, int paramInt3, int paramInt4)
  {
    this.xM = paramInt1;
    this.Rt = paramGameEntity;
    this.NQ = paramString;
    this.SU = paramLong;
    this.SV = paramInt2;
    this.SW = paramParticipantEntity;
    this.SX = paramArrayList;
    this.SY = paramInt3;
    this.SZ = paramInt4;
  }
  
  InvitationEntity(Invitation paramInvitation)
  {
    this.xM = 2;
    this.Rt = new GameEntity(paramInvitation.getGame());
    this.NQ = paramInvitation.getInvitationId();
    this.SU = paramInvitation.getCreationTimestamp();
    this.SV = paramInvitation.getInvitationType();
    this.SY = paramInvitation.getVariant();
    this.SZ = paramInvitation.getAvailableAutoMatchSlots();
    String str = paramInvitation.getInviter().getParticipantId();
    Participant localParticipant = null;
    ArrayList localArrayList = paramInvitation.getParticipants();
    int j = localArrayList.size();
    this.SX = new ArrayList(j);
    int i = 0;
    paramInvitation = localParticipant;
    while (i < j)
    {
      localParticipant = (Participant)localArrayList.get(i);
      if (localParticipant.getParticipantId().equals(str)) {
        paramInvitation = localParticipant;
      }
      this.SX.add((ParticipantEntity)localParticipant.freeze());
      i += 1;
    }
    hm.b(paramInvitation, "Must have a valid inviter!");
    this.SW = ((ParticipantEntity)paramInvitation.freeze());
  }
  
  static int a(Invitation paramInvitation)
  {
    return hk.hashCode(new Object[] { paramInvitation.getGame(), paramInvitation.getInvitationId(), Long.valueOf(paramInvitation.getCreationTimestamp()), Integer.valueOf(paramInvitation.getInvitationType()), paramInvitation.getInviter(), paramInvitation.getParticipants(), Integer.valueOf(paramInvitation.getVariant()), Integer.valueOf(paramInvitation.getAvailableAutoMatchSlots()) });
  }
  
  static boolean a(Invitation paramInvitation, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Invitation)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramInvitation == paramObject);
      paramObject = (Invitation)paramObject;
      if ((!hk.equal(((Invitation)paramObject).getGame(), paramInvitation.getGame())) || (!hk.equal(((Invitation)paramObject).getInvitationId(), paramInvitation.getInvitationId())) || (!hk.equal(Long.valueOf(((Invitation)paramObject).getCreationTimestamp()), Long.valueOf(paramInvitation.getCreationTimestamp()))) || (!hk.equal(Integer.valueOf(((Invitation)paramObject).getInvitationType()), Integer.valueOf(paramInvitation.getInvitationType()))) || (!hk.equal(((Invitation)paramObject).getInviter(), paramInvitation.getInviter())) || (!hk.equal(((Invitation)paramObject).getParticipants(), paramInvitation.getParticipants())) || (!hk.equal(Integer.valueOf(((Invitation)paramObject).getVariant()), Integer.valueOf(paramInvitation.getVariant())))) {
        break;
      }
      bool1 = bool2;
    } while (hk.equal(Integer.valueOf(((Invitation)paramObject).getAvailableAutoMatchSlots()), Integer.valueOf(paramInvitation.getAvailableAutoMatchSlots())));
    return false;
  }
  
  static String b(Invitation paramInvitation)
  {
    return hk.e(paramInvitation).a("Game", paramInvitation.getGame()).a("InvitationId", paramInvitation.getInvitationId()).a("CreationTimestamp", Long.valueOf(paramInvitation.getCreationTimestamp())).a("InvitationType", Integer.valueOf(paramInvitation.getInvitationType())).a("Inviter", paramInvitation.getInviter()).a("Participants", paramInvitation.getParticipants()).a("Variant", Integer.valueOf(paramInvitation.getVariant())).a("AvailableAutoMatchSlots", Integer.valueOf(paramInvitation.getAvailableAutoMatchSlots())).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Invitation freeze()
  {
    return this;
  }
  
  public int getAvailableAutoMatchSlots()
  {
    return this.SZ;
  }
  
  public long getCreationTimestamp()
  {
    return this.SU;
  }
  
  public Game getGame()
  {
    return this.Rt;
  }
  
  public String getInvitationId()
  {
    return this.NQ;
  }
  
  public int getInvitationType()
  {
    return this.SV;
  }
  
  public Participant getInviter()
  {
    return this.SW;
  }
  
  public ArrayList<Participant> getParticipants()
  {
    return new ArrayList(this.SX);
  }
  
  public int getVariant()
  {
    return this.SY;
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
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!fr()) {
      InvitationEntityCreator.a(this, paramParcel, paramInt);
    }
    for (;;)
    {
      return;
      this.Rt.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.NQ);
      paramParcel.writeLong(this.SU);
      paramParcel.writeInt(this.SV);
      this.SW.writeToParcel(paramParcel, paramInt);
      int j = this.SX.size();
      paramParcel.writeInt(j);
      int i = 0;
      while (i < j)
      {
        ((ParticipantEntity)this.SX.get(i)).writeToParcel(paramParcel, paramInt);
        i += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/multiplayer/InvitationEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */