package com.google.android.gms.a;

class bo
        implements ap<bp> {
    private final bp a = new bp();

    public bp a() {
        return this.a;
    }

    public void a(String paramString, int paramInt) {
        if ("ga_dispatchPeriod".equals(paramString)) {
            this.a.d = paramInt;
            return;
        }
        bt.d("int configuration name not recognized:  " + paramString);
    }

    public void a(String paramString1, String paramString2) {
    }

    public void a(String paramString, boolean paramBoolean) {
        if ("ga_dryRun".equals(paramString)) {
            paramString = this.a;
            if (paramBoolean) {
            }
            for (int i = 1; ; i = 0) {
                paramString.e = i;
                return;
            }
        }
        bt.d("bool configuration name not recognized:  " + paramString);
    }

    public void b(String paramString1, String paramString2) {
        if ("ga_appName".equals(paramString1)) {
            this.a.a = paramString2;
            return;
        }
        if ("ga_appVersion".equals(paramString1)) {
            this.a.b = paramString2;
            return;
        }
        if ("ga_logLevel".equals(paramString1)) {
            this.a.c = paramString2;
            return;
        }
        bt.d("string configuration name not recognized:  " + paramString1);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */