package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class ar
  implements Parcelable.Creator
{
  static void a(dt.a parama, Parcel paramParcel, int paramInt)
  {
    paramInt = c.a(paramParcel);
    c.a(paramParcel, 1, parama.a);
    c.a(paramParcel, 2, parama.b, false);
    c.a(paramParcel, 3, parama.c);
    c.a(paramParcel, paramInt);
  }
  
  public dt.a a(Parcel paramParcel)
  {
    int j = 0;
    int k = a.b(paramParcel);
    String str = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.a(paramParcel);
      switch (a.a(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        i = a.f(paramParcel, m);
        break;
      case 2: 
        str = a.l(paramParcel, m);
        break;
      case 3: 
        j = a.f(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new b("Overread allowed size end=" + k, paramParcel);
    }
    return new dt.a(i, str, j);
  }
  
  public dt.a[] a(int paramInt)
  {
    return new dt.a[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */