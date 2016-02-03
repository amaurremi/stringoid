package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class FullWallet
  implements SafeParcelable
{
  public static final Parcelable.Creator<FullWallet> CREATOR = new f();
  String aiN;
  String aiO;
  ProxyCard aiP;
  String aiQ;
  Address aiR;
  Address aiS;
  String[] aiT;
  UserAddress aiU;
  UserAddress aiV;
  InstrumentInfo[] aiW;
  private final int xJ;
  
  private FullWallet()
  {
    this.xJ = 1;
  }
  
  FullWallet(int paramInt, String paramString1, String paramString2, ProxyCard paramProxyCard, String paramString3, Address paramAddress1, Address paramAddress2, String[] paramArrayOfString, UserAddress paramUserAddress1, UserAddress paramUserAddress2, InstrumentInfo[] paramArrayOfInstrumentInfo)
  {
    this.xJ = paramInt;
    this.aiN = paramString1;
    this.aiO = paramString2;
    this.aiP = paramProxyCard;
    this.aiQ = paramString3;
    this.aiR = paramAddress1;
    this.aiS = paramAddress2;
    this.aiT = paramArrayOfString;
    this.aiU = paramUserAddress1;
    this.aiV = paramUserAddress2;
    this.aiW = paramArrayOfInstrumentInfo;
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
  
  public String getMerchantTransactionId()
  {
    return this.aiO;
  }
  
  public String[] getPaymentDescriptions()
  {
    return this.aiT;
  }
  
  public ProxyCard getProxyCard()
  {
    return this.aiP;
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
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wallet/FullWallet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */