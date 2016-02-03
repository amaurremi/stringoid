package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator<h>
{
  static void a(h paramh, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.a(paramParcel, 1, paramh.qk(), false);
    b.c(paramParcel, 1000, paramh.lX());
    b.a(paramParcel, 2, paramh.vv(), false);
    b.a(paramParcel, 3, paramh.vw(), false);
    b.a(paramParcel, 4, paramh.vx(), false);
    b.a(paramParcel, 5, paramh.vy(), false);
    b.a(paramParcel, 6, paramh.vz(), false);
    b.a(paramParcel, 7, paramh.vA(), false);
    b.a(paramParcel, 8, paramh.vB(), false);
    b.a(paramParcel, 9, paramh.vC(), paramInt, false);
    b.D(paramParcel, i);
  }
  
  public h bw(Parcel paramParcel)
  {
    PlusCommonExtras localPlusCommonExtras = null;
    int j = a.j(paramParcel);
    int i = 0;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String[] arrayOfString1 = null;
    String[] arrayOfString2 = null;
    String[] arrayOfString3 = null;
    String str5 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.i(paramParcel);
      switch (a.br(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        str5 = a.m(paramParcel, k);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        arrayOfString3 = a.x(paramParcel, k);
        break;
      case 3: 
        arrayOfString2 = a.x(paramParcel, k);
        break;
      case 4: 
        arrayOfString1 = a.x(paramParcel, k);
        break;
      case 5: 
        str4 = a.m(paramParcel, k);
        break;
      case 6: 
        str3 = a.m(paramParcel, k);
        break;
      case 7: 
        str2 = a.m(paramParcel, k);
        break;
      case 8: 
        str1 = a.m(paramParcel, k);
        break;
      case 9: 
        localPlusCommonExtras = (PlusCommonExtras)a.a(paramParcel, k, PlusCommonExtras.Wd);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new h(i, str5, arrayOfString3, arrayOfString2, arrayOfString1, str4, str3, str2, str1, localPlusCommonExtras);
  }
  
  public h[] ei(int paramInt)
  {
    return new h[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/plus/internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */