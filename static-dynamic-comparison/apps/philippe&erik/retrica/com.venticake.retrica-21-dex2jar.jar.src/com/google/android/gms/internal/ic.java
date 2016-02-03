package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class ic
  implements Parcelable.Creator<ib>
{
  static void a(ib paramib, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramib.getVersionCode());
    b.b(paramParcel, 2, paramib.fV(), false);
    b.a(paramParcel, 3, paramib.fW(), false);
    b.G(paramParcel, paramInt);
  }
  
  public ib J(Parcel paramParcel)
  {
    String str = null;
    int j = a.B(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
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
        localArrayList = a.c(paramParcel, k, ib.a.CREATOR);
        break;
      case 3: 
        str = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ib(i, localArrayList, str);
  }
  
  public ib[] ay(int paramInt)
  {
    return new ib[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */