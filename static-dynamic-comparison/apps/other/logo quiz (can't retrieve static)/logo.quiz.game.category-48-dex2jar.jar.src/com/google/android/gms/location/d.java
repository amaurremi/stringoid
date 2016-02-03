package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class d
  implements Parcelable.Creator<c>
{
  static void a(c paramc, Parcel paramParcel, int paramInt)
  {
    paramInt = b.D(paramParcel);
    b.c(paramParcel, 1, paramc.aem);
    b.c(paramParcel, 1000, paramc.getVersionCode());
    b.c(paramParcel, 2, paramc.aen);
    b.a(paramParcel, 3, paramc.aeo);
    b.H(paramParcel, paramInt);
  }
  
  public c ct(Parcel paramParcel)
  {
    int i = 1;
    int m = a.C(paramParcel);
    int k = 0;
    long l = 0L;
    int j = 1;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.B(paramParcel);
      switch (a.aD(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        j = a.g(paramParcel, n);
        break;
      case 1000: 
        k = a.g(paramParcel, n);
        break;
      case 2: 
        i = a.g(paramParcel, n);
        break;
      case 3: 
        l = a.i(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new c(k, j, i, l);
  }
  
  public c[] eg(int paramInt)
  {
    return new c[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/location/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */