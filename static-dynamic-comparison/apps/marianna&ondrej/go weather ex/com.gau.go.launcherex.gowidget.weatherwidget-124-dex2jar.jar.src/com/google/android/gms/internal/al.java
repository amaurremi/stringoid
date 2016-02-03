package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class al
  implements Parcelable.Creator<ak>
{
  static void a(ak paramak, Parcel paramParcel, int paramInt)
  {
    int i = b.p(paramParcel);
    b.c(paramParcel, 1, paramak.versionCode);
    b.a(paramParcel, 2, paramak.lS, false);
    b.c(paramParcel, 3, paramak.height);
    b.c(paramParcel, 4, paramak.heightPixels);
    b.a(paramParcel, 5, paramak.lT);
    b.c(paramParcel, 6, paramak.width);
    b.c(paramParcel, 7, paramak.widthPixels);
    b.a(paramParcel, 8, paramak.lU, paramInt, false);
    b.F(paramParcel, i);
  }
  
  public ak b(Parcel paramParcel)
  {
    ak[] arrayOfak = null;
    int i = 0;
    int i1 = a.o(paramParcel);
    int j = 0;
    boolean bool = false;
    int k = 0;
    int m = 0;
    String str = null;
    int n = 0;
    while (paramParcel.dataPosition() < i1)
    {
      int i2 = a.n(paramParcel);
      switch (a.R(i2))
      {
      default: 
        a.b(paramParcel, i2);
        break;
      case 1: 
        n = a.g(paramParcel, i2);
        break;
      case 2: 
        str = a.n(paramParcel, i2);
        break;
      case 3: 
        m = a.g(paramParcel, i2);
        break;
      case 4: 
        k = a.g(paramParcel, i2);
        break;
      case 5: 
        bool = a.c(paramParcel, i2);
        break;
      case 6: 
        j = a.g(paramParcel, i2);
        break;
      case 7: 
        i = a.g(paramParcel, i2);
        break;
      case 8: 
        arrayOfak = (ak[])a.b(paramParcel, i2, ak.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i1) {
      throw new a.a("Overread allowed size end=" + i1, paramParcel);
    }
    return new ak(n, str, m, k, bool, j, i, arrayOfak);
  }
  
  public ak[] c(int paramInt)
  {
    return new ak[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */