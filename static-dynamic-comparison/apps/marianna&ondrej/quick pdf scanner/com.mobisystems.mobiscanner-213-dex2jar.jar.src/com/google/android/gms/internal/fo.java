package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class fo
  implements Parcelable.Creator<ir.b>
{
  static void a(ir.b paramb, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    Set localSet = paramb.rI();
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramb.lX());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.a(paramParcel, 2, paramb.tb(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      b.a(paramParcel, 3, paramb.tc(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      b.c(paramParcel, 4, paramb.td());
    }
    b.D(paramParcel, i);
  }
  
  public ir.b aP(Parcel paramParcel)
  {
    ir.b.b localb = null;
    int i = 0;
    int k = a.j(paramParcel);
    HashSet localHashSet = new HashSet();
    ir.b.a locala = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.i(paramParcel);
      switch (a.br(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        j = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        locala = (ir.b.a)a.a(paramParcel, m, ir.b.a.RZ);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        localb = (ir.b.b)a.a(paramParcel, m, ir.b.b.Sc);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4: 
        i = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(4));
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new ir.b(localHashSet, j, locala, localb, i);
  }
  
  public ir.b[] dj(int paramInt)
  {
    return new ir.b[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/fo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */