package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.HashSet;
import java.util.Set;

public class cf
  implements Parcelable.Creator
{
  static void a(fv.c paramc, Parcel paramParcel, int paramInt)
  {
    paramInt = c.a(paramParcel);
    Set localSet = paramc.e();
    if (localSet.contains(Integer.valueOf(1))) {
      c.a(paramParcel, 1, paramc.f());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      c.a(paramParcel, 2, paramc.g(), true);
    }
    c.a(paramParcel, paramInt);
  }
  
  public fv.c a(Parcel paramParcel)
  {
    int j = a.b(paramParcel);
    HashSet localHashSet = new HashSet();
    int i = 0;
    String str = null;
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
        str = a.l(paramParcel, k);
        localHashSet.add(Integer.valueOf(2));
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new b("Overread allowed size end=" + j, paramParcel);
    }
    return new fv.c(localHashSet, i, str);
  }
  
  public fv.c[] a(int paramInt)
  {
    return new fv.c[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */