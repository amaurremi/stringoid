package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class e
  implements Parcelable.Creator
{
  static void a(LatLngBounds paramLatLngBounds, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramLatLngBounds.a());
    c.a(paramParcel, 2, paramLatLngBounds.a, paramInt, false);
    c.a(paramParcel, 3, paramLatLngBounds.b, paramInt, false);
    c.a(paramParcel, i);
  }
  
  public LatLngBounds a(Parcel paramParcel)
  {
    LatLng localLatLng1 = null;
    int j = a.b(paramParcel);
    int i = 0;
    LatLng localLatLng2 = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = a.a(paramParcel);
      switch (a.a(k))
      {
      default: 
        a.b(paramParcel, k);
      }
      for (;;)
      {
        break;
        i = a.f(paramParcel, k);
        continue;
        localLatLng2 = (LatLng)a.a(paramParcel, k, LatLng.CREATOR);
        continue;
        localLatLng1 = (LatLng)a.a(paramParcel, k, LatLng.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new b("Overread allowed size end=" + j, paramParcel);
    }
    return new LatLngBounds(i, localLatLng2, localLatLng1);
  }
  
  public LatLngBounds[] a(int paramInt)
  {
    return new LatLngBounds[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/maps/model/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */