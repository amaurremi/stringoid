package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

public class e
  implements Parcelable.Creator<InvitationEntity>
{
  static void a(InvitationEntity paramInvitationEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.a(paramParcel, 1, paramInvitationEntity.nX(), paramInt, false);
    b.c(paramParcel, 1000, paramInvitationEntity.lX());
    b.a(paramParcel, 2, paramInvitationEntity.nY(), false);
    b.a(paramParcel, 3, paramInvitationEntity.oa());
    b.c(paramParcel, 4, paramInvitationEntity.ob());
    b.a(paramParcel, 5, paramInvitationEntity.nZ(), paramInt, false);
    b.b(paramParcel, 6, paramInvitationEntity.oe(), false);
    b.c(paramParcel, 7, paramInvitationEntity.oc());
    b.c(paramParcel, 8, paramInvitationEntity.od());
    b.D(paramParcel, i);
  }
  
  public InvitationEntity Y(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int i = 0;
    int n = a.j(paramParcel);
    long l = 0L;
    int j = 0;
    ParticipantEntity localParticipantEntity = null;
    int k = 0;
    String str = null;
    GameEntity localGameEntity = null;
    int m = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = a.i(paramParcel);
      switch (a.br(i1))
      {
      default: 
        a.b(paramParcel, i1);
        break;
      case 1: 
        localGameEntity = (GameEntity)a.a(paramParcel, i1, GameEntity.CREATOR);
        break;
      case 1000: 
        m = a.g(paramParcel, i1);
        break;
      case 2: 
        str = a.m(paramParcel, i1);
        break;
      case 3: 
        l = a.h(paramParcel, i1);
        break;
      case 4: 
        k = a.g(paramParcel, i1);
        break;
      case 5: 
        localParticipantEntity = (ParticipantEntity)a.a(paramParcel, i1, ParticipantEntity.CREATOR);
        break;
      case 6: 
        localArrayList = a.c(paramParcel, i1, ParticipantEntity.CREATOR);
        break;
      case 7: 
        j = a.g(paramParcel, i1);
        break;
      case 8: 
        i = a.g(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new a.a("Overread allowed size end=" + n, paramParcel);
    }
    return new InvitationEntity(m, localGameEntity, str, l, k, localParticipantEntity, localArrayList, j, i);
  }
  
  public InvitationEntity[] ci(int paramInt)
  {
    return new InvitationEntity[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/multiplayer/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */