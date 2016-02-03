package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class jr
  implements Parcelable.Creator<jq>
{
  static void a(jq paramjq, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1000, paramjq.xM);
    b.a(paramParcel, 2, paramjq.jf(), paramInt, false);
    b.a(paramParcel, 3, paramjq.getInterval());
    b.c(paramParcel, 4, paramjq.getPriority());
    b.G(paramParcel, i);
  }
  
  public jq bx(Parcel paramParcel)
  {
    int k = a.B(paramParcel);
    int j = 0;
    jm localjm = null;
    long l = jq.Wm;
    int i = 102;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.A(paramParcel);
      switch (a.ar(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1000: 
        j = a.g(paramParcel, m);
        break;
      case 2: 
        localjm = (jm)a.a(paramParcel, m, jm.CREATOR);
        break;
      case 3: 
        l = a.i(paramParcel, m);
        break;
      case 4: 
        i = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new jq(j, localjm, l, i);
  }
  
  public jq[] cS(int paramInt)
  {
    return new jq[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/jr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */