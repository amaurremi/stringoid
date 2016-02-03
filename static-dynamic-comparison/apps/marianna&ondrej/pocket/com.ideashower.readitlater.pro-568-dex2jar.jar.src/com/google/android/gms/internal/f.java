package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class f
  implements Parcelable.Creator
{
  static void a(bu parambu, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, parambu.a);
    c.a(paramParcel, 2, parambu.b, false);
    c.a(paramParcel, 3, parambu.c, paramInt, false);
    c.a(paramParcel, 4, parambu.d, paramInt, false);
    c.a(paramParcel, 5, parambu.e, false);
    c.a(paramParcel, 6, parambu.f, paramInt, false);
    c.a(paramParcel, 7, parambu.g, paramInt, false);
    c.a(paramParcel, 8, parambu.h, false);
    c.a(paramParcel, 9, parambu.i, false);
    c.a(paramParcel, 10, parambu.j, false);
    c.a(paramParcel, 11, parambu.k, paramInt, false);
    c.a(paramParcel, i);
  }
  
  public bu a(Parcel paramParcel)
  {
    co localco = null;
    int j = a.b(paramParcel);
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
      int k = a.a(paramParcel);
      switch (a.a(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.f(paramParcel, k);
        break;
      case 2: 
        localBundle = a.n(paramParcel, k);
        break;
      case 3: 
        localv = (v)a.a(paramParcel, k, v.CREATOR);
        break;
      case 4: 
        localx = (x)a.a(paramParcel, k, x.CREATOR);
        break;
      case 5: 
        str4 = a.l(paramParcel, k);
        break;
      case 6: 
        localApplicationInfo = (ApplicationInfo)a.a(paramParcel, k, ApplicationInfo.CREATOR);
        break;
      case 7: 
        localPackageInfo = (PackageInfo)a.a(paramParcel, k, PackageInfo.CREATOR);
        break;
      case 8: 
        str3 = a.l(paramParcel, k);
        break;
      case 9: 
        str2 = a.l(paramParcel, k);
        break;
      case 10: 
        str1 = a.l(paramParcel, k);
        break;
      case 11: 
        localco = (co)a.a(paramParcel, k, co.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new b("Overread allowed size end=" + j, paramParcel);
    }
    return new bu(i, localBundle, localv, localx, str4, localApplicationInfo, localPackageInfo, str3, str2, str1, localco);
  }
  
  public bu[] a(int paramInt)
  {
    return new bu[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */