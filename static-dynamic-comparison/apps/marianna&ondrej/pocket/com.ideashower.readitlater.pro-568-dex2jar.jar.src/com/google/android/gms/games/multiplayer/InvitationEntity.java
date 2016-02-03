package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.al;
import com.google.android.gms.internal.am;
import com.google.android.gms.internal.an;
import com.google.android.gms.internal.en;
import java.util.ArrayList;

public final class InvitationEntity
  extends en
  implements Invitation
{
  public static final Parcelable.Creator CREATOR = new a();
  private final int a;
  private final GameEntity b;
  private final String c;
  private final long d;
  private final int e;
  private final ParticipantEntity f;
  private final ArrayList g;
  private final int h;
  
  InvitationEntity(int paramInt1, GameEntity paramGameEntity, String paramString, long paramLong, int paramInt2, ParticipantEntity paramParticipantEntity, ArrayList paramArrayList, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramGameEntity;
    this.c = paramString;
    this.d = paramLong;
    this.e = paramInt2;
    this.f = paramParticipantEntity;
    this.g = paramArrayList;
    this.h = paramInt3;
  }
  
  InvitationEntity(Invitation paramInvitation)
  {
    this.a = 1;
    this.b = new GameEntity(paramInvitation.b());
    this.c = paramInvitation.c();
    this.d = paramInvitation.e();
    this.e = paramInvitation.f();
    this.h = paramInvitation.g();
    String str = paramInvitation.d().i();
    Participant localParticipant = null;
    ArrayList localArrayList = paramInvitation.i();
    int j = localArrayList.size();
    this.g = new ArrayList(j);
    int i = 0;
    paramInvitation = localParticipant;
    while (i < j)
    {
      localParticipant = (Participant)localArrayList.get(i);
      if (localParticipant.i().equals(str)) {
        paramInvitation = localParticipant;
      }
      this.g.add((ParticipantEntity)localParticipant.a());
      i += 1;
    }
    an.a(paramInvitation, "Must have a valid inviter!");
    this.f = ((ParticipantEntity)paramInvitation.a());
  }
  
  static int a(Invitation paramInvitation)
  {
    return al.a(new Object[] { paramInvitation.b(), paramInvitation.c(), Long.valueOf(paramInvitation.e()), Integer.valueOf(paramInvitation.f()), paramInvitation.d(), paramInvitation.i(), Integer.valueOf(paramInvitation.g()) });
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
      if ((!al.a(((Invitation)paramObject).b(), paramInvitation.b())) || (!al.a(((Invitation)paramObject).c(), paramInvitation.c())) || (!al.a(Long.valueOf(((Invitation)paramObject).e()), Long.valueOf(paramInvitation.e()))) || (!al.a(Integer.valueOf(((Invitation)paramObject).f()), Integer.valueOf(paramInvitation.f()))) || (!al.a(((Invitation)paramObject).d(), paramInvitation.d())) || (!al.a(((Invitation)paramObject).i(), paramInvitation.i()))) {
        break;
      }
      bool1 = bool2;
    } while (al.a(Integer.valueOf(((Invitation)paramObject).g()), Integer.valueOf(paramInvitation.g())));
    return false;
  }
  
  static String b(Invitation paramInvitation)
  {
    return al.a(paramInvitation).a("Game", paramInvitation.b()).a("InvitationId", paramInvitation.c()).a("CreationTimestamp", Long.valueOf(paramInvitation.e())).a("InvitationType", Integer.valueOf(paramInvitation.f())).a("Inviter", paramInvitation.d()).a("Participants", paramInvitation.i()).a("Variant", Integer.valueOf(paramInvitation.g())).toString();
  }
  
  public Game b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public Participant d()
  {
    return this.f;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long e()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public int f()
  {
    return this.e;
  }
  
  public int g()
  {
    return this.h;
  }
  
  public int h()
  {
    return this.a;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public ArrayList i()
  {
    return new ArrayList(this.g);
  }
  
  public Invitation j()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!v()) {
      f.a(this, paramParcel, paramInt);
    }
    for (;;)
    {
      return;
      this.b.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.c);
      paramParcel.writeLong(this.d);
      paramParcel.writeInt(this.e);
      this.f.writeToParcel(paramParcel, paramInt);
      int j = this.g.size();
      paramParcel.writeInt(j);
      int i = 0;
      while (i < j)
      {
        ((ParticipantEntity)this.g.get(i)).writeToParcel(paramParcel, paramInt);
        i += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/games/multiplayer/InvitationEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */