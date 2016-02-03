package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.HashSet;
import java.util.Set;

public class ci
  implements Parcelable.Creator
{
  static void a(fv.g paramg, Parcel paramParcel, int paramInt)
  {
    paramInt = c.a(paramParcel);
    Set localSet = paramg.e();
    if (localSet.contains(Integer.valueOf(1))) {
      c.a(paramParcel, 1, paramg.f());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      c.a(paramParcel, 2, paramg.g());
    }
    if (localSet.contains(Integer.valueOf(3))) {
      c.a(paramParcel, 3, paramg.h(), true);
    }
    c.a(paramParcel, paramInt);
  }
  
  public fv.g a(Parcel paramParcel)
  {
    boolean bool = false;
    int j = a.b(paramParcel);
    HashSet localHashSet = new HashSet();
    String str = null;
    int i = 0;
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
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        bool = a.c(paramParcel, k);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        str = a.l(paramParcel, k);
        localHashSet.add(Integer.valueOf(3));
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new b("Overread allowed size end=" + j, paramParcel);
    }
    return new fv.g(localHashSet, i, bool, str);
  }
  
  public fv.g[] a(int paramInt)
  {
    return new fv.g[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */