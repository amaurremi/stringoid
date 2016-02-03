package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ji
  implements Parcelable.Creator<jh>
{
  static void a(jh paramjh, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.a(paramParcel, 1, paramjh.getRequestId(), false);
    b.c(paramParcel, 1000, paramjh.getVersionCode());
    b.a(paramParcel, 2, paramjh.getExpirationTime());
    b.a(paramParcel, 3, paramjh.ja());
    b.a(paramParcel, 4, paramjh.getLatitude());
    b.a(paramParcel, 5, paramjh.getLongitude());
    b.a(paramParcel, 6, paramjh.jb());
    b.c(paramParcel, 7, paramjh.jc());
    b.c(paramParcel, 8, paramjh.getNotificationResponsiveness());
    b.c(paramParcel, 9, paramjh.jd());
    b.G(paramParcel, paramInt);
  }
  
  public jh bt(Parcel paramParcel)
  {
    int n = a.B(paramParcel);
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
      int i1 = a.A(paramParcel);
      switch (a.ar(i1))
      {
      default: 
        a.b(paramParcel, i1);
        break;
      case 1: 
        str = a.o(paramParcel, i1);
        break;
      case 1000: 
        m = a.g(paramParcel, i1);
        break;
      case 2: 
        l = a.i(paramParcel, i1);
        break;
      case 3: 
        s = a.f(paramParcel, i1);
        break;
      case 4: 
        d2 = a.m(paramParcel, i1);
        break;
      case 5: 
        d1 = a.m(paramParcel, i1);
        break;
      case 6: 
        f = a.l(paramParcel, i1);
        break;
      case 7: 
        k = a.g(paramParcel, i1);
        break;
      case 8: 
        j = a.g(paramParcel, i1);
        break;
      case 9: 
        i = a.g(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new a.a("Overread allowed size end=" + n, paramParcel);
    }
    return new jh(m, str, k, s, d2, d1, f, l, j, i);
  }
  
  public jh[] cO(int paramInt)
  {
    return new jh[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */