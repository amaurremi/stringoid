package com.google.android.gms.wallet;

public final class FullWalletRequest$Builder
{
  private FullWalletRequest$Builder(FullWalletRequest paramFullWalletRequest) {}
  
  public FullWalletRequest build()
  {
    return this.ajb;
  }
  
  public Builder setCart(Cart paramCart)
  {
    this.ajb.aja = paramCart;
    return this;
  }
  
  public Builder setGoogleTransactionId(String paramString)
  {
    this.ajb.aiQ = paramString;
    return this;
  }
  
  public Builder setMerchantTransactionId(String paramString)
  {
    this.ajb.aiR = paramString;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/FullWalletRequest$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */