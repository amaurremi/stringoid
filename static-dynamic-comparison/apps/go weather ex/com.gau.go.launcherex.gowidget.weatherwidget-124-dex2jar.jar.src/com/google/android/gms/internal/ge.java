package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class ge
  implements Parcelable.Creator<gd>
{
  static void a(gd paramgd, Parcel paramParcel, int paramInt)
  {
    paramInt = b.p(paramParcel);
    b.c(paramParcel, 1, paramgd.getVersionCode());
    b.b(paramParcel, 2, paramgd.fn(), false);
    b.a(paramParcel, 3, paramgd.fo(), false);
    b.F(paramParcel, paramInt);
  }
  
  public gd[] X(int paramInt)
  {
    return new gd[paramInt];
  }
  
  public gd v(Parcel paramParcel)
  {
    String str = null;
    int j = a.o(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.n(paramParcel);
      switch (a.R(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        localArrayList = a.c(paramParcel, k, gd.a.CREATOR);
        break;
      case 3: 
        str = a.n(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new gd(i, localArrayList, str);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/ge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */