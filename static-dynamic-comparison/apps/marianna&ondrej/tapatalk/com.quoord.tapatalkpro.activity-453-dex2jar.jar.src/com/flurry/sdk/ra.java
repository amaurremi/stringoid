package com.flurry.sdk;

import java.util.HashMap;

public class ra<T extends Enum<T>> {
    protected final Class<T> a;
    protected final T[] b;
    protected final HashMap<String, T> c;

    protected ra(Class<T> paramClass, T[] paramArrayOfT, HashMap<String, T> paramHashMap) {
        this.a = paramClass;
        this.b = paramArrayOfT;
        this.c = paramHashMap;
    }

    public static <ET extends Enum<ET>> ra<ET> a(Class<ET> paramClass) {
        Enum[] arrayOfEnum = (Enum[]) paramClass.getEnumConstants();
        HashMap localHashMap = new HashMap();
        int i = arrayOfEnum.length;
        for (; ; ) {
            i -= 1;
            if (i < 0) {
                break;
            }
            Enum localEnum = arrayOfEnum[i];
            localHashMap.put(localEnum.toString(), localEnum);
        }
        return new ra(paramClass, arrayOfEnum, localHashMap);
    }

    public static <ET extends Enum<ET>> ra<ET> a(Class<ET> paramClass, iq paramiq) {
        Enum[] arrayOfEnum = (Enum[]) paramClass.getEnumConstants();
        if (arrayOfEnum == null) {
            throw new IllegalArgumentException("No enum constants for class " + paramClass.getName());
        }
        HashMap localHashMap = new HashMap();
        int j = arrayOfEnum.length;
        int i = 0;
        while (i < j) {
            Enum localEnum = arrayOfEnum[i];
            localHashMap.put(paramiq.a(localEnum), localEnum);
            i += 1;
        }
        return new ra(paramClass, arrayOfEnum, localHashMap);
    }

    public static ra<?> b(Class<?> paramClass) {
        return a(paramClass);
    }

    public static ra<?> b(Class<?> paramClass, iq paramiq) {
        return a(paramClass, paramiq);
    }

    public Class<T> a() {
        return this.a;
    }

    public T a(int paramInt) {
        if ((paramInt < 0) || (paramInt >= this.b.length)) {
            return null;
        }
        return this.b[paramInt];
    }

    public T a(String paramString) {
        return (Enum) this.c.get(paramString);
    }

    public int b() {
        return this.b.length - 1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ra.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */