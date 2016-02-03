package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class fu
  implements Parcelable.Creator<ir.g>
{
  static void a(ir.g paramg, Parcel paramParcel, int paramInt)
  {
    paramInt = b.k(paramParcel);
    Set localSet = paramg.rI();
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramg.lX());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.a(paramParcel, 2, paramg.tq());
    }
    if (localSet.contains(Integer.valueOf(3))) {
      b.a(paramParcel, 3, paramg.getValue(), true);
    }
    b.D(paramParcel, paramInt);
  }
  
  public ir.g aV(Parcel paramParcel)
  {
    boolean bool = false;
    int j = a.j(paramParcel);
    HashSet localHashSet = new HashSet();
    String str = null;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.i(paramParcel);
      switch (a.br(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        bool = a.c(paramParcel, k);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        str = a.m(paramParcel, k);
        localHashSet.add(Integer.valueOf(3));
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ir.g(localHashSet, i, bool, str);
  }
  
  public ir.g[] dp(int paramInt)
  {
    return new ir.g[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/fu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */