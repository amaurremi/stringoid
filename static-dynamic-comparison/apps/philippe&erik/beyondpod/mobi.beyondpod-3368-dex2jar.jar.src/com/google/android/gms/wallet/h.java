package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h
  implements Parcelable.Creator<MaskedWallet>
{
  static void a(MaskedWallet paramMaskedWallet, Parcel paramParcel, int paramInt)
  {
    int i = b.o(paramParcel);
    b.c(paramParcel, 1, paramMaskedWallet.getVersionCode());
    b.a(paramParcel, 2, paramMaskedWallet.Gn, false);
    b.a(paramParcel, 3, paramMaskedWallet.Go, false);
    b.a(paramParcel, 4, paramMaskedWallet.Gt, false);
    b.a(paramParcel, 5, paramMaskedWallet.Gq, false);
    b.a(paramParcel, 6, paramMaskedWallet.Gr, paramInt, false);
    b.a(paramParcel, 7, paramMaskedWallet.Gs, paramInt, false);
    b.a(paramParcel, 8, paramMaskedWallet.GI, paramInt, false);
    b.a(paramParcel, 9, paramMaskedWallet.GJ, paramInt, false);
    b.D(paramParcel, i);
  }
  
  public MaskedWallet aL(Parcel paramParcel)
  {
    OfferWalletObject[] arrayOfOfferWalletObject = null;
    int j = a.n(paramParcel);
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
      int k = a.m(paramParcel);
      switch (a.M(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str3 = a.m(paramParcel, k);
        break;
      case 3: 
        str2 = a.m(paramParcel, k);
        break;
      case 4: 
        arrayOfString = a.x(paramParcel, k);
        break;
      case 5: 
        str1 = a.m(paramParcel, k);
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
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new MaskedWallet(i, str3, str2, arrayOfString, str1, localAddress2, localAddress1, arrayOfLoyaltyWalletObject, arrayOfOfferWalletObject);
  }
  
  public MaskedWallet[] bD(int paramInt)
  {
    return new MaskedWallet[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/wallet/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */