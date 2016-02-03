package com.amazon.inapp.purchasing;

import com.amazon.venezia.command.SuccessResult;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

final class KiwiGetItemDataRequestCommandTask
  extends KiwiBaseCommandTask
{
  private static final String COMMAND_NAME = "getItem_data";
  private static final String COMMAND_VERSION = "1.0";
  private static final String TAG = "KiwiGetItemDataRequestCommandTask";
  private final Set<String> _skus;
  
  KiwiGetItemDataRequestCommandTask(Set<String> paramSet, String paramString)
  {
    super("getItem_data", "1.0", paramString);
    this._skus = paramSet;
    addCommandData("skus", this._skus);
  }
  
  private ItemDataResponse getFailedResponse()
  {
    return new ItemDataResponse(getRequestId(), null, ItemDataResponse.ItemDataRequestStatus.FAILED, null);
  }
  
  private void notifyObserver(final ItemDataResponse paramItemDataResponse)
  {
    postRunnableToMainLooper(new Runnable()
    {
      public void run()
      {
        PurchasingObserver localPurchasingObserver = PurchasingManager.getPurchasingObserver();
        if (localPurchasingObserver != null)
        {
          if (Logger.isTraceOn()) {
            Logger.trace("KiwiGetItemDataRequestCommandTask", "Invoking onItemDataResponse with " + paramItemDataResponse);
          }
          localPurchasingObserver.onItemDataResponse(paramItemDataResponse);
        }
      }
    });
  }
  
  protected void onSuccess(SuccessResult paramSuccessResult)
  {
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiGetItemDataRequestCommandTask", "onSuccess");
    }
    paramSuccessResult = paramSuccessResult.getData();
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiGetItemDataRequestCommandTask", "data: " + paramSuccessResult);
    }
    Object localObject = (String)paramSuccessResult.get("errorMessage");
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiGetItemDataRequestCommandTask", "onSuccess: errorMessage: \"" + (String)localObject + "\"");
    }
    if (isNullOrEmpty((String)localObject))
    {
      localObject = new HashSet();
      HashMap localHashMap = new HashMap();
      Iterator localIterator = this._skus.iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        if (!paramSuccessResult.containsKey(str1))
        {
          ((Set)localObject).add(str1);
        }
        else
        {
          try
          {
            JSONObject localJSONObject = new JSONObject((String)paramSuccessResult.get(str1));
            String str2 = localJSONObject.getString("title");
            String str3 = localJSONObject.getString("description");
            String str4 = localJSONObject.getString("iconUrl");
            localHashMap.put(str1, new Item(str1, localJSONObject.optString("price"), Item.ItemType.valueOf(localJSONObject.getString("itemType")), str2, str3, str4));
          }
          catch (JSONException localJSONException)
          {
            ((Set)localObject).add(str1);
          }
          if (Logger.isErrorOn()) {
            Logger.error("KiwiGetItemDataRequestCommandTask", "Error parsing JSON for SKU " + str1 + ": " + localJSONException.getMessage());
          }
        }
      }
      if (((Set)localObject).isEmpty()) {}
      for (paramSuccessResult = ItemDataResponse.ItemDataRequestStatus.SUCCESSFUL;; paramSuccessResult = ItemDataResponse.ItemDataRequestStatus.SUCCESSFUL_WITH_UNAVAILABLE_SKUS)
      {
        notifyObserver(new ItemDataResponse(getRequestId(), (Set)localObject, paramSuccessResult, localHashMap));
        return;
      }
    }
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiGetItemDataRequestCommandTask", "found error message: " + (String)localObject);
    }
    sendFailedResponse();
  }
  
  protected void sendFailedResponse()
  {
    notifyObserver(getFailedResponse());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/KiwiGetItemDataRequestCommandTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */