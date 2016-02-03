package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.internal.ig;
import java.util.ArrayList;

public class e
  implements Parcelable.Creator<d>
{
  static void a(d paramd, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.b.C(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramd.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, paramd.akP, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 3, paramd.akQ, false);
    com.google.android.gms.common.internal.safeparcel.b.b(paramParcel, 4, paramd.akR, false);
    com.google.android.gms.common.internal.safeparcel.b.G(paramParcel, paramInt);
  }
  
  public d cl(Parcel paramParcel)
  {
    String str2 = null;
    int j = a.B(paramParcel);
    int i = 0;
    ArrayList localArrayList = ig.ga();
    String str1 = null;
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
        str1 = a.o(paramParcel, k);
        break;
      case 3: 
        str2 = a.o(paramParcel, k);
        break;
      case 4: 
        localArrayList = a.c(paramParcel, k, b.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new d(i, str1, str2, localArrayList);
  }
  
  public d[] dT(int paramInt)
  {
    return new d[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/wobs/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */