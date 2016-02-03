package com.google.analytics.tracking.android;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class l
        extends ah {
    private static l a;
    private static String b;
    private final s c;
    private boolean d;
    private boolean e;
    private int f;
    private long g;
    private long h;
    private Context i;
    private final Map<String, String> j;
    private x k;
    private ad l;
    private h m;
    private Timer n;
    private TimerTask o;
    private boolean p;
    private boolean q;

    private l(Context paramContext) {
        this(paramContext, new y(paramContext), s.a(paramContext), q.a(), null);
    }

    private l(Context paramContext, x paramx, s params, ad paramad, ai paramai) {
    }

    private Logger.LogLevel a(String paramString) {
        try {
            paramString = Logger.LogLevel.valueOf(paramString.toUpperCase());
            return paramString;
        } catch (IllegalArgumentException paramString) {
        }
        return null;
    }

    public static l a(Context paramContext) {
        if (a == null) {
            a = new l(paramContext);
        }
        return a;
    }

    private void a(Context paramContext, x paramx, ad paramad) {
        if (paramContext == null) {
            v.a("Context cannot be null");
        }
        this.i = paramContext.getApplicationContext();
        this.l = paramad;
        this.k = paramx;
        b();
    }

    private void b() {
        v.c("Starting EasyTracker.");
        Object localObject2 = this.k.a("ga_trackingId");
        Object localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence) localObject2)) {
            localObject1 = this.k.a("ga_api_key");
        }
        a("&tid", (String) localObject1);
        v.c("[EasyTracker] trackingId loaded: " + (String) localObject1);
        localObject1 = this.k.a("ga_appName");
        if (!TextUtils.isEmpty((CharSequence) localObject1)) {
            v.c("[EasyTracker] app name loaded: " + (String) localObject1);
            a("&an", (String) localObject1);
        }
        localObject1 = this.k.a("ga_appVersion");
        if (localObject1 != null) {
            v.c("[EasyTracker] app version loaded: " + (String) localObject1);
            a("&av", (String) localObject1);
        }
        localObject1 = this.k.a("ga_logLevel");
        if (localObject1 != null) {
            localObject1 = a((String) localObject1);
            if (localObject1 != null) {
                v.c("[EasyTracker] log level loaded: " + localObject1);
                this.c.d().a((Logger.LogLevel) localObject1);
            }
        }
        localObject2 = this.k.b("ga_sampleFrequency");
        localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = new Double(this.k.a("ga_sampleRate", 100));
        }
        if (((Double) localObject1).doubleValue() != 100.0D) {
            a("&sf", Double.toString(((Double) localObject1).doubleValue()));
        }
        v.c("[EasyTracker] sample rate loaded: " + localObject1);
        int i1 = this.k.a("ga_dispatchPeriod", 1800);
        v.c("[EasyTracker] dispatch period loaded: " + i1);
        this.l.a(i1);
        this.g = (this.k.a("ga_sessionTimeout", 30) * 1000);
        v.c("[EasyTracker] session timeout loaded: " + this.g);
        if ((this.k.c("ga_autoActivityTracking")) || (this.k.c("ga_auto_activity_tracking"))) {
        }
        for (boolean bool = true; ; bool = false) {
            this.e = bool;
            v.c("[EasyTracker] auto activity tracking loaded: " + this.e);
            bool = this.k.c("ga_anonymizeIp");
            if (bool) {
                a("&aip", "1");
                v.c("[EasyTracker] anonymize ip loaded: " + bool);
            }
            this.d = this.k.c("ga_reportUncaughtExceptions");
            if (this.d) {
                Thread.setDefaultUncaughtExceptionHandler(new n(this, this.l, Thread.getDefaultUncaughtExceptionHandler(), this.i));
                v.c("[EasyTracker] report uncaught exceptions loaded: " + this.d);
            }
            bool = this.k.c("ga_dryRun");
            this.c.a(bool);
            return;
        }
    }

    private String c(Activity paramActivity) {
        String str1 = paramActivity.getClass().getCanonicalName();
        if (this.j.containsKey(str1)) {
            return (String) this.j.get(str1);
        }
        String str2 = this.k.a(str1);
        paramActivity = str2;
        if (str2 == null) {
            paramActivity = str1;
        }
        this.j.put(str1, paramActivity);
        return paramActivity;
    }

    private void c() {
        try {
            if (this.n != null) {
                this.n.cancel();
                this.n = null;
            }
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void a(Activity paramActivity) {
        GAUsage.a().a(GAUsage.Field.EASY_TRACKER_ACTIVITY_START);
        c();
        if ((!this.p) && (this.f == 0) && (a())) {
            this.q = true;
        }
        this.p = true;
        this.f += 1;
        if (this.e) {
            // todo keys put in hash map
            HashMap localHashMap = new HashMap();
            localHashMap.put("&t", "appview");
            GAUsage.a().a(true);
            a("&cd", c(paramActivity));
            a(localHashMap);
            GAUsage.a().a(false);
        }
    }

    public void a(Map<String, String> paramMap) {
        if (this.q) {
            paramMap.put("&sc", "start");
            this.q = false;
        }
        super.a(paramMap);
    }

    boolean a() {
        return (this.g == 0L) || ((this.g > 0L) && (this.m.a() > this.h + this.g));
    }

    public void b(Activity paramActivity) {
        GAUsage.a().a(GAUsage.Field.EASY_TRACKER_ACTIVITY_STOP);
        this.f -= 1;
        this.f = Math.max(0, this.f);
        this.h = this.m.a();
        if (this.f == 0) {
            c();
            this.o = new a(null);
            this.n = new Timer("waitForActivityStart");
            this.n.schedule(this.o, 1000L);
        }
    }

    private class a
            extends TimerTask {
        private a() {
        }

        public void run() {
            l.a(l.this, false);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/google/analytics/tracking/android/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */