package com.flurry.sdk;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class eh
        implements HostnameVerifier {
    public boolean verify(String paramString, SSLSession paramSSLSession) {
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/eh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */