package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator<WalletFragmentStyle>
{
  static void a(WalletFragmentStyle paramWalletFragmentStyle, Parcel paramParcel, int paramInt)
  {
    paramInt = b.p(paramParcel);
    b.c(paramParcel, 1, paramWalletFragmentStyle.xH);
    b.a(paramParcel, 2, paramWalletFragmentStyle.acT, false);
    b.c(paramParcel, 3, paramWalletFragmentStyle.acU);
    b.F(paramParcel, paramInt);
  }
  
  public WalletFragmentStyle bp(Parcel paramParcel)
  {
    int j = 0;
    int k = a.o(paramParcel);
    Bundle localBundle = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.n(paramParcel);
      switch (a.R(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        i = a.g(paramParcel, m);
        break;
      case 2: 
        localBundle = a.p(paramParcel, m);
        break;
      case 3: 
        j = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new WalletFragmentStyle(i, localBundle, j);
  }
  
  public WalletFragmentStyle[] cC(int paramInt)
  {
    return new WalletFragmentStyle[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/wallet/fragment/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */