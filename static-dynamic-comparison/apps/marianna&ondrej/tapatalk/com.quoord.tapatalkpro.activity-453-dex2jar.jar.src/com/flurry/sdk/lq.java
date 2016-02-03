package com.flurry.sdk;

import java.io.IOException;
import java.lang.reflect.Method;

@kc
public class lq
        extends mc<Enum<?>> {
    protected final ra<?> a;

    public lq(ra<?> paramra) {
        super(Enum.class);
        this.a = paramra;
    }

    public static jg<?> a(iy paramiy, Class<?> paramClass, mr parammr) {
        if (parammr.b(0) != String.class) {
            throw new IllegalArgumentException("Parameter #0 type for factory method (" + parammr + ") not suitable, must be java.lang.String");
        }
        if (paramiy.a(iy.a.f)) {
            qy.a(parammr.i());
        }
        return new a(paramClass, parammr);
    }

    public Enum<?> b(hj paramhj, iz paramiz)
            throws IOException, hk {
        Object localObject = paramhj.e();
        if ((localObject == hm.h) || (localObject == hm.f)) {
            paramhj = paramhj.k();
            localObject = this.a.a(paramhj);
            paramhj = (hj) localObject;
            if (localObject == null) {
                throw paramiz.b(this.a.a(), "value not one of declared Enum instance names");
            }
        } else if (localObject == hm.i) {
            if (paramiz.a(iy.a.m)) {
                throw paramiz.b("Not allowed to deserialize Enum value out of JSON number (disable DeserializationConfig.Feature.FAIL_ON_NUMBERS_FOR_ENUMS to allow)");
            }
            int i = paramhj.t();
            localObject = this.a.a(i);
            paramhj = (hj) localObject;
            if (localObject == null) {
                throw paramiz.c(this.a.a(), "index value outside legal index range [0.." + this.a.b() + "]");
            }
        } else {
            throw paramiz.b(this.a.a());
        }
        return paramhj;
    }

    public static class a
            extends mc<Object> {
        protected final Class<?> a;
        protected final Method b;

        public a(Class<?> paramClass, mr parammr) {
            super();
            this.a = paramClass;
            this.b = parammr.e();
        }

        public Object a(hj paramhj, iz paramiz)
                throws IOException, hk {
            hm localhm = paramhj.e();
            if ((localhm != hm.h) && (localhm != hm.f)) {
                throw paramiz.b(this.a);
            }
            paramhj = paramhj.k();
            try {
                paramhj = this.b.invoke(this.a, new Object[]{paramhj});
                return paramhj;
            } catch (Exception paramhj) {
                qy.c(paramhj);
            }
            return null;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/lq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */