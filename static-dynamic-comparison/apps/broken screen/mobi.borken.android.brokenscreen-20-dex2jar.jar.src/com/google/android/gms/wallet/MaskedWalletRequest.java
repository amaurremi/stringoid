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
  String aiI;
  String aiO;
  Cart aiX;
  boolean ajC;
  boolean ajD;
  boolean ajE;
  String ajF;
  String ajG;
  boolean ajH;
  boolean ajI;
  CountrySpecification[] ajJ;
  boolean ajK;
  boolean ajL;
  ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> ajM;
  private final int xJ;
  
  MaskedWalletRequest()
  {
    this.xJ = 3;
    this.ajK = true;
    this.ajL = true;
  }
  
  MaskedWalletRequest(int paramInt, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, String paramString3, String paramString4, Cart paramCart, boolean paramBoolean4, boolean paramBoolean5, CountrySpecification[] paramArrayOfCountrySpecification, boolean paramBoolean6, boolean paramBoolean7, ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> paramArrayList)
  {
    this.xJ = paramInt;
    this.aiO = paramString1;
    this.ajC = paramBoolean1;
    this.ajD = paramBoolean2;
    this.ajE = paramBoolean3;
    this.ajF = paramString2;
    this.aiI = paramString3;
    this.ajG = paramString4;
    this.aiX = paramCart;
    this.ajH = paramBoolean4;
    this.ajI = paramBoolean5;
    this.ajJ = paramArrayOfCountrySpecification;
    this.ajK = paramBoolean6;
    this.ajL = paramBoolean7;
    this.ajM = paramArrayList;
  }
  
  public static Builder newBuilder()
  {
    MaskedWalletRequest localMaskedWalletRequest = new MaskedWalletRequest();
    localMaskedWalletRequest.getClass();
    return new Builder(null);
  }
  
  public boolean allowDebitCard()
  {
    return this.ajL;
  }
  
  public boolean allowPrepaidCard()
  {
    return this.ajK;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> getAllowedCountrySpecificationsForShipping()
  {
    return this.ajM;
  }
  
  public CountrySpecification[] getAllowedShippingCountrySpecifications()
  {
    return this.ajJ;
  }
  
  public Cart getCart()
  {
    return this.aiX;
  }
  
  public String getCurrencyCode()
  {
    return this.aiI;
  }
  
  public String getEstimatedTotalPrice()
  {
    return this.ajF;
  }
  
  public String getMerchantName()
  {
    return this.ajG;
  }
  
  public String getMerchantTransactionId()
  {
    return this.aiO;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public boolean isBillingAgreement()
  {
    return this.ajI;
  }
  
  public boolean isPhoneNumberRequired()
  {
    return this.ajC;
  }
  
  public boolean isShippingAddressRequired()
  {
    return this.ajD;
  }
  
  public boolean shouldRetrieveWalletObjects()
  {
    return this.ajH;
  }
  
  public boolean useMinimalBillingAddress()
  {
    return this.ajE;
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
      if (MaskedWalletRequest.this.ajM == null) {
        MaskedWalletRequest.this.ajM = new ArrayList();
      }
      MaskedWalletRequest.this.ajM.add(paramCountrySpecification);
      return this;
    }
    
    public Builder addAllowedCountrySpecificationsForShipping(Collection<com.google.android.gms.identity.intents.model.CountrySpecification> paramCollection)
    {
      if (paramCollection != null)
      {
        if (MaskedWalletRequest.this.ajM == null) {
          MaskedWalletRequest.this.ajM = new ArrayList();
        }
        MaskedWalletRequest.this.ajM.addAll(paramCollection);
      }
      return this;
    }
    
    public MaskedWalletRequest build()
    {
      return MaskedWalletRequest.this;
    }
    
    public Builder setAllowDebitCard(boolean paramBoolean)
    {
      MaskedWalletRequest.this.ajL = paramBoolean;
      return this;
    }
    
    public Builder setAllowPrepaidCard(boolean paramBoolean)
    {
      MaskedWalletRequest.this.ajK = paramBoolean;
      return this;
    }
    
    public Builder setCart(Cart paramCart)
    {
      MaskedWalletRequest.this.aiX = paramCart;
      return this;
    }
    
    public Builder setCurrencyCode(String paramString)
    {
      MaskedWalletRequest.this.aiI = paramString;
      return this;
    }
    
    public Builder setEstimatedTotalPrice(String paramString)
    {
      MaskedWalletRequest.this.ajF = paramString;
      return this;
    }
    
    public Builder setIsBillingAgreement(boolean paramBoolean)
    {
      MaskedWalletRequest.this.ajI = paramBoolean;
      return this;
    }
    
    public Builder setMerchantName(String paramString)
    {
      MaskedWalletRequest.this.ajG = paramString;
      return this;
    }
    
    public Builder setMerchantTransactionId(String paramString)
    {
      MaskedWalletRequest.this.aiO = paramString;
      return this;
    }
    
    public Builder setPhoneNumberRequired(boolean paramBoolean)
    {
      MaskedWalletRequest.this.ajC = paramBoolean;
      return this;
    }
    
    public Builder setShippingAddressRequired(boolean paramBoolean)
    {
      MaskedWalletRequest.this.ajD = paramBoolean;
      return this;
    }
    
    public Builder setShouldRetrieveWalletObjects(boolean paramBoolean)
    {
      MaskedWalletRequest.this.ajH = paramBoolean;
      return this;
    }
    
    public Builder setUseMinimalBillingAddress(boolean paramBoolean)
    {
      MaskedWalletRequest.this.ajE = paramBoolean;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wallet/MaskedWalletRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */