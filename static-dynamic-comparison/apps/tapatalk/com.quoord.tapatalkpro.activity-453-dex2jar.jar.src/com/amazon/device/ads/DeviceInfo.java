package com.amazon.device.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;

class DeviceInfo {
    private static final String LOG_TAG = "DeviceInfo";
    public static final String ORIENTATION_LANDSCAPE = "landscape";
    public static final String ORIENTATION_PORTRAIT = "portrait";
    public static final String ORIENTATION_UNKNOWN = "unknown";
    public static final String WIFI_NAME = "Wifi";
    private static final String dt = "android";
    private static final String make = Build.MANUFACTURER;
    private static final String model = Build.MODEL;
    private static final String os = "Android";
    private static final String osVersion = Build.VERSION.RELEASE;
    private static String userAgent;
    private boolean bad_mac;
    private boolean bad_serial;
    private boolean bad_udid;
    private String carrier;
    private String country;
    private Size landscapeScreenSize;
    private String language;
    private boolean macFetched;
    private String md5_mac;
    private String md5_serial;
    private String md5_udid;
    private Size portraitScreenSize;
    private float scalingFactor;
    private String scalingFactorAsString;
    private boolean serialFetched;
    private String sha1_mac;
    private String sha1_serial;
    private String sha1_udid;
    private String udid;
    private boolean udidFetched;

    protected DeviceInfo() {
    }

    public DeviceInfo(Context paramContext) {
        setCountry();
        setCarrier(paramContext);
        setLanguage();
        setScalingFactor(paramContext);
    }

    public static String getDeviceType() {
        return "android";
    }

    public static String getMake() {
        return make;
    }

    public static String getModel() {
        return model;
    }

    public static String getOS() {
        return "Android";
    }

    public static String getOSVersion() {
        return osVersion;
    }

    public static String getUserAgentString() {
        return userAgent;
    }

    private void setCarrier(Context paramContext) {
        paramContext = (TelephonyManager) paramContext.getSystemService("phone");
        if (paramContext != null) {
            paramContext = paramContext.getNetworkOperatorName();
            if ((paramContext == null) || (paramContext.length() <= 0)) {
                break label36;
            }
        }
        for (; ; ) {
            this.carrier = paramContext;
            return;
            label36:
            paramContext = null;
        }
    }

    private void setCountry() {
        String str = Locale.getDefault().getCountry();
        if ((str != null) && (str.length() > 0)) {
        }
        for (; ; ) {
            this.country = str;
            return;
            str = null;
        }
    }

    private void setLanguage() {
        String str = Locale.getDefault().getLanguage();
        if ((str != null) && (str.length() > 0)) {
        }
        for (; ; ) {
            this.language = str;
            return;
            str = null;
        }
    }

    private void setMacAddressIfNotFetched() {
        if (!this.macFetched) {
            setMacAddress();
        }
    }

    private void setScalingFactor(Context paramContext) {
        if ((make.equals("motorola")) && (model.equals("MB502"))) {
        }
        DisplayMetrics localDisplayMetrics;
        for (this.scalingFactor = 1.0F; ; this.scalingFactor = localDisplayMetrics.scaledDensity) {
            this.scalingFactorAsString = Float.toString(this.scalingFactor);
            return;
            paramContext = (WindowManager) paramContext.getSystemService("window");
            localDisplayMetrics = new DisplayMetrics();
            paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
        }
    }

    private void setSerial() {
        Object localObject = null;
        try {
            String str = (String) Build.class.getDeclaredField("SERIAL").get(Build.class);
            localObject = str;
        } catch (Exception localException) {
            for (; ; ) {
            }
        }
        if ((localObject == null) || (((String) localObject).length() == 0) || (((String) localObject).equalsIgnoreCase("unknown"))) {
            this.bad_serial = true;
        }
        for (; ; ) {
            this.serialFetched = true;
            return;
            this.sha1_serial = Utils.getURLEncodedString(Utils.sha1((String) localObject));
        }
    }

    private void setSerialIfNotFetched() {
        if (!this.serialFetched) {
            setSerial();
        }
    }

    private void setUdid() {
        String str = Settings.Secure.getString(InternalAdRegistration.getInstance().getApplicationContext().getContentResolver(), "android_id");
        if ((Utils.isNullOrEmpty(str)) || (str.equalsIgnoreCase("9774d56d682e549c"))) {
            this.udid = null;
            this.sha1_udid = null;
            this.bad_udid = true;
        }
        for (; ; ) {
            this.udidFetched = true;
            return;
            this.udid = Utils.getURLEncodedString(str);
            this.sha1_udid = Utils.getURLEncodedString(Utils.sha1(str));
        }
    }

    private void setUdidIfNotFetched() {
        if (!this.udidFetched) {
            setUdid();
        }
    }

    public static void setUserAgentString(String paramString) {
        if ((paramString != null) && (!paramString.equals(userAgent))) {
            userAgent = paramString;
        }
    }

    public String getCarrier() {
        return this.carrier;
    }

    public String getConnectionType() {
        ConnectivityManager localConnectivityManager = (ConnectivityManager) InternalAdRegistration.getInstance().getApplicationContext().getSystemService("connectivity");
        Object localObject3 = null;
        Object localObject1 = localObject3;
        if (localConnectivityManager != null) {
        }
        try {
            localObject1 = localConnectivityManager.getActiveNetworkInfo();
            if (localObject1 != null) {
                if (((NetworkInfo) localObject1).getType() == 1) {
                    return "Wifi";
                }
            }
        } catch (SecurityException localSecurityException) {
            Object localObject2;
            for (; ; ) {
                Log.d("DeviceInfo", "Unable to get active network information: %s", new Object[]{localSecurityException});
                localObject2 = localObject3;
            }
            return Integer.toString(((NetworkInfo) localObject2).getSubtype());
        }
        return Integer.toString(0);
    }

    public String getCountry() {
        return this.country;
    }

    public JSONObject getDInfoProperty() {
        JSONObject localJSONObject = new JSONObject();
        JSONUtils.put(localJSONObject, "make", getMake());
        JSONUtils.put(localJSONObject, "model", getModel());
        JSONUtils.put(localJSONObject, "os", getOS());
        JSONUtils.put(localJSONObject, "osVersion", getOSVersion());
        JSONUtils.put(localJSONObject, "scalingFactor", getScalingFactorAsString());
        JSONUtils.put(localJSONObject, "language", getLanguage());
        JSONUtils.put(localJSONObject, "country", getCountry());
        JSONUtils.put(localJSONObject, "carrier", getCarrier());
        return localJSONObject;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getMacMd5() {
        setMacAddressIfNotFetched();
        return this.md5_mac;
    }

    public String getMacSha1() {
        setMacAddressIfNotFetched();
        return this.sha1_mac;
    }

    public String getOrientation() {
        switch () {
            default:
                return "unknown";
            case 1:
            case 9:
                return "portrait";
        }
        return "landscape";
    }

    public float getScalingFactorAsFloat() {
        return this.scalingFactor;
    }

    public String getScalingFactorAsString() {
        return this.scalingFactorAsString;
    }

    public Size getScreenSize(String paramString) {
        if ((paramString.equals("portrait")) && (this.portraitScreenSize != null)) {
            return this.portraitScreenSize;
        }
        if ((paramString.equals("landscape")) && (this.landscapeScreenSize != null)) {
            return this.landscapeScreenSize;
        }
        Object localObject = (WindowManager) InternalAdRegistration.getInstance().getApplicationContext().getSystemService("window");
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager) localObject).getDefaultDisplay().getMetrics(localDisplayMetrics);
        localObject = String.valueOf(localDisplayMetrics.widthPixels) + "x" + String.valueOf(localDisplayMetrics.heightPixels);
        if (paramString.equals("portrait")) {
            this.portraitScreenSize = new Size((String) localObject);
            return this.portraitScreenSize;
        }
        if (paramString.equals("landscape")) {
            this.landscapeScreenSize = new Size((String) localObject);
            return this.landscapeScreenSize;
        }
        return new Size((String) localObject);
    }

    public String getSerialMd5() {
        setSerialIfNotFetched();
        return this.md5_serial;
    }

    public String getSerialSha1() {
        setSerialIfNotFetched();
        return this.sha1_serial;
    }

    public String getUdid() {
        setUdidIfNotFetched();
        return this.udid;
    }

    public String getUdidMd5() {
        setUdidIfNotFetched();
        return this.md5_udid;
    }

    public String getUdidSha1() {
        setUdidIfNotFetched();
        return this.sha1_udid;
    }

    public boolean isMacBad() {
        setMacAddressIfNotFetched();
        return this.bad_mac;
    }

    public boolean isSerialBad() {
        setSerialIfNotFetched();
        return this.bad_serial;
    }

    public boolean isUdidBad() {
        setUdidIfNotFetched();
        return this.bad_udid;
    }

    protected void setMacAddress() {
        WifiManager localWifiManager = (WifiManager) InternalAdRegistration.getInstance().getApplicationContext().getSystemService("wifi");
        Object localObject4 = null;
        Object localObject1 = localObject4;
        if (localWifiManager != null) {
        }
        try {
            localObject1 = localWifiManager.getConnectionInfo();
            if (localObject1 == null) {
                this.sha1_mac = null;
                this.macFetched = true;
                return;
            }
        } catch (SecurityException localSecurityException) {
            for (; ; ) {
                Log.d("DeviceInfo", "Unable to get Wifi connection information: %s", new Object[]{localSecurityException});
                Object localObject2 = localObject4;
            }
        } catch (ExceptionInInitializerError localExceptionInInitializerError) {
            for (; ; ) {
                Log.d("DeviceInfo", "Unable to get Wifi connection information: %s", new Object[]{localExceptionInInitializerError});
                Object localObject3 = localObject4;
                continue;
                localObject3 = ((WifiInfo) localObject3).getMacAddress();
                if ((localObject3 == null) || (((String) localObject3).length() == 0)) {
                    this.sha1_mac = null;
                    this.bad_mac = true;
                } else if (!Pattern.compile("((([0-9a-fA-F]){1,2}[-:]){5}([0-9a-fA-F]){1,2})").matcher((CharSequence) localObject3).find()) {
                    this.sha1_mac = null;
                    this.bad_mac = true;
                } else {
                    this.sha1_mac = Utils.getURLEncodedString(Utils.sha1((String) localObject3));
                }
            }
        }
    }

    JSONObject toJsonObject(String paramString) {
        JSONObject localJSONObject = getDInfoProperty();
        JSONUtils.put(localJSONObject, "orientation", paramString);
        JSONUtils.put(localJSONObject, "screenSize", getScreenSize(paramString).toString());
        JSONUtils.put(localJSONObject, "connectionType", getConnectionType());
        return localJSONObject;
    }

    public String toJsonString() {
        return toJsonObject(getOrientation()).toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/DeviceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */