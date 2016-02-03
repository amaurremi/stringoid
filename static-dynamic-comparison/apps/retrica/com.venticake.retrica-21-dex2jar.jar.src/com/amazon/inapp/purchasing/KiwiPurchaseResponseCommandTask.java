package com.amazon.inapp.purchasing;

import com.amazon.venezia.command.SuccessResult;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class KiwiPurchaseResponseCommandTask
  extends KiwiBaseCommandTask
{
  private static final String COMMAND_NAME = "purchase_response";
  private static final String COMMAND_VERSION = "1.0";
  private static final String TAG = "KiwiPurchaseResponseCommandTask";
  
  KiwiPurchaseResponseCommandTask(String paramString)
  {
    super("purchase_response", "1.0", paramString);
  }
  
  protected void onSuccess(SuccessResult paramSuccessResult)
  {
    Object localObject2 = null;
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiPurchaseResponseCommandTask", "onSuccess");
    }
    Object localObject1 = paramSuccessResult.getData();
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiPurchaseResponseCommandTask", "data: " + localObject1);
    }
    paramSuccessResult = (String)((Map)localObject1).get("errorMessage");
    String str = (String)((Map)localObject1).get("userId");
    Object localObject3 = (String)((Map)localObject1).get("receipt");
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiPurchaseResponseCommandTask", "onSuccess: errorMessage: \"" + paramSuccessResult + "\" receipt: \"" + (String)localObject3 + "\"");
    }
    localObject1 = PurchaseResponse.PurchaseRequestStatus.FAILED;
    if ((isNullOrEmpty(paramSuccessResult)) && (!isNullOrEmpty((String)localObject3))) {}
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject((String)localObject3);
        paramSuccessResult = localJSONObject.getString("orderStatus");
      }
      catch (JSONException paramSuccessResult)
      {
        JSONObject localJSONObject;
        if (!Logger.isErrorOn()) {
          continue;
        }
        Logger.error("KiwiPurchaseResponseCommandTask", "Error parsing receipt JSON: " + paramSuccessResult.getMessage());
        PurchaseResponse.PurchaseRequestStatus localPurchaseRequestStatus = PurchaseResponse.PurchaseRequestStatus.FAILED;
        paramSuccessResult = (SuccessResult)localObject2;
        continue;
        paramSuccessResult = null;
        continue;
      }
      try
      {
        localObject1 = PurchaseResponse.PurchaseRequestStatus.valueOf(paramSuccessResult);
        if (PurchaseResponse.PurchaseRequestStatus.SUCCESSFUL == localObject1)
        {
          localObject3 = getReceiptFromReceiptJson(localJSONObject);
          paramSuccessResult = (SuccessResult)localObject3;
          if (!verifyReceipt(str, (Receipt)localObject3, localJSONObject))
          {
            localObject1 = PurchaseResponse.PurchaseRequestStatus.FAILED;
            paramSuccessResult = null;
          }
          postRunnableToMainLooper(new Runnable()
          {
            public void run()
            {
              PurchasingObserver localPurchasingObserver = PurchasingManager.getPurchasingObserver();
              if (Logger.isTraceOn()) {
                Logger.trace("KiwiPurchaseResponseCommandTask", "About to invoke onPurchaseResponse with PurchasingObserver: " + localPurchasingObserver);
              }
              if (localPurchasingObserver != null)
              {
                if (Logger.isTraceOn()) {
                  Logger.trace("KiwiPurchaseResponseCommandTask", "Invoking onPurchaseResponse with " + this.val$purchaseResponse);
                }
                localPurchasingObserver.onPurchaseResponse(this.val$purchaseResponse);
                if (Logger.isTraceOn()) {
                  Logger.trace("KiwiPurchaseResponseCommandTask", "No exceptions were thrown when invoking onPurchaseResponse");
                }
                ImplementationFactory.getRequestHandler().sendPurchaseResponseReceivedRequest(KiwiPurchaseResponseCommandTask.this.getRequestId());
              }
            }
          });
          return;
        }
      }
      catch (Exception localException)
      {
        if (Logger.isErrorOn()) {
          Logger.error("KiwiPurchaseResponseCommandTask", "Invalid order status " + paramSuccessResult);
        }
        localPurchaseRequestStatus = PurchaseResponse.PurchaseRequestStatus.FAILED;
        continue;
      }
      paramSuccessResult = (SuccessResult)localObject2;
    }
  }
  
  protected void sendFailedResponse()
  {
    postRunnableToMainLooper(new Runnable()
    {
      public void run()
      {
        PurchasingObserver localPurchasingObserver = PurchasingManager.getPurchasingObserver();
        PurchaseResponse localPurchaseResponse = new PurchaseResponse(KiwiPurchaseResponseCommandTask.this.getRequestId(), null, null, PurchaseResponse.PurchaseRequestStatus.FAILED);
        if (localPurchasingObserver != null)
        {
          if (Logger.isTraceOn()) {
            Logger.trace("KiwiPurchaseResponseCommandTask", "Invoking onPurchaseResponse with " + localPurchaseResponse);
          }
          localPurchasingObserver.onPurchaseResponse(localPurchaseResponse);
        }
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/KiwiPurchaseResponseCommandTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */