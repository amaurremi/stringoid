package com.flurry.sdk;

public class oz
        extends oi {
    public oz(oi paramoi) {
        super(paramoi);
    }

    public oz(oi paramoi, jk<Object> paramjk) {
        super(paramoi, paramjk);
    }

    protected jk<Object> a(ov paramov, Class<?> paramClass, jw paramjw)
            throws jh {
        if (this.o != null) {
        }
        for (paramov = paramjw.a(paramjw.a(this.o, paramClass), this); ; paramov = paramjw.a(paramClass, this)) {
            paramjw = paramov;
            if (!paramov.b()) {
                paramjw = paramov.a();
            }
            this.j = this.j.a(paramClass, paramjw);
            return paramjw;
        }
    }

    public oi a(jk<Object> paramjk) {
        if (getClass() != oz.class) {
            throw new IllegalStateException("UnwrappingBeanPropertyWriter sub-class does not override 'withSerializer()'; needs to!");
        }
        Object localObject = paramjk;
        if (!paramjk.b()) {
            localObject = paramjk.a();
        }
        return new oz(this, (jk) localObject);
    }

    public void a(Object paramObject, hf paramhf, jw paramjw)
            throws Exception {
        Object localObject = a(paramObject);
        if (localObject == null) {
        }
        do {
            return;
            if (localObject == paramObject) {
                b(paramObject);
            }
        } while ((this.l != null) && (this.l.equals(localObject)));
        jk localjk = this.i;
        paramObject = localjk;
        if (localjk == null) {
            Class localClass = localObject.getClass();
            ov localov = this.j;
            localjk = localov.a(localClass);
            paramObject = localjk;
            if (localjk == null) {
                paramObject = a(localov, localClass, paramjw);
            }
        }
        if (!((jk) paramObject).b()) {
            paramhf.a(this.g);
        }
        if (this.n == null) {
            ((jk) paramObject).a(localObject, paramhf, paramjw);
            return;
        }
        ((jk) paramObject).a(localObject, paramhf, paramjw, this.n);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/oz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */