package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ax
  implements Parcelable.Creator<aw>
{
  static void a(aw paramaw, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramaw.versionCode);
    b.c(paramParcel, 2, paramaw.mD);
    b.c(paramParcel, 3, paramaw.backgroundColor);
    b.c(paramParcel, 4, paramaw.mE);
    b.c(paramParcel, 5, paramaw.mF);
    b.c(paramParcel, 6, paramaw.mG);
    b.c(paramParcel, 7, paramaw.mH);
    b.c(paramParcel, 8, paramaw.mI);
    b.c(paramParcel, 9, paramaw.mJ);
    b.a(paramParcel, 10, paramaw.mK, false);
    b.c(paramParcel, 11, paramaw.mL);
    b.a(paramParcel, 12, paramaw.mM, false);
    b.c(paramParcel, 13, paramaw.mN);
    b.c(paramParcel, 14, paramaw.mO);
    b.a(paramParcel, 15, paramaw.mP, false);
    b.G(paramParcel, paramInt);
  }
  
  public aw d(Parcel paramParcel)
  {
    int i8 = a.B(paramParcel);
    int i7 = 0;
    int i6 = 0;
    int i5 = 0;
    int i4 = 0;
    int i3 = 0;
    int i2 = 0;
    int i1 = 0;
    int n = 0;
    int m = 0;
    String str3 = null;
    int k = 0;
    String str2 = null;
    int j = 0;
    int i = 0;
    String str1 = null;
    while (paramParcel.dataPosition() < i8)
    {
      int i9 = a.A(paramParcel);
      switch (a.ar(i9))
      {
      default: 
        a.b(paramParcel, i9);
        break;
      case 1: 
        i7 = a.g(paramParcel, i9);
        break;
      case 2: 
        i6 = a.g(paramParcel, i9);
        break;
      case 3: 
        i5 = a.g(paramParcel, i9);
        break;
      case 4: 
        i4 = a.g(paramParcel, i9);
        break;
      case 5: 
        i3 = a.g(paramParcel, i9);
        break;
      case 6: 
        i2 = a.g(paramParcel, i9);
        break;
      case 7: 
        i1 = a.g(paramParcel, i9);
        break;
      case 8: 
        n = a.g(paramParcel, i9);
        break;
      case 9: 
        m = a.g(paramParcel, i9);
        break;
      case 10: 
        str3 = a.o(paramParcel, i9);
        break;
      case 11: 
        k = a.g(paramParcel, i9);
        break;
      case 12: 
        str2 = a.o(paramParcel, i9);
        break;
      case 13: 
        j = a.g(paramParcel, i9);
        break;
      case 14: 
        i = a.g(paramParcel, i9);
        break;
      case 15: 
        str1 = a.o(paramParcel, i9);
      }
    }
    if (paramParcel.dataPosition() != i8) {
      throw new a.a("Overread allowed size end=" + i8, paramParcel);
    }
    return new aw(i7, i6, i5, i4, i3, i2, i1, n, m, str3, k, str2, j, i, str1);
  }
  
  public aw[] f(int paramInt)
  {
    return new aw[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */