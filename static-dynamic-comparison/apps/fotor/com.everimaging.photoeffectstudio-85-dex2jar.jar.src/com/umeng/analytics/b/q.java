package com.umeng.analytics.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.umeng.analytics.d.y;
import com.umeng.common.Log;

import java.lang.reflect.Method;

public class q {
    private static final String a = "uptr";
    private static final String b = "dntr";

    public static y a(Context paramContext) {
        long[] arrayOfLong;
        label136:
        label138:
        label140:
        do {
            long l1;
            long l2;
            try {
                localy = new y();
                arrayOfLong = b(paramContext);
                if ((arrayOfLong[0] <= 0L) || (arrayOfLong[1] <= 0L)) {
                    break label136;
                }
                paramContext = m.a(paramContext);
                l1 = paramContext.a("uptr", -1L);
                l2 = paramContext.a("dntr", -1L);
                paramContext.a().a("uptr", arrayOfLong[1]).a("dntr", arrayOfLong[0]).b();
                if (l1 <= 0L) {
                    break label138;
                }
                if (l2 > 0L) {
                    break label140;
                }
            } catch (Exception paramContext) {
                y localy;
                Log.e("MobclickAgent", "sdk less than 2.2 has get no traffic");
                return null;
            }
            localy.c((int) arrayOfLong[0]);
            localy.a((int) arrayOfLong[1]);
            return localy;
            return null;
            return null;
            arrayOfLong[0] -= l2;
            arrayOfLong[1] -= l1;
        } while ((arrayOfLong[0] > 0L) && (arrayOfLong[1] > 0L));
        return null;
    }

    public static long[] b(Context paramContext)
            throws Exception {
        Object localObject = Class.forName("android.net.TrafficStats");
        Method localMethod = ((Class) localObject).getMethod("getUidRxBytes", new Class[]{Integer.TYPE});
        localObject = ((Class) localObject).getMethod("getUidTxBytes", new Class[]{Integer.TYPE});
        int i = paramContext.getApplicationInfo().uid;
        if (i == -1) {
            return null;
        }
        return new long[]{((Long) localMethod.invoke(null, new Object[]{Integer.valueOf(i)})).longValue(), ((Long) ((Method) localObject).invoke(null, new Object[]{Integer.valueOf(i)})).longValue()};
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/b/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */