package com.inmobi.commons.thinICE.wifi;

final class b
        implements Runnable {
    public void run() {
        WifiScanListener localWifiScanListener = WifiScanner.a();
        WifiScanner.b();
        if (localWifiScanListener != null) {
            localWifiScanListener.onTimeout();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/thinICE/wifi/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */