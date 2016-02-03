package com.facebook.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

class ImageResponseCache {
    static final String TAG = ImageResponseCache.class.getSimpleName();
    private static volatile FileLruCache imageCache;

    static void clearCache(Context paramContext) {
        try {
            getCache(paramContext).clearCache();
            return;
        } catch (IOException paramContext) {
            Logger.log(LoggingBehavior.CACHE, 5, TAG, "clearCache failed " + paramContext.getMessage());
        }
    }

    static FileLruCache getCache(Context paramContext) {
        try {
            if (imageCache == null) {
                imageCache = new FileLruCache(paramContext.getApplicationContext(), TAG, new FileLruCache.Limits());
            }
            paramContext = imageCache;
            return paramContext;
        } finally {
        }
    }

    static InputStream getCachedImageStream(URI paramURI, Context paramContext) {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (paramURI != null) {
            localObject1 = localObject2;
            if (!isCDNURL(paramURI)) {
            }
        }
        try {
            localObject1 = getCache(paramContext).get(paramURI.toString());
            return (InputStream) localObject1;
        } catch (IOException paramURI) {
            Logger.log(LoggingBehavior.CACHE, 5, TAG, paramURI.toString());
        }
        return null;
    }

    static InputStream interceptAndCacheImageStream(Context paramContext, HttpURLConnection paramHttpURLConnection) {
        Object localObject = null;
        URL localURL;
        InputStream localInputStream;
        if (paramHttpURLConnection.getResponseCode() == 200) {
            localURL = paramHttpURLConnection.getURL();
            localInputStream = paramHttpURLConnection.getInputStream();
            localObject = localInputStream;
        }
        try {
            if (isCDNURL(localURL.toURI())) {
                localObject = getCache(paramContext).interceptAndPut(localURL.toString(), new ImageResponseCache.BufferedHttpInputStream(localInputStream, paramHttpURLConnection));
            }
            return (InputStream) localObject;
        } catch (URISyntaxException paramContext) {
            return localInputStream;
        } catch (IOException paramContext) {
        }
        return localInputStream;
    }

    private static boolean isCDNURL(URI paramURI) {
        if (paramURI != null) {
            paramURI = paramURI.getHost();
            if (paramURI.endsWith("fbcdn.net")) {
            }
            while ((paramURI.startsWith("fbcdn")) && (paramURI.endsWith("akamaihd.net"))) {
                return true;
            }
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/ImageResponseCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */