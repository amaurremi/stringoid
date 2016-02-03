package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class RoomEntityCreator
  implements Parcelable.Creator<RoomEntity>
{
  static void a(RoomEntity paramRoomEntity, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.a(paramParcel, 1, paramRoomEntity.getRoomId(), false);
    b.c(paramParcel, 1000, paramRoomEntity.getVersionCode());
    b.a(paramParcel, 2, paramRoomEntity.getCreatorId(), false);
    b.a(paramParcel, 3, paramRoomEntity.getCreationTimestamp());
    b.c(paramParcel, 4, paramRoomEntity.getStatus());
    b.a(paramParcel, 5, paramRoomEntity.getDescription(), false);
    b.c(paramParcel, 6, paramRoomEntity.getVariant());
    b.a(paramParcel, 7, paramRoomEntity.getAutoMatchCriteria(), false);
    b.b(paramParcel, 8, paramRoomEntity.getParticipants(), false);
    b.c(paramParcel, 9, paramRoomEntity.getAutoMatchWaitEstimateSeconds());
    b.G(paramParcel, paramInt);
  }
  
  public RoomEntity bo(Parcel paramParcel)
  {
    int i = 0;
    ArrayList localArrayList = null;
    int n = a.B(paramParcel);
    long l = 0L;
    Bundle localBundle = null;
    int j = 0;
    String str1 = null;
    int k = 0;
    String str2 = null;
    String str3 = null;
    int m = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = a.A(paramParcel);
      switch (a.ar(i1))
      {
      default: 
        a.b(paramParcel, i1);
        break;
      case 1: 
        str3 = a.o(paramParcel, i1);
        break;
      case 1000: 
        m = a.g(paramParcel, i1);
        break;
      case 2: 
        str2 = a.o(paramParcel, i1);
        break;
      case 3: 
        l = a.i(paramParcel, i1);
        break;
      case 4: 
        k = a.g(paramParcel, i1);
        break;
      case 5: 
        str1 = a.o(paramParcel, i1);
        break;
      case 6: 
        j = a.g(paramParcel, i1);
        break;
      case 7: 
        localBundle = a.q(paramParcel, i1);
        break;
      case 8: 
        localArrayList = a.c(paramParcel, i1, ParticipantEntity.CREATOR);
        break;
      case 9: 
        i = a.g(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new a.a("Overread allowed size end=" + n, paramParcel);
    }
    return new RoomEntity(m, str3, str2, l, k, str1, j, localBundle, localArrayList, i);
  }
  
  public RoomEntity[] cA(int paramInt)
  {
    return new RoomEntity[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/RoomEntityCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */