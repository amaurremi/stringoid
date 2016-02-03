package com.umeng.a.a.a.a;

import com.umeng.a.a.a.d;
import com.umeng.a.a.a.k;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class b
        implements Serializable {
    private static Map<Class<? extends d>, Map<? extends k, b>> d = new HashMap();
    public final String a;
    public final byte b;
    public final c c;

    public b(String paramString, byte paramByte, c paramc) {
        this.a = paramString;
        this.b = paramByte;
        this.c = paramc;
    }

    public static Map<? extends k, b> a(Class<? extends d> paramClass) {
        if (!d.containsKey(paramClass)) {
        }
        try {
            paramClass.newInstance();
            return (Map) d.get(paramClass);
        } catch (InstantiationException localInstantiationException) {
            throw new RuntimeException("InstantiationException for TBase class: " + paramClass.getName() + ", message: " + localInstantiationException.getMessage());
        } catch (IllegalAccessException localIllegalAccessException) {
            throw new RuntimeException("IllegalAccessException for TBase class: " + paramClass.getName() + ", message: " + localIllegalAccessException.getMessage());
        }
    }

    public static void a(Class<? extends d> paramClass, Map<? extends k, b> paramMap) {
        d.put(paramClass, paramMap);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/a/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */