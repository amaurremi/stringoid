package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;

public class av
  implements Parcelable.Creator
{
  static void a(dz paramdz, Parcel paramParcel, int paramInt)
  {
    paramInt = c.a(paramParcel);
    c.a(paramParcel, 1, paramdz.b());
    c.b(paramParcel, 2, paramdz.c(), false);
    c.a(paramParcel, 3, paramdz.d(), false);
    c.a(paramParcel, paramInt);
  }
  
  public dz a(Parcel paramParcel)
  {
    String str = null;
    int j = a.b(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
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
        localArrayList = a.c(paramParcel, k, dz.a.CREATOR);
        break;
      case 3: 
        str = a.l(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new b("Overread allowed size end=" + j, paramParcel);
    }
    return new dz(i, localArrayList, str);
  }
  
  public dz[] a(int paramInt)
  {
    return new dz[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */