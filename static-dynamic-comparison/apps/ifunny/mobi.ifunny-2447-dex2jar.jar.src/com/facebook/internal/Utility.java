package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.FacebookException;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Settings;
import com.facebook.model.GraphObject;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class Utility {
    private static final String APPLICATION_FIELDS = "fields";
    private static final String APP_SETTINGS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_SETTINGS.%s";
    private static final String APP_SETTINGS_PREFS_STORE = "com.facebook.internal.preferences.APP_SETTINGS";
    private static final String APP_SETTING_DIALOG_CONFIGS = "android_dialog_configs";
    private static final String[] APP_SETTING_FIELDS = {"supports_attribution", "supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled", "android_dialog_configs"};
    private static final String APP_SETTING_NUX_CONTENT = "gdpv4_nux_content";
    private static final String APP_SETTING_NUX_ENABLED = "gdpv4_nux_enabled";
    private static final String APP_SETTING_SUPPORTS_ATTRIBUTION = "supports_attribution";
    private static final String APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING = "supports_implicit_sdk_logging";
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;
    private static final String DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR = "\\|";
    private static final String DIALOG_CONFIG_NAME_KEY = "name";
    private static final String DIALOG_CONFIG_URL_KEY = "url";
    private static final String DIALOG_CONFIG_VERSIONS_KEY = "versions";
    private static final String EXTRA_APP_EVENTS_INFO_FORMAT_VERSION = "a1";
    private static final String HASH_ALGORITHM_MD5 = "MD5";
    private static final String HASH_ALGORITHM_SHA1 = "SHA-1";
    static final String LOG_TAG = "FacebookSDK";
    private static final String URL_SCHEME = "https";
    private static final String UTF8 = "UTF-8";
    private static Map<String, Utility.FetchedAppSettings> fetchedAppSettings = new ConcurrentHashMap();
    private static AsyncTask<Void, Void, GraphObject> initialAppSettingsLoadTask;

    public static <T> boolean areObjectsEqual(T paramT1, T paramT2) {
        if (paramT1 == null) {
            return paramT2 == null;
        }
        return paramT1.equals(paramT2);
    }

    public static <T> ArrayList<T> arrayList(T... paramVarArgs) {
        ArrayList localArrayList = new ArrayList(paramVarArgs.length);
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j) {
            localArrayList.add(paramVarArgs[i]);
            i += 1;
        }
        return localArrayList;
    }

    public static <T> List<T> asListNoNulls(T... paramVarArgs) {
        ArrayList localArrayList = new ArrayList();
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j) {
            T ? = paramVarArgs[i];
            if (?!=null){
                localArrayList.add( ?);
            }
            i += 1;
        }
        return localArrayList;
    }

    public static Uri buildUri(String paramString1, String paramString2, Bundle paramBundle) {
        Uri.Builder localBuilder = new Uri.Builder();
        localBuilder.scheme("https");
        localBuilder.authority(paramString1);
        localBuilder.path(paramString2);
        paramString1 = paramBundle.keySet().iterator();
        while (paramString1.hasNext()) {
            paramString2 = (String) paramString1.next();
            Object localObject = paramBundle.get(paramString2);
            if ((localObject instanceof String)) {
                localBuilder.appendQueryParameter(paramString2, (String) localObject);
            }
        }
        return localBuilder.build();
    }

    public static void clearCaches(Context paramContext) {
        ImageDownloader.clearCache(paramContext);
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
        while (i < j) {
            String[] arrayOfString = localObject[i].split("=");
            if (arrayOfString.length > 0) {
                paramContext.setCookie(paramString, arrayOfString[0].trim() + "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
            }
            i += 1;
        }
        paramContext.removeExpiredCookie();
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

    public static String coerceValueIfNullOrEmpty(String paramString1, String paramString2) {
        if (isNullOrEmpty(paramString1)) {
            return paramString2;
        }
        return paramString1;
    }

    static Map<String, Object> convertJSONObjectToHashMap(JSONObject paramJSONObject) {
        HashMap localHashMap = new HashMap();
        JSONArray localJSONArray = paramJSONObject.names();
        int i = 0;
        while (i < localJSONArray.length()) {
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
        return localHashMap;
    }

    public static void deleteDirectory(File paramFile) {
        if (!paramFile.exists()) {
            return;
        }
        if (paramFile.isDirectory()) {
            File[] arrayOfFile = paramFile.listFiles();
            int j = arrayOfFile.length;
            int i = 0;
            while (i < j) {
                deleteDirectory(arrayOfFile[i]);
                i += 1;
            }
        }
        paramFile.delete();
    }

    public static void disconnectQuietly(URLConnection paramURLConnection) {
        if ((paramURLConnection instanceof HttpURLConnection)) {
            ((HttpURLConnection) paramURLConnection).disconnect();
        }
    }

    public static String getActivityName(Context paramContext) {
        if (paramContext == null) {
            return "null";
        }
        if (paramContext == paramContext.getApplicationContext()) {
            return "unknown";
        }
        return paramContext.getClass().getSimpleName();
    }

    private static GraphObject getAppSettingsQueryResponse(String paramString) {
        Bundle localBundle = new Bundle();
        localBundle.putString("fields", TextUtils.join(",", APP_SETTING_FIELDS));
        paramString = Request.newGraphPathRequest(null, paramString, null);
        paramString.setSkipClientToken(true);
        paramString.setParameters(localBundle);
        return paramString.executeAndWait().getGraphObject();
    }

    public static Utility.DialogFeatureConfig getDialogFeatureConfig(String paramString1, String paramString2, String paramString3) {
        if ((isNullOrEmpty(paramString2)) || (isNullOrEmpty(paramString3))) {
            return null;
        }
        paramString1 = (Utility.FetchedAppSettings) fetchedAppSettings.get(paramString1);
        if (paramString1 != null) {
            paramString1 = (Map) paramString1.getDialogConfigurations().get(paramString2);
            if (paramString1 != null) {
                return (Utility.DialogFeatureConfig) paramString1.get(paramString3);
            }
        }
        return null;
    }

    public static String getHashedDeviceAndAppID(Context paramContext, String paramString) {
        paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
        if (paramContext == null) {
            return null;
        }
        return sha1hash(paramContext + paramString);
    }

    public static String getMetadataApplicationId(Context paramContext) {
        Validate.notNull(paramContext, "context");
        Settings.loadDefaultsFromMetadata(paramContext);
        return Settings.getApplicationId();
    }

    public static Method getMethodQuietly(Class<?> paramClass, String paramString, Class<?>... paramVarArgs) {
        try {
            paramClass = paramClass.getMethod(paramString, paramVarArgs);
            return paramClass;
        } catch (NoSuchMethodException paramClass) {
        }
        return null;
    }

    public static Method getMethodQuietly(String paramString1, String paramString2, Class<?>... paramVarArgs) {
        try {
            paramString1 = getMethodQuietly(Class.forName(paramString1), paramString2, paramVarArgs);
            return paramString1;
        } catch (ClassNotFoundException paramString1) {
        }
        return null;
    }

    public static Object getStringPropertyAsJSON(JSONObject paramJSONObject, String paramString1, String paramString2) {
        paramJSONObject = paramJSONObject.opt(paramString1);
        if ((paramJSONObject != null) && ((paramJSONObject instanceof String))) {
            paramJSONObject = new JSONTokener((String) paramJSONObject).nextValue();
        }
        for (; ; ) {
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
    }

    private static String hashBytes(MessageDigest paramMessageDigest, byte[] paramArrayOfByte) {
        paramMessageDigest.update(paramArrayOfByte);
        paramMessageDigest = paramMessageDigest.digest();
        paramArrayOfByte = new StringBuilder();
        int j = paramMessageDigest.length;
        int i = 0;
        while (i < j) {
            int k = paramMessageDigest[i];
            paramArrayOfByte.append(Integer.toHexString(k >> 4 & 0xF));
            paramArrayOfByte.append(Integer.toHexString(k >> 0 & 0xF));
            i += 1;
        }
        return paramArrayOfByte.toString();
    }

    private static String hashWithAlgorithm(String paramString1, String paramString2) {
        return hashWithAlgorithm(paramString1, paramString2.getBytes());
    }

    private static String hashWithAlgorithm(String paramString, byte[] paramArrayOfByte) {
        try {
            paramString = MessageDigest.getInstance(paramString);
            return hashBytes(paramString, paramArrayOfByte);
        } catch (NoSuchAlgorithmException paramString) {
        }
        return null;
    }

    public static int[] intersectRanges(int[] paramArrayOfInt1, int[] paramArrayOfInt2) {
        int i2 = 0;
        if (paramArrayOfInt1 == null) {
            return paramArrayOfInt2;
        }
        if (paramArrayOfInt2 == null) {
            return paramArrayOfInt1;
        }
        int[] arrayOfInt = new int[paramArrayOfInt1.length + paramArrayOfInt2.length];
        int i3 = 0;
        int n = 0;
        int i = n;
        int j;
        int i4;
        if (i3 < paramArrayOfInt1.length) {
            i = n;
            if (i2 < paramArrayOfInt2.length) {
                j = paramArrayOfInt1[i3];
                i4 = paramArrayOfInt2[i2];
                if (i3 >= paramArrayOfInt1.length - 1) {
                    break label302;
                }
            }
        }
        label284:
        label302:
        for (i = paramArrayOfInt1[(i3 + 1)]; ; i = Integer.MAX_VALUE) {
            if (i2 < paramArrayOfInt2.length - 1) {
            }
            for (int i1 = paramArrayOfInt2[(i2 + 1)]; ; i1 = Integer.MAX_VALUE) {
                int k;
                int m;
                if (j < i4) {
                    if (i > i4) {
                        if (i > i1) {
                            k = i2 + 2;
                            j = i4;
                            i = i1;
                            m = i3;
                        }
                    }
                }
                for (; ; ) {
                    i2 = k;
                    i3 = m;
                    if (j == Integer.MIN_VALUE) {
                        break;
                    }
                    i1 = n + 1;
                    arrayOfInt[n] = j;
                    if (i == Integer.MAX_VALUE) {
                        break label284;
                    }
                    n = i1 + 1;
                    arrayOfInt[i1] = i;
                    i2 = k;
                    i3 = m;
                    break;
                    m = i3 + 2;
                    k = i2;
                    j = i4;
                    continue;
                    m = i3 + 2;
                    i = Integer.MAX_VALUE;
                    j = Integer.MIN_VALUE;
                    k = i2;
                    continue;
                    if (i1 > j) {
                        if (i1 > i) {
                            m = i3 + 2;
                            k = i2;
                        } else {
                            k = i2 + 2;
                            m = i3;
                            i = i1;
                        }
                    } else {
                        k = i2 + 2;
                        i = Integer.MAX_VALUE;
                        j = Integer.MIN_VALUE;
                        m = i3;
                    }
                }
                i = i1;
                return Arrays.copyOf(arrayOfInt, i);
            }
        }
    }

    public static Object invokeMethodQuietly(Object paramObject, Method paramMethod, Object... paramVarArgs) {
        try {
            paramObject = paramMethod.invoke(paramObject, paramVarArgs);
            return paramObject;
        } catch (IllegalAccessException paramObject) {
            return null;
        } catch (InvocationTargetException paramObject) {
        }
        return null;
    }

    public static boolean isNullOrEmpty(String paramString) {
        return (paramString == null) || (paramString.length() == 0);
    }

    public static <T> boolean isNullOrEmpty(Collection<T> paramCollection) {
        return (paramCollection == null) || (paramCollection.size() == 0);
    }

    public static <T> boolean isSubset(Collection<T> paramCollection1, Collection<T> paramCollection2) {
        boolean bool = false;
        if ((paramCollection2 == null) || (paramCollection2.size() == 0)) {
            if ((paramCollection1 == null) || (paramCollection1.size() == 0)) {
                bool = true;
            }
            return bool;
        }
        paramCollection2 = new HashSet(paramCollection2);
        paramCollection1 = paramCollection1.iterator();
        while (paramCollection1.hasNext()) {
            if (!paramCollection2.contains(paramCollection1.next())) {
                return false;
            }
        }
        return true;
    }

    public static void loadAppSettingsAsync(Context paramContext, String paramString) {
        Object localObject = null;
        if ((isNullOrEmpty(paramString)) || (fetchedAppSettings.containsKey(paramString)) || (initialAppSettingsLoadTask != null)) {
        }
        for (; ; ) {
            return;
            String str = String.format("com.facebook.internal.APP_SETTINGS.%s", new Object[]{paramString});
            initialAppSettingsLoadTask = new Utility .1 (paramString, paramContext, str);
            initialAppSettingsLoadTask.execute((Void[]) null);
            paramContext = paramContext.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0).getString(str, null);
            if (isNullOrEmpty(paramContext)) {
                continue;
            }
            try {
                paramContext = new JSONObject(paramContext);
                if (paramContext == null) {
                    continue;
                }
                parseAppSettingsFromJSON(paramString, paramContext);
                return;
            } catch (JSONException paramContext) {
                for (; ; ) {
                    logd("FacebookSDK", paramContext);
                    paramContext = (Context) localObject;
                }
            }
        }
    }

    public static void logd(String paramString, Exception paramException) {
        if ((Settings.isDebugEnabled()) && (paramString != null) && (paramException != null)) {
            Log.d(paramString, paramException.getClass().getSimpleName() + ": " + paramException.getMessage());
        }
    }

    public static void logd(String paramString1, String paramString2) {
        if ((Settings.isDebugEnabled()) && (paramString1 != null) && (paramString2 != null)) {
            Log.d(paramString1, paramString2);
        }
    }

    public static void logd(String paramString1, String paramString2, Throwable paramThrowable) {
        if ((Settings.isDebugEnabled()) && (!isNullOrEmpty(paramString1))) {
            Log.d(paramString1, paramString2, paramThrowable);
        }
    }

    static String md5hash(String paramString) {
        return hashWithAlgorithm("MD5", paramString);
    }

    private static Utility.FetchedAppSettings parseAppSettingsFromJSON(String paramString, JSONObject paramJSONObject) {
        paramJSONObject = new Utility.FetchedAppSettings(paramJSONObject.optBoolean("supports_attribution", false), paramJSONObject.optBoolean("supports_implicit_sdk_logging", false), paramJSONObject.optString("gdpv4_nux_content", ""), paramJSONObject.optBoolean("gdpv4_nux_enabled", false), parseDialogConfigurations(paramJSONObject.optJSONObject("android_dialog_configs")), null);
        fetchedAppSettings.put(paramString, paramJSONObject);
        return paramJSONObject;
    }

    private static Map<String, Map<String, Utility.DialogFeatureConfig>> parseDialogConfigurations(JSONObject paramJSONObject) {
        HashMap localHashMap = new HashMap();
        if (paramJSONObject != null) {
            JSONArray localJSONArray = paramJSONObject.optJSONArray("data");
            if (localJSONArray != null) {
                int i = 0;
                if (i < localJSONArray.length()) {
                    Utility.DialogFeatureConfig localDialogFeatureConfig = Utility.DialogFeatureConfig.access$400(localJSONArray.optJSONObject(i));
                    if (localDialogFeatureConfig == null) {
                    }
                    for (; ; ) {
                        i += 1;
                        break;
                        String str = localDialogFeatureConfig.getDialogName();
                        Map localMap = (Map) localHashMap.get(str);
                        paramJSONObject = localMap;
                        if (localMap == null) {
                            paramJSONObject = new HashMap();
                            localHashMap.put(str, paramJSONObject);
                        }
                        paramJSONObject.put(localDialogFeatureConfig.getFeatureName(), localDialogFeatureConfig);
                    }
                }
            }
        }
        return localHashMap;
    }

    public static Bundle parseUrlQueryString(String paramString) {
        Bundle localBundle = new Bundle();
        int j;
        int i;
        if (!isNullOrEmpty(paramString)) {
            paramString = paramString.split("&");
            j = paramString.length;
            i = 0;
        }
        for (; ; ) {
            if (i < j) {
                String[] arrayOfString = paramString[i].split("=");
                try {
                    if (arrayOfString.length == 2) {
                        localBundle.putString(URLDecoder.decode(arrayOfString[0], "UTF-8"), URLDecoder.decode(arrayOfString[1], "UTF-8"));
                    } else if (arrayOfString.length == 1) {
                        localBundle.putString(URLDecoder.decode(arrayOfString[0], "UTF-8"), "");
                    }
                } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
                    logd("FacebookSDK", localUnsupportedEncodingException);
                }
            }
            return localBundle;
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

    public static Utility.FetchedAppSettings queryAppSettings(String paramString, boolean paramBoolean) {
        if ((!paramBoolean) && (fetchedAppSettings.containsKey(paramString))) {
            return (Utility.FetchedAppSettings) fetchedAppSettings.get(paramString);
        }
        GraphObject localGraphObject = getAppSettingsQueryResponse(paramString);
        if (localGraphObject == null) {
            return null;
        }
        return parseAppSettingsFromJSON(paramString, localGraphObject.getInnerJSONObject());
    }

    /* Error */
    public static String readStreamToString(java.io.InputStream paramInputStream) {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: new 670	java/io/BufferedInputStream
        //   5: dup
        //   6: aload_0
        //   7: invokespecial 673	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
        //   10: astore_0
        //   11: new 675	java/io/InputStreamReader
        //   14: dup
        //   15: aload_0
        //   16: invokespecial 676	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   19: astore_2
        //   20: new 209	java/lang/StringBuilder
        //   23: dup
        //   24: invokespecial 210	java/lang/StringBuilder:<init>	()V
        //   27: astore_3
        //   28: sipush 2048
        //   31: newarray <illegal type>
        //   33: astore 4
        //   35: aload_2
        //   36: aload 4
        //   38: invokevirtual 680	java/io/InputStreamReader:read	([C)I
        //   41: istore_1
        //   42: iload_1
        //   43: iconst_m1
        //   44: if_icmpeq +32 -> 76
        //   47: aload_3
        //   48: aload 4
        //   50: iconst_0
        //   51: iload_1
        //   52: invokevirtual 683	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
        //   55: pop
        //   56: goto -21 -> 35
        //   59: astore 4
        //   61: aload_0
        //   62: astore_3
        //   63: aload 4
        //   65: astore_0
        //   66: aload_3
        //   67: invokestatic 685	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   70: aload_2
        //   71: invokestatic 685	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   74: aload_0
        //   75: athrow
        //   76: aload_3
        //   77: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   80: astore_3
        //   81: aload_0
        //   82: invokestatic 685	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   85: aload_2
        //   86: invokestatic 685	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   89: aload_3
        //   90: areturn
        //   91: astore_0
        //   92: aconst_null
        //   93: astore_2
        //   94: goto -28 -> 66
        //   97: astore 4
        //   99: aconst_null
        //   100: astore_2
        //   101: aload_0
        //   102: astore_3
        //   103: aload 4
        //   105: astore_0
        //   106: goto -40 -> 66
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	109	0	paramInputStream	java.io.InputStream
        //   41	11	1	i	int
        //   19	82	2	localInputStreamReader	java.io.InputStreamReader
        //   1	102	3	localObject1	Object
        //   33	16	4	arrayOfChar	char[]
        //   59	5	4	localObject2	Object
        //   97	7	4	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   20	35	59	finally
        //   35	42	59	finally
        //   47	56	59	finally
        //   76	81	59	finally
        //   2	11	91	finally
        //   11	20	97	finally
    }

    public static boolean safeGetBooleanFromResponse(GraphObject paramGraphObject, String paramString) {
        Object localObject = Boolean.valueOf(false);
        if (paramGraphObject != null) {
            localObject = paramGraphObject.getProperty(paramString);
        }
        paramGraphObject = (GraphObject) localObject;
        if (!(localObject instanceof Boolean)) {
            paramGraphObject = Boolean.valueOf(false);
        }
        return ((Boolean) paramGraphObject).booleanValue();
    }

    public static String safeGetStringFromResponse(GraphObject paramGraphObject, String paramString) {
        Object localObject = "";
        if (paramGraphObject != null) {
            localObject = paramGraphObject.getProperty(paramString);
        }
        paramGraphObject = (GraphObject) localObject;
        if (!(localObject instanceof String)) {
            paramGraphObject = "";
        }
        return (String) paramGraphObject;
    }

    public static void setAppEventAttributionParameters(GraphObject paramGraphObject, AttributionIdentifiers paramAttributionIdentifiers, String paramString, boolean paramBoolean) {
        boolean bool2 = true;
        if ((paramAttributionIdentifiers != null) && (paramAttributionIdentifiers.getAttributionId() != null)) {
            paramGraphObject.setProperty("attribution", paramAttributionIdentifiers.getAttributionId());
        }
        boolean bool1;
        if ((paramAttributionIdentifiers != null) && (paramAttributionIdentifiers.getAndroidAdvertiserId() != null)) {
            paramGraphObject.setProperty("advertiser_id", paramAttributionIdentifiers.getAndroidAdvertiserId());
            if (!paramAttributionIdentifiers.isTrackingLimited()) {
                bool1 = true;
                paramGraphObject.setProperty("advertiser_tracking_enabled", Boolean.valueOf(bool1));
                label75:
                if (paramBoolean) {
                    break label119;
                }
            }
        }
        label119:
        for (paramBoolean = bool2; ; paramBoolean = false) {
            paramGraphObject.setProperty("application_tracking_enabled", Boolean.valueOf(paramBoolean));
            return;
            bool1 = false;
            break;
            if (paramString == null) {
                break label75;
            }
            paramGraphObject.setProperty("advertiser_id", paramString);
            break label75;
        }
    }

    public static void setAppEventExtendedDeviceInfoParameters(GraphObject paramGraphObject, Context paramContext) {
        JSONArray localJSONArray = new JSONArray();
        localJSONArray.put("a1");
        String str2 = paramContext.getPackageName();
        int j = -1;
        str1 = "";
        int i = j;
        try {
            paramContext = paramContext.getPackageManager().getPackageInfo(str2, 0);
            i = j;
            j = paramContext.versionCode;
            i = j;
            paramContext = paramContext.versionName;
            i = j;
        } catch (PackageManager.NameNotFoundException paramContext) {
            for (; ; ) {
                paramContext = str1;
            }
        }
        localJSONArray.put(str2);
        localJSONArray.put(i);
        localJSONArray.put(paramContext);
        paramGraphObject.setProperty("extinfo", localJSONArray.toString());
    }

    static String sha1hash(String paramString) {
        return hashWithAlgorithm("SHA-1", paramString);
    }

    static String sha1hash(byte[] paramArrayOfByte) {
        return hashWithAlgorithm("SHA-1", paramArrayOfByte);
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

    public static JSONArray tryGetJSONArrayFromResponse(GraphObject paramGraphObject, String paramString) {
        if (paramGraphObject == null) {
            return null;
        }
        paramGraphObject = paramGraphObject.getProperty(paramString);
        if (!(paramGraphObject instanceof JSONArray)) {
            return null;
        }
        return (JSONArray) paramGraphObject;
    }

    public static JSONObject tryGetJSONObjectFromResponse(GraphObject paramGraphObject, String paramString) {
        if (paramGraphObject == null) {
            return null;
        }
        paramGraphObject = paramGraphObject.getProperty(paramString);
        if (!(paramGraphObject instanceof JSONObject)) {
            return null;
        }
        return (JSONObject) paramGraphObject;
    }

    public static <T> Collection<T> unmodifiableCollection(T... paramVarArgs) {
        return Collections.unmodifiableCollection(Arrays.asList(paramVarArgs));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/Utility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */