package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class fa
  implements Parcelable.Creator<hx.a>
{
  static void a(hx.a parama, Parcel paramParcel, int paramInt)
  {
    paramInt = b.k(paramParcel);
    b.a(paramParcel, 1, parama.rp(), false);
    b.c(paramParcel, 1000, parama.qh);
    b.a(paramParcel, 2, parama.getTag(), false);
    b.a(paramParcel, 3, parama.rD(), false);
    b.c(paramParcel, 4, parama.rE());
    b.D(paramParcel, paramInt);
  }
  
  public hx.a aH(Parcel paramParcel)
  {
    int i = 0;
    String str1 = null;
    int k = a.j(paramParcel);
    String str2 = null;
    String str3 = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.i(paramParcel);
      switch (a.br(m))
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
    return new hx.a(j, str3, str2, str1, i);
  }
  
  public hx.a[] da(int paramInt)
  {
    return new hx.a[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/fa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */