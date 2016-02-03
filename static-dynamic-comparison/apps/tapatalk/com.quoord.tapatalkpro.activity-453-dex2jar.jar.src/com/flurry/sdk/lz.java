package com.flurry.sdk;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class lz<T>
        extends jg<T> {
    protected final Class<?> q;

    protected lz(sh paramsh) {
        if (paramsh == null) {
        }
        for (paramsh = null; ; paramsh = paramsh.p()) {
            this.q = paramsh;
            return;
        }
    }

    protected lz(Class<?> paramClass) {
        this.q = paramClass;
    }

    protected static final double b(String paramString)
            throws NumberFormatException {
        if ("2.2250738585072012e-308".equals(paramString)) {
            return 2.2250738585072014E-308D;
        }
        return Double.parseDouble(paramString);
    }

    protected final double A(hj paramhj, iz paramiz)
            throws IOException, hk {
        double d = 0.0D;
        hm localhm = paramhj.e();
        if ((localhm == hm.i) || (localhm == hm.j)) {
            d = paramhj.x();
        }
        do {
            do {
                return d;
                if (localhm != hm.h) {
                    break;
                }
                paramhj = paramhj.k().trim();
            } while (paramhj.length() == 0);
            switch (paramhj.charAt(0)) {
            }
            for (; ; ) {
                try {
                    d = b(paramhj);
                    return d;
                } catch (IllegalArgumentException paramhj) {
                    throw paramiz.b(this.q, "not a valid double value");
                }
                if (("Infinity".equals(paramhj)) || ("INF".equals(paramhj))) {
                    return Double.POSITIVE_INFINITY;
                    if ("NaN".equals(paramhj)) {
                        return NaN .0D;
                        if (("-Infinity".equals(paramhj)) || ("-INF".equals(paramhj))) {
                            return Double.NEGATIVE_INFINITY;
                        }
                    }
                }
            }
        } while (localhm == hm.m);
        throw paramiz.a(this.q, localhm);
    }

    protected java.util.Date B(hj paramhj, iz paramiz)
            throws IOException, hk {
        hm localhm = paramhj.e();
        if (localhm == hm.i) {
            return new java.util.Date(paramhj.u());
        }
        if (localhm == hm.m) {
            return (java.util.Date) b();
        }
        if (localhm == hm.h) {
            try {
                paramhj = paramhj.k().trim();
                if (paramhj.length() == 0) {
                    return (java.util.Date) c();
                }
                paramhj = paramiz.a(paramhj);
                return paramhj;
            } catch (IllegalArgumentException paramhj) {
                throw paramiz.b(this.q, "not a valid representation (error: " + paramhj.getMessage() + ")");
            }
        }
        throw paramiz.a(this.q, localhm);
    }

    protected jg<Object> a(iy paramiy, jc paramjc, sh paramsh, is paramis)
            throws jh {
        return paramjc.a(paramiy, paramsh, paramis);
    }

    public Object a(hj paramhj, iz paramiz, jy paramjy)
            throws IOException, hk {
        return paramjy.d(paramhj, paramiz);
    }

    protected void a(hj paramhj, iz paramiz, Object paramObject, String paramString)
            throws IOException, hk {
        Object localObject = paramObject;
        if (paramObject == null) {
            localObject = f();
        }
        if (paramiz.a(paramhj, this, localObject, paramString)) {
            return;
        }
        a(paramiz, localObject, paramString);
        paramhj.d();
    }

    protected void a(iz paramiz, Object paramObject, String paramString)
            throws IOException, hk {
        if (paramiz.a(iy.a.k)) {
            throw paramiz.a(paramObject, paramString);
        }
    }

    protected boolean a(jg<?> paramjg) {
        return (paramjg != null) && (paramjg.getClass().getAnnotation(kb.class) != null);
    }

    public Class<?> f() {
        return this.q;
    }

    protected final boolean n(hj paramhj, iz paramiz)
            throws IOException, hk {
        hm localhm = paramhj.e();
        if (localhm == hm.k) {
        }
        label65:
        do {
            do {
                return true;
                if (localhm == hm.l) {
                    return false;
                }
                if (localhm == hm.m) {
                    return false;
                }
                if (localhm != hm.i) {
                    break label65;
                }
                if (paramhj.q() != hj.b.a) {
                    break;
                }
            } while (paramhj.t() != 0);
            return false;
            return p(paramhj, paramiz);
            if (localhm != hm.h) {
                break;
            }
            paramhj = paramhj.k().trim();
        } while ("true".equals(paramhj));
        if (("false".equals(paramhj)) || (paramhj.length() == 0)) {
            return Boolean.FALSE.booleanValue();
        }
        throw paramiz.b(this.q, "only \"true\" or \"false\" recognized");
        throw paramiz.a(this.q, localhm);
    }

    protected final Boolean o(hj paramhj, iz paramiz)
            throws IOException, hk {
        hm localhm = paramhj.e();
        if (localhm == hm.k) {
            return Boolean.TRUE;
        }
        if (localhm == hm.l) {
            return Boolean.FALSE;
        }
        if (localhm == hm.i) {
            if (paramhj.q() == hj.b.a) {
                if (paramhj.t() == 0) {
                    return Boolean.FALSE;
                }
                return Boolean.TRUE;
            }
            return Boolean.valueOf(p(paramhj, paramiz));
        }
        if (localhm == hm.m) {
            return (Boolean) b();
        }
        if (localhm == hm.h) {
            paramhj = paramhj.k().trim();
            if ("true".equals(paramhj)) {
                return Boolean.TRUE;
            }
            if ("false".equals(paramhj)) {
                return Boolean.FALSE;
            }
            if (paramhj.length() == 0) {
                return (Boolean) c();
            }
            throw paramiz.b(this.q, "only \"true\" or \"false\" recognized");
        }
        throw paramiz.a(this.q, localhm);
    }

    protected final boolean p(hj paramhj, iz paramiz)
            throws IOException, hk {
        if (paramhj.q() == hj.b.b) {
            if (paramhj.u() == 0L) {
            }
            for (paramhj = Boolean.FALSE; ; paramhj = Boolean.TRUE) {
                return paramhj.booleanValue();
            }
        }
        paramhj = paramhj.k();
        if (("0.0".equals(paramhj)) || ("0".equals(paramhj))) {
            return Boolean.FALSE.booleanValue();
        }
        return Boolean.TRUE.booleanValue();
    }

    protected Byte q(hj paramhj, iz paramiz)
            throws IOException, hk {
        hm localhm = paramhj.e();
        if ((localhm == hm.i) || (localhm == hm.j)) {
            return Byte.valueOf(paramhj.r());
        }
        if (localhm == hm.h) {
            paramhj = paramhj.k().trim();
            int i;
            try {
                if (paramhj.length() == 0) {
                    return (Byte) c();
                }
                i = ii.a(paramhj);
                if ((i < -128) || (i > 127)) {
                    throw paramiz.b(this.q, "overflow, value can not be represented as 8-bit value");
                }
            } catch (IllegalArgumentException paramhj) {
                throw paramiz.b(this.q, "not a valid Byte value");
            }
            return Byte.valueOf((byte) i);
        }
        if (localhm == hm.m) {
            return (Byte) b();
        }
        throw paramiz.a(this.q, localhm);
    }

    protected Short r(hj paramhj, iz paramiz)
            throws IOException, hk {
        hm localhm = paramhj.e();
        if ((localhm == hm.i) || (localhm == hm.j)) {
            return Short.valueOf(paramhj.s());
        }
        if (localhm == hm.h) {
            paramhj = paramhj.k().trim();
            int i;
            try {
                if (paramhj.length() == 0) {
                    return (Short) c();
                }
                i = ii.a(paramhj);
                if ((i < 32768) || (i > 32767)) {
                    throw paramiz.b(this.q, "overflow, value can not be represented as 16-bit value");
                }
            } catch (IllegalArgumentException paramhj) {
                throw paramiz.b(this.q, "not a valid Short value");
            }
            return Short.valueOf((short) i);
        }
        if (localhm == hm.m) {
            return (Short) b();
        }
        throw paramiz.a(this.q, localhm);
    }

    protected final short s(hj paramhj, iz paramiz)
            throws IOException, hk {
        int i = t(paramhj, paramiz);
        if ((i < 32768) || (i > 32767)) {
            throw paramiz.b(this.q, "overflow, value can not be represented as 16-bit value");
        }
        return (short) i;
    }

    protected final int t(hj paramhj, iz paramiz)
            throws IOException, hk {
        int i = 0;
        hm localhm = paramhj.e();
        if ((localhm == hm.i) || (localhm == hm.j)) {
            i = paramhj.t();
        }
        do {
            int j;
            do {
                return i;
                if (localhm != hm.h) {
                    break;
                }
                paramhj = paramhj.k().trim();
                long l;
                try {
                    j = paramhj.length();
                    if (j <= 9) {
                        continue;
                    }
                    l = Long.parseLong(paramhj);
                    if ((l < -2147483648L) || (l > 2147483647L)) {
                        throw paramiz.b(this.q, "Overflow: numeric value (" + paramhj + ") out of range of int (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
                    }
                } catch (IllegalArgumentException paramhj) {
                    throw paramiz.b(this.q, "not a valid int value");
                }
                return (int) l;
            } while (j == 0);
            i = ii.a(paramhj);
            return i;
        } while (localhm == hm.m);
        throw paramiz.a(this.q, localhm);
    }

    protected final Integer u(hj paramhj, iz paramiz)
            throws IOException, hk {
        hm localhm = paramhj.e();
        if ((localhm == hm.i) || (localhm == hm.j)) {
            return Integer.valueOf(paramhj.t());
        }
        if (localhm == hm.h) {
            paramhj = paramhj.k().trim();
            long l;
            try {
                i = paramhj.length();
                if (i <= 9) {
                    break label161;
                }
                l = Long.parseLong(paramhj);
                if ((l < -2147483648L) || (l > 2147483647L)) {
                    throw paramiz.b(this.q, "Overflow: numeric value (" + paramhj + ") out of range of Integer (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
                }
            } catch (IllegalArgumentException paramhj) {
                throw paramiz.b(this.q, "not a valid Integer value");
            }
            int i = (int) l;
            return Integer.valueOf(i);
            label161:
            if (i == 0) {
                return (Integer) c();
            }
            i = ii.a(paramhj);
            return Integer.valueOf(i);
        }
        if (localhm == hm.m) {
            return (Integer) b();
        }
        throw paramiz.a(this.q, localhm);
    }

    protected final Long v(hj paramhj, iz paramiz)
            throws IOException, hk {
        hm localhm = paramhj.e();
        if ((localhm == hm.i) || (localhm == hm.j)) {
            return Long.valueOf(paramhj.u());
        }
        if (localhm == hm.h) {
            paramhj = paramhj.k().trim();
            if (paramhj.length() == 0) {
                return (Long) c();
            }
            try {
                long l = ii.b(paramhj);
                return Long.valueOf(l);
            } catch (IllegalArgumentException paramhj) {
                throw paramiz.b(this.q, "not a valid Long value");
            }
        }
        if (localhm == hm.m) {
            return (Long) b();
        }
        throw paramiz.a(this.q, localhm);
    }

    protected final long w(hj paramhj, iz paramiz)
            throws IOException, hk {
        long l = 0L;
        hm localhm = paramhj.e();
        if ((localhm == hm.i) || (localhm == hm.j)) {
            l = paramhj.u();
        }
        do {
            do {
                return l;
                if (localhm != hm.h) {
                    break;
                }
                paramhj = paramhj.k().trim();
            } while (paramhj.length() == 0);
            try {
                l = ii.b(paramhj);
                return l;
            } catch (IllegalArgumentException paramhj) {
                throw paramiz.b(this.q, "not a valid long value");
            }
        } while (localhm == hm.m);
        throw paramiz.a(this.q, localhm);
    }

    protected final Float x(hj paramhj, iz paramiz)
            throws IOException, hk {
        hm localhm = paramhj.e();
        if ((localhm == hm.i) || (localhm == hm.j)) {
            return Float.valueOf(paramhj.w());
        }
        if (localhm == hm.h) {
            paramhj = paramhj.k().trim();
            if (paramhj.length() == 0) {
                return (Float) c();
            }
            switch (paramhj.charAt(0)) {
            }
            for (; ; ) {
                try {
                    float f = Float.parseFloat(paramhj);
                    return Float.valueOf(f);
                } catch (IllegalArgumentException paramhj) {
                    throw paramiz.b(this.q, "not a valid Float value");
                }
                if (("Infinity".equals(paramhj)) || ("INF".equals(paramhj))) {
                    return Float.valueOf(Float.POSITIVE_INFINITY);
                    if ("NaN".equals(paramhj)) {
                        return Float.valueOf(NaN .0F);
                        if (("-Infinity".equals(paramhj)) || ("-INF".equals(paramhj))) {
                            return Float.valueOf(Float.NEGATIVE_INFINITY);
                        }
                    }
                }
            }
        }
        if (localhm == hm.m) {
            return (Float) b();
        }
        throw paramiz.a(this.q, localhm);
    }

    protected final float y(hj paramhj, iz paramiz)
            throws IOException, hk {
        float f = 0.0F;
        hm localhm = paramhj.e();
        if ((localhm == hm.i) || (localhm == hm.j)) {
            f = paramhj.w();
        }
        do {
            do {
                return f;
                if (localhm != hm.h) {
                    break;
                }
                paramhj = paramhj.k().trim();
            } while (paramhj.length() == 0);
            switch (paramhj.charAt(0)) {
            }
            for (; ; ) {
                try {
                    f = Float.parseFloat(paramhj);
                    return f;
                } catch (IllegalArgumentException paramhj) {
                    throw paramiz.b(this.q, "not a valid float value");
                }
                if (("Infinity".equals(paramhj)) || ("INF".equals(paramhj))) {
                    return Float.POSITIVE_INFINITY;
                    if ("NaN".equals(paramhj)) {
                        return NaN .0F;
                        if (("-Infinity".equals(paramhj)) || ("-INF".equals(paramhj))) {
                            return Float.NEGATIVE_INFINITY;
                        }
                    }
                }
            }
        } while (localhm == hm.m);
        throw paramiz.a(this.q, localhm);
    }

    protected final Double z(hj paramhj, iz paramiz)
            throws IOException, hk {
        hm localhm = paramhj.e();
        if ((localhm == hm.i) || (localhm == hm.j)) {
            return Double.valueOf(paramhj.x());
        }
        if (localhm == hm.h) {
            paramhj = paramhj.k().trim();
            if (paramhj.length() == 0) {
                return (Double) c();
            }
            switch (paramhj.charAt(0)) {
            }
            for (; ; ) {
                try {
                    double d = b(paramhj);
                    return Double.valueOf(d);
                } catch (IllegalArgumentException paramhj) {
                    throw paramiz.b(this.q, "not a valid Double value");
                }
                if (("Infinity".equals(paramhj)) || ("INF".equals(paramhj))) {
                    return Double.valueOf(Double.POSITIVE_INFINITY);
                    if ("NaN".equals(paramhj)) {
                        return Double.valueOf(NaN .0D);
                        if (("-Infinity".equals(paramhj)) || ("-INF".equals(paramhj))) {
                            return Double.valueOf(Double.NEGATIVE_INFINITY);
                        }
                    }
                }
            }
        }
        if (localhm == hm.m) {
            return (Double) b();
        }
        throw paramiz.a(this.q, localhm);
    }

    @kb
    public static class a
            extends mc<BigDecimal> {
        public a() {
            super();
        }

        public BigDecimal b(hj paramhj, iz paramiz)
                throws IOException, hk {
            hm localhm = paramhj.e();
            if ((localhm == hm.i) || (localhm == hm.j)) {
                return paramhj.y();
            }
            if (localhm == hm.h) {
                paramhj = paramhj.k().trim();
                if (paramhj.length() == 0) {
                    return null;
                }
                try {
                    paramhj = new BigDecimal(paramhj);
                    return paramhj;
                } catch (IllegalArgumentException paramhj) {
                    throw paramiz.b(this.q, "not a valid representation");
                }
            }
            throw paramiz.a(this.q, localhm);
        }
    }

    @kb
    public static class b
            extends mc<BigInteger> {
        public b() {
            super();
        }

        public BigInteger b(hj paramhj, iz paramiz)
                throws IOException, hk {
            hm localhm = paramhj.e();
            if (localhm == hm.i) {
                switch (lz .1.b[paramhj.q().ordinal()])
                {
                }
            }
            do {
                paramhj = paramhj.k().trim();
                if (paramhj.length() != 0) {
                    break;
                }
                return null;
                return BigInteger.valueOf(paramhj.u());
                if (localhm == hm.j) {
                    return paramhj.y().toBigInteger();
                }
            } while (localhm == hm.h);
            throw paramiz.a(this.q, localhm);
            try {
                paramhj = new BigInteger(paramhj);
                return paramhj;
            } catch (IllegalArgumentException paramhj) {
                throw paramiz.b(this.q, "not a valid representation");
            }
        }
    }

    @kb
    public static final class c
            extends lz.k<Boolean> {
        public c(Class<Boolean> paramClass, Boolean paramBoolean) {
            super(paramBoolean);
        }

        public Boolean b(hj paramhj, iz paramiz)
                throws IOException, hk {
            return o(paramhj, paramiz);
        }

        public Boolean b(hj paramhj, iz paramiz, jy paramjy)
                throws IOException, hk {
            return o(paramhj, paramiz);
        }
    }

    @kb
    public static final class d
            extends lz.k<Byte> {
        public d(Class<Byte> paramClass, Byte paramByte) {
            super(paramByte);
        }

        public Byte b(hj paramhj, iz paramiz)
                throws IOException, hk {
            return q(paramhj, paramiz);
        }
    }

    @kb
    public static final class e
            extends lz.k<Character> {
        public e(Class<Character> paramClass, Character paramCharacter) {
            super(paramCharacter);
        }

        public Character b(hj paramhj, iz paramiz)
                throws IOException, hk {
            hm localhm = paramhj.e();
            if (localhm == hm.i) {
                int i = paramhj.t();
                if ((i >= 0) && (i <= 65535)) {
                    return Character.valueOf((char) i);
                }
            } else if (localhm == hm.h) {
                paramhj = paramhj.k();
                if (paramhj.length() == 1) {
                    return Character.valueOf(paramhj.charAt(0));
                }
                if (paramhj.length() == 0) {
                    return (Character) c();
                }
            }
            throw paramiz.a(this.q, localhm);
        }
    }

    @kb
    public static final class f
            extends lz.k<Double> {
        public f(Class<Double> paramClass, Double paramDouble) {
            super(paramDouble);
        }

        public Double b(hj paramhj, iz paramiz)
                throws IOException, hk {
            return z(paramhj, paramiz);
        }

        public Double b(hj paramhj, iz paramiz, jy paramjy)
                throws IOException, hk {
            return z(paramhj, paramiz);
        }
    }

    @kb
    public static final class g
            extends lz.k<Float> {
        public g(Class<Float> paramClass, Float paramFloat) {
            super(paramFloat);
        }

        public Float b(hj paramhj, iz paramiz)
                throws IOException, hk {
            return x(paramhj, paramiz);
        }
    }

    @kb
    public static final class h
            extends lz.k<Integer> {
        public h(Class<Integer> paramClass, Integer paramInteger) {
            super(paramInteger);
        }

        public Integer b(hj paramhj, iz paramiz)
                throws IOException, hk {
            return u(paramhj, paramiz);
        }

        public Integer b(hj paramhj, iz paramiz, jy paramjy)
                throws IOException, hk {
            return u(paramhj, paramiz);
        }
    }

    @kb
    public static final class i
            extends lz.k<Long> {
        public i(Class<Long> paramClass, Long paramLong) {
            super(paramLong);
        }

        public Long b(hj paramhj, iz paramiz)
                throws IOException, hk {
            return v(paramhj, paramiz);
        }
    }

    @kb
    public static final class j
            extends mc<Number> {
        public j() {
            super();
        }

        public Object a(hj paramhj, iz paramiz, jy paramjy)
                throws IOException, hk {
            switch (lz .1.a[paramhj.e().ordinal()])
            {
                default:
                    return paramjy.c(paramhj, paramiz);
            }
            return b(paramhj, paramiz);
        }

        public Number b(hj paramhj, iz paramiz)
                throws IOException, hk {
            hm localhm = paramhj.e();
            if (localhm == hm.i) {
                if (paramiz.a(iy.a.h)) {
                    return paramhj.v();
                }
                return paramhj.p();
            }
            if (localhm == hm.j) {
                if (paramiz.a(iy.a.g)) {
                    return paramhj.y();
                }
                return Double.valueOf(paramhj.x());
            }
            if (localhm == hm.h) {
                paramhj = paramhj.k().trim();
                try {
                    if (paramhj.indexOf('.') < 0) {
                        break label132;
                    }
                    if (paramiz.a(iy.a.g)) {
                        paramhj = new BigDecimal(paramhj);
                        return paramhj;
                    }
                } catch (IllegalArgumentException paramhj) {
                    throw paramiz.b(this.q, "not a valid number");
                }
                return new Double(paramhj);
                label132:
                if (paramiz.a(iy.a.h)) {
                    return new BigInteger(paramhj);
                }
                long l = Long.parseLong(paramhj);
                if ((l <= 2147483647L) && (l >= -2147483648L)) {
                    return Integer.valueOf((int) l);
                }
                return Long.valueOf(l);
            }
            throw paramiz.a(this.q, localhm);
        }
    }

    public static abstract class k<T>
            extends mc<T> {
        final T a;

        protected k(Class<T> paramClass, T paramT) {
            super();
            this.a = paramT;
        }

        public final T b() {
            return (T) this.a;
        }
    }

    @kb
    public static final class l
            extends lz.k<Short> {
        public l(Class<Short> paramClass, Short paramShort) {
            super(paramShort);
        }

        public Short b(hj paramhj, iz paramiz)
                throws IOException, hk {
            return r(paramhj, paramiz);
        }
    }

    public static class m
            extends mc<java.sql.Date> {
        public m() {
            super();
        }

        public java.sql.Date b(hj paramhj, iz paramiz)
                throws IOException, hk {
            paramhj = B(paramhj, paramiz);
            if (paramhj == null) {
                return null;
            }
            return new java.sql.Date(paramhj.getTime());
        }
    }

    public static class n
            extends mc<StackTraceElement> {
        public n() {
            super();
        }

        public StackTraceElement b(hj paramhj, iz paramiz)
                throws IOException, hk {
            Object localObject = paramhj.e();
            if (localObject == hm.b) {
                localObject = "";
                String str1 = "";
                String str2 = "";
                int i = -1;
                for (; ; ) {
                    hm localhm = paramhj.c();
                    if (localhm == hm.c) {
                        break;
                    }
                    String str3 = paramhj.g();
                    if ("className".equals(str3)) {
                        localObject = paramhj.k();
                    } else if ("fileName".equals(str3)) {
                        str2 = paramhj.k();
                    } else if ("lineNumber".equals(str3)) {
                        if (localhm.c()) {
                            i = paramhj.t();
                        } else {
                            throw jh.a(paramhj, "Non-numeric token (" + localhm + ") for property 'lineNumber'");
                        }
                    } else if ("methodName".equals(str3)) {
                        str1 = paramhj.k();
                    } else if (!"nativeMethod".equals(str3)) {
                        a(paramhj, paramiz, this.q, str3);
                    }
                }
                return new StackTraceElement((String) localObject, str1, str2, i);
            }
            throw paramiz.a(this.q, (hm) localObject);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/lz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */