package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.HashSet;
import java.util.Set;

public class by
  implements Parcelable.Creator
{
  static void a(fs paramfs, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    Set localSet = paramfs.e();
    if (localSet.contains(Integer.valueOf(1))) {
      c.a(paramParcel, 1, paramfs.f());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      c.a(paramParcel, 2, paramfs.g(), true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      c.a(paramParcel, 4, paramfs.h(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      c.a(paramParcel, 5, paramfs.i(), true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      c.a(paramParcel, 6, paramfs.j(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(7))) {
      c.a(paramParcel, 7, paramfs.k(), true);
    }
    c.a(paramParcel, i);
  }
  
  public fs a(Parcel paramParcel)
  {
    String str1 = null;
    int j = a.b(paramParcel);
    HashSet localHashSet = new HashSet();
    int i = 0;
    fq localfq1 = null;
    String str2 = null;
    fq localfq2 = null;
    String str3 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.a(paramParcel);
      switch (a.a(k))
      {
      case 3: 
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.f(paramParcel, k);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        str3 = a.l(paramParcel, k);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 4: 
        localfq2 = (fq)a.a(paramParcel, k, fq.CREATOR);
        localHashSet.add(Integer.valueOf(4));
        break;
      case 5: 
        str2 = a.l(paramParcel, k);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6: 
        localfq1 = (fq)a.a(paramParcel, k, fq.CREATOR);
        localHashSet.add(Integer.valueOf(6));
        break;
      case 7: 
        str1 = a.l(paramParcel, k);
        localHashSet.add(Integer.valueOf(7));
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new b("Overread allowed size end=" + j, paramParcel);
    }
    return new fs(localHashSet, i, str3, localfq2, str2, localfq1, str1);
  }
  
  public fs[] a(int paramInt)
  {
    return new fs[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */