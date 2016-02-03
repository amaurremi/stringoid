package com.flurry.sdk;

import java.io.IOException;

public class hk
        extends IOException {
    protected hg a;

    protected hk(String paramString) {
        super(paramString);
    }

    protected hk(String paramString, hg paramhg) {
        this(paramString, paramhg, null);
    }

    protected hk(String paramString, hg paramhg, Throwable paramThrowable) {
        super(paramString);
        if (paramThrowable != null) {
            initCause(paramThrowable);
        }
        this.a = paramhg;
    }

    protected hk(String paramString, Throwable paramThrowable) {
        this(paramString, null, paramThrowable);
    }

    public hg a() {
        return this.a;
    }

    public String getMessage() {
        Object localObject2 = super.getMessage();
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = "N/A";
        }
        hg localhg = a();
        localObject2 = localObject1;
        if (localhg != null) {
            localObject2 = new StringBuilder();
            ((StringBuilder) localObject2).append((String) localObject1);
            ((StringBuilder) localObject2).append('\n');
            ((StringBuilder) localObject2).append(" at ");
            ((StringBuilder) localObject2).append(localhg.toString());
            localObject2 = ((StringBuilder) localObject2).toString();
        }
        return (String) localObject2;
    }

    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/hk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */