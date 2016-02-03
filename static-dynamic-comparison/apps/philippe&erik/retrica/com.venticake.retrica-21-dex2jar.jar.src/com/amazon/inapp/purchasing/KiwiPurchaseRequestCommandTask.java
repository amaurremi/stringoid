package com.amazon.inapp.purchasing;

import android.app.Activity;
import android.content.Intent;
import com.amazon.android.framework.context.ContextManager;
import com.amazon.android.framework.resource.Resource;
import com.amazon.android.framework.task.Task;
import com.amazon.android.framework.task.TaskManager;
import com.amazon.android.framework.task.pipeline.TaskPipelineId;
import com.amazon.venezia.command.SuccessResult;
import java.util.Map;

final class KiwiPurchaseRequestCommandTask
  extends KiwiBaseCommandTask
{
  private static final String COMMAND_NAME = "purchase_item";
  private static final String COMMAND_VERSION = "1.0";
  private static final String TAG = "KiwiPurchaseRequestCommandTask";
  private final String _sku;
  @Resource
  private ContextManager contextMgr;
  @Resource
  private TaskManager taskManager;
  
  KiwiPurchaseRequestCommandTask(String paramString1, String paramString2)
  {
    super("purchase_item", "1.0", paramString2);
    this._sku = paramString1;
    addCommandData("sku", this._sku);
  }
  
  protected void onSuccess(final SuccessResult paramSuccessResult)
  {
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiPurchaseRequestCommandTask", "onSuccess");
    }
    paramSuccessResult = paramSuccessResult.getData();
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiPurchaseRequestCommandTask", "data: " + paramSuccessResult);
    }
    if (paramSuccessResult.containsKey("purchaseItemIntent"))
    {
      if (Logger.isTraceOn()) {
        Logger.trace("KiwiPurchaseRequestCommandTask", "found intent");
      }
      paramSuccessResult = (Intent)paramSuccessResult.remove("purchaseItemIntent");
      this.taskManager.enqueueAtFront(TaskPipelineId.FOREGROUND, new Task()
      {
        public void execute()
        {
          try
          {
            Activity localActivity2 = KiwiPurchaseRequestCommandTask.this.contextMgr.getVisible();
            Activity localActivity1 = localActivity2;
            if (localActivity2 == null) {
              localActivity1 = KiwiPurchaseRequestCommandTask.this.contextMgr.getRoot();
            }
            if (Logger.isTraceOn()) {
              Logger.trace("KiwiPurchaseRequestCommandTask", "About to fire intent with activity " + localActivity1);
            }
            localActivity1.startActivity(paramSuccessResult);
            return;
          }
          catch (Exception localException)
          {
            while (!Logger.isTraceOn()) {}
            Logger.trace("KiwiPurchaseRequestCommandTask", "Exception when attempting to fire intent: " + localException);
          }
        }
      });
    }
    while (!Logger.isTraceOn()) {
      return;
    }
    Logger.trace("KiwiPurchaseRequestCommandTask", "did not find intent");
  }
  
  protected void sendFailedResponse()
  {
    postRunnableToMainLooper(new Runnable()
    {
      public void run()
      {
        PurchasingObserver localPurchasingObserver = PurchasingManager.getPurchasingObserver();
        PurchaseResponse localPurchaseResponse = new PurchaseResponse(KiwiPurchaseRequestCommandTask.this.getRequestId(), null, null, PurchaseResponse.PurchaseRequestStatus.FAILED);
        if (localPurchasingObserver != null)
        {
          if (Logger.isTraceOn()) {
            Logger.trace("KiwiPurchaseRequestCommandTask", "Invoking onPurchaseResponse with " + localPurchaseResponse);
          }
          localPurchasingObserver.onPurchaseResponse(localPurchaseResponse);
        }
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/KiwiPurchaseRequestCommandTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */