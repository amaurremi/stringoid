package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class kj
  implements Parcelable.Creator<ki>
{
  static void a(ki paramki, Parcel paramParcel, int paramInt)
  {
    paramInt = b.p(paramParcel);
    b.c(paramParcel, 1, paramki.xH);
    b.c(paramParcel, 2, paramki.fA());
    b.a(paramParcel, 3, paramki.getPath(), false);
    b.a(paramParcel, 4, paramki.getData(), false);
    b.a(paramParcel, 5, paramki.getSource(), false);
    b.F(paramParcel, paramInt);
  }
  
  public ki by(Parcel paramParcel)
  {
    int i = 0;
    String str1 = null;
    int k = a.o(paramParcel);
    byte[] arrayOfByte = null;
    String str2 = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.n(paramParcel);
      switch (a.R(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        j = a.g(paramParcel, m);
        break;
      case 2: 
        i = a.g(paramParcel, m);
        break;
      case 3: 
        str2 = a.n(paramParcel, m);
        break;
      case 4: 
        arrayOfByte = a.q(paramParcel, m);
        break;
      case 5: 
        str1 = a.n(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new ki(j, i, str2, arrayOfByte, str1);
  }
  
  public ki[] cN(int paramInt)
  {
    return new ki[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/kj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */