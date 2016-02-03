package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.internal.hm;

public final class MaskedWallet
  implements SafeParcelable
{
  public static final Parcelable.Creator<MaskedWallet> CREATOR = new k();
  String aiQ;
  String aiR;
  String aiT;
  Address aiU;
  Address aiV;
  String[] aiW;
  UserAddress aiX;
  UserAddress aiY;
  InstrumentInfo[] aiZ;
  LoyaltyWalletObject[] ajC;
  OfferWalletObject[] ajD;
  private final int xM;
  
  private MaskedWallet()
  {
    this.xM = 2;
  }
  
  MaskedWallet(int paramInt, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, Address paramAddress1, Address paramAddress2, LoyaltyWalletObject[] paramArrayOfLoyaltyWalletObject, OfferWalletObject[] paramArrayOfOfferWalletObject, UserAddress paramUserAddress1, UserAddress paramUserAddress2, InstrumentInfo[] paramArrayOfInstrumentInfo)
  {
    this.xM = paramInt;
    this.aiQ = paramString1;
    this.aiR = paramString2;
    this.aiW = paramArrayOfString;
    this.aiT = paramString3;
    this.aiU = paramAddress1;
    this.aiV = paramAddress2;
    this.ajC = paramArrayOfLoyaltyWalletObject;
    this.ajD = paramArrayOfOfferWalletObject;
    this.aiX = paramUserAddress1;
    this.aiY = paramUserAddress2;
    this.aiZ = paramArrayOfInstrumentInfo;
  }
  
  public static MaskedWallet.Builder newBuilderFrom(MaskedWallet paramMaskedWallet)
  {
    hm.f(paramMaskedWallet);
    return ng().setGoogleTransactionId(paramMaskedWallet.getGoogleTransactionId()).setMerchantTransactionId(paramMaskedWallet.getMerchantTransactionId()).setPaymentDescriptions(paramMaskedWallet.getPaymentDescriptions()).setInstrumentInfos(paramMaskedWallet.getInstrumentInfos()).setEmail(paramMaskedWallet.getEmail()).setLoyaltyWalletObjects(paramMaskedWallet.getLoyaltyWalletObjects()).setOfferWalletObjects(paramMaskedWallet.getOfferWalletObjects()).setBuyerBillingAddress(paramMaskedWallet.getBuyerBillingAddress()).setBuyerShippingAddress(paramMaskedWallet.getBuyerShippingAddress());
  }
  
  public static MaskedWallet.Builder ng()
  {
    MaskedWallet localMaskedWallet = new MaskedWallet();
    localMaskedWallet.getClass();
    return new MaskedWallet.Builder(localMaskedWallet, null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @Deprecated
  public Address getBillingAddress()
  {
    return this.aiU;
  }
  
  public UserAddress getBuyerBillingAddress()
  {
    return this.aiX;
  }
  
  public UserAddress getBuyerShippingAddress()
  {
    return this.aiY;
  }
  
  public String getEmail()
  {
    return this.aiT;
  }
  
  public String getGoogleTransactionId()
  {
    return this.aiQ;
  }
  
  public InstrumentInfo[] getInstrumentInfos()
  {
    return this.aiZ;
  }
  
  public LoyaltyWalletObject[] getLoyaltyWalletObjects()
  {
    return this.ajC;
  }
  
  public String getMerchantTransactionId()
  {
    return this.aiR;
  }
  
  public OfferWalletObject[] getOfferWalletObjects()
  {
    return this.ajD;
  }
  
  public String[] getPaymentDescriptions()
  {
    return this.aiW;
  }
  
  @Deprecated
  public Address getShippingAddress()
  {
    return this.aiV;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    k.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/MaskedWallet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */