package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class eu
  implements Parcelable.Creator<ev.b>
{
  static void a(ev.b paramb, Parcel paramParcel, int paramInt)
  {
    int i = b.o(paramParcel);
    b.c(paramParcel, 1, paramb.versionCode);
    b.a(paramParcel, 2, paramb.qw, false);
    b.a(paramParcel, 3, paramb.qx, paramInt, false);
    b.D(paramParcel, i);
  }
  
  public ev.b[] S(int paramInt)
  {
    return new ev.b[paramInt];
  }
  
  public ev.b u(Parcel paramParcel)
  {
    es.a locala = null;
    int j = a.n(paramParcel);
    int i = 0;
    String str = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.m(paramParcel);
      switch (a.M(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str = a.m(paramParcel, k);
        break;
      case 3: 
        locala = (es.a)a.a(paramParcel, k, es.a.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ev.b(i, str, locala);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/eu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */