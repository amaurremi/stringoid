package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class fs
  implements Parcelable.Creator<fr>
{
  static void a(fr paramfr, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramfr.yq, paramInt, false);
    b.c(paramParcel, 1000, paramfr.xM);
    b.a(paramParcel, 2, paramfr.yr);
    b.c(paramParcel, 3, paramfr.ys);
    b.a(paramParcel, 4, paramfr.mP, false);
    b.a(paramParcel, 5, paramfr.yt, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public fr[] K(int paramInt)
  {
    return new fr[paramInt];
  }
  
  public fr q(Parcel paramParcel)
  {
    int i = 0;
    fg localfg = null;
    int k = a.B(paramParcel);
    long l = 0L;
    String str = null;
    fi localfi = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.A(paramParcel);
      switch (a.ar(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        localfi = (fi)a.a(paramParcel, m, fi.CREATOR);
        break;
      case 1000: 
        j = a.g(paramParcel, m);
        break;
      case 2: 
        l = a.i(paramParcel, m);
        break;
      case 3: 
        i = a.g(paramParcel, m);
        break;
      case 4: 
        str = a.o(paramParcel, m);
        break;
      case 5: 
        localfg = (fg)a.a(paramParcel, m, fg.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new fr(j, localfi, l, i, str, localfg);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/fs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */