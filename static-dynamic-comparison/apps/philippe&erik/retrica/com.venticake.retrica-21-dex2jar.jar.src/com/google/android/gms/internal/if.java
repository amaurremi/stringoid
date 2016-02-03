package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class if
  implements Parcelable.Creator<ie>
{
  static void a(ie paramie, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramie.getVersionCode());
    b.a(paramParcel, 2, paramie.fY(), false);
    b.a(paramParcel, 3, paramie.fZ(), paramInt, false);
    b.G(paramParcel, i);
  }
  
  public ie L(Parcel paramParcel)
  {
    ib localib = null;
    int j = a.B(paramParcel);
    int i = 0;
    Parcel localParcel = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        localParcel = a.C(paramParcel, k);
        break;
      case 3: 
        localib = (ib)a.a(paramParcel, k, ib.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ie(i, localParcel, localib);
  }
  
  public ie[] aA(int paramInt)
  {
    return new ie[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/if.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */