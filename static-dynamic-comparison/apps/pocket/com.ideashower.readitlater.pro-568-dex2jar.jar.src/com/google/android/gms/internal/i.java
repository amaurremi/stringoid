package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class i
  implements Parcelable.Creator
{
  static void a(co paramco, Parcel paramParcel, int paramInt)
  {
    paramInt = c.a(paramParcel);
    c.a(paramParcel, 1, paramco.a);
    c.a(paramParcel, 2, paramco.b, false);
    c.a(paramParcel, 3, paramco.c);
    c.a(paramParcel, 4, paramco.d);
    c.a(paramParcel, 5, paramco.e);
    c.a(paramParcel, paramInt);
  }
  
  public co a(Parcel paramParcel)
  {
    boolean bool = false;
    int m = a.b(paramParcel);
    String str = null;
    int i = 0;
    int j = 0;
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
        str = a.l(paramParcel, n);
        break;
      case 3: 
        j = a.f(paramParcel, n);
        break;
      case 4: 
        i = a.f(paramParcel, n);
        break;
      case 5: 
        bool = a.c(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new b("Overread allowed size end=" + m, paramParcel);
    }
    return new co(k, str, j, i, bool);
  }
  
  public co[] a(int paramInt)
  {
    return new co[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */