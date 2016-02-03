package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

public class h
{
  static void a(PolylineOptions paramPolylineOptions, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramPolylineOptions.getVersionCode());
    b.b(paramParcel, 2, paramPolylineOptions.getPoints(), false);
    b.a(paramParcel, 3, paramPolylineOptions.getWidth());
    b.c(paramParcel, 4, paramPolylineOptions.getColor());
    b.a(paramParcel, 5, paramPolylineOptions.getZIndex());
    b.a(paramParcel, 6, paramPolylineOptions.isVisible());
    b.a(paramParcel, 7, paramPolylineOptions.isGeodesic());
    b.G(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/maps/model/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */