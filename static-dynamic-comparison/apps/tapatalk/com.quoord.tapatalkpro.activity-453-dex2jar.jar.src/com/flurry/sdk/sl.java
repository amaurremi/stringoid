package com.flurry.sdk;

import java.io.IOException;
import java.util.Arrays;

public class sl
        implements ho {
    protected hs a = new a();
    protected hs b = new b();
    protected boolean c = true;
    protected int d = 0;

    public void a(hf paramhf)
            throws IOException, he {
        paramhf.a(' ');
    }

    public void a(hf paramhf, int paramInt)
            throws IOException, he {
        if (!this.b.a()) {
            this.d -= 1;
        }
        if (paramInt > 0) {
            this.b.a(paramhf, this.d);
        }
        for (; ; ) {
            paramhf.a('}');
            return;
            paramhf.a(' ');
        }
    }

    public void b(hf paramhf)
            throws IOException, he {
        paramhf.a('{');
        if (!this.b.a()) {
            this.d += 1;
        }
    }

    public void b(hf paramhf, int paramInt)
            throws IOException, he {
        if (!this.a.a()) {
            this.d -= 1;
        }
        if (paramInt > 0) {
            this.a.a(paramhf, this.d);
        }
        for (; ; ) {
            paramhf.a(']');
            return;
            paramhf.a(' ');
        }
    }

    public void c(hf paramhf)
            throws IOException, he {
        paramhf.a(',');
        this.b.a(paramhf, this.d);
    }

    public void d(hf paramhf)
            throws IOException, he {
        if (this.c) {
            paramhf.c(" : ");
            return;
        }
        paramhf.a(':');
    }

    public void e(hf paramhf)
            throws IOException, he {
        if (!this.a.a()) {
            this.d += 1;
        }
        paramhf.a('[');
    }

    public void f(hf paramhf)
            throws IOException, he {
        paramhf.a(',');
        this.a.a(paramhf, this.d);
    }

    public void g(hf paramhf)
            throws IOException, he {
        this.a.a(paramhf, this.d);
    }

    public void h(hf paramhf)
            throws IOException, he {
        this.b.a(paramhf, this.d);
    }

    public static class a
            implements hs {
        public void a(hf paramhf, int paramInt)
                throws IOException, he {
            paramhf.a(' ');
        }

        public boolean a() {
            return true;
        }
    }

    public static class b
            implements hs {
        static final String a;
        static final char[] b;

        static {
            Object localObject1 = null;
            try {
                localObject2 = System.getProperty("line.separator");
                localObject1 = localObject2;
            } catch (Throwable localThrowable) {
                Object localObject2;
                for (; ; ) {
                }
            }
            localObject2 = localObject1;
            if (localObject1 == null) {
                localObject2 = "\n";
            }
            a = (String) localObject2;
            b = new char[64];
            Arrays.fill(b, ' ');
        }

        public void a(hf paramhf, int paramInt)
                throws IOException, he {
            paramhf.c(a);
            paramInt += paramInt;
            while (paramInt > 64) {
                paramhf.b(b, 0, 64);
                paramInt -= b.length;
            }
            paramhf.b(b, 0, paramInt);
        }

        public boolean a() {
            return false;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/sl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */