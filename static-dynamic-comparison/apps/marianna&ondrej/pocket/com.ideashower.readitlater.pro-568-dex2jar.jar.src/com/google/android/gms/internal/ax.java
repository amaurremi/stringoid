package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class ax
  implements Parcelable.Creator
{
  static void a(ec paramec, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramec.a());
    c.a(paramParcel, 2, paramec.e(), false);
    c.a(paramParcel, 3, paramec.f(), paramInt, false);
    c.a(paramParcel, i);
  }
  
  public ec a(Parcel paramParcel)
  {
    dz localdz = null;
    int j = a.b(paramParcel);
    int i = 0;
    Parcel localParcel = null;
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
        break;
      case 2: 
        localParcel = a.y(paramParcel, k);
        break;
      case 3: 
        localdz = (dz)a.a(paramParcel, k, dz.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new b("Overread allowed size end=" + j, paramParcel);
    }
    return new ec(i, localParcel, localdz);
  }
  
  public ec[] a(int paramInt)
  {
    return new ec[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */