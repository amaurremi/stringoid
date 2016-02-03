package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.c;

public class u
{
  static void a(PolylineOptions paramPolylineOptions, Parcel paramParcel, int paramInt)
  {
    paramInt = c.a(paramParcel);
    c.a(paramParcel, 1, paramPolylineOptions.a());
    c.b(paramParcel, 2, paramPolylineOptions.b(), false);
    c.a(paramParcel, 3, paramPolylineOptions.c());
    c.a(paramParcel, 4, paramPolylineOptions.d());
    c.a(paramParcel, 5, paramPolylineOptions.e());
    c.a(paramParcel, 6, paramPolylineOptions.f());
    c.a(paramParcel, 7, paramPolylineOptions.g());
    c.a(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/maps/model/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */