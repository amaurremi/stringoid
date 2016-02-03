package org.b.d.a.a;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.TooManyListenersException;

public class c
        extends d {
    private Class<?> h;
    private ArrayList<h> i;
    private Method[] j;
    private Method k;
    private Method l;
    private Method m;
    private boolean n;
    private boolean o = true;

    public c(String paramString, Class<?> paramClass, Method[] paramArrayOfMethod, Method paramMethod1, Method paramMethod2, Method paramMethod3) {
        a(paramString);
        this.h = paramClass;
        this.j = paramArrayOfMethod;
        if (paramArrayOfMethod != null) {
            this.i = new ArrayList();
            int i2 = paramArrayOfMethod.length;
            int i1 = 0;
            while (i1 < i2) {
                paramString = paramArrayOfMethod[i1];
                this.i.add(new h(paramString));
                i1 += 1;
            }
        }
        this.l = paramMethod1;
        this.m = paramMethod2;
        this.k = paramMethod3;
        this.n = a(paramMethod1);
    }

    private static boolean a(Method paramMethod) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        int i2;
        int i1;
        if (paramMethod != null) {
            paramMethod = paramMethod.getExceptionTypes();
            i2 = paramMethod.length;
            i1 = 0;
        }
        for (; ; ) {
            bool1 = bool2;
            if (i1 < i2) {
                if (paramMethod[i1].equals(TooManyListenersException.class)) {
                    bool1 = true;
                }
            } else {
                return bool1;
            }
            i1 += 1;
        }
    }

    void a(c paramc) {
        super.a(paramc);
        if (this.l == null) {
            this.l = paramc.l;
        }
        if (this.k == null) {
            this.k = paramc.k;
        }
        if (this.i == null) {
            this.i = paramc.i;
        }
        if (this.j == null) {
            this.j = paramc.j;
        }
        if (this.h == null) {
            this.h = paramc.h;
        }
        if (this.m == null) {
            this.m = paramc.m;
        }
        this.o &= paramc.o;
    }

    public void a(boolean paramBoolean) {
        this.n = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */