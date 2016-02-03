package com.flurry.sdk;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class sq
        extends hf {
    protected static final int b = ;
    protected hn c;
    protected int d;
    protected boolean e;
    protected b f;
    protected b g;
    protected int h;
    protected hx i;

    public sq(hn paramhn) {
        this.c = paramhn;
        this.d = b;
        this.i = hx.g();
        paramhn = new b();
        this.g = paramhn;
        this.f = paramhn;
        this.h = 0;
    }

    public hf a() {
        return this;
    }

    public hj a(hj paramhj) {
        a locala = new a(this.f, paramhj.a());
        locala.a(paramhj.h());
        return locala;
    }

    public hj a(hn paramhn) {
        return new a(this.f, paramhn);
    }

    public void a(char paramChar)
            throws IOException, he {
        i();
    }

    public void a(double paramDouble)
            throws IOException, he {
        a(hm.j, Double.valueOf(paramDouble));
    }

    public void a(float paramFloat)
            throws IOException, he {
        a(hm.j, Float.valueOf(paramFloat));
    }

    public void a(long paramLong)
            throws IOException, he {
        a(hm.i, Long.valueOf(paramLong));
    }

    public void a(ha paramha, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
            throws IOException, he {
        paramha = new byte[paramInt2];
        System.arraycopy(paramArrayOfByte, paramInt1, paramha, 0, paramInt2);
        a(paramha);
    }

    public void a(hf paramhf)
            throws IOException, he {
        b localb = this.f;
        int j = -1;
        j += 1;
        if (j >= 16) {
            localb = localb.a();
            if (localb == null) {
                label26:
                return;
            }
            j = 0;
        }
        for (; ; ) {
            Object localObject = localb.a(j);
            if (localObject == null) {
                break label26;
            }
            switch (1. a[localObject.ordinal()])
            {
                default:
                    throw new RuntimeException("Internal error: should never end up through this code path");
                case 1:
                    paramhf.d();
            }
            for (; ; ) {
                break;
                paramhf.e();
                continue;
                paramhf.b();
                continue;
                paramhf.c();
                continue;
                localObject = localb.b(j);
                if ((localObject instanceof hp)) {
                    paramhf.a((hp) localObject);
                } else {
                    paramhf.a((String) localObject);
                    continue;
                    localObject = localb.b(j);
                    if ((localObject instanceof hp)) {
                        paramhf.b((hp) localObject);
                    } else {
                        paramhf.b((String) localObject);
                        continue;
                        localObject = (Number) localb.b(j);
                        if ((localObject instanceof BigInteger)) {
                            paramhf.a((BigInteger) localObject);
                        } else if ((localObject instanceof Long)) {
                            paramhf.a(((Number) localObject).longValue());
                        } else {
                            paramhf.b(((Number) localObject).intValue());
                            continue;
                            localObject = localb.b(j);
                            if ((localObject instanceof BigDecimal)) {
                                paramhf.a((BigDecimal) localObject);
                            } else if ((localObject instanceof Float)) {
                                paramhf.a(((Float) localObject).floatValue());
                            } else if ((localObject instanceof Double)) {
                                paramhf.a(((Double) localObject).doubleValue());
                            } else if (localObject == null) {
                                paramhf.f();
                            } else if ((localObject instanceof String)) {
                                paramhf.e((String) localObject);
                            } else {
                                throw new he("Unrecognized value type for VALUE_NUMBER_FLOAT: " + localObject.getClass().getName() + ", can not serialize");
                                paramhf.a(true);
                                continue;
                                paramhf.a(false);
                                continue;
                                paramhf.f();
                                continue;
                                paramhf.a(localb.b(j));
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(hh paramhh)
            throws IOException, hk {
        a(hm.g, paramhh);
    }

    protected final void a(hm paramhm) {
        paramhm = this.g.a(this.h, paramhm);
        if (paramhm == null) {
            this.h += 1;
            return;
        }
        this.g = paramhm;
        this.h = 1;
    }

    protected final void a(hm paramhm, Object paramObject) {
        paramhm = this.g.a(this.h, paramhm, paramObject);
        if (paramhm == null) {
            this.h += 1;
            return;
        }
        this.g = paramhm;
        this.h = 1;
    }

    public void a(hp paramhp)
            throws IOException, he {
        a(hm.f, paramhp);
        this.i.a(paramhp.a());
    }

    public void a(im paramim)
            throws IOException, he {
        a(hm.f, paramim);
        this.i.a(paramim.a());
    }

    public void a(Object paramObject)
            throws IOException, hk {
        a(hm.g, paramObject);
    }

    public final void a(String paramString)
            throws IOException, he {
        a(hm.f, paramString);
        this.i.a(paramString);
    }

    public void a(BigDecimal paramBigDecimal)
            throws IOException, he {
        if (paramBigDecimal == null) {
            f();
            return;
        }
        a(hm.j, paramBigDecimal);
    }

    public void a(BigInteger paramBigInteger)
            throws IOException, he {
        if (paramBigInteger == null) {
            f();
            return;
        }
        a(hm.i, paramBigInteger);
    }

    public void a(boolean paramBoolean)
            throws IOException, he {
        if (paramBoolean) {
        }
        for (hm localhm = hm.k; ; localhm = hm.l) {
            a(localhm);
            return;
        }
    }

    public void a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws IOException, he {
        b(new String(paramArrayOfChar, paramInt1, paramInt2));
    }

    public final void b()
            throws IOException, he {
        a(hm.d);
        this.i = this.i.h();
    }

    public void b(int paramInt)
            throws IOException, he {
        a(hm.i, Integer.valueOf(paramInt));
    }

    public void b(hj paramhj)
            throws IOException, hk {
        switch (1. a[paramhj.e().ordinal()])
        {
            default:
                throw new RuntimeException("Internal error: should never end up through this code path");
            case 1:
                d();
                return;
            case 2:
                e();
                return;
            case 3:
                b();
                return;
            case 4:
                c();
                return;
            case 5:
                a(paramhj.g());
                return;
            case 6:
                if (paramhj.o()) {
                    a(paramhj.l(), paramhj.n(), paramhj.m());
                    return;
                }
                b(paramhj.k());
                return;
            case 7:
                switch (1. b[paramhj.q().ordinal()])
            {
                default:
                    a(paramhj.u());
                    return;
                case 1:
                    b(paramhj.t());
                    return;
            }
            a(paramhj.v());
            return;
            case 8:
                switch (1. b[paramhj.q().ordinal()])
            {
                default:
                    a(paramhj.x());
                    return;
                case 3:
                    a(paramhj.y());
                    return;
            }
            a(paramhj.w());
            return;
            case 9:
                a(true);
                return;
            case 10:
                a(false);
                return;
            case 11:
                f();
                return;
        }
        a(paramhj.z());
    }

    public void b(hp paramhp)
            throws IOException, he {
        if (paramhp == null) {
            f();
            return;
        }
        a(hm.h, paramhp);
    }

    public void b(String paramString)
            throws IOException, he {
        if (paramString == null) {
            f();
            return;
        }
        a(hm.h, paramString);
    }

    public void b(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws IOException, he {
        i();
    }

    public final void c()
            throws IOException, he {
        a(hm.e);
        hx localhx = this.i.j();
        if (localhx != null) {
            this.i = localhx;
        }
    }

    public void c(hj paramhj)
            throws IOException, hk {
        hm localhm2 = paramhj.e();
        hm localhm1 = localhm2;
        if (localhm2 == hm.f) {
            a(paramhj.g());
            localhm1 = paramhj.b();
        }
        switch (1. a[localhm1.ordinal()])
        {
            case 2:
            default:
                b(paramhj);
                return;
            case 3:
                b();
                while (paramhj.b() != hm.e) {
                    c(paramhj);
                }
                c();
                return;
        }
        d();
        while (paramhj.b() != hm.c) {
            c(paramhj);
        }
        e();
    }

    public void c(String paramString)
            throws IOException, he {
        i();
    }

    public void close()
            throws IOException {
        this.e = true;
    }

    public final void d()
            throws IOException, he {
        a(hm.b);
        this.i = this.i.i();
    }

    public void d(String paramString)
            throws IOException, he {
        i();
    }

    public final void e()
            throws IOException, he {
        a(hm.c);
        hx localhx = this.i.j();
        if (localhx != null) {
            this.i = localhx;
        }
    }

    public void e(String paramString)
            throws IOException, he {
        a(hm.j, paramString);
    }

    public void f()
            throws IOException, he {
        a(hm.m);
    }

    public void g()
            throws IOException {
    }

    public hj h() {
        return a(this.c);
    }

    protected void i() {
        throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[TokenBuffer: ");
        hj localhj = h();
        int j = 0;
        for (; ; ) {
            hm localhm;
            try {
                localhm = localhj.b();
                if (localhm == null) {
                    if (j >= 100) {
                        localStringBuilder.append(" ... (truncated ").append(j - 100).append(" entries)");
                    }
                    localStringBuilder.append(']');
                    return localStringBuilder.toString();
                }
            } catch (IOException localIOException) {
                throw new IllegalStateException(localIOException);
            }
            if (j < 100) {
                if (j > 0) {
                    localIOException.append(", ");
                }
                localIOException.append(localhm.toString());
            }
            j += 1;
        }
    }

    public static final class a
            extends hv {
        protected hn d;
        protected sq.b e;
        protected int f;
        protected hw g;
        protected boolean h;
        protected transient sj i;
        protected hg j = null;

        public a(sq.b paramb, hn paramhn) {
            super();
            this.e = paramb;
            this.f = -1;
            this.d = paramhn;
            this.g = hw.a(-1, -1);
        }

        protected final Object A() {
            return this.e.b(this.f);
        }

        protected final void B()
                throws hi {
            if ((this.b == null) || (!this.b.c())) {
                throw a("Current token (" + this.b + ") not numeric, can not use numeric value accessors");
            }
        }

        protected void H()
                throws hi {
            U();
        }

        public hn a() {
            return this.d;
        }

        public void a(hg paramhg) {
            this.j = paramhg;
        }

        public byte[] a(ha paramha)
                throws IOException, hi {
            if (this.b == hm.g) {
                localObject = A();
                if ((localObject instanceof byte[])) {
                    return (byte[]) localObject;
                }
            }
            if (this.b != hm.h) {
                throw a("Current token (" + this.b + ") not VALUE_STRING (or VALUE_EMBEDDED_OBJECT with byte[]), can not access as binary");
            }
            String str = k();
            if (str == null) {
                return null;
            }
            Object localObject = this.i;
            if (localObject == null) {
                localObject = new sj(100);
                this.i = ((sj) localObject);
            }
            for (; ; ) {
                a(str, (sj) localObject, paramha);
                return ((sj) localObject).b();
                this.i.a();
            }
        }

        public hm b()
                throws IOException, hi {
            if ((this.h) || (this.e == null)) {
            }
            do {
                return null;
                int k = this.f + 1;
                this.f = k;
                if (k < 16) {
                    break;
                }
                this.f = 0;
                this.e = this.e.a();
            } while (this.e == null);
            this.b = this.e.a(this.f);
            Object localObject;
            if (this.b == hm.f) {
                localObject = A();
                if ((localObject instanceof String)) {
                    localObject = (String) localObject;
                    this.g.a((String) localObject);
                }
            }
            for (; ; ) {
                return this.b;
                localObject = localObject.toString();
                break;
                if (this.b == hm.b) {
                    this.g = this.g.c(-1, -1);
                } else if (this.b == hm.d) {
                    this.g = this.g.b(-1, -1);
                } else if ((this.b == hm.c) || (this.b == hm.e)) {
                    this.g = this.g.i();
                    if (this.g == null) {
                        this.g = hw.a(-1, -1);
                    }
                }
            }
        }

        public void close()
                throws IOException {
            if (!this.h) {
                this.h = true;
            }
        }

        public String g() {
            return this.g.h();
        }

        public hg h() {
            return i();
        }

        public hg i() {
            if (this.j == null) {
                return hg.a;
            }
            return this.j;
        }

        public String k() {
            Object localObject2 = null;
            Object localObject1;
            if ((this.b == hm.h) || (this.b == hm.f)) {
                localObject1 = A();
                if ((localObject1 instanceof String)) {
                    localObject1 = (String) localObject1;
                }
            }
            Object localObject3;
            do {
                do {
                    return (String) localObject1;
                    if (localObject1 == null) {
                    }
                    for (localObject1 = null; ; localObject1 = localObject1.toString()) {
                        return (String) localObject1;
                    }
                    localObject1 = localObject2;
                } while (this.b == null);
                switch (sq .1.a[this.b.ordinal()])
                {
                    default:
                        return this.b.a();
                }
                localObject3 = A();
                localObject1 = localObject2;
            } while (localObject3 == null);
            return localObject3.toString();
        }

        public char[] l() {
            String str = k();
            if (str == null) {
                return null;
            }
            return str.toCharArray();
        }

        public int m() {
            String str = k();
            if (str == null) {
                return 0;
            }
            return str.length();
        }

        public int n() {
            return 0;
        }

        public boolean o() {
            return false;
        }

        public final Number p()
                throws IOException, hi {
            B();
            return (Number) A();
        }

        public hj.b q()
                throws IOException, hi {
            Number localNumber = p();
            if ((localNumber instanceof Integer)) {
                return hj.b.a;
            }
            if ((localNumber instanceof Long)) {
                return hj.b.b;
            }
            if ((localNumber instanceof Double)) {
                return hj.b.e;
            }
            if ((localNumber instanceof BigDecimal)) {
                return hj.b.f;
            }
            if ((localNumber instanceof Float)) {
                return hj.b.d;
            }
            if ((localNumber instanceof BigInteger)) {
                return hj.b.c;
            }
            return null;
        }

        public int t()
                throws IOException, hi {
            if (this.b == hm.i) {
                return ((Number) A()).intValue();
            }
            return p().intValue();
        }

        public long u()
                throws IOException, hi {
            return p().longValue();
        }

        public BigInteger v()
                throws IOException, hi {
            Number localNumber = p();
            if ((localNumber instanceof BigInteger)) {
                return (BigInteger) localNumber;
            }
            switch (sq .1.b[q().ordinal()])
            {
                default:
                    return BigInteger.valueOf(localNumber.longValue());
            }
            return ((BigDecimal) localNumber).toBigInteger();
        }

        public float w()
                throws IOException, hi {
            return p().floatValue();
        }

        public double x()
                throws IOException, hi {
            return p().doubleValue();
        }

        public BigDecimal y()
                throws IOException, hi {
            Number localNumber = p();
            if ((localNumber instanceof BigDecimal)) {
                return (BigDecimal) localNumber;
            }
            switch (sq .1.b[q().ordinal()])
            {
                case 3:
                case 4:
                default:
                    return BigDecimal.valueOf(localNumber.doubleValue());
                case 1:
                case 5:
                    return BigDecimal.valueOf(localNumber.longValue());
            }
            return new BigDecimal((BigInteger) localNumber);
        }

        public Object z() {
            if (this.b == hm.g) {
                return A();
            }
            return null;
        }
    }

    public static final class b {
        private static final hm[] d = new hm[16];
        protected b a;
        protected long b;
        protected final Object[] c = new Object[16];

        static {
            hm[] arrayOfhm = hm.values();
            System.arraycopy(arrayOfhm, 1, d, 1, Math.min(15, arrayOfhm.length - 1));
        }

        public hm a(int paramInt) {
            long l2 = this.b;
            long l1 = l2;
            if (paramInt > 0) {
                l1 = l2 >> (paramInt << 2);
            }
            paramInt = (int) l1;
            return d[(paramInt & 0xF)];
        }

        public b a() {
            return this.a;
        }

        public b a(int paramInt, hm paramhm) {
            if (paramInt < 16) {
                b(paramInt, paramhm);
                return null;
            }
            this.a = new b();
            this.a.b(0, paramhm);
            return this.a;
        }

        public b a(int paramInt, hm paramhm, Object paramObject) {
            if (paramInt < 16) {
                b(paramInt, paramhm, paramObject);
                return null;
            }
            this.a = new b();
            this.a.b(0, paramhm, paramObject);
            return this.a;
        }

        public Object b(int paramInt) {
            return this.c[paramInt];
        }

        public void b(int paramInt, hm paramhm) {
            long l2 = paramhm.ordinal();
            long l1 = l2;
            if (paramInt > 0) {
                l1 = l2 << (paramInt << 2);
            }
            this.b = (l1 | this.b);
        }

        public void b(int paramInt, hm paramhm, Object paramObject) {
            this.c[paramInt] = paramObject;
            long l2 = paramhm.ordinal();
            long l1 = l2;
            if (paramInt > 0) {
                l1 = l2 << (paramInt << 2);
            }
            this.b = (l1 | this.b);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/sq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */