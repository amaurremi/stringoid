package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class cg
  implements Parcelable.Creator<ch>
{
  static void a(ch paramch, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramch.versionCode);
    b.a(paramParcel, 2, paramch.ov, paramInt, false);
    b.a(paramParcel, 3, paramch.aU(), false);
    b.a(paramParcel, 4, paramch.aV(), false);
    b.a(paramParcel, 5, paramch.aW(), false);
    b.a(paramParcel, 6, paramch.aX(), false);
    b.a(paramParcel, 7, paramch.oA, false);
    b.a(paramParcel, 8, paramch.oB);
    b.a(paramParcel, 9, paramch.oC, false);
    b.a(paramParcel, 10, paramch.aZ(), false);
    b.c(paramParcel, 11, paramch.orientation);
    b.c(paramParcel, 12, paramch.oE);
    b.a(paramParcel, 13, paramch.ob, false);
    b.a(paramParcel, 14, paramch.kQ, paramInt, false);
    b.a(paramParcel, 15, paramch.aY(), false);
    b.a(paramParcel, 17, paramch.oH, paramInt, false);
    b.a(paramParcel, 16, paramch.oG, false);
    b.G(paramParcel, i);
  }
  
  public ch f(Parcel paramParcel)
  {
    int m = a.B(paramParcel);
    int k = 0;
    ce localce = null;
    IBinder localIBinder6 = null;
    IBinder localIBinder5 = null;
    IBinder localIBinder4 = null;
    IBinder localIBinder3 = null;
    String str4 = null;
    boolean bool = false;
    String str3 = null;
    IBinder localIBinder2 = null;
    int j = 0;
    int i = 0;
    String str2 = null;
    ev localev = null;
    IBinder localIBinder1 = null;
    String str1 = null;
    v localv = null;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.A(paramParcel);
      switch (a.ar(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.g(paramParcel, n);
        break;
      case 2: 
        localce = (ce)a.a(paramParcel, n, ce.CREATOR);
        break;
      case 3: 
        localIBinder6 = a.p(paramParcel, n);
        break;
      case 4: 
        localIBinder5 = a.p(paramParcel, n);
        break;
      case 5: 
        localIBinder4 = a.p(paramParcel, n);
        break;
      case 6: 
        localIBinder3 = a.p(paramParcel, n);
        break;
      case 7: 
        str4 = a.o(paramParcel, n);
        break;
      case 8: 
        bool = a.c(paramParcel, n);
        break;
      case 9: 
        str3 = a.o(paramParcel, n);
        break;
      case 10: 
        localIBinder2 = a.p(paramParcel, n);
        break;
      case 11: 
        j = a.g(paramParcel, n);
        break;
      case 12: 
        i = a.g(paramParcel, n);
        break;
      case 13: 
        str2 = a.o(paramParcel, n);
        break;
      case 14: 
        localev = (ev)a.a(paramParcel, n, ev.CREATOR);
        break;
      case 15: 
        localIBinder1 = a.p(paramParcel, n);
        break;
      case 17: 
        localv = (v)a.a(paramParcel, n, v.CREATOR);
        break;
      case 16: 
        str1 = a.o(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new ch(k, localce, localIBinder6, localIBinder5, localIBinder4, localIBinder3, str4, bool, str3, localIBinder2, j, i, str2, localev, localIBinder1, str1, localv);
  }
  
  public ch[] j(int paramInt)
  {
    return new ch[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */