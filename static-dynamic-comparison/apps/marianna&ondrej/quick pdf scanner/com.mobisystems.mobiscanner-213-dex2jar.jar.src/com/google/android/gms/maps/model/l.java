package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class l
  implements Parcelable.Creator<TileOverlayOptions>
{
  static void a(TileOverlayOptions paramTileOverlayOptions, Parcel paramParcel, int paramInt)
  {
    paramInt = b.k(paramParcel);
    b.c(paramParcel, 1, paramTileOverlayOptions.lX());
    b.a(paramParcel, 2, paramTileOverlayOptions.vj(), false);
    b.a(paramParcel, 3, paramTileOverlayOptions.isVisible());
    b.a(paramParcel, 4, paramTileOverlayOptions.uS());
    b.a(paramParcel, 5, paramTileOverlayOptions.vk());
    b.D(paramParcel, paramInt);
  }
  
  public TileOverlayOptions bt(Parcel paramParcel)
  {
    boolean bool2 = false;
    int j = a.j(paramParcel);
    IBinder localIBinder = null;
    float f = 0.0F;
    boolean bool1 = true;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.i(paramParcel);
      switch (a.br(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        localIBinder = a.n(paramParcel, k);
        break;
      case 3: 
        bool2 = a.c(paramParcel, k);
        break;
      case 4: 
        f = a.j(paramParcel, k);
        break;
      case 5: 
        bool1 = a.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new TileOverlayOptions(i, localIBinder, bool2, f, bool1);
  }
  
  public TileOverlayOptions[] eb(int paramInt)
  {
    return new TileOverlayOptions[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/model/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */