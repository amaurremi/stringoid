package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.factories.HttpClientFactory;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;

class AdViewController$3
        implements Runnable {
    AdViewController$3(AdViewController paramAdViewController) {
    }

    public void run() {
        if (AdViewController.access$000(this.this$0).getClickthroughUrl() == null) {
            return;
        }
        DefaultHttpClient localDefaultHttpClient = HttpClientFactory.create();
        try {
            MoPubLog.d("Tracking click for: " + AdViewController.access$000(this.this$0).getClickthroughUrl());
            HttpGet localHttpGet = new HttpGet(AdViewController.access$000(this.this$0).getClickthroughUrl());
            localHttpGet.addHeader("User-Agent", AdViewController.access$000(this.this$0).getUserAgent());
            localDefaultHttpClient.execute(localHttpGet);
            return;
        } catch (Exception localException) {
            MoPubLog.d("Click tracking failed: " + AdViewController.access$000(this.this$0).getClickthroughUrl(), localException);
            return;
        } finally {
            localDefaultHttpClient.getConnectionManager().shutdown();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/AdViewController$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */