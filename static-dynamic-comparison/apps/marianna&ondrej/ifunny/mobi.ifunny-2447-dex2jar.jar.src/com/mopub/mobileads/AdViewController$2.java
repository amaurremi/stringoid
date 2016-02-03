package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.factories.HttpClientFactory;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;

class AdViewController$2
        implements Runnable {
    AdViewController$2(AdViewController paramAdViewController) {
    }

    public void run() {
        if (AdViewController.access$000(this.this$0).getImpressionUrl() == null) {
            return;
        }
        DefaultHttpClient localDefaultHttpClient = HttpClientFactory.create();
        try {
            HttpGet localHttpGet = new HttpGet(AdViewController.access$000(this.this$0).getImpressionUrl());
            localHttpGet.addHeader("User-Agent", AdViewController.access$000(this.this$0).getUserAgent());
            localDefaultHttpClient.execute(localHttpGet);
            return;
        } catch (Exception localException) {
            MoPubLog.d("Impression tracking failed : " + AdViewController.access$000(this.this$0).getImpressionUrl(), localException);
            return;
        } finally {
            localDefaultHttpClient.getConnectionManager().shutdown();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/AdViewController$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */