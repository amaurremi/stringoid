package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator<CameraPosition>
{
  static void a(CameraPosition paramCameraPosition, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1, paramCameraPosition.lX());
    b.a(paramParcel, 2, paramCameraPosition.UP, paramInt, false);
    b.a(paramParcel, 3, paramCameraPosition.UQ);
    b.a(paramParcel, 4, paramCameraPosition.UR);
    b.a(paramParcel, 5, paramCameraPosition.US);
    b.D(paramParcel, i);
  }
  
  public CameraPosition bk(Parcel paramParcel)
  {
    float f1 = 0.0F;
    int j = a.j(paramParcel);
    int i = 0;
    LatLng localLatLng = null;
    float f2 = 0.0F;
    float f3 = 0.0F;
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
        localLatLng = (LatLng)a.a(paramParcel, k, LatLng.Vo);
        break;
      case 3: 
        f3 = a.j(paramParcel, k);
        break;
      case 4: 
        f2 = a.j(paramParcel, k);
        break;
      case 5: 
        f1 = a.j(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new CameraPosition(i, localLatLng, f3, f2, f1);
  }
  
  public CameraPosition[] dS(int paramInt)
  {
    return new CameraPosition[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/model/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */