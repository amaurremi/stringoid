package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class kw
  implements Parcelable.Creator<kt.b>
{
  static void a(kt.b paramb, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    Set localSet = paramb.kf();
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramb.getVersionCode());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.a(paramParcel, 2, paramb.kJ(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      b.a(paramParcel, 3, paramb.kK(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      b.c(paramParcel, 4, paramb.getLayout());
    }
    b.G(paramParcel, i);
  }
  
  public kt.b bI(Parcel paramParcel)
  {
    kt.b.b localb = null;
    int i = 0;
    int k = a.B(paramParcel);
    HashSet localHashSet = new HashSet();
    kt.b.a locala = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.A(paramParcel);
      switch (a.ar(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        j = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        locala = (kt.b.a)a.a(paramParcel, m, kt.b.a.CREATOR);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        localb = (kt.b.b)a.a(paramParcel, m, kt.b.b.CREATOR);
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
    return new kt.b(localHashSet, j, locala, localb, i);
  }
  
  public kt.b[] df(int paramInt)
  {
    return new kt.b[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/kw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */