package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class fn
  implements Parcelable.Creator<fm>
{
  static void a(fm paramfm, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramfm.id);
    b.c(paramParcel, 1000, paramfm.xM);
    b.a(paramParcel, 2, paramfm.xY, false);
    b.G(paramParcel, paramInt);
  }
  
  public fm[] G(int paramInt)
  {
    return new fm[paramInt];
  }
  
  public fm o(Parcel paramParcel)
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
    return new fm(i, j, localBundle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/fn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */