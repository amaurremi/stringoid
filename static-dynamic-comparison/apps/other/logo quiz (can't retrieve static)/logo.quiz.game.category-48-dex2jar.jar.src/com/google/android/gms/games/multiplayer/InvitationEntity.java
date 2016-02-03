package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.ArrayList;

public final class InvitationEntity
  extends GamesDowngradeableSafeParcel
  implements Invitation
{
  public static final Parcelable.Creator<InvitationEntity> CREATOR = new InvitationEntityCreatorCompat();
  private final int BR;
  private final String WD;
  private final GameEntity aan;
  private final long abO;
  private final int abP;
  private final ParticipantEntity abQ;
  private final ArrayList<ParticipantEntity> abR;
  private final int abS;
  private final int abT;
  
  InvitationEntity(int paramInt1, GameEntity paramGameEntity, String paramString, long paramLong, int paramInt2, ParticipantEntity paramParticipantEntity, ArrayList<ParticipantEntity> paramArrayList, int paramInt3, int paramInt4)
  {
    this.BR = paramInt1;
    this.aan = paramGameEntity;
    this.WD = paramString;
    this.abO = paramLong;
    this.abP = paramInt2;
    this.abQ = paramParticipantEntity;
    this.abR = paramArrayList;
    this.abS = paramInt3;
    this.abT = paramInt4;
  }
  
  InvitationEntity(Invitation paramInvitation)
  {
    this.BR = 2;
    this.aan = new GameEntity(paramInvitation.getGame());
    this.WD = paramInvitation.getInvitationId();
    this.abO = paramInvitation.getCreationTimestamp();
    this.abP = paramInvitation.getInvitationType();
    this.abS = paramInvitation.getVariant();
    this.abT = paramInvitation.getAvailableAutoMatchSlots();
    String str = paramInvitation.getInviter().getParticipantId();
    Participant localParticipant = null;
    ArrayList localArrayList = paramInvitation.getParticipants();
    int j = localArrayList.size();
    this.abR = new ArrayList(j);
    int i = 0;
    paramInvitation = localParticipant;
    while (i < j)
    {
      localParticipant = (Participant)localArrayList.get(i);
      if (localParticipant.getParticipantId().equals(str)) {
        paramInvitation = localParticipant;
      }
      this.abR.add((ParticipantEntity)localParticipant.freeze());
      i += 1;
    }
    n.b(paramInvitation, "Must have a valid inviter!");
    this.abQ = ((ParticipantEntity)paramInvitation.freeze());
  }
  
  static int a(Invitation paramInvitation)
  {
    return m.hashCode(new Object[] { paramInvitation.getGame(), paramInvitation.getInvitationId(), Long.valueOf(paramInvitation.getCreationTimestamp()), Integer.valueOf(paramInvitation.getInvitationType()), paramInvitation.getInviter(), paramInvitation.getParticipants(), Integer.valueOf(paramInvitation.getVariant()), Integer.valueOf(paramInvitation.getAvailableAutoMatchSlots()) });
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
      if ((!m.equal(((Invitation)paramObject).getGame(), paramInvitation.getGame())) || (!m.equal(((Invitation)paramObject).getInvitationId(), paramInvitation.getInvitationId())) || (!m.equal(Long.valueOf(((Invitation)paramObject).getCreationTimestamp()), Long.valueOf(paramInvitation.getCreationTimestamp()))) || (!m.equal(Integer.valueOf(((Invitation)paramObject).getInvitationType()), Integer.valueOf(paramInvitation.getInvitationType()))) || (!m.equal(((Invitation)paramObject).getInviter(), paramInvitation.getInviter())) || (!m.equal(((Invitation)paramObject).getParticipants(), paramInvitation.getParticipants())) || (!m.equal(Integer.valueOf(((Invitation)paramObject).getVariant()), Integer.valueOf(paramInvitation.getVariant())))) {
        break;
      }
      bool1 = bool2;
    } while (m.equal(Integer.valueOf(((Invitation)paramObject).getAvailableAutoMatchSlots()), Integer.valueOf(paramInvitation.getAvailableAutoMatchSlots())));
    return false;
  }
  
  static String b(Invitation paramInvitation)
  {
    return m.h(paramInvitation).a("Game", paramInvitation.getGame()).a("InvitationId", paramInvitation.getInvitationId()).a("CreationTimestamp", Long.valueOf(paramInvitation.getCreationTimestamp())).a("InvitationType", Integer.valueOf(paramInvitation.getInvitationType())).a("Inviter", paramInvitation.getInviter()).a("Participants", paramInvitation.getParticipants()).a("Variant", Integer.valueOf(paramInvitation.getVariant())).a("AvailableAutoMatchSlots", Integer.valueOf(paramInvitation.getAvailableAutoMatchSlots())).toString();
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
    return this.abT;
  }
  
  public long getCreationTimestamp()
  {
    return this.abO;
  }
  
  public Game getGame()
  {
    return this.aan;
  }
  
  public String getInvitationId()
  {
    return this.WD;
  }
  
  public int getInvitationType()
  {
    return this.abP;
  }
  
  public Participant getInviter()
  {
    return this.abQ;
  }
  
  public ArrayList<Participant> getParticipants()
  {
    return new ArrayList(this.abR);
  }
  
  public int getVariant()
  {
    return this.abS;
  }
  
  public int getVersionCode()
  {
    return this.BR;
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
    if (!gQ()) {
      InvitationEntityCreator.a(this, paramParcel, paramInt);
    }
    for (;;)
    {
      return;
      this.aan.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.WD);
      paramParcel.writeLong(this.abO);
      paramParcel.writeInt(this.abP);
      this.abQ.writeToParcel(paramParcel, paramInt);
      int j = this.abR.size();
      paramParcel.writeInt(j);
      int i = 0;
      while (i < j)
      {
        ((ParticipantEntity)this.abR.get(i)).writeToParcel(paramParcel, paramInt);
        i += 1;
      }
    }
  }
  
  static final class InvitationEntityCreatorCompat
    extends InvitationEntityCreator
  {
    public InvitationEntity cl(Parcel paramParcel)
    {
      if ((InvitationEntity.b(InvitationEntity.jQ())) || (InvitationEntity.bt(InvitationEntity.class.getCanonicalName()))) {
        return super.cl(paramParcel);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/multiplayer/InvitationEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */