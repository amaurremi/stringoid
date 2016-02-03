package org.apache.commons.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ClassUtils;

public class ConstructorUtils {
    public static Constructor getAccessibleConstructor(Class paramClass1, Class paramClass2) {
        return getAccessibleConstructor(paramClass1, new Class[]{paramClass2});
    }

    public static Constructor getAccessibleConstructor(Class paramClass, Class[] paramArrayOfClass) {
        try {
            paramClass = getAccessibleConstructor(paramClass.getConstructor(paramArrayOfClass));
            return paramClass;
        } catch (NoSuchMethodException paramClass) {
        }
        return null;
    }

    public static Constructor getAccessibleConstructor(Constructor paramConstructor) {
        if ((MemberUtils.isAccessible(paramConstructor)) && (Modifier.isPublic(paramConstructor.getDeclaringClass().getModifiers()))) {
            return paramConstructor;
        }
        return null;
    }

    public static Constructor getMatchingAccessibleConstructor(Class paramClass, Class[] paramArrayOfClass) {
        try {
            Constructor localConstructor1 = paramClass.getConstructor(paramArrayOfClass);
            MemberUtils.setAccessibleWorkaround(localConstructor1);
            return localConstructor1;
        } catch (NoSuchMethodException localNoSuchMethodException) {
            Object localObject = null;
            Constructor[] arrayOfConstructor = paramClass.getConstructors();
            int i = 0;
            for (paramClass = (Class) localObject; i < arrayOfConstructor.length; paramClass = (Class) localObject) {
                localObject = paramClass;
                if (ClassUtils.isAssignable(paramArrayOfClass, arrayOfConstructor[i].getParameterTypes(), true)) {
                    Constructor localConstructor2 = getAccessibleConstructor(arrayOfConstructor[i]);
                    localObject = paramClass;
                    if (localConstructor2 != null) {
                        MemberUtils.setAccessibleWorkaround(localConstructor2);
                        if (paramClass != null) {
                            localObject = paramClass;
                            if (MemberUtils.compareParameterTypes(localConstructor2.getParameterTypes(), paramClass.getParameterTypes(), paramArrayOfClass) >= 0) {
                            }
                        } else {
                            localObject = localConstructor2;
                        }
                    }
                }
                i += 1;
            }
        }
        return paramClass;
    }

    public static Object invokeConstructor(Class paramClass, Object paramObject)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return invokeConstructor(paramClass, new Object[]{paramObject});
    }

    public static Object invokeConstructor(Class paramClass, Object[] paramArrayOfObject)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object[] arrayOfObject = paramArrayOfObject;
        if (paramArrayOfObject == null) {
            arrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        paramArrayOfObject = new Class[arrayOfObject.length];
        int i = 0;
        while (i < arrayOfObject.length) {
            paramArrayOfObject[i] = arrayOfObject[i].getClass();
            i += 1;
        }
        return invokeConstructor(paramClass, arrayOfObject, paramArrayOfObject);
    }

    public static Object invokeConstructor(Class paramClass, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class[] arrayOfClass = paramArrayOfClass;
        if (paramArrayOfClass == null) {
            arrayOfClass = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        paramArrayOfClass = paramArrayOfObject;
        if (paramArrayOfObject == null) {
            paramArrayOfClass = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        paramArrayOfObject = getMatchingAccessibleConstructor(paramClass, arrayOfClass);
        if (paramArrayOfObject == null) {
            throw new NoSuchMethodException("No such accessible constructor on object: " + paramClass.getName());
        }
        return paramArrayOfObject.newInstance(paramArrayOfClass);
    }

    public static Object invokeExactConstructor(Class paramClass, Object paramObject)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return invokeExactConstructor(paramClass, new Object[]{paramObject});
    }

    public static Object invokeExactConstructor(Class paramClass, Object[] paramArrayOfObject)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object[] arrayOfObject = paramArrayOfObject;
        if (paramArrayOfObject == null) {
            arrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        int j = arrayOfObject.length;
        paramArrayOfObject = new Class[j];
        int i = 0;
        while (i < j) {
            paramArrayOfObject[i] = arrayOfObject[i].getClass();
            i += 1;
        }
        return invokeExactConstructor(paramClass, arrayOfObject, paramArrayOfObject);
    }

    public static Object invokeExactConstructor(Class paramClass, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object[] arrayOfObject = paramArrayOfObject;
        if (paramArrayOfObject == null) {
            arrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        paramArrayOfObject = paramArrayOfClass;
        if (paramArrayOfClass == null) {
            paramArrayOfObject = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        paramArrayOfObject = getAccessibleConstructor(paramClass, paramArrayOfObject);
        if (paramArrayOfObject == null) {
            throw new NoSuchMethodException("No such accessible constructor on object: " + paramClass.getName());
        }
        return paramArrayOfObject.newInstance(arrayOfObject);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/reflect/ConstructorUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */