package com.google.android.gms.wallet;

import com.google.android.gms.identity.intents.model.UserAddress;

public final class MaskedWallet$Builder
{
  private MaskedWallet$Builder(MaskedWallet paramMaskedWallet) {}
  
  public MaskedWallet build()
  {
    return this.ajE;
  }
  
  public Builder setBillingAddress(Address paramAddress)
  {
    this.ajE.aiU = paramAddress;
    return this;
  }
  
  public Builder setBuyerBillingAddress(UserAddress paramUserAddress)
  {
    this.ajE.aiX = paramUserAddress;
    return this;
  }
  
  public Builder setBuyerShippingAddress(UserAddress paramUserAddress)
  {
    this.ajE.aiY = paramUserAddress;
    return this;
  }
  
  public Builder setEmail(String paramString)
  {
    this.ajE.aiT = paramString;
    return this;
  }
  
  public Builder setGoogleTransactionId(String paramString)
  {
    this.ajE.aiQ = paramString;
    return this;
  }
  
  public Builder setInstrumentInfos(InstrumentInfo[] paramArrayOfInstrumentInfo)
  {
    this.ajE.aiZ = paramArrayOfInstrumentInfo;
    return this;
  }
  
  public Builder setLoyaltyWalletObjects(LoyaltyWalletObject[] paramArrayOfLoyaltyWalletObject)
  {
    this.ajE.ajC = paramArrayOfLoyaltyWalletObject;
    return this;
  }
  
  public Builder setMerchantTransactionId(String paramString)
  {
    this.ajE.aiR = paramString;
    return this;
  }
  
  public Builder setOfferWalletObjects(OfferWalletObject[] paramArrayOfOfferWalletObject)
  {
    this.ajE.ajD = paramArrayOfOfferWalletObject;
    return this;
  }
  
  public Builder setPaymentDescriptions(String[] paramArrayOfString)
  {
    this.ajE.aiW = paramArrayOfString;
    return this;
  }
  
  public Builder setShippingAddress(Address paramAddress)
  {
    this.ajE.aiV = paramAddress;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/MaskedWallet$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */