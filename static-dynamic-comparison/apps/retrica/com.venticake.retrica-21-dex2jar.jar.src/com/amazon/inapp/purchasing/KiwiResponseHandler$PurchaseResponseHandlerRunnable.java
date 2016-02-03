package com.amazon.inapp.purchasing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.amazon.android.Kiwi;

class KiwiResponseHandler$PurchaseResponseHandlerRunnable
  extends KiwiResponseHandler.ResponseHandlerRunnable
{
  public KiwiResponseHandler$PurchaseResponseHandlerRunnable(KiwiResponseHandler paramKiwiResponseHandler, Context paramContext, Intent paramIntent)
  {
    super(paramKiwiResponseHandler, paramContext, paramIntent);
  }
  
  public void run()
  {
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiResponseHandler", "PurchaseResponseHandlerRunnable.run()");
    }
    String str = getIntent().getExtras().getString("requestId");
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiResponseHandler", "PurchaseResponseHandlerRunnable.run: requestId: " + str);
    }
    if ((str != null) && (str.trim().length() > 0)) {
      Kiwi.addCommandToCommandTaskPipeline(new KiwiPurchaseResponseCommandTask(str));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/KiwiResponseHandler$PurchaseResponseHandlerRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */