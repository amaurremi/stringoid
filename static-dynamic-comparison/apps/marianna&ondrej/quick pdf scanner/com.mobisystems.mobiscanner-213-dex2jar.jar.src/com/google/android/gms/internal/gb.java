package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class gb
  implements Parcelable.Creator<jp>
{
  static void a(jp paramjp, Parcel paramParcel, int paramInt)
  {
    paramInt = b.k(paramParcel);
    b.c(paramParcel, 1, paramjp.lX());
    b.a(paramParcel, 2, paramjp.SL, false);
    b.a(paramParcel, 3, paramjp.DL, false);
    b.D(paramParcel, paramInt);
  }
  
  public jp bb(Parcel paramParcel)
  {
    String str2 = null;
    int j = a.j(paramParcel);
    int i = 0;
    String str1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.i(paramParcel);
      switch (a.br(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str1 = a.m(paramParcel, k);
        break;
      case 3: 
        str2 = a.m(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new jp(i, str1, str2);
  }
  
  public jp[] dv(int paramInt)
  {
    return new jp[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/gb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */