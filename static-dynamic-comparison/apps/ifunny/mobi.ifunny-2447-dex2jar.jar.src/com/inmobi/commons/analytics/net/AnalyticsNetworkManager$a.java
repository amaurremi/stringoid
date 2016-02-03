package com.inmobi.commons.analytics.net;

import android.os.Handler;
import android.os.Looper;

class AnalyticsNetworkManager$a
        extends Thread {
    AnalyticsNetworkManager$a(AnalyticsNetworkManager paramAnalyticsNetworkManager) {
    }

    public void run() {
        Looper.prepare();
        AnalyticsNetworkManager.a(new Handler(new AnalyticsNetworkManager.a.a(this)));
        Looper.loop();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/net/AnalyticsNetworkManager$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */