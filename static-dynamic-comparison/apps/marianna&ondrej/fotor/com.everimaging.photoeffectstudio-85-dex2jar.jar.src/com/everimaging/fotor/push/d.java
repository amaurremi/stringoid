package com.everimaging.fotor.push;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import com.everimaging.fotor.SplashActivity;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.OpenUDID.a;

public class d {
    public static String a = "http://store.fotor.com/PushSurpport/";
    public static final String b = a + "pushFlow";
    public static final String c = a + "register";
    public static String d = "163249411645";
    private static final String e = d.class.getSimpleName();
    private static final LoggerFactory.c f = LoggerFactory.a(e, LoggerFactory.LoggerType.CONSOLE);

    public static Map<String, String> a(Context paramContext, String paramString) {
        HashMap localHashMap = new HashMap();
        localHashMap.put("udid", a.a());
        localHashMap.put("pushToken", paramString);
        localHashMap.put("platform", "1");
        localHashMap.put("country", Locale.getDefault().getCountry());
        localHashMap.put("language", Locale.getDefault().getLanguage());
        localHashMap.put("deviceName", Build.MODEL);
        localHashMap.put("osVersion", Build.VERSION.RELEASE);
        try {
            localHashMap.put("appVersion", paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName);
            return localHashMap;
        } catch (PackageManager.NameNotFoundException paramContext) {
            paramContext.printStackTrace();
        }
        return localHashMap;
    }

    public static void a(Context paramContext, String paramString, int paramInt) {
        long l = System.currentTimeMillis();
        f.c(new Object[]{"push message:" + paramString});
        paramString = (a) new GsonBuilder().create().fromJson(paramString, a.class);
        NotificationManager localNotificationManager = (NotificationManager) paramContext.getSystemService("notification");
        Notification localNotification = new Notification(paramInt, paramString.a(), l);
        String str = paramContext.getString(2131296346);
        Object localObject = new Intent(paramContext, SplashActivity.class);
        ((Intent) localObject).setFlags(603979776);
        localObject = PendingIntent.getActivity(paramContext, 0, (Intent) localObject, 0);
        localNotification.setLatestEventInfo(paramContext, str, paramString.a(), (PendingIntent) localObject);
        localNotification.flags |= 0x10;
        localNotificationManager.notify(0, localNotification);
    }

    class a {
        private String a;

        public String a() {
            return this.a;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/push/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */