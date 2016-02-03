package com.google.analytics.tracking.android;

import android.content.Context;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class s
        extends ai {
    private static s g;
    private boolean a;
    private e b;
    private Context c;
    private volatile Boolean d = Boolean.valueOf(false);
    private final Map<String, ah> e = new HashMap();
    private Logger f;

    protected s(Context paramContext) {
        this(paramContext, r.a(paramContext));
    }

    private s(Context paramContext, e parame) {
        if (paramContext == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.c = paramContext.getApplicationContext();
        this.b = parame;
        f.a(this.c);
        ab.a(this.c);
        g.a(this.c);
        this.f = new i();
    }

    static s a() {
        try {
            s locals = g;
            return locals;
        } finally {
        }
    }

    public static s a(Context paramContext) {
        try {
            if (g == null) {
                g = new s(paramContext);
            }
            paramContext = g;
            return paramContext;
        } finally {
        }
    }

    void a(Map<String, String> paramMap) {
        if (paramMap == null) {
            try {
                throw new IllegalArgumentException("hit cannot be null");
            } finally {
            }
        }
        aj.a(paramMap, "&ul", aj.a(Locale.getDefault()));
        aj.a(paramMap, "&sr", ab.a().a("&sr"));
        paramMap.put("&_u", GAUsage.a().c());
        GAUsage.a().b();
        this.b.a(paramMap);
    }

    public void a(boolean paramBoolean) {
        GAUsage.a().a(GAUsage.Field.SET_DRY_RUN);
        this.a = paramBoolean;
    }

    public boolean b() {
        GAUsage.a().a(GAUsage.Field.GET_DRY_RUN);
        return this.a;
    }

    public boolean c() {
        GAUsage.a().a(GAUsage.Field.GET_APP_OPT_OUT);
        return this.d.booleanValue();
    }

    public Logger d() {
        return this.f;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/google/analytics/tracking/android/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */