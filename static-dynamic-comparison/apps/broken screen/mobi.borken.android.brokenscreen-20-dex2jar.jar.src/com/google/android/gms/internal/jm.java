package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class jm
  implements Parcelable.Creator<jl>
{
  static void a(jl paramjl, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramjl.iX());
    b.c(paramParcel, 1000, paramjl.getVersionCode());
    b.c(paramParcel, 2, paramjl.iZ());
    b.a(paramParcel, 3, paramjl.ja(), paramInt, false);
    b.G(paramParcel, i);
  }
  
  public jl bu(Parcel paramParcel)
  {
    int j = 0;
    int m = a.B(paramParcel);
    int k = -1;
    jn localjn = null;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.A(paramParcel);
      switch (a.ar(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        j = a.g(paramParcel, n);
        break;
      case 1000: 
        i = a.g(paramParcel, n);
        break;
      case 2: 
        k = a.g(paramParcel, n);
        break;
      case 3: 
        localjn = (jn)a.a(paramParcel, n, jn.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new jl(i, j, k, localjn);
  }
  
  public jl[] cP(int paramInt)
  {
    return new jl[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/jm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */