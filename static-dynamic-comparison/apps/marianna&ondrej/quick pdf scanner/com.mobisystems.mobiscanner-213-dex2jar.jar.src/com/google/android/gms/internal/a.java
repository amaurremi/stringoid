package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class a
  implements Parcelable.Creator<z>
{
  static void a(z paramz, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1, paramz.versionCode);
    b.a(paramParcel, 2, paramz.TL);
    b.a(paramParcel, 3, paramz.extras, false);
    b.c(paramParcel, 4, paramz.TM);
    b.a(paramParcel, 5, paramz.TN, false);
    b.a(paramParcel, 6, paramz.TO);
    b.c(paramParcel, 7, paramz.gU);
    b.a(paramParcel, 8, paramz.TP);
    b.a(paramParcel, 9, paramz.TQ, false);
    b.a(paramParcel, 10, paramz.TR, paramInt, false);
    b.a(paramParcel, 11, paramz.TS, paramInt, false);
    b.a(paramParcel, 12, paramz.TT, false);
    b.D(paramParcel, i);
  }
  
  public z ai(Parcel paramParcel)
  {
    int m = com.google.android.gms.common.internal.safeparcel.a.j(paramParcel);
    int k = 0;
    long l = 0L;
    Bundle localBundle = null;
    int j = 0;
    ArrayList localArrayList = null;
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = false;
    String str2 = null;
    am localam = null;
    Location localLocation = null;
    String str1 = null;
    while (paramParcel.dataPosition() < m)
    {
      int n = com.google.android.gms.common.internal.safeparcel.a.i(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.br(n))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, n);
        break;
      case 1: 
        k = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
        break;
      case 2: 
        l = com.google.android.gms.common.internal.safeparcel.a.h(paramParcel, n);
        break;
      case 3: 
        localBundle = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, n);
        break;
      case 4: 
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
        break;
      case 5: 
        localArrayList = com.google.android.gms.common.internal.safeparcel.a.y(paramParcel, n);
        break;
      case 6: 
        bool2 = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, n);
        break;
      case 7: 
        i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
        break;
      case 8: 
        bool1 = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, n);
        break;
      case 9: 
        str2 = com.google.android.gms.common.internal.safeparcel.a.m(paramParcel, n);
        break;
      case 10: 
        localam = (am)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, n, am.xv);
        break;
      case 11: 
        localLocation = (Location)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, n, Location.CREATOR);
        break;
      case 12: 
        str1 = com.google.android.gms.common.internal.safeparcel.a.m(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new z(k, l, localBundle, j, localArrayList, bool2, i, bool1, str2, localam, localLocation, str1);
  }
  
  public z[] cr(int paramInt)
  {
    return new z[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */