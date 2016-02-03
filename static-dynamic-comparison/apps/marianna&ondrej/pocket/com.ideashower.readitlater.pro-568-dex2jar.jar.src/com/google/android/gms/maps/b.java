package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.c;

public class b
{
  static void a(GoogleMapOptions paramGoogleMapOptions, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramGoogleMapOptions.a());
    c.a(paramParcel, 2, paramGoogleMapOptions.b());
    c.a(paramParcel, 3, paramGoogleMapOptions.c());
    c.a(paramParcel, 4, paramGoogleMapOptions.j());
    c.a(paramParcel, 5, paramGoogleMapOptions.k(), paramInt, false);
    c.a(paramParcel, 6, paramGoogleMapOptions.d());
    c.a(paramParcel, 7, paramGoogleMapOptions.e());
    c.a(paramParcel, 8, paramGoogleMapOptions.f());
    c.a(paramParcel, 9, paramGoogleMapOptions.g());
    c.a(paramParcel, 10, paramGoogleMapOptions.h());
    c.a(paramParcel, 11, paramGoogleMapOptions.i());
    c.a(paramParcel, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/maps/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */