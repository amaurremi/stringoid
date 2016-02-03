package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class bi
  implements Parcelable.Creator<bj>
{
  static void a(bj parambj, Parcel paramParcel, int paramInt)
  {
    paramInt = b.o(paramParcel);
    b.c(paramParcel, 1, parambj.versionCode);
    b.a(paramParcel, 2, parambj.gn, false);
    b.a(paramParcel, 3, parambj.go, false);
    b.a(paramParcel, 4, parambj.mimeType, false);
    b.a(paramParcel, 5, parambj.packageName, false);
    b.a(paramParcel, 6, parambj.gp, false);
    b.a(paramParcel, 7, parambj.gq, false);
    b.a(paramParcel, 8, parambj.gr, false);
    b.D(paramParcel, paramInt);
  }
  
  public bj d(Parcel paramParcel)
  {
    String str1 = null;
    int j = a.n(paramParcel);
    int i = 0;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    String str7 = null;
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
        str7 = a.m(paramParcel, k);
        break;
      case 3: 
        str6 = a.m(paramParcel, k);
        break;
      case 4: 
        str5 = a.m(paramParcel, k);
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
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new bj(i, str7, str6, str5, str4, str3, str2, str1);
  }
  
  public bj[] i(int paramInt)
  {
    return new bj[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */