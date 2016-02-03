package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class BridgeMMDevice
        extends MMJSObject {
    static JSONObject a(Context paramContext) {
        try {
            JSONObject localJSONObject = new JSONObject();
            JSONArray localJSONArray;
            MMLog.a("BridgeMMDevice", "Bridge getting deviceInfo json exception: ", localJSONException1);
        } catch (JSONException localJSONException1) {
            try {
                localJSONObject.put("sdkVersion", "5.3.0-c3980670.a");
                localJSONObject.put("connection", MMSDK.c(paramContext));
                localJSONObject.put("platform", "Android");
                if (Build.VERSION.RELEASE != null) {
                    localJSONObject.put("version", Build.VERSION.RELEASE);
                }
                if (Build.MODEL != null) {
                    localJSONObject.put("device", Build.MODEL);
                }
                localJSONObject.put("mmdid", MMSDK.d(paramContext));
                paramContext = paramContext.getResources().getDisplayMetrics();
                localJSONObject.put("density", new Float(paramContext.density));
                localJSONObject.put("height", new Integer(paramContext.heightPixels));
                localJSONObject.put("width", new Integer(paramContext.widthPixels));
                paramContext = Locale.getDefault();
                if (paramContext != null) {
                    localJSONObject.put("language", paramContext.getLanguage());
                    localJSONObject.put("country", paramContext.getCountry());
                }
                paramContext = new JSONObject();
                paramContext.put("name", "MAC-ID");
                paramContext.put("path", "/");
                paramContext.put("value", MMSDK.e);
                localJSONArray = new JSONArray();
                localJSONArray.put(paramContext);
                localJSONObject.put("cookies", localJSONArray);
                return localJSONObject;
            } catch (JSONException localJSONException2) {
                for (; ; ) {
                    paramContext = localJSONException1;
                    Object localObject = localJSONException2;
                }
            }
            localJSONException1 = localJSONException1;
            paramContext = null;
        }
        return paramContext;
    }

    MMJSResponse a(String paramString, Map<String, String> paramMap) {
        MMJSResponse localMMJSResponse = null;
        if ("call".equals(paramString)) {
            localMMJSResponse = call(paramMap);
        }
        do {
            return localMMJSResponse;
            if ("composeEmail".equals(paramString)) {
                return composeEmail(paramMap);
            }
            if ("composeSms".equals(paramString)) {
                return composeSms(paramMap);
            }
            if ("enableHardwareAcceleration".equals(paramString)) {
                return enableHardwareAcceleration(paramMap);
            }
            if ("getAvailableSchemes".equals(paramString)) {
                return getAvailableSchemes(paramMap);
            }
            if ("getInfo".equals(paramString)) {
                return getInfo(paramMap);
            }
            if ("getLocation".equals(paramString)) {
                return getLocation(paramMap);
            }
            if ("getOrientation".equals(paramString)) {
                return getOrientation(paramMap);
            }
            if ("isSchemeAvailable".equals(paramString)) {
                return isSchemeAvailable(paramMap);
            }
            if ("openAppStore".equals(paramString)) {
                return openAppStore(paramMap);
            }
            if ("openUrl".equals(paramString)) {
                return openUrl(paramMap);
            }
            if ("setMMDID".equals(paramString)) {
                return setMMDID(paramMap);
            }
            if ("showMap".equals(paramString)) {
                return showMap(paramMap);
            }
        } while (!"tweet".equals(paramString));
        return tweet(paramMap);
    }

    public MMJSResponse call(Map<String, String> paramMap) {
        Context localContext = (Context) this.b.get();
        Object localObject = (String) paramMap.get("number");
        if ((localContext != null) && (localObject != null)) {
            MMLog.b("BridgeMMDevice", String.format("Dialing Phone: %s", new Object[]{localObject}));
            if ((Boolean.parseBoolean((String) paramMap.get("dial"))) && (localContext.checkCallingOrSelfPermission("android.permission.CALL_PHONE") == 0)) {
            }
            for (localObject = new Intent("android.intent.action.CALL", Uri.parse("tel:" + (String) localObject)); ; localObject = new Intent("android.intent.action.VIEW", Uri.parse("tel:" + (String) localObject))) {
                Utils.IntentUtils.c(localContext, (Intent) localObject);
                MMSDK.Event.a(localContext, "tel", b((String) paramMap.get("PROPERTY_EXPANDING")));
                return MMJSResponse.a();
            }
        }
        return null;
    }

    public MMJSResponse composeEmail(Map<String, String> paramMap) {
        Context localContext = (Context) this.b.get();
        String str1 = (String) paramMap.get("recipient");
        String str2 = (String) paramMap.get("subject");
        String str3 = (String) paramMap.get("message");
        if (localContext != null) {
            MMLog.b("BridgeMMDevice", "Creating email");
            Intent localIntent = new Intent("android.intent.action.SEND");
            localIntent.setType("plain/text");
            if (str1 != null) {
                localIntent.putExtra("android.intent.extra.EMAIL", str1.split(","));
            }
            if (str2 != null) {
                localIntent.putExtra("android.intent.extra.SUBJECT", str2);
            }
            if (str3 != null) {
                localIntent.putExtra("android.intent.extra.TEXT", str3);
            }
            Utils.IntentUtils.c(localContext, localIntent);
            MMSDK.Event.a(localContext, "email", b((String) paramMap.get("PROPERTY_EXPANDING")));
            return MMJSResponse.a();
        }
        return null;
    }

    public MMJSResponse composeSms(Map<String, String> paramMap) {
        Context localContext = (Context) this.b.get();
        Object localObject = (String) paramMap.get("number");
        String str = (String) paramMap.get("message");
        if ((localContext != null) && (localObject != null)) {
            MMLog.b("BridgeMMDevice", String.format("Creating sms: %s", new Object[]{localObject}));
            localObject = new Intent("android.intent.action.VIEW", Uri.parse("sms:" + (String) localObject));
            if (str != null) {
                ((Intent) localObject).putExtra("sms_body", str);
            }
            Utils.IntentUtils.c(localContext, (Intent) localObject);
            MMSDK.Event.a(localContext, "sms", b((String) paramMap.get("PROPERTY_EXPANDING")));
            return MMJSResponse.a("SMS Sent");
        }
        return null;
    }

    public MMJSResponse enableHardwareAcceleration(Map<String, String> paramMap) {
        MMLog.b("BridgeMMDevice", "hardware accel call" + paramMap);
        paramMap = (String) paramMap.get("enabled");
        MMWebView localMMWebView = (MMWebView) this.c.get();
        if ((localMMWebView != null) && (localMMWebView != null)) {
            if (Boolean.parseBoolean(paramMap)) {
                localMMWebView.c();
            }
            for (; ; ) {
                return MMJSResponse.a();
                localMMWebView.a();
            }
        }
        return null;
    }

    public MMJSResponse getAvailableSchemes(Map<String, String> paramMap) {
        paramMap = (Context) this.b.get();
        if (paramMap != null) {
            HandShake localHandShake = HandShake.a(paramMap);
            MMJSResponse localMMJSResponse = new MMJSResponse();
            localMMJSResponse.c = 1;
            localMMJSResponse.d = localHandShake.c(paramMap);
            return localMMJSResponse;
        }
        return null;
    }

    public MMJSResponse getInfo(Map<String, String> paramMap) {
        paramMap = (Context) this.b.get();
        if (paramMap != null) {
            MMJSResponse localMMJSResponse = new MMJSResponse();
            localMMJSResponse.c = 1;
            localMMJSResponse.d = a(paramMap);
            return localMMJSResponse;
        }
        return null;
    }

    public MMJSResponse getLocation(Map<String, String> paramMap) {
        if (MMRequest.l != null) {
            for (; ; ) {
                try {
                    paramMap = new JSONObject();
                    MMJSResponse localMMJSResponse;
                    MMLog.a("BridgeMMDevice", "Bridge getLocation json exception: ", localJSONException1);
                } catch (JSONException localJSONException1) {
                    try {
                        paramMap.put("lat", Double.toString(MMRequest.l.getLatitude()));
                        paramMap.put("long", Double.toString(MMRequest.l.getLongitude()));
                        if (MMRequest.l.hasAccuracy()) {
                            paramMap.put("ha", Float.toString(MMRequest.l.getAccuracy()));
                            paramMap.put("va", Float.toString(MMRequest.l.getAccuracy()));
                        }
                        if (MMRequest.l.hasSpeed()) {
                            paramMap.put("spd", Float.toString(MMRequest.l.getSpeed()));
                        }
                        if (MMRequest.l.hasBearing()) {
                            paramMap.put("brg", Float.toString(MMRequest.l.getBearing()));
                        }
                        if (MMRequest.l.hasAltitude()) {
                            paramMap.put("alt", Double.toString(MMRequest.l.getAltitude()));
                        }
                        paramMap.put("tslr", Long.toString(MMRequest.l.getTime()));
                        localMMJSResponse = new MMJSResponse();
                        localMMJSResponse.c = 1;
                        localMMJSResponse.d = paramMap;
                        return localMMJSResponse;
                    } catch (JSONException localJSONException2) {
                        for (; ; ) {
                        }
                    }
                    localJSONException1 = localJSONException1;
                    paramMap = null;
                }
            }
        }
        return MMJSResponse.b("location object has not been set");
    }

    public MMJSResponse getOrientation(Map<String, String> paramMap) {
        paramMap = (Context) this.b.get();
        int i;
        if (paramMap != null) {
            i = paramMap.getResources().getConfiguration().orientation;
            if (i != 0) {
                break label101;
            }
            i = ((WindowManager) paramMap.getSystemService("window")).getDefaultDisplay().getOrientation();
        }
        label101:
        for (; ; ) {
            paramMap = new MMJSResponse();
            paramMap.c = 1;
            switch (i) {
            }
            for (paramMap.d = "portrait"; ; paramMap.d = "landscape") {
                return paramMap;
            }
            return null;
        }
    }

    public MMJSResponse isSchemeAvailable(Map<String, String> paramMap) {
        paramMap = (String) paramMap.get("scheme");
        if (!paramMap.contains(":")) {
            paramMap = paramMap + ":";
        }
        for (; ; ) {
            Context localContext = (Context) this.b.get();
            if ((paramMap != null) && (localContext != null)) {
                Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramMap));
                if (localContext.getPackageManager().queryIntentActivities(localIntent, 65536).size() > 0) {
                    return MMJSResponse.a(paramMap);
                }
            }
            return MMJSResponse.b(paramMap);
        }
    }

    public MMJSResponse openAppStore(Map<String, String> paramMap) {
        Context localContext = (Context) this.b.get();
        String str1 = (String) paramMap.get("appId");
        String str2 = (String) paramMap.get("referrer");
        if ((localContext != null) && (str1 != null)) {
            MMLog.b("BridgeMMDevice", String.format("Opening marketplace: %s", new Object[]{str1}));
            Intent localIntent = new Intent("android.intent.action.VIEW");
            if (Build.MANUFACTURER.equals("Amazon")) {
                localIntent.setData(Uri.parse(String.format("amzn://apps/android?p=%s", new Object[]{str1})));
            }
            for (; ; ) {
                MMSDK.Event.a(localContext, "market", b((String) paramMap.get("PROPERTY_EXPANDING")));
                Utils.IntentUtils.c(localContext, localIntent);
                return MMJSResponse.a();
                if (str2 != null) {
                    localIntent.setData(Uri.parse(String.format("market://details?id=%s&referrer=%s", new Object[]{str1, URLEncoder.encode(str2)})));
                } else {
                    localIntent.setData(Uri.parse("market://details?id=" + str1));
                }
            }
        }
        return null;
    }

    public MMJSResponse openUrl(Map<String, String> paramMap) {
        Context localContext = (Context) this.b.get();
        Object localObject = (String) paramMap.get("url");
        if ((localContext != null) && (localObject != null)) {
            MMLog.b("BridgeMMDevice", String.format("Opening: %s", new Object[]{localObject}));
            localObject = new Intent("android.intent.action.VIEW", Uri.parse((String) localObject));
            if ((((Intent) localObject).getScheme().startsWith("http")) || (((Intent) localObject).getScheme().startsWith("https"))) {
                MMSDK.Event.a(localContext, "browser", b((String) paramMap.get("PROPERTY_EXPANDING")));
            }
            Utils.IntentUtils.c(localContext, (Intent) localObject);
            return MMJSResponse.a("Overlay opened");
        }
        return MMJSResponse.b("URL could not be opened");
    }

    public MMJSResponse setMMDID(Map<String, String> paramMap) {
        paramMap = (String) paramMap.get("mmdid");
        Context localContext = (Context) this.b.get();
        if (localContext != null) {
            HandShake.a(localContext).c(localContext, paramMap);
            return MMJSResponse.a("MMDID is set");
        }
        return null;
    }

    public MMJSResponse showMap(Map<String, String> paramMap) {
        Context localContext = (Context) this.b.get();
        String str = (String) paramMap.get("location");
        if ((localContext != null) && (str != null)) {
            MMLog.b("BridgeMMDevice", String.format("Launching Google Maps: %s", new Object[]{str}));
            Utils.IntentUtils.c(localContext, new Intent("android.intent.action.VIEW", Uri.parse("geo:" + str)));
            MMSDK.Event.a(localContext, "geo", b((String) paramMap.get("PROPERTY_EXPANDING")));
            return MMJSResponse.a("Map successfully opened");
        }
        return null;
    }

    public MMJSResponse tweet(Map<String, String> paramMap) {
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/BridgeMMDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */