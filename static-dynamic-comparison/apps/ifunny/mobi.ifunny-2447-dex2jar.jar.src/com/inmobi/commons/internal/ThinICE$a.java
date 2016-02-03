package com.inmobi.commons.internal;

import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.bootstrapper.ThinICEConfig;
import com.inmobi.commons.cache.RetryMechanism.RetryRunnable;

final class ThinICE$a
        implements RetryMechanism.RetryRunnable {
    ThinICE$a(String paramString) {
    }

    public void completed() {
    }

    public void run() {
        Log.internal("[InMobi]-4.5.1", "Sending ThinICE data to server " + AnalyticsInitializer.getConfigParams().getThinIceConfig().getEndpointUrl());
        if (InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext())) {
            ThinICE.a(this.a);
            return;
        }
        throw new Exception("Device not connected.");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/internal/ThinICE$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */