package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hs
  implements Parcelable.Creator<hr>
{
  static void a(hr paramhr, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramhr.xM);
    b.a(paramParcel, 2, paramhr.GT, false);
    b.c(paramParcel, 3, paramhr.GU);
    b.G(paramParcel, paramInt);
  }
  
  public hr D(Parcel paramParcel)
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
        i = a.g(paramParcel, m);
        break;
      case 2: 
        str = a.o(paramParcel, m);
        break;
      case 3: 
        j = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new hr(i, str, j);
  }
  
  public hr[] as(int paramInt)
  {
    return new hr[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/hs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */