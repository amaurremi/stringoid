package a.a.a.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

import org.OpenUDID.a;
import org.json.JSONException;
import org.json.JSONObject;

class d {
    public static String a() {
        if (!a.b()) {
            return "REPLACE_UDID";
        }
        return a.a();
    }

    public static String a(Context paramContext) {
        paramContext = ((WindowManager) paramContext.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        paramContext.getMetrics(localDisplayMetrics);
        return localDisplayMetrics.widthPixels + "x" + localDisplayMetrics.heightPixels;
    }

    public static String b() {
        return "Android";
    }

    public static String b(Context paramContext) {
        try {
            paramContext = ((TelephonyManager) paramContext.getSystemService("phone")).getNetworkOperatorName();
            return paramContext;
        } catch (NullPointerException paramContext) {
            paramContext.printStackTrace();
            Log.e("Countly", "No carrier found");
        }
        return "";
    }

    public static String c() {
        return Build.VERSION.RELEASE;
    }

    public static String c(Context paramContext) {
        try {
            paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
            return paramContext;
        } catch (PackageManager.NameNotFoundException paramContext) {
        }
        return "1.0";
    }

    public static String d() {
        return Build.MODEL;
    }

    public static String d(Context paramContext) {
        Object localObject = new JSONObject();
        try {
            ((JSONObject) localObject).put("_device", d());
            ((JSONObject) localObject).put("_os", b());
            ((JSONObject) localObject).put("_os_version", c());
            ((JSONObject) localObject).put("_carrier", b(paramContext));
            ((JSONObject) localObject).put("_resolution", a(paramContext));
            ((JSONObject) localObject).put("_locale", e());
            ((JSONObject) localObject).put("_app_version", c(paramContext));
            paramContext = ((JSONObject) localObject).toString();
        } catch (JSONException paramContext) {
            for (; ; ) {
                try {
                    localObject = URLEncoder.encode(paramContext, "UTF-8");
                    return (String) localObject;
                } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
                }
                paramContext = paramContext;
                paramContext.printStackTrace();
            }
        }
        return paramContext;
    }

    public static String e() {
        Locale localLocale = Locale.getDefault();
        return localLocale.getLanguage() + "_" + localLocale.getCountry();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/a/a/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */