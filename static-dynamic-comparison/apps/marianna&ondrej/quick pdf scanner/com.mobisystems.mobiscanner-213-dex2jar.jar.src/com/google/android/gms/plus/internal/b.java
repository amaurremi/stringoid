package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;

public class b
  implements Parcelable.Creator<PlusCommonExtras>
{
  static void a(PlusCommonExtras paramPlusCommonExtras, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.b.k(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 1, paramPlusCommonExtras.vt(), false);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1000, paramPlusCommonExtras.lX());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, paramPlusCommonExtras.vu(), false);
    com.google.android.gms.common.internal.safeparcel.b.D(paramParcel, paramInt);
  }
  
  public PlusCommonExtras bv(Parcel paramParcel)
  {
    String str2 = null;
    int j = a.j(paramParcel);
    int i = 0;
    String str1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.i(paramParcel);
      switch (a.br(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        str1 = a.m(paramParcel, k);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str2 = a.m(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new PlusCommonExtras(i, str1, str2);
  }
  
  public PlusCommonExtras[] eh(int paramInt)
  {
    return new PlusCommonExtras[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/plus/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */