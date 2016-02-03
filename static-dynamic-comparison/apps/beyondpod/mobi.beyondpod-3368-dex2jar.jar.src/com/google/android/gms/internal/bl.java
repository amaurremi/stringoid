package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class bl
  implements Parcelable.Creator<bm>
{
  static void a(bm parambm, Parcel paramParcel, int paramInt)
  {
    int i = b.o(paramParcel);
    b.c(paramParcel, 1, parambm.versionCode);
    b.a(paramParcel, 2, parambm.gG, paramInt, false);
    b.a(paramParcel, 3, parambm.aa(), false);
    b.a(paramParcel, 4, parambm.ab(), false);
    b.a(paramParcel, 5, parambm.ac(), false);
    b.a(paramParcel, 6, parambm.ad(), false);
    b.a(paramParcel, 7, parambm.gL, false);
    b.a(paramParcel, 8, parambm.gM);
    b.a(paramParcel, 9, parambm.gN, false);
    b.a(paramParcel, 10, parambm.ae(), false);
    b.c(paramParcel, 11, parambm.orientation);
    b.c(paramParcel, 12, parambm.gP);
    b.a(paramParcel, 13, parambm.go, false);
    b.a(paramParcel, 14, parambm.ej, paramInt, false);
    b.D(paramParcel, i);
  }
  
  public bm e(Parcel paramParcel)
  {
    int m = a.n(paramParcel);
    int k = 0;
    bj localbj = null;
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
    cu localcu = null;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.m(paramParcel);
      switch (a.M(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.g(paramParcel, n);
        break;
      case 2: 
        localbj = (bj)a.a(paramParcel, n, bj.CREATOR);
        break;
      case 3: 
        localIBinder5 = a.n(paramParcel, n);
        break;
      case 4: 
        localIBinder4 = a.n(paramParcel, n);
        break;
      case 5: 
        localIBinder3 = a.n(paramParcel, n);
        break;
      case 6: 
        localIBinder2 = a.n(paramParcel, n);
        break;
      case 7: 
        str3 = a.m(paramParcel, n);
        break;
      case 8: 
        bool = a.c(paramParcel, n);
        break;
      case 9: 
        str2 = a.m(paramParcel, n);
        break;
      case 10: 
        localIBinder1 = a.n(paramParcel, n);
        break;
      case 11: 
        j = a.g(paramParcel, n);
        break;
      case 12: 
        i = a.g(paramParcel, n);
        break;
      case 13: 
        str1 = a.m(paramParcel, n);
        break;
      case 14: 
        localcu = (cu)a.a(paramParcel, n, cu.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new bm(k, localbj, localIBinder5, localIBinder4, localIBinder3, localIBinder2, str3, bool, str2, localIBinder1, j, i, str1, localcu);
  }
  
  public bm[] j(int paramInt)
  {
    return new bm[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */