package com.amazon.inapp.purchasing;

import com.amazon.venezia.command.SuccessResult;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class KiwiPurchaseUpdatesCommandTask
  extends KiwiBaseCommandTask
{
  private static final String COMMAND_NAME = "purchase_updates";
  private static final String COMMAND_VERSION = "1.0";
  private static final String TAG = "KiwiPurchaseUpdatesCommandTask";
  private final Offset _offset;
  
  KiwiPurchaseUpdatesCommandTask(Offset paramOffset, String paramString)
  {
    super("purchase_updates", "1.0", paramString);
    this._offset = paramOffset;
    if (Offset.BEGINNING.equals(this._offset)) {}
    for (paramOffset = null;; paramOffset = this._offset.toString())
    {
      addCommandData("cursor", paramOffset);
      return;
    }
  }
  
  private PurchaseUpdatesResponse getFailedResponse()
  {
    return new PurchaseUpdatesResponse(getRequestId(), null, PurchaseUpdatesResponse.PurchaseUpdatesRequestStatus.FAILED, null, null, this._offset, false);
  }
  
  private void notifyObserver(final PurchaseUpdatesResponse paramPurchaseUpdatesResponse)
  {
    postRunnableToMainLooper(new Runnable()
    {
      public void run()
      {
        PurchasingObserver localPurchasingObserver = PurchasingManager.getPurchasingObserver();
        if (localPurchasingObserver != null)
        {
          if (Logger.isTraceOn()) {
            Logger.trace("KiwiPurchaseUpdatesCommandTask", "Invoking onPurchaseUpdatesResponse with " + paramPurchaseUpdatesResponse);
          }
          localPurchasingObserver.onPurchaseUpdatesResponse(paramPurchaseUpdatesResponse);
        }
      }
    });
  }
  
  protected void onSuccess(SuccessResult paramSuccessResult)
  {
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiPurchaseUpdatesCommandTask", "onSuccess");
    }
    paramSuccessResult = paramSuccessResult.getData();
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiPurchaseUpdatesCommandTask", "data: " + paramSuccessResult);
    }
    Object localObject1 = (String)paramSuccessResult.get("errorMessage");
    String str = (String)paramSuccessResult.get("userId");
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiPurchaseUpdatesCommandTask", "onSuccess: errorMessage: \"" + (String)localObject1 + "\"");
    }
    if (isNullOrEmpty((String)localObject1)) {
      for (;;)
      {
        try
        {
          localObject1 = new HashSet();
          HashSet localHashSet = new HashSet();
          Object localObject2 = new JSONArray((String)paramSuccessResult.get("receipts"));
          int i = 0;
          if (i < ((JSONArray)localObject2).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
            Receipt localReceipt = getReceiptFromReceiptJson(localJSONObject);
            if (verifyReceipt(str, localReceipt, localJSONObject)) {
              ((Set)localObject1).add(localReceipt);
            }
          }
          else
          {
            localObject2 = new JSONArray((String)paramSuccessResult.get("revocations"));
            i = 0;
            if (i < ((JSONArray)localObject2).length())
            {
              localHashSet.add(((JSONArray)localObject2).getString(i));
              i += 1;
              continue;
            }
            localObject2 = (String)paramSuccessResult.get("cursor");
            boolean bool = "true".equalsIgnoreCase((String)paramSuccessResult.get("hasMore"));
            if (isNullOrEmpty((String)localObject2))
            {
              paramSuccessResult = Offset.BEGINNING;
              localObject2 = PurchaseUpdatesResponse.PurchaseUpdatesRequestStatus.SUCCESSFUL;
              notifyObserver(new PurchaseUpdatesResponse(getRequestId(), str, (PurchaseUpdatesResponse.PurchaseUpdatesRequestStatus)localObject2, (Set)localObject1, localHashSet, paramSuccessResult, bool));
              return;
            }
            paramSuccessResult = Offset.fromString((String)localObject2);
            continue;
          }
          i += 1;
        }
        catch (JSONException paramSuccessResult)
        {
          if (Logger.isErrorOn()) {
            Logger.error("KiwiPurchaseUpdatesCommandTask", "Error parsing purchase updates JSON: " + paramSuccessResult.getMessage());
          }
          sendFailedResponse();
          return;
        }
      }
    }
  }
  
  protected void sendFailedResponse()
  {
    notifyObserver(getFailedResponse());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/KiwiPurchaseUpdatesCommandTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */