package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ex
  implements Parcelable.Creator<ht>
{
  static void a(ht paramht, Parcel paramParcel, int paramInt)
  {
    paramInt = b.k(paramParcel);
    b.a(paramParcel, 1, paramht.PI, false);
    b.c(paramParcel, 1000, paramht.qh);
    b.D(paramParcel, paramInt);
  }
  
  public ht aG(Parcel paramParcel)
  {
    int j = a.j(paramParcel);
    int i = 0;
    String str = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.i(paramParcel);
      switch (a.br(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        str = a.m(paramParcel, k);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ht(i, str);
  }
  
  public ht[] cZ(int paramInt)
  {
    return new ht[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/ex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */