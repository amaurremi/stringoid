package com.google.android.gms.a;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ag;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class m {
    private final o a;
    private Context b;
    private final Map<String, String> c = new HashMap();
    private t d;
    private final al e;
    private final u f;
    private final ak g;
    private boolean h;
    private n i;
    private aa j;
    private b k;

    m(String paramString, o paramo, Context paramContext) {
        this(paramString, paramo, al.a(), u.a(), ak.a(), new bs("tracking"), paramContext);
    }

    m(String paramString, o paramo, al paramal, u paramu, ak paramak, t paramt, Context paramContext) {
        this.a = paramo;
        if (paramContext != null) {
            this.b = paramContext.getApplicationContext();
        }
        if (paramString != null) {
            this.c.put("&tid", paramString);
        }
        this.c.put("useSecure", "1");
        this.e = paramal;
        this.f = paramu;
        this.g = paramak;
        this.c.put("&a", Integer.toString(new Random().nextInt(Integer.MAX_VALUE) + 1));
        this.d = paramt;
        this.i = new n(this);
        c(false);
    }

    long a() {
        return this.i.a();
    }

    public void a(long paramLong) {
        this.i.a(1000L * paramLong);
    }

    void a(aa paramaa) {
        bt.c("Loading Tracker config values.");
        this.j = paramaa;
        if (this.j.a()) {
            paramaa = this.j.b();
            a("&tid", paramaa);
            bt.c("[Tracker] trackingId loaded: " + paramaa);
        }
        if (this.j.c()) {
            paramaa = Double.toString(this.j.d());
            a("&sf", paramaa);
            bt.c("[Tracker] sample frequency loaded: " + paramaa);
        }
        if (this.j.e()) {
            a(this.j.f());
            bt.c("[Tracker] session timeout loaded: " + a());
        }
        if (this.j.g()) {
            b(this.j.h());
            bt.c("[Tracker] auto activity tracking loaded: " + b());
        }
        if (this.j.i()) {
            if (this.j.j()) {
                a("&aip", "1");
                bt.c("[Tracker] anonymize ip loaded: true");
            }
            bt.c("[Tracker] anonymize ip loaded: false");
        }
        a(this.j.k());
    }

    public void a(String paramString) {
        a("&cd", paramString);
    }

    public void a(String paramString1, String paramString2) {
        ag.a(paramString1, "Key should be non-null");
        bl.a().a(bm.k);
        this.c.put(paramString1, paramString2);
    }

    public void a(Map<String, String> paramMap) {
        bl.a().a(bm.l);
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(this.c);
        if (paramMap != null) {
            localHashMap.putAll(paramMap);
        }
        if (TextUtils.isEmpty((CharSequence) localHashMap.get("&tid"))) {
            bt.d(String.format("Missing tracking id (%s) parameter.", new Object[]{"&tid"}));
        }
        String str = (String) localHashMap.get("&t");
        paramMap = str;
        if (TextUtils.isEmpty(str)) {
            bt.d(String.format("Missing hit type (%s) parameter.", new Object[]{"&t"}));
            paramMap = "";
        }
        if (this.i.c()) {
            localHashMap.put("&sc", "start");
        }
        paramMap = paramMap.toLowerCase();
        if (("screenview".equals(paramMap)) || ("pageview".equals(paramMap)) || ("appview".equals(paramMap)) || (TextUtils.isEmpty(paramMap))) {
            int n = Integer.parseInt((String) this.c.get("&a")) + 1;
            int m = n;
            if (n >= Integer.MAX_VALUE) {
                m = 1;
            }
            this.c.put("&a", Integer.toString(m));
        }
        if ((!paramMap.equals("transaction")) && (!paramMap.equals("item")) && (!this.d.a())) {
            bt.d("Too many hits sent too quickly, rate limiting invoked.");
            return;
        }
        this.a.a(localHashMap);
    }

    public void a(boolean paramBoolean) {
        if (this.h == paramBoolean) {
            return;
        }
        this.h = paramBoolean;
        if (paramBoolean) {
            this.k = new b(this, Thread.getDefaultUncaughtExceptionHandler(), this.b);
            Thread.setDefaultUncaughtExceptionHandler(this.k);
            bt.c("Uncaught exceptions will be reported to Google Analytics.");
            return;
        }
        if (this.k != null) {
            Thread.setDefaultUncaughtExceptionHandler(this.k.a());
        }
        for (; ; ) {
            bt.c("Uncaught exceptions will not be reported to Google Analytics.");
            return;
            Thread.setDefaultUncaughtExceptionHandler(null);
        }
    }

    public void b(boolean paramBoolean) {
        this.i.a(paramBoolean);
    }

    boolean b() {
        return this.i.b();
    }

    public void c(boolean paramBoolean) {
        if (!paramBoolean) {
            this.c.put("&ate", null);
            this.c.put("&adid", null);
        }
        do {
            return;
            if (this.c.containsKey("&ate")) {
                this.c.remove("&ate");
            }
        } while (!this.c.containsKey("&adid"));
        this.c.remove("&adid");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */