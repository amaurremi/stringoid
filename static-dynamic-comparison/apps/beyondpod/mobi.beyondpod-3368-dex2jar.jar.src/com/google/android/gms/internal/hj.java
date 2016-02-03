package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hj
  implements Parcelable.Creator<hi>
{
  static void a(hi paramhi, Parcel paramParcel, int paramInt)
  {
    paramInt = b.o(paramParcel);
    b.a(paramParcel, 1, paramhi.Bn, false);
    b.c(paramParcel, 1000, paramhi.versionCode);
    b.a(paramParcel, 2, paramhi.Bo, false);
    b.D(paramParcel, paramInt);
  }
  
  public hi aq(Parcel paramParcel)
  {
    String str2 = null;
    int j = a.n(paramParcel);
    int i = 0;
    String str1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.m(paramParcel);
      switch (a.M(k))
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
    return new hi(i, str1, str2);
  }
  
  public hi[] bg(int paramInt)
  {
    return new hi[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/hj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */