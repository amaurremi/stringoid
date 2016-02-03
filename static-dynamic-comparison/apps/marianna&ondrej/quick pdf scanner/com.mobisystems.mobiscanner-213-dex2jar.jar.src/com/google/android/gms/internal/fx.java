package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class fx
  implements Parcelable.Creator<jj>
{
  static void a(jj paramjj, Parcel paramParcel, int paramInt)
  {
    paramInt = b.k(paramParcel);
    b.c(paramParcel, 1, paramjj.lX());
    b.a(paramParcel, 2, paramjj.SA, false);
    b.a(paramParcel, 3, paramjj.SB, false);
    b.b(paramParcel, 4, paramjj.SC, false);
    b.D(paramParcel, paramInt);
  }
  
  public jj aY(Parcel paramParcel)
  {
    String str2 = null;
    int j = a.j(paramParcel);
    int i = 0;
    ArrayList localArrayList = dr.qW();
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
        break;
      case 4: 
        localArrayList = a.c(paramParcel, k, jh.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new jj(i, str1, str2, localArrayList);
  }
  
  public jj[] ds(int paramInt)
  {
    return new jj[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/fx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */