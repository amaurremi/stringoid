package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

public class f
  implements Parcelable.Creator
{
  static void a(InvitationEntity paramInvitationEntity, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramInvitationEntity.b(), paramInt, false);
    c.a(paramParcel, 1000, paramInvitationEntity.h());
    c.a(paramParcel, 2, paramInvitationEntity.c(), false);
    c.a(paramParcel, 3, paramInvitationEntity.e());
    c.a(paramParcel, 4, paramInvitationEntity.f());
    c.a(paramParcel, 5, paramInvitationEntity.d(), paramInt, false);
    c.b(paramParcel, 6, paramInvitationEntity.i(), false);
    c.a(paramParcel, 7, paramInvitationEntity.g());
    c.a(paramParcel, i);
  }
  
  public InvitationEntity a(Parcel paramParcel)
  {
    int i = 0;
    ArrayList localArrayList = null;
    int m = a.b(paramParcel);
    long l = 0L;
    ParticipantEntity localParticipantEntity = null;
    int j = 0;
    String str = null;
    GameEntity localGameEntity = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.a(paramParcel);
      switch (a.a(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        localGameEntity = (GameEntity)a.a(paramParcel, n, GameEntity.CREATOR);
        break;
      case 1000: 
        k = a.f(paramParcel, n);
        break;
      case 2: 
        str = a.l(paramParcel, n);
        break;
      case 3: 
        l = a.g(paramParcel, n);
        break;
      case 4: 
        j = a.f(paramParcel, n);
        break;
      case 5: 
        localParticipantEntity = (ParticipantEntity)a.a(paramParcel, n, ParticipantEntity.CREATOR);
        break;
      case 6: 
        localArrayList = a.c(paramParcel, n, ParticipantEntity.CREATOR);
        break;
      case 7: 
        i = a.f(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new b("Overread allowed size end=" + m, paramParcel);
    }
    return new InvitationEntity(k, localGameEntity, str, l, j, localParticipantEntity, localArrayList, i);
  }
  
  public InvitationEntity[] a(int paramInt)
  {
    return new InvitationEntity[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/games/multiplayer/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */