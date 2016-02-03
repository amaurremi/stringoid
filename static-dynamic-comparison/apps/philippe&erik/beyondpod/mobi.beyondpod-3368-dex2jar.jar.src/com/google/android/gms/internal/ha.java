package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ha
  implements Parcelable.Creator<hd.a>
{
  static void a(hd.a parama, Parcel paramParcel, int paramInt)
  {
    paramInt = b.o(paramParcel);
    b.a(paramParcel, 1, parama.eh(), false);
    b.c(paramParcel, 1000, parama.kg);
    b.a(paramParcel, 2, parama.getTag(), false);
    b.a(paramParcel, 3, parama.ei(), false);
    b.c(paramParcel, 4, parama.ej());
    b.D(paramParcel, paramInt);
  }
  
  public hd.a am(Parcel paramParcel)
  {
    int i = 0;
    String str1 = null;
    int k = a.n(paramParcel);
    String str2 = null;
    String str3 = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.m(paramParcel);
      switch (a.M(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        str3 = a.m(paramParcel, m);
        break;
      case 1000: 
        j = a.g(paramParcel, m);
        break;
      case 2: 
        str2 = a.m(paramParcel, m);
        break;
      case 3: 
        str1 = a.m(paramParcel, m);
        break;
      case 4: 
        i = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new hd.a(j, str3, str2, str1, i);
  }
  
  public hd.a[] bb(int paramInt)
  {
    return new hd.a[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/ha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */