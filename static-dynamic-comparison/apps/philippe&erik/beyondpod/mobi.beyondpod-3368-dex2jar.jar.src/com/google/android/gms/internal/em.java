package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class em
  implements Parcelable.Creator<el>
{
  static void a(el paramel, Parcel paramParcel, int paramInt)
  {
    paramInt = b.o(paramParcel);
    b.c(paramParcel, 1, paramel.getType());
    b.c(paramParcel, 1000, paramel.getVersionCode());
    b.c(paramParcel, 2, paramel.bY());
    b.a(paramParcel, 3, paramel.bZ(), false);
    b.a(paramParcel, 4, paramel.ca(), false);
    b.a(paramParcel, 5, paramel.getDisplayName(), false);
    b.a(paramParcel, 6, paramel.cb(), false);
    b.a(paramParcel, 7, paramel.getMetadata(), false);
    b.D(paramParcel, paramInt);
  }
  
  public el[] N(int paramInt)
  {
    return new el[paramInt];
  }
  
  public el p(Parcel paramParcel)
  {
    int i = 0;
    Bundle localBundle = null;
    int m = a.n(paramParcel);
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    int j = 0;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.m(paramParcel);
      switch (a.M(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        j = a.g(paramParcel, n);
        break;
      case 1000: 
        k = a.g(paramParcel, n);
        break;
      case 2: 
        i = a.g(paramParcel, n);
        break;
      case 3: 
        str4 = a.m(paramParcel, n);
        break;
      case 4: 
        str3 = a.m(paramParcel, n);
        break;
      case 5: 
        str2 = a.m(paramParcel, n);
        break;
      case 6: 
        str1 = a.m(paramParcel, n);
        break;
      case 7: 
        localBundle = a.o(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new el(k, j, i, str4, str3, str2, str1, localBundle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/em.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */