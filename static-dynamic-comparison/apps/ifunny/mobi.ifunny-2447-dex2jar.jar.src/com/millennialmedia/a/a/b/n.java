package com.millennialmedia.a.a.b;

import com.millennialmedia.a.a.u;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

class n
        implements ag<T> {
    n(f paramf, Type paramType) {
    }

    public T a() {
        if ((this.a instanceof ParameterizedType)) {
            Type localType = ((ParameterizedType) this.a).getActualTypeArguments()[0];
            if ((localType instanceof Class)) {
                return EnumSet.noneOf((Class) localType);
            }
            throw new u("Invalid EnumSet type: " + this.a.toString());
        }
        throw new u("Invalid EnumSet type: " + this.a.toString());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */