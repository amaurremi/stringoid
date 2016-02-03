package com.greystripe.sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.webkit.JavascriptInterface;

final class bh
{
  private static bh b;
  private Context a;
  
  private bh() {}
  
  private bh(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public static bh a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new bh(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  private bi c()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.a.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected())) {
      return bi.OFFLINE;
    }
    if (localNetworkInfo.getType() == 0) {
      return bi.CELLULAR;
    }
    return bi.WIFI;
  }
  
  @JavascriptInterface
  public final boolean a()
  {
    return c() != bi.OFFLINE;
  }
  
  @JavascriptInterface
  public final boolean b()
  {
    return c() == bi.WIFI;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */