package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class y
  implements Parcelable.Creator<x>
{
  static void a(x paramx, Parcel paramParcel, int paramInt)
  {
    int i = b.o(paramParcel);
    b.c(paramParcel, 1, paramx.versionCode);
    b.a(paramParcel, 2, paramx.eF, false);
    b.c(paramParcel, 3, paramx.height);
    b.c(paramParcel, 4, paramx.heightPixels);
    b.a(paramParcel, 5, paramx.eG);
    b.c(paramParcel, 6, paramx.width);
    b.c(paramParcel, 7, paramx.widthPixels);
    b.a(paramParcel, 8, paramx.eH, paramInt, false);
    b.D(paramParcel, i);
  }
  
  public x b(Parcel paramParcel)
  {
    x[] arrayOfx = null;
    int i = 0;
    int i1 = a.n(paramParcel);
    int j = 0;
    boolean bool = false;
    int k = 0;
    int m = 0;
    String str = null;
    int n = 0;
    while (paramParcel.dataPosition() < i1)
    {
      int i2 = a.m(paramParcel);
      switch (a.M(i2))
      {
      default: 
        a.b(paramParcel, i2);
        break;
      case 1: 
        n = a.g(paramParcel, i2);
        break;
      case 2: 
        str = a.m(paramParcel, i2);
        break;
      case 3: 
        m = a.g(paramParcel, i2);
        break;
      case 4: 
        k = a.g(paramParcel, i2);
        break;
      case 5: 
        bool = a.c(paramParcel, i2);
        break;
      case 6: 
        j = a.g(paramParcel, i2);
        break;
      case 7: 
        i = a.g(paramParcel, i2);
        break;
      case 8: 
        arrayOfx = (x[])a.b(paramParcel, i2, x.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i1) {
      throw new a.a("Overread allowed size end=" + i1, paramParcel);
    }
    return new x(n, str, m, k, bool, j, i, arrayOfx);
  }
  
  public x[] c(int paramInt)
  {
    return new x[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */