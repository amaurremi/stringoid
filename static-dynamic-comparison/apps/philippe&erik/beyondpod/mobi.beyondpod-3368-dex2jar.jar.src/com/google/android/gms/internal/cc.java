package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class cc
  implements Parcelable.Creator<cb>
{
  static void a(cb paramcb, Parcel paramParcel, int paramInt)
  {
    paramInt = b.o(paramParcel);
    b.c(paramParcel, 1, paramcb.versionCode);
    b.a(paramParcel, 2, paramcb.gL, false);
    b.a(paramParcel, 3, paramcb.hw, false);
    b.a(paramParcel, 4, paramcb.fK, false);
    b.c(paramParcel, 5, paramcb.errorCode);
    b.a(paramParcel, 6, paramcb.fL, false);
    b.a(paramParcel, 7, paramcb.hx);
    b.a(paramParcel, 8, paramcb.hy);
    b.a(paramParcel, 9, paramcb.hz);
    b.a(paramParcel, 10, paramcb.hA, false);
    b.a(paramParcel, 11, paramcb.fO);
    b.c(paramParcel, 12, paramcb.orientation);
    b.a(paramParcel, 13, paramcb.hB, false);
    b.D(paramParcel, paramInt);
  }
  
  public cb g(Parcel paramParcel)
  {
    int m = a.n(paramParcel);
    int k = 0;
    String str3 = null;
    String str2 = null;
    ArrayList localArrayList3 = null;
    int j = 0;
    ArrayList localArrayList2 = null;
    long l3 = 0L;
    boolean bool = false;
    long l2 = 0L;
    ArrayList localArrayList1 = null;
    long l1 = 0L;
    int i = 0;
    String str1 = null;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.m(paramParcel);
      switch (a.M(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.g(paramParcel, n);
        break;
      case 2: 
        str3 = a.m(paramParcel, n);
        break;
      case 3: 
        str2 = a.m(paramParcel, n);
        break;
      case 4: 
        localArrayList3 = a.y(paramParcel, n);
        break;
      case 5: 
        j = a.g(paramParcel, n);
        break;
      case 6: 
        localArrayList2 = a.y(paramParcel, n);
        break;
      case 7: 
        l3 = a.h(paramParcel, n);
        break;
      case 8: 
        bool = a.c(paramParcel, n);
        break;
      case 9: 
        l2 = a.h(paramParcel, n);
        break;
      case 10: 
        localArrayList1 = a.y(paramParcel, n);
        break;
      case 11: 
        l1 = a.h(paramParcel, n);
        break;
      case 12: 
        i = a.g(paramParcel, n);
        break;
      case 13: 
        str1 = a.m(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new cb(k, str3, str2, localArrayList3, j, localArrayList2, l3, bool, l2, localArrayList1, l1, i, str1);
  }
  
  public cb[] l(int paramInt)
  {
    return new cb[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */