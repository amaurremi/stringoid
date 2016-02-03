package com.flurry.sdk;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public final class rb {
    private final EnumMap<?, im> a;

    private rb(Map<Enum<?>, im> paramMap) {
        this.a = new EnumMap(paramMap);
    }

    public static rb a(Class<Enum<?>> paramClass, iq paramiq) {
        return b(paramClass, paramiq);
    }

    public static rb b(Class<Enum<?>> paramClass, iq paramiq) {
        Enum[] arrayOfEnum = (Enum[]) qy.g(paramClass).getEnumConstants();
        if (arrayOfEnum != null) {
            paramClass = new HashMap();
            int j = arrayOfEnum.length;
            int i = 0;
            while (i < j) {
                Enum localEnum = arrayOfEnum[i];
                paramClass.put(localEnum, new im(paramiq.a(localEnum)));
                i += 1;
            }
            return new rb(paramClass);
        }
        throw new IllegalArgumentException("Can not determine enum constants for Class " + paramClass.getName());
    }

    public static rb c(Class<Enum<?>> paramClass, iq paramiq) {
        paramiq = (Enum[]) qy.g(paramClass).getEnumConstants();
        if (paramiq != null) {
            paramClass = new HashMap();
            int j = paramiq.length;
            int i = 0;
            while (i < j) {
                Object localObject = paramiq[i];
                paramClass.put(localObject, new im(((Enum) localObject).toString()));
                i += 1;
            }
            return new rb(paramClass);
        }
        throw new IllegalArgumentException("Can not determine enum constants for Class " + paramClass.getName());
    }

    public im a(Enum<?> paramEnum) {
        return (im) this.a.get(paramEnum);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/rb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */