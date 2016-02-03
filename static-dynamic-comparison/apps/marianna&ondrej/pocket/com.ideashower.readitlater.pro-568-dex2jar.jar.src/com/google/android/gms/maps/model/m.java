package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class m
  implements Parcelable.Creator
{
  static void a(VisibleRegion paramVisibleRegion, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramVisibleRegion.a());
    c.a(paramParcel, 2, paramVisibleRegion.a, paramInt, false);
    c.a(paramParcel, 3, paramVisibleRegion.b, paramInt, false);
    c.a(paramParcel, 4, paramVisibleRegion.c, paramInt, false);
    c.a(paramParcel, 5, paramVisibleRegion.d, paramInt, false);
    c.a(paramParcel, 6, paramVisibleRegion.e, paramInt, false);
    c.a(paramParcel, i);
  }
  
  public VisibleRegion a(Parcel paramParcel)
  {
    LatLngBounds localLatLngBounds = null;
    int j = a.b(paramParcel);
    int i = 0;
    LatLng localLatLng1 = null;
    LatLng localLatLng2 = null;
    LatLng localLatLng3 = null;
    LatLng localLatLng4 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.a(paramParcel);
      switch (a.a(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.f(paramParcel, k);
        break;
      case 2: 
        localLatLng4 = (LatLng)a.a(paramParcel, k, LatLng.CREATOR);
        break;
      case 3: 
        localLatLng3 = (LatLng)a.a(paramParcel, k, LatLng.CREATOR);
        break;
      case 4: 
        localLatLng2 = (LatLng)a.a(paramParcel, k, LatLng.CREATOR);
        break;
      case 5: 
        localLatLng1 = (LatLng)a.a(paramParcel, k, LatLng.CREATOR);
        break;
      case 6: 
        localLatLngBounds = (LatLngBounds)a.a(paramParcel, k, LatLngBounds.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new b("Overread allowed size end=" + j, paramParcel);
    }
    return new VisibleRegion(i, localLatLng4, localLatLng3, localLatLng2, localLatLng1, localLatLngBounds);
  }
  
  public VisibleRegion[] a(int paramInt)
  {
    return new VisibleRegion[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/maps/model/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */