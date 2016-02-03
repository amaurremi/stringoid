package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class im
  implements Parcelable.Creator<ig.c>
{
  static void a(ig.c paramc, Parcel paramParcel, int paramInt)
  {
    paramInt = b.o(paramParcel);
    Set localSet = paramc.fa();
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramc.getVersionCode());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.a(paramParcel, 2, paramc.getUrl(), true);
    }
    b.D(paramParcel, paramInt);
  }
  
  public ig.c az(Parcel paramParcel)
  {
    int j = a.n(paramParcel);
    HashSet localHashSet = new HashSet();
    int i = 0;
    String str = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.m(paramParcel);
      switch (a.M(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        str = a.m(paramParcel, k);
        localHashSet.add(Integer.valueOf(2));
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ig.c(localHashSet, i, str);
  }
  
  public ig.c[] br(int paramInt)
  {
    return new ig.c[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/im.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */