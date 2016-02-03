package com.facebook.android;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.Utility;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

public final class Util {
    private static final String UTF8 = "UTF-8";

    @Deprecated
    public static Bundle decodeUrl(String paramString) {
        int i = 0;
        Bundle localBundle = new Bundle();
        int j;
        if (paramString != null) {
            paramString = paramString.split("&");
            j = paramString.length;
        }
        for (; ; ) {
            if (i >= j) {
                return localBundle;
            }
            String[] arrayOfString = paramString[i].split("=");
            try {
                if (arrayOfString.length == 2) {
                    localBundle.putString(URLDecoder.decode(arrayOfString[0], "UTF-8"), URLDecoder.decode(arrayOfString[1], "UTF-8"));
                } else if (arrayOfString.length == 1) {
                    localBundle.putString(URLDecoder.decode(arrayOfString[0], "UTF-8"), "");
                }
            } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            }
            i += 1;
        }
    }

    @Deprecated
    public static String encodePostBody(Bundle paramBundle, String paramString) {
        if (paramBundle == null) {
            return "";
        }
        StringBuilder localStringBuilder = new StringBuilder();
        Iterator localIterator = paramBundle.keySet().iterator();
        for (; ; ) {
            if (!localIterator.hasNext()) {
                return localStringBuilder.toString();
            }
            String str = (String) localIterator.next();
            Object localObject = paramBundle.get(str);
            if ((localObject instanceof String)) {
                localStringBuilder.append("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n" + (String) localObject);
                localStringBuilder.append("\r\n--" + paramString + "\r\n");
            }
        }
    }

    @Deprecated
    public static String encodeUrl(Bundle paramBundle) {
        if (paramBundle == null) {
            return "";
        }
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 1;
        Iterator localIterator = paramBundle.keySet().iterator();
        String str;
        do {
            if (!localIterator.hasNext()) {
                return localStringBuilder.toString();
            }
            str = (String) localIterator.next();
        } while (!(paramBundle.get(str) instanceof String));
        if (i != 0) {
            i = 0;
        }
        for (; ; ) {
            localStringBuilder.append(URLEncoder.encode(str) + "=" + URLEncoder.encode(paramBundle.getString(str)));
            break;
            localStringBuilder.append("&");
        }
    }

    @Deprecated
    public static String openUrl(String paramString1, String paramString2, Bundle paramBundle)
            throws MalformedURLException, IOException {
        Object localObject1 = paramString1;
        if (paramString2.equals("GET")) {
            localObject1 = paramString1 + "?" + encodeUrl(paramBundle);
        }
        Utility.logd("Facebook-Util", paramString2 + " URL: " + (String) localObject1);
        paramString1 = (HttpURLConnection) new URL((String) localObject1).openConnection();
        paramString1.setRequestProperty("User-Agent", System.getProperties().getProperty("http.agent") + " FacebookAndroidSDK");
        Object localObject2;
        if (!paramString2.equals("GET")) {
            localObject1 = new Bundle();
            localObject2 = paramBundle.keySet().iterator();
            if (((Iterator) localObject2).hasNext()) {
                break label373;
            }
            if (!paramBundle.containsKey("method")) {
                paramBundle.putString("method", paramString2);
            }
            if (paramBundle.containsKey("access_token")) {
                paramBundle.putString("access_token", URLDecoder.decode(paramBundle.getString("access_token")));
            }
            paramString1.setRequestMethod("POST");
            paramString1.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
            paramString1.setDoOutput(true);
            paramString1.setDoInput(true);
            paramString1.setRequestProperty("Connection", "Keep-Alive");
            paramString1.connect();
            paramString2 = new BufferedOutputStream(paramString1.getOutputStream());
            paramString2.write(("--" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + "\r\n").getBytes());
            paramString2.write(encodePostBody(paramBundle, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f").getBytes());
            paramString2.write(("\r\n" + "--" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + "\r\n").getBytes());
            if (!((Bundle) localObject1).isEmpty()) {
                paramBundle = ((Bundle) localObject1).keySet().iterator();
            }
        }
        for (; ; ) {
            if (!paramBundle.hasNext()) {
                paramString2.flush();
            }
            label373:
            try {
                paramString2 = read(paramString1.getInputStream());
                return paramString2;
            } catch (FileNotFoundException paramString2) {
            }
            String str = (String) ((Iterator) localObject2).next();
            Object localObject3 = paramBundle.get(str);
            if (!(localObject3 instanceof byte[])) {
                break;
            }
            ((Bundle) localObject1).putByteArray(str, (byte[]) localObject3);
            break;
            localObject2 = (String) paramBundle.next();
            paramString2.write(("Content-Disposition: form-data; filename=\"" + (String) localObject2 + "\"" + "\r\n").getBytes());
            paramString2.write(("Content-Type: content/unknown" + "\r\n" + "\r\n").getBytes());
            paramString2.write(((Bundle) localObject1).getByteArray((String) localObject2));
            paramString2.write(("\r\n" + "--" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + "\r\n").getBytes());
        }
        return read(paramString1.getErrorStream());
    }

    @Deprecated
    public static JSONObject parseJson(String paramString)
            throws JSONException, FacebookError {
        if (paramString.equals("false")) {
            throw new FacebookError("request failed");
        }
        String str = paramString;
        if (paramString.equals("true")) {
            str = "{value : true}";
        }
        paramString = new JSONObject(str);
        if (paramString.has("error")) {
            paramString = paramString.getJSONObject("error");
            throw new FacebookError(paramString.getString("message"), paramString.getString("type"), 0);
        }
        if ((paramString.has("error_code")) && (paramString.has("error_msg"))) {
            throw new FacebookError(paramString.getString("error_msg"), "", Integer.parseInt(paramString.getString("error_code")));
        }
        if (paramString.has("error_code")) {
            throw new FacebookError("request failed", "", Integer.parseInt(paramString.getString("error_code")));
        }
        if (paramString.has("error_msg")) {
            throw new FacebookError(paramString.getString("error_msg"));
        }
        if (paramString.has("error_reason")) {
            throw new FacebookError(paramString.getString("error_reason"));
        }
        return paramString;
    }

    @Deprecated
    public static Bundle parseUrl(String paramString) {
        paramString = paramString.replace("fbconnect", "http");
        try {
            paramString = new URL(paramString);
            Bundle localBundle = decodeUrl(paramString.getQuery());
            localBundle.putAll(decodeUrl(paramString.getRef()));
            return localBundle;
        } catch (MalformedURLException paramString) {
        }
        return new Bundle();
    }

    @Deprecated
    private static String read(InputStream paramInputStream)
            throws IOException {
        StringBuilder localStringBuilder = new StringBuilder();
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream), 1000);
        for (String str = localBufferedReader.readLine(); ; str = localBufferedReader.readLine()) {
            if (str == null) {
                paramInputStream.close();
                return localStringBuilder.toString();
            }
            localStringBuilder.append(str);
        }
    }

    @Deprecated
    public static void showAlert(Context paramContext, String paramString1, String paramString2) {
        paramContext = new AlertDialog.Builder(paramContext);
        paramContext.setTitle(paramString1);
        paramContext.setMessage(paramString2);
        paramContext.create().show();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/android/Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */