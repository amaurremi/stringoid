package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;

public final class dh
  extends dc.a
{
  private final InAppPurchaseListener mB;
  
  public dh(InAppPurchaseListener paramInAppPurchaseListener)
  {
    this.mB = paramInAppPurchaseListener;
  }
  
  public void a(db paramdb)
  {
    this.mB.onInAppPurchaseRequested(new dk(paramdb));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */