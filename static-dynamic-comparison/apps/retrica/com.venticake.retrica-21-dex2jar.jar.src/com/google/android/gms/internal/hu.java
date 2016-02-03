package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hu
  implements Parcelable.Creator<ht>
{
  static void a(ht paramht, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramht.getVersionCode());
    b.a(paramParcel, 2, paramht.fB(), paramInt, false);
    b.G(paramParcel, i);
  }
  
  public ht E(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int i = 0;
    hv localhv = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        localhv = (hv)a.a(paramParcel, k, hv.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ht(i, localhv);
  }
  
  public ht[] at(int paramInt)
  {
    return new ht[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/hu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */