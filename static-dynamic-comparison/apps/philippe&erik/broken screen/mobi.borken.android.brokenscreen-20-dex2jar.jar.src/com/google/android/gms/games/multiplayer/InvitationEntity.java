package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.hn;
import java.util.ArrayList;

public final class InvitationEntity
  extends GamesDowngradeableSafeParcel
  implements Invitation
{
  public static final Parcelable.Creator<InvitationEntity> CREATOR = new InvitationEntityCreatorCompat();
  private final String NN;
  private final GameEntity Rq;
  private final long SR;
  private final int SS;
  private final ParticipantEntity ST;
  private final ArrayList<ParticipantEntity> SU;
  private final int SV;
  private final int SW;
  private final int xJ;
  
  InvitationEntity(int paramInt1, GameEntity paramGameEntity, String paramString, long paramLong, int paramInt2, ParticipantEntity paramParticipantEntity, ArrayList<ParticipantEntity> paramArrayList, int paramInt3, int paramInt4)
  {
    this.xJ = paramInt1;
    this.Rq = paramGameEntity;
    this.NN = paramString;
    this.SR = paramLong;
    this.SS = paramInt2;
    this.ST = paramParticipantEntity;
    this.SU = paramArrayList;
    this.SV = paramInt3;
    this.SW = paramInt4;
  }
  
  InvitationEntity(Invitation paramInvitation)
  {
    this.xJ = 2;
    this.Rq = new GameEntity(paramInvitation.getGame());
    this.NN = paramInvitation.getInvitationId();
    this.SR = paramInvitation.getCreationTimestamp();
    this.SS = paramInvitation.getInvitationType();
    this.SV = paramInvitation.getVariant();
    this.SW = paramInvitation.getAvailableAutoMatchSlots();
    String str = paramInvitation.getInviter().getParticipantId();
    Participant localParticipant = null;
    ArrayList localArrayList = paramInvitation.getParticipants();
    int j = localArrayList.size();
    this.SU = new ArrayList(j);
    int i = 0;
    paramInvitation = localParticipant;
    while (i < j)
    {
      localParticipant = (Participant)localArrayList.get(i);
      if (localParticipant.getParticipantId().equals(str)) {
        paramInvitation = localParticipant;
      }
      this.SU.add((ParticipantEntity)localParticipant.freeze());
      i += 1;
    }
    hn.b(paramInvitation, "Must have a valid inviter!");
    this.ST = ((ParticipantEntity)paramInvitation.freeze());
  }
  
  static int a(Invitation paramInvitation)
  {
    return hl.hashCode(new Object[] { paramInvitation.getGame(), paramInvitation.getInvitationId(), Long.valueOf(paramInvitation.getCreationTimestamp()), Integer.valueOf(paramInvitation.getInvitationType()), paramInvitation.getInviter(), paramInvitation.getParticipants(), Integer.valueOf(paramInvitation.getVariant()), Integer.valueOf(paramInvitation.getAvailableAutoMatchSlots()) });
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
      if ((!hl.equal(((Invitation)paramObject).getGame(), paramInvitation.getGame())) || (!hl.equal(((Invitation)paramObject).getInvitationId(), paramInvitation.getInvitationId())) || (!hl.equal(Long.valueOf(((Invitation)paramObject).getCreationTimestamp()), Long.valueOf(paramInvitation.getCreationTimestamp()))) || (!hl.equal(Integer.valueOf(((Invitation)paramObject).getInvitationType()), Integer.valueOf(paramInvitation.getInvitationType()))) || (!hl.equal(((Invitation)paramObject).getInviter(), paramInvitation.getInviter())) || (!hl.equal(((Invitation)paramObject).getParticipants(), paramInvitation.getParticipants())) || (!hl.equal(Integer.valueOf(((Invitation)paramObject).getVariant()), Integer.valueOf(paramInvitation.getVariant())))) {
        break;
      }
      bool1 = bool2;
    } while (hl.equal(Integer.valueOf(((Invitation)paramObject).getAvailableAutoMatchSlots()), Integer.valueOf(paramInvitation.getAvailableAutoMatchSlots())));
    return false;
  }
  
  static String b(Invitation paramInvitation)
  {
    return hl.e(paramInvitation).a("Game", paramInvitation.getGame()).a("InvitationId", paramInvitation.getInvitationId()).a("CreationTimestamp", Long.valueOf(paramInvitation.getCreationTimestamp())).a("InvitationType", Integer.valueOf(paramInvitation.getInvitationType())).a("Inviter", paramInvitation.getInviter()).a("Participants", paramInvitation.getParticipants()).a("Variant", Integer.valueOf(paramInvitation.getVariant())).a("AvailableAutoMatchSlots", Integer.valueOf(paramInvitation.getAvailableAutoMatchSlots())).toString();
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
    return this.SW;
  }
  
  public long getCreationTimestamp()
  {
    return this.SR;
  }
  
  public Game getGame()
  {
    return this.Rq;
  }
  
  public String getInvitationId()
  {
    return this.NN;
  }
  
  public int getInvitationType()
  {
    return this.SS;
  }
  
  public Participant getInviter()
  {
    return this.ST;
  }
  
  public ArrayList<Participant> getParticipants()
  {
    return new ArrayList(this.SU);
  }
  
  public int getVariant()
  {
    return this.SV;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
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
    if (!fm()) {
      InvitationEntityCreator.a(this, paramParcel, paramInt);
    }
    for (;;)
    {
      return;
      this.Rq.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.NN);
      paramParcel.writeLong(this.SR);
      paramParcel.writeInt(this.SS);
      this.ST.writeToParcel(paramParcel, paramInt);
      int j = this.SU.size();
      paramParcel.writeInt(j);
      int i = 0;
      while (i < j)
      {
        ((ParticipantEntity)this.SU.get(i)).writeToParcel(paramParcel, paramInt);
        i += 1;
      }
    }
  }
  
  static final class InvitationEntityCreatorCompat
    extends InvitationEntityCreator
  {
    public InvitationEntity bl(Parcel paramParcel)
    {
      if ((InvitationEntity.b(InvitationEntity.gM())) || (InvitationEntity.aQ(InvitationEntity.class.getCanonicalName()))) {
        return super.bl(paramParcel);
      }
      GameEntity localGameEntity = (GameEntity)GameEntity.CREATOR.createFromParcel(paramParcel);
      String str = paramParcel.readString();
      long l = paramParcel.readLong();
      int j = paramParcel.readInt();
      ParticipantEntity localParticipantEntity = (ParticipantEntity)ParticipantEntity.CREATOR.createFromParcel(paramParcel);
      int k = paramParcel.readInt();
      ArrayList localArrayList = new ArrayList(k);
      int i = 0;
      while (i < k)
      {
        localArrayList.add(ParticipantEntity.CREATOR.createFromParcel(paramParcel));
        i += 1;
      }
      return new InvitationEntity(2, localGameEntity, str, l, j, localParticipantEntity, localArrayList, -1, 0);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/multiplayer/InvitationEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */