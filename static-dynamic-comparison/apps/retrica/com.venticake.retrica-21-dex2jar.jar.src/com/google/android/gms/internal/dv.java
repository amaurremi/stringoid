package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class dv
  implements Parcelable.Creator<du>
{
  static void a(du paramdu, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramdu.versionCode);
    b.a(paramParcel, 2, paramdu.oA, false);
    b.a(paramParcel, 3, paramdu.qe, false);
    b.a(paramParcel, 4, paramdu.nt, false);
    b.c(paramParcel, 5, paramdu.errorCode);
    b.a(paramParcel, 6, paramdu.nu, false);
    b.a(paramParcel, 7, paramdu.qf);
    b.a(paramParcel, 8, paramdu.qg);
    b.a(paramParcel, 9, paramdu.qh);
    b.a(paramParcel, 10, paramdu.qi, false);
    b.a(paramParcel, 11, paramdu.nx);
    b.c(paramParcel, 12, paramdu.orientation);
    b.a(paramParcel, 13, paramdu.qj, false);
    b.a(paramParcel, 14, paramdu.qk);
    b.a(paramParcel, 15, paramdu.ql, false);
    b.a(paramParcel, 19, paramdu.qn, false);
    b.a(paramParcel, 18, paramdu.qm);
    b.a(paramParcel, 21, paramdu.qo, false);
    b.G(paramParcel, paramInt);
  }
  
  public du i(Parcel paramParcel)
  {
    int m = a.B(paramParcel);
    int k = 0;
    String str6 = null;
    String str5 = null;
    ArrayList localArrayList3 = null;
    int j = 0;
    ArrayList localArrayList2 = null;
    long l4 = 0L;
    boolean bool2 = false;
    long l3 = 0L;
    ArrayList localArrayList1 = null;
    long l2 = 0L;
    int i = 0;
    String str4 = null;
    long l1 = 0L;
    String str3 = null;
    boolean bool1 = false;
    String str2 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.A(paramParcel);
      switch (a.ar(n))
      {
      case 16: 
      case 17: 
      case 20: 
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.g(paramParcel, n);
        break;
      case 2: 
        str6 = a.o(paramParcel, n);
        break;
      case 3: 
        str5 = a.o(paramParcel, n);
        break;
      case 4: 
        localArrayList3 = a.B(paramParcel, n);
        break;
      case 5: 
        j = a.g(paramParcel, n);
        break;
      case 6: 
        localArrayList2 = a.B(paramParcel, n);
        break;
      case 7: 
        l4 = a.i(paramParcel, n);
        break;
      case 8: 
        bool2 = a.c(paramParcel, n);
        break;
      case 9: 
        l3 = a.i(paramParcel, n);
        break;
      case 10: 
        localArrayList1 = a.B(paramParcel, n);
        break;
      case 11: 
        l2 = a.i(paramParcel, n);
        break;
      case 12: 
        i = a.g(paramParcel, n);
        break;
      case 13: 
        str4 = a.o(paramParcel, n);
        break;
      case 14: 
        l1 = a.i(paramParcel, n);
        break;
      case 15: 
        str3 = a.o(paramParcel, n);
        break;
      case 19: 
        str2 = a.o(paramParcel, n);
        break;
      case 18: 
        bool1 = a.c(paramParcel, n);
        break;
      case 21: 
        str1 = a.o(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new du(k, str6, str5, localArrayList3, j, localArrayList2, l4, bool2, l3, localArrayList1, l2, i, str4, l1, str3, bool1, str2, str1);
  }
  
  public du[] n(int paramInt)
  {
    return new du[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/dv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */