package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.cz;
import com.google.android.gms.internal.cz.a;
import com.google.android.gms.internal.dc;
import com.google.android.gms.internal.fy;
import java.util.ArrayList;

public final class InvitationEntity
  extends fy
  implements Invitation
{
  public static final Parcelable.Creator<InvitationEntity> CREATOR = new a();
  private final int qh;
  private final GameEntity vL;
  private final String vM;
  private final long vN;
  private final int vO;
  private final ParticipantEntity vP;
  private final ArrayList<ParticipantEntity> vQ;
  private final int vR;
  private final int vS;
  
  InvitationEntity(int paramInt1, GameEntity paramGameEntity, String paramString, long paramLong, int paramInt2, ParticipantEntity paramParticipantEntity, ArrayList<ParticipantEntity> paramArrayList, int paramInt3, int paramInt4)
  {
    this.qh = paramInt1;
    this.vL = paramGameEntity;
    this.vM = paramString;
    this.vN = paramLong;
    this.vO = paramInt2;
    this.vP = paramParticipantEntity;
    this.vQ = paramArrayList;
    this.vR = paramInt3;
    this.vS = paramInt4;
  }
  
  InvitationEntity(Invitation paramInvitation)
  {
    this.qh = 2;
    this.vL = new GameEntity(paramInvitation.nX());
    this.vM = paramInvitation.nY();
    this.vN = paramInvitation.oa();
    this.vO = paramInvitation.ob();
    this.vR = paramInvitation.oc();
    this.vS = paramInvitation.od();
    String str = paramInvitation.nZ().oi();
    Participant localParticipant = null;
    ArrayList localArrayList = paramInvitation.oe();
    int j = localArrayList.size();
    this.vQ = new ArrayList(j);
    int i = 0;
    paramInvitation = localParticipant;
    while (i < j)
    {
      localParticipant = (Participant)localArrayList.get(i);
      if (localParticipant.oi().equals(str)) {
        paramInvitation = localParticipant;
      }
      this.vQ.add((ParticipantEntity)localParticipant.mM());
      i += 1;
    }
    dc.e(paramInvitation, "Must have a valid inviter!");
    this.vP = ((ParticipantEntity)paramInvitation.mM());
  }
  
  static int a(Invitation paramInvitation)
  {
    return cz.hashCode(new Object[] { paramInvitation.nX(), paramInvitation.nY(), Long.valueOf(paramInvitation.oa()), Integer.valueOf(paramInvitation.ob()), paramInvitation.nZ(), paramInvitation.oe(), Integer.valueOf(paramInvitation.oc()), Integer.valueOf(paramInvitation.od()) });
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
      if ((!cz.b(((Invitation)paramObject).nX(), paramInvitation.nX())) || (!cz.b(((Invitation)paramObject).nY(), paramInvitation.nY())) || (!cz.b(Long.valueOf(((Invitation)paramObject).oa()), Long.valueOf(paramInvitation.oa()))) || (!cz.b(Integer.valueOf(((Invitation)paramObject).ob()), Integer.valueOf(paramInvitation.ob()))) || (!cz.b(((Invitation)paramObject).nZ(), paramInvitation.nZ())) || (!cz.b(((Invitation)paramObject).oe(), paramInvitation.oe())) || (!cz.b(Integer.valueOf(((Invitation)paramObject).oc()), Integer.valueOf(paramInvitation.oc())))) {
        break;
      }
      bool1 = bool2;
    } while (cz.b(Integer.valueOf(((Invitation)paramObject).od()), Integer.valueOf(paramInvitation.od())));
    return false;
  }
  
  static String b(Invitation paramInvitation)
  {
    return cz.M(paramInvitation).a("Game", paramInvitation.nX()).a("InvitationId", paramInvitation.nY()).a("CreationTimestamp", Long.valueOf(paramInvitation.oa())).a("InvitationType", Integer.valueOf(paramInvitation.ob())).a("Inviter", paramInvitation.nZ()).a("Participants", paramInvitation.oe()).a("Variant", Integer.valueOf(paramInvitation.oc())).a("AvailableAutoMatchSlots", Integer.valueOf(paramInvitation.od())).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public int lX()
  {
    return this.qh;
  }
  
  public Game nX()
  {
    return this.vL;
  }
  
  public String nY()
  {
    return this.vM;
  }
  
  public Participant nZ()
  {
    return this.vP;
  }
  
  public long oa()
  {
    return this.vN;
  }
  
  public int ob()
  {
    return this.vO;
  }
  
  public int oc()
  {
    return this.vR;
  }
  
  public int od()
  {
    return this.vS;
  }
  
  public ArrayList<Participant> oe()
  {
    return new ArrayList(this.vQ);
  }
  
  public Invitation of()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!qp()) {
      e.a(this, paramParcel, paramInt);
    }
    for (;;)
    {
      return;
      this.vL.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.vM);
      paramParcel.writeLong(this.vN);
      paramParcel.writeInt(this.vO);
      this.vP.writeToParcel(paramParcel, paramInt);
      int j = this.vQ.size();
      paramParcel.writeInt(j);
      int i = 0;
      while (i < j)
      {
        ((ParticipantEntity)this.vQ.get(i)).writeToParcel(paramParcel, paramInt);
        i += 1;
      }
    }
  }
  
  static final class a
    extends e
  {
    public InvitationEntity Y(Parcel paramParcel)
    {
      if ((InvitationEntity.a(InvitationEntity.nR())) || (InvitationEntity.aw(InvitationEntity.class.getCanonicalName()))) {
        return super.Y(paramParcel);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/multiplayer/InvitationEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */