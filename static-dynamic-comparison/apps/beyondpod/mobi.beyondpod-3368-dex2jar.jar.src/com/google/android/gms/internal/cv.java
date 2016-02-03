package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class cv
  implements Parcelable.Creator<cu>
{
  static void a(cu paramcu, Parcel paramParcel, int paramInt)
  {
    paramInt = b.o(paramParcel);
    b.c(paramParcel, 1, paramcu.versionCode);
    b.a(paramParcel, 2, paramcu.iJ, false);
    b.c(paramParcel, 3, paramcu.iK);
    b.c(paramParcel, 4, paramcu.iL);
    b.a(paramParcel, 5, paramcu.iM);
    b.D(paramParcel, paramInt);
  }
  
  public cu h(Parcel paramParcel)
  {
    boolean bool = false;
    int m = a.n(paramParcel);
    String str = null;
    int i = 0;
    int j = 0;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.m(paramParcel);
      switch (a.M(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.g(paramParcel, n);
        break;
      case 2: 
        str = a.m(paramParcel, n);
        break;
      case 3: 
        j = a.g(paramParcel, n);
        break;
      case 4: 
        i = a.g(paramParcel, n);
        break;
      case 5: 
        bool = a.c(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new cu(k, str, j, i, bool);
  }
  
  public cu[] o(int paramInt)
  {
    return new cu[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */