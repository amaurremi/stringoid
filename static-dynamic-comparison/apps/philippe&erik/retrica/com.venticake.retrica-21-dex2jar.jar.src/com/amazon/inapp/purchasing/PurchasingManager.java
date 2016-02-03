package com.amazon.inapp.purchasing;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;

public final class PurchasingManager
{
  public static final String BUILD_ID = "1.0.3";
  private static final HandlerAdapter HANDLER = HandlerManager.getHandlerAdapter("PurchasingManagerHandlerThread");
  static final String HANDLER_THREAD_NAME = "PurchasingManagerHandlerThread";
  public static final int ITEM_DATA_REQUEST_MAX_SKUS = 100;
  private static final String TAG = "PurchasingManager";
  private static PurchasingObserver registeredPurchasingObserver;
  
  static
  {
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        Log.i("PurchasingManager", "Purchasing Framework initialization complete. Build ID 1.0.3");
      }
    };
    HANDLER.post(local1);
  }
  
  private static void checkObserverRegistered()
  {
    if (registeredPurchasingObserver == null) {
      throw new IllegalStateException("You must register a PurchasingObserver before invoking this operation");
    }
  }
  
  static Context getObserverContext()
  {
    if (registeredPurchasingObserver == null) {
      return null;
    }
    return registeredPurchasingObserver.getContext();
  }
  
  static PurchasingObserver getPurchasingObserver()
  {
    return registeredPurchasingObserver;
  }
  
  public static String initiateGetUserIdRequest()
  {
    checkObserverRegistered();
    return initiateRequest(new GetUserIdRequest());
  }
  
  public static String initiateItemDataRequest(Set<String> paramSet)
  {
    checkObserverRegistered();
    return initiateRequest(new ItemDataRequest(new HashSet(paramSet)));
  }
  
  public static String initiatePurchaseRequest(String paramString)
  {
    checkObserverRegistered();
    return initiateRequest(new PurchaseRequest(paramString));
  }
  
  public static String initiatePurchaseUpdatesRequest(Offset paramOffset)
  {
    checkObserverRegistered();
    return initiateRequest(new PurchaseUpdatesRequest(paramOffset));
  }
  
  private static String initiateRequest(Request paramRequest)
  {
    HANDLER.post(paramRequest.getRunnable());
    return paramRequest.getRequestId();
  }
  
  public static void registerObserver(PurchasingObserver paramPurchasingObserver)
  {
    if (Logger.isTraceOn()) {
      Logger.trace("PurchasingManager", "PurchasingObserver registered: " + paramPurchasingObserver);
    }
    if (paramPurchasingObserver == null) {
      throw new IllegalArgumentException("Provided PurchasingObserver must not be null");
    }
    registeredPurchasingObserver = paramPurchasingObserver;
    paramPurchasingObserver = new Runnable()
    {
      public void run()
      {
        Runnable local1 = new Runnable()
        {
          public void run()
          {
            PurchasingManager.this.onSdkAvailable(ImplementationFactory.isSandboxMode());
          }
        };
        new Handler(PurchasingManager.getObserverContext().getMainLooper()).post(local1);
      }
    };
    HANDLER.post(paramPurchasingObserver);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/PurchasingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */