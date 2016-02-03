package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;

public final class MaskedWalletRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<MaskedWalletRequest> CREATOR = new l();
  private final int BR;
  Cart asA;
  String asl;
  String asr;
  boolean ate;
  boolean atf;
  boolean atg;
  String ath;
  String ati;
  boolean atj;
  boolean atk;
  CountrySpecification[] atl;
  boolean atm;
  boolean atn;
  ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> ato;
  
  MaskedWalletRequest()
  {
    this.BR = 3;
    this.atm = true;
    this.atn = true;
  }
  
  MaskedWalletRequest(int paramInt, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, String paramString3, String paramString4, Cart paramCart, boolean paramBoolean4, boolean paramBoolean5, CountrySpecification[] paramArrayOfCountrySpecification, boolean paramBoolean6, boolean paramBoolean7, ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> paramArrayList)
  {
    this.BR = paramInt;
    this.asr = paramString1;
    this.ate = paramBoolean1;
    this.atf = paramBoolean2;
    this.atg = paramBoolean3;
    this.ath = paramString2;
    this.asl = paramString3;
    this.ati = paramString4;
    this.asA = paramCart;
    this.atj = paramBoolean4;
    this.atk = paramBoolean5;
    this.atl = paramArrayOfCountrySpecification;
    this.atm = paramBoolean6;
    this.atn = paramBoolean7;
    this.ato = paramArrayList;
  }
  
  public static Builder newBuilder()
  {
    MaskedWalletRequest localMaskedWalletRequest = new MaskedWalletRequest();
    localMaskedWalletRequest.getClass();
    return new Builder(null);
  }
  
  public boolean allowDebitCard()
  {
    return this.atn;
  }
  
  public boolean allowPrepaidCard()
  {
    return this.atm;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> getAllowedCountrySpecificationsForShipping()
  {
    return this.ato;
  }
  
  public CountrySpecification[] getAllowedShippingCountrySpecifications()
  {
    return this.atl;
  }
  
  public Cart getCart()
  {
    return this.asA;
  }
  
  public String getCurrencyCode()
  {
    return this.asl;
  }
  
  public String getEstimatedTotalPrice()
  {
    return this.ath;
  }
  
  public String getMerchantName()
  {
    return this.ati;
  }
  
  public String getMerchantTransactionId()
  {
    return this.asr;
  }
  
  public int getVersionCode()
  {
    return this.BR;
  }
  
  public boolean isBillingAgreement()
  {
    return this.atk;
  }
  
  public boolean isPhoneNumberRequired()
  {
    return this.ate;
  }
  
  public boolean isShippingAddressRequired()
  {
    return this.atf;
  }
  
  public boolean shouldRetrieveWalletObjects()
  {
    return this.atj;
  }
  
  public boolean useMinimalBillingAddress()
  {
    return this.atg;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    l.a(this, paramParcel, paramInt);
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public Builder addAllowedCountrySpecificationForShipping(com.google.android.gms.identity.intents.model.CountrySpecification paramCountrySpecification)
    {
      if (MaskedWalletRequest.this.ato == null) {
        MaskedWalletRequest.this.ato = new ArrayList();
      }
      MaskedWalletRequest.this.ato.add(paramCountrySpecification);
      return this;
    }
    
    public Builder addAllowedCountrySpecificationsForShipping(Collection<com.google.android.gms.identity.intents.model.CountrySpecification> paramCollection)
    {
      if (paramCollection != null)
      {
        if (MaskedWalletRequest.this.ato == null) {
          MaskedWalletRequest.this.ato = new ArrayList();
        }
        MaskedWalletRequest.this.ato.addAll(paramCollection);
      }
      return this;
    }
    
    public MaskedWalletRequest build()
    {
      return MaskedWalletRequest.this;
    }
    
    public Builder setAllowDebitCard(boolean paramBoolean)
    {
      MaskedWalletRequest.this.atn = paramBoolean;
      return this;
    }
    
    public Builder setAllowPrepaidCard(boolean paramBoolean)
    {
      MaskedWalletRequest.this.atm = paramBoolean;
      return this;
    }
    
    public Builder setCart(Cart paramCart)
    {
      MaskedWalletRequest.this.asA = paramCart;
      return this;
    }
    
    public Builder setCurrencyCode(String paramString)
    {
      MaskedWalletRequest.this.asl = paramString;
      return this;
    }
    
    public Builder setEstimatedTotalPrice(String paramString)
    {
      MaskedWalletRequest.this.ath = paramString;
      return this;
    }
    
    public Builder setIsBillingAgreement(boolean paramBoolean)
    {
      MaskedWalletRequest.this.atk = paramBoolean;
      return this;
    }
    
    public Builder setMerchantName(String paramString)
    {
      MaskedWalletRequest.this.ati = paramString;
      return this;
    }
    
    public Builder setMerchantTransactionId(String paramString)
    {
      MaskedWalletRequest.this.asr = paramString;
      return this;
    }
    
    public Builder setPhoneNumberRequired(boolean paramBoolean)
    {
      MaskedWalletRequest.this.ate = paramBoolean;
      return this;
    }
    
    public Builder setShippingAddressRequired(boolean paramBoolean)
    {
      MaskedWalletRequest.this.atf = paramBoolean;
      return this;
    }
    
    public Builder setShouldRetrieveWalletObjects(boolean paramBoolean)
    {
      MaskedWalletRequest.this.atj = paramBoolean;
      return this;
    }
    
    public Builder setUseMinimalBillingAddress(boolean paramBoolean)
    {
      MaskedWalletRequest.this.atg = paramBoolean;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wallet/MaskedWalletRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */