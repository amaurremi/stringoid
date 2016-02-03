package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.atomic.apps.ringtone.cutter.aa;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public final class bn
  implements Parcelable.Creator
{
  public static cz a(Parcel paramParcel)
  {
    int m = aa.a(paramParcel);
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
      int n = paramParcel.readInt();
      switch (0xFFFF & n)
      {
      case 16: 
      case 17: 
      case 20: 
      default: 
        aa.b(paramParcel, n);
        break;
      case 1: 
        k = aa.d(paramParcel, n);
        break;
      case 2: 
        str6 = aa.f(paramParcel, n);
        break;
      case 3: 
        str5 = aa.f(paramParcel, n);
        break;
      case 4: 
        localArrayList3 = aa.i(paramParcel, n);
        break;
      case 5: 
        j = aa.d(paramParcel, n);
        break;
      case 6: 
        localArrayList2 = aa.i(paramParcel, n);
        break;
      case 7: 
        l4 = aa.e(paramParcel, n);
        break;
      case 8: 
        bool2 = aa.c(paramParcel, n);
        break;
      case 9: 
        l3 = aa.e(paramParcel, n);
        break;
      case 10: 
        localArrayList1 = aa.i(paramParcel, n);
        break;
      case 11: 
        l2 = aa.e(paramParcel, n);
        break;
      case 12: 
        i = aa.d(paramParcel, n);
        break;
      case 13: 
        str4 = aa.f(paramParcel, n);
        break;
      case 14: 
        l1 = aa.e(paramParcel, n);
        break;
      case 15: 
        str3 = aa.f(paramParcel, n);
        break;
      case 19: 
        str2 = aa.f(paramParcel, n);
        break;
      case 18: 
        bool1 = aa.c(paramParcel, n);
        break;
      case 21: 
        str1 = aa.f(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a("Overread allowed size end=" + m, paramParcel);
    }
    return new cz(k, str6, str5, localArrayList3, j, localArrayList2, l4, bool2, l3, localArrayList1, l2, i, str4, l1, str3, bool1, str2, str1);
  }
  
  static void a(cz paramcz, Parcel paramParcel)
  {
    int i = aa.b(paramParcel);
    aa.a(paramParcel, 1, paramcz.a);
    aa.a(paramParcel, 2, paramcz.b, false);
    aa.a(paramParcel, 3, paramcz.c, false);
    aa.a(paramParcel, 4, paramcz.d, false);
    aa.a(paramParcel, 5, paramcz.e);
    aa.a(paramParcel, 6, paramcz.f, false);
    aa.a(paramParcel, 7, paramcz.g);
    aa.a(paramParcel, 8, paramcz.h);
    aa.a(paramParcel, 9, paramcz.i);
    aa.a(paramParcel, 10, paramcz.j, false);
    aa.a(paramParcel, 11, paramcz.k);
    aa.a(paramParcel, 12, paramcz.l);
    aa.a(paramParcel, 13, paramcz.m, false);
    aa.a(paramParcel, 14, paramcz.n);
    aa.a(paramParcel, 15, paramcz.o, false);
    aa.a(paramParcel, 19, paramcz.q, false);
    aa.a(paramParcel, 18, paramcz.p);
    aa.a(paramParcel, 21, paramcz.r, false);
    aa.j(paramParcel, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */