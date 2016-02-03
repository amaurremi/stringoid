package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class StreetViewPanoramaOptionsCreator
  implements Parcelable.Creator<StreetViewPanoramaOptions>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  static void a(StreetViewPanoramaOptions paramStreetViewPanoramaOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramStreetViewPanoramaOptions.getVersionCode());
    b.a(paramParcel, 2, paramStreetViewPanoramaOptions.getStreetViewPanoramaCamera(), paramInt, false);
    b.a(paramParcel, 3, paramStreetViewPanoramaOptions.getPanoramaId(), false);
    b.a(paramParcel, 4, paramStreetViewPanoramaOptions.getPosition(), paramInt, false);
    b.a(paramParcel, 5, paramStreetViewPanoramaOptions.getRadius(), false);
    b.a(paramParcel, 6, paramStreetViewPanoramaOptions.jD());
    b.a(paramParcel, 7, paramStreetViewPanoramaOptions.jv());
    b.a(paramParcel, 8, paramStreetViewPanoramaOptions.jE());
    b.a(paramParcel, 9, paramStreetViewPanoramaOptions.jF());
    b.a(paramParcel, 10, paramStreetViewPanoramaOptions.jr());
    b.G(paramParcel, i);
  }
  
  public StreetViewPanoramaOptions createFromParcel(Parcel paramParcel)
  {
    Integer localInteger = null;
    byte b1 = 0;
    int j = a.B(paramParcel);
    byte b2 = 0;
    byte b3 = 0;
    byte b4 = 0;
    byte b5 = 0;
    LatLng localLatLng = null;
    String str = null;
    StreetViewPanoramaCamera localStreetViewPanoramaCamera = null;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        localStreetViewPanoramaCamera = (StreetViewPanoramaCamera)a.a(paramParcel, k, StreetViewPanoramaCamera.CREATOR);
        break;
      case 3: 
        str = a.o(paramParcel, k);
        break;
      case 4: 
        localLatLng = (LatLng)a.a(paramParcel, k, LatLng.CREATOR);
        break;
      case 5: 
        localInteger = a.h(paramParcel, k);
        break;
      case 6: 
        b5 = a.e(paramParcel, k);
        break;
      case 7: 
        b4 = a.e(paramParcel, k);
        break;
      case 8: 
        b3 = a.e(paramParcel, k);
        break;
      case 9: 
        b2 = a.e(paramParcel, k);
        break;
      case 10: 
        b1 = a.e(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new StreetViewPanoramaOptions(i, localStreetViewPanoramaCamera, str, localLatLng, localInteger, b5, b4, b3, b2, b1);
  }
  
  public StreetViewPanoramaOptions[] newArray(int paramInt)
  {
    return new StreetViewPanoramaOptions[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/StreetViewPanoramaOptionsCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */