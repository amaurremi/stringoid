package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class FullWallet
  implements SafeParcelable
{
  public static final Parcelable.Creator<FullWallet> CREATOR = new f();
  String aiQ;
  String aiR;
  ProxyCard aiS;
  String aiT;
  Address aiU;
  Address aiV;
  String[] aiW;
  UserAddress aiX;
  UserAddress aiY;
  InstrumentInfo[] aiZ;
  private final int xM;
  
  private FullWallet()
  {
    this.xM = 1;
  }
  
  FullWallet(int paramInt, String paramString1, String paramString2, ProxyCard paramProxyCard, String paramString3, Address paramAddress1, Address paramAddress2, String[] paramArrayOfString, UserAddress paramUserAddress1, UserAddress paramUserAddress2, InstrumentInfo[] paramArrayOfInstrumentInfo)
  {
    this.xM = paramInt;
    this.aiQ = paramString1;
    this.aiR = paramString2;
    this.aiS = paramProxyCard;
    this.aiT = paramString3;
    this.aiU = paramAddress1;
    this.aiV = paramAddress2;
    this.aiW = paramArrayOfString;
    this.aiX = paramUserAddress1;
    this.aiY = paramUserAddress2;
    this.aiZ = paramArrayOfInstrumentInfo;
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
  
  public String getMerchantTransactionId()
  {
    return this.aiR;
  }
  
  public String[] getPaymentDescriptions()
  {
    return this.aiW;
  }
  
  public ProxyCard getProxyCard()
  {
    return this.aiS;
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
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/FullWallet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */