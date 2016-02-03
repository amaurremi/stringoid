package com.google.android.gms.analytics;

import android.content.Context;

import java.util.Map;

class ai
        extends k<aj> {
    public ai(Context paramContext) {
        super(paramContext, new a());
    }

    private static class a
            implements k.a<aj> {
        private final aj wg = new aj();

        public void a(String paramString, int paramInt) {
            if ("ga_sessionTimeout".equals(paramString)) {
                this.wg.wj = paramInt;
                return;
            }
            aa.z("int configuration name not recognized:  " + paramString);
        }

        public void a(String paramString1, String paramString2) {
            this.wg.wn.put(paramString1, paramString2);
        }

        public void b(String paramString1, String paramString2) {
            if ("ga_trackingId".equals(paramString1)) {
                this.wg.wh = paramString2;
                return;
            }
            if ("ga_sampleFrequency".equals(paramString1)) {
                try {
                    this.wg.wi = Double.parseDouble(paramString2);
                    return;
                } catch (NumberFormatException paramString1) {
                    aa.w("Error parsing ga_sampleFrequency value: " + paramString2);
                    return;
                }
            }
            aa.z("string configuration name not recognized:  " + paramString1);
        }

        public void c(String paramString, boolean paramBoolean) {
            int j = 1;
            int k = 1;
            int i = 1;
            if ("ga_autoActivityTracking".equals(paramString)) {
                paramString = this.wg;
                if (paramBoolean) {
                }
                for (; ; ) {
                    paramString.wk = i;
                    return;
                    i = 0;
                }
            }
            if ("ga_anonymizeIp".equals(paramString)) {
                paramString = this.wg;
                if (paramBoolean) {
                }
                for (i = j; ; i = 0) {
                    paramString.wl = i;
                    return;
                }
            }
            if ("ga_reportUncaughtExceptions".equals(paramString)) {
                paramString = this.wg;
                if (paramBoolean) {
                }
                for (i = k; ; i = 0) {
                    paramString.wm = i;
                    return;
                }
            }
            aa.z("bool configuration name not recognized:  " + paramString);
        }

        public aj di() {
            return this.wg;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/analytics/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */