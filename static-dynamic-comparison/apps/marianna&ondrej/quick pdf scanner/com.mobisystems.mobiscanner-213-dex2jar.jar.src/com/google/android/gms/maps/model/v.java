package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

public class v
{
  static void a(PolylineOptions paramPolylineOptions, Parcel paramParcel, int paramInt)
  {
    paramInt = b.k(paramParcel);
    b.c(paramParcel, 1, paramPolylineOptions.lX());
    b.b(paramParcel, 2, paramPolylineOptions.vh(), false);
    b.a(paramParcel, 3, paramPolylineOptions.getWidth());
    b.c(paramParcel, 4, paramPolylineOptions.getColor());
    b.a(paramParcel, 5, paramPolylineOptions.uS());
    b.a(paramParcel, 6, paramPolylineOptions.isVisible());
    b.a(paramParcel, 7, paramPolylineOptions.vi());
    b.D(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/model/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */