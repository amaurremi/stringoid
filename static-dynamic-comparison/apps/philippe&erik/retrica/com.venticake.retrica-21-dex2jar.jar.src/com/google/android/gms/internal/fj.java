package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class fj
  implements Parcelable.Creator<fi>
{
  static void a(fi paramfi, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.a(paramParcel, 1, paramfi.xQ, false);
    b.c(paramParcel, 1000, paramfi.xM);
    b.a(paramParcel, 2, paramfi.xR, false);
    b.a(paramParcel, 3, paramfi.xS, false);
    b.G(paramParcel, paramInt);
  }
  
  public fi[] E(int paramInt)
  {
    return new fi[paramInt];
  }
  
  public fi m(Parcel paramParcel)
  {
    String str3 = null;
    int j = a.B(paramParcel);
    int i = 0;
    String str2 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        str1 = a.o(paramParcel, k);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str2 = a.o(paramParcel, k);
        break;
      case 3: 
        str3 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new fi(i, str1, str2, str3);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/fj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */