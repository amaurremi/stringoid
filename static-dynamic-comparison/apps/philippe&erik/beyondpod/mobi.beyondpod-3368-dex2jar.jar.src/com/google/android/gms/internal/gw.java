package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.location.LocationRequest;

public class gw
  implements Parcelable.Creator<gv>
{
  static void a(gv paramgv, Parcel paramParcel, int paramInt)
  {
    int i = b.o(paramParcel);
    b.a(paramParcel, 1, paramgv.dS(), paramInt, false);
    b.c(paramParcel, 1000, paramgv.kg);
    b.a(paramParcel, 2, paramgv.dT(), paramInt, false);
    b.D(paramParcel, i);
  }
  
  public gv[] aZ(int paramInt)
  {
    return new gv[paramInt];
  }
  
  public gv ak(Parcel paramParcel)
  {
    gt localgt = null;
    int j = a.n(paramParcel);
    int i = 0;
    LocationRequest localLocationRequest = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = a.m(paramParcel);
      switch (a.M(k))
      {
      default: 
        a.b(paramParcel, k);
      }
      for (;;)
      {
        break;
        localLocationRequest = (LocationRequest)a.a(paramParcel, k, LocationRequest.CREATOR);
        continue;
        i = a.g(paramParcel, k);
        continue;
        localgt = (gt)a.a(paramParcel, k, gt.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new gv(i, localLocationRequest, localgt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/gw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */