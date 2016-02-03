package com.inneractive.api.ads.sdk;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

final class IAreflectionHandler$a {
    private final Object a;
    private final String b;
    private Class c;
    private List d;
    private List e;
    private boolean f;

    IAreflectionHandler$a(Object paramObject, String paramString) {
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

    final a a(Class paramClass) {
        this.f = true;
        this.c = paramClass;
        return this;
    }

    final a a(Class paramClass, Object paramObject) {
        this.d.add(paramClass);
        this.e.add(paramObject);
        return this;
    }

    final Object a() {
        Object localObject = new Class[this.d.size()];
        localObject = (Class[]) this.d.toArray((Object[]) localObject);
        localObject = IAreflectionHandler.a(this.c, this.b, (Class[]) localObject);
        Object[] arrayOfObject = this.e.toArray();
        if (this.f) {
            return ((Method) localObject).invoke(null, arrayOfObject);
        }
        return ((Method) localObject).invoke(this.a, arrayOfObject);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAreflectionHandler$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */