package com.amazon.inapp.purchasing;

import com.amazon.venezia.command.SuccessResult;
import java.util.Map;

final class KiwiGetUserIdCommandTask
  extends KiwiBaseCommandTask
{
  private static final String COMMAND_NAME = "get_userId";
  private static final String COMMAND_VERSION = "1.0";
  private static final String TAG = "KiwiGetUserIdCommandTask";
  
  KiwiGetUserIdCommandTask(String paramString)
  {
    super("get_userId", "1.0", paramString);
  }
  
  private void notifyObserver(final GetUserIdResponse paramGetUserIdResponse)
  {
    postRunnableToMainLooper(new Runnable()
    {
      public void run()
      {
        PurchasingObserver localPurchasingObserver = PurchasingManager.getPurchasingObserver();
        if (localPurchasingObserver != null)
        {
          if (Logger.isTraceOn()) {
            Logger.trace("KiwiGetUserIdCommandTask", "Invoking onGetUserIdResponse with " + paramGetUserIdResponse);
          }
          localPurchasingObserver.onGetUserIdResponse(paramGetUserIdResponse);
        }
      }
    });
  }
  
  protected void onSuccess(SuccessResult paramSuccessResult)
  {
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiGetUserIdCommandTask", "onSuccess");
    }
    paramSuccessResult = paramSuccessResult.getData();
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiGetUserIdCommandTask", "data: " + paramSuccessResult);
    }
    paramSuccessResult = (String)paramSuccessResult.get("userId");
    if (!isNullOrEmpty(paramSuccessResult)) {}
    for (GetUserIdResponse.GetUserIdRequestStatus localGetUserIdRequestStatus = GetUserIdResponse.GetUserIdRequestStatus.SUCCESSFUL;; localGetUserIdRequestStatus = GetUserIdResponse.GetUserIdRequestStatus.FAILED)
    {
      notifyObserver(new GetUserIdResponse(getRequestId(), localGetUserIdRequestStatus, paramSuccessResult));
      return;
      if (Logger.isTraceOn()) {
        Logger.trace("KiwiGetUserIdCommandTask", "found null or empty user ID");
      }
      paramSuccessResult = null;
    }
  }
  
  protected void sendFailedResponse()
  {
    notifyObserver(new GetUserIdResponse(getRequestId(), GetUserIdResponse.GetUserIdRequestStatus.FAILED, null));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/KiwiGetUserIdCommandTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */