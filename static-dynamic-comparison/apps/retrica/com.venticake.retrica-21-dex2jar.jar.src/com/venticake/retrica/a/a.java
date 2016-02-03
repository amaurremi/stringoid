package com.venticake.retrica.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import com.amazon.inapp.purchasing.BasePurchasingObserver;
import com.amazon.inapp.purchasing.GetUserIdResponse;
import com.amazon.inapp.purchasing.GetUserIdResponse.GetUserIdRequestStatus;
import com.amazon.inapp.purchasing.ItemDataResponse;
import com.amazon.inapp.purchasing.Offset;
import com.amazon.inapp.purchasing.PurchaseResponse;
import com.amazon.inapp.purchasing.PurchaseResponse.PurchaseRequestStatus;
import com.amazon.inapp.purchasing.PurchaseUpdatesResponse;
import com.amazon.inapp.purchasing.PurchasingManager;
import com.amazon.inapp.purchasing.Receipt;
import java.util.Set;

@SuppressLint({"NewApi"})
public class a
  extends BasePurchasingObserver
{
  private d a;
  private k b;
  
  public a(Activity paramActivity, d paramd)
  {
    super(paramActivity);
    this.a = paramd;
  }
  
  private boolean a(String paramString)
  {
    return this.a.a(paramString);
  }
  
  public void a(k paramk)
  {
    this.b = paramk;
  }
  
  public void onGetUserIdResponse(GetUserIdResponse paramGetUserIdResponse)
  {
    Log.i("amazon_iap", "onGetUserIdResponse: requestId (" + paramGetUserIdResponse.getRequestId() + ") userIdRequestStatus: " + paramGetUserIdResponse.getUserIdRequestStatus() + ")");
    GetUserIdResponse.GetUserIdRequestStatus localGetUserIdRequestStatus = paramGetUserIdResponse.getUserIdRequestStatus();
    switch (a()[localGetUserIdRequestStatus.ordinal()])
    {
    default: 
      return;
    case 1: 
      paramGetUserIdResponse = paramGetUserIdResponse.getUserId();
      Log.i("amazon_iap", "onGetUserIdResponse: save userId (" + paramGetUserIdResponse + ") as current user");
      boolean bool = a(paramGetUserIdResponse);
      Log.i("amazon_iap", "onGetUserIdResponse: call onGetUserIdResponseSuccess for userId (" + paramGetUserIdResponse + ") userChanged (" + bool + ")");
      this.b.a(paramGetUserIdResponse, bool);
      paramGetUserIdResponse = this.a.b();
      Log.i("amazon_iap", "onGetUserIdResponse: call initiatePurchaseUpdatesRequest from offset (" + paramGetUserIdResponse + ")");
      PurchasingManager.initiatePurchaseUpdatesRequest(paramGetUserIdResponse);
      return;
    }
    Log.i("amazon_iap", "onGetUserIdResponse: FAILED");
    this.b.a_(paramGetUserIdResponse.getRequestId());
  }
  
  public void onItemDataResponse(ItemDataResponse paramItemDataResponse)
  {
    Object localObject = paramItemDataResponse.getItemDataRequestStatus();
    Log.i("amazon_iap", "onItemDataResponse: itemDataRequestStatus (" + localObject + ")");
    switch (b()[localObject.ordinal()])
    {
    default: 
      return;
    case 3: 
      localObject = paramItemDataResponse.getUnavailableSkus();
      Log.i("amazon_iap", "onItemDataResponse: " + ((Set)localObject).size() + " unavailable skus");
      if (!((Set)localObject).isEmpty())
      {
        Log.i("amazon_iap", "onItemDataResponse: call onItemDataResponseUnavailableSkus");
        this.b.a((Set)localObject);
      }
    case 1: 
      Log.d("amazon_iap", "onItemDataResponse: successful.  The item data map in this response includes the valid SKUs");
      this.b.a(paramItemDataResponse.getItemData());
      return;
    }
    Log.d("amazon_iap", "onItemDataResponse: failed, should retry request");
    this.b.b_(paramItemDataResponse.getRequestId());
  }
  
  public void onPurchaseResponse(PurchaseResponse paramPurchaseResponse)
  {
    b localb = null;
    Object localObject2 = null;
    Object localObject1 = null;
    String str2 = paramPurchaseResponse.getRequestId();
    String str1 = paramPurchaseResponse.getUserId();
    PurchaseResponse.PurchaseRequestStatus localPurchaseRequestStatus = paramPurchaseResponse.getPurchaseRequestStatus();
    Log.i("amazon_iap", "onPurchaseResponse: requestId (" + str2 + ") userId (" + str1 + ") purchaseRequestStatus (" + localPurchaseRequestStatus + ")");
    if (!this.a.b(str1))
    {
      Log.i("amazon_iap", "onPurchaseResponse: userId (" + str1 + ") in response is NOT the same as current user!");
      return;
    }
    switch (d()[localPurchaseRequestStatus.ordinal()])
    {
    default: 
      return;
    case 1: 
      localObject1 = paramPurchaseResponse.getReceipt();
      Log.i("amazon_iap", "onPurchaseResponse: receipt itemType (" + ((Receipt)localObject1).getItemType() + ") SKU (" + ((Receipt)localObject1).getSku() + ") purchaseToken (" + ((Receipt)localObject1).getPurchaseToken() + ")");
      Log.i("amazon_iap", "onPurchaseResponse: call savePurchaseReceipt for requestId (" + paramPurchaseResponse.getRequestId() + ")");
      localObject1 = this.a.a(paramPurchaseResponse);
      if (localObject1 == null)
      {
        Log.i("amazon_iap", "onPurchaseResponse: could not save purchase receipt for requestId (" + paramPurchaseResponse.getRequestId() + "), skipping fulfillment");
        return;
      }
      Log.i("amazon_iap", "onPurchaseResponse: fulfill purchase with AsyncTask");
      new e(this, null).execute(new b[] { localObject1 });
      return;
    case 4: 
      Log.i("amazon_iap", "onPurchaseResponse: already entitled so remove purchase request from local storage");
      localb = this.a.j(str2);
      this.a.o(str2);
      paramPurchaseResponse = (PurchaseResponse)localObject1;
      if (localb != null) {
        paramPurchaseResponse = localb.f();
      }
      this.b.a(str1, paramPurchaseResponse);
      return;
    case 3: 
      Log.i("amazon_iap", "onPurchaseResponse: invalid SKU! Should never get here, onItemDataResponse should have disabled buy button already.");
      localObject1 = this.a.j(str2);
      this.a.o(str2);
      paramPurchaseResponse = localb;
      if (localObject1 != null) {
        paramPurchaseResponse = ((b)localObject1).f();
      }
      this.b.b(str1, paramPurchaseResponse);
      return;
    }
    Log.i("amazon_iap", "onPurchaseResponse: failed so remove purchase request from local storage");
    localObject1 = this.a.j(str2);
    this.a.o(str2);
    paramPurchaseResponse = (PurchaseResponse)localObject2;
    if (localObject1 != null) {
      paramPurchaseResponse = ((b)localObject1).f();
    }
    this.b.c(str2, paramPurchaseResponse);
  }
  
  public void onPurchaseUpdatesResponse(PurchaseUpdatesResponse paramPurchaseUpdatesResponse)
  {
    Object localObject1 = paramPurchaseUpdatesResponse.getUserId();
    Object localObject2 = paramPurchaseUpdatesResponse.getPurchaseUpdatesRequestStatus();
    Log.i("amazon_iap", "onPurchaseUpdatesResponse: userId (" + (String)localObject1 + ") purchaseUpdatesRequestStatus (" + localObject2 + ")");
    if (!this.a.b((String)localObject1))
    {
      Log.i("amazon_iap", "onPurchaseUpdatesResponse: userId (" + (String)localObject1 + ") in response is NOT the same as current user!");
      return;
    }
    switch (c()[localObject2.ordinal()])
    {
    default: 
      return;
    case 1: 
      localObject1 = paramPurchaseUpdatesResponse.getReceipts();
      localObject2 = paramPurchaseUpdatesResponse.getRevokedSkus();
      Log.i("amazon_iap", "onPurchaseUpdatesResponse: (" + ((Set)localObject1).size() + ") receipts and (" + ((Set)localObject2).size() + ") revoked SKUs");
      if ((!((Set)localObject1).isEmpty()) || (!((Set)localObject2).isEmpty()))
      {
        localObject1 = new g(paramPurchaseUpdatesResponse.getUserId(), (Set)localObject1, (Set)localObject2);
        new f(this, null).execute(new g[] { localObject1 });
      }
      localObject1 = paramPurchaseUpdatesResponse.getOffset();
      if (paramPurchaseUpdatesResponse.isMore())
      {
        Log.i("amazon_iap", "onPurchaseUpdatesResponse: more updates, call initiatePurchaseUpdatesRequest with offset: " + localObject1);
        PurchasingManager.initiatePurchaseUpdatesRequest((Offset)localObject1);
      }
      this.a.a((Offset)localObject1);
      return;
    }
    Log.i("amazon_iap", "onPurchaseUpdatesResponse: FAILED: response: " + paramPurchaseUpdatesResponse);
    this.b.c(paramPurchaseUpdatesResponse.getRequestId());
  }
  
  public void onSdkAvailable(boolean paramBoolean)
  {
    Log.i("amazon_iap", "onSdkAvailable: isSandboxMode: " + paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */