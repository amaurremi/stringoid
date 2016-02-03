package com.google.android.gms.wallet;

import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;

public final class MaskedWalletRequest$Builder
{
  private MaskedWalletRequest$Builder(MaskedWalletRequest paramMaskedWalletRequest) {}
  
  public Builder addAllowedCountrySpecificationForShipping(CountrySpecification paramCountrySpecification)
  {
    if (this.ajQ.ajP == null) {
      this.ajQ.ajP = new ArrayList();
    }
    this.ajQ.ajP.add(paramCountrySpecification);
    return this;
  }
  
  public Builder addAllowedCountrySpecificationsForShipping(Collection<CountrySpecification> paramCollection)
  {
    if (paramCollection != null)
    {
      if (this.ajQ.ajP == null) {
        this.ajQ.ajP = new ArrayList();
      }
      this.ajQ.ajP.addAll(paramCollection);
    }
    return this;
  }
  
  public MaskedWalletRequest build()
  {
    return this.ajQ;
  }
  
  public Builder setAllowDebitCard(boolean paramBoolean)
  {
    this.ajQ.ajO = paramBoolean;
    return this;
  }
  
  public Builder setAllowPrepaidCard(boolean paramBoolean)
  {
    this.ajQ.ajN = paramBoolean;
    return this;
  }
  
  public Builder setCart(Cart paramCart)
  {
    this.ajQ.aja = paramCart;
    return this;
  }
  
  public Builder setCurrencyCode(String paramString)
  {
    this.ajQ.aiL = paramString;
    return this;
  }
  
  public Builder setEstimatedTotalPrice(String paramString)
  {
    this.ajQ.ajI = paramString;
    return this;
  }
  
  public Builder setIsBillingAgreement(boolean paramBoolean)
  {
    this.ajQ.ajL = paramBoolean;
    return this;
  }
  
  public Builder setMerchantName(String paramString)
  {
    this.ajQ.ajJ = paramString;
    return this;
  }
  
  public Builder setMerchantTransactionId(String paramString)
  {
    this.ajQ.aiR = paramString;
    return this;
  }
  
  public Builder setPhoneNumberRequired(boolean paramBoolean)
  {
    this.ajQ.ajF = paramBoolean;
    return this;
  }
  
  public Builder setShippingAddressRequired(boolean paramBoolean)
  {
    this.ajQ.ajG = paramBoolean;
    return this;
  }
  
  public Builder setShouldRetrieveWalletObjects(boolean paramBoolean)
  {
    this.ajQ.ajK = paramBoolean;
    return this;
  }
  
  public Builder setUseMinimalBillingAddress(boolean paramBoolean)
  {
    this.ajQ.ajH = paramBoolean;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/MaskedWalletRequest$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */