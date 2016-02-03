package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class kl
  implements Parcelable.Creator<kk>
{
  static void a(kk paramkk, Parcel paramParcel, int paramInt)
  {
    paramInt = b.p(paramParcel);
    b.c(paramParcel, 1, paramkk.xH);
    b.a(paramParcel, 2, paramkk.getId(), false);
    b.a(paramParcel, 3, paramkk.getDisplayName(), false);
    b.F(paramParcel, paramInt);
  }
  
  public kk bz(Parcel paramParcel)
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
    return new kk(i, str1, str2);
  }
  
  public kk[] cO(int paramInt)
  {
    return new kk[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/kl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */