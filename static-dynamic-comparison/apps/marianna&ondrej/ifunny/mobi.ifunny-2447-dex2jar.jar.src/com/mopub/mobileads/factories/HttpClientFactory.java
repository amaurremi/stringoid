package com.mopub.mobileads.factories;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public class HttpClientFactory {
    public static final int SOCKET_SIZE = 8192;
    private static HttpClientFactory a = new HttpClientFactory();

    public static DefaultHttpClient create() {
        return a.a(0);
    }

    public static DefaultHttpClient create(int paramInt) {
        return a.a(paramInt);
    }

    @Deprecated
    public static void setInstance(HttpClientFactory paramHttpClientFactory) {
        a = paramHttpClientFactory;
    }

    protected DefaultHttpClient a(int paramInt) {
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        if (paramInt > 0) {
            HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, paramInt);
            HttpConnectionParams.setSoTimeout(localBasicHttpParams, paramInt);
        }
        HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
        return new DefaultHttpClient(localBasicHttpParams);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/factories/HttpClientFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */