package com.mopub.mobileads.util;

import org.apache.http.client.HttpClient;

public class HttpClients {
    public static void safeShutdown(HttpClient paramHttpClient) {
        new Thread(new d(paramHttpClient)).start();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/util/HttpClients.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */