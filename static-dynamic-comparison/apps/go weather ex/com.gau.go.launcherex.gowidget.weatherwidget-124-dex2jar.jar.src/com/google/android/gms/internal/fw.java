package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class fw
  implements Parcelable.Creator<fv>
{
  static void a(fv paramfv, Parcel paramParcel, int paramInt)
  {
    int i = b.p(paramParcel);
    b.c(paramParcel, 1, paramfv.getVersionCode());
    b.a(paramParcel, 2, paramfv.eT(), paramInt, false);
    b.F(paramParcel, i);
  }
  
  public fv[] S(int paramInt)
  {
    return new fv[paramInt];
  }
  
  public fv q(Parcel paramParcel)
  {
    int j = a.o(paramParcel);
    int i = 0;
    fx localfx = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.n(paramParcel);
      switch (a.R(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        localfx = (fx)a.a(paramParcel, k, fx.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new fv(i, localfx);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/fw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */