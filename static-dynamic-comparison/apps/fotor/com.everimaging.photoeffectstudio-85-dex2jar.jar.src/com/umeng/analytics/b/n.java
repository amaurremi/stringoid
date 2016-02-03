package com.umeng.analytics.b;

import android.content.Context;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.d.x;
import com.umeng.common.Log;
import com.umeng.common.b;
import com.umeng.common.util.h;

import java.util.Arrays;
import java.util.List;

public class n {
    private static final String a = "session_start_time";
    private static final String b = "session_end_time";
    private static final String c = "session_id";
    private static final String f = "activities";
    private final String d = "a_start_time";
    private final String e = "a_end_time";

    private String a(Context paramContext, m paramm) {
        a locala = a.a(paramContext);
        String str = b(paramContext);
        locala.a(str);
        paramContext = a(paramContext);
        if (paramContext != null) {
            locala.a(paramContext);
        }
        for (; ; ) {
            paramContext = paramm.a();
            paramContext.a("session_id", str);
            paramContext.a("session_start_time", System.currentTimeMillis());
            paramContext.a("session_end_time", 0L);
            paramContext.b();
            return str;
            locala.a((x) null);
        }
    }

    private void a(m paramm) {
        paramm = paramm.a();
        paramm.a("session_start_time");
        paramm.a("session_end_time");
        paramm.a("session_id");
        paramm.a("a_start_time");
        paramm.a("a_end_time");
        paramm.a("activities", "");
        paramm.b();
    }

    private boolean b(m paramm) {
        long l1 = paramm.a("a_start_time", 0L);
        long l2 = paramm.a("a_end_time", 0L);
        long l3 = System.currentTimeMillis();
        if ((l1 != 0L) && (l3 - l1 < AnalyticsConfig.kContinueSessionMillis)) {
            Log.b("MobclickAgent", "onResume called before onPause");
        }
        while (l3 - l2 <= AnalyticsConfig.kContinueSessionMillis) {
            return false;
        }
        return true;
    }

    public x a(Context paramContext) {
        m localm = m.a(paramContext);
        Object localObject = localm.a("session_id", null);
        if (localObject == null) {
            return null;
        }
        long l3 = localm.a("session_start_time", 0L);
        long l4 = localm.a("session_end_time", 0L);
        long l1 = 0L;
        if (l4 != 0L) {
            long l2 = l4 - l3;
            l1 = l2;
            if (Math.abs(l2) > 86400000L) {
                l1 = 0L;
            }
        }
        x localx = new x();
        localx.a((String) localObject);
        localx.a(l3);
        localx.b(l4);
        localx.c(l1);
        localObject = AnalyticsConfig.getLocation();
        if (localObject != null) {
            localObject = new com.umeng.analytics.d.q(localObject[0], localObject[1], System.currentTimeMillis());
            if (!localx.y()) {
                break label212;
            }
            localx.a((com.umeng.analytics.d.q) localObject);
        }
        for (; ; ) {
            paramContext = q.a(paramContext);
            if (paramContext != null) {
                localx.a(paramContext);
            }
            paramContext = r.a(localm);
            if ((paramContext != null) && (paramContext.size() > 0)) {
                localx.a(paramContext);
            }
            a(localm);
            return localx;
            label212:
            localx.b(Arrays.asList(new com.umeng.analytics.d.q[]{localObject}));
        }
    }

    public String b(Context paramContext) {
        String str = b.f(paramContext);
        paramContext = AnalyticsConfig.getAppkey(paramContext);
        long l = System.currentTimeMillis();
        if (paramContext == null) {
            throw new RuntimeException("Appkey is null or empty, Please check AndroidManifest.xml");
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(l).append(paramContext).append(str);
        return h.a(localStringBuilder.toString());
    }

    public void c(Context paramContext) {
        m localm = m.a(paramContext);
        if (localm == null) {
            return;
        }
        if (b(localm)) {
            paramContext = a(paramContext, localm);
            Log.a("MobclickAgent", "Start new session: " + paramContext);
        }
        for (; ; ) {
            paramContext = localm.a();
            paramContext.a("a_start_time", System.currentTimeMillis());
            paramContext.a("a_end_time", 0L);
            paramContext.b();
            return;
            String str = localm.a("session_id", null);
            a.a(paramContext).a(str);
            Log.a("MobclickAgent", "Extend current session: " + str);
        }
    }

    public void d(Context paramContext) {
        paramContext = m.a(paramContext);
        if (paramContext == null) {
            return;
        }
        if ((paramContext.a("a_start_time", 0L) == 0L) && (AnalyticsConfig.ACTIVITY_DURATION_OPEN)) {
            Log.b("MobclickAgent", "onPause called before onResume");
            return;
        }
        long l = System.currentTimeMillis();
        paramContext = paramContext.a();
        paramContext.a("a_start_time", 0L);
        paramContext.a("a_end_time", l);
        paramContext.a("session_end_time", l);
        paramContext.b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */