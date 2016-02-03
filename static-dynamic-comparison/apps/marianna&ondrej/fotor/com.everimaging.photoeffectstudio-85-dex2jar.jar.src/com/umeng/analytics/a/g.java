package com.umeng.analytics.a;

import android.content.Context;
import com.umeng.common.b;

public class g
        extends a {
    private static final String a = "mac";
    private Context b;

    public g(Context paramContext) {
        super("mac");
        this.b = paramContext;
    }

    public String f() {
        try {
            String str = b.p(this.b);
            return str;
        } catch (Exception localException) {
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */