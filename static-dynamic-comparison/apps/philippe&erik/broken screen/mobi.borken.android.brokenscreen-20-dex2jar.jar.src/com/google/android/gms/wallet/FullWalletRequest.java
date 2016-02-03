package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class FullWalletRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<FullWalletRequest> CREATOR = new g();
  String aiN;
  String aiO;
  Cart aiX;
  private final int xJ;
  
  FullWalletRequest()
  {
    this.xJ = 1;
  }
  
  FullWalletRequest(int paramInt, String paramString1, String paramString2, Cart paramCart)
  {
    this.xJ = paramInt;
    this.aiN = paramString1;
    this.aiO = paramString2;
    this.aiX = paramCart;
  }
  
  public static Builder newBuilder()
  {
    FullWalletRequest localFullWalletRequest = new FullWalletRequest();
    localFullWalletRequest.getClass();
    return new Builder(null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Cart getCart()
  {
    return this.aiX;
  }
  
  public String getGoogleTransactionId()
  {
    return this.aiN;
  }
  
  public String getMerchantTransactionId()
  {
    return this.aiO;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel, paramInt);
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public FullWalletRequest build()
    {
      return FullWalletRequest.this;
    }
    
    public Builder setCart(Cart paramCart)
    {
      FullWalletRequest.this.aiX = paramCart;
      return this;
    }
    
    public Builder setGoogleTransactionId(String paramString)
    {
      FullWalletRequest.this.aiN = paramString;
      return this;
    }
    
    public Builder setMerchantTransactionId(String paramString)
    {
      FullWalletRequest.this.aiO = paramString;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wallet/FullWalletRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */