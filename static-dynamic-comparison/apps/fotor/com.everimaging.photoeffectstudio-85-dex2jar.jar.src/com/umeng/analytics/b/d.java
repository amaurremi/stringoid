package com.umeng.analytics.b;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.common.Log;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class d {
    private final int a = 128;
    private final int b = 256;
    private b c;
    private Context d;

    public d(Context paramContext) {
        if (paramContext == null) {
            throw new RuntimeException("Context is null, can't track event");
        }
        this.d = paramContext.getApplicationContext();
        this.c = new b(paramContext);
        paramContext = this.c;
        if (!AnalyticsConfig.ENABLE_MEMORY_BUFFER) {
        }
        for (boolean bool = true; ; bool = false) {
            paramContext.a(bool);
            return;
        }
    }

    private boolean a(String paramString) {
        if (paramString != null) {
            int i = paramString.trim().getBytes().length;
            if ((i > 0) && (i <= 128)) {
                return true;
            }
        }
        Log.b("MobclickAgent", "Event id is empty or too long in tracking Event");
        return false;
    }

    private boolean a(Map<String, Object> paramMap) {
        if ((paramMap == null) || (paramMap.isEmpty())) {
            Log.b("MobclickAgent", "map is null or empty in onEvent");
            return false;
        }
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext()) {
            Map.Entry localEntry = (Map.Entry) paramMap.next();
            if (!a((String) localEntry.getKey())) {
                return false;
            }
            if (((localEntry.getValue() instanceof String)) && (!b(localEntry.getValue().toString()))) {
                return false;
            }
        }
        return true;
    }

    private boolean b(String paramString) {
        if (paramString == null) {
        }
        while (paramString.trim().getBytes().length <= 256) {
            return true;
        }
        Log.b("MobclickAgent", "Event label or value is empty or too long in tracking Event");
        return false;
    }

    public void a(String paramString1, String paramString2) {
        if ((!a(paramString1)) || (!b(paramString2))) {
            return;
        }
        this.c.a(com.umeng.analytics.c.b.b(paramString1, paramString2, null), com.umeng.analytics.c.b.a(paramString1, paramString2, null));
    }

    public void a(String paramString1, String paramString2, long paramLong, int paramInt) {
        if ((!a(paramString1)) || (!b(paramString2))) {
            return;
        }
        HashMap localHashMap = new HashMap();
        String str = paramString2;
        if (paramString2 == null) {
            str = "";
        }
        localHashMap.put(paramString1, str);
        a.a(this.d).a(new com.umeng.analytics.c.b(paramString1, localHashMap, paramLong, paramInt));
    }

    public void a(String paramString, Map<String, Object> paramMap) {
        if ((!TextUtils.isEmpty(paramString)) && (!paramMap.isEmpty())) {
            a.a(this.d).b(new com.umeng.analytics.c.b(paramString, paramMap, 0L, -1));
        }
    }

    public void a(String paramString, Map<String, Object> paramMap, long paramLong) {
        if (!a(paramString)) {
        }
        while (!a(paramMap)) {
            return;
        }
        a.a(this.d).a(new com.umeng.analytics.c.b(paramString, paramMap, paramLong, -1));
    }

    public void a(String paramString1, Map<String, Object> paramMap, String paramString2) {
        if (!a(paramString1)) {
        }
        while (!a(paramMap)) {
            return;
        }
        this.c.a(com.umeng.analytics.c.b.b(paramString1, paramString2, paramMap), com.umeng.analytics.c.b.a(paramString1, paramString2, paramMap));
    }

    public void b(String paramString1, String paramString2) {
        if ((!a(paramString1)) || (!b(paramString2))) {
        }
        com.umeng.analytics.c.a locala;
        do {
            return;
            locala = this.c.b(com.umeng.analytics.c.b.b(paramString1, paramString2, null));
        } while (locala == null);
        a(paramString1, paramString2, (int) (System.currentTimeMillis() - locala.a), 0);
    }

    public void c(String paramString1, String paramString2) {
        if (!a(paramString1)) {
        }
        do {
            return;
            paramString2 = this.c.b(com.umeng.analytics.c.b.b(paramString1, paramString2, null));
        } while (paramString2 == null);
        int i = (int) (System.currentTimeMillis() - paramString2.a);
        a(paramString1, paramString2.d, i);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */