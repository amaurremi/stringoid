package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.internal.fq;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class Tracker {
    private final TrackerHandler vM;
    private final Map<String, String> vN = new HashMap();
    private ad vO;
    private final h vP;
    private final ae vQ;
    private final g vR;
    private boolean vS;
    private a vT;
    private aj vU;

    Tracker(String paramString, TrackerHandler paramTrackerHandler) {
        this(paramString, paramTrackerHandler, h.cb(), ae.cZ(), g.ca(), new z("tracking"));
    }

    Tracker(String paramString, TrackerHandler paramTrackerHandler, h paramh, ae paramae, g paramg, ad paramad) {
        this.vM = paramTrackerHandler;
        if (paramString != null) {
            this.vN.put("&tid", paramString);
        }
        this.vN.put("useSecure", "1");
        this.vP = paramh;
        this.vQ = paramae;
        this.vR = paramg;
        this.vO = paramad;
        this.vT = new a();
    }

    void a(Context paramContext, aj paramaj) {
        aa.y("Loading Tracker config values.");
        this.vU = paramaj;
        if (this.vU.dj()) {
            paramaj = this.vU.dk();
            set("&tid", paramaj);
            aa.y("[Tracker] trackingId loaded: " + paramaj);
        }
        if (this.vU.dl()) {
            paramaj = Double.toString(this.vU.dm());
            set("&sf", paramaj);
            aa.y("[Tracker] sample frequency loaded: " + paramaj);
        }
        if (this.vU.dn()) {
            setSessionTimeout(this.vU.getSessionTimeout());
            aa.y("[Tracker] session timeout loaded: " + dc());
        }
        if (this.vU.jdMethod_do()) {
            enableAutoActivityTracking(this.vU.dp());
            aa.y("[Tracker] auto activity tracking loaded: " + dd());
        }
        if (this.vU.dq()) {
            if (this.vU.dr()) {
                set("&aip", "1");
                aa.y("[Tracker] anonymize ip loaded: true");
            }
            aa.y("[Tracker] anonymize ip loaded: false");
        }
        this.vS = this.vU.ds();
        if (this.vU.ds()) {
            Thread.setDefaultUncaughtExceptionHandler(new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), paramContext));
            aa.y("[Tracker] report uncaught exceptions loaded: " + this.vS);
        }
    }

    long dc() {
        return this.vT.dc();
    }

    boolean dd() {
        return this.vT.dd();
    }

    public void enableAdvertisingIdCollection(boolean paramBoolean) {
        if (!paramBoolean) {
            this.vN.put("&ate", null);
            this.vN.put("&adid", null);
        }
        do {
            return;
            if (this.vN.containsKey("&ate")) {
                this.vN.remove("&ate");
            }
        } while (!this.vN.containsKey("&adid"));
        this.vN.remove("&adid");
    }

    public void enableAutoActivityTracking(boolean paramBoolean) {
        this.vT.enableAutoActivityTracking(paramBoolean);
    }

    public String get(String paramString) {
        u.cy().a(u.a.tR);
        if (TextUtils.isEmpty(paramString)) {
        }
        do {
            return null;
            if (this.vN.containsKey(paramString)) {
                return (String) this.vN.get(paramString);
            }
            if (paramString.equals("&ul")) {
                return ak.a(Locale.getDefault());
            }
            if ((this.vP != null) && (this.vP.C(paramString))) {
                return this.vP.getValue(paramString);
            }
            if ((this.vQ != null) && (this.vQ.C(paramString))) {
                return this.vQ.getValue(paramString);
            }
        } while ((this.vR == null) || (!this.vR.C(paramString)));
        return this.vR.getValue(paramString);
    }

    public void send(Map<String, String> paramMap) {
        u.cy().a(u.a.tT);
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(this.vN);
        if (paramMap != null) {
            localHashMap.putAll(paramMap);
        }
        if (TextUtils.isEmpty((CharSequence) localHashMap.get("&tid"))) {
            aa.z(String.format("Missing tracking id (%s) parameter.", new Object[]{"&tid"}));
        }
        String str = (String) localHashMap.get("&t");
        paramMap = str;
        if (TextUtils.isEmpty(str)) {
            aa.z(String.format("Missing hit type (%s) parameter.", new Object[]{"&t"}));
            paramMap = "";
        }
        if (this.vT.de()) {
            localHashMap.put("&sc", "start");
        }
        if ((!paramMap.equals("transaction")) && (!paramMap.equals("item")) && (!this.vO.cS())) {
            aa.z("Too many hits sent too quickly, rate limiting invoked.");
            return;
        }
        this.vM.q(localHashMap);
    }

    public void set(String paramString1, String paramString2) {
        fq.b(paramString1, "Key should be non-null");
        u.cy().a(u.a.tS);
        this.vN.put(paramString1, paramString2);
    }

    public void setAnonymizeIp(boolean paramBoolean) {
        set("&aip", ak.u(paramBoolean));
    }

    public void setAppId(String paramString) {
        set("&aid", paramString);
    }

    public void setAppInstallerId(String paramString) {
        set("&aiid", paramString);
    }

    public void setAppName(String paramString) {
        set("&an", paramString);
    }

    public void setAppVersion(String paramString) {
        set("&av", paramString);
    }

    public void setClientId(String paramString) {
        set("&cid", paramString);
    }

    public void setEncoding(String paramString) {
        set("&de", paramString);
    }

    public void setHostname(String paramString) {
        set("&dh", paramString);
    }

    public void setLanguage(String paramString) {
        set("&ul", paramString);
    }

    public void setLocation(String paramString) {
        set("&dl", paramString);
    }

    public void setPage(String paramString) {
        set("&dp", paramString);
    }

    public void setReferrer(String paramString) {
        set("&dr", paramString);
    }

    public void setSampleRate(double paramDouble) {
        set("&sf", Double.toHexString(paramDouble));
    }

    public void setScreenColors(String paramString) {
        set("&sd", paramString);
    }

    public void setScreenName(String paramString) {
        set("&cd", paramString);
    }

    public void setScreenResolution(int paramInt1, int paramInt2) {
        if ((paramInt1 < 0) && (paramInt2 < 0)) {
            aa.z("Invalid width or height. The values should be non-negative.");
            return;
        }
        set("&sr", paramInt1 + "x" + paramInt2);
    }

    public void setSessionTimeout(long paramLong) {
        this.vT.setSessionTimeout(1000L * paramLong);
    }

    public void setTitle(String paramString) {
        set("&dt", paramString);
    }

    public void setUseSecure(boolean paramBoolean) {
        set("useSecure", ak.u(paramBoolean));
    }

    public void setViewportSize(String paramString) {
        set("&vp", paramString);
    }

    private class a
            implements GoogleAnalytics.a {
        private i tg = new i() {
            public long currentTimeMillis() {
                return System.currentTimeMillis();
            }
        };
        private Timer vV;
        private TimerTask vW;
        private boolean vX = false;
        private boolean vY = false;
        private int vZ = 0;
        private long wa = -1L;
        private boolean wb = false;
        private long wc;

        public a() {
        }

        private void df() {
            GoogleAnalytics localGoogleAnalytics = GoogleAnalytics.cM();
            if (localGoogleAnalytics == null) {
                aa.w("GoogleAnalytics isn't initialized for the Tracker!");
                return;
            }
            if ((this.wa >= 0L) || (this.vY)) {
                localGoogleAnalytics.a(Tracker.b(Tracker.this));
                return;
            }
            localGoogleAnalytics.b(Tracker.b(Tracker.this));
        }

        private void dg() {
            try {
                if (this.vV != null) {
                    this.vV.cancel();
                    this.vV = null;
                }
                return;
            } finally {
                localObject =finally;
                throw ((Throwable) localObject);
            }
        }

        public long dc() {
            return this.wa;
        }

        public boolean dd() {
            return this.vY;
        }

        public boolean de() {
            boolean bool = this.wb;
            this.wb = false;
            return bool;
        }

        boolean dh() {
            return (this.wa == 0L) || ((this.wa > 0L) && (this.tg.currentTimeMillis() > this.wc + this.wa));
        }

        public void enableAutoActivityTracking(boolean paramBoolean) {
            this.vY = paramBoolean;
            df();
        }

        public void f(Activity paramActivity) {
            u.cy().a(u.a.uQ);
            dg();
            if ((!this.vX) && (this.vZ == 0) && (dh())) {
                this.wb = true;
            }
            this.vX = true;
            this.vZ += 1;
            HashMap localHashMap;
            Tracker localTracker;
            if (this.vY) {
                localHashMap = new HashMap();
                localHashMap.put("&t", "appview");
                u.cy().t(true);
                localTracker = Tracker.this;
                if (Tracker.c(Tracker.this) == null) {
                    break label137;
                }
            }
            label137:
            for (paramActivity = Tracker.c(Tracker.this).h(paramActivity); ; paramActivity = paramActivity.getClass().getCanonicalName()) {
                localTracker.set("&cd", paramActivity);
                Tracker.this.send(localHashMap);
                u.cy().t(false);
                return;
            }
        }

        public void g(Activity paramActivity) {
            u.cy().a(u.a.uR);
            this.vZ -= 1;
            this.vZ = Math.max(0, this.vZ);
            this.wc = this.tg.currentTimeMillis();
            if (this.vZ == 0) {
                dg();
                this.vW = new a(null);
                this.vV = new Timer("waitForActivityStart");
                this.vV.schedule(this.vW, 1000L);
            }
        }

        public void setSessionTimeout(long paramLong) {
            this.wa = paramLong;
            df();
        }

        private class a
                extends TimerTask {
            private a() {
            }

            public void run() {
                Tracker.a.a(Tracker.a.this, false);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/analytics/Tracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */