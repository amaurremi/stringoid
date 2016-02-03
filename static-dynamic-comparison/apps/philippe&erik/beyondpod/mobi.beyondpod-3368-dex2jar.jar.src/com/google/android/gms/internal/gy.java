package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class gy
  implements Parcelable.Creator<gx>
{
  static void a(gx paramgx, Parcel paramParcel, int paramInt)
  {
    paramInt = b.o(paramParcel);
    b.a(paramParcel, 1, paramgx.AI, false);
    b.c(paramParcel, 1000, paramgx.kg);
    b.D(paramParcel, paramInt);
  }
  
  public gx al(Parcel paramParcel)
  {
    int j = a.n(paramParcel);
    int i = 0;
    String str = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.m(paramParcel);
      switch (a.M(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        str = a.m(paramParcel, k);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new gx(i, str);
  }
  
  public gx[] ba(int paramInt)
  {
    return new gx[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/gy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */