package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h
  implements Parcelable.Creator<g>
{
  static void a(g paramg, Parcel paramParcel, int paramInt)
  {
    paramInt = b.D(paramParcel);
    b.c(paramParcel, 1, paramg.getVersionCode());
    b.c(paramParcel, 2, paramg.aus);
    b.a(paramParcel, 3, paramg.aut, false);
    b.a(paramParcel, 4, paramg.auu);
    b.a(paramParcel, 5, paramg.auv, false);
    b.a(paramParcel, 6, paramg.auw);
    b.c(paramParcel, 7, paramg.aux);
    b.H(paramParcel, paramInt);
  }
  
  public g dJ(Parcel paramParcel)
  {
    String str1 = null;
    int j = 0;
    int m = a.C(paramParcel);
    double d = 0.0D;
    long l = 0L;
    int i = -1;
    String str2 = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.B(paramParcel);
      switch (a.aD(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.g(paramParcel, n);
        break;
      case 2: 
        j = a.g(paramParcel, n);
        break;
      case 3: 
        str2 = a.o(paramParcel, n);
        break;
      case 4: 
        d = a.m(paramParcel, n);
        break;
      case 5: 
        str1 = a.o(paramParcel, n);
        break;
      case 6: 
        l = a.i(paramParcel, n);
        break;
      case 7: 
        i = a.g(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new g(k, j, str2, d, str1, l, i);
  }
  
  public g[] fL(int paramInt)
  {
    return new g[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wallet/wobs/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */