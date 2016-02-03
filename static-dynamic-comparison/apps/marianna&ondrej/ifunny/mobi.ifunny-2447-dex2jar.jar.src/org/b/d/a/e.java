package org.b.d.a;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import org.b.c;
import org.b.d.q;

public class e
        extends f {
    protected Field a;

    public e() {
        this(null, q.a);
    }

    public e(Field paramField, q paramq) {
        super(paramq);
        this.a = paramField;
    }

    public Object a(Object paramObject) {
        try {
            paramObject = a().get(paramObject);
            return paramObject;
        } catch (IllegalArgumentException paramObject) {
            throw new c((Throwable) paramObject);
        } catch (IllegalAccessException paramObject) {
            throw new c((Throwable) paramObject);
        }
    }

    public Field a() {
        return this.a;
    }

    public void a(Object paramObject1, Object paramObject2) {
        try {
            this.a.set(paramObject1, paramObject2);
            return;
        } catch (IllegalArgumentException paramObject1) {
            throw new c((Throwable) paramObject1);
        } catch (IllegalAccessException paramObject1) {
            throw new c((Throwable) paramObject1);
        }
    }

    public String b() {
        return this.a.getName();
    }

    public Class<?> c() {
        return this.a.getType();
    }

    public Type d() {
        return this.a.getGenericType();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */