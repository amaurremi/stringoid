package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.al;
import com.google.android.gms.internal.am;
import com.google.android.gms.internal.en;
import java.util.ArrayList;

public final class RoomEntity
  extends en
  implements Room
{
  public static final Parcelable.Creator CREATOR = new b();
  private final int a;
  private final String b;
  private final String c;
  private final long d;
  private final int e;
  private final String f;
  private final int g;
  private final Bundle h;
  private final ArrayList i;
  private final int j;
  
  RoomEntity(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, String paramString3, int paramInt3, Bundle paramBundle, ArrayList paramArrayList, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramLong;
    this.e = paramInt2;
    this.f = paramString3;
    this.g = paramInt3;
    this.h = paramBundle;
    this.i = paramArrayList;
    this.j = paramInt4;
  }
  
  public RoomEntity(Room paramRoom)
  {
    this.a = 2;
    this.b = paramRoom.b();
    this.c = paramRoom.c();
    this.d = paramRoom.d();
    this.e = paramRoom.e();
    this.f = paramRoom.f();
    this.g = paramRoom.g();
    this.h = paramRoom.h();
    ArrayList localArrayList = paramRoom.i();
    int m = localArrayList.size();
    this.i = new ArrayList(m);
    int k = 0;
    while (k < m)
    {
      this.i.add((ParticipantEntity)((Participant)localArrayList.get(k)).a());
      k += 1;
    }
    this.j = paramRoom.j();
  }
  
  static int a(Room paramRoom)
  {
    return al.a(new Object[] { paramRoom.b(), paramRoom.c(), Long.valueOf(paramRoom.d()), Integer.valueOf(paramRoom.e()), paramRoom.f(), Integer.valueOf(paramRoom.g()), paramRoom.h(), paramRoom.i(), Integer.valueOf(paramRoom.j()) });
  }
  
  static boolean a(Room paramRoom, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Room)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramRoom == paramObject);
      paramObject = (Room)paramObject;
      if ((!al.a(((Room)paramObject).b(), paramRoom.b())) || (!al.a(((Room)paramObject).c(), paramRoom.c())) || (!al.a(Long.valueOf(((Room)paramObject).d()), Long.valueOf(paramRoom.d()))) || (!al.a(Integer.valueOf(((Room)paramObject).e()), Integer.valueOf(paramRoom.e()))) || (!al.a(((Room)paramObject).f(), paramRoom.f())) || (!al.a(Integer.valueOf(((Room)paramObject).g()), Integer.valueOf(paramRoom.g()))) || (!al.a(((Room)paramObject).h(), paramRoom.h())) || (!al.a(((Room)paramObject).i(), paramRoom.i()))) {
        break;
      }
      bool1 = bool2;
    } while (al.a(Integer.valueOf(((Room)paramObject).j()), Integer.valueOf(paramRoom.j())));
    return false;
  }
  
  static String b(Room paramRoom)
  {
    return al.a(paramRoom).a("RoomId", paramRoom.b()).a("CreatorId", paramRoom.c()).a("CreationTimestamp", Long.valueOf(paramRoom.d())).a("RoomStatus", Integer.valueOf(paramRoom.e())).a("Description", paramRoom.f()).a("Variant", Integer.valueOf(paramRoom.g())).a("AutoMatchCriteria", paramRoom.h()).a("Participants", paramRoom.i()).a("AutoMatchWaitEstimateSeconds", Integer.valueOf(paramRoom.j())).toString();
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public long d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public String f()
  {
    return this.f;
  }
  
  public int g()
  {
    return this.g;
  }
  
  public Bundle h()
  {
    return this.h;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public ArrayList i()
  {
    return new ArrayList(this.i);
  }
  
  public int j()
  {
    return this.j;
  }
  
  public int k()
  {
    return this.a;
  }
  
  public Room l()
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
      d.a(this, paramParcel, paramInt);
    }
    for (;;)
    {
      return;
      paramParcel.writeString(this.b);
      paramParcel.writeString(this.c);
      paramParcel.writeLong(this.d);
      paramParcel.writeInt(this.e);
      paramParcel.writeString(this.f);
      paramParcel.writeInt(this.g);
      paramParcel.writeBundle(this.h);
      int m = this.i.size();
      paramParcel.writeInt(m);
      int k = 0;
      while (k < m)
      {
        ((ParticipantEntity)this.i.get(k)).writeToParcel(paramParcel, paramInt);
        k += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/RoomEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */