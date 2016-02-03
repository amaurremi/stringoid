package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class fo
  implements Parcelable.Creator<fn>
{
  static void a(fn paramfn, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramfn.id);
    b.c(paramParcel, 1000, paramfn.xJ);
    b.a(paramParcel, 2, paramfn.xV, false);
    b.G(paramParcel, paramInt);
  }
  
  public fn[] G(int paramInt)
  {
    return new fn[paramInt];
  }
  
  public fn o(Parcel paramParcel)
  {
    int j = 0;
    int k = a.B(paramParcel);
    Bundle localBundle = null;
    int i = 0;
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
      case 1000: 
        i = a.g(paramParcel, m);
        break;
      case 2: 
        localBundle = a.q(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new fn(i, j, localBundle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/fo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */