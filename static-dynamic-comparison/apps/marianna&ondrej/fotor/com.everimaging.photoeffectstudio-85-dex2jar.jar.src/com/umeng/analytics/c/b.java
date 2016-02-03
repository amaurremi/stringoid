package com.umeng.analytics.c;

import com.umeng.analytics.d.i;
import com.umeng.analytics.d.t;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class b
        extends i {
    public static int a = 0;
    public static int b = 1;
    private int i = 0;

    public b(String paramString, Map<String, Object> paramMap, long paramLong, int paramInt) {
        a(paramString);
        b(System.currentTimeMillis());
        if (paramMap.size() > 0) {
            a(b(paramMap));
        }
        if (paramInt > 0) {
        }
        for (; ; ) {
            c(paramInt);
            if (paramLong > 0L) {
                a(paramLong);
            }
            return;
            paramInt = 1;
        }
    }

    public static a a(String paramString1, String paramString2, Map<String, Object> paramMap) {
        a locala = new a();
        locala.b = paramString1;
        locala.c = paramString2;
        locala.d = paramMap;
        return locala;
    }

    public static String b(String paramString1, String paramString2, Map<String, Object> paramMap) {
        return paramString1 + paramString2;
    }

    private HashMap<String, t> b(Map<String, Object> paramMap) {
        paramMap = paramMap.entrySet().iterator();
        HashMap localHashMap = new HashMap();
        int j = 0;
        if ((j < 10) && (paramMap.hasNext())) {
            Map.Entry localEntry = (Map.Entry) paramMap.next();
            t localt = new t();
            Object localObject = localEntry.getValue();
            if ((localObject instanceof String)) {
                localt.b((String) localObject);
            }
            for (; ; ) {
                localHashMap.put(localEntry.getKey(), localt);
                j += 1;
                break;
                if ((localObject instanceof Long)) {
                    localt.b(((Long) localObject).longValue());
                } else if ((localObject instanceof Integer)) {
                    localt.b(((Integer) localObject).longValue());
                } else if ((localObject instanceof Float)) {
                    localt.b(((Float) localObject).longValue());
                }
            }
        }
        return localHashMap;
    }

    public int a() {
        return this.i;
    }

    public void a(int paramInt) {
        this.i = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */