package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class MaskedWalletRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<MaskedWalletRequest> CREATOR = new i();
  boolean GK;
  boolean GL;
  boolean GM;
  String GN;
  String GO;
  boolean GP;
  boolean GQ;
  CountrySpecification[] GR;
  boolean GS;
  boolean GT;
  String Gk;
  String Go;
  Cart Gu;
  private final int kg;
  
  MaskedWalletRequest()
  {
    this.kg = 3;
    this.GS = true;
    this.GT = true;
  }
  
  MaskedWalletRequest(int paramInt, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, String paramString3, String paramString4, Cart paramCart, boolean paramBoolean4, boolean paramBoolean5, CountrySpecification[] paramArrayOfCountrySpecification, boolean paramBoolean6, boolean paramBoolean7)
  {
    this.kg = paramInt;
    this.Go = paramString1;
    this.GK = paramBoolean1;
    this.GL = paramBoolean2;
    this.GM = paramBoolean3;
    this.GN = paramString2;
    this.Gk = paramString3;
    this.GO = paramString4;
    this.Gu = paramCart;
    this.GP = paramBoolean4;
    this.GQ = paramBoolean5;
    this.GR = paramArrayOfCountrySpecification;
    this.GS = paramBoolean6;
    this.GT = paramBoolean7;
  }
  
  public static Builder newBuilder()
  {
    MaskedWalletRequest localMaskedWalletRequest = new MaskedWalletRequest();
    localMaskedWalletRequest.getClass();
    return new Builder(null);
  }
  
  public boolean allowDebitCard()
  {
    return this.GT;
  }
  
  public boolean allowPrepaidCard()
  {
    return this.GS;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public CountrySpecification[] getAllowedShippingCountrySpecifications()
  {
    return this.GR;
  }
  
  public Cart getCart()
  {
    return this.Gu;
  }
  
  public String getCurrencyCode()
  {
    return this.Gk;
  }
  
  public String getEstimatedTotalPrice()
  {
    return this.GN;
  }
  
  public String getMerchantName()
  {
    return this.GO;
  }
  
  public String getMerchantTransactionId()
  {
    return this.Go;
  }
  
  public int getVersionCode()
  {
    return this.kg;
  }
  
  public boolean isBillingAgreement()
  {
    return this.GQ;
  }
  
  public boolean isPhoneNumberRequired()
  {
    return this.GK;
  }
  
  public boolean isShippingAddressRequired()
  {
    return this.GL;
  }
  
  public boolean shouldRetrieveWalletObjects()
  {
    return this.GP;
  }
  
  public boolean useMinimalBillingAddress()
  {
    return this.GM;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    i.a(this, paramParcel, paramInt);
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public MaskedWalletRequest build()
    {
      return MaskedWalletRequest.this;
    }
    
    public Builder setAllowDebitCard(boolean paramBoolean)
    {
      MaskedWalletRequest.this.GT = paramBoolean;
      return this;
    }
    
    public Builder setAllowPrepaidCard(boolean paramBoolean)
    {
      MaskedWalletRequest.this.GS = paramBoolean;
      return this;
    }
    
    public Builder setAllowedShippingCountrySpecifications(CountrySpecification[] paramArrayOfCountrySpecification)
    {
      MaskedWalletRequest.this.GR = paramArrayOfCountrySpecification;
      return this;
    }
    
    public Builder setCart(Cart paramCart)
    {
      MaskedWalletRequest.this.Gu = paramCart;
      return this;
    }
    
    public Builder setCurrencyCode(String paramString)
    {
      MaskedWalletRequest.this.Gk = paramString;
      return this;
    }
    
    public Builder setEstimatedTotalPrice(String paramString)
    {
      MaskedWalletRequest.this.GN = paramString;
      return this;
    }
    
    public Builder setIsBillingAgreement(boolean paramBoolean)
    {
      MaskedWalletRequest.this.GQ = paramBoolean;
      return this;
    }
    
    public Builder setMerchantName(String paramString)
    {
      MaskedWalletRequest.this.GO = paramString;
      return this;
    }
    
    public Builder setMerchantTransactionId(String paramString)
    {
      MaskedWalletRequest.this.Go = paramString;
      return this;
    }
    
    public Builder setPhoneNumberRequired(boolean paramBoolean)
    {
      MaskedWalletRequest.this.GK = paramBoolean;
      return this;
    }
    
    public Builder setShippingAddressRequired(boolean paramBoolean)
    {
      MaskedWalletRequest.this.GL = paramBoolean;
      return this;
    }
    
    public Builder setShouldRetrieveWalletObjects(boolean paramBoolean)
    {
      MaskedWalletRequest.this.GP = paramBoolean;
      return this;
    }
    
    public Builder setUseMinimalBillingAddress(boolean paramBoolean)
    {
      MaskedWalletRequest.this.GM = paramBoolean;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/wallet/MaskedWalletRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */