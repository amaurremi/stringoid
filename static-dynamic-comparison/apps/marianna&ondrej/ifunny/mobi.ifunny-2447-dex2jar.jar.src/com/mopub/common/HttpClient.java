package com.mopub.common;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.ResponseHeader;

import java.util.Arrays;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class HttpClient {
    private static String a;

    public static AndroidHttpClient getHttpClient() {
        AndroidHttpClient localAndroidHttpClient = AndroidHttpClient.newInstance(DeviceUtils.getUserAgent());
        HttpParams localHttpParams = localAndroidHttpClient.getParams();
        HttpConnectionParams.setConnectionTimeout(localHttpParams, 10000);
        HttpConnectionParams.setSoTimeout(localHttpParams, 10000);
        HttpClientParams.setRedirecting(localHttpParams, true);
        return localAndroidHttpClient;
    }

    public static String getWebViewUserAgent() {
        try {
            String str = a;
            return str;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public static HttpGet initializeHttpGet(String paramString, Context paramContext) {
        paramString = new HttpGet(paramString);
        if ((getWebViewUserAgent() == null) && (paramContext != null)) {
            setWebViewUserAgent(new WebView(paramContext).getSettings().getUserAgentString());
        }
        paramContext = getWebViewUserAgent();
        if (paramContext != null) {
            paramString.addHeader(ResponseHeader.USER_AGENT.getKey(), paramContext);
        }
        return paramString;
    }

    public static void makeTrackingHttpRequest(Iterable<String> paramIterable, Context paramContext) {
        if ((paramIterable == null) || (paramContext == null)) {
            return;
        }
        k localk = new k();
        paramIterable = new l(paramIterable, paramContext.getApplicationContext(), localk);
        new Handler(Looper.getMainLooper()).post(paramIterable);
    }

    public static void makeTrackingHttpRequest(String paramString, Context paramContext) {
        makeTrackingHttpRequest(Arrays.asList(new String[]{paramString}), paramContext);
    }

    public static void setWebViewUserAgent(String paramString) {
        try {
            a = paramString;
            return;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/HttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */