package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

public final class dl
  extends dg.a
{
  private final PlayStorePurchaseListener mC;
  
  public dl(PlayStorePurchaseListener paramPlayStorePurchaseListener)
  {
    this.mC = paramPlayStorePurchaseListener;
  }
  
  public void a(df paramdf)
  {
    this.mC.onInAppPurchaseFinished(new dj(paramdf));
  }
  
  public boolean isValidPurchase(String paramString)
  {
    return this.mC.isValidPurchase(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/dl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */