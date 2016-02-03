package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.HashSet;
import java.util.Set;

public class ce
  implements Parcelable.Creator
{
  static void a(fv.b.b paramb, Parcel paramParcel, int paramInt)
  {
    paramInt = c.a(paramParcel);
    Set localSet = paramb.e();
    if (localSet.contains(Integer.valueOf(1))) {
      c.a(paramParcel, 1, paramb.f());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      c.a(paramParcel, 2, paramb.g());
    }
    if (localSet.contains(Integer.valueOf(3))) {
      c.a(paramParcel, 3, paramb.h(), true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      c.a(paramParcel, 4, paramb.i());
    }
    c.a(paramParcel, paramInt);
  }
  
  public fv.b.b a(Parcel paramParcel)
  {
    int i = 0;
    int m = a.b(paramParcel);
    HashSet localHashSet = new HashSet();
    String str = null;
    int j = 0;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.a(paramParcel);
      switch (a.a(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.f(paramParcel, n);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        j = a.f(paramParcel, n);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        str = a.l(paramParcel, n);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4: 
        i = a.f(paramParcel, n);
        localHashSet.add(Integer.valueOf(4));
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new b("Overread allowed size end=" + m, paramParcel);
    }
    return new fv.b.b(localHashSet, k, j, str, i);
  }
  
  public fv.b.b[] a(int paramInt)
  {
    return new fv.b.b[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */