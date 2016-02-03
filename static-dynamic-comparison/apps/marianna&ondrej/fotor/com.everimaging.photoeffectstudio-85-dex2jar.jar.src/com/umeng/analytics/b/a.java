package com.umeng.analytics.b;

import android.content.Context;
import com.umeng.analytics.d;
import com.umeng.analytics.d.g;
import com.umeng.analytics.d.i;
import com.umeng.analytics.d.x;
import com.umeng.analytics.e;

public final class a {
    private static a c;
    private f a;
    private Context b;

    private a(Context paramContext) {
        this.b = paramContext.getApplicationContext();
        this.a = new h(this.b);
    }

    public static a a(Context paramContext) {
        try {
            if ((c == null) && (paramContext != null)) {
                c = new a(paramContext);
            }
            paramContext = c;
            return paramContext;
        } finally {
        }
    }

    public f a() {
        return this.a;
    }

    public void a(final int paramInt) {
        d.b(new e() {
            public void a() {
                a.a(a.this).a(paramInt);
            }
        });
    }

    public void a(f paramf) {
        this.a = paramf;
    }

    public void a(g paramg) {
        if (paramg != null) {
            this.a.a(paramg);
        }
    }

    public void a(i parami) {
        if (parami != null) {
            this.a.b(parami);
        }
        a(1);
    }

    public void a(x paramx) {
        if (paramx != null) {
            this.a.a(paramx);
        }
        a(4);
    }

    public void a(String paramString) {
        if (paramString != null) {
            this.a.a(paramString);
        }
    }

    public void b() {
        d.b(new e() {
            public void a() {
                a.a(a.this).a();
            }
        });
    }

    public void b(i parami) {
        if (parami != null) {
            this.a.a(parami);
        }
        a(1);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */