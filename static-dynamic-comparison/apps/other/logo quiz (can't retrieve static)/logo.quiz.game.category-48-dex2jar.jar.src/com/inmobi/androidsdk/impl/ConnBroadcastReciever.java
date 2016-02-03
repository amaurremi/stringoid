package com.inmobi.androidsdk.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.inmobi.androidsdk.impl.net.RequestResponseManager;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

public class ConnBroadcastReciever
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) && (InternalSDKUtil.checkNetworkAvailibility(paramContext))) {
      Log.internal("InMobiAndroidSDK_3.7.1", "Received CONNECTIVITY BROADCAST");
    }
    try
    {
      paramIntent = new RequestResponseManager();
      paramIntent.init();
      paramIntent.processClickInBackground(paramContext.getApplicationContext());
      return;
    }
    catch (Exception paramContext)
    {
      Log.internal("InMobiAndroidSDK_3.7.1", "Connectivity receiver exception", paramContext);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/impl/ConnBroadcastReciever.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */