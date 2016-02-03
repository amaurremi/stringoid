package com.millennialmedia.a.a.b;

import com.millennialmedia.a.a.c.a;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public final class f {
    private final Map<Type, com.millennialmedia.a.a.q<?>> a;

    public f(Map<Type, com.millennialmedia.a.a.q<?>> paramMap) {
        this.a = paramMap;
    }

    private <T> ag<T> a(Class<? super T> paramClass) {
        try {
            paramClass = paramClass.getDeclaredConstructor(new Class[0]);
            if (!paramClass.isAccessible()) {
                paramClass.setAccessible(true);
            }
            paramClass = new l(this, paramClass);
            return paramClass;
        } catch (NoSuchMethodException paramClass) {
        }
        return null;
    }

    private <T> ag<T> a(Type paramType, Class<? super T> paramClass) {
        if (Collection.class.isAssignableFrom(paramClass)) {
            if (SortedSet.class.isAssignableFrom(paramClass)) {
                return new m(this);
            }
            if (EnumSet.class.isAssignableFrom(paramClass)) {
                return new n(this, paramType);
            }
            if (Set.class.isAssignableFrom(paramClass)) {
                return new o(this);
            }
            if (Queue.class.isAssignableFrom(paramClass)) {
                return new p(this);
            }
            return new q(this);
        }
        if (Map.class.isAssignableFrom(paramClass)) {
            if (SortedMap.class.isAssignableFrom(paramClass)) {
                return new r(this);
            }
            if (((paramType instanceof ParameterizedType)) && (!String.class.isAssignableFrom(a.a(((ParameterizedType) paramType).getActualTypeArguments()[0]).a()))) {
                return new h(this);
            }
            return new i(this);
        }
        return null;
    }

    private <T> ag<T> b(Type paramType, Class<? super T> paramClass) {
        return new j(this, paramClass, paramType);
    }

    public <T> ag<T> a(a<T> parama) {
        Type localType = parama.b();
        Class localClass = parama.a();
        parama = (com.millennialmedia.a.a.q) this.a.get(localType);
        if (parama != null) {
            parama = new g(this, parama, localType);
        }
        ag localag;
        do {
            do {
                return parama;
                parama = (com.millennialmedia.a.a.q) this.a.get(localClass);
                if (parama != null) {
                    return new k(this, parama, localType);
                }
                localag = a(localClass);
                parama = localag;
            } while (localag != null);
            localag = a(localType, localClass);
            parama = localag;
        } while (localag != null);
        return b(localType, localClass);
    }

    public String toString() {
        return this.a.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */