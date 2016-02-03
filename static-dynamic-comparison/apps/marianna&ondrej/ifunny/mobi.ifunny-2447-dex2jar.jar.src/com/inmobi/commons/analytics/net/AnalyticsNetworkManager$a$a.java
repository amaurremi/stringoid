package com.inmobi.commons.analytics.net;

import android.os.Handler.Callback;
import android.os.Message;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.bootstrapper.AutomaticCaptureConfig;
import com.inmobi.commons.analytics.events.AnalyticsEventsWrapper;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.internal.Log;

class AnalyticsNetworkManager$a$a
        implements Handler.Callback {
    AnalyticsNetworkManager$a$a(AnalyticsNetworkManager.a parama) {
    }

    public boolean handleMessage(Message paramMessage) {
        Log.debug("[InMobi]-[Analytics]-4.5.1", "NetworkManager->handleMessag: msg:" + paramMessage);
        if (paramMessage.what == 1001) {
            if ((!AnalyticsInitializer.getConfigParams().getAutomaticCapture().isAutoSessionCaptureEnabled()) && (!AnalyticsEventsWrapper.isEventsUser())) {
                AnalyticsUtils.setStartHandle(false);
            }
        } else {
            return true;
        }
        AnalyticsNetworkManager.a(this.a.a);
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/net/AnalyticsNetworkManager$a$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */