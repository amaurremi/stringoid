package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

public final class MaskedWalletRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<MaskedWalletRequest> CREATOR = new l();
  String aiL;
  String aiR;
  boolean ajF;
  boolean ajG;
  boolean ajH;
  String ajI;
  String ajJ;
  boolean ajK;
  boolean ajL;
  CountrySpecification[] ajM;
  boolean ajN;
  boolean ajO;
  ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> ajP;
  Cart aja;
  private final int xM;
  
  MaskedWalletRequest()
  {
    this.xM = 3;
    this.ajN = true;
    this.ajO = true;
  }
  
  MaskedWalletRequest(int paramInt, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, String paramString3, String paramString4, Cart paramCart, boolean paramBoolean4, boolean paramBoolean5, CountrySpecification[] paramArrayOfCountrySpecification, boolean paramBoolean6, boolean paramBoolean7, ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> paramArrayList)
  {
    this.xM = paramInt;
    this.aiR = paramString1;
    this.ajF = paramBoolean1;
    this.ajG = paramBoolean2;
    this.ajH = paramBoolean3;
    this.ajI = paramString2;
    this.aiL = paramString3;
    this.ajJ = paramString4;
    this.aja = paramCart;
    this.ajK = paramBoolean4;
    this.ajL = paramBoolean5;
    this.ajM = paramArrayOfCountrySpecification;
    this.ajN = paramBoolean6;
    this.ajO = paramBoolean7;
    this.ajP = paramArrayList;
  }
  
  public static MaskedWalletRequest.Builder newBuilder()
  {
    MaskedWalletRequest localMaskedWalletRequest = new MaskedWalletRequest();
    localMaskedWalletRequest.getClass();
    return new MaskedWalletRequest.Builder(localMaskedWalletRequest, null);
  }
  
  public boolean allowDebitCard()
  {
    return this.ajO;
  }
  
  public boolean allowPrepaidCard()
  {
    return this.ajN;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> getAllowedCountrySpecificationsForShipping()
  {
    return this.ajP;
  }
  
  public CountrySpecification[] getAllowedShippingCountrySpecifications()
  {
    return this.ajM;
  }
  
  public Cart getCart()
  {
    return this.aja;
  }
  
  public String getCurrencyCode()
  {
    return this.aiL;
  }
  
  public String getEstimatedTotalPrice()
  {
    return this.ajI;
  }
  
  public String getMerchantName()
  {
    return this.ajJ;
  }
  
  public String getMerchantTransactionId()
  {
    return this.aiR;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public boolean isBillingAgreement()
  {
    return this.ajL;
  }
  
  public boolean isPhoneNumberRequired()
  {
    return this.ajF;
  }
  
  public boolean isShippingAddressRequired()
  {
    return this.ajG;
  }
  
  public boolean shouldRetrieveWalletObjects()
  {
    return this.ajK;
  }
  
  public boolean useMinimalBillingAddress()
  {
    return this.ajH;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    l.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/MaskedWalletRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */