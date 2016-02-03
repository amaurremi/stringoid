package org.osmdroid.tileprovider.modules;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkAvailabliltyCheck
  implements INetworkAvailablityCheck
{
  private final ConnectivityManager mConnectionManager;
  
  public NetworkAvailabliltyCheck(Context paramContext)
  {
    this.mConnectionManager = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
  }
  
  public boolean getCellularDataNetworkAvailable()
  {
    boolean bool2 = false;
    NetworkInfo localNetworkInfo = this.mConnectionManager.getNetworkInfo(0);
    boolean bool1 = bool2;
    if (localNetworkInfo != null)
    {
      bool1 = bool2;
      if (localNetworkInfo.isAvailable()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean getNetworkAvailable()
  {
    NetworkInfo localNetworkInfo = this.mConnectionManager.getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.isAvailable());
  }
  
  public boolean getRouteToPathExists(int paramInt)
  {
    boolean bool = false;
    if ((this.mConnectionManager.requestRouteToHost(1, paramInt)) || (this.mConnectionManager.requestRouteToHost(0, paramInt))) {
      bool = true;
    }
    return bool;
  }
  
  public boolean getWiFiNetworkAvailable()
  {
    NetworkInfo localNetworkInfo = this.mConnectionManager.getNetworkInfo(1);
    return (localNetworkInfo != null) && (localNetworkInfo.isAvailable());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/modules/NetworkAvailabliltyCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */