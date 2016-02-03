package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class fk
  implements Parcelable.Creator<im>
{
  static void a(im paramim, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    Set localSet = paramim.rI();
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramim.lX());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.a(paramParcel, 2, paramim.rJ(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      b.a(paramParcel, 3, paramim.rK(), true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      b.a(paramParcel, 4, paramim.rL(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      b.a(paramParcel, 5, paramim.rM(), true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      b.a(paramParcel, 6, paramim.rN(), true);
    }
    if (localSet.contains(Integer.valueOf(7))) {
      b.a(paramParcel, 7, paramim.rO(), true);
    }
    if (localSet.contains(Integer.valueOf(8))) {
      b.b(paramParcel, 8, paramim.rP(), true);
    }
    if (localSet.contains(Integer.valueOf(9))) {
      b.c(paramParcel, 9, paramim.rQ());
    }
    if (localSet.contains(Integer.valueOf(10))) {
      b.b(paramParcel, 10, paramim.rR(), true);
    }
    if (localSet.contains(Integer.valueOf(11))) {
      b.a(paramParcel, 11, paramim.rS(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(12))) {
      b.b(paramParcel, 12, paramim.rT(), true);
    }
    if (localSet.contains(Integer.valueOf(13))) {
      b.a(paramParcel, 13, paramim.rU(), true);
    }
    if (localSet.contains(Integer.valueOf(14))) {
      b.a(paramParcel, 14, paramim.rV(), true);
    }
    if (localSet.contains(Integer.valueOf(15))) {
      b.a(paramParcel, 15, paramim.rW(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(17))) {
      b.a(paramParcel, 17, paramim.rY(), true);
    }
    if (localSet.contains(Integer.valueOf(16))) {
      b.a(paramParcel, 16, paramim.rX(), true);
    }
    if (localSet.contains(Integer.valueOf(19))) {
      b.b(paramParcel, 19, paramim.rZ(), true);
    }
    if (localSet.contains(Integer.valueOf(18))) {
      b.a(paramParcel, 18, paramim.oQ(), true);
    }
    if (localSet.contains(Integer.valueOf(21))) {
      b.a(paramParcel, 21, paramim.sb(), true);
    }
    if (localSet.contains(Integer.valueOf(20))) {
      b.a(paramParcel, 20, paramim.sa(), true);
    }
    if (localSet.contains(Integer.valueOf(23))) {
      b.a(paramParcel, 23, paramim.getDescription(), true);
    }
    if (localSet.contains(Integer.valueOf(22))) {
      b.a(paramParcel, 22, paramim.sc(), true);
    }
    if (localSet.contains(Integer.valueOf(25))) {
      b.a(paramParcel, 25, paramim.se(), true);
    }
    if (localSet.contains(Integer.valueOf(24))) {
      b.a(paramParcel, 24, paramim.sd(), true);
    }
    if (localSet.contains(Integer.valueOf(27))) {
      b.a(paramParcel, 27, paramim.sg(), true);
    }
    if (localSet.contains(Integer.valueOf(26))) {
      b.a(paramParcel, 26, paramim.sf(), true);
    }
    if (localSet.contains(Integer.valueOf(29))) {
      b.a(paramParcel, 29, paramim.si(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(28))) {
      b.a(paramParcel, 28, paramim.sh(), true);
    }
    if (localSet.contains(Integer.valueOf(31))) {
      b.a(paramParcel, 31, paramim.sk(), true);
    }
    if (localSet.contains(Integer.valueOf(30))) {
      b.a(paramParcel, 30, paramim.sj(), true);
    }
    if (localSet.contains(Integer.valueOf(34))) {
      b.a(paramParcel, 34, paramim.sm(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(32))) {
      b.a(paramParcel, 32, paramim.getId(), true);
    }
    if (localSet.contains(Integer.valueOf(33))) {
      b.a(paramParcel, 33, paramim.sl(), true);
    }
    if (localSet.contains(Integer.valueOf(38))) {
      b.a(paramParcel, 38, paramim.getLongitude());
    }
    if (localSet.contains(Integer.valueOf(39))) {
      b.a(paramParcel, 39, paramim.getName(), true);
    }
    if (localSet.contains(Integer.valueOf(36))) {
      b.a(paramParcel, 36, paramim.getLatitude());
    }
    if (localSet.contains(Integer.valueOf(37))) {
      b.a(paramParcel, 37, paramim.sn(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(42))) {
      b.a(paramParcel, 42, paramim.sq(), true);
    }
    if (localSet.contains(Integer.valueOf(43))) {
      b.a(paramParcel, 43, paramim.sr(), true);
    }
    if (localSet.contains(Integer.valueOf(40))) {
      b.a(paramParcel, 40, paramim.so(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(41))) {
      b.b(paramParcel, 41, paramim.sp(), true);
    }
    if (localSet.contains(Integer.valueOf(46))) {
      b.a(paramParcel, 46, paramim.st(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(47))) {
      b.a(paramParcel, 47, paramim.su(), true);
    }
    if (localSet.contains(Integer.valueOf(44))) {
      b.a(paramParcel, 44, paramim.getPostalCode(), true);
    }
    if (localSet.contains(Integer.valueOf(45))) {
      b.a(paramParcel, 45, paramim.ss(), true);
    }
    if (localSet.contains(Integer.valueOf(51))) {
      b.a(paramParcel, 51, paramim.sx(), true);
    }
    if (localSet.contains(Integer.valueOf(50))) {
      b.a(paramParcel, 50, paramim.sw(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(49))) {
      b.a(paramParcel, 49, paramim.getText(), true);
    }
    if (localSet.contains(Integer.valueOf(48))) {
      b.a(paramParcel, 48, paramim.sv(), true);
    }
    if (localSet.contains(Integer.valueOf(55))) {
      b.a(paramParcel, 55, paramim.sz(), true);
    }
    if (localSet.contains(Integer.valueOf(54))) {
      b.a(paramParcel, 54, paramim.getUrl(), true);
    }
    if (localSet.contains(Integer.valueOf(53))) {
      b.a(paramParcel, 53, paramim.getType(), true);
    }
    if (localSet.contains(Integer.valueOf(52))) {
      b.a(paramParcel, 52, paramim.sy(), true);
    }
    if (localSet.contains(Integer.valueOf(56))) {
      b.a(paramParcel, 56, paramim.sA(), true);
    }
    b.D(paramParcel, i);
  }
  
  public im aL(Parcel paramParcel)
  {
    int k = a.j(paramParcel);
    HashSet localHashSet = new HashSet();
    int j = 0;
    im localim10 = null;
    ArrayList localArrayList6 = null;
    im localim9 = null;
    String str35 = null;
    String str34 = null;
    String str33 = null;
    ArrayList localArrayList5 = null;
    int i = 0;
    ArrayList localArrayList4 = null;
    im localim8 = null;
    ArrayList localArrayList3 = null;
    String str32 = null;
    String str31 = null;
    im localim7 = null;
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
    im localim6 = null;
    String str18 = null;
    String str17 = null;
    String str16 = null;
    String str15 = null;
    im localim5 = null;
    double d2 = 0.0D;
    im localim4 = null;
    double d1 = 0.0D;
    String str14 = null;
    im localim3 = null;
    ArrayList localArrayList1 = null;
    String str13 = null;
    String str12 = null;
    String str11 = null;
    String str10 = null;
    im localim2 = null;
    String str9 = null;
    String str8 = null;
    String str7 = null;
    im localim1 = null;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.i(paramParcel);
      switch (a.br(m))
      {
      case 35: 
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        j = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        localim10 = (im)a.a(paramParcel, m, im.Qw);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        localArrayList6 = a.y(paramParcel, m);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4: 
        localim9 = (im)a.a(paramParcel, m, im.Qw);
        localHashSet.add(Integer.valueOf(4));
        break;
      case 5: 
        str35 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6: 
        str34 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(6));
        break;
      case 7: 
        str33 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(7));
        break;
      case 8: 
        localArrayList5 = a.c(paramParcel, m, im.Qw);
        localHashSet.add(Integer.valueOf(8));
        break;
      case 9: 
        i = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(9));
        break;
      case 10: 
        localArrayList4 = a.c(paramParcel, m, im.Qw);
        localHashSet.add(Integer.valueOf(10));
        break;
      case 11: 
        localim8 = (im)a.a(paramParcel, m, im.Qw);
        localHashSet.add(Integer.valueOf(11));
        break;
      case 12: 
        localArrayList3 = a.c(paramParcel, m, im.Qw);
        localHashSet.add(Integer.valueOf(12));
        break;
      case 13: 
        str32 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(13));
        break;
      case 14: 
        str31 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(14));
        break;
      case 15: 
        localim7 = (im)a.a(paramParcel, m, im.Qw);
        localHashSet.add(Integer.valueOf(15));
        break;
      case 17: 
        str29 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(17));
        break;
      case 16: 
        str30 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(16));
        break;
      case 19: 
        localArrayList2 = a.c(paramParcel, m, im.Qw);
        localHashSet.add(Integer.valueOf(19));
        break;
      case 18: 
        str28 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(18));
        break;
      case 21: 
        str26 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(21));
        break;
      case 20: 
        str27 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(20));
        break;
      case 23: 
        str24 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(23));
        break;
      case 22: 
        str25 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(22));
        break;
      case 25: 
        str22 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(25));
        break;
      case 24: 
        str23 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(24));
        break;
      case 27: 
        str20 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(27));
        break;
      case 26: 
        str21 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(26));
        break;
      case 29: 
        localim6 = (im)a.a(paramParcel, m, im.Qw);
        localHashSet.add(Integer.valueOf(29));
        break;
      case 28: 
        str19 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(28));
        break;
      case 31: 
        str17 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(31));
        break;
      case 30: 
        str18 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(30));
        break;
      case 34: 
        localim5 = (im)a.a(paramParcel, m, im.Qw);
        localHashSet.add(Integer.valueOf(34));
        break;
      case 32: 
        str16 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(32));
        break;
      case 33: 
        str15 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(33));
        break;
      case 38: 
        d1 = a.k(paramParcel, m);
        localHashSet.add(Integer.valueOf(38));
        break;
      case 39: 
        str14 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(39));
        break;
      case 36: 
        d2 = a.k(paramParcel, m);
        localHashSet.add(Integer.valueOf(36));
        break;
      case 37: 
        localim4 = (im)a.a(paramParcel, m, im.Qw);
        localHashSet.add(Integer.valueOf(37));
        break;
      case 42: 
        str13 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(42));
        break;
      case 43: 
        str12 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(43));
        break;
      case 40: 
        localim3 = (im)a.a(paramParcel, m, im.Qw);
        localHashSet.add(Integer.valueOf(40));
        break;
      case 41: 
        localArrayList1 = a.c(paramParcel, m, im.Qw);
        localHashSet.add(Integer.valueOf(41));
        break;
      case 46: 
        localim2 = (im)a.a(paramParcel, m, im.Qw);
        localHashSet.add(Integer.valueOf(46));
        break;
      case 47: 
        str9 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(47));
        break;
      case 44: 
        str11 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(44));
        break;
      case 45: 
        str10 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(45));
        break;
      case 51: 
        str6 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(51));
        break;
      case 50: 
        localim1 = (im)a.a(paramParcel, m, im.Qw);
        localHashSet.add(Integer.valueOf(50));
        break;
      case 49: 
        str7 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(49));
        break;
      case 48: 
        str8 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(48));
        break;
      case 55: 
        str2 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(55));
        break;
      case 54: 
        str3 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(54));
        break;
      case 53: 
        str4 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(53));
        break;
      case 52: 
        str5 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(52));
        break;
      case 56: 
        str1 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(56));
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new im(localHashSet, j, localim10, localArrayList6, localim9, str35, str34, str33, localArrayList5, i, localArrayList4, localim8, localArrayList3, str32, str31, localim7, str30, str29, str28, localArrayList2, str27, str26, str25, str24, str23, str22, str21, str20, str19, localim6, str18, str17, str16, str15, localim5, d2, localim4, d1, str14, localim3, localArrayList1, str13, str12, str11, str10, localim2, str9, str8, str7, localim1, str6, str5, str4, str3, str2, str1);
  }
  
  public im[] df(int paramInt)
  {
    return new im[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/fk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */