package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class bf
  implements Parcelable.Creator
{
  static void a(fa paramfa, Parcel paramParcel, int paramInt)
  {
    paramInt = c.a(paramParcel);
    c.a(paramParcel, 1, paramfa.f(), false);
    c.a(paramParcel, 1000, paramfa.a());
    c.a(paramParcel, 2, paramfa.g());
    c.a(paramParcel, 3, paramfa.b());
    c.a(paramParcel, 4, paramfa.c());
    c.a(paramParcel, 5, paramfa.d());
    c.a(paramParcel, 6, paramfa.e());
    c.a(paramParcel, 7, paramfa.h());
    c.a(paramParcel, 8, paramfa.i());
    c.a(paramParcel, 9, paramfa.j());
    c.a(paramParcel, paramInt);
  }
  
  public fa a(Parcel paramParcel)
  {
    int n = a.b(paramParcel);
    int m = 0;
    String str = null;
    int k = 0;
    short s = 0;
    double d2 = 0.0D;
    double d1 = 0.0D;
    float f = 0.0F;
    long l = 0L;
    int j = 0;
    int i = -1;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = a.a(paramParcel);
      switch (a.a(i1))
      {
      default: 
        a.b(paramParcel, i1);
        break;
      case 1: 
        str = a.l(paramParcel, i1);
        break;
      case 1000: 
        m = a.f(paramParcel, i1);
        break;
      case 2: 
        l = a.g(paramParcel, i1);
        break;
      case 3: 
        s = a.e(paramParcel, i1);
        break;
      case 4: 
        d2 = a.j(paramParcel, i1);
        break;
      case 5: 
        d1 = a.j(paramParcel, i1);
        break;
      case 6: 
        f = a.i(paramParcel, i1);
        break;
      case 7: 
        k = a.f(paramParcel, i1);
        break;
      case 8: 
        j = a.f(paramParcel, i1);
        break;
      case 9: 
        i = a.f(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new b("Overread allowed size end=" + n, paramParcel);
    }
    return new fa(m, str, k, s, d2, d1, f, l, j, i);
  }
  
  public fa[] a(int paramInt)
  {
    return new fa[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */