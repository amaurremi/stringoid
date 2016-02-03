package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.HashSet;
import java.util.Set;

public class cc
  implements Parcelable.Creator
{
  static void a(fv.b paramb, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    Set localSet = paramb.e();
    if (localSet.contains(Integer.valueOf(1))) {
      c.a(paramParcel, 1, paramb.f());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      c.a(paramParcel, 2, paramb.g(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      c.a(paramParcel, 3, paramb.h(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      c.a(paramParcel, 4, paramb.i());
    }
    c.a(paramParcel, i);
  }
  
  public fv.b a(Parcel paramParcel)
  {
    fv.b.b localb = null;
    int i = 0;
    int k = a.b(paramParcel);
    HashSet localHashSet = new HashSet();
    fv.b.a locala = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.a(paramParcel);
      switch (a.a(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        j = a.f(paramParcel, m);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        locala = (fv.b.a)a.a(paramParcel, m, fv.b.a.CREATOR);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        localb = (fv.b.b)a.a(paramParcel, m, fv.b.b.CREATOR);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4: 
        i = a.f(paramParcel, m);
        localHashSet.add(Integer.valueOf(4));
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new b("Overread allowed size end=" + k, paramParcel);
    }
    return new fv.b(localHashSet, j, locala, localb, i);
  }
  
  public fv.b[] a(int paramInt)
  {
    return new fv.b[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */