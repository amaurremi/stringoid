package com.inmobi.commons.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.cache.CacheController;
import com.inmobi.commons.cache.CacheController.Validator;
import com.inmobi.commons.cache.ProductConfig;
import com.inmobi.commons.metric.Logger;
import com.inmobi.commons.thirdparty.Base64;
import com.inmobi.commons.uid.UID;

import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;

import org.json.JSONException;
import org.json.JSONObject;

public class InternalSDKUtil {
    public static final String ACTION_CONNECTIVITY_UPDATE = "android.net.conn.CONNECTIVITY_CHANGE";
    public static final String ACTION_RECEIVER_REFERRER = "com.android.vending.INSTALL_REFERRER";
    public static final String ACTION_SHARE_INMID = "com.inmobi.share.id";
    public static final String BASE_LOG_TAG = "[InMobi]";
    public static final String IM_PREF = "impref";
    public static final String INMOBI_SDK_RELEASE_DATE = "20140918";
    public static final String INMOBI_SDK_RELEASE_VERSION = "4.5.1";
    public static final String KEY_LTVID = "ltvid";
    public static final String LOGGING_TAG = "[InMobi]-4.5.1";
    public static final String PRODUCT_COMMONS = "commons";
    private static CommonsConfig a = new CommonsConfig();
    private static String b;
    private static Context c = null;
    private static Map<String, String> d = new HashMap();
    private static CacheController.Validator e = new d();
    private static boolean f = true;

    public static Map<String, Object> JSONToMap(JSONObject paramJSONObject) {
        try {
            HashMap localHashMap = new HashMap();
            Iterator localIterator = paramJSONObject.keys();
            while (localIterator.hasNext()) {
                String str = (String) localIterator.next();
                try {
                    localHashMap.put(str, paramJSONObject.get(str));
                } catch (JSONException localJSONException) {
                }
            }
            return localHashMap;
        } catch (Exception paramJSONObject) {
        }
        return null;
    }

    private static void a() {
        d = UID.getInstance().getMapForEncryption(null);
    }

    static boolean a(Map<String, Object> paramMap) {

        try {
            CommonsConfig localCommonsConfig = new CommonsConfig();
            localCommonsConfig.setFromMap(paramMap);
            a = localCommonsConfig;
            ApiStatCollector.getLogger().setMetricConfigParams(localCommonsConfig.getApiStatsConfig());
            return true;
        } catch (Exception paramMap) {
            paramMap.printStackTrace();
        }
        return false;
    }

    private static byte[] a(byte[] paramArrayOfByte, int paramInt, Cipher paramCipher) {
        if (paramInt == 1) {
        }
        int j = paramArrayOfByte.length;
        Object localObject3 = new byte[64];
        Object localObject1 = new byte[0];
        paramInt = 0;
        Object localObject4;
        Object localObject2;
        if (paramInt < j) {
            localObject4 = localObject3;
            localObject2 = localObject1;
            if (paramInt > 0) {
                localObject4 = localObject3;
                localObject2 = localObject1;
                if (paramInt % 64 == 0) {
                    localObject2 = a((byte[]) localObject1, paramCipher.doFinal((byte[]) localObject3));
                    if (paramInt + 64 <= j) {
                        break label124;
                    }
                }
            }
        }
        label124:
        for (int i = j - paramInt; ; i = 64) {
            localObject4 = new byte[i];
            localObject4[(paramInt % 64)] = paramArrayOfByte[paramInt];
            paramInt += 1;
            localObject3 = localObject4;
            localObject1 = localObject2;
            break;
            return a((byte[]) localObject1, paramCipher.doFinal((byte[]) localObject3));
        }
    }

    private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {
        byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
        System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
        return arrayOfByte;
    }

    public static String byteToHex(byte paramByte) {
        try {
            Object localObject = new char[16];
            Object tmp6_5 = localObject;
            tmp6_5[0] = 48;
            Object tmp11_6 = tmp6_5;
            tmp11_6[1] = 49;
            Object tmp16_11 = tmp11_6;
            tmp16_11[2] = 50;
            Object tmp21_16 = tmp16_11;
            tmp21_16[3] = 51;
            Object tmp26_21 = tmp21_16;
            tmp26_21[4] = 52;
            Object tmp31_26 = tmp26_21;
            tmp31_26[5] = 53;
            Object tmp36_31 = tmp31_26;
            tmp36_31[6] = 54;
            Object tmp42_36 = tmp36_31;
            tmp42_36[7] = 55;
            Object tmp48_42 = tmp42_36;
            tmp48_42[8] = 56;
            Object tmp54_48 = tmp48_42;
            tmp54_48[9] = 57;
            Object tmp60_54 = tmp54_48;
            tmp60_54[10] = 97;
            Object tmp66_60 = tmp60_54;
            tmp66_60[11] = 98;
            Object tmp72_66 = tmp66_60;
            tmp72_66[12] = 99;
            Object tmp78_72 = tmp72_66;
            tmp78_72[13] = 100;
            Object tmp84_78 = tmp78_72;
            tmp84_78[14] = 101;
            Object tmp90_84 = tmp84_78;
            tmp90_84[15] = 102;
            tmp90_84;
            localObject = new String(new char[]{localObject[(paramByte >> 4 & 0xF)], localObject[(paramByte & 0xF)]});
            return (String) localObject;
        } catch (Exception localException) {
        }
        return null;
    }

    public static boolean checkNetworkAvailibility(Context paramContext) {
        if (paramContext == null) {
            return false;
        }
        try {
            paramContext = (ConnectivityManager) paramContext.getSystemService("connectivity");
            if (paramContext.getActiveNetworkInfo() == null) {
                return false;
            }
            boolean bool = paramContext.getActiveNetworkInfo().isConnected();
            return bool;
        } catch (Exception paramContext) {
            Log.internal("[InMobi]-4.5.1", "Cannot check network state", paramContext);
        }
        return false;
    }

    public static String convertListToDelimitedString(List<?> paramList, String paramString) {
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 0;
        for (; ; ) {
            if (i >= paramList.size()) {
                break label86;
            }
            try {
                if (localStringBuilder.length() > 0) {
                    localStringBuilder.append(paramString);
                }
                localStringBuilder.append(paramList.get(i));
            } catch (Exception localException) {
                for (; ; ) {
                    Log.internal("[InMobi]-4.5.1", "Exception Converting map to deliminated string " + paramList.toString(), localException);
                }
            }
            i += 1;
        }
        label86:
        return localStringBuilder.toString();
    }

    public static String encodeMapAndconvertToDelimitedString(Map<String, ? extends Object> paramMap, String paramString) {
        StringBuilder localStringBuilder = new StringBuilder();
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            try {
                if (localStringBuilder.length() > 0) {
                    localStringBuilder.append(paramString);
                }
                localStringBuilder.append(String.format("%s=%s", new Object[]{getURLEncoded(str), getURLEncoded(paramMap.get(str).toString())}));
            } catch (Exception localException) {
                Log.internal("[InMobi]-4.5.1", "Exception Converting map to deliminated string " + paramMap.toString(), localException);
            }
        }
        return localStringBuilder.toString();
    }

    public static String encryptRSA(String paramString) {
        if ((paramString == null) || ("".equals(paramString))) {
            return null;
        }
        try {
            Object localObject1 = new BigInteger("C10F7968CFE2C76AC6F0650C877806D4514DE58FC239592D2385BCE5609A84B2A0FBDAF29B05505EAD1FDFEF3D7209ACBF34B5D0A806DF18147EA9C0337D6B5B", 16);
            Object localObject2 = new BigInteger("010001", 16);
            localObject1 = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec((BigInteger) localObject1, (BigInteger) localObject2));
            localObject2 = Cipher.getInstance("RSA/ECB/nopadding");
            ((Cipher) localObject2).init(1, (Key) localObject1);
            paramString = new String(Base64.encode(a(paramString.getBytes("UTF-8"), 1, (Cipher) localObject2), 0));
            return paramString;
        } catch (Exception paramString) {
            Log.debug("[InMobi]-4.5.1", "Exception in encryptRSA", paramString);
        }
        return null;
    }

    public static boolean getBooleanFromJSON(JSONObject paramJSONObject, String paramString, boolean paramBoolean) {
        try {
            boolean bool = paramJSONObject.getBoolean(paramString);
            return bool;
        } catch (Exception localException) {
            try {
                Log.debug("[InMobi]-4.5.1", "JSON with property " + paramString + " found but has bad datatype(" + paramJSONObject.get(paramString).getClass() + "). Reverting to " + paramBoolean);
                return paramBoolean;
            } catch (JSONException paramJSONObject) {
            }
        }
        return paramBoolean;
    }

    public static boolean getBooleanFromMap(Map<String, Object> paramMap, String paramString) {
        paramMap = paramMap.get(paramString);
        if ((paramMap instanceof Boolean)) {
            return ((Boolean) paramMap).booleanValue();
        }
        Log.internal("[InMobi]-4.5.1", "Key " + paramString + " has illegal value");
        throw new IllegalArgumentException();
    }

    public static CommonsConfig getConfig() {
        return a;
    }

    public static String getConnectivityType(Context paramContext) {
        int j;
        label89:
        label93:
        do {
            try {
                if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
                    break label89;
                }
                paramContext = (ConnectivityManager) paramContext.getSystemService("connectivity");
                if (paramContext == null) {
                    break label89;
                }
                paramContext = paramContext.getActiveNetworkInfo();
                if (paramContext == null) {
                    break label89;
                }
                int i = paramContext.getType();
                j = paramContext.getSubtype();
                if (i == 1) {
                    return "wifi";
                }
                if (i != 0) {
                    break label89;
                }
                paramContext = "carrier";
                if (j != 1) {
                    break label93;
                }
                return "gprs";
            } catch (Exception paramContext) {
                Log.internal("[InMobi]-4.5.1", "Error getting the network info", paramContext);
                return null;
            }
            if (j == 0) {
                return "carrier";
                paramContext = null;
            }
            return paramContext;
            if (j == 2) {
                return "edge";
            }
        } while (j != 3);
        return "umts";
    }

    public static Context getContext() {
        return c;
    }

    public static String getDigested(String paramString1, String paramString2) {
        if (paramString1 != null) {
            try {
                if (!"".equals(paramString1.trim())) {
                    paramString2 = MessageDigest.getInstance(paramString2);
                    paramString2.update(paramString1.getBytes());
                    paramString1 = paramString2.digest();
                    paramString2 = new StringBuffer();
                    int i = 0;
                    while (i < paramString1.length) {
                        paramString2.append(Integer.toString((paramString1[i] & 0xFF) + 256, 16).substring(1));
                        i += 1;
                    }
                    paramString1 = paramString2.toString();
                    return paramString1;
                }
            } catch (Exception paramString1) {
                Log.debug("[InMobi]-4.5.1", "Exception in getting ODIN-1", paramString1);
                return null;
            }
        }
        return "TEST_EMULATOR";
    }

    public static Map<String, String> getEncodedMap(Map<String, ? extends Object> paramMap) {
        HashMap localHashMap = new HashMap();
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            try {
                localHashMap.put(getURLEncoded(str), getURLEncoded(paramMap.get(str).toString()));
            } catch (Exception localException) {
                Log.internal("[InMobi]-4.5.1", "Exception Map encoding " + paramMap.toString(), localException);
            }
        }
        return localHashMap;
    }

    public static String getFinalRedirectedUrl(String paramString) {
        int i = 0;
        String str2;
        label139:
        for (; ; ) {
            try {
                localHttpURLConnection = (HttpURLConnection) new URL(paramString).openConnection();
                localHttpURLConnection.setRequestProperty("User-Agent", getUserAgent());
                localHttpURLConnection.setUseCaches(false);
                localHttpURLConnection.setRequestMethod("GET");
                j = localHttpURLConnection.getResponseCode();
                if ((j < 300) || (j >= 400)) {
                    break label139;
                }
                str1 = localHttpURLConnection.getHeaderField("Location");
                if (str1 == null) {
                    str2 = paramString;
                }
            } catch (Exception localException1) {
                HttpURLConnection localHttpURLConnection;
                int j;
                String str1;
                Log.internal("[InMobi]-4.5.1", "Cannot get redirect url", localException1);
                return paramString;
            }
            try {
                localHttpURLConnection.disconnect();
                return paramString;
            } catch (Exception localException2) {
                paramString = str2;
                continue;
            }
            str2 = str1;
            j = localHttpURLConnection.getResponseCode();
            paramString = str1;
            if (j != 200) {
                paramString = str1;
                if (i < 5) {
                    i += 1;
                    paramString = str1;
                }
            }
        }
    }

    public static String getInMobiInternalVersion(String paramString) {
        paramString = paramString.split("[.]");
        StringBuffer localStringBuffer = new StringBuffer("");
        int i = 0;
        for (; ; ) {
            if (i < paramString.length) {
            }
            try {
                int j = Integer.valueOf(paramString[i]).intValue();
                localStringBuffer.append("T").append((char) (j + 65));
                i += 1;
                continue;
                if (localStringBuffer.equals("")) {
                    return "";
                }
                return localStringBuffer.substring(1).toString();
            } catch (NumberFormatException localNumberFormatException) {
                for (; ; ) {
                }
            }
        }
    }

    public static int getIntFromJSON(JSONObject paramJSONObject, String paramString, int paramInt) {
        try {
            int i = paramJSONObject.getInt(paramString);
            return i;
        } catch (Exception localException) {
            try {
                Log.debug("[InMobi]-4.5.1", "JSON with property " + paramString + " found but has bad datatype(" + paramJSONObject.get(paramString).getClass() + "). Reverting to " + paramInt);
                return paramInt;
            } catch (JSONException paramJSONObject) {
            }
        }
        return paramInt;
    }

    public static int getIntFromMap(Map<String, Object> paramMap, String paramString, int paramInt, long paramLong) {
        paramMap = paramMap.get(paramString);
        if ((paramMap instanceof Integer)) {
            int i = ((Integer) paramMap).intValue();
            if ((i <= paramLong) && (i >= paramInt)) {
                return i;
            }
        }
        Log.internal("[InMobi]-4.5.1", "Key " + paramString + " has illegal value");
        throw new IllegalArgumentException();
    }

    public static long getLongFromJSON(JSONObject paramJSONObject, String paramString, long paramLong) {
        try {
            long l = paramJSONObject.getLong(paramString);
            return l;
        } catch (Exception localException) {
            try {
                Log.debug("[InMobi]-4.5.1", "JSON with property " + paramString + " found but has bad datatype(" + paramJSONObject.get(paramString).getClass() + "). Reverting to " + paramLong);
                return paramLong;
            } catch (JSONException paramJSONObject) {
            }
        }
        return paramLong;
    }

    public static long getLongFromMap(Map<String, Object> paramMap, String paramString, long paramLong1, long paramLong2) {
        Object localObject = paramMap.get(paramString);
        if ((localObject instanceof Long)) {
            l = ((Long) localObject).longValue();
            if ((l <= paramLong2) && (l >= paramLong1)) {
                return l;
            }
        }
        long l = paramLong1;
        if (paramLong1 < -2147483648L) {
            l = -2147483648L;
        }
        int i = (int) l;
        paramLong1 = paramLong2;
        if (paramLong2 > 2147483647L) {
            paramLong1 = 2147483647L;
        }
        return getIntFromMap(paramMap, paramString, i, (int) paramLong1);
    }

    public static String getLtvpSessionId() {
        return getContext().getSharedPreferences("inmobiAppAnalyticsSession", 0).getString("APP_SESSION_ID", null);
    }

    public static Object getObjectFromMap(Map<String, Object> paramMap, String paramString) {
        paramMap = paramMap.get(paramString);
        if ((paramMap != null) && ((paramMap instanceof Map))) {
            if (((Map) paramMap).isEmpty()) {
                Log.internal("[InMobi]-4.5.1", "Key " + paramString + " has empty object as value.");
                throw new IllegalArgumentException();
            }
        } else {
            Log.internal("[InMobi]-4.5.1", "Key " + paramString + " has illegal value");
            throw new IllegalArgumentException();
        }
        return paramMap;
    }

    public static String getSavedUserAgent() {
        return b;
    }

    public static String getStringFromJSON(JSONObject paramJSONObject, String paramString1, String paramString2) {
        try {
            String str = paramJSONObject.getString(paramString1);
            return str;
        } catch (Exception localException) {
            try {
                Log.debug("[InMobi]-4.5.1", "JSON with property " + paramString1 + " found but has bad datatype(" + paramJSONObject.get(paramString1).getClass() + "). Reverting to " + paramString2);
                return paramString2;
            } catch (JSONException paramJSONObject) {
            }
        }
        return paramString2;
    }

    public static String getStringFromMap(Map<String, Object> paramMap, String paramString) {
        paramMap = paramMap.get(paramString);
        if ((paramMap instanceof String)) {
            return (String) paramMap;
        }
        Log.internal("[InMobi]-4.5.1", "Key " + paramString + " has illegal value");
        throw new IllegalArgumentException();
    }

    public static String getURLDecoded(String paramString1, String paramString2) {
        try {
            paramString2 = URLDecoder.decode(paramString1, paramString2);
            return paramString2;
        } catch (Exception paramString2) {
            Log.internal("[InMobi]-4.5.1", "Exception URL decoding " + paramString1, paramString2);
        }
        return "";
    }

    public static String getURLEncoded(String paramString) {
        try {
            String str = URLEncoder.encode(paramString, "UTF-8");
            return str;
        } catch (Exception localException) {
            Log.internal("[InMobi]-4.5.1", "Exception URL encoding " + paramString, localException);
        }
        return "";
    }

    public static String getUserAgent() {
        try {
            if (b == null) {
                if (Build.VERSION.SDK_INT < 17) {
                    break label27;
                }
            }
            label27:
            for (b = InternalSDKUtil.a.a(c); ; b = new WebView(c).getSettings().getUserAgentString()) {
                return b;
            }
            return b;
        } catch (Exception localException) {
            Log.internal("[InMobi]-4.5.1", "Cannot get user agent", localException);
        }
    }

    public static void initialize(Context paramContext) {
        if (getContext() == null) {
            if (paramContext != null) {
                break label24;
            }
            c.getApplicationContext();
        }
        while (InMobi.getAppId() == null) {
            return;
            label24:
            c = paramContext.getApplicationContext();
        }
        if (f) {
            f = false;
            a();
        }
        try {
            a(CacheController.getConfig("commons", paramContext, d, e).getData());
            return;
        } catch (CommonsException paramContext) {
            Log.internal("[InMobi]-4.5.1", "IMCommons config init: IMCommonsException caught. Reason: " + paramContext.toString());
            return;
        } catch (Exception paramContext) {
            Log.internal("[InMobi]-4.5.1", "Exception while getting commons config data.");
        }
    }

    public static boolean isHexString(String paramString) {
        return paramString.matches("[0-9A-F]+");
    }

    public static boolean isInitializedSuccessfully() {
        return isInitializedSuccessfully(true);
    }

    public static boolean isInitializedSuccessfully(boolean paramBoolean) {
        if ((getContext() == null) || (InMobi.getAppId() == null)) {
            if (paramBoolean) {
                Log.debug("[InMobi]-4.5.1", "InMobi not initialized. Call InMobi.initialize before using any InMobi API");
            }
            return false;
        }
        return true;
    }

    public static String mapToJSONs(Map<String, Object> paramMap) {
        if (paramMap != null) {
            JSONObject localJSONObject = new JSONObject();
            Iterator localIterator = paramMap.keySet().iterator();
            while (localIterator.hasNext()) {
                String str = (String) localIterator.next();
                try {
                    localJSONObject.put(str, paramMap.get(str));
                } catch (JSONException localJSONException) {
                    Log.internal("[InMobi]-4.5.1", "Unable to convert map to JSON for key " + str);
                }
            }
            return localJSONObject.toString();
        }
        return null;
    }

    public static void populate(Map<String, Object> paramMap1, Map<String, Object> paramMap2, boolean paramBoolean) {
        Iterator localIterator = paramMap1.keySet().iterator();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            if (paramMap2.get(str) == null) {
                paramMap2.put(str, paramMap1.get(str));
            }
            Object localObject1 = paramMap1.get(str);
            Object localObject2 = paramMap2.get(str);
            if (((localObject1 instanceof Map)) && ((localObject2 instanceof Map))) {
                if (!paramBoolean) {
                    paramMap2.put(str, localObject1);
                } else {
                    populate((Map) localObject1, (Map) localObject2, true);
                }
            } else {
                paramMap2.put(str, localObject1);
            }
        }
    }

    public static void populate(JSONObject paramJSONObject1, JSONObject paramJSONObject2, boolean paramBoolean) {
        Iterator localIterator = paramJSONObject1.keys();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            Object localObject2;
            try {
                paramJSONObject2.get(str);
                try {
                    Object localObject1 = paramJSONObject1.get(str);
                    localObject2 = paramJSONObject2.get(str);
                    if ((!(localObject1 instanceof JSONObject)) || (!(localObject2 instanceof JSONObject))) {
                        break label130;
                    }
                    if (paramBoolean) {
                        break label113;
                    }
                    paramJSONObject2.put(str, localObject1);
                } catch (JSONException localJSONException1) {
                    Log.internal("[InMobi]-4.5.1", "Cannot populate to json exception", localJSONException1);
                }
            } catch (JSONException localJSONException2) {
                paramJSONObject2.put(localJSONException1, paramJSONObject1.get(localJSONException1));
            }
            continue;
            label113:
            populate((JSONObject) localJSONException2, (JSONObject) localObject2, true);
            continue;
            label130:
            paramJSONObject2.put(localJSONException1, localJSONException2);
        }
    }

    public static JSONObject populateToNewJSON(JSONObject paramJSONObject1, JSONObject paramJSONObject2, boolean paramBoolean) {
        JSONObject localJSONObject = new JSONObject();
        populate(paramJSONObject2, localJSONObject, false);
        populate(paramJSONObject1, localJSONObject, paramBoolean);
        return localJSONObject;
    }

    public static Map<String, Object> populateToNewMap(Map<String, Object> paramMap1, Map<String, Object> paramMap2, boolean paramBoolean) {
        HashMap localHashMap = new HashMap();
        populate(paramMap2, localHashMap, false);
        populate(paramMap1, localHashMap, paramBoolean);
        return localHashMap;
    }

    public static void setContext(Context paramContext) {
        if (c == null) {
            c = paramContext.getApplicationContext();
            if (InMobi.getAppId() != null) {
            }
        } else {
            return;
        }
        a();
        try {
            CacheController.getConfig("commons", paramContext, d, e);
            return;
        } catch (CommonsException paramContext) {
            Log.internal("commons", "Unable retrive config for commons product");
        }
    }

    public static String union(String paramString1, String paramString2) {
        String[] arrayOfString = paramString1.split(",");
        int i = 0;
        while (i < arrayOfString.length) {
            paramString1 = paramString2;
            if (!paramString2.contains(arrayOfString[i])) {
                paramString1 = paramString2 + "," + arrayOfString[i];
            }
            i += 1;
            paramString2 = paramString1;
        }
        return paramString2;
    }

    public static boolean validateAppId(String paramString) {
        if (paramString == null) {
            Log.debug("[InMobi]-4.5.1", "appId is null");
            return false;
        }
        if (paramString.matches("(x)+")) {
            Log.debug("[InMobi]-4.5.1", "appId is all xxxxxxx");
            return false;
        }
        if ("".equals(paramString.trim())) {
            Log.debug("[InMobi]-4.5.1", "appId is all blank");
            return false;
        }
        return true;
    }

    public static String xorWithKey(String paramString1, String paramString2) {
        try {
            paramString1 = paramString1.getBytes("UTF-8");
            byte[] arrayOfByte = new byte[paramString1.length];
            paramString2 = paramString2.getBytes("UTF-8");
            int i = 0;
            while (i < paramString1.length) {
                arrayOfByte[i] = ((byte) (paramString1[i] ^ paramString2[(i % paramString2.length)]));
                i += 1;
            }
            paramString1 = new String(Base64.encode(arrayOfByte, 2), "UTF-8");
            return paramString1;
        } catch (Exception paramString1) {
            Log.debug("[InMobi]-4.5.1", "Exception in xor with random integer", paramString1);
        }
        return "";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/internal/InternalSDKUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */