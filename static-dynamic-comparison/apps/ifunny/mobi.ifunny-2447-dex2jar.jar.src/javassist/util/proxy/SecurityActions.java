package javassist.util.proxy;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedActionException;

class SecurityActions {
    static Constructor getDeclaredConstructor(Class paramClass, Class[] paramArrayOfClass) {
        if (System.getSecurityManager() == null) {
            return paramClass.getDeclaredConstructor(paramArrayOfClass);
        }
        try {
            paramClass = (Constructor) AccessController.doPrivileged(new SecurityActions .4
            (paramClass, paramArrayOfClass));
            return paramClass;
        } catch (PrivilegedActionException paramClass) {
            if ((paramClass.getCause() instanceof NoSuchMethodException)) {
                throw ((NoSuchMethodException) paramClass.getCause());
            }
            throw new RuntimeException(paramClass.getCause());
        }
    }

    static Constructor[] getDeclaredConstructors(Class paramClass) {
        if (System.getSecurityManager() == null) {
            return paramClass.getDeclaredConstructors();
        }
        return (Constructor[]) AccessController.doPrivileged(new SecurityActions .2 (paramClass));
    }

    static Method getDeclaredMethod(Class paramClass, String paramString, Class[] paramArrayOfClass) {
        if (System.getSecurityManager() == null) {
            return paramClass.getDeclaredMethod(paramString, paramArrayOfClass);
        }
        try {
            paramClass = (Method) AccessController.doPrivileged(new SecurityActions .3
            (paramClass, paramString, paramArrayOfClass));
            return paramClass;
        } catch (PrivilegedActionException paramClass) {
            if ((paramClass.getCause() instanceof NoSuchMethodException)) {
                throw ((NoSuchMethodException) paramClass.getCause());
            }
            throw new RuntimeException(paramClass.getCause());
        }
    }

    static Method[] getDeclaredMethods(Class paramClass) {
        if (System.getSecurityManager() == null) {
            return paramClass.getDeclaredMethods();
        }
        return (Method[]) AccessController.doPrivileged(new SecurityActions .1 (paramClass));
    }

    static void set(Field paramField, Object paramObject1, Object paramObject2) {
        if (System.getSecurityManager() == null) {
            paramField.set(paramObject1, paramObject2);
            return;
        }
        try {
            AccessController.doPrivileged(new SecurityActions .6 (paramField, paramObject1, paramObject2));
            return;
        } catch (PrivilegedActionException paramField) {
            if ((paramField.getCause() instanceof NoSuchMethodException)) {
                throw ((IllegalAccessException) paramField.getCause());
            }
            throw new RuntimeException(paramField.getCause());
        }
    }

    static void setAccessible(AccessibleObject paramAccessibleObject, boolean paramBoolean) {
        if (System.getSecurityManager() == null) {
            paramAccessibleObject.setAccessible(paramBoolean);
            return;
        }
        AccessController.doPrivileged(new SecurityActions .5 (paramAccessibleObject, paramBoolean));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/util/proxy/SecurityActions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */