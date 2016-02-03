package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class MaskedWallet
  implements SafeParcelable
{
  public static final Parcelable.Creator<MaskedWallet> CREATOR = new k();
  private final int BR;
  String asq;
  String asr;
  String ast;
  Address asu;
  Address asv;
  String[] asw;
  UserAddress asx;
  UserAddress asy;
  InstrumentInfo[] asz;
  LoyaltyWalletObject[] atb;
  OfferWalletObject[] atc;
  
  private MaskedWallet()
  {
    this.BR = 2;
  }
  
  MaskedWallet(int paramInt, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, Address paramAddress1, Address paramAddress2, LoyaltyWalletObject[] paramArrayOfLoyaltyWalletObject, OfferWalletObject[] paramArrayOfOfferWalletObject, UserAddress paramUserAddress1, UserAddress paramUserAddress2, InstrumentInfo[] paramArrayOfInstrumentInfo)
  {
    this.BR = paramInt;
    this.asq = paramString1;
    this.asr = paramString2;
    this.asw = paramArrayOfString;
    this.ast = paramString3;
    this.asu = paramAddress1;
    this.asv = paramAddress2;
    this.atb = paramArrayOfLoyaltyWalletObject;
    this.atc = paramArrayOfOfferWalletObject;
    this.asx = paramUserAddress1;
    this.asy = paramUserAddress2;
    this.asz = paramArrayOfInstrumentInfo;
  }
  
  public static Builder newBuilderFrom(MaskedWallet paramMaskedWallet)
  {
    n.i(paramMaskedWallet);
    return pK().setGoogleTransactionId(paramMaskedWallet.getGoogleTransactionId()).setMerchantTransactionId(paramMaskedWallet.getMerchantTransactionId()).setPaymentDescriptions(paramMaskedWallet.getPaymentDescriptions()).setInstrumentInfos(paramMaskedWallet.getInstrumentInfos()).setEmail(paramMaskedWallet.getEmail()).setLoyaltyWalletObjects(paramMaskedWallet.getLoyaltyWalletObjects()).setOfferWalletObjects(paramMaskedWallet.getOfferWalletObjects()).setBuyerBillingAddress(paramMaskedWallet.getBuyerBillingAddress()).setBuyerShippingAddress(paramMaskedWallet.getBuyerShippingAddress());
  }
  
  public static Builder pK()
  {
    MaskedWallet localMaskedWallet = new MaskedWallet();
    localMaskedWallet.getClass();
    return new Builder(null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @Deprecated
  public Address getBillingAddress()
  {
    return this.asu;
  }
  
  public UserAddress getBuyerBillingAddress()
  {
    return this.asx;
  }
  
  public UserAddress getBuyerShippingAddress()
  {
    return this.asy;
  }
  
  public String getEmail()
  {
    return this.ast;
  }
  
  public String getGoogleTransactionId()
  {
    return this.asq;
  }
  
  public InstrumentInfo[] getInstrumentInfos()
  {
    return this.asz;
  }
  
  public LoyaltyWalletObject[] getLoyaltyWalletObjects()
  {
    return this.atb;
  }
  
  public String getMerchantTransactionId()
  {
    return this.asr;
  }
  
  public OfferWalletObject[] getOfferWalletObjects()
  {
    return this.atc;
  }
  
  public String[] getPaymentDescriptions()
  {
    return this.asw;
  }
  
  @Deprecated
  public Address getShippingAddress()
  {
    return this.asv;
  }
  
  public int getVersionCode()
  {
    return this.BR;
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
      MaskedWallet.this.asu = paramAddress;
      return this;
    }
    
    public Builder setBuyerBillingAddress(UserAddress paramUserAddress)
    {
      MaskedWallet.this.asx = paramUserAddress;
      return this;
    }
    
    public Builder setBuyerShippingAddress(UserAddress paramUserAddress)
    {
      MaskedWallet.this.asy = paramUserAddress;
      return this;
    }
    
    public Builder setEmail(String paramString)
    {
      MaskedWallet.this.ast = paramString;
      return this;
    }
    
    public Builder setGoogleTransactionId(String paramString)
    {
      MaskedWallet.this.asq = paramString;
      return this;
    }
    
    public Builder setInstrumentInfos(InstrumentInfo[] paramArrayOfInstrumentInfo)
    {
      MaskedWallet.this.asz = paramArrayOfInstrumentInfo;
      return this;
    }
    
    public Builder setLoyaltyWalletObjects(LoyaltyWalletObject[] paramArrayOfLoyaltyWalletObject)
    {
      MaskedWallet.this.atb = paramArrayOfLoyaltyWalletObject;
      return this;
    }
    
    public Builder setMerchantTransactionId(String paramString)
    {
      MaskedWallet.this.asr = paramString;
      return this;
    }
    
    public Builder setOfferWalletObjects(OfferWalletObject[] paramArrayOfOfferWalletObject)
    {
      MaskedWallet.this.atc = paramArrayOfOfferWalletObject;
      return this;
    }
    
    public Builder setPaymentDescriptions(String[] paramArrayOfString)
    {
      MaskedWallet.this.asw = paramArrayOfString;
      return this;
    }
    
    public Builder setShippingAddress(Address paramAddress)
    {
      MaskedWallet.this.asv = paramAddress;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wallet/MaskedWallet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */