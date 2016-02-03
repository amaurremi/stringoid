package com.millennialmedia.a.a.b;

import java.lang.reflect.Type;

class j
        implements ag<T> {
    private final am d = am.a();

    j(f paramf, Class paramClass, Type paramType) {
    }

    public T a() {
        try {
            Object localObject = this.d.a(this.a);
            return (T) localObject;
        } catch (Exception localException) {
            throw new RuntimeException("Unable to invoke no-args constructor for " + this.b + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", localException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */