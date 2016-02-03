package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class jq
  implements Parcelable.Creator<jp>
{
  static void a(jp paramjp, Parcel paramParcel, int paramInt)
  {
    paramInt = b.p(paramParcel);
    b.c(paramParcel, 1, paramjp.getVersionCode());
    b.c(paramParcel, 2, paramjp.adh);
    b.a(paramParcel, 3, paramjp.adi, false);
    b.a(paramParcel, 4, paramjp.adj);
    b.a(paramParcel, 5, paramjp.adk, false);
    b.a(paramParcel, 6, paramjp.adl);
    b.c(paramParcel, 7, paramjp.adm);
    b.F(paramParcel, paramInt);
  }
  
  public jp bs(Parcel paramParcel)
  {
    String str1 = null;
    int j = 0;
    int m = a.o(paramParcel);
    double d = 0.0D;
    long l = 0L;
    int i = -1;
    String str2 = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.n(paramParcel);
      switch (a.R(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.g(paramParcel, n);
        break;
      case 2: 
        j = a.g(paramParcel, n);
        break;
      case 3: 
        str2 = a.n(paramParcel, n);
        break;
      case 4: 
        d = a.l(paramParcel, n);
        break;
      case 5: 
        str1 = a.n(paramParcel, n);
        break;
      case 6: 
        l = a.i(paramParcel, n);
        break;
      case 7: 
        i = a.g(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new jp(k, j, str2, d, str1, l, i);
  }
  
  public jp[] cG(int paramInt)
  {
    return new jp[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/jq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */