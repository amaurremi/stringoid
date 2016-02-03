package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class et
  implements Parcelable.Creator<es.a>
{
  static void a(es.a parama, Parcel paramParcel, int paramInt)
  {
    int i = b.o(paramParcel);
    b.c(paramParcel, 1, parama.getVersionCode());
    b.c(paramParcel, 2, parama.ch());
    b.a(paramParcel, 3, parama.cn());
    b.c(paramParcel, 4, parama.ci());
    b.a(paramParcel, 5, parama.co());
    b.a(paramParcel, 6, parama.cp(), false);
    b.c(paramParcel, 7, parama.cq());
    b.a(paramParcel, 8, parama.cs(), false);
    b.a(paramParcel, 9, parama.cu(), paramInt, false);
    b.D(paramParcel, i);
  }
  
  public es.a[] R(int paramInt)
  {
    return new es.a[paramInt];
  }
  
  public es.a t(Parcel paramParcel)
  {
    en localen = null;
    int i = 0;
    int n = a.n(paramParcel);
    String str1 = null;
    String str2 = null;
    boolean bool1 = false;
    int j = 0;
    boolean bool2 = false;
    int k = 0;
    int m = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = a.m(paramParcel);
      switch (a.M(i1))
      {
      default: 
        a.b(paramParcel, i1);
        break;
      case 1: 
        m = a.g(paramParcel, i1);
        break;
      case 2: 
        k = a.g(paramParcel, i1);
        break;
      case 3: 
        bool2 = a.c(paramParcel, i1);
        break;
      case 4: 
        j = a.g(paramParcel, i1);
        break;
      case 5: 
        bool1 = a.c(paramParcel, i1);
        break;
      case 6: 
        str2 = a.m(paramParcel, i1);
        break;
      case 7: 
        i = a.g(paramParcel, i1);
        break;
      case 8: 
        str1 = a.m(paramParcel, i1);
        break;
      case 9: 
        localen = (en)a.a(paramParcel, i1, en.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new a.a("Overread allowed size end=" + n, paramParcel);
    }
    return new es.a(m, k, bool2, j, bool1, str2, i, str1, localen);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/et.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */