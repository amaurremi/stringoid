package org.b.d.a;

import java.lang.reflect.Array;

import org.b.c.e;
import org.b.d.a;
import org.b.d.aj;
import org.b.f.q;

class c
        extends a {
    private Class a;
    private aj b;

    public c(Class paramClass, aj paramaj) {
        this.a = paramClass;
        this.b = paramaj;
    }

    Class a() {
        return this.a;
    }

    public Object a(q paramq, Object paramObject, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        int j = paramq.s();
        paramObject = (Object[]) Array.newInstance(this.a, j);
        int i = 0;
        while (i < j) {
            paramObject[i] = this.b.a(paramq, null, paramBoolean);
            i += 1;
        }
        paramq.b();
        return paramObject;
    }

    public void a(e parame, Object paramObject, boolean paramBoolean) {
        if (paramObject == null) {
            if (paramBoolean) {
                throw new org.b.c("Attempted to write null");
            }
            parame.d();
            return;
        }
        if ((!(paramObject instanceof Object[])) || (!this.a.isAssignableFrom(paramObject.getClass().getComponentType()))) {
            throw new org.b.c();
        }
        paramObject = (Object[]) paramObject;
        int j = paramObject.length;
        parame.c(j);
        int i = 0;
        while (i < j) {
            this.b.a(parame, paramObject[i], paramBoolean);
            i += 1;
        }
        parame.a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */