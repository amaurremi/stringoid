package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class jr
  implements Parcelable.Creator<jo>
{
  static void a(jo paramjo, Parcel paramParcel, int paramInt)
  {
    int i = b.p(paramParcel);
    b.c(paramParcel, 1, paramjo.getVersionCode());
    b.a(paramParcel, 2, paramjo.label, false);
    b.a(paramParcel, 3, paramjo.adg, paramInt, false);
    b.a(paramParcel, 4, paramjo.type, false);
    b.a(paramParcel, 5, paramjo.abJ, paramInt, false);
    b.F(paramParcel, i);
  }
  
  public jo bt(Parcel paramParcel)
  {
    ju localju = null;
    int j = a.o(paramParcel);
    int i = 0;
    String str1 = null;
    jp localjp = null;
    String str2 = null;
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
        str2 = a.n(paramParcel, k);
        break;
      case 3: 
        localjp = (jp)a.a(paramParcel, k, jp.CREATOR);
        break;
      case 4: 
        str1 = a.n(paramParcel, k);
        break;
      case 5: 
        localju = (ju)a.a(paramParcel, k, ju.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new jo(i, str2, localjp, str1, localju);
  }
  
  public jo[] cH(int paramInt)
  {
    return new jo[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/jr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */