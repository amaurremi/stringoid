package com.amazon.inapp.purchasing;

import com.amazon.android.Kiwi;
import com.amazon.android.framework.exception.KiwiException;
import com.amazon.android.framework.prompt.PromptContent;
import com.amazon.android.framework.prompt.PromptManager;
import com.amazon.android.framework.task.command.AbstractCommandTask;
import com.amazon.android.licensing.LicenseFailurePromptContentMapper;
import com.amazon.venezia.command.FailureResult;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

abstract class KiwiBaseCommandTask
  extends AbstractCommandTask
{
  private static final String DATE_FORMAT = "MM/dd/yyyy HH:mm:ss";
  protected static final String FALSE = "false";
  protected static final String KEY_CURSOR = "cursor";
  protected static final String KEY_DESCRIPTION = "description";
  protected static final String KEY_ERROR_MESSAGE = "errorMessage";
  protected static final String KEY_HAS_CONTENT = "hasContent";
  protected static final String KEY_HAS_MORE = "hasMore";
  protected static final String KEY_ICON_URL = "iconUrl";
  protected static final String KEY_ITEM_TYPE = "itemType";
  protected static final String KEY_ORDER_STATUS = "orderStatus";
  protected static final String KEY_PERIOD_DATE_END = "endDate";
  protected static final String KEY_PERIOD_DATE_START = "startDate";
  protected static final String KEY_PRICE = "price";
  protected static final String KEY_PURCHASE_ITEM_INTENT = "purchaseItemIntent";
  protected static final String KEY_RECEIPT = "receipt";
  protected static final String KEY_RECEIPTS = "receipts";
  protected static final String KEY_REQUEST_ID = "requestId";
  protected static final String KEY_REVOCATIONS = "revocations";
  protected static final String KEY_SDK_VERSION = "sdkVersion";
  protected static final String KEY_SIGNATURE = "signature";
  protected static final String KEY_SKU = "sku";
  protected static final String KEY_SKUS = "skus";
  protected static final String KEY_TITLE = "title";
  protected static final String KEY_TOKEN = "token";
  protected static final String KEY_USER_ID = "userId";
  protected static final String SDK_VERSION = "1.0";
  private static final String TAG = "KiwiBaseCommandTask";
  protected static final String TRUE = "true";
  private final Map<String, Object> _commandData;
  private final String _commandName;
  private final String _commandVersion;
  private final String _requestId;
  private LicenseFailurePromptContentMapper mapper = new LicenseFailurePromptContentMapper();
  
  KiwiBaseCommandTask(String paramString1, String paramString2, String paramString3)
  {
    this._requestId = paramString3;
    this._commandName = paramString1;
    this._commandVersion = paramString2;
    this._commandData = new HashMap();
    this._commandData.put("requestId", this._requestId);
    this._commandData.put("sdkVersion", "1.0");
  }
  
  protected void addCommandData(String paramString, Object paramObject)
  {
    this._commandData.put(paramString, paramObject);
  }
  
  protected Map<String, Object> getCommandData()
  {
    return this._commandData;
  }
  
  protected String getCommandName()
  {
    return this._commandName;
  }
  
  protected String getCommandVersion()
  {
    return this._commandVersion;
  }
  
  protected Date getDateFromString(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    try
    {
      paramString = localSimpleDateFormat.parse(paramString);
      long l = paramString.getTime();
      if (0L == l) {
        paramString = null;
      }
      return paramString;
    }
    catch (ParseException paramString)
    {
      throw new JSONException(paramString.getMessage());
    }
  }
  
  protected Receipt getReceiptFromReceiptJson(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.getString("sku");
    Item.ItemType localItemType = Item.ItemType.valueOf(paramJSONObject.getString("itemType"));
    String str2 = paramJSONObject.getString("token");
    if (Item.ItemType.SUBSCRIPTION == localItemType) {}
    for (paramJSONObject = getSubscriptionPeriodFromReceiptJson(paramJSONObject);; paramJSONObject = null) {
      return new Receipt(str1, localItemType, false, paramJSONObject, str2);
    }
  }
  
  protected String getRequestId()
  {
    return this._requestId;
  }
  
  protected SubscriptionPeriod getSubscriptionPeriodFromReceiptJson(JSONObject paramJSONObject)
  {
    Object localObject = null;
    if (!paramJSONObject.has("startDate")) {
      return null;
    }
    Date localDate = getDateFromString(paramJSONObject.getString("startDate"));
    paramJSONObject = paramJSONObject.optString("endDate");
    if (isNullOrEmpty(paramJSONObject)) {}
    for (paramJSONObject = (JSONObject)localObject;; paramJSONObject = getDateFromString(paramJSONObject)) {
      return new SubscriptionPeriod(localDate, paramJSONObject);
    }
  }
  
  protected boolean isExecutionNeeded()
  {
    return true;
  }
  
  protected boolean isNullOrEmpty(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0);
  }
  
  protected void onException(KiwiException paramKiwiException)
  {
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiBaseCommandTask", "onException, result: " + paramKiwiException.getMessage());
    }
    PromptManager localPromptManager = Kiwi.getPromptManager();
    paramKiwiException = this.mapper.map(paramKiwiException);
    if (paramKiwiException != null) {
      localPromptManager.present(new FailurePrompt(paramKiwiException));
    }
    sendFailedResponse();
  }
  
  protected void onFailure(FailureResult paramFailureResult)
  {
    if (paramFailureResult == null)
    {
      if (Logger.isTraceOn()) {
        Logger.trace("KiwiBaseCommandTask", "onFailure: null result");
      }
      return;
    }
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiBaseCommandTask", "onFailure: result message: " + paramFailureResult.getDisplayableMessage());
    }
    paramFailureResult = new FailurePrompt(new PromptContent(paramFailureResult.getDisplayableName(), paramFailureResult.getDisplayableMessage(), paramFailureResult.getButtonLabel(), paramFailureResult.show()));
    Kiwi.getPromptManager().present(paramFailureResult);
    sendFailedResponse();
  }
  
  protected void postRunnableToMainLooper(Runnable paramRunnable)
  {
    HandlerManager.getMainHandlerAdapter().post(paramRunnable);
  }
  
  protected abstract void sendFailedResponse();
  
  protected boolean verifyReceipt(String paramString, Receipt paramReceipt, JSONObject paramJSONObject)
  {
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiBaseCommandTask", "Validating receipt: " + paramReceipt);
    }
    paramJSONObject = paramJSONObject.optString("signature");
    boolean bool = false;
    if (!isNullOrEmpty(paramJSONObject))
    {
      bool = verifySignature(paramString, paramReceipt.getPurchaseToken(), paramJSONObject);
      if (!Logger.isTraceOn()) {
        break label162;
      }
      paramReceipt = new StringBuilder().append("signature verification ");
      if (bool)
      {
        paramString = "succeeded";
        Logger.error("KiwiBaseCommandTask", paramString + " for request ID " + getRequestId());
      }
    }
    while (!Logger.isTraceOn()) {
      for (;;)
      {
        return bool;
        paramString = "failed";
      }
    }
    Logger.error("KiwiBaseCommandTask", "a signature was not found in the receipt for request ID " + getRequestId());
    return false;
    label162:
    return bool;
  }
  
  protected boolean verifySignature(String paramString1, String paramString2, String paramString3)
  {
    return Kiwi.isSignedByKiwi(paramString1 + "-" + paramString2, paramString3);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/KiwiBaseCommandTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */