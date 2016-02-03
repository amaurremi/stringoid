package mobi.ifunny;

import android.content.Context;
import android.graphics.Point;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.util.UUID;

import mobi.ifunny.util.z;

public class g {
    private static final String a = g.class.getSimpleName();
    private static String b;
    private static String c;
    private static String d;
    private static String e;

    public static String a() {
        String str1;
        String str2;
        if (e == null) {
            str1 = h.a("1");
            e = h.a().a(str1, null);
            if (e == null) {
                d.c(a, "Create installation ID");
                long l = System.currentTimeMillis() / 1000L;
                str2 = "android_1_" + l + "_" + b;
                d.c(a, " input " + str2);
            }
        }
        try {
            e = z.a(str2);
            d.c(a, " output " + e);
            h.a().b(str1, e);
            return e;
        } catch (Exception localException) {
            for (; ; ) {
                d.c(a, "Creating installation ID failed", localException);
            }
        }
    }

    public static void a(Context paramContext) {
        Object localObject1 = "" + Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
        d.b(a, "androidId " + (String) localObject1);
        Object localObject2 = (WifiManager) paramContext.getSystemService("wifi");
        localObject2 = "" + ((WifiManager) localObject2).getConnectionInfo().getMacAddress();
        d.b(a, "macAddr " + (String) localObject2);
        b = new UUID(((String) localObject1).hashCode(), ((String) localObject2).hashCode()).toString();
        d.c(a, "deviceId " + b);
        paramContext = ((WindowManager) paramContext.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 13) {
            localObject1 = new Point();
            paramContext.getSize((Point) localObject1);
            c = ((Point) localObject1).x + "x" + ((Point) localObject1).y;
            d.c(a, "displaySize = " + c);
            localObject1 = new DisplayMetrics();
            paramContext.getMetrics((DisplayMetrics) localObject1);
            switch (((DisplayMetrics) localObject1).densityDpi) {
                default:
                    d = "unknown";
            }
        }
        for (; ; ) {
            d.c(a, "density = " + d);
            return;
            int i = paramContext.getWidth();
            int j = paramContext.getHeight();
            c = i + "x" + j;
            break;
            d = "ldpi";
            continue;
            d = "mdpi";
            continue;
            d = "hdpi";
            continue;
            d = "xhdpi";
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */