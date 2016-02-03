package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class gk
  implements Parcelable.Creator<gj>
{
  static void a(gj paramgj, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramgj.getVersionCode());
    b.a(paramParcel, 2, paramgj.eh());
    b.a(paramParcel, 3, paramgj.en());
    b.c(paramParcel, 4, paramgj.eo());
    b.G(paramParcel, paramInt);
  }
  
  public gj[] Y(int paramInt)
  {
    return new gj[paramInt];
  }
  
  public gj v(Parcel paramParcel)
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
    return new gj(j, d, bool, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/gk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */