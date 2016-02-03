package com.mopub.mobileads.util;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;

final class d
        implements Runnable {
    d(HttpClient paramHttpClient) {
    }

    public void run() {
        if ((this.a != null) && (this.a.getConnectionManager() != null)) {
            this.a.getConnectionManager().shutdown();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/util/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */