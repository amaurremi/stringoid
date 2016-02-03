package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

public class r
{
  static void a(LatLngBounds paramLatLngBounds, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1, paramLatLngBounds.lX());
    b.a(paramParcel, 2, paramLatLngBounds.Vs, paramInt, false);
    b.a(paramParcel, 3, paramLatLngBounds.Vt, paramInt, false);
    b.D(paramParcel, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/model/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */