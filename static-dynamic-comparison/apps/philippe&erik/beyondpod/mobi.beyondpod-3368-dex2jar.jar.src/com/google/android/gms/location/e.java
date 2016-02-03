package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class e
  implements Parcelable.Creator<d>
{
  static void a(d paramd, Parcel paramParcel, int paramInt)
  {
    paramInt = b.o(paramParcel);
    b.c(paramParcel, 1, paramd.xG);
    b.c(paramParcel, 1000, paramd.getVersionCode());
    b.c(paramParcel, 2, paramd.xH);
    b.a(paramParcel, 3, paramd.xI);
    b.D(paramParcel, paramInt);
  }
  
  public d[] aS(int paramInt)
  {
    return new d[paramInt];
  }
  
  public d af(Parcel paramParcel)
  {
    int i = 1;
    int m = a.n(paramParcel);
    int k = 0;
    long l = 0L;
    int j = 1;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.m(paramParcel);
      switch (a.M(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        j = a.g(paramParcel, n);
        break;
      case 1000: 
        k = a.g(paramParcel, n);
        break;
      case 2: 
        i = a.g(paramParcel, n);
        break;
      case 3: 
        l = a.h(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new d(k, j, i, l);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/location/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */