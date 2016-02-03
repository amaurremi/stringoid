package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ii
  implements Parcelable.Creator<ih>
{
  static void a(ih paramih, Parcel paramParcel, int paramInt)
  {
    int i = b.p(paramParcel);
    Set localSet = paramih.ja();
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramih.getVersionCode());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.a(paramParcel, 2, paramih.getAboutMe(), true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      b.a(paramParcel, 3, paramih.jv(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      b.a(paramParcel, 4, paramih.getBirthday(), true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      b.a(paramParcel, 5, paramih.getBraggingRights(), true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      b.c(paramParcel, 6, paramih.getCircledByCount());
    }
    if (localSet.contains(Integer.valueOf(7))) {
      b.a(paramParcel, 7, paramih.jw(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(8))) {
      b.a(paramParcel, 8, paramih.getCurrentLocation(), true);
    }
    if (localSet.contains(Integer.valueOf(9))) {
      b.a(paramParcel, 9, paramih.getDisplayName(), true);
    }
    if (localSet.contains(Integer.valueOf(12))) {
      b.c(paramParcel, 12, paramih.getGender());
    }
    if (localSet.contains(Integer.valueOf(14))) {
      b.a(paramParcel, 14, paramih.getId(), true);
    }
    if (localSet.contains(Integer.valueOf(15))) {
      b.a(paramParcel, 15, paramih.jx(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(16))) {
      b.a(paramParcel, 16, paramih.isPlusUser());
    }
    if (localSet.contains(Integer.valueOf(19))) {
      b.a(paramParcel, 19, paramih.jy(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(18))) {
      b.a(paramParcel, 18, paramih.getLanguage(), true);
    }
    if (localSet.contains(Integer.valueOf(21))) {
      b.c(paramParcel, 21, paramih.getObjectType());
    }
    if (localSet.contains(Integer.valueOf(20))) {
      b.a(paramParcel, 20, paramih.getNickname(), true);
    }
    if (localSet.contains(Integer.valueOf(23))) {
      b.b(paramParcel, 23, paramih.jA(), true);
    }
    if (localSet.contains(Integer.valueOf(22))) {
      b.b(paramParcel, 22, paramih.jz(), true);
    }
    if (localSet.contains(Integer.valueOf(25))) {
      b.c(paramParcel, 25, paramih.getRelationshipStatus());
    }
    if (localSet.contains(Integer.valueOf(24))) {
      b.c(paramParcel, 24, paramih.getPlusOneCount());
    }
    if (localSet.contains(Integer.valueOf(27))) {
      b.a(paramParcel, 27, paramih.getUrl(), true);
    }
    if (localSet.contains(Integer.valueOf(26))) {
      b.a(paramParcel, 26, paramih.getTagline(), true);
    }
    if (localSet.contains(Integer.valueOf(29))) {
      b.a(paramParcel, 29, paramih.isVerified());
    }
    if (localSet.contains(Integer.valueOf(28))) {
      b.b(paramParcel, 28, paramih.jB(), true);
    }
    b.F(paramParcel, i);
  }
  
  public ih aN(Parcel paramParcel)
  {
    int i2 = a.o(paramParcel);
    HashSet localHashSet = new HashSet();
    int i1 = 0;
    String str10 = null;
    ih.a locala = null;
    String str9 = null;
    String str8 = null;
    int n = 0;
    ih.b localb = null;
    String str7 = null;
    String str6 = null;
    int m = 0;
    String str5 = null;
    ih.c localc = null;
    boolean bool2 = false;
    String str4 = null;
    ih.d locald = null;
    String str3 = null;
    int k = 0;
    ArrayList localArrayList3 = null;
    ArrayList localArrayList2 = null;
    int j = 0;
    int i = 0;
    String str2 = null;
    String str1 = null;
    ArrayList localArrayList1 = null;
    boolean bool1 = false;
    while (paramParcel.dataPosition() < i2)
    {
      int i3 = a.n(paramParcel);
      switch (a.R(i3))
      {
      case 10: 
      case 11: 
      case 13: 
      case 17: 
      default: 
        a.b(paramParcel, i3);
        break;
      case 1: 
        i1 = a.g(paramParcel, i3);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        str10 = a.n(paramParcel, i3);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        locala = (ih.a)a.a(paramParcel, i3, ih.a.CREATOR);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4: 
        str9 = a.n(paramParcel, i3);
        localHashSet.add(Integer.valueOf(4));
        break;
      case 5: 
        str8 = a.n(paramParcel, i3);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6: 
        n = a.g(paramParcel, i3);
        localHashSet.add(Integer.valueOf(6));
        break;
      case 7: 
        localb = (ih.b)a.a(paramParcel, i3, ih.b.CREATOR);
        localHashSet.add(Integer.valueOf(7));
        break;
      case 8: 
        str7 = a.n(paramParcel, i3);
        localHashSet.add(Integer.valueOf(8));
        break;
      case 9: 
        str6 = a.n(paramParcel, i3);
        localHashSet.add(Integer.valueOf(9));
        break;
      case 12: 
        m = a.g(paramParcel, i3);
        localHashSet.add(Integer.valueOf(12));
        break;
      case 14: 
        str5 = a.n(paramParcel, i3);
        localHashSet.add(Integer.valueOf(14));
        break;
      case 15: 
        localc = (ih.c)a.a(paramParcel, i3, ih.c.CREATOR);
        localHashSet.add(Integer.valueOf(15));
        break;
      case 16: 
        bool2 = a.c(paramParcel, i3);
        localHashSet.add(Integer.valueOf(16));
        break;
      case 19: 
        locald = (ih.d)a.a(paramParcel, i3, ih.d.CREATOR);
        localHashSet.add(Integer.valueOf(19));
        break;
      case 18: 
        str4 = a.n(paramParcel, i3);
        localHashSet.add(Integer.valueOf(18));
        break;
      case 21: 
        k = a.g(paramParcel, i3);
        localHashSet.add(Integer.valueOf(21));
        break;
      case 20: 
        str3 = a.n(paramParcel, i3);
        localHashSet.add(Integer.valueOf(20));
        break;
      case 23: 
        localArrayList2 = a.c(paramParcel, i3, ih.g.CREATOR);
        localHashSet.add(Integer.valueOf(23));
        break;
      case 22: 
        localArrayList3 = a.c(paramParcel, i3, ih.f.CREATOR);
        localHashSet.add(Integer.valueOf(22));
        break;
      case 25: 
        i = a.g(paramParcel, i3);
        localHashSet.add(Integer.valueOf(25));
        break;
      case 24: 
        j = a.g(paramParcel, i3);
        localHashSet.add(Integer.valueOf(24));
        break;
      case 27: 
        str1 = a.n(paramParcel, i3);
        localHashSet.add(Integer.valueOf(27));
        break;
      case 26: 
        str2 = a.n(paramParcel, i3);
        localHashSet.add(Integer.valueOf(26));
        break;
      case 29: 
        bool1 = a.c(paramParcel, i3);
        localHashSet.add(Integer.valueOf(29));
        break;
      case 28: 
        localArrayList1 = a.c(paramParcel, i3, ih.h.CREATOR);
        localHashSet.add(Integer.valueOf(28));
      }
    }
    if (paramParcel.dataPosition() != i2) {
      throw new a.a("Overread allowed size end=" + i2, paramParcel);
    }
    return new ih(localHashSet, i1, str10, locala, str9, str8, n, localb, str7, str6, m, str5, localc, bool2, str4, locald, str3, k, localArrayList3, localArrayList2, j, i, str2, str1, localArrayList1, bool1);
  }
  
  public ih[] bQ(int paramInt)
  {
    return new ih[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/ii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */