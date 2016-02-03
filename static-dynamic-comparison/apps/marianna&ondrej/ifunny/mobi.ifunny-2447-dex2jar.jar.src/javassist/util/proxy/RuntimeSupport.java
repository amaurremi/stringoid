package javassist.util.proxy;

import java.lang.reflect.Method;

public class RuntimeSupport {
    public static MethodHandler default_interceptor = new RuntimeSupport.DefaultMethodHandler();

    private static void error(Object paramObject, String paramString1, String paramString2) {
        throw new RuntimeException("not found " + paramString1 + ":" + paramString2 + " in " + paramObject.getClass().getName());
    }

    public static void find2Methods(Object paramObject, String paramString1, String paramString2, int paramInt, String paramString3, Method[] paramArrayOfMethod) {
        if (paramArrayOfMethod[paramInt] == null) {
            if (paramString2 != null) {
                break label38;
            }
        }
        for (paramString2 = null; ; paramString2 = findMethod(paramObject, paramString2, paramString3)) {
            paramArrayOfMethod[(paramInt + 1)] = paramString2;
            label38:
            try {
                paramArrayOfMethod[paramInt] = findSuperMethod(paramObject, paramString1, paramString3);
                return;
            } finally {
            }
        }
    }

    public static Method findMethod(Object paramObject, String paramString1, String paramString2) {
        Method localMethod = findMethod2(paramObject.getClass(), paramString1, paramString2);
        if (localMethod == null) {
            error(paramObject, paramString1, paramString2);
        }
        return localMethod;
    }

    private static Method findMethod2(Class paramClass, String paramString1, String paramString2) {
        paramClass = SecurityActions.getDeclaredMethods(paramClass);
        int j = paramClass.length;
        int i = 0;
        while (i < j) {
            if ((paramClass[i].getName().equals(paramString1)) && (makeDescriptor(paramClass[i]).equals(paramString2))) {
                return paramClass[i];
            }
            i += 1;
        }
        return null;
    }

    public static Method findSuperMethod(Object paramObject, String paramString1, String paramString2) {
        Class localClass = paramObject.getClass();
        Method localMethod2 = findSuperMethod2(localClass.getSuperclass(), paramString1, paramString2);
        Method localMethod1 = localMethod2;
        if (localMethod2 == null) {
            localMethod1 = searchInterfaces(localClass, paramString1, paramString2);
        }
        if (localMethod1 == null) {
            error(paramObject, paramString1, paramString2);
        }
        return localMethod1;
    }

    private static Method findSuperMethod2(Class paramClass, String paramString1, String paramString2) {
        Object localObject = findMethod2(paramClass, paramString1, paramString2);
        if (localObject != null) {
        }
        Method localMethod;
        do {
            return (Method) localObject;
            localObject = paramClass.getSuperclass();
            if (localObject == null) {
                break;
            }
            localMethod = findSuperMethod2((Class) localObject, paramString1, paramString2);
            localObject = localMethod;
        } while (localMethod != null);
        return searchInterfaces(paramClass, paramString1, paramString2);
    }

    private static void makeDesc(StringBuffer paramStringBuffer, Class paramClass) {
        if (paramClass.isArray()) {
            paramStringBuffer.append('[');
            makeDesc(paramStringBuffer, paramClass.getComponentType());
            return;
        }
        if (paramClass.isPrimitive()) {
            if (paramClass == Void.TYPE) {
                paramStringBuffer.append('V');
                return;
            }
            if (paramClass == Integer.TYPE) {
                paramStringBuffer.append('I');
                return;
            }
            if (paramClass == Byte.TYPE) {
                paramStringBuffer.append('B');
                return;
            }
            if (paramClass == Long.TYPE) {
                paramStringBuffer.append('J');
                return;
            }
            if (paramClass == Double.TYPE) {
                paramStringBuffer.append('D');
                return;
            }
            if (paramClass == Float.TYPE) {
                paramStringBuffer.append('F');
                return;
            }
            if (paramClass == Character.TYPE) {
                paramStringBuffer.append('C');
                return;
            }
            if (paramClass == Short.TYPE) {
                paramStringBuffer.append('S');
                return;
            }
            if (paramClass == Boolean.TYPE) {
                paramStringBuffer.append('Z');
                return;
            }
            throw new RuntimeException("bad type: " + paramClass.getName());
        }
        paramStringBuffer.append('L').append(paramClass.getName().replace('.', '/')).append(';');
    }

    public static String makeDescriptor(String paramString, Class paramClass) {
        paramString = new StringBuffer(paramString);
        makeDesc(paramString, paramClass);
        return paramString.toString();
    }

    public static String makeDescriptor(Method paramMethod) {
        return makeDescriptor(paramMethod.getParameterTypes(), paramMethod.getReturnType());
    }

    public static String makeDescriptor(Class[] paramArrayOfClass, Class paramClass) {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append('(');
        int i = 0;
        while (i < paramArrayOfClass.length) {
            makeDesc(localStringBuffer, paramArrayOfClass[i]);
            i += 1;
        }
        localStringBuffer.append(')');
        if (paramClass != null) {
            makeDesc(localStringBuffer, paramClass);
        }
        return localStringBuffer.toString();
    }

    public static SerializedProxy makeSerializedProxy(Object paramObject) {
        Class localClass = paramObject.getClass();
        MethodHandler localMethodHandler = null;
        if ((paramObject instanceof ProxyObject)) {
            localMethodHandler = ((ProxyObject) paramObject).getHandler();
        }
        for (; ; ) {
            return new SerializedProxy(localClass, ProxyFactory.getFilterSignature(localClass), localMethodHandler);
            if ((paramObject instanceof Proxy)) {
                localMethodHandler = ProxyFactory.getHandler((Proxy) paramObject);
            }
        }
    }

    private static Method searchInterfaces(Class paramClass, String paramString1, String paramString2) {
        Object localObject = null;
        Class[] arrayOfClass = paramClass.getInterfaces();
        int i = 0;
        paramClass = (Class) localObject;
        for (; ; ) {
            if (i < arrayOfClass.length) {
                paramClass = findSuperMethod2(arrayOfClass[i], paramString1, paramString2);
                if (paramClass == null) {
                }
            } else {
                return paramClass;
            }
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/util/proxy/RuntimeSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */