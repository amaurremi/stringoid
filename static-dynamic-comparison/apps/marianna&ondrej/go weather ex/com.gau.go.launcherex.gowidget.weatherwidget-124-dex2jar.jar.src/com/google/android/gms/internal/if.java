package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class if
  implements Parcelable.Creator<ie>
{
  static void a(ie paramie, Parcel paramParcel, int paramInt)
  {
    int i = b.p(paramParcel);
    Set localSet = paramie.ja();
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramie.getVersionCode());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.a(paramParcel, 2, paramie.getId(), true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      b.a(paramParcel, 4, paramie.jr(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      b.a(paramParcel, 5, paramie.getStartDate(), true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      b.a(paramParcel, 6, paramie.js(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(7))) {
      b.a(paramParcel, 7, paramie.getType(), true);
    }
    b.F(paramParcel, i);
  }
  
  public ie aM(Parcel paramParcel)
  {
    String str1 = null;
    int j = a.o(paramParcel);
    HashSet localHashSet = new HashSet();
    int i = 0;
    ic localic1 = null;
    String str2 = null;
    ic localic2 = null;
    String str3 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.n(paramParcel);
      switch (a.R(k))
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
        str3 = a.n(paramParcel, k);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 4: 
        localic2 = (ic)a.a(paramParcel, k, ic.CREATOR);
        localHashSet.add(Integer.valueOf(4));
        break;
      case 5: 
        str2 = a.n(paramParcel, k);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6: 
        localic1 = (ic)a.a(paramParcel, k, ic.CREATOR);
        localHashSet.add(Integer.valueOf(6));
        break;
      case 7: 
        str1 = a.n(paramParcel, k);
        localHashSet.add(Integer.valueOf(7));
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ie(localHashSet, i, str3, localic2, str2, localic1, str1);
  }
  
  public ie[] bP(int paramInt)
  {
    return new ie[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/if.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */