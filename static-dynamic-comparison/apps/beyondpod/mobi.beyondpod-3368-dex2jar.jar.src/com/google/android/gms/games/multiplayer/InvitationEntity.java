package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.ee.a;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.fm;
import java.util.ArrayList;

public final class InvitationEntity
  extends fm
  implements Invitation
{
  public static final Parcelable.Creator<InvitationEntity> CREATOR = new a();
  private final int kg;
  private final String uf;
  private final GameEntity wj;
  private final long wk;
  private final int wl;
  private final ParticipantEntity wm;
  private final ArrayList<ParticipantEntity> wn;
  private final int wo;
  private final int wp;
  
  InvitationEntity(int paramInt1, GameEntity paramGameEntity, String paramString, long paramLong, int paramInt2, ParticipantEntity paramParticipantEntity, ArrayList<ParticipantEntity> paramArrayList, int paramInt3, int paramInt4)
  {
    this.kg = paramInt1;
    this.wj = paramGameEntity;
    this.uf = paramString;
    this.wk = paramLong;
    this.wl = paramInt2;
    this.wm = paramParticipantEntity;
    this.wn = paramArrayList;
    this.wo = paramInt3;
    this.wp = paramInt4;
  }
  
  InvitationEntity(Invitation paramInvitation)
  {
    this.kg = 2;
    this.wj = new GameEntity(paramInvitation.getGame());
    this.uf = paramInvitation.getInvitationId();
    this.wk = paramInvitation.getCreationTimestamp();
    this.wl = paramInvitation.getInvitationType();
    this.wo = paramInvitation.getVariant();
    this.wp = paramInvitation.getAvailableAutoMatchSlots();
    String str = paramInvitation.getInviter().getParticipantId();
    Participant localParticipant = null;
    ArrayList localArrayList = paramInvitation.getParticipants();
    int j = localArrayList.size();
    this.wn = new ArrayList(j);
    int i = 0;
    paramInvitation = localParticipant;
    while (i < j)
    {
      localParticipant = (Participant)localArrayList.get(i);
      if (localParticipant.getParticipantId().equals(str)) {
        paramInvitation = localParticipant;
      }
      this.wn.add((ParticipantEntity)localParticipant.freeze());
      i += 1;
    }
    eg.b(paramInvitation, "Must have a valid inviter!");
    this.wm = ((ParticipantEntity)paramInvitation.freeze());
  }
  
  static int a(Invitation paramInvitation)
  {
    return ee.hashCode(new Object[] { paramInvitation.getGame(), paramInvitation.getInvitationId(), Long.valueOf(paramInvitation.getCreationTimestamp()), Integer.valueOf(paramInvitation.getInvitationType()), paramInvitation.getInviter(), paramInvitation.getParticipants(), Integer.valueOf(paramInvitation.getVariant()), Integer.valueOf(paramInvitation.getAvailableAutoMatchSlots()) });
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
      if ((!ee.equal(((Invitation)paramObject).getGame(), paramInvitation.getGame())) || (!ee.equal(((Invitation)paramObject).getInvitationId(), paramInvitation.getInvitationId())) || (!ee.equal(Long.valueOf(((Invitation)paramObject).getCreationTimestamp()), Long.valueOf(paramInvitation.getCreationTimestamp()))) || (!ee.equal(Integer.valueOf(((Invitation)paramObject).getInvitationType()), Integer.valueOf(paramInvitation.getInvitationType()))) || (!ee.equal(((Invitation)paramObject).getInviter(), paramInvitation.getInviter())) || (!ee.equal(((Invitation)paramObject).getParticipants(), paramInvitation.getParticipants())) || (!ee.equal(Integer.valueOf(((Invitation)paramObject).getVariant()), Integer.valueOf(paramInvitation.getVariant())))) {
        break;
      }
      bool1 = bool2;
    } while (ee.equal(Integer.valueOf(((Invitation)paramObject).getAvailableAutoMatchSlots()), Integer.valueOf(paramInvitation.getAvailableAutoMatchSlots())));
    return false;
  }
  
  static String b(Invitation paramInvitation)
  {
    return ee.e(paramInvitation).a("Game", paramInvitation.getGame()).a("InvitationId", paramInvitation.getInvitationId()).a("CreationTimestamp", Long.valueOf(paramInvitation.getCreationTimestamp())).a("InvitationType", Integer.valueOf(paramInvitation.getInvitationType())).a("Inviter", paramInvitation.getInviter()).a("Participants", paramInvitation.getParticipants()).a("Variant", Integer.valueOf(paramInvitation.getVariant())).a("AvailableAutoMatchSlots", Integer.valueOf(paramInvitation.getAvailableAutoMatchSlots())).toString();
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
    return this.wp;
  }
  
  public long getCreationTimestamp()
  {
    return this.wk;
  }
  
  public Game getGame()
  {
    return this.wj;
  }
  
  public String getInvitationId()
  {
    return this.uf;
  }
  
  public int getInvitationType()
  {
    return this.wl;
  }
  
  public Participant getInviter()
  {
    return this.wm;
  }
  
  public ArrayList<Participant> getParticipants()
  {
    return new ArrayList(this.wn);
  }
  
  public int getVariant()
  {
    return this.wo;
  }
  
  public int getVersionCode()
  {
    return this.kg;
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
    if (!bN()) {
      a.a(this, paramParcel, paramInt);
    }
    for (;;)
    {
      return;
      this.wj.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.uf);
      paramParcel.writeLong(this.wk);
      paramParcel.writeInt(this.wl);
      this.wm.writeToParcel(paramParcel, paramInt);
      int j = this.wn.size();
      paramParcel.writeInt(j);
      int i = 0;
      while (i < j)
      {
        ((ParticipantEntity)this.wn.get(i)).writeToParcel(paramParcel, paramInt);
        i += 1;
      }
    }
  }
  
  static final class a
    extends a
  {
    public InvitationEntity aa(Parcel paramParcel)
    {
      if ((InvitationEntity.b(InvitationEntity.da())) || (InvitationEntity.ad(InvitationEntity.class.getCanonicalName()))) {
        return super.aa(paramParcel);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/games/multiplayer/InvitationEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */