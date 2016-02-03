package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class MaskedWallet
  implements SafeParcelable
{
  public static final Parcelable.Creator<MaskedWallet> CREATOR = new h();
  LoyaltyWalletObject[] GI;
  OfferWalletObject[] GJ;
  String Gn;
  String Go;
  String Gq;
  Address Gr;
  Address Gs;
  String[] Gt;
  private final int kg;
  
  MaskedWallet()
  {
    this.kg = 2;
  }
  
  MaskedWallet(int paramInt, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, Address paramAddress1, Address paramAddress2, LoyaltyWalletObject[] paramArrayOfLoyaltyWalletObject, OfferWalletObject[] paramArrayOfOfferWalletObject)
  {
    this.kg = paramInt;
    this.Gn = paramString1;
    this.Go = paramString2;
    this.Gt = paramArrayOfString;
    this.Gq = paramString3;
    this.Gr = paramAddress1;
    this.Gs = paramAddress2;
    this.GI = paramArrayOfLoyaltyWalletObject;
    this.GJ = paramArrayOfOfferWalletObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Address getBillingAddress()
  {
    return this.Gr;
  }
  
  public String getEmail()
  {
    return this.Gq;
  }
  
  public String getGoogleTransactionId()
  {
    return this.Gn;
  }
  
  public LoyaltyWalletObject[] getLoyaltyWalletObjects()
  {
    return this.GI;
  }
  
  public String getMerchantTransactionId()
  {
    return this.Go;
  }
  
  public OfferWalletObject[] getOfferWalletObjects()
  {
    return this.GJ;
  }
  
  public String[] getPaymentDescriptions()
  {
    return this.Gt;
  }
  
  public Address getShippingAddress()
  {
    return this.Gs;
  }
  
  public int getVersionCode()
  {
    return this.kg;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/wallet/MaskedWallet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */