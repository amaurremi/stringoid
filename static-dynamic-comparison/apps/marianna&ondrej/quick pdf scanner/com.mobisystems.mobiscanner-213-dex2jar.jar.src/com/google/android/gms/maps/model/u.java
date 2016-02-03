package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

public class u
{
  static void a(PolygonOptions paramPolygonOptions, Parcel paramParcel, int paramInt)
  {
    paramInt = b.k(paramParcel);
    b.c(paramParcel, 1, paramPolygonOptions.lX());
    b.b(paramParcel, 2, paramPolygonOptions.vh(), false);
    b.c(paramParcel, 3, paramPolygonOptions.vg(), false);
    b.a(paramParcel, 4, paramPolygonOptions.getStrokeWidth());
    b.c(paramParcel, 5, paramPolygonOptions.uQ());
    b.c(paramParcel, 6, paramPolygonOptions.uR());
    b.a(paramParcel, 7, paramPolygonOptions.uS());
    b.a(paramParcel, 8, paramPolygonOptions.isVisible());
    b.a(paramParcel, 9, paramPolygonOptions.vi());
    b.D(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/model/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */