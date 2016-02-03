package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class o
  implements Parcelable.Creator<ProxyCard>
{
  static void a(ProxyCard paramProxyCard, Parcel paramParcel, int paramInt)
  {
    paramInt = b.p(paramParcel);
    b.c(paramParcel, 1, paramProxyCard.getVersionCode());
    b.a(paramParcel, 2, paramProxyCard.ack, false);
    b.a(paramParcel, 3, paramProxyCard.acl, false);
    b.c(paramParcel, 4, paramProxyCard.acm);
    b.c(paramParcel, 5, paramProxyCard.acn);
    b.F(paramParcel, paramInt);
  }
  
  public ProxyCard bk(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int m = a.o(paramParcel);
    int j = 0;
    String str2 = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.n(paramParcel);
      switch (a.R(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.g(paramParcel, n);
        break;
      case 2: 
        str2 = a.n(paramParcel, n);
        break;
      case 3: 
        str1 = a.n(paramParcel, n);
        break;
      case 4: 
        j = a.g(paramParcel, n);
        break;
      case 5: 
        i = a.g(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new ProxyCard(k, str2, str1, j, i);
  }
  
  public ProxyCard[] cw(int paramInt)
  {
    return new ProxyCard[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/wallet/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */