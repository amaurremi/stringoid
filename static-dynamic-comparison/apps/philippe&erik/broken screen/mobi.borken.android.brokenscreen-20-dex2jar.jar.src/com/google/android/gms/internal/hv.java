package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hv
  implements Parcelable.Creator<hu>
{
  static void a(hu paramhu, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramhu.getVersionCode());
    b.a(paramParcel, 2, paramhu.fw(), paramInt, false);
    b.G(paramParcel, i);
  }
  
  public hu E(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int i = 0;
    hw localhw = null;
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
        localhw = (hw)a.a(paramParcel, k, hw.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new hu(i, localhw);
  }
  
  public hu[] at(int paramInt)
  {
    return new hu[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/hv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */