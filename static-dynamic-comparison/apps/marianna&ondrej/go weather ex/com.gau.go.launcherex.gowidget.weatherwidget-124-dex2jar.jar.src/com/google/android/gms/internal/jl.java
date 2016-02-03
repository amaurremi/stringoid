package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class jl
  implements Parcelable.Creator<jk>
{
  static void a(jk paramjk, Parcel paramParcel, int paramInt)
  {
    paramInt = b.p(paramParcel);
    b.c(paramParcel, 1, paramjk.getVersionCode());
    b.a(paramParcel, 2, paramjk.label, false);
    b.a(paramParcel, 3, paramjk.value, false);
    b.F(paramParcel, paramInt);
  }
  
  public jk bq(Parcel paramParcel)
  {
    String str2 = null;
    int j = a.o(paramParcel);
    int i = 0;
    String str1 = null;
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
        str1 = a.n(paramParcel, k);
        break;
      case 3: 
        str2 = a.n(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new jk(i, str1, str2);
  }
  
  public jk[] cE(int paramInt)
  {
    return new jk[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/jl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */