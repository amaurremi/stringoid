package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class k
  implements Parcelable.Creator
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
  
  public TileOverlayOptions a(Parcel paramParcel)
  {
    boolean bool = false;
    int j = a.b(paramParcel);
    IBinder localIBinder = null;
    float f = 0.0F;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.a(paramParcel);
      switch (a.a(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.f(paramParcel, k);
        break;
      case 2: 
        localIBinder = a.m(paramParcel, k);
        break;
      case 3: 
        bool = a.c(paramParcel, k);
        break;
      case 4: 
        f = a.i(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new b("Overread allowed size end=" + j, paramParcel);
    }
    return new TileOverlayOptions(i, localIBinder, bool, f);
  }
  
  public TileOverlayOptions[] a(int paramInt)
  {
    return new TileOverlayOptions[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/maps/model/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */