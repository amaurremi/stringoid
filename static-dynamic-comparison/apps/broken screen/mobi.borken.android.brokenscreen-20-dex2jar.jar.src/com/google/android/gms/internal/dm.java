package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

public final class dm
  extends dh.a
{
  private final PlayStorePurchaseListener mA;
  
  public dm(PlayStorePurchaseListener paramPlayStorePurchaseListener)
  {
    this.mA = paramPlayStorePurchaseListener;
  }
  
  public void a(dg paramdg)
  {
    this.mA.onInAppPurchaseFinished(new dk(paramdg));
  }
  
  public boolean isValidPurchase(String paramString)
  {
    return this.mA.isValidPurchase(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/dm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */