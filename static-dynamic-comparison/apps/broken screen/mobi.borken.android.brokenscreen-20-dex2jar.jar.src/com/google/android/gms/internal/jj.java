package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class jj
  implements Parcelable.Creator<ji>
{
  static void a(ji paramji, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.a(paramParcel, 1, paramji.getRequestId(), false);
    b.c(paramParcel, 1000, paramji.getVersionCode());
    b.a(paramParcel, 2, paramji.getExpirationTime());
    b.a(paramParcel, 3, paramji.iV());
    b.a(paramParcel, 4, paramji.getLatitude());
    b.a(paramParcel, 5, paramji.getLongitude());
    b.a(paramParcel, 6, paramji.iW());
    b.c(paramParcel, 7, paramji.iX());
    b.c(paramParcel, 8, paramji.getNotificationResponsiveness());
    b.c(paramParcel, 9, paramji.iY());
    b.G(paramParcel, paramInt);
  }
  
  public ji bt(Parcel paramParcel)
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
    return new ji(m, str, k, s, d2, d1, f, l, j, i);
  }
  
  public ji[] cO(int paramInt)
  {
    return new ji[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/jj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */