package com.mopub.common.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Reflection$MethodBuilder {
    private final Object a;
    private final String b;
    private Class<?> c;
    private List<Class<?>> d;
    private List<Object> e;
    private boolean f;
    private boolean g;

    public Reflection$MethodBuilder(Object paramObject, String paramString) {
        this.a = paramObject;
        this.b = paramString;
        this.d = new ArrayList();
        this.e = new ArrayList();
        if (paramObject != null) {
        }
        for (paramObject = paramObject.getClass(); ; paramObject = null) {
            this.c = ((Class) paramObject);
            return;
        }
    }

    public <T> MethodBuilder addParam(Class<T> paramClass, T paramT) {
        this.d.add(paramClass);
        this.e.add(paramT);
        return this;
    }

    public Object execute() {
        Object localObject = new Class[this.d.size()];
        localObject = (Class[]) this.d.toArray((Object[]) localObject);
        localObject = Reflection.getDeclaredMethodWithTraversal(this.c, this.b, (Class[]) localObject);
        if (this.f) {
            ((Method) localObject).setAccessible(true);
        }
        Object[] arrayOfObject = this.e.toArray();
        if (this.g) {
            return ((Method) localObject).invoke(null, arrayOfObject);
        }
        return ((Method) localObject).invoke(this.a, arrayOfObject);
    }

    public MethodBuilder setAccessible() {
        this.f = true;
        return this;
    }

    public MethodBuilder setStatic(Class<?> paramClass) {
        this.g = true;
        this.c = paramClass;
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/util/Reflection$MethodBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */