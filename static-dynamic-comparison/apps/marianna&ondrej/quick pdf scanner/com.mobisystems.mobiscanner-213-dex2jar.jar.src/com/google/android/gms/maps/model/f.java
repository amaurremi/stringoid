package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class f
  implements Parcelable.Creator<LatLngBounds>
{
  static void a(LatLngBounds paramLatLngBounds, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1, paramLatLngBounds.lX());
    b.a(paramParcel, 2, paramLatLngBounds.Vs, paramInt, false);
    b.a(paramParcel, 3, paramLatLngBounds.Vt, paramInt, false);
    b.D(paramParcel, i);
  }
  
  public LatLngBounds bn(Parcel paramParcel)
  {
    LatLng localLatLng1 = null;
    int j = a.j(paramParcel);
    int i = 0;
    LatLng localLatLng2 = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = a.i(paramParcel);
      switch (a.br(k))
      {
      default: 
        a.b(paramParcel, k);
      }
      for (;;)
      {
        break;
        i = a.g(paramParcel, k);
        continue;
        localLatLng2 = (LatLng)a.a(paramParcel, k, LatLng.Vo);
        continue;
        localLatLng1 = (LatLng)a.a(paramParcel, k, LatLng.Vo);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new LatLngBounds(i, localLatLng2, localLatLng1);
  }
  
  public LatLngBounds[] dV(int paramInt)
  {
    return new LatLngBounds[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/model/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */