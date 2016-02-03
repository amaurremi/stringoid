package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@ii
class ky {
    private final List<String> a;
    private final List<String> b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final boolean g;
    private final int h;
    private String i;
    private int j;

    public ky(int paramInt, Map<String, String> paramMap) {
        this.i = ((String) paramMap.get("url"));
        this.d = ((String) paramMap.get("base_uri"));
        this.e = ((String) paramMap.get("post_parameters"));
        this.g = b((String) paramMap.get("drt_include"));
        this.c = ((String) paramMap.get("activation_overlay_url"));
        this.b = c((String) paramMap.get("check_packages"));
        this.h = d((String) paramMap.get("request_id"));
        this.f = ((String) paramMap.get("type"));
        this.a = c((String) paramMap.get("errors"));
        this.j = paramInt;
    }

    private static boolean b(String paramString) {
        return (paramString != null) && ((paramString.equals("1")) || (paramString.equals("true")));
    }

    private List<String> c(String paramString) {
        if (paramString == null) {
            return null;
        }
        return Arrays.asList(paramString.split(","));
    }

    private int d(String paramString) {
        if (paramString == null) {
            return 0;
        }
        return Integer.parseInt(paramString);
    }

    public int a() {
        return this.j;
    }

    public void a(String paramString) {
        this.i = paramString;
    }

    public List<String> b() {
        return this.a;
    }

    public String c() {
        return this.e;
    }

    public String d() {
        return this.i;
    }

    public String e() {
        return this.f;
    }

    public boolean f() {
        return this.g;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ky.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */