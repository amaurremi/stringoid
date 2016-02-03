package com.millennialmedia.android;

import android.text.TextUtils;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

final class HttpRedirection {
    static final String a(String paramString) {
        if (paramString == null) {
            return null;
        }
        HttpURLConnection.setFollowRedirects(false);
        String str1;
        String str2;
        String str3;
        String str4;
        for (; ; ) {
            str1 = paramString;
            str2 = paramString;
            str3 = paramString;
            str4 = paramString;
            try {
                if (paramString.startsWith("https")) {
                    return paramString;
                }
                str1 = paramString;
                str2 = paramString;
                str3 = paramString;
                str4 = paramString;
                URL localURL = new URL(paramString);
                str1 = paramString;
                str2 = paramString;
                str3 = paramString;
                str4 = paramString;
                localObject = (HttpURLConnection) localURL.openConnection();
                str1 = paramString;
                str2 = paramString;
                str3 = paramString;
                str4 = paramString;
                ((HttpURLConnection) localObject).setConnectTimeout(10000);
                str1 = paramString;
                str2 = paramString;
                str3 = paramString;
                str4 = paramString;
                ((HttpURLConnection) localObject).setRequestMethod("GET");
                str1 = paramString;
                str2 = paramString;
                str3 = paramString;
                str4 = paramString;
                ((HttpURLConnection) localObject).connect();
                str1 = paramString;
                str2 = paramString;
                str3 = paramString;
                str4 = paramString;
                int i = ((HttpURLConnection) localObject).getResponseCode();
                str1 = paramString;
                str2 = paramString;
                str3 = paramString;
                str4 = paramString;
                localObject = ((HttpURLConnection) localObject).getHeaderField("Location");
                if ((i < 300) || (i >= 400)) {
                    return paramString;
                }
                str1 = paramString;
                str2 = paramString;
                str3 = paramString;
                str4 = paramString;
                if (TextUtils.isEmpty((CharSequence) localObject)) {
                    return paramString;
                }
                str1 = paramString;
                str2 = paramString;
                str3 = paramString;
                str4 = paramString;
                URI localURI = new URI((String) localObject);
                str1 = paramString;
                str2 = paramString;
                str3 = paramString;
                str4 = paramString;
                if (localURI.isAbsolute()) {
                    break;
                }
                str1 = paramString;
                str2 = paramString;
                str3 = paramString;
                str4 = paramString;
                paramString = localURL.toURI().resolve(localURI).toString();
            } catch (MalformedURLException paramString) {
                for (; ; ) {
                    Object localObject;
                    MMLog.a("HttpRedirection", "Bad url scheme", paramString);
                    return str1;
                    if (localObject != null) {
                        paramString = (String) localObject;
                    }
                }
            } catch (SocketTimeoutException paramString) {
                MMLog.a("HttpRedirection", "Connection timeout.", paramString);
                return str2;
            } catch (IOException paramString) {
                MMLog.a("HttpRedirection", "IOException following redirects: ", paramString);
                return str3;
            } catch (URISyntaxException paramString) {
                MMLog.a("HttpRedirection", "URI Syntax incorrect.", paramString);
                return str4;
            }
            str1 = paramString;
            str2 = paramString;
            str3 = paramString;
            str4 = paramString;
            MMLog.a("HttpRedirection", String.format("Redirecting to: %s", new Object[]{paramString}));
        }
        return paramString;
    }

    static void a(HttpRedirection.RedirectionListenerImpl paramRedirectionListenerImpl) {
        if ((paramRedirectionListenerImpl == null) || (paramRedirectionListenerImpl.a == null) || (paramRedirectionListenerImpl.b == null)) {
            return;
        }
        Utils.ThreadUtils.a(new HttpRedirection .1 (new WeakReference(paramRedirectionListenerImpl)));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/HttpRedirection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */