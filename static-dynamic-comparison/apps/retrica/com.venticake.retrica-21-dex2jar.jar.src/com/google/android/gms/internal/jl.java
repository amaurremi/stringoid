package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class jl
  implements Parcelable.Creator<jk>
{
  static void a(jk paramjk, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramjk.jc());
    b.c(paramParcel, 1000, paramjk.getVersionCode());
    b.c(paramParcel, 2, paramjk.je());
    b.a(paramParcel, 3, paramjk.jf(), paramInt, false);
    b.G(paramParcel, i);
  }
  
  public jk bu(Parcel paramParcel)
  {
    int j = 0;
    int m = a.B(paramParcel);
    int k = -1;
    jm localjm = null;
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
        localjm = (jm)a.a(paramParcel, n, jm.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new jk(i, j, k, localjm);
  }
  
  public jk[] cP(int paramInt)
  {
    return new jk[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/jl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */