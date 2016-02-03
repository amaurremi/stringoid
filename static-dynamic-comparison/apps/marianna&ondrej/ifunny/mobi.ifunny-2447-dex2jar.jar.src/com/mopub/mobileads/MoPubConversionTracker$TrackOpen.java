package com.mopub.mobileads;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.factories.HttpClientFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

class MoPubConversionTracker$TrackOpen
        implements Runnable {
    private MoPubConversionTracker$TrackOpen(MoPubConversionTracker paramMoPubConversionTracker) {
    }

    public void run() {
        Object localObject1 = new MoPubConversionTracker.ConversionUrlGenerator(this.this$0, null).generateUrlString("ads.mopub.com");
        MoPubLog.d("Conversion track: " + (String) localObject1);
        Object localObject2 = HttpClientFactory.create();
        try {
            localObject2 = ((DefaultHttpClient) localObject2).execute(new HttpGet((String) localObject1));
            if (((HttpResponse) localObject2).getStatusLine().getStatusCode() != 200) {
                MoPubLog.d("Conversion track failed: Status code != 200.");
                return;
            }
        } catch (Exception localException) {
            MoPubLog.d("Conversion track failed [" + localException.getClass().getSimpleName() + "]: " + (String) localObject1);
            return;
        }
        localObject1 = localException.getEntity();
        if ((localObject1 == null) || (((HttpEntity) localObject1).getContentLength() == 0L)) {
            MoPubLog.d("Conversion track failed: Response was empty.");
            return;
        }
        MoPubLog.d("Conversion track successful.");
        MoPubConversionTracker.access$400(this.this$0).edit().putBoolean(MoPubConversionTracker.access$300(this.this$0), true).commit();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MoPubConversionTracker$TrackOpen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */