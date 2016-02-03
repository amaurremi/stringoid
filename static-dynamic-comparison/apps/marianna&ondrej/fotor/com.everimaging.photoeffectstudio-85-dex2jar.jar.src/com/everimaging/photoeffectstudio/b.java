package com.everimaging.photoeffectstudio;

import android.content.Context;
import android.util.Log;
import com.everimaging.fotor.push.d;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public final class b {
    private static final Random a = new Random();
    private static final String b = b.class.getSimpleName();

    private static void a(String paramString, Map<String, String> paramMap)
            throws IOException {
        URL localURL;
        try {
            localURL = new URL(paramString);
            Log.i(b, "remote post url:" + localURL);
            paramString = new StringBuilder();
            paramMap = paramMap.entrySet().iterator();
            while (paramMap.hasNext()) {
                localObject2 = (Map.Entry) paramMap.next();
                paramString.append((String) ((Map.Entry) localObject2).getKey()).append('=').append((String) ((Map.Entry) localObject2).getValue());
                if (paramMap.hasNext()) {
                    paramString.append('&');
                }
            }
            paramString = paramString.toString();
        } catch (MalformedURLException paramMap) {
            throw new IllegalArgumentException("invalid url: " + paramString);
        }
        Log.v(b, "Posting '" + paramString + "' to " + localURL);
        Object localObject2 = paramString.getBytes();
        paramString = null;
        try {
            paramMap = (HttpURLConnection) localURL.openConnection();
            try {
                paramMap.setDoOutput(true);
                paramMap.setUseCaches(false);
                paramMap.setFixedLengthStreamingMode(localObject2.length);
                paramMap.setRequestMethod("POST");
                paramMap.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
                paramString = paramMap.getOutputStream();
                paramString.write((byte[]) localObject2);
                paramString.close();
                int i = paramMap.getResponseCode();
                if (i == 200) {
                    break label311;
                }
                throw new IOException("Post failed with error code " + i);
            } finally {
                paramString = paramMap;
                paramMap = (Map<String, String>) localObject1;
            }
        } finally {
            for (; ; ) {
            }
        }
        if (paramString != null) {
            paramString.disconnect();
        }
        throw paramMap;
        label311:
        if (paramMap != null) {
            paramMap.disconnect();
        }
    }

    static boolean a(Context paramContext, String paramString) {
        Log.i(b, "registering device (regId = " + paramString + ")");
        String str = a.a;
        paramString = d.a(paramContext, paramString);
        long l = a.nextInt(1000) + 2000;
        int i = 1;
        for (; ; ) {
            if (i <= 5) {
                Log.d(b, "Attempt #" + i + " to register");
                try {
                    a(str, paramString);
                    com.google.android.gcm.b.a(paramContext, true);
                    return true;
                } catch (IOException localIOException) {
                    Log.e(b, "Failed to register on attempt " + i, localIOException);
                    if (i != 5) {
                        break label145;
                    }
                }
            } else {
                return false;
            }
            try {
                label145:
                Log.d(b, "Sleeping for " + l + " ms before retry");
                Thread.sleep(l);
                l *= 2L;
                i += 1;
            } catch (InterruptedException paramContext) {
                Log.d(b, "Thread interrupted: abort remaining retries!");
                Thread.currentThread().interrupt();
            }
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/photoeffectstudio/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */