package com.flurry.sdk;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public abstract class ma
        extends jl {
    protected final Class<?> a;

    protected ma(Class<?> paramClass) {
        this.a = paramClass;
    }

    protected int a(String paramString)
            throws IllegalArgumentException {
        return Integer.parseInt(paramString);
    }

    public Class<?> a() {
        return this.a;
    }

    public final Object a(String paramString, iz paramiz)
            throws IOException, hk {
        Object localObject1;
        if (paramString == null) {
            localObject1 = null;
        }
        for (; ; ) {
            return localObject1;
            try {
                Object localObject2 = b(paramString, paramiz);
                localObject1 = localObject2;
                if (localObject2 != null) {
                    continue;
                }
                throw paramiz.a(this.a, paramString, "not a valid representation");
            } catch (Exception localException) {
                throw paramiz.a(this.a, paramString, "not a valid representation: " + localException.getMessage());
            }
        }
    }

    protected long b(String paramString)
            throws IllegalArgumentException {
        return Long.parseLong(paramString);
    }

    protected abstract Object b(String paramString, iz paramiz)
            throws Exception;

    protected double c(String paramString)
            throws IllegalArgumentException {
        return ii.c(paramString);
    }

    static final class a
            extends ma {
        a() {
            super();
        }

        public Boolean c(String paramString, iz paramiz)
                throws jh {
            if ("true".equals(paramString)) {
                return Boolean.TRUE;
            }
            if ("false".equals(paramString)) {
                return Boolean.FALSE;
            }
            throw paramiz.a(this.a, paramString, "value not 'true' or 'false'");
        }
    }

    static final class b
            extends ma {
        b() {
            super();
        }

        public Byte c(String paramString, iz paramiz)
                throws jh {
            int i = a(paramString);
            if ((i < -128) || (i > 127)) {
                throw paramiz.a(this.a, paramString, "overflow, value can not be represented as 8-bit value");
            }
            return Byte.valueOf((byte) i);
        }
    }

    static final class c
            extends ma {
        protected c() {
            super();
        }

        public Calendar c(String paramString, iz paramiz)
                throws IllegalArgumentException, jh {
            paramString = paramiz.a(paramString);
            if (paramString == null) {
                return null;
            }
            return paramiz.a(paramString);
        }
    }

    static final class d
            extends ma {
        d() {
            super();
        }

        public Character c(String paramString, iz paramiz)
                throws jh {
            if (paramString.length() == 1) {
                return Character.valueOf(paramString.charAt(0));
            }
            throw paramiz.a(this.a, paramString, "can only convert 1-character Strings");
        }
    }

    static final class e
            extends ma {
        protected e() {
            super();
        }

        public Date c(String paramString, iz paramiz)
                throws IllegalArgumentException, jh {
            return paramiz.a(paramString);
        }
    }

    static final class f
            extends ma {
        f() {
            super();
        }

        public Double c(String paramString, iz paramiz)
                throws jh {
            return Double.valueOf(c(paramString));
        }
    }

    static final class g
            extends ma {
        protected final ra<?> b;
        protected final mr c;

        protected g(ra<?> paramra, mr parammr) {
            super();
            this.b = paramra;
            this.c = parammr;
        }

        public Object b(String paramString, iz paramiz)
                throws jh {
            if (this.c != null) {
            }
            Enum localEnum;
            do {
                try {
                    Object localObject1 = this.c.a(paramString);
                    return localObject1;
                } catch (Exception localException) {
                    qy.c(localException);
                }
                localEnum = this.b.a(paramString);
                Object localObject2 = localEnum;
            } while (localEnum != null);
            throw paramiz.a(this.a, paramString, "not one of values for Enum class");
        }
    }

    static final class h
            extends ma {
        h() {
            super();
        }

        public Float c(String paramString, iz paramiz)
                throws jh {
            return Float.valueOf((float) c(paramString));
        }
    }

    static final class i
            extends ma {
        i() {
            super();
        }

        public Integer c(String paramString, iz paramiz)
                throws jh {
            return Integer.valueOf(a(paramString));
        }
    }

    static final class j
            extends ma {
        j() {
            super();
        }

        public Long c(String paramString, iz paramiz)
                throws jh {
            return Long.valueOf(b(paramString));
        }
    }

    static final class k
            extends ma {
        k() {
            super();
        }

        public Short c(String paramString, iz paramiz)
                throws jh {
            int i = a(paramString);
            if ((i < 32768) || (i > 32767)) {
                throw paramiz.a(this.a, paramString, "overflow, value can not be represented as 16-bit value");
            }
            return Short.valueOf((short) i);
        }
    }

    static final class l
            extends ma {
        protected final Constructor<?> b;

        public l(Constructor<?> paramConstructor) {
            super();
            this.b = paramConstructor;
        }

        public Object b(String paramString, iz paramiz)
                throws Exception {
            return this.b.newInstance(new Object[]{paramString});
        }
    }

    static final class m
            extends ma {
        final Method b;

        public m(Method paramMethod) {
            super();
            this.b = paramMethod;
        }

        public Object b(String paramString, iz paramiz)
                throws Exception {
            return this.b.invoke(null, new Object[]{paramString});
        }
    }

    static final class n
            extends ma {
        private static final n b = new n(String.class);
        private static final n c = new n(Object.class);

        private n(Class<?> paramClass) {
            super();
        }

        public static n a(Class<?> paramClass) {
            if (paramClass == String.class) {
                return b;
            }
            if (paramClass == Object.class) {
                return c;
            }
            return new n(paramClass);
        }

        public String c(String paramString, iz paramiz)
                throws jh {
            return paramString;
        }
    }

    static final class o
            extends ma {
        protected o() {
            super();
        }

        public UUID c(String paramString, iz paramiz)
                throws IllegalArgumentException, jh {
            return UUID.fromString(paramString);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ma.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */