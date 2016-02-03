package com.amazon.inapp.purchasing;

import android.content.Context;

public class BasePurchasingObserver
  extends PurchasingObserver
{
  public BasePurchasingObserver(Context paramContext)
  {
    super(paramContext);
  }
  
  public void onGetUserIdResponse(GetUserIdResponse paramGetUserIdResponse) {}
  
  public void onItemDataResponse(ItemDataResponse paramItemDataResponse) {}
  
  public void onPurchaseResponse(PurchaseResponse paramPurchaseResponse) {}
  
  public void onPurchaseUpdatesResponse(PurchaseUpdatesResponse paramPurchaseUpdatesResponse) {}
  
  public void onSdkAvailable(boolean paramBoolean) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/BasePurchasingObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */