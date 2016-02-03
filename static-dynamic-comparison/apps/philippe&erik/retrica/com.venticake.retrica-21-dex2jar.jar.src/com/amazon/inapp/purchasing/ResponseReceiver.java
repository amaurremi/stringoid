package com.amazon.inapp.purchasing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class ResponseReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ImplementationFactory.getResponseHandler().handleResponse(paramContext, paramIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/ResponseReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */