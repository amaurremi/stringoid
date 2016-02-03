package com.inneractive.api.ads.sdk;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;

final class IAadViewController$4
        implements Runnable {
    IAadViewController$4(IAadViewController paramIAadViewController, IAdefines.IAIntegratedSdksTrackingAction paramIAIntegratedSdksTrackingAction) {
    }

    public final void run() {
        String str = this.b.b(this.a);
        DefaultHttpClient localDefaultHttpClient;
        if (str != null) {
            localDefaultHttpClient = m.b();
        }
        try {
            HttpGet localHttpGet = new HttpGet(str);
            IAadViewController.a(this.b);
            localHttpGet.addHeader("User-Agent", IAadConfig.g());
            localDefaultHttpClient.execute(localHttpGet);
            return;
        } catch (Exception localException) {
            InneractiveAdView.Log.v("Inneractive_verbose", "The following tracking url failed: " + str);
            return;
        } finally {
            localDefaultHttpClient.getConnectionManager().shutdown();
            this.b.a(this.a);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAadViewController$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */