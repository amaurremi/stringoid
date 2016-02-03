package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class FullWalletRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<FullWalletRequest> CREATOR = new g();
  private final int BR;
  Cart asA;
  String asq;
  String asr;
  
  FullWalletRequest()
  {
    this.BR = 1;
  }
  
  FullWalletRequest(int paramInt, String paramString1, String paramString2, Cart paramCart)
  {
    this.BR = paramInt;
    this.asq = paramString1;
    this.asr = paramString2;
    this.asA = paramCart;
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
    return this.asA;
  }
  
  public String getGoogleTransactionId()
  {
    return this.asq;
  }
  
  public String getMerchantTransactionId()
  {
    return this.asr;
  }
  
  public int getVersionCode()
  {
    return this.BR;
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
      FullWalletRequest.this.asA = paramCart;
      return this;
    }
    
    public Builder setGoogleTransactionId(String paramString)
    {
      FullWalletRequest.this.asq = paramString;
      return this;
    }
    
    public Builder setMerchantTransactionId(String paramString)
    {
      FullWalletRequest.this.asr = paramString;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wallet/FullWalletRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */