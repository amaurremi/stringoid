package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class g
  implements Parcelable.Creator
{
  static void a(MaskedWallet paramMaskedWallet, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramMaskedWallet.a());
    c.a(paramParcel, 2, paramMaskedWallet.a, false);
    c.a(paramParcel, 3, paramMaskedWallet.b, false);
    c.a(paramParcel, 4, paramMaskedWallet.c, false);
    c.a(paramParcel, 5, paramMaskedWallet.d, false);
    c.a(paramParcel, 6, paramMaskedWallet.e, paramInt, false);
    c.a(paramParcel, 7, paramMaskedWallet.f, paramInt, false);
    c.a(paramParcel, 8, paramMaskedWallet.g, paramInt, false);
    c.a(paramParcel, 9, paramMaskedWallet.h, paramInt, false);
    c.a(paramParcel, i);
  }
  
  public MaskedWallet a(Parcel paramParcel)
  {
    OfferWalletObject[] arrayOfOfferWalletObject = null;
    int j = a.b(paramParcel);
    int i = 0;
    LoyaltyWalletObject[] arrayOfLoyaltyWalletObject = null;
    Address localAddress1 = null;
    Address localAddress2 = null;
    String str1 = null;
    String[] arrayOfString = null;
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
        arrayOfString = a.w(paramParcel, k);
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
        arrayOfLoyaltyWalletObject = (LoyaltyWalletObject[])a.b(paramParcel, k, LoyaltyWalletObject.CREATOR);
        break;
      case 9: 
        arrayOfOfferWalletObject = (OfferWalletObject[])a.b(paramParcel, k, OfferWalletObject.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new b("Overread allowed size end=" + j, paramParcel);
    }
    return new MaskedWallet(i, str3, str2, arrayOfString, str1, localAddress2, localAddress1, arrayOfLoyaltyWalletObject, arrayOfOfferWalletObject);
  }
  
  public MaskedWallet[] a(int paramInt)
  {
    return new MaskedWallet[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/wallet/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */