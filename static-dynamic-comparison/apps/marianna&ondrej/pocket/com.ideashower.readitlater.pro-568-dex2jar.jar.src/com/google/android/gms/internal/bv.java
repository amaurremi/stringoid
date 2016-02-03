package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class bv
  implements Parcelable.Creator
{
  static void a(fn paramfn, Parcel paramParcel, int paramInt)
  {
    paramInt = c.a(paramParcel);
    c.a(paramParcel, 1, paramfn.b(), false);
    c.a(paramParcel, 1000, paramfn.a());
    c.a(paramParcel, 2, paramfn.c(), false);
    c.a(paramParcel, 3, paramfn.d(), false);
    c.a(paramParcel, 4, paramfn.e(), false);
    c.a(paramParcel, 5, paramfn.f(), false);
    c.a(paramParcel, 6, paramfn.g(), false);
    c.a(paramParcel, 7, paramfn.h(), false);
    c.a(paramParcel, 8, paramfn.i(), false);
    c.a(paramParcel, paramInt);
  }
  
  public fn a(Parcel paramParcel)
  {
    String str1 = null;
    int j = a.b(paramParcel);
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
      int k = a.a(paramParcel);
      switch (a.a(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        str5 = a.l(paramParcel, k);
        break;
      case 1000: 
        i = a.f(paramParcel, k);
        break;
      case 2: 
        arrayOfString3 = a.w(paramParcel, k);
        break;
      case 3: 
        arrayOfString2 = a.w(paramParcel, k);
        break;
      case 4: 
        arrayOfString1 = a.w(paramParcel, k);
        break;
      case 5: 
        str4 = a.l(paramParcel, k);
        break;
      case 6: 
        str3 = a.l(paramParcel, k);
        break;
      case 7: 
        str2 = a.l(paramParcel, k);
        break;
      case 8: 
        str1 = a.l(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new b("Overread allowed size end=" + j, paramParcel);
    }
    return new fn(i, str5, arrayOfString3, arrayOfString2, arrayOfString1, str4, str3, str2, str1);
  }
  
  public fn[] a(int paramInt)
  {
    return new fn[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */