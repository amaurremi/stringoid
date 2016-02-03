package com.gau.go.launcherex.gowidget.download;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;

public class g
{
  public static String a(Context paramContext)
  {
    return Proxy.getHost(paramContext);
  }
  
  public static int b(Context paramContext)
  {
    return Proxy.getPort(paramContext);
  }
  
  public static boolean c(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.getType() == 0) && ((Proxy.getDefaultHost() != null) || (Proxy.getHost(paramContext) != null));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/download/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */