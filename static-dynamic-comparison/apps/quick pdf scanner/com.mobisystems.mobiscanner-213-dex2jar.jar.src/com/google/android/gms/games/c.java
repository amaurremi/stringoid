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
    int i = b.k(paramParcel);
    b.a(paramParcel, 1, paramPlayerEntity.nS(), false);
    b.c(paramParcel, 1000, paramPlayerEntity.lX());
    b.a(paramParcel, 2, paramPlayerEntity.getDisplayName(), false);
    b.a(paramParcel, 3, paramPlayerEntity.nC(), paramInt, false);
    b.a(paramParcel, 4, paramPlayerEntity.nE(), paramInt, false);
    b.a(paramParcel, 5, paramPlayerEntity.nT());
    b.c(paramParcel, 6, paramPlayerEntity.nV());
    b.a(paramParcel, 7, paramPlayerEntity.nU());
    b.a(paramParcel, 8, paramPlayerEntity.nD(), false);
    b.a(paramParcel, 9, paramPlayerEntity.nF(), false);
    b.D(paramParcel, i);
  }
  
  public PlayerEntity X(Parcel paramParcel)
  {
    int k = a.j(paramParcel);
    int j = 0;
    String str4 = null;
    String str3 = null;
    Uri localUri2 = null;
    Uri localUri1 = null;
    long l2 = 0L;
    int i = 0;
    long l1 = 0L;
    String str2 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.i(paramParcel);
      switch (a.br(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        str4 = a.m(paramParcel, m);
        break;
      case 1000: 
        j = a.g(paramParcel, m);
        break;
      case 2: 
        str3 = a.m(paramParcel, m);
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
        break;
      case 8: 
        str2 = a.m(paramParcel, m);
        break;
      case 9: 
        str1 = a.m(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new PlayerEntity(j, str4, str3, localUri2, localUri1, l2, i, l1, str2, str1);
  }
  
  public PlayerEntity[] cg(int paramInt)
  {
    return new PlayerEntity[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */