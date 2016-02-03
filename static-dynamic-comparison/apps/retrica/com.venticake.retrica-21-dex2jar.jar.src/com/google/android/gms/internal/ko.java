package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ko
  implements Parcelable.Creator<kn>
{
  static void a(kn paramkn, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    Set localSet = paramkn.kk();
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramkn.getVersionCode());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.a(paramParcel, 2, paramkn.kl(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      b.a(paramParcel, 3, paramkn.getAdditionalName(), true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      b.a(paramParcel, 4, paramkn.km(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      b.a(paramParcel, 5, paramkn.getAddressCountry(), true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      b.a(paramParcel, 6, paramkn.getAddressLocality(), true);
    }
    if (localSet.contains(Integer.valueOf(7))) {
      b.a(paramParcel, 7, paramkn.getAddressRegion(), true);
    }
    if (localSet.contains(Integer.valueOf(8))) {
      b.b(paramParcel, 8, paramkn.kn(), true);
    }
    if (localSet.contains(Integer.valueOf(9))) {
      b.c(paramParcel, 9, paramkn.getAttendeeCount());
    }
    if (localSet.contains(Integer.valueOf(10))) {
      b.b(paramParcel, 10, paramkn.ko(), true);
    }
    if (localSet.contains(Integer.valueOf(11))) {
      b.a(paramParcel, 11, paramkn.kp(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(12))) {
      b.b(paramParcel, 12, paramkn.kq(), true);
    }
    if (localSet.contains(Integer.valueOf(13))) {
      b.a(paramParcel, 13, paramkn.getBestRating(), true);
    }
    if (localSet.contains(Integer.valueOf(14))) {
      b.a(paramParcel, 14, paramkn.getBirthDate(), true);
    }
    if (localSet.contains(Integer.valueOf(15))) {
      b.a(paramParcel, 15, paramkn.kr(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(17))) {
      b.a(paramParcel, 17, paramkn.getContentSize(), true);
    }
    if (localSet.contains(Integer.valueOf(16))) {
      b.a(paramParcel, 16, paramkn.getCaption(), true);
    }
    if (localSet.contains(Integer.valueOf(19))) {
      b.b(paramParcel, 19, paramkn.ks(), true);
    }
    if (localSet.contains(Integer.valueOf(18))) {
      b.a(paramParcel, 18, paramkn.getContentUrl(), true);
    }
    if (localSet.contains(Integer.valueOf(21))) {
      b.a(paramParcel, 21, paramkn.getDateModified(), true);
    }
    if (localSet.contains(Integer.valueOf(20))) {
      b.a(paramParcel, 20, paramkn.getDateCreated(), true);
    }
    if (localSet.contains(Integer.valueOf(23))) {
      b.a(paramParcel, 23, paramkn.getDescription(), true);
    }
    if (localSet.contains(Integer.valueOf(22))) {
      b.a(paramParcel, 22, paramkn.getDatePublished(), true);
    }
    if (localSet.contains(Integer.valueOf(25))) {
      b.a(paramParcel, 25, paramkn.getEmbedUrl(), true);
    }
    if (localSet.contains(Integer.valueOf(24))) {
      b.a(paramParcel, 24, paramkn.getDuration(), true);
    }
    if (localSet.contains(Integer.valueOf(27))) {
      b.a(paramParcel, 27, paramkn.getFamilyName(), true);
    }
    if (localSet.contains(Integer.valueOf(26))) {
      b.a(paramParcel, 26, paramkn.getEndDate(), true);
    }
    if (localSet.contains(Integer.valueOf(29))) {
      b.a(paramParcel, 29, paramkn.kt(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(28))) {
      b.a(paramParcel, 28, paramkn.getGender(), true);
    }
    if (localSet.contains(Integer.valueOf(31))) {
      b.a(paramParcel, 31, paramkn.getHeight(), true);
    }
    if (localSet.contains(Integer.valueOf(30))) {
      b.a(paramParcel, 30, paramkn.getGivenName(), true);
    }
    if (localSet.contains(Integer.valueOf(34))) {
      b.a(paramParcel, 34, paramkn.ku(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(32))) {
      b.a(paramParcel, 32, paramkn.getId(), true);
    }
    if (localSet.contains(Integer.valueOf(33))) {
      b.a(paramParcel, 33, paramkn.getImage(), true);
    }
    if (localSet.contains(Integer.valueOf(38))) {
      b.a(paramParcel, 38, paramkn.getLongitude());
    }
    if (localSet.contains(Integer.valueOf(39))) {
      b.a(paramParcel, 39, paramkn.getName(), true);
    }
    if (localSet.contains(Integer.valueOf(36))) {
      b.a(paramParcel, 36, paramkn.getLatitude());
    }
    if (localSet.contains(Integer.valueOf(37))) {
      b.a(paramParcel, 37, paramkn.kv(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(42))) {
      b.a(paramParcel, 42, paramkn.getPlayerType(), true);
    }
    if (localSet.contains(Integer.valueOf(43))) {
      b.a(paramParcel, 43, paramkn.getPostOfficeBoxNumber(), true);
    }
    if (localSet.contains(Integer.valueOf(40))) {
      b.a(paramParcel, 40, paramkn.kw(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(41))) {
      b.b(paramParcel, 41, paramkn.kx(), true);
    }
    if (localSet.contains(Integer.valueOf(46))) {
      b.a(paramParcel, 46, paramkn.ky(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(47))) {
      b.a(paramParcel, 47, paramkn.getStartDate(), true);
    }
    if (localSet.contains(Integer.valueOf(44))) {
      b.a(paramParcel, 44, paramkn.getPostalCode(), true);
    }
    if (localSet.contains(Integer.valueOf(45))) {
      b.a(paramParcel, 45, paramkn.getRatingValue(), true);
    }
    if (localSet.contains(Integer.valueOf(51))) {
      b.a(paramParcel, 51, paramkn.getThumbnailUrl(), true);
    }
    if (localSet.contains(Integer.valueOf(50))) {
      b.a(paramParcel, 50, paramkn.kz(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(49))) {
      b.a(paramParcel, 49, paramkn.getText(), true);
    }
    if (localSet.contains(Integer.valueOf(48))) {
      b.a(paramParcel, 48, paramkn.getStreetAddress(), true);
    }
    if (localSet.contains(Integer.valueOf(55))) {
      b.a(paramParcel, 55, paramkn.getWidth(), true);
    }
    if (localSet.contains(Integer.valueOf(54))) {
      b.a(paramParcel, 54, paramkn.getUrl(), true);
    }
    if (localSet.contains(Integer.valueOf(53))) {
      b.a(paramParcel, 53, paramkn.getType(), true);
    }
    if (localSet.contains(Integer.valueOf(52))) {
      b.a(paramParcel, 52, paramkn.getTickerSymbol(), true);
    }
    if (localSet.contains(Integer.valueOf(56))) {
      b.a(paramParcel, 56, paramkn.getWorstRating(), true);
    }
    b.G(paramParcel, i);
  }
  
  public kn bE(Parcel paramParcel)
  {
    int k = a.B(paramParcel);
    HashSet localHashSet = new HashSet();
    int j = 0;
    kn localkn10 = null;
    ArrayList localArrayList6 = null;
    kn localkn9 = null;
    String str35 = null;
    String str34 = null;
    String str33 = null;
    ArrayList localArrayList5 = null;
    int i = 0;
    ArrayList localArrayList4 = null;
    kn localkn8 = null;
    ArrayList localArrayList3 = null;
    String str32 = null;
    String str31 = null;
    kn localkn7 = null;
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
    kn localkn6 = null;
    String str18 = null;
    String str17 = null;
    String str16 = null;
    String str15 = null;
    kn localkn5 = null;
    double d2 = 0.0D;
    kn localkn4 = null;
    double d1 = 0.0D;
    String str14 = null;
    kn localkn3 = null;
    ArrayList localArrayList1 = null;
    String str13 = null;
    String str12 = null;
    String str11 = null;
    String str10 = null;
    kn localkn2 = null;
    String str9 = null;
    String str8 = null;
    String str7 = null;
    kn localkn1 = null;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.A(paramParcel);
      switch (a.ar(m))
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
        localkn10 = (kn)a.a(paramParcel, m, kn.CREATOR);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        localArrayList6 = a.B(paramParcel, m);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4: 
        localkn9 = (kn)a.a(paramParcel, m, kn.CREATOR);
        localHashSet.add(Integer.valueOf(4));
        break;
      case 5: 
        str35 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6: 
        str34 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(6));
        break;
      case 7: 
        str33 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(7));
        break;
      case 8: 
        localArrayList5 = a.c(paramParcel, m, kn.CREATOR);
        localHashSet.add(Integer.valueOf(8));
        break;
      case 9: 
        i = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(9));
        break;
      case 10: 
        localArrayList4 = a.c(paramParcel, m, kn.CREATOR);
        localHashSet.add(Integer.valueOf(10));
        break;
      case 11: 
        localkn8 = (kn)a.a(paramParcel, m, kn.CREATOR);
        localHashSet.add(Integer.valueOf(11));
        break;
      case 12: 
        localArrayList3 = a.c(paramParcel, m, kn.CREATOR);
        localHashSet.add(Integer.valueOf(12));
        break;
      case 13: 
        str32 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(13));
        break;
      case 14: 
        str31 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(14));
        break;
      case 15: 
        localkn7 = (kn)a.a(paramParcel, m, kn.CREATOR);
        localHashSet.add(Integer.valueOf(15));
        break;
      case 17: 
        str29 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(17));
        break;
      case 16: 
        str30 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(16));
        break;
      case 19: 
        localArrayList2 = a.c(paramParcel, m, kn.CREATOR);
        localHashSet.add(Integer.valueOf(19));
        break;
      case 18: 
        str28 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(18));
        break;
      case 21: 
        str26 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(21));
        break;
      case 20: 
        str27 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(20));
        break;
      case 23: 
        str24 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(23));
        break;
      case 22: 
        str25 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(22));
        break;
      case 25: 
        str22 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(25));
        break;
      case 24: 
        str23 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(24));
        break;
      case 27: 
        str20 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(27));
        break;
      case 26: 
        str21 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(26));
        break;
      case 29: 
        localkn6 = (kn)a.a(paramParcel, m, kn.CREATOR);
        localHashSet.add(Integer.valueOf(29));
        break;
      case 28: 
        str19 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(28));
        break;
      case 31: 
        str17 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(31));
        break;
      case 30: 
        str18 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(30));
        break;
      case 34: 
        localkn5 = (kn)a.a(paramParcel, m, kn.CREATOR);
        localHashSet.add(Integer.valueOf(34));
        break;
      case 32: 
        str16 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(32));
        break;
      case 33: 
        str15 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(33));
        break;
      case 38: 
        d1 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(38));
        break;
      case 39: 
        str14 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(39));
        break;
      case 36: 
        d2 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(36));
        break;
      case 37: 
        localkn4 = (kn)a.a(paramParcel, m, kn.CREATOR);
        localHashSet.add(Integer.valueOf(37));
        break;
      case 42: 
        str13 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(42));
        break;
      case 43: 
        str12 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(43));
        break;
      case 40: 
        localkn3 = (kn)a.a(paramParcel, m, kn.CREATOR);
        localHashSet.add(Integer.valueOf(40));
        break;
      case 41: 
        localArrayList1 = a.c(paramParcel, m, kn.CREATOR);
        localHashSet.add(Integer.valueOf(41));
        break;
      case 46: 
        localkn2 = (kn)a.a(paramParcel, m, kn.CREATOR);
        localHashSet.add(Integer.valueOf(46));
        break;
      case 47: 
        str9 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(47));
        break;
      case 44: 
        str11 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(44));
        break;
      case 45: 
        str10 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(45));
        break;
      case 51: 
        str6 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(51));
        break;
      case 50: 
        localkn1 = (kn)a.a(paramParcel, m, kn.CREATOR);
        localHashSet.add(Integer.valueOf(50));
        break;
      case 49: 
        str7 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(49));
        break;
      case 48: 
        str8 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(48));
        break;
      case 55: 
        str2 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(55));
        break;
      case 54: 
        str3 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(54));
        break;
      case 53: 
        str4 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(53));
        break;
      case 52: 
        str5 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(52));
        break;
      case 56: 
        str1 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(56));
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new kn(localHashSet, j, localkn10, localArrayList6, localkn9, str35, str34, str33, localArrayList5, i, localArrayList4, localkn8, localArrayList3, str32, str31, localkn7, str30, str29, str28, localArrayList2, str27, str26, str25, str24, str23, str22, str21, str20, str19, localkn6, str18, str17, str16, str15, localkn5, d2, localkn4, d1, str14, localkn3, localArrayList1, str13, str12, str11, str10, localkn2, str9, str8, str7, localkn1, str6, str5, str4, str3, str2, str1);
  }
  
  public kn[] db(int paramInt)
  {
    return new kn[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ko.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */