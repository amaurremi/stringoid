package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class jv
  implements Parcelable.Creator<ju>
{
  static void a(ju paramju, Parcel paramParcel, int paramInt)
  {
    paramInt = b.p(paramParcel);
    b.c(paramParcel, 1, paramju.getVersionCode());
    b.a(paramParcel, 2, paramju.ado);
    b.a(paramParcel, 3, paramju.adp);
    b.F(paramParcel, paramInt);
  }
  
  public ju bv(Parcel paramParcel)
  {
    long l1 = 0L;
    int j = a.o(paramParcel);
    int i = 0;
    long l2 = 0L;
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
        l2 = a.i(paramParcel, k);
        break;
      case 3: 
        l1 = a.i(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ju(i, l2, l1);
  }
  
  public ju[] cJ(int paramInt)
  {
    return new ju[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/jv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */