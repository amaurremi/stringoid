package com.facebook.widget;

import android.content.Context;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.FileLruCache.Limits;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class ImageResponseCache {
    static final String TAG = ImageResponseCache.class.getSimpleName();
    private static volatile FileLruCache imageCache;

    static FileLruCache getCache(Context paramContext)
            throws IOException {
        try {
            if (imageCache == null) {
                imageCache = new FileLruCache(paramContext.getApplicationContext(), TAG, new FileLruCache.Limits());
            }
            paramContext = imageCache;
            return paramContext;
        } finally {
        }
    }

    static InputStream getCachedImageStream(URL paramURL, Context paramContext) {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (paramURL != null) {
            localObject1 = localObject2;
            if (!isCDNURL(paramURL)) {
            }
        }
        try {
            localObject1 = getCache(paramContext).get(paramURL.toString());
            return (InputStream) localObject1;
        } catch (IOException paramURL) {
            Logger.log(LoggingBehavior.CACHE, 5, TAG, paramURL.toString());
        }
        return null;
    }

    static InputStream interceptAndCacheImageStream(Context paramContext, HttpURLConnection paramHttpURLConnection)
            throws IOException {
        Object localObject = null;
        URL localURL;
        InputStream localInputStream;
        if (paramHttpURLConnection.getResponseCode() == 200) {
            localURL = paramHttpURLConnection.getURL();
            localInputStream = paramHttpURLConnection.getInputStream();
            localObject = localInputStream;
            if (!isCDNURL(localURL)) {
            }
        }
        try {
            localObject = getCache(paramContext).interceptAndPut(localURL.toString(), new BufferedHttpInputStream(localInputStream, paramHttpURLConnection));
            return (InputStream) localObject;
        } catch (IOException paramContext) {
        }
        return localInputStream;
    }

    private static boolean isCDNURL(URL paramURL) {
        if (paramURL != null) {
            paramURL = paramURL.getHost();
            if (paramURL.endsWith("fbcdn.net")) {
            }
            while ((paramURL.startsWith("fbcdn")) && (paramURL.endsWith("akamaihd.net"))) {
                return true;
            }
        }
        return false;
    }

    private static class BufferedHttpInputStream
            extends BufferedInputStream {
        HttpURLConnection connection;

        BufferedHttpInputStream(InputStream paramInputStream, HttpURLConnection paramHttpURLConnection) {
            super(8192);
            this.connection = paramHttpURLConnection;
        }

        public void close()
                throws IOException {
            super.close();
            Utility.disconnectQuietly(this.connection);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/widget/ImageResponseCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */