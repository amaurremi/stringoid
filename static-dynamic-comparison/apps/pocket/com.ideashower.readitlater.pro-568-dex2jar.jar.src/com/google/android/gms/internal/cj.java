package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.HashSet;
import java.util.Set;

public class cj
  implements Parcelable.Creator
{
  static void a(fv.h paramh, Parcel paramParcel, int paramInt)
  {
    paramInt = c.a(paramParcel);
    Set localSet = paramh.e();
    if (localSet.contains(Integer.valueOf(1))) {
      c.a(paramParcel, 1, paramh.f());
    }
    if (localSet.contains(Integer.valueOf(3))) {
      c.a(paramParcel, 3, paramh.h());
    }
    if (localSet.contains(Integer.valueOf(4))) {
      c.a(paramParcel, 4, paramh.j(), true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      c.a(paramParcel, 5, paramh.g(), true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      c.a(paramParcel, 6, paramh.i());
    }
    c.a(paramParcel, paramInt);
  }
  
  public fv.h a(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int m = a.b(paramParcel);
    HashSet localHashSet = new HashSet();
    int j = 0;
    String str2 = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.a(paramParcel);
      switch (a.a(n))
      {
      case 2: 
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.f(paramParcel, n);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 3: 
        i = a.f(paramParcel, n);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4: 
        str1 = a.l(paramParcel, n);
        localHashSet.add(Integer.valueOf(4));
        break;
      case 5: 
        str2 = a.l(paramParcel, n);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6: 
        j = a.f(paramParcel, n);
        localHashSet.add(Integer.valueOf(6));
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new b("Overread allowed size end=" + m, paramParcel);
    }
    return new fv.h(localHashSet, k, str2, j, str1, i);
  }
  
  public fv.h[] a(int paramInt)
  {
    return new fv.h[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */