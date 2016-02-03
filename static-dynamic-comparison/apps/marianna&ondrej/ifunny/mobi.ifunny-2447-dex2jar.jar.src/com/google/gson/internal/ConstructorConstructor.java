package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.reflect.TypeToken;

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

public final class ConstructorConstructor {
    private final Map<Type, InstanceCreator<?>> instanceCreators;

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> paramMap) {
        this.instanceCreators = paramMap;
    }

    private <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> paramClass) {
        try {
            paramClass = paramClass.getDeclaredConstructor(new Class[0]);
            if (!paramClass.isAccessible()) {
                paramClass.setAccessible(true);
            }
            paramClass = new i(this, paramClass);
            return paramClass;
        } catch (NoSuchMethodException paramClass) {
        }
        return null;
    }

    private <T> ObjectConstructor<T> newDefaultImplementationConstructor(Type paramType, Class<? super T> paramClass) {
        if (Collection.class.isAssignableFrom(paramClass)) {
            if (SortedSet.class.isAssignableFrom(paramClass)) {
                return new j(this);
            }
            if (EnumSet.class.isAssignableFrom(paramClass)) {
                return new k(this, paramType);
            }
            if (Set.class.isAssignableFrom(paramClass)) {
                return new l(this);
            }
            if (Queue.class.isAssignableFrom(paramClass)) {
                return new m(this);
            }
            return new n(this);
        }
        if (Map.class.isAssignableFrom(paramClass)) {
            if (SortedMap.class.isAssignableFrom(paramClass)) {
                return new o(this);
            }
            if (((paramType instanceof ParameterizedType)) && (!String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) paramType).getActualTypeArguments()[0]).getRawType()))) {
                return new e(this);
            }
            return new f(this);
        }
        return null;
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(Type paramType, Class<? super T> paramClass) {
        return new g(this, paramClass, paramType);
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> paramTypeToken) {
        Type localType = paramTypeToken.getType();
        Class localClass = paramTypeToken.getRawType();
        paramTypeToken = (InstanceCreator) this.instanceCreators.get(localType);
        if (paramTypeToken != null) {
            paramTypeToken = new d(this, paramTypeToken, localType);
        }
        ObjectConstructor localObjectConstructor;
        do {
            do {
                return paramTypeToken;
                paramTypeToken = (InstanceCreator) this.instanceCreators.get(localClass);
                if (paramTypeToken != null) {
                    return new h(this, paramTypeToken, localType);
                }
                localObjectConstructor = newDefaultConstructor(localClass);
                paramTypeToken = localObjectConstructor;
            } while (localObjectConstructor != null);
            localObjectConstructor = newDefaultImplementationConstructor(localType, localClass);
            paramTypeToken = localObjectConstructor;
        } while (localObjectConstructor != null);
        return newUnsafeAllocator(localType, localClass);
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/ConstructorConstructor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */