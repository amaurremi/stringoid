package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class n
  implements Parcelable.Creator<VisibleRegion>
{
  static void a(VisibleRegion paramVisibleRegion, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1, paramVisibleRegion.lX());
    b.a(paramParcel, 2, paramVisibleRegion.VS, paramInt, false);
    b.a(paramParcel, 3, paramVisibleRegion.VT, paramInt, false);
    b.a(paramParcel, 4, paramVisibleRegion.VU, paramInt, false);
    b.a(paramParcel, 5, paramVisibleRegion.VV, paramInt, false);
    b.a(paramParcel, 6, paramVisibleRegion.VW, paramInt, false);
    b.D(paramParcel, i);
  }
  
  public VisibleRegion bu(Parcel paramParcel)
  {
    LatLngBounds localLatLngBounds = null;
    int j = a.j(paramParcel);
    int i = 0;
    LatLng localLatLng1 = null;
    LatLng localLatLng2 = null;
    LatLng localLatLng3 = null;
    LatLng localLatLng4 = null;
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
        localLatLng4 = (LatLng)a.a(paramParcel, k, LatLng.Vo);
        break;
      case 3: 
        localLatLng3 = (LatLng)a.a(paramParcel, k, LatLng.Vo);
        break;
      case 4: 
        localLatLng2 = (LatLng)a.a(paramParcel, k, LatLng.Vo);
        break;
      case 5: 
        localLatLng1 = (LatLng)a.a(paramParcel, k, LatLng.Vo);
        break;
      case 6: 
        localLatLngBounds = (LatLngBounds)a.a(paramParcel, k, LatLngBounds.Vr);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new VisibleRegion(i, localLatLng4, localLatLng3, localLatLng2, localLatLng1, localLatLngBounds);
  }
  
  public VisibleRegion[] ec(int paramInt)
  {
    return new VisibleRegion[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/model/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */