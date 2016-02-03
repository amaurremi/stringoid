package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class am
  implements Parcelable.Creator<al>
{
  static void a(al paramal, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramal.versionCode);
    b.a(paramParcel, 2, paramal.me, false);
    b.c(paramParcel, 3, paramal.height);
    b.c(paramParcel, 4, paramal.heightPixels);
    b.a(paramParcel, 5, paramal.mf);
    b.c(paramParcel, 6, paramal.width);
    b.c(paramParcel, 7, paramal.widthPixels);
    b.a(paramParcel, 8, paramal.mg, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public al c(Parcel paramParcel)
  {
    al[] arrayOfal = null;
    int i = 0;
    int i1 = a.B(paramParcel);
    int j = 0;
    boolean bool = false;
    int k = 0;
    int m = 0;
    String str = null;
    int n = 0;
    while (paramParcel.dataPosition() < i1)
    {
      int i2 = a.A(paramParcel);
      switch (a.ar(i2))
      {
      default: 
        a.b(paramParcel, i2);
        break;
      case 1: 
        n = a.g(paramParcel, i2);
        break;
      case 2: 
        str = a.o(paramParcel, i2);
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
        arrayOfal = (al[])a.b(paramParcel, i2, al.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i1) {
      throw new a.a("Overread allowed size end=" + i1, paramParcel);
    }
    return new al(n, str, m, k, bool, j, i, arrayOfal);
  }
  
  public al[] d(int paramInt)
  {
    return new al[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */