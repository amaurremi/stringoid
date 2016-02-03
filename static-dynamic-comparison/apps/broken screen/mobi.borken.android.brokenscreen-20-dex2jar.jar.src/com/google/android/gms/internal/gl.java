package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class gl
  implements Parcelable.Creator<gk>
{
  static void a(gk paramgk, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramgk.getVersionCode());
    b.a(paramParcel, 2, paramgk.ec());
    b.a(paramParcel, 3, paramgk.ei());
    b.c(paramParcel, 4, paramgk.ej());
    b.G(paramParcel, paramInt);
  }
  
  public gk[] Y(int paramInt)
  {
    return new gk[paramInt];
  }
  
  public gk v(Parcel paramParcel)
  {
    int i = 0;
    int k = a.B(paramParcel);
    double d = 0.0D;
    boolean bool = false;
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
        j = a.g(paramParcel, m);
        break;
      case 2: 
        d = a.m(paramParcel, m);
        break;
      case 3: 
        bool = a.c(paramParcel, m);
        break;
      case 4: 
        i = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new gk(j, d, bool, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/gl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */