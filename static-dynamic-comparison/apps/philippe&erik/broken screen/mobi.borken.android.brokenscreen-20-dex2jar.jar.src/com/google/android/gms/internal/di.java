package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;

public final class di
  extends dd.a
{
  private final InAppPurchaseListener mz;
  
  public di(InAppPurchaseListener paramInAppPurchaseListener)
  {
    this.mz = paramInAppPurchaseListener;
  }
  
  public void a(dc paramdc)
  {
    this.mz.onInAppPurchaseRequested(new dl(paramdc));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/di.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */