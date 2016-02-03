package com.inmobi.monetization.internal.imai;

import com.inmobi.commons.analytics.net.AnalyticsCommon.HttpRequestCallback;
import com.inmobi.commons.internal.Log;

class IMAICore$c$a
        implements AnalyticsCommon.HttpRequestCallback {
    IMAICore$c$a(IMAICore.c paramc) {
    }

    public void notifyResult(int paramInt, Object paramObject) {
        try {
            Log.internal("[InMobi]-[Monetization]", "Got PING IN WEBVIEW callback. Status: " + paramInt);
            if (paramInt == 0) {
                IMAICore.firePingInWebViewSuccessful(this.a.c, this.a.a);
                return;
            }
            IMAICore.fireErrorEvent(this.a.c, "IMAI Ping in webview failed", "pingInWebview", this.a.a);
            return;
        } catch (Exception paramObject) {
            Log.internal("[InMobi]-[Monetization]", "Exception", (Throwable) paramObject);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/imai/IMAICore$c$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */