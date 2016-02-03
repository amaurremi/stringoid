package com.umeng.analytics.b;

import android.content.Context;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.a.d;
import com.umeng.analytics.f;
import com.umeng.common.Log;

public final class h
        extends e
        implements com.umeng.analytics.onlineconfig.c {
    private i d = null;
    private e e = null;
    private o f = null;
    private d g = null;

    public h(Context paramContext) {
        super(paramContext);
        this.g = com.umeng.analytics.a.h.a(paramContext);
        this.f = new o(paramContext);
        this.d = new i(paramContext);
        this.d.a(this.f);
        int[] arrayOfInt = f.a(paramContext).a();
        a(paramContext, arrayOfInt[0], arrayOfInt[1]);
    }

    private void a(Context paramContext, int paramInt1, int paramInt2) {
        switch (paramInt1) {
            case 2:
            case 3:
            default:
                this.e = new a();
        }
        for (; ; ) {
            Log.c("MobclickAgent", "report policy:" + paramInt1 + " interval:" + paramInt2);
            return;
            this.e = new a();
            continue;
            this.e = new b(this.f, paramInt2);
            continue;
            this.e = new d(this.f);
            continue;
            this.e = new e();
            continue;
            this.e = new f(paramContext);
            continue;
            this.e = new c(this, paramInt2);
        }
    }

    private void j() {
        try {
            if (this.f.b()) {
                a(new com.umeng.analytics.d.b(this.f.j()));
            }
            k();
            return;
        } catch (Throwable localThrowable) {
            do {
                if ((localThrowable instanceof OutOfMemoryError)) {
                    c();
                }
            } while (localThrowable == null);
            localThrowable.printStackTrace();
        }
    }

    private void k() {
        f localf = f.a(e());
        boolean bool = localf.f();
        byte[] arrayOfByte;
        if (bool) {
            arrayOfByte = localf.d();
        }
        switch (this.d.a(arrayOfByte)) {
            default:
            case 2:
            case 3:
                do {
                    do {
                        return;
                        this.g.a();
                        arrayOfByte = b();
                        if (arrayOfByte == null) {
                            Log.e("MobclickAgent", "message is null");
                            return;
                        }
                        arrayOfByte = com.umeng.analytics.a.c.a(e(), AnalyticsConfig.getAppkey(e()), arrayOfByte).c();
                        localf.c();
                        break;
                        if (this.f.i()) {
                            this.f.h();
                        }
                        this.g.d();
                        this.f.g();
                    } while (!bool);
                    localf.e();
                    return;
                    this.f.g();
                } while (!bool);
                localf.e();
                return;
        }
        if (!bool) {
            localf.b(arrayOfByte);
        }
        Log.b("MobclickAgent", "connection error");
    }

    public void a(int paramInt, long paramLong) {
        a(e(), paramInt, (int) paramLong);
    }

    public boolean a(int paramInt) {
        if (paramInt == 2) {
            j();
            return true;
        }
        if (((paramInt == 4) || (paramInt == 1)) && (c(paramInt))) {
            j();
            return true;
        }
        return super.a(paramInt);
    }

    boolean c(int paramInt) {
        boolean bool3 = true;
        boolean bool2 = true;
        if (!com.umeng.common.b.l(e())) {
            bool1 = false;
        }
        do {
            do {
                do {
                    return bool1;
                    bool1 = bool2;
                } while (this.f.b());
                bool1 = bool2;
            } while (paramInt == 2);
            if (!Log.LOG) {
                break;
            }
            bool1 = bool2;
        } while (com.umeng.common.b.w(e()));
        e locale = this.e;
        if (paramInt == 4) {
        }
        for (boolean bool1 = bool3; ; bool1 = false) {
            return locale.a(bool1);
        }
    }

    public static class a
            extends h.e {
        public boolean a(boolean paramBoolean) {
            return paramBoolean;
        }
    }

    public static class b
            extends h.e {
        private long a = 10000L;
        private long b;
        private o c;

        public b(o paramo, long paramLong) {
            this.c = paramo;
            long l = paramLong;
            if (paramLong < this.a) {
                l = this.a;
            }
            this.b = l;
        }

        public long a() {
            return this.b;
        }

        public boolean a(boolean paramBoolean) {
            return System.currentTimeMillis() - this.c.c >= this.b;
        }
    }

    public static class c
            extends h.e {
        private final int a;
        private g b;

        public c(g paramg, int paramInt) {
            this.a = paramInt;
            this.b = paramg;
        }

        public boolean a(boolean paramBoolean) {
            return this.b.f() > this.a;
        }
    }

    public static class d
            extends h.e {
        private long a = 86400000L;
        private o b;

        public d(o paramo) {
            this.b = paramo;
        }

        public boolean a(boolean paramBoolean) {
            return System.currentTimeMillis() - this.b.c >= this.a;
        }
    }

    public static class e {
        public boolean a(boolean paramBoolean) {
            return true;
        }
    }

    public static class f
            extends h.e {
        private Context a = null;

        public f(Context paramContext) {
            this.a = paramContext;
        }

        public boolean a(boolean paramBoolean) {
            return com.umeng.common.b.k(this.a);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */