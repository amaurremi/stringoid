package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hw
  implements Parcelable.Creator<hu>
{
  static void a(hu paramhu, Parcel paramParcel, int paramInt)
  {
    paramInt = b.o(paramParcel);
    b.a(paramParcel, 1, paramhu.getAccountName(), false);
    b.c(paramParcel, 1000, paramhu.getVersionCode());
    b.a(paramParcel, 2, paramhu.eR(), false);
    b.a(paramParcel, 3, paramhu.eS(), false);
    b.a(paramParcel, 4, paramhu.eT(), false);
    b.a(paramParcel, 5, paramhu.eU(), false);
    b.a(paramParcel, 6, paramhu.eV(), false);
    b.a(paramParcel, 7, paramhu.eW(), false);
    b.a(paramParcel, 8, paramhu.eX(), false);
    b.D(paramParcel, paramInt);
  }
  
  public hu ar(Parcel paramParcel)
  {
    String str1 = null;
    int j = a.n(paramParcel);
    int i = 0;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String[] arrayOfString1 = null;
    String[] arrayOfString2 = null;
    String[] arrayOfString3 = null;
    String str5 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.m(paramParcel);
      switch (a.M(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        str5 = a.m(paramParcel, k);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        arrayOfString3 = a.x(paramParcel, k);
        break;
      case 3: 
        arrayOfString2 = a.x(paramParcel, k);
        break;
      case 4: 
        arrayOfString1 = a.x(paramParcel, k);
        break;
      case 5: 
        str4 = a.m(paramParcel, k);
        break;
      case 6: 
        str3 = a.m(paramParcel, k);
        break;
      case 7: 
        str2 = a.m(paramParcel, k);
        break;
      case 8: 
        str1 = a.m(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new hu(i, str5, arrayOfString3, arrayOfString2, arrayOfString1, str4, str3, str2, str1);
  }
  
  public hu[] bj(int paramInt)
  {
    return new hu[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/hw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */