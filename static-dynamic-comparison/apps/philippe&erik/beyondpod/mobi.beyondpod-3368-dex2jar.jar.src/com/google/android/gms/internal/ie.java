package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class ie
  implements Parcelable.Creator<id>
{
  static void a(id paramid, Parcel paramParcel, int paramInt)
  {
    int i = b.o(paramParcel);
    Set localSet = paramid.fa();
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramid.getVersionCode());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.a(paramParcel, 2, paramid.getId(), true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      b.a(paramParcel, 4, paramid.fr(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      b.a(paramParcel, 5, paramid.getStartDate(), true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      b.a(paramParcel, 6, paramid.fs(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(7))) {
      b.a(paramParcel, 7, paramid.getType(), true);
    }
    b.D(paramParcel, i);
  }
  
  public id at(Parcel paramParcel)
  {
    String str1 = null;
    int j = a.n(paramParcel);
    HashSet localHashSet = new HashSet();
    int i = 0;
    ib localib1 = null;
    String str2 = null;
    ib localib2 = null;
    String str3 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.m(paramParcel);
      switch (a.M(k))
      {
      case 3: 
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        str3 = a.m(paramParcel, k);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 4: 
        localib2 = (ib)a.a(paramParcel, k, ib.CREATOR);
        localHashSet.add(Integer.valueOf(4));
        break;
      case 5: 
        str2 = a.m(paramParcel, k);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6: 
        localib1 = (ib)a.a(paramParcel, k, ib.CREATOR);
        localHashSet.add(Integer.valueOf(6));
        break;
      case 7: 
        str1 = a.m(paramParcel, k);
        localHashSet.add(Integer.valueOf(7));
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new id(localHashSet, i, str3, localib2, str2, localib1, str1);
  }
  
  public id[] bl(int paramInt)
  {
    return new id[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/ie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */