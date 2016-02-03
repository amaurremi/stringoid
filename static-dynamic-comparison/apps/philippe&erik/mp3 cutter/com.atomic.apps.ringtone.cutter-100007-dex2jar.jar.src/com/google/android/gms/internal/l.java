package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.atomic.apps.ringtone.cutter.aa;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public final class l
  implements Parcelable.Creator
{
  public static ah a(Parcel paramParcel)
  {
    int m = aa.a(paramParcel);
    int k = 0;
    long l = 0L;
    Bundle localBundle = null;
    int j = 0;
    ArrayList localArrayList = null;
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = false;
    String str2 = null;
    av localav = null;
    Location localLocation = null;
    String str1 = null;
    while (paramParcel.dataPosition() < m)
    {
      int n = paramParcel.readInt();
      switch (0xFFFF & n)
      {
      default: 
        aa.b(paramParcel, n);
        break;
      case 1: 
        k = aa.d(paramParcel, n);
        break;
      case 2: 
        l = aa.e(paramParcel, n);
        break;
      case 3: 
        localBundle = aa.h(paramParcel, n);
        break;
      case 4: 
        j = aa.d(paramParcel, n);
        break;
      case 5: 
        localArrayList = aa.i(paramParcel, n);
        break;
      case 6: 
        bool2 = aa.c(paramParcel, n);
        break;
      case 7: 
        i = aa.d(paramParcel, n);
        break;
      case 8: 
        bool1 = aa.c(paramParcel, n);
        break;
      case 9: 
        str2 = aa.f(paramParcel, n);
        break;
      case 10: 
        localav = (av)aa.a(paramParcel, n, av.CREATOR);
        break;
      case 11: 
        localLocation = (Location)aa.a(paramParcel, n, Location.CREATOR);
        break;
      case 12: 
        str1 = aa.f(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a("Overread allowed size end=" + m, paramParcel);
    }
    return new ah(k, l, localBundle, j, localArrayList, bool2, i, bool1, str2, localav, localLocation, str1);
  }
  
  static void a(ah paramah, Parcel paramParcel, int paramInt)
  {
    int i = aa.b(paramParcel);
    aa.a(paramParcel, 1, paramah.a);
    aa.a(paramParcel, 2, paramah.b);
    aa.a(paramParcel, 3, paramah.c, false);
    aa.a(paramParcel, 4, paramah.d);
    aa.a(paramParcel, 5, paramah.e, false);
    aa.a(paramParcel, 6, paramah.f);
    aa.a(paramParcel, 7, paramah.g);
    aa.a(paramParcel, 8, paramah.h);
    aa.a(paramParcel, 9, paramah.i, false);
    aa.a(paramParcel, 10, paramah.j, paramInt, false);
    aa.a(paramParcel, 11, paramah.k, paramInt, false);
    aa.a(paramParcel, 12, paramah.l, false);
    aa.j(paramParcel, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */