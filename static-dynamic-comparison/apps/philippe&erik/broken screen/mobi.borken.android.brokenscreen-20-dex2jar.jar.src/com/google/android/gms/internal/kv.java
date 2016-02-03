package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class kv
  implements Parcelable.Creator<kt.a>
{
  static void a(kt.a parama, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    Set localSet = parama.kf();
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, parama.getVersionCode());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.c(paramParcel, 2, parama.getMax());
    }
    if (localSet.contains(Integer.valueOf(3))) {
      b.c(paramParcel, 3, parama.getMin());
    }
    b.G(paramParcel, paramInt);
  }
  
  public kt.a bH(Parcel paramParcel)
  {
    int k = 0;
    int m = a.B(paramParcel);
    HashSet localHashSet = new HashSet();
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.A(paramParcel);
      switch (a.ar(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        i = a.g(paramParcel, n);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        j = a.g(paramParcel, n);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        k = a.g(paramParcel, n);
        localHashSet.add(Integer.valueOf(3));
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new kt.a(localHashSet, i, j, k);
  }
  
  public kt.a[] de(int paramInt)
  {
    return new kt.a[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/kv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */