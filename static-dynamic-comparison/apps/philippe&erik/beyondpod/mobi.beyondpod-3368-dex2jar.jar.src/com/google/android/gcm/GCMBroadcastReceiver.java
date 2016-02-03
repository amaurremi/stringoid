package com.google.android.gcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class GCMBroadcastReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "GCMBroadcastReceiver";
  private static boolean mReceiverSet = false;
  
  static final String getDefaultIntentServiceClassName(Context paramContext)
  {
    return paramContext.getPackageName() + ".GCMIntentService";
  }
  
  protected String getGCMIntentServiceClassName(Context paramContext)
  {
    return getDefaultIntentServiceClassName(paramContext);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.v("GCMBroadcastReceiver", "onReceive: " + paramIntent.getAction());
    if (!mReceiverSet)
    {
      mReceiverSet = true;
      str = getClass().getName();
      if (!str.equals(GCMBroadcastReceiver.class.getName())) {
        GCMRegistrar.setRetryReceiverClassName(str);
      }
    }
    String str = getGCMIntentServiceClassName(paramContext);
    Log.v("GCMBroadcastReceiver", "GCM IntentService class: " + str);
    GCMBaseIntentService.runIntentInService(paramContext, paramIntent, str);
    setResult(-1, null, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gcm/GCMBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */