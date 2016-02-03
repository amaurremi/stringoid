package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class f
  implements Parcelable.Creator<LineItem>
{
  static void a(LineItem paramLineItem, Parcel paramParcel, int paramInt)
  {
    paramInt = b.o(paramParcel);
    b.c(paramParcel, 1, paramLineItem.getVersionCode());
    b.a(paramParcel, 2, paramLineItem.description, false);
    b.a(paramParcel, 3, paramLineItem.Gw, false);
    b.a(paramParcel, 4, paramLineItem.Gx, false);
    b.a(paramParcel, 5, paramLineItem.Gj, false);
    b.c(paramParcel, 6, paramLineItem.Gy);
    b.a(paramParcel, 7, paramLineItem.Gk, false);
    b.D(paramParcel, paramInt);
  }
  
  public LineItem aJ(Parcel paramParcel)
  {
    int i = 0;
    String str1 = null;
    int k = a.n(paramParcel);
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.m(paramParcel);
      switch (a.M(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        j = a.g(paramParcel, m);
        break;
      case 2: 
        str5 = a.m(paramParcel, m);
        break;
      case 3: 
        str4 = a.m(paramParcel, m);
        break;
      case 4: 
        str3 = a.m(paramParcel, m);
        break;
      case 5: 
        str2 = a.m(paramParcel, m);
        break;
      case 6: 
        i = a.g(paramParcel, m);
        break;
      case 7: 
        str1 = a.m(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new LineItem(j, str5, str4, str3, str2, i, str1);
  }
  
  public LineItem[] bB(int paramInt)
  {
    return new LineItem[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/wallet/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */