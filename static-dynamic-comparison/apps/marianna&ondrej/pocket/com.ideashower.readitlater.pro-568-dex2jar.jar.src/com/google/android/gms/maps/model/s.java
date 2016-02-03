package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.c;

public class s
{
  static void a(MarkerOptions paramMarkerOptions, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramMarkerOptions.a());
    c.a(paramParcel, 2, paramMarkerOptions.c(), paramInt, false);
    c.a(paramParcel, 3, paramMarkerOptions.d(), false);
    c.a(paramParcel, 4, paramMarkerOptions.e(), false);
    c.a(paramParcel, 5, paramMarkerOptions.b(), false);
    c.a(paramParcel, 6, paramMarkerOptions.f());
    c.a(paramParcel, 7, paramMarkerOptions.g());
    c.a(paramParcel, 8, paramMarkerOptions.h());
    c.a(paramParcel, 9, paramMarkerOptions.i());
    c.a(paramParcel, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/maps/model/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */