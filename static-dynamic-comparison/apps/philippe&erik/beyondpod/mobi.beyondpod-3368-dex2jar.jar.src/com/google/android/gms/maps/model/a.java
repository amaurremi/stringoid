package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

public class a
{
  static void a(CameraPosition paramCameraPosition, Parcel paramParcel, int paramInt)
  {
    int i = b.o(paramParcel);
    b.c(paramParcel, 1, paramCameraPosition.getVersionCode());
    b.a(paramParcel, 2, paramCameraPosition.target, paramInt, false);
    b.a(paramParcel, 3, paramCameraPosition.zoom);
    b.a(paramParcel, 4, paramCameraPosition.tilt);
    b.a(paramParcel, 5, paramCameraPosition.bearing);
    b.D(paramParcel, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/maps/model/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */