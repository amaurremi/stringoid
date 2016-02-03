package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.al;
import com.google.android.gms.internal.am;
import com.google.android.gms.internal.en;

public final class ParticipantEntity
  extends en
  implements Participant
{
  public static final Parcelable.Creator CREATOR = new c();
  private final int a;
  private final String b;
  private final String c;
  private final Uri d;
  private final Uri e;
  private final int f;
  private final String g;
  private final boolean h;
  private final PlayerEntity i;
  private final int j;
  
  ParticipantEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, int paramInt2, String paramString3, boolean paramBoolean, PlayerEntity paramPlayerEntity, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramUri1;
    this.e = paramUri2;
    this.f = paramInt2;
    this.g = paramString3;
    this.h = paramBoolean;
    this.i = paramPlayerEntity;
    this.j = paramInt3;
  }
  
  public ParticipantEntity(Participant paramParticipant)
  {
    this.a = 1;
    this.b = paramParticipant.i();
    this.c = paramParticipant.f();
    this.d = paramParticipant.g();
    this.e = paramParticipant.h();
    this.f = paramParticipant.b();
    this.g = paramParticipant.c();
    this.h = paramParticipant.e();
    Object localObject = paramParticipant.j();
    if (localObject == null) {}
    for (localObject = null;; localObject = new PlayerEntity((Player)localObject))
    {
      this.i = ((PlayerEntity)localObject);
      this.j = paramParticipant.d();
      return;
    }
  }
  
  static int a(Participant paramParticipant)
  {
    return al.a(new Object[] { paramParticipant.j(), Integer.valueOf(paramParticipant.b()), paramParticipant.c(), Boolean.valueOf(paramParticipant.e()), paramParticipant.f(), paramParticipant.g(), paramParticipant.h(), Integer.valueOf(paramParticipant.d()) });
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
      if ((!al.a(((Participant)paramObject).j(), paramParticipant.j())) || (!al.a(Integer.valueOf(((Participant)paramObject).b()), Integer.valueOf(paramParticipant.b()))) || (!al.a(((Participant)paramObject).c(), paramParticipant.c())) || (!al.a(Boolean.valueOf(((Participant)paramObject).e()), Boolean.valueOf(paramParticipant.e()))) || (!al.a(((Participant)paramObject).f(), paramParticipant.f())) || (!al.a(((Participant)paramObject).g(), paramParticipant.g())) || (!al.a(((Participant)paramObject).h(), paramParticipant.h()))) {
        break;
      }
      bool1 = bool2;
    } while (al.a(Integer.valueOf(((Participant)paramObject).d()), Integer.valueOf(paramParticipant.d())));
    return false;
  }
  
  static String b(Participant paramParticipant)
  {
    return al.a(paramParticipant).a("Player", paramParticipant.j()).a("Status", Integer.valueOf(paramParticipant.b())).a("ClientAddress", paramParticipant.c()).a("ConnectedToRoom", Boolean.valueOf(paramParticipant.e())).a("DisplayName", paramParticipant.f()).a("IconImage", paramParticipant.g()).a("HiResImage", paramParticipant.h()).a("Capabilities", Integer.valueOf(paramParticipant.d())).toString();
  }
  
  public int b()
  {
    return this.f;
  }
  
  public String c()
  {
    return this.g;
  }
  
  public int d()
  {
    return this.j;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean e()
  {
    return this.h;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public String f()
  {
    if (this.i == null) {
      return this.c;
    }
    return this.i.c();
  }
  
  public Uri g()
  {
    if (this.i == null) {
      return this.d;
    }
    return this.i.d();
  }
  
  public Uri h()
  {
    if (this.i == null) {
      return this.e;
    }
    return this.i.e();
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public String i()
  {
    return this.b;
  }
  
  public Player j()
  {
    return this.i;
  }
  
  public int k()
  {
    return this.a;
  }
  
  public Participant l()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject2 = null;
    int m = 0;
    if (!v())
    {
      g.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    Object localObject1;
    if (this.d == null)
    {
      localObject1 = null;
      label46:
      paramParcel.writeString((String)localObject1);
      if (this.e != null) {
        break label143;
      }
      localObject1 = localObject2;
      label63:
      paramParcel.writeString((String)localObject1);
      paramParcel.writeInt(this.f);
      paramParcel.writeString(this.g);
      if (!this.h) {
        break label155;
      }
      k = 1;
      label94:
      paramParcel.writeInt(k);
      if (this.i != null) {
        break label160;
      }
    }
    label143:
    label155:
    label160:
    for (int k = m;; k = 1)
    {
      paramParcel.writeInt(k);
      if (this.i == null) {
        break;
      }
      this.i.writeToParcel(paramParcel, paramInt);
      return;
      localObject1 = this.d.toString();
      break label46;
      localObject1 = this.e.toString();
      break label63;
      k = 0;
      break label94;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/games/multiplayer/ParticipantEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */