package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class lj
  implements Parcelable.Creator<li>
{
  static void a(li paramli, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramli.getVersionCode());
    b.a(paramParcel, 2, paramli.ake, false);
    b.a(paramParcel, 3, paramli.akf, false);
    b.G(paramParcel, paramInt);
  }
  
  public li cf(Parcel paramParcel)
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
    return new li(i, arrayOfString, arrayOfByte);
  }
  
  public li[] dL(int paramInt)
  {
    return new li[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/lj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */