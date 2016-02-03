package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class lk
  implements Parcelable.Creator<lj>
{
  static void a(lj paramlj, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramlj.getVersionCode());
    b.a(paramParcel, 2, paramlj.akb, false);
    b.a(paramParcel, 3, paramlj.akc, false);
    b.G(paramParcel, paramInt);
  }
  
  public lj cf(Parcel paramParcel)
  {
    String[] arrayOfString = null;
    int j = a.B(paramParcel);
    int i = 0;
    byte[][] arrayOfByte = (byte[][])null;
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
        arrayOfString = a.A(paramParcel, k);
        break;
      case 3: 
        arrayOfByte = a.s(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new lj(i, arrayOfString, arrayOfByte);
  }
  
  public lj[] dL(int paramInt)
  {
    return new lj[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/lk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */