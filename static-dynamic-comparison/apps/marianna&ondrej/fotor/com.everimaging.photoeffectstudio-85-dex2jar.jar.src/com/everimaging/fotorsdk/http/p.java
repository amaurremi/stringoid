package com.everimaging.fotorsdk.http;

import android.content.Context;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

public class p
        extends a {
    public p() {
        super(false, 80, 443);
    }

    protected k a(DefaultHttpClient paramDefaultHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, String paramString, m paramm, Context paramContext) {
        if (paramString != null) {
            paramHttpUriRequest.addHeader("Content-Type", paramString);
        }
        paramm.a(true);
        new b(paramDefaultHttpClient, paramHttpContext, paramHttpUriRequest, paramm).run();
        return new k(null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/http/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */