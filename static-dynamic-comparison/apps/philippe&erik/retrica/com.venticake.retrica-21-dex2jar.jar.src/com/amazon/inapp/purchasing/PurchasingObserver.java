package com.amazon.inapp.purchasing;

import android.content.Context;
import java.lang.ref.WeakReference;

public abstract class PurchasingObserver
{
  private WeakReference<Context> _contextReference;
  
  public PurchasingObserver(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Provided Context must not be null");
    }
    this._contextReference = new WeakReference(paramContext.getApplicationContext());
  }
  
  final Context getContext()
  {
    return (Context)this._contextReference.get();
  }
  
  public abstract void onGetUserIdResponse(GetUserIdResponse paramGetUserIdResponse);
  
  public abstract void onItemDataResponse(ItemDataResponse paramItemDataResponse);
  
  public abstract void onPurchaseResponse(PurchaseResponse paramPurchaseResponse);
  
  public abstract void onPurchaseUpdatesResponse(PurchaseUpdatesResponse paramPurchaseUpdatesResponse);
  
  public abstract void onSdkAvailable(boolean paramBoolean);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/PurchasingObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */