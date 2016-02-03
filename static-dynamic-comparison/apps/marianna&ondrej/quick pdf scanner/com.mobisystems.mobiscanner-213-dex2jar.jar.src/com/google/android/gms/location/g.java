package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;

public class g
  implements Parcelable.Creator<b>
{
  static void a(b paramb, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.b.k(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramb.Uj);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1000, paramb.lX());
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 2, paramb.Uk);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 3, paramb.Ul);
    com.google.android.gms.common.internal.safeparcel.b.D(paramParcel, paramInt);
  }
  
  public b bi(Parcel paramParcel)
  {
    int i = 1;
    int m = a.j(paramParcel);
    int k = 0;
    long l = 0L;
    int j = 1;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.i(paramParcel);
      switch (a.br(n))
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
        l = a.h(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new b(k, j, i, l);
  }
  
  public b[] dO(int paramInt)
  {
    return new b[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/location/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */