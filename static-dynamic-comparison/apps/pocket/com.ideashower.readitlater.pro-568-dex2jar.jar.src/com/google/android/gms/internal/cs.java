package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class cs
  implements Parcelable.Creator
{
  static void a(x paramx, Parcel paramParcel, int paramInt)
  {
    paramInt = c.a(paramParcel);
    c.a(paramParcel, 1, paramx.a);
    c.a(paramParcel, 2, paramx.b, false);
    c.a(paramParcel, 3, paramx.c);
    c.a(paramParcel, 4, paramx.d);
    c.a(paramParcel, 5, paramx.e);
    c.a(paramParcel, 6, paramx.f);
    c.a(paramParcel, 7, paramx.g);
    c.a(paramParcel, paramInt);
  }
  
  public x a(Parcel paramParcel)
  {
    int i = 0;
    int i1 = a.b(paramParcel);
    String str = null;
    int j = 0;
    boolean bool = false;
    int k = 0;
    int m = 0;
    int n = 0;
    while (paramParcel.dataPosition() < i1)
    {
      int i2 = a.a(paramParcel);
      switch (a.a(i2))
      {
      default: 
        a.b(paramParcel, i2);
        break;
      case 1: 
        n = a.f(paramParcel, i2);
        break;
      case 2: 
        str = a.l(paramParcel, i2);
        break;
      case 3: 
        m = a.f(paramParcel, i2);
        break;
      case 4: 
        k = a.f(paramParcel, i2);
        break;
      case 5: 
        bool = a.c(paramParcel, i2);
        break;
      case 6: 
        j = a.f(paramParcel, i2);
        break;
      case 7: 
        i = a.f(paramParcel, i2);
      }
    }
    if (paramParcel.dataPosition() != i1) {
      throw new b("Overread allowed size end=" + i1, paramParcel);
    }
    return new x(n, str, m, k, bool, j, i);
  }
  
  public x[] a(int paramInt)
  {
    return new x[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */