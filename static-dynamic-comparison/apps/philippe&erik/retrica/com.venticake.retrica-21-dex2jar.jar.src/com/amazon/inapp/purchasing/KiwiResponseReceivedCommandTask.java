package com.amazon.inapp.purchasing;

import com.amazon.venezia.command.SuccessResult;

final class KiwiResponseReceivedCommandTask
  extends KiwiBaseCommandTask
{
  private static final String COMMAND_NAME = "response_received";
  private static final String COMMAND_VERSION = "1.0";
  private static final String TAG = "KiwiResponseReceivedCommandTask";
  
  KiwiResponseReceivedCommandTask(String paramString)
  {
    super("response_received", "1.0", paramString);
  }
  
  protected void onSuccess(SuccessResult paramSuccessResult)
  {
    if (Logger.isTraceOn()) {
      Logger.trace("KiwiResponseReceivedCommandTask", "onSuccess");
    }
  }
  
  protected void sendFailedResponse() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/KiwiResponseReceivedCommandTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */