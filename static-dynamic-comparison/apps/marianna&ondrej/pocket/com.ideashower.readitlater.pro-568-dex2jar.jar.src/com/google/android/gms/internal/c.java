package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator
{
  static void a(bh parambh, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1, parambh.a);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, parambh.b, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 3, parambh.a(), false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 4, parambh.b(), false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 5, parambh.c(), false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 6, parambh.d(), false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 7, parambh.g, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 8, parambh.h);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 9, parambh.i, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 10, parambh.e(), false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 11, parambh.k);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 12, parambh.l);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 13, parambh.m, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 14, parambh.n, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, i);
  }
  
  public bh a(Parcel paramParcel)
  {
    int m = a.b(paramParcel);
    int k = 0;
    be localbe = null;
    IBinder localIBinder5 = null;
    IBinder localIBinder4 = null;
    IBinder localIBinder3 = null;
    IBinder localIBinder2 = null;
    String str3 = null;
    boolean bool = false;
    String str2 = null;
    IBinder localIBinder1 = null;
    int j = 0;
    int i = 0;
    String str1 = null;
    co localco = null;
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
        localbe = (be)a.a(paramParcel, n, be.CREATOR);
        break;
      case 3: 
        localIBinder5 = a.m(paramParcel, n);
        break;
      case 4: 
        localIBinder4 = a.m(paramParcel, n);
        break;
      case 5: 
        localIBinder3 = a.m(paramParcel, n);
        break;
      case 6: 
        localIBinder2 = a.m(paramParcel, n);
        break;
      case 7: 
        str3 = a.l(paramParcel, n);
        break;
      case 8: 
        bool = a.c(paramParcel, n);
        break;
      case 9: 
        str2 = a.l(paramParcel, n);
        break;
      case 10: 
        localIBinder1 = a.m(paramParcel, n);
        break;
      case 11: 
        j = a.f(paramParcel, n);
        break;
      case 12: 
        i = a.f(paramParcel, n);
        break;
      case 13: 
        str1 = a.l(paramParcel, n);
        break;
      case 14: 
        localco = (co)a.a(paramParcel, n, co.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new b("Overread allowed size end=" + m, paramParcel);
    }
    return new bh(k, localbe, localIBinder5, localIBinder4, localIBinder3, localIBinder2, str3, bool, str2, localIBinder1, j, i, str1, localco);
  }
  
  public bh[] a(int paramInt)
  {
    return new bh[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */