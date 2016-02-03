package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ch
  implements Parcelable.Creator<ci>
{
  static void a(ci paramci, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramci.versionCode);
    b.a(paramParcel, 2, paramci.ot, paramInt, false);
    b.a(paramParcel, 3, paramci.aP(), false);
    b.a(paramParcel, 4, paramci.aQ(), false);
    b.a(paramParcel, 5, paramci.aR(), false);
    b.a(paramParcel, 6, paramci.aS(), false);
    b.a(paramParcel, 7, paramci.oy, false);
    b.a(paramParcel, 8, paramci.oz);
    b.a(paramParcel, 9, paramci.oA, false);
    b.a(paramParcel, 10, paramci.aU(), false);
    b.c(paramParcel, 11, paramci.orientation);
    b.c(paramParcel, 12, paramci.oC);
    b.a(paramParcel, 13, paramci.nZ, false);
    b.a(paramParcel, 14, paramci.kO, paramInt, false);
    b.a(paramParcel, 15, paramci.aT(), false);
    b.a(paramParcel, 17, paramci.oF, paramInt, false);
    b.a(paramParcel, 16, paramci.oE, false);
    b.G(paramParcel, i);
  }
  
  public ci f(Parcel paramParcel)
  {
    int m = a.B(paramParcel);
    int k = 0;
    cf localcf = null;
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
    ew localew = null;
    IBinder localIBinder1 = null;
    String str1 = null;
    w localw = null;
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
        localcf = (cf)a.a(paramParcel, n, cf.CREATOR);
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
        localew = (ew)a.a(paramParcel, n, ew.CREATOR);
        break;
      case 15: 
        localIBinder1 = a.p(paramParcel, n);
        break;
      case 17: 
        localw = (w)a.a(paramParcel, n, w.CREATOR);
        break;
      case 16: 
        str1 = a.o(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new ci(k, localcf, localIBinder6, localIBinder5, localIBinder4, localIBinder3, str4, bool, str3, localIBinder2, j, i, str2, localew, localIBinder1, str1, localw);
  }
  
  public ci[] j(int paramInt)
  {
    return new ci[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */