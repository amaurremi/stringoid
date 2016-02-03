package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.identity.intents.model.UserAddress;

public class k
  implements Parcelable.Creator<MaskedWallet>
{
  static void a(MaskedWallet paramMaskedWallet, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1, paramMaskedWallet.lX());
    b.a(paramParcel, 2, paramMaskedWallet.Yt, false);
    b.a(paramParcel, 3, paramMaskedWallet.Yu, false);
    b.a(paramParcel, 4, paramMaskedWallet.Yz, false);
    b.a(paramParcel, 5, paramMaskedWallet.Yw, false);
    b.a(paramParcel, 6, paramMaskedWallet.Yx, paramInt, false);
    b.a(paramParcel, 7, paramMaskedWallet.Yy, paramInt, false);
    b.a(paramParcel, 8, paramMaskedWallet.Zc, paramInt, false);
    b.a(paramParcel, 9, paramMaskedWallet.Zd, paramInt, false);
    b.a(paramParcel, 10, paramMaskedWallet.YA, paramInt, false);
    b.a(paramParcel, 11, paramMaskedWallet.YB, paramInt, false);
    b.a(paramParcel, 12, paramMaskedWallet.YC, paramInt, false);
    b.D(paramParcel, i);
  }
  
  public MaskedWallet bG(Parcel paramParcel)
  {
    int j = a.j(paramParcel);
    int i = 0;
    String str3 = null;
    String str2 = null;
    String[] arrayOfString = null;
    String str1 = null;
    Address localAddress2 = null;
    Address localAddress1 = null;
    LoyaltyWalletObject[] arrayOfLoyaltyWalletObject = null;
    OfferWalletObject[] arrayOfOfferWalletObject = null;
    UserAddress localUserAddress2 = null;
    UserAddress localUserAddress1 = null;
    InstrumentInfo[] arrayOfInstrumentInfo = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.i(paramParcel);
      switch (a.br(k))
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
        break;
      case 10: 
        localUserAddress2 = (UserAddress)a.a(paramParcel, k, UserAddress.CREATOR);
        break;
      case 11: 
        localUserAddress1 = (UserAddress)a.a(paramParcel, k, UserAddress.CREATOR);
        break;
      case 12: 
        arrayOfInstrumentInfo = (InstrumentInfo[])a.b(paramParcel, k, InstrumentInfo.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new MaskedWallet(i, str3, str2, arrayOfString, str1, localAddress2, localAddress1, arrayOfLoyaltyWalletObject, arrayOfOfferWalletObject, localUserAddress2, localUserAddress1, arrayOfInstrumentInfo);
  }
  
  public MaskedWallet[] ey(int paramInt)
  {
    return new MaskedWallet[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/wallet/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */