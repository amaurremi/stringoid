package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class k
  implements Parcelable.Creator<Tile>
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
  
  public Tile bs(Parcel paramParcel)
  {
    int k = 0;
    int m = a.j(paramParcel);
    byte[] arrayOfByte = null;
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.i(paramParcel);
      switch (a.br(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        i = a.g(paramParcel, n);
        break;
      case 2: 
        j = a.g(paramParcel, n);
        break;
      case 3: 
        k = a.g(paramParcel, n);
        break;
      case 4: 
        arrayOfByte = a.p(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new Tile(i, j, k, arrayOfByte);
  }
  
  public Tile[] ea(int paramInt)
  {
    return new Tile[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/model/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */