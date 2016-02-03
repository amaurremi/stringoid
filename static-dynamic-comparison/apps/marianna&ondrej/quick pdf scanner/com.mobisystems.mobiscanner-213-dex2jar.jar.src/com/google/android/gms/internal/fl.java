package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class fl
  implements Parcelable.Creator<io>
{
  static void a(io paramio, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    Set localSet = paramio.rI();
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramio.lX());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.a(paramParcel, 2, paramio.getId(), true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      b.a(paramParcel, 4, paramio.sC(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      b.a(paramParcel, 5, paramio.su(), true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      b.a(paramParcel, 6, paramio.sD(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(7))) {
      b.a(paramParcel, 7, paramio.getType(), true);
    }
    b.D(paramParcel, i);
  }
  
  public io aM(Parcel paramParcel)
  {
    String str1 = null;
    int j = a.j(paramParcel);
    HashSet localHashSet = new HashSet();
    int i = 0;
    im localim1 = null;
    String str2 = null;
    im localim2 = null;
    String str3 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.i(paramParcel);
      switch (a.br(k))
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
        localim2 = (im)a.a(paramParcel, k, im.Qw);
        localHashSet.add(Integer.valueOf(4));
        break;
      case 5: 
        str2 = a.m(paramParcel, k);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6: 
        localim1 = (im)a.a(paramParcel, k, im.Qw);
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
    return new io(localHashSet, i, str3, localim2, str2, localim1, str1);
  }
  
  public io[] dg(int paramInt)
  {
    return new io[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/fl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */