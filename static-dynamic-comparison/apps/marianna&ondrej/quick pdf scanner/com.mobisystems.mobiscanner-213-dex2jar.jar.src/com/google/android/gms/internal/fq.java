package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class fq
  implements Parcelable.Creator<ir.b.b>
{
  static void a(ir.b.b paramb, Parcel paramParcel, int paramInt)
  {
    paramInt = b.k(paramParcel);
    Set localSet = paramb.rI();
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramb.lX());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.c(paramParcel, 2, paramb.getHeight());
    }
    if (localSet.contains(Integer.valueOf(3))) {
      b.a(paramParcel, 3, paramb.getUrl(), true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      b.c(paramParcel, 4, paramb.getWidth());
    }
    b.D(paramParcel, paramInt);
  }
  
  public ir.b.b aR(Parcel paramParcel)
  {
    int i = 0;
    int m = a.j(paramParcel);
    HashSet localHashSet = new HashSet();
    String str = null;
    int j = 0;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.i(paramParcel);
      switch (a.br(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.g(paramParcel, n);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        j = a.g(paramParcel, n);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        str = a.m(paramParcel, n);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4: 
        i = a.g(paramParcel, n);
        localHashSet.add(Integer.valueOf(4));
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new ir.b.b(localHashSet, k, j, str, i);
  }
  
  public ir.b.b[] dl(int paramInt)
  {
    return new ir.b.b[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/fq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */