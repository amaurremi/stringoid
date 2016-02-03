package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class mx
  implements Parcelable.Creator<mw>
{
  static void a(mw parammw, Parcel paramParcel, int paramInt)
  {
    paramInt = b.D(paramParcel);
    b.a(paramParcel, 1, parammw.ahY, false);
    b.c(paramParcel, 1000, parammw.versionCode);
    b.a(paramParcel, 2, parammw.ahZ, false);
    b.a(paramParcel, 3, parammw.Dv, false);
    b.H(paramParcel, paramInt);
  }
  
  public mw cF(Parcel paramParcel)
  {
    String str3 = null;
    int j = a.C(paramParcel);
    int i = 0;
    String str2 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.B(paramParcel);
      switch (a.aD(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        str1 = a.o(paramParcel, k);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str2 = a.o(paramParcel, k);
        break;
      case 3: 
        str3 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new mw(i, str1, str2, str3);
  }
  
  public mw[] eu(int paramInt)
  {
    return new mw[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/mx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */