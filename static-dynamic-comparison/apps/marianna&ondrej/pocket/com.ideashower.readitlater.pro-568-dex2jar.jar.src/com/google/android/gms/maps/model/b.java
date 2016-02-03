package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public class b
  implements Parcelable.Creator
{
  static void a(CameraPosition paramCameraPosition, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramCameraPosition.a());
    c.a(paramParcel, 2, paramCameraPosition.a, paramInt, false);
    c.a(paramParcel, 3, paramCameraPosition.b);
    c.a(paramParcel, 4, paramCameraPosition.c);
    c.a(paramParcel, 5, paramCameraPosition.d);
    c.a(paramParcel, i);
  }
  
  public CameraPosition a(Parcel paramParcel)
  {
    float f1 = 0.0F;
    int j = a.b(paramParcel);
    int i = 0;
    LatLng localLatLng = null;
    float f2 = 0.0F;
    float f3 = 0.0F;
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
        localLatLng = (LatLng)a.a(paramParcel, k, LatLng.CREATOR);
        break;
      case 3: 
        f3 = a.i(paramParcel, k);
        break;
      case 4: 
        f2 = a.i(paramParcel, k);
        break;
      case 5: 
        f1 = a.i(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + j, paramParcel);
    }
    return new CameraPosition(i, localLatLng, f3, f2, f1);
  }
  
  public CameraPosition[] a(int paramInt)
  {
    return new CameraPosition[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/maps/model/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */