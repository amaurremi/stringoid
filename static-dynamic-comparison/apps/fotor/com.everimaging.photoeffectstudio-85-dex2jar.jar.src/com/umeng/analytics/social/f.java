package com.umeng.analytics.social;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public abstract class f {
    private static Map<String, String> a;

    protected static String a(Context paramContext) {
        String str = e.d;
        if (!TextUtils.isEmpty(str)) {
            b.b("MobclickAgent", "use usefully appkey from constant field.");
            return str;
        }
        try {
            paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
            if (paramContext != null) {
                paramContext = paramContext.metaData.getString("UMENG_APPKEY");
                if (paramContext != null) {
                    return paramContext.trim();
                }
                b.b("MobclickAgent", "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.");
            }
        } catch (Exception paramContext) {
            for (; ; ) {
                b.b("MobclickAgent", "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.", paramContext);
            }
        }
        return null;
    }

    private static String a(List<NameValuePair> paramList) {
        try {
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            new UrlEncodedFormEntity(paramList, "UTF-8").writeTo(localByteArrayOutputStream);
            paramList = localByteArrayOutputStream.toString();
            return paramList;
        } catch (Exception paramList) {
            paramList.printStackTrace();
        }
        return null;
    }

    private static List<NameValuePair> a(UMPlatformData... paramVarArgs) {
        StringBuilder localStringBuilder1 = new StringBuilder();
        StringBuilder localStringBuilder2 = new StringBuilder();
        StringBuilder localStringBuilder3 = new StringBuilder();
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j) {
            UMPlatformData localUMPlatformData = paramVarArgs[i];
            localStringBuilder1.append(localUMPlatformData.getMeida().toString());
            localStringBuilder1.append(',');
            localStringBuilder2.append(localUMPlatformData.getUsid());
            localStringBuilder2.append(',');
            localStringBuilder3.append(localUMPlatformData.getWeiboId());
            localStringBuilder3.append(',');
            i += 1;
        }
        if (paramVarArgs.length > 0) {
            localStringBuilder1.deleteCharAt(localStringBuilder1.length() - 1);
            localStringBuilder2.deleteCharAt(localStringBuilder2.length() - 1);
            localStringBuilder3.deleteCharAt(localStringBuilder3.length() - 1);
        }
        paramVarArgs = new ArrayList();
        paramVarArgs.add(new BasicNameValuePair("platform", localStringBuilder1.toString()));
        paramVarArgs.add(new BasicNameValuePair("usid", localStringBuilder2.toString()));
        if (localStringBuilder3.length() > 0) {
            paramVarArgs.add(new BasicNameValuePair("weiboid", localStringBuilder3.toString()));
        }
        return paramVarArgs;
    }

    private static boolean a(Context paramContext, String paramString) {
        return paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) == 0;
    }

    protected static String[] a(Context paramContext, String paramString, UMPlatformData... paramVarArgs)
            throws a {
        if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
            throw new a("platform data is null");
        }
        String str = a(paramContext);
        if (TextUtils.isEmpty(str)) {
            throw new a("can`t get appkey.");
        }
        ArrayList localArrayList = new ArrayList();
        str = "http://log.umsns.com/share/api/" + str + "/";
        if ((a == null) || (a.isEmpty())) {
            a = c(paramContext);
        }
        if ((a != null) && (!a.isEmpty())) {
            paramContext = a.entrySet().iterator();
            while (paramContext.hasNext()) {
                Map.Entry localEntry = (Map.Entry) paramContext.next();
                localArrayList.add(new BasicNameValuePair((String) localEntry.getKey(), (String) localEntry.getValue()));
            }
        }
        localArrayList.add(new BasicNameValuePair("date", String.valueOf(System.currentTimeMillis())));
        localArrayList.add(new BasicNameValuePair("channel", e.e));
        if (!TextUtils.isEmpty(paramString)) {
            localArrayList.add(new BasicNameValuePair("topic", paramString));
        }
        localArrayList.addAll(a(paramVarArgs));
        paramString = b(paramVarArgs);
        paramContext = paramString;
        if (paramString == null) {
            paramContext = "null";
        }
        paramString = str + "?" + a(localArrayList);
        b.c("MobclickAgent", "URL:" + paramString);
        b.c("MobclickAgent", "BODY:" + paramContext);
        return new String[]{paramString, paramContext};
    }

    private static String b(UMPlatformData... paramVarArgs) {
        JSONObject localJSONObject1 = new JSONObject();
        int j = paramVarArgs.length;
        int i = 0;
        for (; ; ) {
            if (i < j) {
                UMPlatformData localUMPlatformData = paramVarArgs[i];
                Object localObject = localUMPlatformData.getGender();
                String str = localUMPlatformData.getName();
                if (localObject == null) {
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        break label163;
                    }
                    JSONObject localJSONObject2 = new JSONObject();
                    if (localObject == null) {
                        localObject = "";
                        localJSONObject2.put("gender", localObject);
                        if (str != null) {
                            break label125;
                        }
                    }
                    label125:
                    for (localObject = ""; ; localObject = String.valueOf(str)) {
                        localJSONObject2.put("name", localObject);
                        localJSONObject1.put(localUMPlatformData.getMeida().toString(), localJSONObject2);
                        break label163;
                        localObject = String.valueOf(((UMPlatformData.GENDER) localObject).value);
                        break;
                    }
                    if (localJSONObject1.length() != 0) {
                        break label157;
                    }
                } catch (Exception paramVarArgs) {
                    throw new a("build body exception", paramVarArgs);
                }
            }
            return null;
            label157:
            return localJSONObject1.toString();
            label163:
            i += 1;
        }
    }

    public static Map<String, String> b(Context paramContext) {
        HashMap localHashMap = new HashMap();
        Object localObject1 = (TelephonyManager) paramContext.getSystemService("phone");
        if (localObject1 == null) {
            b.e("MobclickAgent", "No IMEI.");
        }
        try {
            if (a(paramContext, "android.permission.READ_PHONE_STATE")) {
                localObject1 = ((TelephonyManager) localObject1).getDeviceId();
                String str = d(paramContext);
                paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
                if (!TextUtils.isEmpty(str)) {
                    localHashMap.put("mac", str);
                }
                if (!TextUtils.isEmpty((CharSequence) localObject1)) {
                    localHashMap.put("imei", localObject1);
                }
                if (!TextUtils.isEmpty(paramContext)) {
                    localHashMap.put("android_id", paramContext);
                }
                return localHashMap;
            }
        } catch (Exception localException) {
            for (; ; ) {
                b.e("MobclickAgent", "No IMEI.", localException);
                Object localObject2 = null;
            }
        }
    }

    private static Map<String, String> c(Context paramContext)
            throws a {
        HashMap localHashMap = new HashMap();
        Object localObject = b(paramContext);
        if ((localObject != null) && (!((Map) localObject).isEmpty())) {
            paramContext = new StringBuilder();
            StringBuilder localStringBuilder = new StringBuilder();
            localObject = ((Map) localObject).entrySet().iterator();
            while (((Iterator) localObject).hasNext()) {
                Map.Entry localEntry = (Map.Entry) ((Iterator) localObject).next();
                if (!TextUtils.isEmpty((CharSequence) localEntry.getValue())) {
                    localStringBuilder.append((String) localEntry.getKey()).append(",");
                    paramContext.append((String) localEntry.getValue()).append(",");
                }
            }
            if (paramContext.length() > 0) {
                paramContext.deleteCharAt(paramContext.length() - 1);
                localHashMap.put("deviceid", paramContext.toString());
            }
            if (localStringBuilder.length() > 0) {
                localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
                localHashMap.put("idtype", localStringBuilder.toString());
            }
            return localHashMap;
        }
        throw new a("can`t get device id.");
    }

    private static String d(Context paramContext) {
        try {
            WifiManager localWifiManager = (WifiManager) paramContext.getSystemService("wifi");
            if (a(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
                return localWifiManager.getConnectionInfo().getMacAddress();
            }
            b.e("MobclickAgent", "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
        } catch (Exception paramContext) {
            for (; ; ) {
                b.e("MobclickAgent", "Could not get mac address." + paramContext.toString());
            }
        }
        return "";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/social/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */