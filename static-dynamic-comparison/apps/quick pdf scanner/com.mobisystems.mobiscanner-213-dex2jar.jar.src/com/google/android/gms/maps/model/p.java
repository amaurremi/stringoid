package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

public class p
{
  static void a(CircleOptions paramCircleOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1, paramCircleOptions.lX());
    b.a(paramParcel, 2, paramCircleOptions.uP(), paramInt, false);
    b.a(paramParcel, 3, paramCircleOptions.getRadius());
    b.a(paramParcel, 4, paramCircleOptions.getStrokeWidth());
    b.c(paramParcel, 5, paramCircleOptions.uQ());
    b.c(paramParcel, 6, paramCircleOptions.uR());
    b.a(paramParcel, 7, paramCircleOptions.uS());
    b.a(paramParcel, 8, paramCircleOptions.isVisible());
    b.D(paramParcel, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/model/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */