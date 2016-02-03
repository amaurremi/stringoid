package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ig
  implements Parcelable.Creator<if>
{
  static void a(if paramif, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramif.getVersionCode());
    b.a(paramParcel, 2, paramif.fT(), false);
    b.a(paramParcel, 3, paramif.fU(), paramInt, false);
    b.G(paramParcel, i);
  }
  
  public if L(Parcel paramParcel)
  {
    ic localic = null;
    int j = a.B(paramParcel);
    int i = 0;
    Parcel localParcel = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        localParcel = a.C(paramParcel, k);
        break;
      case 3: 
        localic = (ic)a.a(paramParcel, k, ic.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new if(i, localParcel, localic);
  }
  
  public if[] aA(int paramInt)
  {
    return new if[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */