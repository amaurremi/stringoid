package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public class b
  implements Parcelable.Creator
{
  static void a(be parambe, Parcel paramParcel, int paramInt)
  {
    paramInt = c.a(paramParcel);
    c.a(paramParcel, 1, parambe.a);
    c.a(paramParcel, 2, parambe.b, false);
    c.a(paramParcel, 3, parambe.c, false);
    c.a(paramParcel, 4, parambe.d, false);
    c.a(paramParcel, 5, parambe.e, false);
    c.a(paramParcel, 6, parambe.f, false);
    c.a(paramParcel, 7, parambe.g, false);
    c.a(paramParcel, 8, parambe.h, false);
    c.a(paramParcel, paramInt);
  }
  
  public be a(Parcel paramParcel)
  {
    String str1 = null;
    int j = a.b(paramParcel);
    int i = 0;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    String str7 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.a(paramParcel);
      switch (a.a(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.f(paramParcel, k);
        break;
      case 2: 
        str7 = a.l(paramParcel, k);
        break;
      case 3: 
        str6 = a.l(paramParcel, k);
        break;
      case 4: 
        str5 = a.l(paramParcel, k);
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
      throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + j, paramParcel);
    }
    return new be(i, str7, str6, str5, str4, str3, str2, str1);
  }
  
  public be[] a(int paramInt)
  {
    return new be[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */