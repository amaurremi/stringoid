package org.apache.commons.lang.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ClassUtils;

public class MethodUtils {
    public static Method getAccessibleMethod(Class paramClass1, String paramString, Class paramClass2) {
        return getAccessibleMethod(paramClass1, paramString, new Class[]{paramClass2});
    }

    public static Method getAccessibleMethod(Class paramClass, String paramString, Class[] paramArrayOfClass) {
        try {
            paramClass = getAccessibleMethod(paramClass.getMethod(paramString, paramArrayOfClass));
            return paramClass;
        } catch (NoSuchMethodException paramClass) {
        }
        return null;
    }

    public static Method getAccessibleMethod(Method paramMethod) {
        Method localMethod;
        if (!MemberUtils.isAccessible(paramMethod)) {
            localMethod = null;
        }
        Class localClass;
        String str;
        Class[] arrayOfClass;
        do {
            do {
                return localMethod;
                localClass = paramMethod.getDeclaringClass();
                localMethod = paramMethod;
            } while (Modifier.isPublic(localClass.getModifiers()));
            str = paramMethod.getName();
            arrayOfClass = paramMethod.getParameterTypes();
            paramMethod = getAccessibleMethodFromInterfaceNest(localClass, str, arrayOfClass);
            localMethod = paramMethod;
        } while (paramMethod != null);
        return getAccessibleMethodFromSuperclass(localClass, str, arrayOfClass);
    }

    private static Method getAccessibleMethodFromInterfaceNest(Class paramClass, String paramString, Class[] paramArrayOfClass) {
        Object localObject = null;
        Class localClass = paramClass;
        paramClass = (Class) localObject;
        Class[] arrayOfClass;
        int i;
        if (localClass != null) {
            arrayOfClass = localClass.getInterfaces();
            i = 0;
            for (; ; ) {
                localObject = paramClass;
                if (i >= arrayOfClass.length) {
                    break label74;
                }
                if (Modifier.isPublic(arrayOfClass[i].getModifiers())) {
                    break;
                }
                label46:
                i += 1;
            }
        }
        try {
            localObject = arrayOfClass[i].getDeclaredMethod(paramString, paramArrayOfClass);
            paramClass = (Class) localObject;
        } catch (NoSuchMethodException localNoSuchMethodException) {
            for (; ; ) {
            }
        }
        if (paramClass != null) {
            localObject = paramClass;
        }
        for (; ; ) {
            label74:
            localClass = localClass.getSuperclass();
            paramClass = (Class) localObject;
            break;
            localObject = getAccessibleMethodFromInterfaceNest(arrayOfClass[i], paramString, paramArrayOfClass);
            paramClass = (Class) localObject;
            if (localObject == null) {
                break label46;
            }
        }
        return paramClass;
    }

    private static Method getAccessibleMethodFromSuperclass(Class paramClass, String paramString, Class[] paramArrayOfClass) {
        Object localObject2 = null;
        for (paramClass = paramClass.getSuperclass(); ; paramClass = paramClass.getSuperclass()) {
            Object localObject1 = localObject2;
            if ((paramClass == null) || (Modifier.isPublic(paramClass.getModifiers()))) {
                try {
                    localObject1 = paramClass.getMethod(paramString, paramArrayOfClass);
                    return (Method) localObject1;
                } catch (NoSuchMethodException paramClass) {
                    return null;
                }
            }
        }
    }

    public static Method getMatchingAccessibleMethod(Class paramClass, String paramString, Class[] paramArrayOfClass) {
        try {
            Method localMethod1 = paramClass.getMethod(paramString, paramArrayOfClass);
            MemberUtils.setAccessibleWorkaround(localMethod1);
            return localMethod1;
        } catch (NoSuchMethodException localNoSuchMethodException) {
            Object localObject = null;
            Method[] arrayOfMethod = paramClass.getMethods();
            int i = 0;
            int j = arrayOfMethod.length;
            for (paramClass = (Class) localObject; i < j; paramClass = (Class) localObject) {
                localObject = paramClass;
                if (arrayOfMethod[i].getName().equals(paramString)) {
                    localObject = paramClass;
                    if (ClassUtils.isAssignable(paramArrayOfClass, arrayOfMethod[i].getParameterTypes(), true)) {
                        Method localMethod2 = getAccessibleMethod(arrayOfMethod[i]);
                        localObject = paramClass;
                        if (localMethod2 != null) {
                            if (paramClass != null) {
                                localObject = paramClass;
                                if (MemberUtils.compareParameterTypes(localMethod2.getParameterTypes(), paramClass.getParameterTypes(), paramArrayOfClass) >= 0) {
                                }
                            } else {
                                localObject = localMethod2;
                            }
                        }
                    }
                }
                i += 1;
            }
            if (paramClass != null) {
                MemberUtils.setAccessibleWorkaround(paramClass);
            }
        }
        return paramClass;
    }

    public static Object invokeExactMethod(Object paramObject1, String paramString, Object paramObject2)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeExactMethod(paramObject1, paramString, new Object[]{paramObject2});
    }

    public static Object invokeExactMethod(Object paramObject, String paramString, Object[] paramArrayOfObject)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
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
        return invokeExactMethod(paramObject, paramString, arrayOfObject, paramArrayOfObject);
    }

    public static Object invokeExactMethod(Object paramObject, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] arrayOfObject = paramArrayOfObject;
        if (paramArrayOfObject == null) {
            arrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        paramArrayOfObject = paramArrayOfClass;
        if (paramArrayOfClass == null) {
            paramArrayOfObject = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        paramArrayOfObject = getAccessibleMethod(paramObject.getClass(), paramString, paramArrayOfObject);
        if (paramArrayOfObject == null) {
            throw new NoSuchMethodException("No such accessible method: " + paramString + "() on object: " + paramObject.getClass().getName());
        }
        return paramArrayOfObject.invoke(paramObject, arrayOfObject);
    }

    public static Object invokeExactStaticMethod(Class paramClass, String paramString, Object paramObject)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeExactStaticMethod(paramClass, paramString, new Object[]{paramObject});
    }

    public static Object invokeExactStaticMethod(Class paramClass, String paramString, Object[] paramArrayOfObject)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
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
        return invokeExactStaticMethod(paramClass, paramString, arrayOfObject, paramArrayOfObject);
    }

    public static Object invokeExactStaticMethod(Class paramClass, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] arrayOfObject = paramArrayOfObject;
        if (paramArrayOfObject == null) {
            arrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        paramArrayOfObject = paramArrayOfClass;
        if (paramArrayOfClass == null) {
            paramArrayOfObject = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        paramArrayOfObject = getAccessibleMethod(paramClass, paramString, paramArrayOfObject);
        if (paramArrayOfObject == null) {
            throw new NoSuchMethodException("No such accessible method: " + paramString + "() on class: " + paramClass.getName());
        }
        return paramArrayOfObject.invoke(null, arrayOfObject);
    }

    public static Object invokeMethod(Object paramObject1, String paramString, Object paramObject2)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeMethod(paramObject1, paramString, new Object[]{paramObject2});
    }

    public static Object invokeMethod(Object paramObject, String paramString, Object[] paramArrayOfObject)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
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
        return invokeMethod(paramObject, paramString, arrayOfObject, paramArrayOfObject);
    }

    public static Object invokeMethod(Object paramObject, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class[] arrayOfClass = paramArrayOfClass;
        if (paramArrayOfClass == null) {
            arrayOfClass = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        paramArrayOfClass = paramArrayOfObject;
        if (paramArrayOfObject == null) {
            paramArrayOfClass = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        paramArrayOfObject = getMatchingAccessibleMethod(paramObject.getClass(), paramString, arrayOfClass);
        if (paramArrayOfObject == null) {
            throw new NoSuchMethodException("No such accessible method: " + paramString + "() on object: " + paramObject.getClass().getName());
        }
        return paramArrayOfObject.invoke(paramObject, paramArrayOfClass);
    }

    public static Object invokeStaticMethod(Class paramClass, String paramString, Object paramObject)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeStaticMethod(paramClass, paramString, new Object[]{paramObject});
    }

    public static Object invokeStaticMethod(Class paramClass, String paramString, Object[] paramArrayOfObject)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
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
        return invokeStaticMethod(paramClass, paramString, arrayOfObject, paramArrayOfObject);
    }

    public static Object invokeStaticMethod(Class paramClass, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class[] arrayOfClass = paramArrayOfClass;
        if (paramArrayOfClass == null) {
            arrayOfClass = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        paramArrayOfClass = paramArrayOfObject;
        if (paramArrayOfObject == null) {
            paramArrayOfClass = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        paramArrayOfObject = getMatchingAccessibleMethod(paramClass, paramString, arrayOfClass);
        if (paramArrayOfObject == null) {
            throw new NoSuchMethodException("No such accessible method: " + paramString + "() on class: " + paramClass.getName());
        }
        return paramArrayOfObject.invoke(null, paramArrayOfClass);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/reflect/MethodUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */