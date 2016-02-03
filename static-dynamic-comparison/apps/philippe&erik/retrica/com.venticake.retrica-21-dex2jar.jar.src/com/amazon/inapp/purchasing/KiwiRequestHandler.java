package com.amazon.inapp.purchasing;

import com.amazon.android.Kiwi;
import java.util.Set;

final class KiwiRequestHandler
  implements RequestHandler
{
  static final String HANDLER_THREAD_NAME = "KiwiRequestHandlerHandlerThread";
  private static final String TAG = "KiwiRequestHandler";
  private final HandlerAdapter _handler = HandlerManager.getHandlerAdapter("KiwiRequestHandlerHandlerThread");
  
  public void sendContentDownloadRequest(String paramString1, String paramString2, String paramString3) {}
  
  public void sendGetUserIdRequest(final String paramString)
  {
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiRequestHandler", "sendGetUserIdRequest");
    }
    paramString = new Runnable()
    {
      public void run()
      {
        Kiwi.addCommandToCommandTaskPipeline(new KiwiGetUserIdCommandTask(paramString));
      }
    };
    this._handler.post(paramString);
  }
  
  public void sendItemDataRequest(final Set<String> paramSet, final String paramString)
  {
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiRequestHandler", "sendItemDataRequest");
    }
    paramSet = new Runnable()
    {
      public void run()
      {
        Kiwi.addCommandToCommandTaskPipeline(new KiwiGetItemDataRequestCommandTask(paramSet, paramString));
      }
    };
    this._handler.post(paramSet);
  }
  
  public void sendPurchaseRequest(final String paramString1, final String paramString2)
  {
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiRequestHandler", "sendPurchaseRequest");
    }
    paramString1 = new Runnable()
    {
      public void run()
      {
        Kiwi.addCommandToCommandTaskPipeline(new KiwiPurchaseRequestCommandTask(paramString1, paramString2));
      }
    };
    this._handler.post(paramString1);
  }
  
  public void sendPurchaseResponseReceivedRequest(final String paramString)
  {
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiRequestHandler", "sendPurchaseResponseReceivedRequest");
    }
    paramString = new Runnable()
    {
      public void run()
      {
        Kiwi.addCommandToCommandTaskPipeline(new KiwiResponseReceivedCommandTask(paramString));
      }
    };
    this._handler.post(paramString);
  }
  
  public void sendPurchaseUpdatesRequest(final Offset paramOffset, final String paramString)
  {
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiRequestHandler", "sendPurchaseUpdatesRequest");
    }
    paramOffset = new Runnable()
    {
      public void run()
      {
        Kiwi.addCommandToCommandTaskPipeline(new KiwiPurchaseUpdatesCommandTask(paramOffset, paramString));
      }
    };
    this._handler.post(paramOffset);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/KiwiRequestHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */