package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class iq
  implements Parcelable.Creator<ig.h>
{
  static void a(ig.h paramh, Parcel paramParcel, int paramInt)
  {
    paramInt = b.o(paramParcel);
    Set localSet = paramh.fa();
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramh.getVersionCode());
    }
    if (localSet.contains(Integer.valueOf(3))) {
      b.c(paramParcel, 3, paramh.fN());
    }
    if (localSet.contains(Integer.valueOf(4))) {
      b.a(paramParcel, 4, paramh.getValue(), true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      b.a(paramParcel, 5, paramh.getLabel(), true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      b.c(paramParcel, 6, paramh.getType());
    }
    b.D(paramParcel, paramInt);
  }
  
  public ig.h aD(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int m = a.n(paramParcel);
    HashSet localHashSet = new HashSet();
    int j = 0;
    String str2 = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.m(paramParcel);
      switch (a.M(n))
      {
      case 2: 
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.g(paramParcel, n);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 3: 
        i = a.g(paramParcel, n);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4: 
        str1 = a.m(paramParcel, n);
        localHashSet.add(Integer.valueOf(4));
        break;
      case 5: 
        str2 = a.m(paramParcel, n);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6: 
        j = a.g(paramParcel, n);
        localHashSet.add(Integer.valueOf(6));
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new ig.h(localHashSet, k, str2, j, str1, i);
  }
  
  public ig.h[] bv(int paramInt)
  {
    return new ig.h[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/iq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */