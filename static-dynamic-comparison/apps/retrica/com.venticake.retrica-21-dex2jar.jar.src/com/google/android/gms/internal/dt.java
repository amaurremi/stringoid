package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class dt
  implements Parcelable.Creator<ds>
{
  static void a(ds paramds, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramds.versionCode);
    b.a(paramParcel, 2, paramds.pW, false);
    b.a(paramParcel, 3, paramds.pX, paramInt, false);
    b.a(paramParcel, 4, paramds.kT, paramInt, false);
    b.a(paramParcel, 5, paramds.kN, false);
    b.a(paramParcel, 6, paramds.applicationInfo, paramInt, false);
    b.a(paramParcel, 7, paramds.pY, paramInt, false);
    b.a(paramParcel, 8, paramds.pZ, false);
    b.a(paramParcel, 9, paramds.qa, false);
    b.a(paramParcel, 10, paramds.qb, false);
    b.a(paramParcel, 11, paramds.kQ, paramInt, false);
    b.a(paramParcel, 12, paramds.qc, false);
    b.a(paramParcel, 13, paramds.qd, false);
    b.G(paramParcel, i);
  }
  
  public ds h(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int i = 0;
    Bundle localBundle2 = null;
    ai localai = null;
    al localal = null;
    String str5 = null;
    ApplicationInfo localApplicationInfo = null;
    PackageInfo localPackageInfo = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    ev localev = null;
    Bundle localBundle1 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        localBundle2 = a.q(paramParcel, k);
        break;
      case 3: 
        localai = (ai)a.a(paramParcel, k, ai.CREATOR);
        break;
      case 4: 
        localal = (al)a.a(paramParcel, k, al.CREATOR);
        break;
      case 5: 
        str5 = a.o(paramParcel, k);
        break;
      case 6: 
        localApplicationInfo = (ApplicationInfo)a.a(paramParcel, k, ApplicationInfo.CREATOR);
        break;
      case 7: 
        localPackageInfo = (PackageInfo)a.a(paramParcel, k, PackageInfo.CREATOR);
        break;
      case 8: 
        str4 = a.o(paramParcel, k);
        break;
      case 9: 
        str3 = a.o(paramParcel, k);
        break;
      case 10: 
        str2 = a.o(paramParcel, k);
        break;
      case 11: 
        localev = (ev)a.a(paramParcel, k, ev.CREATOR);
        break;
      case 12: 
        localBundle1 = a.q(paramParcel, k);
        break;
      case 13: 
        str1 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ds(i, localBundle2, localai, localal, str5, localApplicationInfo, localPackageInfo, str4, str3, str2, localev, localBundle1, str1);
  }
  
  public ds[] m(int paramInt)
  {
    return new ds[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/dt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */