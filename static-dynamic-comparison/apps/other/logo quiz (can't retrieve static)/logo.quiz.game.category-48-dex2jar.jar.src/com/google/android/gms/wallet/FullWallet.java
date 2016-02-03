package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class FullWallet
  implements SafeParcelable
{
  public static final Parcelable.Creator<FullWallet> CREATOR = new f();
  private final int BR;
  String asq;
  String asr;
  ProxyCard ass;
  String ast;
  Address asu;
  Address asv;
  String[] asw;
  UserAddress asx;
  UserAddress asy;
  InstrumentInfo[] asz;
  
  private FullWallet()
  {
    this.BR = 1;
  }
  
  FullWallet(int paramInt, String paramString1, String paramString2, ProxyCard paramProxyCard, String paramString3, Address paramAddress1, Address paramAddress2, String[] paramArrayOfString, UserAddress paramUserAddress1, UserAddress paramUserAddress2, InstrumentInfo[] paramArrayOfInstrumentInfo)
  {
    this.BR = paramInt;
    this.asq = paramString1;
    this.asr = paramString2;
    this.ass = paramProxyCard;
    this.ast = paramString3;
    this.asu = paramAddress1;
    this.asv = paramAddress2;
    this.asw = paramArrayOfString;
    this.asx = paramUserAddress1;
    this.asy = paramUserAddress2;
    this.asz = paramArrayOfInstrumentInfo;
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
  
  public String getMerchantTransactionId()
  {
    return this.asr;
  }
  
  public String[] getPaymentDescriptions()
  {
    return this.asw;
  }
  
  public ProxyCard getProxyCard()
  {
    return this.ass;
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
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wallet/FullWallet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */