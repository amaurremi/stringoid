package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

public class a
  implements Parcelable.Creator<InvitationEntity>
{
  static void a(InvitationEntity paramInvitationEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.o(paramParcel);
    b.a(paramParcel, 1, paramInvitationEntity.getGame(), paramInt, false);
    b.c(paramParcel, 1000, paramInvitationEntity.getVersionCode());
    b.a(paramParcel, 2, paramInvitationEntity.getInvitationId(), false);
    b.a(paramParcel, 3, paramInvitationEntity.getCreationTimestamp());
    b.c(paramParcel, 4, paramInvitationEntity.getInvitationType());
    b.a(paramParcel, 5, paramInvitationEntity.getInviter(), paramInt, false);
    b.b(paramParcel, 6, paramInvitationEntity.getParticipants(), false);
    b.c(paramParcel, 7, paramInvitationEntity.getVariant());
    b.c(paramParcel, 8, paramInvitationEntity.getAvailableAutoMatchSlots());
    b.D(paramParcel, i);
  }
  
  public InvitationEntity[] aI(int paramInt)
  {
    return new InvitationEntity[paramInt];
  }
  
  public InvitationEntity aa(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int i = 0;
    int n = com.google.android.gms.common.internal.safeparcel.a.n(paramParcel);
    long l = 0L;
    int j = 0;
    ParticipantEntity localParticipantEntity = null;
    int k = 0;
    String str = null;
    GameEntity localGameEntity = null;
    int m = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = com.google.android.gms.common.internal.safeparcel.a.m(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.M(i1))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, i1);
        break;
      case 1: 
        localGameEntity = (GameEntity)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, i1, GameEntity.CREATOR);
        break;
      case 1000: 
        m = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, i1);
        break;
      case 2: 
        str = com.google.android.gms.common.internal.safeparcel.a.m(paramParcel, i1);
        break;
      case 3: 
        l = com.google.android.gms.common.internal.safeparcel.a.h(paramParcel, i1);
        break;
      case 4: 
        k = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, i1);
        break;
      case 5: 
        localParticipantEntity = (ParticipantEntity)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, i1, ParticipantEntity.CREATOR);
        break;
      case 6: 
        localArrayList = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, i1, ParticipantEntity.CREATOR);
        break;
      case 7: 
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, i1);
        break;
      case 8: 
        i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new a.a("Overread allowed size end=" + n, paramParcel);
    }
    return new InvitationEntity(m, localGameEntity, str, l, k, localParticipantEntity, localArrayList, j, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/games/multiplayer/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */