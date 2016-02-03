package org.b.d.a.a;

import java.lang.reflect.Method;

public class h
        extends d {
    private Method h;
    private i[] i;

    public h(Method paramMethod) {
        if (paramMethod == null) {
            throw new NullPointerException();
        }
        this.h = paramMethod;
        a(paramMethod.getName());
    }

    public Method a() {
        return this.h;
    }

    void a(h paramh) {
        super.a(paramh);
        if (this.h == null) {
            this.h = paramh.h;
        }
        if (this.i == null) {
            this.i = paramh.i;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/a/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */