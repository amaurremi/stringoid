package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class li
  implements Parcelable.Creator<lh>
{
  static void a(lh paramlh, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramlh.getVersionCode());
    b.a(paramParcel, 2, paramlh.aka, false);
    b.G(paramParcel, paramInt);
  }
  
  public lh ce(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int i = 0;
    int[] arrayOfInt = null;
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
        arrayOfInt = a.u(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new lh(i, arrayOfInt);
  }
  
  public lh[] dK(int paramInt)
  {
    return new lh[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/li.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */