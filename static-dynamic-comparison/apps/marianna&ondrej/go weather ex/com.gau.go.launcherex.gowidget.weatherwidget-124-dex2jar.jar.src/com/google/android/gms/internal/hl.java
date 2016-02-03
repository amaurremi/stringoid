package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hl
  implements Parcelable.Creator<hk>
{
  static void a(hk paramhk, Parcel paramParcel, int paramInt)
  {
    int i = b.p(paramParcel);
    b.c(paramParcel, 1000, paramhk.xH);
    b.a(paramParcel, 2, paramhk.hZ(), paramInt, false);
    b.a(paramParcel, 3, paramhk.getInterval());
    b.c(paramParcel, 4, paramhk.getPriority());
    b.F(paramParcel, i);
  }
  
  public hk aF(Parcel paramParcel)
  {
    int k = a.o(paramParcel);
    int j = 0;
    hg localhg = null;
    long l = hk.OF;
    int i = 102;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.n(paramParcel);
      switch (a.R(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1000: 
        j = a.g(paramParcel, m);
        break;
      case 2: 
        localhg = (hg)a.a(paramParcel, m, hg.CREATOR);
        break;
      case 3: 
        l = a.i(paramParcel, m);
        break;
      case 4: 
        i = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new hk(j, localhg, l, i);
  }
  
  public hk[] bG(int paramInt)
  {
    return new hk[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/hl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */