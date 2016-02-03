package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class id
  implements Parcelable.Creator<ic>
{
  static void a(ic paramic, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramic.getVersionCode());
    b.b(paramParcel, 2, paramic.fQ(), false);
    b.a(paramParcel, 3, paramic.fR(), false);
    b.G(paramParcel, paramInt);
  }
  
  public ic J(Parcel paramParcel)
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
        localArrayList = a.c(paramParcel, k, ic.a.CREATOR);
        break;
      case 3: 
        str = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ic(i, localArrayList, str);
  }
  
  public ic[] ay(int paramInt)
  {
    return new ic[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/id.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */