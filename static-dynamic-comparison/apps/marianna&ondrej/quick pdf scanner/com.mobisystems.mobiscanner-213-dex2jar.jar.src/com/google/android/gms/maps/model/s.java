package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

public class s
{
  static void a(LatLng paramLatLng, Parcel paramParcel, int paramInt)
  {
    paramInt = b.k(paramParcel);
    b.c(paramParcel, 1, paramLatLng.lX());
    b.a(paramParcel, 2, paramLatLng.Vp);
    b.a(paramParcel, 3, paramLatLng.Vq);
    b.D(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/model/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */