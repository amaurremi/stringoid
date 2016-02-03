package com.umeng.a.a.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class i {
    public static h a(Class<? extends h> paramClass, int paramInt) {
        try {
            paramClass = (h) paramClass.getMethod("findByValue", new Class[]{Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(paramInt)});
            return paramClass;
        } catch (NoSuchMethodException paramClass) {
            return null;
        } catch (IllegalAccessException paramClass) {
            return null;
        } catch (InvocationTargetException paramClass) {
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/a/a/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */