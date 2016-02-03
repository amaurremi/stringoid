package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class fr
  implements Parcelable.Creator<fq>
{
  static void a(fq paramfq, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramfq.name, false);
    b.c(paramParcel, 1000, paramfq.xJ);
    b.a(paramParcel, 2, paramfq.xY, false);
    b.a(paramParcel, 3, paramfq.xZ);
    b.c(paramParcel, 4, paramfq.weight);
    b.a(paramParcel, 5, paramfq.ya);
    b.a(paramParcel, 6, paramfq.yb, false);
    b.a(paramParcel, 7, paramfq.yc, paramInt, false);
    b.a(paramParcel, 8, paramfq.yd, false);
    b.a(paramParcel, 11, paramfq.ye, false);
    b.G(paramParcel, i);
  }
  
  public fq[] J(int paramInt)
  {
    return new fq[paramInt];
  }
  
  public fq p(Parcel paramParcel)
  {
    boolean bool1 = false;
    String str1 = null;
    int k = a.B(paramParcel);
    int i = 1;
    int[] arrayOfInt = null;
    fn[] arrayOffn = null;
    String str2 = null;
    boolean bool2 = false;
    String str3 = null;
    String str4 = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.A(paramParcel);
      switch (a.ar(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        str4 = a.o(paramParcel, m);
        break;
      case 1000: 
        j = a.g(paramParcel, m);
        break;
      case 2: 
        str3 = a.o(paramParcel, m);
        break;
      case 3: 
        bool2 = a.c(paramParcel, m);
        break;
      case 4: 
        i = a.g(paramParcel, m);
        break;
      case 5: 
        bool1 = a.c(paramParcel, m);
        break;
      case 6: 
        str2 = a.o(paramParcel, m);
        break;
      case 7: 
        arrayOffn = (fn[])a.b(paramParcel, m, fn.CREATOR);
        break;
      case 8: 
        arrayOfInt = a.u(paramParcel, m);
        break;
      case 11: 
        str1 = a.o(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new fq(j, str4, str3, bool2, i, bool1, str2, arrayOffn, arrayOfInt, str1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/fr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */