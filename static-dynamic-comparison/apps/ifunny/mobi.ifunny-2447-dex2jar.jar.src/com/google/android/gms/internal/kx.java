package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@ii
public final class kx {
    private String a;
    private String b;
    private String c;
    private List<String> d;
    private String e;
    private String f;
    private List<String> g;
    private long h = -1L;
    private boolean i = false;
    private final long j = -1L;
    private List<String> k;
    private long l = -1L;
    private int m = -1;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;

    static String a(Map<String, List<String>> paramMap, String paramString) {
        paramMap = (List) paramMap.get(paramString);
        if ((paramMap != null) && (!paramMap.isEmpty())) {
            return (String) paramMap.get(0);
        }
        return null;
    }

    static long b(Map<String, List<String>> paramMap, String paramString) {
        paramMap = (List) paramMap.get(paramString);
        if ((paramMap != null) && (!paramMap.isEmpty())) {
            paramMap = (String) paramMap.get(0);
            try {
                float f1 = Float.parseFloat(paramMap);
                return (f1 * 1000.0F);
            } catch (NumberFormatException localNumberFormatException) {
                mx.e("Could not parse float from " + paramString + " header: " + paramMap);
            }
        }
        return -1L;
    }

    private void b(Map<String, List<String>> paramMap) {
        this.a = a(paramMap, "X-Afma-Ad-Size");
    }

    static List<String> c(Map<String, List<String>> paramMap, String paramString) {
        paramMap = (List) paramMap.get(paramString);
        if ((paramMap != null) && (!paramMap.isEmpty())) {
            paramMap = (String) paramMap.get(0);
            if (paramMap != null) {
                return Arrays.asList(paramMap.trim().split("\\s+"));
            }
        }
        return null;
    }

    private void c(Map<String, List<String>> paramMap) {
        paramMap = c(paramMap, "X-Afma-Click-Tracking-Urls");
        if (paramMap != null) {
            this.d = paramMap;
        }
    }

    private void d(Map<String, List<String>> paramMap) {
        paramMap = (List) paramMap.get("X-Afma-Debug-Dialog");
        if ((paramMap != null) && (!paramMap.isEmpty())) {
            this.e = ((String) paramMap.get(0));
        }
    }

    private boolean d(Map<String, List<String>> paramMap, String paramString) {
        paramMap = (List) paramMap.get(paramString);
        return (paramMap != null) && (!paramMap.isEmpty()) && (Boolean.valueOf((String) paramMap.get(0)).booleanValue());
    }

    private void e(Map<String, List<String>> paramMap) {
        paramMap = c(paramMap, "X-Afma-Tracking-Urls");
        if (paramMap != null) {
            this.g = paramMap;
        }
    }

    private void f(Map<String, List<String>> paramMap) {
        long l1 = b(paramMap, "X-Afma-Interstitial-Timeout");
        if (l1 != -1L) {
            this.h = l1;
        }
    }

    private void g(Map<String, List<String>> paramMap) {
        this.f = a(paramMap, "X-Afma-ActiveView");
    }

    private void h(Map<String, List<String>> paramMap) {
        this.o |= d(paramMap, "X-Afma-Native");
    }

    private void i(Map<String, List<String>> paramMap) {
        this.n |= d(paramMap, "X-Afma-Custom-Rendering-Allowed");
    }

    private void j(Map<String, List<String>> paramMap) {
        this.i |= d(paramMap, "X-Afma-Mediation");
    }

    private void k(Map<String, List<String>> paramMap) {
        paramMap = c(paramMap, "X-Afma-Manual-Tracking-Urls");
        if (paramMap != null) {
            this.k = paramMap;
        }
    }

    private void l(Map<String, List<String>> paramMap) {
        long l1 = b(paramMap, "X-Afma-Refresh-Rate");
        if (l1 != -1L) {
            this.l = l1;
        }
    }

    private void m(Map<String, List<String>> paramMap) {
        paramMap = (List) paramMap.get("X-Afma-Orientation");
        if ((paramMap != null) && (!paramMap.isEmpty())) {
            paramMap = (String) paramMap.get(0);
            if (!"portrait".equalsIgnoreCase(paramMap)) {
                break label53;
            }
            this.m = lw.c();
        }
        label53:
        while (!"landscape".equalsIgnoreCase(paramMap)) {
            return;
        }
        this.m = lw.b();
    }

    private void n(Map<String, List<String>> paramMap) {
        paramMap = (List) paramMap.get("X-Afma-Use-HTTPS");
        if ((paramMap != null) && (!paramMap.isEmpty())) {
            this.p = Boolean.valueOf((String) paramMap.get(0)).booleanValue();
        }
    }

    private void o(Map<String, List<String>> paramMap) {
        paramMap = (List) paramMap.get("X-Afma-Content-Url-Opted-Out");
        if ((paramMap != null) && (!paramMap.isEmpty())) {
            this.q = Boolean.valueOf((String) paramMap.get(0)).booleanValue();
        }
    }

    public fk a(long paramLong) {
        return new fk(this.b, this.c, this.d, this.g, this.h, this.i, -1L, this.k, this.l, this.m, this.a, paramLong, this.e, this.f, this.n, this.o, this.p, this.q);
    }

    public void a(String paramString1, Map<String, List<String>> paramMap, String paramString2) {
        this.b = paramString1;
        this.c = paramString2;
        a(paramMap);
    }

    public void a(Map<String, List<String>> paramMap) {
        b(paramMap);
        c(paramMap);
        d(paramMap);
        e(paramMap);
        f(paramMap);
        j(paramMap);
        k(paramMap);
        l(paramMap);
        m(paramMap);
        g(paramMap);
        n(paramMap);
        i(paramMap);
        h(paramMap);
        o(paramMap);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/kx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */