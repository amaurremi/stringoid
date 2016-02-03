package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.atomic.apps.ringtone.cutter.aa;
import com.google.android.gms.common.internal.safeparcel.a;

public final class bm
  implements Parcelable.Creator
{
  public static cx a(Parcel paramParcel)
  {
    Bundle localBundle1 = null;
    int j = aa.a(paramParcel);
    int i = 0;
    dx localdx = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    PackageInfo localPackageInfo = null;
    ApplicationInfo localApplicationInfo = null;
    String str4 = null;
    ak localak = null;
    ah localah = null;
    Bundle localBundle2 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = paramParcel.readInt();
      switch (0xFFFF & k)
      {
      default: 
        aa.b(paramParcel, k);
        break;
      case 1: 
        i = aa.d(paramParcel, k);
        break;
      case 2: 
        localBundle2 = aa.h(paramParcel, k);
        break;
      case 3: 
        localah = (ah)aa.a(paramParcel, k, ah.CREATOR);
        break;
      case 4: 
        localak = (ak)aa.a(paramParcel, k, ak.CREATOR);
        break;
      case 5: 
        str4 = aa.f(paramParcel, k);
        break;
      case 6: 
        localApplicationInfo = (ApplicationInfo)aa.a(paramParcel, k, ApplicationInfo.CREATOR);
        break;
      case 7: 
        localPackageInfo = (PackageInfo)aa.a(paramParcel, k, PackageInfo.CREATOR);
        break;
      case 8: 
        str3 = aa.f(paramParcel, k);
        break;
      case 9: 
        str2 = aa.f(paramParcel, k);
        break;
      case 10: 
        str1 = aa.f(paramParcel, k);
        break;
      case 11: 
        localdx = (dx)aa.a(paramParcel, k, dx.CREATOR);
        break;
      case 12: 
        localBundle1 = aa.h(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a("Overread allowed size end=" + j, paramParcel);
    }
    return new cx(i, localBundle2, localah, localak, str4, localApplicationInfo, localPackageInfo, str3, str2, str1, localdx, localBundle1);
  }
  
  static void a(cx paramcx, Parcel paramParcel, int paramInt)
  {
    int i = aa.b(paramParcel);
    aa.a(paramParcel, 1, paramcx.a);
    aa.a(paramParcel, 2, paramcx.b, false);
    aa.a(paramParcel, 3, paramcx.c, paramInt, false);
    aa.a(paramParcel, 4, paramcx.d, paramInt, false);
    aa.a(paramParcel, 5, paramcx.e, false);
    aa.a(paramParcel, 6, paramcx.f, paramInt, false);
    aa.a(paramParcel, 7, paramcx.g, paramInt, false);
    aa.a(paramParcel, 8, paramcx.h, false);
    aa.a(paramParcel, 9, paramcx.i, false);
    aa.a(paramParcel, 10, paramcx.j, false);
    aa.a(paramParcel, 11, paramcx.k, paramInt, false);
    aa.a(paramParcel, 12, paramcx.l, false);
    aa.j(paramParcel, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */