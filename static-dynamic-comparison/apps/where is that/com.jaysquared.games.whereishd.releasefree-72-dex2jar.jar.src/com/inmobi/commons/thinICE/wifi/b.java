package com.inmobi.commons.thinICE.wifi;

final class b
  implements Runnable
{
  public void run()
  {
    WifiScanListener localWifiScanListener = WifiScanner.a();
    WifiScanner.b();
    if (localWifiScanListener != null) {
      localWifiScanListener.onTimeout();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/thinICE/wifi/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */