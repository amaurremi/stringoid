package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class eo
  implements Parcelable.Creator<en>
{
  static void a(en paramen, Parcel paramParcel, int paramInt)
  {
    int i = b.o(paramParcel);
    b.c(paramParcel, 1, paramen.getVersionCode());
    b.a(paramParcel, 2, paramen.ce(), paramInt, false);
    b.D(paramParcel, i);
  }
  
  public en[] O(int paramInt)
  {
    return new en[paramInt];
  }
  
  public en q(Parcel paramParcel)
  {
    int j = a.n(paramParcel);
    int i = 0;
    ep localep = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.m(paramParcel);
      switch (a.M(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        localep = (ep)a.a(paramParcel, k, ep.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new en(i, localep);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/eo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */