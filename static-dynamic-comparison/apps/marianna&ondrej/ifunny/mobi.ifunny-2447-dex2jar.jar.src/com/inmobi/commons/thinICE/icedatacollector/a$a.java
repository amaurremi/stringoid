package com.inmobi.commons.thinICE.icedatacollector;

import android.net.wifi.ScanResult;
import android.util.Log;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import com.inmobi.commons.thinICE.wifi.WifiScanListener;
import com.inmobi.commons.thinICE.wifi.WifiUtil;

import java.util.Iterator;
import java.util.List;

class a$a
        implements WifiScanListener {
    a$a(a parama, boolean paramBoolean1, boolean paramBoolean2) {
    }

    public void onResultsReceived(List<ScanResult> paramList) {
        if (BuildSettings.DEBUG) {
            Log.d("IceDataCollector", "Received Wi-Fi scan results " + paramList.size());
        }
        paramList = WifiUtil.scanResultsToWifiInfos(paramList, this.a, this.b);
        if (BuildSettings.DEBUG) {
            Log.d("IceDataCollector", "-- wifi scan:");
            ???=paramList.iterator();
            while (((Iterator) ? ??).hasNext())
            {
                WifiInfo localWifiInfo = (WifiInfo) ((Iterator) ? ??).next();
                Log.d("IceDataCollector", "   + " + localWifiInfo);
            }
        }
        synchronized (IceDataCollector.k()) {
            if (IceDataCollector.l() != null) {
                IceDataCollector.l().visibleWifiAp = paramList;
                a.a(this.c);
            }
            return;
        }
    }

    public void onTimeout() {
        if (BuildSettings.DEBUG) {
            Log.w("IceDataCollector", "Received Wi-Fi scan timeout");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/thinICE/icedatacollector/a$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */