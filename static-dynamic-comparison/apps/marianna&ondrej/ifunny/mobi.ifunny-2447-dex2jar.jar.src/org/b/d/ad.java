package org.b.d;

import java.lang.reflect.Array;

import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class ad
        extends a {
    protected Class a;
    protected aj b;

    public ad(Class paramClass, aj paramaj) {
        this.a = paramClass;
        this.b = paramaj;
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
                throw new c("Attempted to write null");
            }
            parame.d();
            return;
        }
        if ((!(paramObject instanceof Object[])) || (!this.a.isAssignableFrom(paramObject.getClass().getComponentType()))) {
            throw new c();
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */