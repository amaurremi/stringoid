package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class iy
  implements Parcelable.Creator<ix>
{
  static void a(ix paramix, Parcel paramParcel, int paramInt)
  {
    paramInt = b.p(paramParcel);
    b.c(paramParcel, 1, paramix.getVersionCode());
    b.a(paramParcel, 2, paramix.act, false);
    b.a(paramParcel, 3, paramix.acu, false);
    b.F(paramParcel, paramInt);
  }
  
  public ix bm(Parcel paramParcel)
  {
    String[] arrayOfString = null;
    int j = a.o(paramParcel);
    int i = 0;
    byte[][] arrayOfByte = (byte[][])null;
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
        arrayOfString = a.z(paramParcel, k);
        break;
      case 3: 
        arrayOfByte = a.r(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ix(i, arrayOfString, arrayOfByte);
  }
  
  public ix[] cy(int paramInt)
  {
    return new ix[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/iy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */