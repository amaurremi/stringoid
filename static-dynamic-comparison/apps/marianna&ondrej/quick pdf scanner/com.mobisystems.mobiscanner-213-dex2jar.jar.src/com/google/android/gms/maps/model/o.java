package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

public class o
{
  static void a(CameraPosition paramCameraPosition, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1, paramCameraPosition.lX());
    b.a(paramParcel, 2, paramCameraPosition.UP, paramInt, false);
    b.a(paramParcel, 3, paramCameraPosition.UQ);
    b.a(paramParcel, 4, paramCameraPosition.UR);
    b.a(paramParcel, 5, paramCameraPosition.US);
    b.D(paramParcel, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/model/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */