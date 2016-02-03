package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator
{
  static void a(CircleOptions paramCircleOptions, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1, paramCircleOptions.a());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, paramCircleOptions.b(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 3, paramCircleOptions.c());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 4, paramCircleOptions.d());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 5, paramCircleOptions.e());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 6, paramCircleOptions.f());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 7, paramCircleOptions.g());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 8, paramCircleOptions.h());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, i);
  }
  
  public CircleOptions a(Parcel paramParcel)
  {
    float f1 = 0.0F;
    boolean bool = false;
    int m = a.b(paramParcel);
    LatLng localLatLng = null;
    double d = 0.0D;
    int i = 0;
    int j = 0;
    float f2 = 0.0F;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.a(paramParcel);
      switch (a.a(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.f(paramParcel, n);
        break;
      case 2: 
        localLatLng = (LatLng)a.a(paramParcel, n, LatLng.CREATOR);
        break;
      case 3: 
        d = a.j(paramParcel, n);
        break;
      case 4: 
        f2 = a.i(paramParcel, n);
        break;
      case 5: 
        j = a.f(paramParcel, n);
        break;
      case 6: 
        i = a.f(paramParcel, n);
        break;
      case 7: 
        f1 = a.i(paramParcel, n);
        break;
      case 8: 
        bool = a.c(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new b("Overread allowed size end=" + m, paramParcel);
    }
    return new CircleOptions(k, localLatLng, d, f2, j, i, f1, bool);
  }
  
  public CircleOptions[] a(int paramInt)
  {
    return new CircleOptions[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/maps/model/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */