package com.amazon.inapp.purchasing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

final class KiwiResponseHandler
  implements ResponseHandler
{
  static final String HANDLER_THREAD_NAME = "KiwiResponseHandlerHandlerThread";
  private static final String KEY_REQUEST_ID = "requestId";
  private static final String KEY_RESPONSE_TYPE = "response_type";
  private static final String TAG = "KiwiResponseHandler";
  private final HandlerAdapter _handler = HandlerManager.getHandlerAdapter("KiwiResponseHandlerHandlerThread");
  
  public void handleResponse(Context paramContext, Intent paramIntent)
  {
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiResponseHandler", "handleResponse");
    }
    String str = paramIntent.getExtras().getString("response_type");
    if (str == null)
    {
      if (Logger.isTraceOn()) {
        Logger.trace("KiwiResponseHandler", "Invalid response type: null");
      }
      label40:
      return;
    }
    for (;;)
    {
      try
      {
        KiwiResponseHandler.ResponseType localResponseType = KiwiResponseHandler.ResponseType.valueOf(str);
        if (Logger.isTraceOn()) {
          Logger.trace("KiwiResponseHandler", "Found response type: " + localResponseType);
        }
        str = null;
        switch (1.$SwitchMap$com$amazon$inapp$purchasing$KiwiResponseHandler$ResponseType[localResponseType.ordinal()])
        {
        default: 
          paramContext = str;
          if (paramContext == null) {
            break label40;
          }
          this._handler.post(paramContext);
          return;
        }
      }
      catch (IllegalArgumentException paramContext) {}
      if (!Logger.isTraceOn()) {
        break;
      }
      Logger.trace("KiwiResponseHandler", "Invlid response type: " + str);
      return;
      paramContext = new KiwiResponseHandler.PurchaseResponseHandlerRunnable(this, paramContext, paramIntent);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/KiwiResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */