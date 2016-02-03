package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

public class y
{
  static void a(VisibleRegion paramVisibleRegion, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1, paramVisibleRegion.lX());
    b.a(paramParcel, 2, paramVisibleRegion.VS, paramInt, false);
    b.a(paramParcel, 3, paramVisibleRegion.VT, paramInt, false);
    b.a(paramParcel, 4, paramVisibleRegion.VU, paramInt, false);
    b.a(paramParcel, 5, paramVisibleRegion.VV, paramInt, false);
    b.a(paramParcel, 6, paramVisibleRegion.VW, paramInt, false);
    b.D(paramParcel, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/model/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */