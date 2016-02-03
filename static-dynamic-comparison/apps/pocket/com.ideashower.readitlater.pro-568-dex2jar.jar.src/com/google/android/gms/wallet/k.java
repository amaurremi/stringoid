package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class k
  implements Parcelable.Creator
{
  static void a(ProxyCard paramProxyCard, Parcel paramParcel, int paramInt)
  {
    paramInt = c.a(paramParcel);
    c.a(paramParcel, 1, paramProxyCard.a());
    c.a(paramParcel, 2, paramProxyCard.a, false);
    c.a(paramParcel, 3, paramProxyCard.b, false);
    c.a(paramParcel, 4, paramProxyCard.c);
    c.a(paramParcel, 5, paramProxyCard.d);
    c.a(paramParcel, paramInt);
  }
  
  public ProxyCard a(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int m = a.b(paramParcel);
    int j = 0;
    String str2 = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.a(paramParcel);
      switch (a.a(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.f(paramParcel, n);
        break;
      case 2: 
        str2 = a.l(paramParcel, n);
        break;
      case 3: 
        str1 = a.l(paramParcel, n);
        break;
      case 4: 
        j = a.f(paramParcel, n);
        break;
      case 5: 
        i = a.f(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new b("Overread allowed size end=" + m, paramParcel);
    }
    return new ProxyCard(k, str2, str1, j, i);
  }
  
  public ProxyCard[] a(int paramInt)
  {
    return new ProxyCard[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/wallet/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */