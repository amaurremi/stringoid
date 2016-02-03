package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.c;

public class x
{
  static void a(VisibleRegion paramVisibleRegion, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramVisibleRegion.a());
    c.a(paramParcel, 2, paramVisibleRegion.a, paramInt, false);
    c.a(paramParcel, 3, paramVisibleRegion.b, paramInt, false);
    c.a(paramParcel, 4, paramVisibleRegion.c, paramInt, false);
    c.a(paramParcel, 5, paramVisibleRegion.d, paramInt, false);
    c.a(paramParcel, 6, paramVisibleRegion.e, paramInt, false);
    c.a(paramParcel, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/maps/model/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */