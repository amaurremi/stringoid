package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

public class d
{
  static void a(GoogleMapOptions paramGoogleMapOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1, paramGoogleMapOptions.lX());
    b.a(paramParcel, 2, paramGoogleMapOptions.tY());
    b.a(paramParcel, 3, paramGoogleMapOptions.tZ());
    b.c(paramParcel, 4, paramGoogleMapOptions.ug());
    b.a(paramParcel, 5, paramGoogleMapOptions.uh(), paramInt, false);
    b.a(paramParcel, 6, paramGoogleMapOptions.ua());
    b.a(paramParcel, 7, paramGoogleMapOptions.ub());
    b.a(paramParcel, 8, paramGoogleMapOptions.uc());
    b.a(paramParcel, 9, paramGoogleMapOptions.ud());
    b.a(paramParcel, 10, paramGoogleMapOptions.ue());
    b.a(paramParcel, 11, paramGoogleMapOptions.uf());
    b.D(paramParcel, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */