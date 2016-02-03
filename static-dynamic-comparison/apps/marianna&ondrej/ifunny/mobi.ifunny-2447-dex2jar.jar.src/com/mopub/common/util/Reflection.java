package com.mopub.common.util;

import java.lang.reflect.Method;

public class Reflection {
    public static boolean classFound(String paramString) {
        try {
            Class.forName(paramString);
            return true;
        } catch (ClassNotFoundException paramString) {
        }
        return false;
    }

    public static Method getDeclaredMethodWithTraversal(Class<?> paramClass, String paramString, Class<?>... paramVarArgs) {
        while (paramClass != null) {
            try {
                Method localMethod = paramClass.getDeclaredMethod(paramString, paramVarArgs);
                return localMethod;
            } catch (NoSuchMethodException localNoSuchMethodException) {
                paramClass = paramClass.getSuperclass();
            }
        }
        throw new NoSuchMethodException();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/util/Reflection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */