package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class f
  implements Parcelable.Creator
{
  static void a(PlayerEntity paramPlayerEntity, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramPlayerEntity.b(), false);
    c.a(paramParcel, 1000, paramPlayerEntity.g());
    c.a(paramParcel, 2, paramPlayerEntity.c(), false);
    c.a(paramParcel, 3, paramPlayerEntity.d(), paramInt, false);
    c.a(paramParcel, 4, paramPlayerEntity.e(), paramInt, false);
    c.a(paramParcel, 5, paramPlayerEntity.f());
    c.a(paramParcel, i);
  }
  
  public PlayerEntity a(Parcel paramParcel)
  {
    Uri localUri1 = null;
    int j = a.b(paramParcel);
    int i = 0;
    long l = 0L;
    Uri localUri2 = null;
    String str1 = null;
    String str2 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.a(paramParcel);
      switch (a.a(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        str2 = a.l(paramParcel, k);
        break;
      case 1000: 
        i = a.f(paramParcel, k);
        break;
      case 2: 
        str1 = a.l(paramParcel, k);
        break;
      case 3: 
        localUri2 = (Uri)a.a(paramParcel, k, Uri.CREATOR);
        break;
      case 4: 
        localUri1 = (Uri)a.a(paramParcel, k, Uri.CREATOR);
        break;
      case 5: 
        l = a.g(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new b("Overread allowed size end=" + j, paramParcel);
    }
    return new PlayerEntity(i, str2, str1, localUri2, localUri1, l);
  }
  
  public PlayerEntity[] a(int paramInt)
  {
    return new PlayerEntity[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/games/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */