package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class w
  implements Parcelable.Creator<v>
{
  static void a(v paramv, Parcel paramParcel, int paramInt)
  {
    int i = b.o(paramParcel);
    b.c(paramParcel, 1, paramv.versionCode);
    b.a(paramParcel, 2, paramv.ex);
    b.a(paramParcel, 3, paramv.extras, false);
    b.c(paramParcel, 4, paramv.ey);
    b.a(paramParcel, 5, paramv.ez, false);
    b.a(paramParcel, 6, paramv.eA);
    b.c(paramParcel, 7, paramv.tagForChildDirectedTreatment);
    b.a(paramParcel, 8, paramv.eB);
    b.a(paramParcel, 9, paramv.eC, false);
    b.a(paramParcel, 10, paramv.eD, paramInt, false);
    b.a(paramParcel, 11, paramv.eE, paramInt, false);
    b.D(paramParcel, i);
  }
  
  public v a(Parcel paramParcel)
  {
    int m = a.n(paramParcel);
    int k = 0;
    long l = 0L;
    Bundle localBundle = null;
    int j = 0;
    ArrayList localArrayList = null;
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = false;
    String str = null;
    ai localai = null;
    Location localLocation = null;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.m(paramParcel);
      switch (a.M(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.g(paramParcel, n);
        break;
      case 2: 
        l = a.h(paramParcel, n);
        break;
      case 3: 
        localBundle = a.o(paramParcel, n);
        break;
      case 4: 
        j = a.g(paramParcel, n);
        break;
      case 5: 
        localArrayList = a.y(paramParcel, n);
        break;
      case 6: 
        bool2 = a.c(paramParcel, n);
        break;
      case 7: 
        i = a.g(paramParcel, n);
        break;
      case 8: 
        bool1 = a.c(paramParcel, n);
        break;
      case 9: 
        str = a.m(paramParcel, n);
        break;
      case 10: 
        localai = (ai)a.a(paramParcel, n, ai.CREATOR);
        break;
      case 11: 
        localLocation = (Location)a.a(paramParcel, n, Location.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new v(k, l, localBundle, j, localArrayList, bool2, i, bool1, str, localai, localLocation);
  }
  
  public v[] b(int paramInt)
  {
    return new v[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */