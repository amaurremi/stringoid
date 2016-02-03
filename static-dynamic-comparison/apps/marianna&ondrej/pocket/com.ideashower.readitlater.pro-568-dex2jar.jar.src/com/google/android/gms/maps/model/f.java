package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class f
  implements Parcelable.Creator
{
  static void a(LatLng paramLatLng, Parcel paramParcel, int paramInt)
  {
    paramInt = c.a(paramParcel);
    c.a(paramParcel, 1, paramLatLng.a());
    c.a(paramParcel, 2, paramLatLng.a);
    c.a(paramParcel, 3, paramLatLng.b);
    c.a(paramParcel, paramInt);
  }
  
  public LatLng a(Parcel paramParcel)
  {
    double d1 = 0.0D;
    int j = a.b(paramParcel);
    int i = 0;
    double d2 = 0.0D;
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
        d2 = a.j(paramParcel, k);
        break;
      case 3: 
        d1 = a.j(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new b("Overread allowed size end=" + j, paramParcel);
    }
    return new LatLng(i, d2, d1);
  }
  
  public LatLng[] a(int paramInt)
  {
    return new LatLng[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/maps/model/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */