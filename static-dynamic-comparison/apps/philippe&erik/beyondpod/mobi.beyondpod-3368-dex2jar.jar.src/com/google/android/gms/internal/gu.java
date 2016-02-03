package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class gu
  implements Parcelable.Creator<gt>
{
  static void a(gt paramgt, Parcel paramParcel, int paramInt)
  {
    paramInt = b.o(paramParcel);
    b.c(paramParcel, 1, paramgt.dO());
    b.c(paramParcel, 1000, paramgt.kg);
    b.b(paramParcel, 2, paramgt.yg, false);
    b.a(paramParcel, 3, paramgt.dP(), false);
    b.a(paramParcel, 4, paramgt.dQ(), false);
    b.a(paramParcel, 5, paramgt.dR());
    b.D(paramParcel, paramInt);
  }
  
  public gt[] aY(int paramInt)
  {
    return new gt[paramInt];
  }
  
  public gt aj(Parcel paramParcel)
  {
    String str1 = null;
    boolean bool = false;
    int k = a.n(paramParcel);
    String str2 = null;
    ArrayList localArrayList = null;
    int i = 0;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.m(paramParcel);
      switch (a.M(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        i = a.g(paramParcel, m);
        break;
      case 1000: 
        j = a.g(paramParcel, m);
        break;
      case 2: 
        localArrayList = a.c(paramParcel, m, gx.CREATOR);
        break;
      case 3: 
        str2 = a.m(paramParcel, m);
        break;
      case 4: 
        str1 = a.m(paramParcel, m);
        break;
      case 5: 
        bool = a.c(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new gt(j, i, localArrayList, str2, str1, bool);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/gu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */