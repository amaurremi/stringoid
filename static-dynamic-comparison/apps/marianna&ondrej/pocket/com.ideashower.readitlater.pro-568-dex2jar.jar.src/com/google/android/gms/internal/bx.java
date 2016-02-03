package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class bx
  implements Parcelable.Creator
{
  static void a(fq paramfq, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    Set localSet = paramfq.e();
    if (localSet.contains(Integer.valueOf(1))) {
      c.a(paramParcel, 1, paramfq.f());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      c.a(paramParcel, 2, paramfq.g(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      c.a(paramParcel, 3, paramfq.h(), true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      c.a(paramParcel, 4, paramfq.i(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      c.a(paramParcel, 5, paramfq.j(), true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      c.a(paramParcel, 6, paramfq.k(), true);
    }
    if (localSet.contains(Integer.valueOf(7))) {
      c.a(paramParcel, 7, paramfq.l(), true);
    }
    if (localSet.contains(Integer.valueOf(8))) {
      c.b(paramParcel, 8, paramfq.m(), true);
    }
    if (localSet.contains(Integer.valueOf(9))) {
      c.a(paramParcel, 9, paramfq.n());
    }
    if (localSet.contains(Integer.valueOf(10))) {
      c.b(paramParcel, 10, paramfq.o(), true);
    }
    if (localSet.contains(Integer.valueOf(11))) {
      c.a(paramParcel, 11, paramfq.p(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(12))) {
      c.b(paramParcel, 12, paramfq.q(), true);
    }
    if (localSet.contains(Integer.valueOf(13))) {
      c.a(paramParcel, 13, paramfq.r(), true);
    }
    if (localSet.contains(Integer.valueOf(14))) {
      c.a(paramParcel, 14, paramfq.s(), true);
    }
    if (localSet.contains(Integer.valueOf(15))) {
      c.a(paramParcel, 15, paramfq.t(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(17))) {
      c.a(paramParcel, 17, paramfq.v(), true);
    }
    if (localSet.contains(Integer.valueOf(16))) {
      c.a(paramParcel, 16, paramfq.u(), true);
    }
    if (localSet.contains(Integer.valueOf(19))) {
      c.b(paramParcel, 19, paramfq.x(), true);
    }
    if (localSet.contains(Integer.valueOf(18))) {
      c.a(paramParcel, 18, paramfq.w(), true);
    }
    if (localSet.contains(Integer.valueOf(21))) {
      c.a(paramParcel, 21, paramfq.z(), true);
    }
    if (localSet.contains(Integer.valueOf(20))) {
      c.a(paramParcel, 20, paramfq.y(), true);
    }
    if (localSet.contains(Integer.valueOf(23))) {
      c.a(paramParcel, 23, paramfq.B(), true);
    }
    if (localSet.contains(Integer.valueOf(22))) {
      c.a(paramParcel, 22, paramfq.A(), true);
    }
    if (localSet.contains(Integer.valueOf(25))) {
      c.a(paramParcel, 25, paramfq.D(), true);
    }
    if (localSet.contains(Integer.valueOf(24))) {
      c.a(paramParcel, 24, paramfq.C(), true);
    }
    if (localSet.contains(Integer.valueOf(27))) {
      c.a(paramParcel, 27, paramfq.F(), true);
    }
    if (localSet.contains(Integer.valueOf(26))) {
      c.a(paramParcel, 26, paramfq.E(), true);
    }
    if (localSet.contains(Integer.valueOf(29))) {
      c.a(paramParcel, 29, paramfq.H(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(28))) {
      c.a(paramParcel, 28, paramfq.G(), true);
    }
    if (localSet.contains(Integer.valueOf(31))) {
      c.a(paramParcel, 31, paramfq.J(), true);
    }
    if (localSet.contains(Integer.valueOf(30))) {
      c.a(paramParcel, 30, paramfq.I(), true);
    }
    if (localSet.contains(Integer.valueOf(34))) {
      c.a(paramParcel, 34, paramfq.M(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(32))) {
      c.a(paramParcel, 32, paramfq.K(), true);
    }
    if (localSet.contains(Integer.valueOf(33))) {
      c.a(paramParcel, 33, paramfq.L(), true);
    }
    if (localSet.contains(Integer.valueOf(38))) {
      c.a(paramParcel, 38, paramfq.P());
    }
    if (localSet.contains(Integer.valueOf(39))) {
      c.a(paramParcel, 39, paramfq.Q(), true);
    }
    if (localSet.contains(Integer.valueOf(36))) {
      c.a(paramParcel, 36, paramfq.N());
    }
    if (localSet.contains(Integer.valueOf(37))) {
      c.a(paramParcel, 37, paramfq.O(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(42))) {
      c.a(paramParcel, 42, paramfq.T(), true);
    }
    if (localSet.contains(Integer.valueOf(43))) {
      c.a(paramParcel, 43, paramfq.U(), true);
    }
    if (localSet.contains(Integer.valueOf(40))) {
      c.a(paramParcel, 40, paramfq.R(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(41))) {
      c.b(paramParcel, 41, paramfq.S(), true);
    }
    if (localSet.contains(Integer.valueOf(46))) {
      c.a(paramParcel, 46, paramfq.X(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(47))) {
      c.a(paramParcel, 47, paramfq.Y(), true);
    }
    if (localSet.contains(Integer.valueOf(44))) {
      c.a(paramParcel, 44, paramfq.V(), true);
    }
    if (localSet.contains(Integer.valueOf(45))) {
      c.a(paramParcel, 45, paramfq.W(), true);
    }
    if (localSet.contains(Integer.valueOf(51))) {
      c.a(paramParcel, 51, paramfq.ac(), true);
    }
    if (localSet.contains(Integer.valueOf(50))) {
      c.a(paramParcel, 50, paramfq.ab(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(49))) {
      c.a(paramParcel, 49, paramfq.aa(), true);
    }
    if (localSet.contains(Integer.valueOf(48))) {
      c.a(paramParcel, 48, paramfq.Z(), true);
    }
    if (localSet.contains(Integer.valueOf(55))) {
      c.a(paramParcel, 55, paramfq.ag(), true);
    }
    if (localSet.contains(Integer.valueOf(54))) {
      c.a(paramParcel, 54, paramfq.af(), true);
    }
    if (localSet.contains(Integer.valueOf(53))) {
      c.a(paramParcel, 53, paramfq.ae(), true);
    }
    if (localSet.contains(Integer.valueOf(52))) {
      c.a(paramParcel, 52, paramfq.ad(), true);
    }
    if (localSet.contains(Integer.valueOf(56))) {
      c.a(paramParcel, 56, paramfq.ah(), true);
    }
    c.a(paramParcel, i);
  }
  
  public fq a(Parcel paramParcel)
  {
    int k = a.b(paramParcel);
    HashSet localHashSet = new HashSet();
    int j = 0;
    fq localfq10 = null;
    ArrayList localArrayList6 = null;
    fq localfq9 = null;
    String str35 = null;
    String str34 = null;
    String str33 = null;
    ArrayList localArrayList5 = null;
    int i = 0;
    ArrayList localArrayList4 = null;
    fq localfq8 = null;
    ArrayList localArrayList3 = null;
    String str32 = null;
    String str31 = null;
    fq localfq7 = null;
    String str30 = null;
    String str29 = null;
    String str28 = null;
    ArrayList localArrayList2 = null;
    String str27 = null;
    String str26 = null;
    String str25 = null;
    String str24 = null;
    String str23 = null;
    String str22 = null;
    String str21 = null;
    String str20 = null;
    String str19 = null;
    fq localfq6 = null;
    String str18 = null;
    String str17 = null;
    String str16 = null;
    String str15 = null;
    fq localfq5 = null;
    double d2 = 0.0D;
    fq localfq4 = null;
    double d1 = 0.0D;
    String str14 = null;
    fq localfq3 = null;
    ArrayList localArrayList1 = null;
    String str13 = null;
    String str12 = null;
    String str11 = null;
    String str10 = null;
    fq localfq2 = null;
    String str9 = null;
    String str8 = null;
    String str7 = null;
    fq localfq1 = null;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.a(paramParcel);
      switch (a.a(m))
      {
      case 35: 
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        j = a.f(paramParcel, m);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        localfq10 = (fq)a.a(paramParcel, m, fq.CREATOR);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        localArrayList6 = a.x(paramParcel, m);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4: 
        localfq9 = (fq)a.a(paramParcel, m, fq.CREATOR);
        localHashSet.add(Integer.valueOf(4));
        break;
      case 5: 
        str35 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6: 
        str34 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(6));
        break;
      case 7: 
        str33 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(7));
        break;
      case 8: 
        localArrayList5 = a.c(paramParcel, m, fq.CREATOR);
        localHashSet.add(Integer.valueOf(8));
        break;
      case 9: 
        i = a.f(paramParcel, m);
        localHashSet.add(Integer.valueOf(9));
        break;
      case 10: 
        localArrayList4 = a.c(paramParcel, m, fq.CREATOR);
        localHashSet.add(Integer.valueOf(10));
        break;
      case 11: 
        localfq8 = (fq)a.a(paramParcel, m, fq.CREATOR);
        localHashSet.add(Integer.valueOf(11));
        break;
      case 12: 
        localArrayList3 = a.c(paramParcel, m, fq.CREATOR);
        localHashSet.add(Integer.valueOf(12));
        break;
      case 13: 
        str32 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(13));
        break;
      case 14: 
        str31 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(14));
        break;
      case 15: 
        localfq7 = (fq)a.a(paramParcel, m, fq.CREATOR);
        localHashSet.add(Integer.valueOf(15));
        break;
      case 17: 
        str29 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(17));
        break;
      case 16: 
        str30 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(16));
        break;
      case 19: 
        localArrayList2 = a.c(paramParcel, m, fq.CREATOR);
        localHashSet.add(Integer.valueOf(19));
        break;
      case 18: 
        str28 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(18));
        break;
      case 21: 
        str26 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(21));
        break;
      case 20: 
        str27 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(20));
        break;
      case 23: 
        str24 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(23));
        break;
      case 22: 
        str25 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(22));
        break;
      case 25: 
        str22 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(25));
        break;
      case 24: 
        str23 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(24));
        break;
      case 27: 
        str20 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(27));
        break;
      case 26: 
        str21 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(26));
        break;
      case 29: 
        localfq6 = (fq)a.a(paramParcel, m, fq.CREATOR);
        localHashSet.add(Integer.valueOf(29));
        break;
      case 28: 
        str19 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(28));
        break;
      case 31: 
        str17 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(31));
        break;
      case 30: 
        str18 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(30));
        break;
      case 34: 
        localfq5 = (fq)a.a(paramParcel, m, fq.CREATOR);
        localHashSet.add(Integer.valueOf(34));
        break;
      case 32: 
        str16 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(32));
        break;
      case 33: 
        str15 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(33));
        break;
      case 38: 
        d1 = a.j(paramParcel, m);
        localHashSet.add(Integer.valueOf(38));
        break;
      case 39: 
        str14 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(39));
        break;
      case 36: 
        d2 = a.j(paramParcel, m);
        localHashSet.add(Integer.valueOf(36));
        break;
      case 37: 
        localfq4 = (fq)a.a(paramParcel, m, fq.CREATOR);
        localHashSet.add(Integer.valueOf(37));
        break;
      case 42: 
        str13 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(42));
        break;
      case 43: 
        str12 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(43));
        break;
      case 40: 
        localfq3 = (fq)a.a(paramParcel, m, fq.CREATOR);
        localHashSet.add(Integer.valueOf(40));
        break;
      case 41: 
        localArrayList1 = a.c(paramParcel, m, fq.CREATOR);
        localHashSet.add(Integer.valueOf(41));
        break;
      case 46: 
        localfq2 = (fq)a.a(paramParcel, m, fq.CREATOR);
        localHashSet.add(Integer.valueOf(46));
        break;
      case 47: 
        str9 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(47));
        break;
      case 44: 
        str11 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(44));
        break;
      case 45: 
        str10 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(45));
        break;
      case 51: 
        str6 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(51));
        break;
      case 50: 
        localfq1 = (fq)a.a(paramParcel, m, fq.CREATOR);
        localHashSet.add(Integer.valueOf(50));
        break;
      case 49: 
        str7 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(49));
        break;
      case 48: 
        str8 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(48));
        break;
      case 55: 
        str2 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(55));
        break;
      case 54: 
        str3 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(54));
        break;
      case 53: 
        str4 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(53));
        break;
      case 52: 
        str5 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(52));
        break;
      case 56: 
        str1 = a.l(paramParcel, m);
        localHashSet.add(Integer.valueOf(56));
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new b("Overread allowed size end=" + k, paramParcel);
    }
    return new fq(localHashSet, j, localfq10, localArrayList6, localfq9, str35, str34, str33, localArrayList5, i, localArrayList4, localfq8, localArrayList3, str32, str31, localfq7, str30, str29, str28, localArrayList2, str27, str26, str25, str24, str23, str22, str21, str20, str19, localfq6, str18, str17, str16, str15, localfq5, d2, localfq4, d1, str14, localfq3, localArrayList1, str13, str12, str11, str10, localfq2, str9, str8, str7, localfq1, str6, str5, str4, str3, str2, str1);
  }
  
  public fq[] a(int paramInt)
  {
    return new fq[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */