package com.jtpgodorncrqoeurl;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class AdNetworkController
  extends AdController
{
  private ConnectivityManager c;
  private int d;
  private AdNetworkBroadcastReceiver e;
  private IntentFilter f;
  
  public AdNetworkController(AdView paramAdView, Context paramContext)
  {
    super(paramAdView, paramContext);
    this.c = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
  }
  
  public String getNetwork()
  {
    NetworkInfo localNetworkInfo = this.c.getActiveNetworkInfo();
    String str = "unknown";
    if (localNetworkInfo == null) {
      str = "offline";
    }
    for (;;)
    {
      Log.d("AdOrmmaNetworkController", "getNetwork: " + str);
      return str;
      int i;
      switch (L.a[localNetworkInfo.getState().ordinal()])
      {
      default: 
        i = localNetworkInfo.getType();
        if (i == 0) {
          str = "cell";
        }
        break;
      case 1: 
        str = "unknown";
        break;
      case 2: 
        str = "offline";
        continue;
        if (i == 1) {
          str = "wifi";
        }
        break;
      }
    }
  }
  
  public void onConnectionChanged()
  {
    String str = "window.ormmaview.fireChangeEvent({ network: '" + getNetwork() + "'});";
    Log.d("AdOrmmaNetworkController", str);
    this.b.injectJavaScript(str);
  }
  
  public void startNetworkListener()
  {
    if (this.d == 0)
    {
      this.e = new AdNetworkBroadcastReceiver(this);
      this.f = new IntentFilter();
      this.f.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    }
    this.d += 1;
    this.a.registerReceiver(this.e, this.f);
  }
  
  public void stopAllListeners()
  {
    this.d = 0;
    try
    {
      this.a.unregisterReceiver(this.e);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void stopNetworkListener()
  {
    this.d -= 1;
    if (this.d == 0)
    {
      this.a.unregisterReceiver(this.e);
      this.e = null;
      this.f = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdNetworkController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */