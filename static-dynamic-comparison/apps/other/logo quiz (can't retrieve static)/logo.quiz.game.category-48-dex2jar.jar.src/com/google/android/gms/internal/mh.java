package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class mh
  implements Parcelable.Creator<mg>
{
  static void a(mg parammg, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, parammg.ma());
    b.c(paramParcel, 1000, parammg.getVersionCode());
    b.c(paramParcel, 2, parammg.me());
    b.a(paramParcel, 3, parammg.mf(), paramInt, false);
    b.H(paramParcel, i);
  }
  
  public mg cy(Parcel paramParcel)
  {
    int j = 0;
    int m = a.C(paramParcel);
    int k = -1;
    mi localmi = null;
    int i = 0;
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
        i = a.g(paramParcel, n);
        break;
      case 2: 
        k = a.g(paramParcel, n);
        break;
      case 3: 
        localmi = (mi)a.a(paramParcel, n, mi.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new mg(i, j, k, localmi);
  }
  
  public mg[] en(int paramInt)
  {
    return new mg[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/mh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */