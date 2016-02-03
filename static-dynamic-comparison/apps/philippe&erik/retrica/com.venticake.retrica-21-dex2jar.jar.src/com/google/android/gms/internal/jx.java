package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class jx
  implements Parcelable.Creator<jw>
{
  static void a(jw paramjw, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.a(paramParcel, 1, paramjw.qX, false);
    b.c(paramParcel, 1000, paramjw.xM);
    b.c(paramParcel, 2, paramjw.YS);
    b.G(paramParcel, paramInt);
  }
  
  public jw bA(Parcel paramParcel)
  {
    int j = 0;
    int k = a.B(paramParcel);
    String str = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.A(paramParcel);
      switch (a.ar(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        str = a.o(paramParcel, m);
        break;
      case 1000: 
        i = a.g(paramParcel, m);
        break;
      case 2: 
        j = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new jw(i, str, j);
  }
  
  public jw[] cV(int paramInt)
  {
    return new jw[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/jx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */