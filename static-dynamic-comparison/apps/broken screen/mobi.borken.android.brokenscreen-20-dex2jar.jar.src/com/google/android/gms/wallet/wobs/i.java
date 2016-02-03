package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class i
  implements Parcelable.Creator<f>
{
  static void a(f paramf, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramf.getVersionCode());
    b.a(paramParcel, 2, paramf.label, false);
    b.a(paramParcel, 3, paramf.akP, paramInt, false);
    b.a(paramParcel, 4, paramf.type, false);
    b.a(paramParcel, 5, paramf.ajp, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public f cn(Parcel paramParcel)
  {
    l locall = null;
    int j = a.B(paramParcel);
    int i = 0;
    String str1 = null;
    g localg = null;
    String str2 = null;
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
        str2 = a.o(paramParcel, k);
        break;
      case 3: 
        localg = (g)a.a(paramParcel, k, g.CREATOR);
        break;
      case 4: 
        str1 = a.o(paramParcel, k);
        break;
      case 5: 
        locall = (l)a.a(paramParcel, k, l.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new f(i, str2, localg, str1, locall);
  }
  
  public f[] dV(int paramInt)
  {
    return new f[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wallet/wobs/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */