package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hc
  implements Parcelable.Creator<hb>
{
  static void a(hb paramhb, Parcel paramParcel, int paramInt)
  {
    int i = b.o(paramParcel);
    b.a(paramParcel, 1, paramhb.dU(), paramInt, false);
    b.c(paramParcel, 1000, paramhb.kg);
    b.a(paramParcel, 2, paramhb.dV(), false);
    b.a(paramParcel, 3, paramhb.getTimestampMillis());
    b.D(paramParcel, i);
  }
  
  public hb an(Parcel paramParcel)
  {
    float[] arrayOfFloat = null;
    int j = a.n(paramParcel);
    int i = 0;
    long l = 0L;
    hd[] arrayOfhd = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.m(paramParcel);
      switch (a.M(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        arrayOfhd = (hd[])a.b(paramParcel, k, hd.CREATOR);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        arrayOfFloat = a.u(paramParcel, k);
        break;
      case 3: 
        l = a.h(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new hb(i, arrayOfhd, arrayOfFloat, l);
  }
  
  public hb[] bc(int paramInt)
  {
    return new hb[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/hc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */