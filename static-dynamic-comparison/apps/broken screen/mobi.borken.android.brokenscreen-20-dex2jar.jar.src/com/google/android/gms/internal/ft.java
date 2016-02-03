package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ft
  implements Parcelable.Creator<fs>
{
  static void a(fs paramfs, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramfs.yn, paramInt, false);
    b.c(paramParcel, 1000, paramfs.xJ);
    b.a(paramParcel, 2, paramfs.yo);
    b.c(paramParcel, 3, paramfs.yp);
    b.a(paramParcel, 4, paramfs.mN, false);
    b.a(paramParcel, 5, paramfs.yq, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public fs[] K(int paramInt)
  {
    return new fs[paramInt];
  }
  
  public fs q(Parcel paramParcel)
  {
    int i = 0;
    fh localfh = null;
    int k = a.B(paramParcel);
    long l = 0L;
    String str = null;
    fj localfj = null;
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
        localfj = (fj)a.a(paramParcel, m, fj.CREATOR);
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
        localfh = (fh)a.a(paramParcel, m, fh.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new fs(j, localfj, l, i, str, localfh);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */