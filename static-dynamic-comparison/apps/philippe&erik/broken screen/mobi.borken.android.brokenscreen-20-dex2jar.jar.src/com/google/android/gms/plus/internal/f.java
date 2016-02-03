package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class f
  implements Parcelable.Creator<PlusCommonExtras>
{
  static void a(PlusCommonExtras paramPlusCommonExtras, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.a(paramParcel, 1, paramPlusCommonExtras.jS(), false);
    b.c(paramParcel, 1000, paramPlusCommonExtras.getVersionCode());
    b.a(paramParcel, 2, paramPlusCommonExtras.jT(), false);
    b.G(paramParcel, paramInt);
  }
  
  public PlusCommonExtras bC(Parcel paramParcel)
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
        str1 = a.o(paramParcel, k);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str2 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new PlusCommonExtras(i, str1, str2);
  }
  
  public PlusCommonExtras[] cZ(int paramInt)
  {
    return new PlusCommonExtras[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/plus/internal/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */