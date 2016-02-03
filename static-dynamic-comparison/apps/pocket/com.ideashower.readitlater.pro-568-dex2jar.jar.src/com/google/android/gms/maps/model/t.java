package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.c;

public class t
{
  static void a(PolygonOptions paramPolygonOptions, Parcel paramParcel, int paramInt)
  {
    paramInt = c.a(paramParcel);
    c.a(paramParcel, 1, paramPolygonOptions.a());
    c.b(paramParcel, 2, paramPolygonOptions.c(), false);
    c.c(paramParcel, 3, paramPolygonOptions.b(), false);
    c.a(paramParcel, 4, paramPolygonOptions.d());
    c.a(paramParcel, 5, paramPolygonOptions.e());
    c.a(paramParcel, 6, paramPolygonOptions.f());
    c.a(paramParcel, 7, paramPolygonOptions.g());
    c.a(paramParcel, 8, paramPolygonOptions.h());
    c.a(paramParcel, 9, paramPolygonOptions.i());
    c.a(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/maps/model/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */