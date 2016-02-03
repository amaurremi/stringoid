package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator<PlayerEntity>
{
  static void a(PlayerEntity paramPlayerEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.o(paramParcel);
    b.a(paramParcel, 1, paramPlayerEntity.getPlayerId(), false);
    b.c(paramParcel, 1000, paramPlayerEntity.getVersionCode());
    b.a(paramParcel, 2, paramPlayerEntity.getDisplayName(), false);
    b.a(paramParcel, 3, paramPlayerEntity.getIconImageUri(), paramInt, false);
    b.a(paramParcel, 4, paramPlayerEntity.getHiResImageUri(), paramInt, false);
    b.a(paramParcel, 5, paramPlayerEntity.getRetrievedTimestamp());
    b.c(paramParcel, 6, paramPlayerEntity.db());
    b.a(paramParcel, 7, paramPlayerEntity.getLastPlayedWithTimestamp());
    b.D(paramParcel, i);
  }
  
  public PlayerEntity Z(Parcel paramParcel)
  {
    long l1 = 0L;
    int i = 0;
    Uri localUri1 = null;
    int k = a.n(paramParcel);
    long l2 = 0L;
    Uri localUri2 = null;
    String str1 = null;
    String str2 = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.m(paramParcel);
      switch (a.M(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        str2 = a.m(paramParcel, m);
        break;
      case 1000: 
        j = a.g(paramParcel, m);
        break;
      case 2: 
        str1 = a.m(paramParcel, m);
        break;
      case 3: 
        localUri2 = (Uri)a.a(paramParcel, m, Uri.CREATOR);
        break;
      case 4: 
        localUri1 = (Uri)a.a(paramParcel, m, Uri.CREATOR);
        break;
      case 5: 
        l2 = a.h(paramParcel, m);
        break;
      case 6: 
        i = a.g(paramParcel, m);
        break;
      case 7: 
        l1 = a.h(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new PlayerEntity(j, str2, str1, localUri2, localUri1, l2, i, l1);
  }
  
  public PlayerEntity[] aA(int paramInt)
  {
    return new PlayerEntity[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/games/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */