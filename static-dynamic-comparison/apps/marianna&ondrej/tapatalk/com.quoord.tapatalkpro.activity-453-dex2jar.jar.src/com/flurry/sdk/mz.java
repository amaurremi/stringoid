package com.flurry.sdk;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class mz {
    static final Class<?>[] a = new Class[0];
    final String b;
    final Class<?>[] c;

    public mz(String paramString, Class<?>[] paramArrayOfClass) {
        this.b = paramString;
        paramString = paramArrayOfClass;
        if (paramArrayOfClass == null) {
            paramString = a;
        }
        this.c = paramString;
    }

    public mz(Constructor<?> paramConstructor) {
        this("", paramConstructor.getParameterTypes());
    }

    public mz(Method paramMethod) {
        this(paramMethod.getName(), paramMethod.getParameterTypes());
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
            return true;
        }
        if (paramObject == null) {
            return false;
        }
        if (paramObject.getClass() != getClass()) {
            return false;
        }
        paramObject = (mz) paramObject;
        if (!this.b.equals(((mz) paramObject).b)) {
            return false;
        }
        paramObject = ((mz) paramObject).c;
        int j = this.c.length;
        if (paramObject.length != j) {
            return false;
        }
        int i = 0;
        label68:
        Class localClass1;
        Class localClass2;
        if (i < j) {
            localClass1 = paramObject[i];
            localClass2 = this.c[i];
            if (localClass1 != localClass2) {
                break label100;
            }
        }
        label100:
        while ((localClass1.isAssignableFrom(localClass2)) || (localClass2.isAssignableFrom(localClass1))) {
            i += 1;
            break label68;
            break;
        }
        return false;
    }

    public int hashCode() {
        return this.b.hashCode() + this.c.length;
    }

    public String toString() {
        return this.b + "(" + this.c.length + "-args)";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/mz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */