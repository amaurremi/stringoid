package com.google.android.gms.analytics;

import android.content.Context;

class v
        extends k<w> {
    public v(Context paramContext) {
        super(paramContext, new a());
    }

    private static class a
            implements k.a<w> {
        private final w uU = new w();

        public void a(String paramString, int paramInt) {
            if ("ga_dispatchPeriod".equals(paramString)) {
                this.uU.uW = paramInt;
                return;
            }
            aa.z("int configuration name not recognized:  " + paramString);
        }

        public void a(String paramString1, String paramString2) {
        }

        public void b(String paramString1, String paramString2) {
            if ("ga_appName".equals(paramString1)) {
                this.uU.so = paramString2;
                return;
            }
            if ("ga_appVersion".equals(paramString1)) {
                this.uU.sp = paramString2;
                return;
            }
            if ("ga_logLevel".equals(paramString1)) {
                this.uU.uV = paramString2;
                return;
            }
            aa.z("string configuration name not recognized:  " + paramString1);
        }

        public void c(String paramString, boolean paramBoolean) {
            if ("ga_dryRun".equals(paramString)) {
                paramString = this.uU;
                if (paramBoolean) {
                }
                for (int i = 1; ; i = 0) {
                    paramString.uX = i;
                    return;
                }
            }
            aa.z("bool configuration name not recognized:  " + paramString);
        }

        public w cB() {
            return this.uU;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/analytics/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */