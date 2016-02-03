package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class jp
  implements Parcelable.Creator<jo>
{
  static void a(jo paramjo, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramjo.xM);
    b.a(paramParcel, 2, paramjo.jj(), false);
    b.a(paramParcel, 3, paramjo.getTag(), false);
    b.G(paramParcel, paramInt);
  }
  
  public jo bw(Parcel paramParcel)
  {
    String str2 = null;
    int j = a.B(paramParcel);
    int i = 0;
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
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str1 = a.o(paramParcel, k);
        break;
      case 3: 
        str2 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new jo(i, str1, str2);
  }
  
  public jo[] cR(int paramInt)
  {
    return new jo[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/jp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */