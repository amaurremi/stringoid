package android.support.v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;

public class ch
        extends cp {
    public static final cq a;
    private static final cj g;
    private final String b;
    private final CharSequence c;
    private final CharSequence[] d;
    private final boolean e;
    private final Bundle f;

    static {
        if (Build.VERSION.SDK_INT >= 20) {
            g = new ck();
        }
        for (; ; ) {
            a = new ci();
            return;
            if (Build.VERSION.SDK_INT >= 16) {
                g = new cm();
            } else {
                g = new cl();
            }
        }
    }

    public String a() {
        return this.b;
    }

    public CharSequence b() {
        return this.c;
    }

    public CharSequence[] c() {
        return this.d;
    }

    public boolean d() {
        return this.e;
    }

    public Bundle e() {
        return this.f;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */