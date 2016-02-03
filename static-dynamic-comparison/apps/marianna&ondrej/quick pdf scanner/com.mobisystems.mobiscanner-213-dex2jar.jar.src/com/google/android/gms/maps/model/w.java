package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

public class w
{
  static void a(Tile paramTile, Parcel paramParcel, int paramInt)
  {
    paramInt = b.k(paramParcel);
    b.c(paramParcel, 1, paramTile.lX());
    b.c(paramParcel, 2, paramTile.width);
    b.c(paramParcel, 3, paramTile.height);
    b.a(paramParcel, 4, paramTile.VJ, false);
    b.D(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/model/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */