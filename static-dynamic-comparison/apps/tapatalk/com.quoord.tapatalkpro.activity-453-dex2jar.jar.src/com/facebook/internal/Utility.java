package com.facebook.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.FacebookException;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.model.GraphObject;

import java.io.Closeable;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class Utility {
    private static final String APPLICATION_FIELDS = "fields";
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;
    private static final String HASH_ALGORITHM_MD5 = "MD5";
    private static final Object LOCK = new Object();
    static final String LOG_TAG = "FacebookSDK";
    private static final String SUPPORTS_ATTRIBUTION = "supports_attribution";
    private static final String URL_SCHEME = "https";
    private static volatile boolean attributionAllowedForLastAppChecked = false;
    private static volatile String lastAppCheckedForAttributionStatus = "";

    public static <T> ArrayList<T> arrayList(T... paramVarArgs) {
        ArrayList localArrayList = new ArrayList(paramVarArgs.length);
        int j = paramVarArgs.length;
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                return localArrayList;
            }
            localArrayList.add(paramVarArgs[i]);
            i += 1;
        }
    }

    public static Uri buildUri(String paramString1, String paramString2, Bundle paramBundle) {
        Uri.Builder localBuilder = new Uri.Builder();
        localBuilder.scheme("https");
        localBuilder.authority(paramString1);
        localBuilder.path(paramString2);
        paramString1 = paramBundle.keySet().iterator();
        for (; ; ) {
            if (!paramString1.hasNext()) {
                return localBuilder.build();
            }
            paramString2 = (String) paramString1.next();
            Object localObject = paramBundle.get(paramString2);
            if ((localObject instanceof String)) {
                localBuilder.appendQueryParameter(paramString2, (String) localObject);
            }
        }
    }

    private static void clearCookiesForDomain(Context paramContext, String paramString) {
        CookieSyncManager.createInstance(paramContext).sync();
        paramContext = CookieManager.getInstance();
        Object localObject = paramContext.getCookie(paramString);
        if (localObject == null) {
            return;
        }
        localObject = ((String) localObject).split(";");
        int j = localObject.length;
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                paramContext.removeExpiredCookie();
                return;
            }
            String[] arrayOfString = localObject[i].split("=");
            if (arrayOfString.length > 0) {
                paramContext.setCookie(paramString, arrayOfString[0].trim() + "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
            }
            i += 1;
        }
    }

    public static void clearFacebookCookies(Context paramContext) {
        clearCookiesForDomain(paramContext, "facebook.com");
        clearCookiesForDomain(paramContext, ".facebook.com");
        clearCookiesForDomain(paramContext, "https://facebook.com");
        clearCookiesForDomain(paramContext, "https://.facebook.com");
    }

    public static void closeQuietly(Closeable paramCloseable) {
        if (paramCloseable != null) {
        }
        try {
            paramCloseable.close();
            return;
        } catch (IOException paramCloseable) {
        }
    }

    static Map<String, Object> convertJSONObjectToHashMap(JSONObject paramJSONObject) {
        HashMap localHashMap = new HashMap();
        JSONArray localJSONArray = paramJSONObject.names();
        int i = 0;
        for (; ; ) {
            if (i >= localJSONArray.length()) {
                return localHashMap;
            }
            try {
                String str = localJSONArray.getString(i);
                Object localObject2 = paramJSONObject.get(str);
                Object localObject1 = localObject2;
                if ((localObject2 instanceof JSONObject)) {
                    localObject1 = convertJSONObjectToHashMap((JSONObject) localObject2);
                }
                localHashMap.put(str, localObject1);
            } catch (JSONException localJSONException) {
                for (; ; ) {
                }
            }
            i += 1;
        }
    }

    public static void disconnectQuietly(URLConnection paramURLConnection) {
        if ((paramURLConnection instanceof HttpURLConnection)) {
            ((HttpURLConnection) paramURLConnection).disconnect();
        }
    }

    public static String getMetadataApplicationId(Context paramContext) {
        try {
            paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
            if (paramContext.metaData != null) {
                paramContext = paramContext.metaData.getString("com.facebook.sdk.ApplicationId");
                return paramContext;
            }
        } catch (PackageManager.NameNotFoundException paramContext) {
        }
        return null;
    }

    public static Object getStringPropertyAsJSON(JSONObject paramJSONObject, String paramString1, String paramString2)
            throws JSONException {
        paramString1 = paramJSONObject.opt(paramString1);
        paramJSONObject = paramString1;
        if (paramString1 != null) {
            paramJSONObject = paramString1;
            if ((paramString1 instanceof String)) {
                paramJSONObject = new JSONTokener((String) paramString1).nextValue();
            }
        }
        if ((paramJSONObject != null) && (!(paramJSONObject instanceof JSONObject)) && (!(paramJSONObject instanceof JSONArray))) {
            if (paramString2 != null) {
                paramString1 = new JSONObject();
                paramString1.putOpt(paramString2, paramJSONObject);
                return paramString1;
            }
            throw new FacebookException("Got an unexpected non-JSON object.");
        }
        return paramJSONObject;
    }

    public static boolean isNullOrEmpty(String paramString) {
        return (paramString == null) || (paramString.length() == 0);
    }

    public static <T> boolean isNullOrEmpty(Collection<T> paramCollection) {
        return (paramCollection == null) || (paramCollection.size() == 0);
    }

    public static <T> boolean isSubset(Collection<T> paramCollection1, Collection<T> paramCollection2) {
        if ((paramCollection2 == null) || (paramCollection2.size() == 0)) {
            return (paramCollection1 == null) || (paramCollection1.size() == 0);
        }
        paramCollection2 = new HashSet(paramCollection2);
        paramCollection1 = paramCollection1.iterator();
        do {
            if (!paramCollection1.hasNext()) {
                return true;
            }
        } while (paramCollection2.contains((Object) paramCollection1.next()));
        return false;
    }

    public static void logd(String paramString, Exception paramException) {
    }

    public static void logd(String paramString1, String paramString2) {
    }

    static String md5hash(String paramString) {
        for (; ; ) {
            Object localObject;
            int i;
            try {
                localObject = MessageDigest.getInstance("MD5");
                ((MessageDigest) localObject).update(paramString.getBytes());
                paramString = ((MessageDigest) localObject).digest();
                localObject = new StringBuilder();
                int j = paramString.length;
                i = 0;
                if (i >= j) {
                    return ((StringBuilder) localObject).toString();
                }
            } catch (NoSuchAlgorithmException paramString) {
                return null;
            }
            int k = paramString[i];
            ((StringBuilder) localObject).append(Integer.toHexString(k >> 4 & 0xF));
            ((StringBuilder) localObject).append(Integer.toHexString(k >> 0 & 0xF));
            i += 1;
        }
    }

    public static void putObjectInBundle(Bundle paramBundle, String paramString, Object paramObject) {
        if ((paramObject instanceof String)) {
            paramBundle.putString(paramString, (String) paramObject);
            return;
        }
        if ((paramObject instanceof Parcelable)) {
            paramBundle.putParcelable(paramString, (Parcelable) paramObject);
            return;
        }
        if ((paramObject instanceof byte[])) {
            paramBundle.putByteArray(paramString, (byte[]) paramObject);
            return;
        }
        throw new FacebookException("attempted to add unsupported type to Bundle");
    }

    public static boolean queryAppAttributionSupportAndWait(String paramString) {
        for (; ; ) {
            synchronized (LOCK) {
                boolean bool;
                if (paramString.equals(lastAppCheckedForAttributionStatus)) {
                    bool = attributionAllowedForLastAppChecked;
                    return bool;
                }
                Object localObject1 = new Bundle();
                ((Bundle) localObject1).putString("fields", "supports_attribution");
                Object localObject3 = Request.newGraphPathRequest(null, paramString, null);
                ((Request) localObject3).setParameters((Bundle) localObject1);
                localObject3 = ((Request) localObject3).executeAndWait().getGraphObject();
                localObject1 = Boolean.valueOf(false);
                if (localObject3 != null) {
                    localObject1 = ((GraphObject) localObject3).getProperty("supports_attribution");
                }
                if (!(localObject1 instanceof Boolean)) {
                    localObject1 = Boolean.valueOf(false);
                    lastAppCheckedForAttributionStatus = paramString;
                    attributionAllowedForLastAppChecked = ((Boolean) localObject1).booleanValue();
                    bool = attributionAllowedForLastAppChecked;
                    return bool;
                }
            }
        }
    }

    /* Error */
    public static String readStreamToString(java.io.InputStream paramInputStream)
            throws IOException {
        // Byte code:
        //   0: aconst_null
        //   1: astore_2
        //   2: aconst_null
        //   3: astore_3
        //   4: new 384	java/io/BufferedInputStream
        //   7: dup
        //   8: aload_0
        //   9: invokespecial 387	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
        //   12: astore_0
        //   13: new 389	java/io/InputStreamReader
        //   16: dup
        //   17: aload_0
        //   18: invokespecial 390	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   21: astore_2
        //   22: new 140	java/lang/StringBuilder
        //   25: dup
        //   26: invokespecial 318	java/lang/StringBuilder:<init>	()V
        //   29: astore_3
        //   30: sipush 2048
        //   33: newarray <illegal type>
        //   35: astore 4
        //   37: aload_2
        //   38: aload 4
        //   40: invokevirtual 394	java/io/InputStreamReader:read	([C)I
        //   43: istore_1
        //   44: iload_1
        //   45: iconst_m1
        //   46: if_icmpne +18 -> 64
        //   49: aload_3
        //   50: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   53: astore_3
        //   54: aload_0
        //   55: invokestatic 396	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   58: aload_2
        //   59: invokestatic 396	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   62: aload_3
        //   63: areturn
        //   64: aload_3
        //   65: aload 4
        //   67: iconst_0
        //   68: iload_1
        //   69: invokevirtual 399	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
        //   72: pop
        //   73: goto -36 -> 37
        //   76: astore 4
        //   78: aload_2
        //   79: astore_3
        //   80: aload 4
        //   82: astore_2
        //   83: aload_0
        //   84: invokestatic 396	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   87: aload_3
        //   88: invokestatic 396	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   91: aload_2
        //   92: athrow
        //   93: astore 4
        //   95: aload_2
        //   96: astore_0
        //   97: aload 4
        //   99: astore_2
        //   100: goto -17 -> 83
        //   103: astore_2
        //   104: goto -21 -> 83
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	107	0	paramInputStream	java.io.InputStream
        //   43	26	1	i	int
        //   1	99	2	localObject1	Object
        //   103	1	2	localObject2	Object
        //   3	85	3	localObject3	Object
        //   35	31	4	arrayOfChar	char[]
        //   76	5	4	localObject4	Object
        //   93	5	4	localObject5	Object
        // Exception table:
        //   from	to	target	type
        //   22	37	76	finally
        //   37	44	76	finally
        //   49	54	76	finally
        //   64	73	76	finally
        //   4	13	93	finally
        //   13	22	103	finally
    }

    public static boolean stringsEqualOrEmpty(String paramString1, String paramString2) {
        boolean bool1 = TextUtils.isEmpty(paramString1);
        boolean bool2 = TextUtils.isEmpty(paramString2);
        if ((bool1) && (bool2)) {
            return true;
        }
        if ((!bool1) && (!bool2)) {
            return paramString1.equals(paramString2);
        }
        return false;
    }

    public static <T> Collection<T> unmodifiableCollection(T... paramVarArgs) {
        return Collections.unmodifiableCollection(Arrays.asList(paramVarArgs));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/internal/Utility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */