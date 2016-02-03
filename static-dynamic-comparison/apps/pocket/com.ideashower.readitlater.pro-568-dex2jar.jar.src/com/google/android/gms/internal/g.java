package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;

public class g
  implements Parcelable.Creator
{
  static void a(bw parambw, Parcel paramParcel, int paramInt)
  {
    paramInt = c.a(paramParcel);
    c.a(paramParcel, 1, parambw.a);
    c.a(paramParcel, 2, parambw.b, false);
    c.a(paramParcel, 3, parambw.c, false);
    c.a(paramParcel, 4, parambw.d, false);
    c.a(paramParcel, 5, parambw.e);
    c.a(paramParcel, 6, parambw.f, false);
    c.a(paramParcel, 7, parambw.g);
    c.a(paramParcel, 8, parambw.h);
    c.a(paramParcel, 9, parambw.i);
    c.a(paramParcel, 10, parambw.j, false);
    c.a(paramParcel, 11, parambw.k);
    c.a(paramParcel, 12, parambw.l);
    c.a(paramParcel, paramInt);
  }
  
  public bw a(Parcel paramParcel)
  {
    int m = a.b(paramParcel);
    int k = 0;
    String str2 = null;
    String str1 = null;
    ArrayList localArrayList3 = null;
    int j = 0;
    ArrayList localArrayList2 = null;
    long l3 = 0L;
    boolean bool = false;
    long l2 = 0L;
    ArrayList localArrayList1 = null;
    long l1 = 0L;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.a(paramParcel);
      switch (a.a(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.f(paramParcel, n);
        break;
      case 2: 
        str2 = a.l(paramParcel, n);
        break;
      case 3: 
        str1 = a.l(paramParcel, n);
        break;
      case 4: 
        localArrayList3 = a.x(paramParcel, n);
        break;
      case 5: 
        j = a.f(paramParcel, n);
        break;
      case 6: 
        localArrayList2 = a.x(paramParcel, n);
        break;
      case 7: 
        l3 = a.g(paramParcel, n);
        break;
      case 8: 
        bool = a.c(paramParcel, n);
        break;
      case 9: 
        l2 = a.g(paramParcel, n);
        break;
      case 10: 
        localArrayList1 = a.x(paramParcel, n);
        break;
      case 11: 
        l1 = a.g(paramParcel, n);
        break;
      case 12: 
        i = a.f(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new b("Overread allowed size end=" + m, paramParcel);
    }
    return new bw(k, str2, str1, localArrayList3, j, localArrayList2, l3, bool, l2, localArrayList1, l1, i);
  }
  
  public bw[] a(int paramInt)
  {
    return new bw[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */