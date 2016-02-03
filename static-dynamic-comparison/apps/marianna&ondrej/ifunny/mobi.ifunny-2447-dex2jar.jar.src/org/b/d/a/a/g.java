package org.b.d.a.a;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public class g {
    private static String[] a = {"sun.beans.infos"};
    private static Map<Class<?>, n> b = Collections.synchronizedMap(new WeakHashMap(128));

    public static String a(String paramString) {
        String str;
        if (paramString == null) {
            str = null;
        }
        do {
            do {
                return str;
                str = paramString;
            } while (paramString.length() == 0);
            if (paramString.length() <= 1) {
                break;
            }
            str = paramString;
        } while (Character.isUpperCase(paramString.charAt(1)));
        paramString = paramString.toCharArray();
        paramString[0] = Character.toLowerCase(paramString[0]);
        return new String(paramString);
    }

    public static b a(Class<?> paramClass) {
        n localn2 = (n) b.get(paramClass);
        n localn1 = localn2;
        if (localn2 == null) {
            localn1 = b(paramClass, null, 1);
            b.put(paramClass, localn1);
        }
        return localn1;
    }

    private static b a(String paramString, Class<?> paramClass) {
        try {
            if (paramClass.getClassLoader() != null) {
                paramClass = (b) Class.forName(paramString, true, paramClass.getClassLoader()).newInstance();
                return paramClass;
            }
        } catch (Exception paramClass) {
            try {
                paramClass = (b) Class.forName(paramString, true, ClassLoader.getSystemClassLoader()).newInstance();
                return paramClass;
            } catch (Exception paramClass) {
            }
        }
        return (b) Class.forName(paramString, true, Thread.currentThread().getContextClassLoader()).newInstance();
    }

    private static n a(Class<?> paramClass1, Class<?> paramClass2, int paramInt) {
        Object localObject = null;
        if (paramInt == 1) {
            localObject = b(paramClass1);
        }
        localObject = new n(paramClass1, (b) localObject, paramClass2);
        int i;
        if (((n) localObject).a != null) {
            i = ((n) localObject).a.length - 1;
            while (i >= 0) {
                ((n) localObject).a(localObject.a[i], true);
                i -= 1;
            }
        }
        paramClass1 = paramClass1.getSuperclass();
        if (paramClass1 != paramClass2) {
            if (paramClass1 == null) {
                throw new f("Stop class is not super class of bean class");
            }
            i = paramInt;
            if (paramInt == 2) {
                i = 1;
            }
            paramClass1 = a(paramClass1, paramClass2, i);
            if (paramClass1 != null) {
                ((n) localObject).a(paramClass1, false);
            }
        }
        return (n) localObject;
    }

    private static b b(Class<?> paramClass) {
        Object localObject2 = paramClass.getName() + "BeanInfo";
        try {
            b localb = a((String) localObject2, paramClass);
            return localb;
        } catch (Exception localException1) {
            int i = ((String) localObject2).lastIndexOf('.');
            Object localObject1 = localObject2;
            if (i >= 0) {
                localObject1 = ((String) localObject2).substring(i + 1);
            }
            i = 0;
            while (i < a.length) {
                localObject2 = a[i] + "." + (String) localObject1;
                try {
                    localObject2 = a((String) localObject2, paramClass);
                    a locala = ((b) localObject2).e();
                    if ((locala != null) && (paramClass == locala.a())) {
                        return (b) localObject2;
                    }
                } catch (Exception localException2) {
                    i += 1;
                }
            }
            if (b.class.isAssignableFrom(paramClass)) {
                try {
                    paramClass = a(paramClass.getName(), paramClass);
                    return paramClass;
                } catch (Exception paramClass) {
                }
            }
        }
        return null;
    }

    private static n b(Class<?> paramClass1, Class<?> paramClass2, int paramInt) {
        paramClass1 = a(paramClass1, paramClass2, paramInt);
        paramClass1.h();
        return paramClass1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */