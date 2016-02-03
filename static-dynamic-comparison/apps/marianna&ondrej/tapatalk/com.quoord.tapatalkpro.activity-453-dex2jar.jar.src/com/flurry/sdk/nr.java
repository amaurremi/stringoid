package com.flurry.sdk;

import java.util.EnumMap;
import java.util.EnumSet;

public class nr
        extends nw {
    public nr(sh paramsh, qs paramqs) {
        super(paramsh, paramqs);
    }

    public sh a(String paramString) {
        if (paramString.indexOf('<') > 0) {
            return qs.a(paramString);
        }
        try {
            Object localObject = Class.forName(paramString, true, Thread.currentThread().getContextClassLoader());
            localObject = this.c.a(this.d, (Class) localObject);
            return (sh) localObject;
        } catch (ClassNotFoundException localClassNotFoundException) {
            throw new IllegalArgumentException("Invalid type id '" + paramString + "' (for id type 'Id.class'): no such class found");
        } catch (Exception localException) {
            throw new IllegalArgumentException("Invalid type id '" + paramString + "' (for id type 'Id.class'): " + localException.getMessage(), localException);
        }
    }

    public String a(Object paramObject) {
        return b(paramObject, paramObject.getClass());
    }

    public String a(Object paramObject, Class<?> paramClass) {
        return b(paramObject, paramClass);
    }

    protected final String b(Object paramObject, Class<?> paramClass) {
        Object localObject = paramClass;
        if (Enum.class.isAssignableFrom(paramClass)) {
            localObject = paramClass;
            if (!paramClass.isEnum()) {
                localObject = paramClass.getSuperclass();
            }
        }
        paramClass = ((Class) localObject).getName();
        if (paramClass.startsWith("java.util")) {
            if ((paramObject instanceof EnumSet)) {
                paramObject = qy.a((EnumSet) paramObject);
                paramObject = qs.a().b(EnumSet.class, (Class) paramObject).m();
            }
        }
        do {
            do {
                do {
                    do {
                        do {
                            return (String) paramObject;
                            if ((paramObject instanceof EnumMap)) {
                                paramObject = qy.a((EnumMap) paramObject);
                                return qs.a().a(EnumMap.class, (Class) paramObject, Object.class).m();
                            }
                            localObject = paramClass.substring(9);
                            if (((String) localObject).startsWith(".Arrays$")) {
                                break;
                            }
                            paramObject = paramClass;
                        } while (!((String) localObject).startsWith(".Collections$"));
                        paramObject = paramClass;
                    } while (paramClass.indexOf("List") < 0);
                    return "java.util.ArrayList";
                    paramObject = paramClass;
                } while (paramClass.indexOf('$') < 0);
                paramObject = paramClass;
            } while (qy.b((Class) localObject) == null);
            paramObject = paramClass;
        } while (qy.b(this.d.p()) != null);
        return this.d.p().getName();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/nr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */