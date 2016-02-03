package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.internal.hn;

public final class MaskedWallet
  implements SafeParcelable
{
  public static final Parcelable.Creator<MaskedWallet> CREATOR = new k();
  String aiN;
  String aiO;
  String aiQ;
  Address aiR;
  Address aiS;
  String[] aiT;
  UserAddress aiU;
  UserAddress aiV;
  InstrumentInfo[] aiW;
  OfferWalletObject[] ajA;
  LoyaltyWalletObject[] ajz;
  private final int xJ;
  
  private MaskedWallet()
  {
    this.xJ = 2;
  }
  
  MaskedWallet(int paramInt, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, Address paramAddress1, Address paramAddress2, LoyaltyWalletObject[] paramArrayOfLoyaltyWalletObject, OfferWalletObject[] paramArrayOfOfferWalletObject, UserAddress paramUserAddress1, UserAddress paramUserAddress2, InstrumentInfo[] paramArrayOfInstrumentInfo)
  {
    this.xJ = paramInt;
    this.aiN = paramString1;
    this.aiO = paramString2;
    this.aiT = paramArrayOfString;
    this.aiQ = paramString3;
    this.aiR = paramAddress1;
    this.aiS = paramAddress2;
    this.ajz = paramArrayOfLoyaltyWalletObject;
    this.ajA = paramArrayOfOfferWalletObject;
    this.aiU = paramUserAddress1;
    this.aiV = paramUserAddress2;
    this.aiW = paramArrayOfInstrumentInfo;
  }
  
  public static Builder nb()
  {
    MaskedWallet localMaskedWallet = new MaskedWallet();
    localMaskedWallet.getClass();
    return new Builder(null);
  }
  
  public static Builder newBuilderFrom(MaskedWallet paramMaskedWallet)
  {
    hn.f(paramMaskedWallet);
    return nb().setGoogleTransactionId(paramMaskedWallet.getGoogleTransactionId()).setMerchantTransactionId(paramMaskedWallet.getMerchantTransactionId()).setPaymentDescriptions(paramMaskedWallet.getPaymentDescriptions()).setInstrumentInfos(paramMaskedWallet.getInstrumentInfos()).setEmail(paramMaskedWallet.getEmail()).setLoyaltyWalletObjects(paramMaskedWallet.getLoyaltyWalletObjects()).setOfferWalletObjects(paramMaskedWallet.getOfferWalletObjects()).setBuyerBillingAddress(paramMaskedWallet.getBuyerBillingAddress()).setBuyerShippingAddress(paramMaskedWallet.getBuyerShippingAddress());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @Deprecated
  public Address getBillingAddress()
  {
    return this.aiR;
  }
  
  public UserAddress getBuyerBillingAddress()
  {
    return this.aiU;
  }
  
  public UserAddress getBuyerShippingAddress()
  {
    return this.aiV;
  }
  
  public String getEmail()
  {
    return this.aiQ;
  }
  
  public String getGoogleTransactionId()
  {
    return this.aiN;
  }
  
  public InstrumentInfo[] getInstrumentInfos()
  {
    return this.aiW;
  }
  
  public LoyaltyWalletObject[] getLoyaltyWalletObjects()
  {
    return this.ajz;
  }
  
  public String getMerchantTransactionId()
  {
    return this.aiO;
  }
  
  public OfferWalletObject[] getOfferWalletObjects()
  {
    return this.ajA;
  }
  
  public String[] getPaymentDescriptions()
  {
    return this.aiT;
  }
  
  @Deprecated
  public Address getShippingAddress()
  {
    return this.aiS;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    k.a(this, paramParcel, paramInt);
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public MaskedWallet build()
    {
      return MaskedWallet.this;
    }
    
    public Builder setBillingAddress(Address paramAddress)
    {
      MaskedWallet.this.aiR = paramAddress;
      return this;
    }
    
    public Builder setBuyerBillingAddress(UserAddress paramUserAddress)
    {
      MaskedWallet.this.aiU = paramUserAddress;
      return this;
    }
    
    public Builder setBuyerShippingAddress(UserAddress paramUserAddress)
    {
      MaskedWallet.this.aiV = paramUserAddress;
      return this;
    }
    
    public Builder setEmail(String paramString)
    {
      MaskedWallet.this.aiQ = paramString;
      return this;
    }
    
    public Builder setGoogleTransactionId(String paramString)
    {
      MaskedWallet.this.aiN = paramString;
      return this;
    }
    
    public Builder setInstrumentInfos(InstrumentInfo[] paramArrayOfInstrumentInfo)
    {
      MaskedWallet.this.aiW = paramArrayOfInstrumentInfo;
      return this;
    }
    
    public Builder setLoyaltyWalletObjects(LoyaltyWalletObject[] paramArrayOfLoyaltyWalletObject)
    {
      MaskedWallet.this.ajz = paramArrayOfLoyaltyWalletObject;
      return this;
    }
    
    public Builder setMerchantTransactionId(String paramString)
    {
      MaskedWallet.this.aiO = paramString;
      return this;
    }
    
    public Builder setOfferWalletObjects(OfferWalletObject[] paramArrayOfOfferWalletObject)
    {
      MaskedWallet.this.ajA = paramArrayOfOfferWalletObject;
      return this;
    }
    
    public Builder setPaymentDescriptions(String[] paramArrayOfString)
    {
      MaskedWallet.this.aiT = paramArrayOfString;
      return this;
    }
    
    public Builder setShippingAddress(Address paramAddress)
    {
      MaskedWallet.this.aiS = paramAddress;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wallet/MaskedWallet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */