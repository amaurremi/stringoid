package com.flurry.sdk;

public abstract class oo {
    public static oi a(oi paramoi, Class<?>[] paramArrayOfClass) {
        if (paramArrayOfClass.length == 1) {
            return new b(paramoi, paramArrayOfClass[0]);
        }
        return new a(paramoi, paramArrayOfClass);
    }

    static final class a
            extends oi {
        protected final oi p;
        protected final Class<?>[] q;

        protected a(oi paramoi, Class<?>[] paramArrayOfClass) {
            super();
            this.p = paramoi;
            this.q = paramArrayOfClass;
        }

        public oi a(jk<Object> paramjk) {
            return new a(this.p.a(paramjk), this.q);
        }

        public void a(Object paramObject, hf paramhf, jw paramjw)
                throws Exception {
            Class localClass = paramjw.a();
            if (localClass != null) {
                int i = 0;
                int j = this.q.length;
                for (; ; ) {
                    if ((i >= j) || (this.q[i].isAssignableFrom(localClass))) {
                        if (i != j) {
                            break;
                        }
                        return;
                    }
                    i += 1;
                }
            }
            this.p.a(paramObject, paramhf, paramjw);
        }
    }

    static final class b
            extends oi {
        protected final oi p;
        protected final Class<?> q;

        protected b(oi paramoi, Class<?> paramClass) {
            super();
            this.p = paramoi;
            this.q = paramClass;
        }

        public oi a(jk<Object> paramjk) {
            return new b(this.p.a(paramjk), this.q);
        }

        public void a(Object paramObject, hf paramhf, jw paramjw)
                throws Exception {
            Class localClass = paramjw.a();
            if ((localClass == null) || (this.q.isAssignableFrom(localClass))) {
                this.p.a(paramObject, paramhf, paramjw);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/oo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */