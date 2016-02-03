package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class StreetViewPanoramaOrientationCreator
  implements Parcelable.Creator<StreetViewPanoramaOrientation>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  static void a(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation, Parcel paramParcel, int paramInt)
  {
    paramInt = b.p(paramParcel);
    b.c(paramParcel, 1, paramStreetViewPanoramaOrientation.getVersionCode());
    b.a(paramParcel, 2, paramStreetViewPanoramaOrientation.tilt);
    b.a(paramParcel, 3, paramStreetViewPanoramaOrientation.bearing);
    b.F(paramParcel, paramInt);
  }
  
  public StreetViewPanoramaOrientation createFromParcel(Parcel paramParcel)
  {
    float f2 = 0.0F;
    int j = a.o(paramParcel);
    int i = 0;
    float f1 = 0.0F;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.n(paramParcel);
      switch (a.R(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        f1 = a.k(paramParcel, k);
        break;
      case 3: 
        f2 = a.k(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new StreetViewPanoramaOrientation(i, f1, f2);
  }
  
  public StreetViewPanoramaOrientation[] newArray(int paramInt)
  {
    return new StreetViewPanoramaOrientation[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/maps/model/StreetViewPanoramaOrientationCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */