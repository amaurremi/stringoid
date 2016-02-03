package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

public class a
{
  static void a(GoogleMapOptions paramGoogleMapOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramGoogleMapOptions.getVersionCode());
    b.a(paramParcel, 2, paramGoogleMapOptions.jl());
    b.a(paramParcel, 3, paramGoogleMapOptions.jm());
    b.c(paramParcel, 4, paramGoogleMapOptions.getMapType());
    b.a(paramParcel, 5, paramGoogleMapOptions.getCamera(), paramInt, false);
    b.a(paramParcel, 6, paramGoogleMapOptions.jn());
    b.a(paramParcel, 7, paramGoogleMapOptions.jo());
    b.a(paramParcel, 8, paramGoogleMapOptions.jp());
    b.a(paramParcel, 9, paramGoogleMapOptions.jq());
    b.a(paramParcel, 10, paramGoogleMapOptions.jr());
    b.a(paramParcel, 11, paramGoogleMapOptions.js());
    b.G(paramParcel, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/maps/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */