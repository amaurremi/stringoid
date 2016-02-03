package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class fm
  implements Parcelable.Creator<fl>
{
  static void a(fl paramfl, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramfl.xR, false);
    b.c(paramParcel, 1000, paramfl.xJ);
    b.a(paramParcel, 3, paramfl.xS, paramInt, false);
    b.c(paramParcel, 4, paramfl.xT);
    b.a(paramParcel, 5, paramfl.xU, false);
    b.G(paramParcel, i);
  }
  
  public fl[] F(int paramInt)
  {
    return new fl[paramInt];
  }
  
  public fl n(Parcel paramParcel)
  {
    byte[] arrayOfByte = null;
    int k = a.B(paramParcel);
    int j = 0;
    int i = -1;
    fq localfq = null;
    String str = null;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.A(paramParcel);
      switch (a.ar(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        str = a.o(paramParcel, m);
        break;
      case 1000: 
        j = a.g(paramParcel, m);
        break;
      case 3: 
        localfq = (fq)a.a(paramParcel, m, fq.CREATOR);
        break;
      case 4: 
        i = a.g(paramParcel, m);
        break;
      case 5: 
        arrayOfByte = a.r(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new fl(j, str, localfq, i, arrayOfByte);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/fm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */