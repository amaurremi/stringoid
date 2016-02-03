package com.tapjoy.mraid.controller;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.util.NetworkBroadcastReceiver;
import com.tapjoy.mraid.view.MraidView;

public class Network
  extends Abstract
{
  private static final String TAG = "MRAID Network";
  private NetworkBroadcastReceiver mBroadCastReceiver;
  private ConnectivityManager mConnectivityManager;
  private IntentFilter mFilter;
  private int mNetworkListenerCount;
  
  public Network(MraidView paramMraidView, Context paramContext)
  {
    super(paramMraidView, paramContext);
    this.mConnectivityManager = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
  }
  
  public String getNetwork()
  {
    localObject1 = null;
    try
    {
      localObject2 = this.mConnectivityManager.getActiveNetworkInfo();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        localException.printStackTrace();
        continue;
        int i;
        switch (localObject1.getState())
        {
        default: 
          i = ((NetworkInfo)localObject1).getType();
          if (i == 0) {
            localObject1 = "cell";
          }
          break;
        case ???: 
          localObject1 = "unknown";
          break;
        case ???: 
          localObject1 = "offline";
          continue;
          localObject1 = localException;
          if (i == 1) {
            localObject1 = "wifi";
          }
          break;
        }
      }
    }
    localObject2 = "unknown";
    if (localObject1 == null)
    {
      localObject1 = "offline";
      TapjoyLog.d("MRAID Network", "getNetwork: " + (String)localObject1);
      return (String)localObject1;
    }
  }
  
  public void onConnectionChanged()
  {
    String str = "window.mraidview.fireChangeEvent({ network: '" + getNetwork() + "'});";
    TapjoyLog.d("MRAID Network", str);
    this.mMraidView.injectMraidJavaScript(str);
  }
  
  public void startNetworkListener()
  {
    if (this.mNetworkListenerCount == 0)
    {
      this.mBroadCastReceiver = new NetworkBroadcastReceiver(this);
      this.mFilter = new IntentFilter();
      this.mFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    }
    this.mNetworkListenerCount += 1;
    this.mContext.registerReceiver(this.mBroadCastReceiver, this.mFilter);
  }
  
  public void stopAllListeners()
  {
    this.mNetworkListenerCount = 0;
    try
    {
      this.mContext.unregisterReceiver(this.mBroadCastReceiver);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void stopNetworkListener()
  {
    this.mNetworkListenerCount -= 1;
    if (this.mNetworkListenerCount == 0)
    {
      this.mContext.unregisterReceiver(this.mBroadCastReceiver);
      this.mBroadCastReceiver = null;
      this.mFilter = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/mraid/controller/Network.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */