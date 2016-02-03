package com.inneractive.api.ads.sdk;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

final class m {
    private static m a = new m();

    static DefaultHttpClient a() {
        m localm = a;
        int i = IAnetworkFetcher.a;
        i = IAnetworkFetcher.b;
        return c();
    }

    static DefaultHttpClient b() {
        m localm = a;
        return c();
    }

    private static DefaultHttpClient c() {
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        if (IAnetworkFetcher.a > 0) {
            HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, IAnetworkFetcher.a);
        }
        if (IAnetworkFetcher.b > 0) {
            HttpConnectionParams.setSoTimeout(localBasicHttpParams, IAnetworkFetcher.b);
        }
        HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
        HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 3000);
        HttpConnectionParams.setSoTimeout(localBasicHttpParams, 5000);
        return new DefaultHttpClient(localBasicHttpParams);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */