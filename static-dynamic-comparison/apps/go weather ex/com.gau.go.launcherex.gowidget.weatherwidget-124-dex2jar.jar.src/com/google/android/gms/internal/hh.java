package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class hh
  implements Parcelable.Creator<hg>
{
  static void a(hg paramhg, Parcel paramParcel, int paramInt)
  {
    paramInt = b.p(paramParcel);
    b.b(paramParcel, 1, paramhg.OA, false);
    b.c(paramParcel, 1000, paramhg.xH);
    b.a(paramParcel, 2, paramhg.hW(), false);
    b.a(paramParcel, 3, paramhg.hX());
    b.F(paramParcel, paramInt);
  }
  
  public hg aD(Parcel paramParcel)
  {
    String str = null;
    boolean bool = false;
    int j = a.o(paramParcel);
    ArrayList localArrayList = null;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.n(paramParcel);
      switch (a.R(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        localArrayList = a.c(paramParcel, k, hm.CREATOR);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str = a.n(paramParcel, k);
        break;
      case 3: 
        bool = a.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new hg(i, localArrayList, str, bool);
  }
  
  public hg[] bE(int paramInt)
  {
    return new hg[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/hh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */