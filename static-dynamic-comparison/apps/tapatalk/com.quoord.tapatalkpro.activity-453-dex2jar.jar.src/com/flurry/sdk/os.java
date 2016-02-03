package com.flurry.sdk;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;

public class os {
    @kb
    public static final class a
            extends pp<Boolean> {
        final boolean a;

        public a(boolean paramBoolean) {
            super();
            this.a = paramBoolean;
        }

        public void a(Boolean paramBoolean, hf paramhf, jw paramjw)
                throws IOException, he {
            paramhf.a(paramBoolean.booleanValue());
        }
    }

    @kb
    public static final class b
            extends pp<Double> {
        static final b a = new b();

        public b() {
            super();
        }

        public void a(Double paramDouble, hf paramhf, jw paramjw)
                throws IOException, he {
            paramhf.a(paramDouble.doubleValue());
        }
    }

    @kb
    public static final class c
            extends pt<Float> {
        static final c a = new c();

        public c() {
            super();
        }

        public void a(Float paramFloat, hf paramhf, jw paramjw)
                throws IOException, he {
            paramhf.a(paramFloat.floatValue());
        }
    }

    @kb
    public static final class d
            extends pt<Number> {
        static final d a = new d();

        public d() {
            super();
        }

        public void a(Number paramNumber, hf paramhf, jw paramjw)
                throws IOException, he {
            paramhf.b(paramNumber.intValue());
        }
    }

    @kb
    public static final class e
            extends pp<Integer> {
        public e() {
            super();
        }

        public void a(Integer paramInteger, hf paramhf, jw paramjw)
                throws IOException, he {
            paramhf.b(paramInteger.intValue());
        }
    }

    @kb
    public static final class f
            extends pt<Long> {
        static final f a = new f();

        public f() {
            super();
        }

        public void a(Long paramLong, hf paramhf, jw paramjw)
                throws IOException, he {
            paramhf.a(paramLong.longValue());
        }
    }

    @kb
    public static final class g
            extends pt<Number> {
        public static final g a = new g();

        public g() {
            super();
        }

        public void a(Number paramNumber, hf paramhf, jw paramjw)
                throws IOException, he {
            if ((paramNumber instanceof BigDecimal)) {
                paramhf.a((BigDecimal) paramNumber);
                return;
            }
            if ((paramNumber instanceof BigInteger)) {
                paramhf.a((BigInteger) paramNumber);
                return;
            }
            if ((paramNumber instanceof Integer)) {
                paramhf.b(paramNumber.intValue());
                return;
            }
            if ((paramNumber instanceof Long)) {
                paramhf.a(paramNumber.longValue());
                return;
            }
            if ((paramNumber instanceof Double)) {
                paramhf.a(paramNumber.doubleValue());
                return;
            }
            if ((paramNumber instanceof Float)) {
                paramhf.a(paramNumber.floatValue());
                return;
            }
            if (((paramNumber instanceof Byte)) || ((paramNumber instanceof Short))) {
                paramhf.b(paramNumber.intValue());
                return;
            }
            paramhf.e(paramNumber.toString());
        }
    }

    @kb
    public static final class h
            extends pt<Date> {
        public h() {
            super();
        }

        public void a(Date paramDate, hf paramhf, jw paramjw)
                throws IOException, he {
            paramhf.b(paramDate.toString());
        }
    }

    @kb
    public static final class i
            extends pt<Time> {
        public i() {
            super();
        }

        public void a(Time paramTime, hf paramhf, jw paramjw)
                throws IOException, he {
            paramhf.b(paramTime.toString());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/os.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */