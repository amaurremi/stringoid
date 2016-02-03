package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator
{
  static void a(FullWallet paramFullWallet, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1, paramFullWallet.a());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, paramFullWallet.a, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 3, paramFullWallet.b, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 4, paramFullWallet.c, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 5, paramFullWallet.d, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 6, paramFullWallet.e, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 7, paramFullWallet.f, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 8, paramFullWallet.g, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, i);
  }
  
  public FullWallet a(Parcel paramParcel)
  {
    String[] arrayOfString = null;
    int j = a.b(paramParcel);
    int i = 0;
    Address localAddress1 = null;
    Address localAddress2 = null;
    String str1 = null;
    ProxyCard localProxyCard = null;
    String str2 = null;
    String str3 = null;
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
        str3 = a.l(paramParcel, k);
        break;
      case 3: 
        str2 = a.l(paramParcel, k);
        break;
      case 4: 
        localProxyCard = (ProxyCard)a.a(paramParcel, k, ProxyCard.CREATOR);
        break;
      case 5: 
        str1 = a.l(paramParcel, k);
        break;
      case 6: 
        localAddress2 = (Address)a.a(paramParcel, k, Address.CREATOR);
        break;
      case 7: 
        localAddress1 = (Address)a.a(paramParcel, k, Address.CREATOR);
        break;
      case 8: 
        arrayOfString = a.w(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new b("Overread allowed size end=" + j, paramParcel);
    }
    return new FullWallet(i, str3, str2, localProxyCard, str1, localAddress2, localAddress1, arrayOfString);
  }
  
  public FullWallet[] a(int paramInt)
  {
    return new FullWallet[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/wallet/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */