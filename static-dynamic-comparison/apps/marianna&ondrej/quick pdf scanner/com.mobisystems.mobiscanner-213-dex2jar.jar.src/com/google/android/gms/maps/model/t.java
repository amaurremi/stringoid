package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

public class t
{
  static void a(MarkerOptions paramMarkerOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1, paramMarkerOptions.lX());
    b.a(paramParcel, 2, paramMarkerOptions.va(), paramInt, false);
    b.a(paramParcel, 3, paramMarkerOptions.getTitle(), false);
    b.a(paramParcel, 4, paramMarkerOptions.vb(), false);
    b.a(paramParcel, 5, paramMarkerOptions.uZ(), false);
    b.a(paramParcel, 6, paramMarkerOptions.uX());
    b.a(paramParcel, 7, paramMarkerOptions.uY());
    b.a(paramParcel, 8, paramMarkerOptions.vc());
    b.a(paramParcel, 9, paramMarkerOptions.isVisible());
    b.D(paramParcel, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/model/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */