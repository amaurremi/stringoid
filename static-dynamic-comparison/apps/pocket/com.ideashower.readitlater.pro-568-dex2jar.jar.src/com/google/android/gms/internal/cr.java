package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;

public class cr
  implements Parcelable.Creator
{
  static void a(v paramv, Parcel paramParcel, int paramInt)
  {
    paramInt = c.a(paramParcel);
    c.a(paramParcel, 1, paramv.a);
    c.a(paramParcel, 2, paramv.b);
    c.a(paramParcel, 3, paramv.c, false);
    c.a(paramParcel, 4, paramv.d);
    c.a(paramParcel, 5, paramv.e, false);
    c.a(paramParcel, 6, paramv.f);
    c.a(paramParcel, 7, paramv.g);
    c.a(paramParcel, paramInt);
  }
  
  public v a(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int i = 0;
    int m = a.b(paramParcel);
    long l = 0L;
    boolean bool = false;
    int j = 0;
    Bundle localBundle = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.a(paramParcel);
      switch (a.a(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.f(paramParcel, n);
        break;
      case 2: 
        l = a.g(paramParcel, n);
        break;
      case 3: 
        localBundle = a.n(paramParcel, n);
        break;
      case 4: 
        j = a.f(paramParcel, n);
        break;
      case 5: 
        localArrayList = a.x(paramParcel, n);
        break;
      case 6: 
        bool = a.c(paramParcel, n);
        break;
      case 7: 
        i = a.f(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new b("Overread allowed size end=" + m, paramParcel);
    }
    return new v(k, l, localBundle, j, localArrayList, bool, i);
  }
  
  public v[] a(int paramInt)
  {
    return new v[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */