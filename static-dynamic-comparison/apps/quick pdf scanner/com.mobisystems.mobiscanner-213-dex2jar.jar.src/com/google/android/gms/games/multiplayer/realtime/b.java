package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class b
  implements Parcelable.Creator<RoomEntity>
{
  static void a(RoomEntity paramRoomEntity, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.b.k(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 1, paramRoomEntity.oo(), false);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1000, paramRoomEntity.lX());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, paramRoomEntity.op(), false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 3, paramRoomEntity.oa());
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 4, paramRoomEntity.getStatus());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 5, paramRoomEntity.getDescription(), false);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 6, paramRoomEntity.oc());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 7, paramRoomEntity.oq(), false);
    com.google.android.gms.common.internal.safeparcel.b.b(paramParcel, 8, paramRoomEntity.oe(), false);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 9, paramRoomEntity.or());
    com.google.android.gms.common.internal.safeparcel.b.D(paramParcel, paramInt);
  }
  
  public RoomEntity ac(Parcel paramParcel)
  {
    int i = 0;
    ArrayList localArrayList = null;
    int n = a.j(paramParcel);
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
      int i1 = a.i(paramParcel);
      switch (a.br(i1))
      {
      default: 
        a.b(paramParcel, i1);
        break;
      case 1: 
        str3 = a.m(paramParcel, i1);
        break;
      case 1000: 
        m = a.g(paramParcel, i1);
        break;
      case 2: 
        str2 = a.m(paramParcel, i1);
        break;
      case 3: 
        l = a.h(paramParcel, i1);
        break;
      case 4: 
        k = a.g(paramParcel, i1);
        break;
      case 5: 
        str1 = a.m(paramParcel, i1);
        break;
      case 6: 
        j = a.g(paramParcel, i1);
        break;
      case 7: 
        localBundle = a.o(paramParcel, i1);
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
  
  public RoomEntity[] cl(int paramInt)
  {
    return new RoomEntity[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */