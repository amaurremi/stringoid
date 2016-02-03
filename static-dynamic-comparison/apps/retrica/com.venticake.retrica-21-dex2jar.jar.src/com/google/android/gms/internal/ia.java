package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ia
  implements Parcelable.Creator<ib.b>
{
  static void a(ib.b paramb, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramb.versionCode);
    b.a(paramParcel, 2, paramb.eM, false);
    b.a(paramParcel, 3, paramb.Hp, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public ib.b I(Parcel paramParcel)
  {
    hy.a locala = null;
    int j = a.B(paramParcel);
    int i = 0;
    String str = null;
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
        str = a.o(paramParcel, k);
        break;
      case 3: 
        locala = (hy.a)a.a(paramParcel, k, hy.a.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ib.b(i, str, locala);
  }
  
  public ib.b[] ax(int paramInt)
  {
    return new ib.b[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */