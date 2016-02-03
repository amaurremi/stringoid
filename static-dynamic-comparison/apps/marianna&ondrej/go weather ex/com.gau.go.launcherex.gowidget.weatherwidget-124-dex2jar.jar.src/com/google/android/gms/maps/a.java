package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

public class a
{
  static void a(GoogleMapOptions paramGoogleMapOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.p(paramParcel);
    b.c(paramParcel, 1, paramGoogleMapOptions.getVersionCode());
    b.a(paramParcel, 2, paramGoogleMapOptions.ig());
    b.a(paramParcel, 3, paramGoogleMapOptions.ih());
    b.c(paramParcel, 4, paramGoogleMapOptions.getMapType());
    b.a(paramParcel, 5, paramGoogleMapOptions.getCamera(), paramInt, false);
    b.a(paramParcel, 6, paramGoogleMapOptions.ii());
    b.a(paramParcel, 7, paramGoogleMapOptions.ij());
    b.a(paramParcel, 8, paramGoogleMapOptions.ik());
    b.a(paramParcel, 9, paramGoogleMapOptions.il());
    b.a(paramParcel, 10, paramGoogleMapOptions.im());
    b.a(paramParcel, 11, paramGoogleMapOptions.in());
    b.F(paramParcel, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/maps/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */