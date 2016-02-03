package org.b.d.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import org.b.c;
import org.b.d.a.a.k;
import org.b.d.q;

public class d
        extends f {
    protected k a;

    public d() {
    }

    public d(k paramk) {
        this(paramk, q.d);
    }

    public d(k paramk, q paramq) {
        super(paramq);
        this.a = paramk;
    }

    public Object a(Object paramObject) {
        try {
            paramObject = a().g().invoke(paramObject, new Object[0]);
            return paramObject;
        } catch (IllegalArgumentException paramObject) {
            throw new c((Throwable) paramObject);
        } catch (IllegalAccessException paramObject) {
            throw new c((Throwable) paramObject);
        } catch (InvocationTargetException paramObject) {
            throw new c((Throwable) paramObject);
        }
    }

    public k a() {
        return this.a;
    }

    public void a(Object paramObject1, Object paramObject2) {
        try {
            a().f().invoke(paramObject1, new Object[]{paramObject2});
            return;
        } catch (IllegalArgumentException paramObject1) {
            throw new c((Throwable) paramObject1);
        } catch (IllegalAccessException paramObject1) {
            throw new c((Throwable) paramObject1);
        } catch (InvocationTargetException paramObject1) {
            throw new c((Throwable) paramObject1);
        }
    }

    public String b() {
        return a().c();
    }

    public Class<?> c() {
        return a().h();
    }

    public Type d() {
        return a().g().getGenericReturnType();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */