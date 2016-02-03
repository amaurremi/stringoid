package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class lh
  implements Parcelable.Creator<lg>
{
  static void a(lg paramlg, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramlg.getVersionCode());
    b.a(paramParcel, 2, paramlg.akd, false);
    b.G(paramParcel, paramInt);
  }
  
  public lg ce(Parcel paramParcel)
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
    return new lg(i, arrayOfInt);
  }
  
  public lg[] dK(int paramInt)
  {
    return new lg[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/lh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */