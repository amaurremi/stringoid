package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ca
  implements Parcelable.Creator<bz>
{
  static void a(bz parambz, Parcel paramParcel, int paramInt)
  {
    int i = b.o(paramParcel);
    b.c(paramParcel, 1, parambz.versionCode);
    b.a(paramParcel, 2, parambz.hq, false);
    b.a(paramParcel, 3, parambz.hr, paramInt, false);
    b.a(paramParcel, 4, parambz.em, paramInt, false);
    b.a(paramParcel, 5, parambz.adUnitId, false);
    b.a(paramParcel, 6, parambz.applicationInfo, paramInt, false);
    b.a(paramParcel, 7, parambz.hs, paramInt, false);
    b.a(paramParcel, 8, parambz.ht, false);
    b.a(paramParcel, 9, parambz.hu, false);
    b.a(paramParcel, 10, parambz.hv, false);
    b.a(paramParcel, 11, parambz.ej, paramInt, false);
    b.D(paramParcel, i);
  }
  
  public bz f(Parcel paramParcel)
  {
    cu localcu = null;
    int j = a.n(paramParcel);
    int i = 0;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    PackageInfo localPackageInfo = null;
    ApplicationInfo localApplicationInfo = null;
    String str4 = null;
    x localx = null;
    v localv = null;
    Bundle localBundle = null;
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
        localBundle = a.o(paramParcel, k);
        break;
      case 3: 
        localv = (v)a.a(paramParcel, k, v.CREATOR);
        break;
      case 4: 
        localx = (x)a.a(paramParcel, k, x.CREATOR);
        break;
      case 5: 
        str4 = a.m(paramParcel, k);
        break;
      case 6: 
        localApplicationInfo = (ApplicationInfo)a.a(paramParcel, k, ApplicationInfo.CREATOR);
        break;
      case 7: 
        localPackageInfo = (PackageInfo)a.a(paramParcel, k, PackageInfo.CREATOR);
        break;
      case 8: 
        str3 = a.m(paramParcel, k);
        break;
      case 9: 
        str2 = a.m(paramParcel, k);
        break;
      case 10: 
        str1 = a.m(paramParcel, k);
        break;
      case 11: 
        localcu = (cu)a.a(paramParcel, k, cu.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new bz(i, localBundle, localv, localx, str4, localApplicationInfo, localPackageInfo, str3, str2, str1, localcu);
  }
  
  public bz[] k(int paramInt)
  {
    return new bz[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */