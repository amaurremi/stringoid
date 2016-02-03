package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.c;

public class v
{
  static void a(Tile paramTile, Parcel paramParcel, int paramInt)
  {
    paramInt = c.a(paramParcel);
    c.a(paramParcel, 1, paramTile.a());
    c.a(paramParcel, 2, paramTile.a);
    c.a(paramParcel, 3, paramTile.b);
    c.a(paramParcel, 4, paramTile.c, false);
    c.a(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/maps/model/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */