package com.google.android.gms.internal;

import android.content.Intent;
import android.os.IInterface;

public abstract interface df
  extends IInterface
{
  public abstract void finishPurchase();
  
  public abstract String getProductId();
  
  public abstract Intent getPurchaseData();
  
  public abstract int getResultCode();
  
  public abstract boolean isVerified();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */