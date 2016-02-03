package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.c;

public class w
{
  static void a(TileOverlayOptions paramTileOverlayOptions, Parcel paramParcel, int paramInt)
  {
    paramInt = c.a(paramParcel);
    c.a(paramParcel, 1, paramTileOverlayOptions.a());
    c.a(paramParcel, 2, paramTileOverlayOptions.b(), false);
    c.a(paramParcel, 3, paramTileOverlayOptions.d());
    c.a(paramParcel, 4, paramTileOverlayOptions.c());
    c.a(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/maps/model/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */