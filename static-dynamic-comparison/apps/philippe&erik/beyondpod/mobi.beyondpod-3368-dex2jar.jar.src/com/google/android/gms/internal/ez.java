package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ez
  implements Parcelable.Creator<ey>
{
  static void a(ey paramey, Parcel paramParcel, int paramInt)
  {
    int i = b.o(paramParcel);
    b.c(paramParcel, 1, paramey.getVersionCode());
    b.a(paramParcel, 2, paramey.cB(), false);
    b.a(paramParcel, 3, paramey.cC(), paramInt, false);
    b.D(paramParcel, i);
  }
  
  public ey[] V(int paramInt)
  {
    return new ey[paramInt];
  }
  
  public ey x(Parcel paramParcel)
  {
    ev localev = null;
    int j = a.n(paramParcel);
    int i = 0;
    Parcel localParcel = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.m(paramParcel);
      switch (a.M(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        localParcel = a.z(paramParcel, k);
        break;
      case 3: 
        localev = (ev)a.a(paramParcel, k, ev.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ey(i, localParcel, localev);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/ez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */