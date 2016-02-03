package org.apache.commons.lang;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ClassUtils {
    public static final String INNER_CLASS_SEPARATOR;
    public static final char INNER_CLASS_SEPARATOR_CHAR = '$';
    public static final String PACKAGE_SEPARATOR = String.valueOf('.');
    public static final char PACKAGE_SEPARATOR_CHAR = '.';
    private static final Map abbreviationMap;
    static Class class$java$lang$Boolean;
    static Class class$java$lang$Byte;
    static Class class$java$lang$Character;
    static Class class$java$lang$Double;
    static Class class$java$lang$Float;
    static Class class$java$lang$Integer;
    static Class class$java$lang$Long;
    static Class class$java$lang$Short;
    static Class class$org$apache$commons$lang$ClassUtils;
    private static final Map primitiveWrapperMap;
    private static final Map reverseAbbreviationMap;
    private static final Map wrapperPrimitiveMap;

    static {
        INNER_CLASS_SEPARATOR = String.valueOf('$');
        primitiveWrapperMap = new HashMap();
        Object localObject2 = primitiveWrapperMap;
        Class localClass = Boolean.TYPE;
        Object localObject1;
        if (class$java$lang$Boolean == null) {
            localObject1 = class$("java.lang.Boolean");
            class$java$lang$Boolean = (Class) localObject1;
            ((Map) localObject2).put(localClass, localObject1);
            localObject2 = primitiveWrapperMap;
            localClass = Byte.TYPE;
            if (class$java$lang$Byte != null) {
                break label390;
            }
            localObject1 = class$("java.lang.Byte");
            class$java$lang$Byte = (Class) localObject1;
            label83:
            ((Map) localObject2).put(localClass, localObject1);
            localObject2 = primitiveWrapperMap;
            localClass = Character.TYPE;
            if (class$java$lang$Character != null) {
                break label397;
            }
            localObject1 = class$("java.lang.Character");
            class$java$lang$Character = (Class) localObject1;
            label116:
            ((Map) localObject2).put(localClass, localObject1);
            localObject2 = primitiveWrapperMap;
            localClass = Short.TYPE;
            if (class$java$lang$Short != null) {
                break label404;
            }
            localObject1 = class$("java.lang.Short");
            class$java$lang$Short = (Class) localObject1;
            label149:
            ((Map) localObject2).put(localClass, localObject1);
            localObject2 = primitiveWrapperMap;
            localClass = Integer.TYPE;
            if (class$java$lang$Integer != null) {
                break label411;
            }
            localObject1 = class$("java.lang.Integer");
            class$java$lang$Integer = (Class) localObject1;
            label182:
            ((Map) localObject2).put(localClass, localObject1);
            localObject2 = primitiveWrapperMap;
            localClass = Long.TYPE;
            if (class$java$lang$Long != null) {
                break label418;
            }
            localObject1 = class$("java.lang.Long");
            class$java$lang$Long = (Class) localObject1;
            label215:
            ((Map) localObject2).put(localClass, localObject1);
            localObject2 = primitiveWrapperMap;
            localClass = Double.TYPE;
            if (class$java$lang$Double != null) {
                break label425;
            }
            localObject1 = class$("java.lang.Double");
            class$java$lang$Double = (Class) localObject1;
            label248:
            ((Map) localObject2).put(localClass, localObject1);
            localObject2 = primitiveWrapperMap;
            localClass = Float.TYPE;
            if (class$java$lang$Float != null) {
                break label432;
            }
            localObject1 = class$("java.lang.Float");
            class$java$lang$Float = (Class) localObject1;
        }
        for (; ; ) {
            ((Map) localObject2).put(localClass, localObject1);
            primitiveWrapperMap.put(Void.TYPE, Void.TYPE);
            wrapperPrimitiveMap = new HashMap();
            localObject1 = primitiveWrapperMap.keySet().iterator();
            while (((Iterator) localObject1).hasNext()) {
                localObject2 = (Class) ((Iterator) localObject1).next();
                localClass = (Class) primitiveWrapperMap.get(localObject2);
                if (!localObject2.equals(localClass)) {
                    wrapperPrimitiveMap.put(localClass, localObject2);
                }
            }
            localObject1 = class$java$lang$Boolean;
            break;
            label390:
            localObject1 = class$java$lang$Byte;
            break label83;
            label397:
            localObject1 = class$java$lang$Character;
            break label116;
            label404:
            localObject1 = class$java$lang$Short;
            break label149;
            label411:
            localObject1 = class$java$lang$Integer;
            break label182;
            label418:
            localObject1 = class$java$lang$Long;
            break label215;
            label425:
            localObject1 = class$java$lang$Double;
            break label248;
            label432:
            localObject1 = class$java$lang$Float;
        }
        abbreviationMap = new HashMap();
        reverseAbbreviationMap = new HashMap();
        addAbbreviation("int", "I");
        addAbbreviation("boolean", "Z");
        addAbbreviation("float", "F");
        addAbbreviation("long", "J");
        addAbbreviation("short", "S");
        addAbbreviation("byte", "B");
        addAbbreviation("double", "D");
        addAbbreviation("char", "C");
    }

    private static void addAbbreviation(String paramString1, String paramString2) {
        abbreviationMap.put(paramString1, paramString2);
        reverseAbbreviationMap.put(paramString2, paramString1);
    }

    static Class class$(String paramString) {
        try {
            paramString = Class.forName(paramString);
            return paramString;
        } catch (ClassNotFoundException paramString) {
            throw new NoClassDefFoundError(paramString.getMessage());
        }
    }

    public static List convertClassNamesToClasses(List paramList) {
        if (paramList == null) {
            paramList = null;
            return paramList;
        }
        ArrayList localArrayList = new ArrayList(paramList.size());
        Iterator localIterator = paramList.iterator();
        for (; ; ) {
            paramList = localArrayList;
            if (!localIterator.hasNext()) {
                break;
            }
            paramList = (String) localIterator.next();
            try {
                localArrayList.add(Class.forName(paramList));
            } catch (Exception paramList) {
                localArrayList.add(null);
            }
        }
    }

    public static List convertClassesToClassNames(List paramList) {
        if (paramList == null) {
            paramList = null;
            return paramList;
        }
        ArrayList localArrayList = new ArrayList(paramList.size());
        Iterator localIterator = paramList.iterator();
        for (; ; ) {
            paramList = localArrayList;
            if (!localIterator.hasNext()) {
                break;
            }
            paramList = (Class) localIterator.next();
            if (paramList == null) {
                localArrayList.add(null);
            } else {
                localArrayList.add(paramList.getName());
            }
        }
    }

    public static List getAllInterfaces(Class paramClass) {
        if (paramClass == null) {
            return null;
        }
        ArrayList localArrayList = new ArrayList();
        getAllInterfaces(paramClass, localArrayList);
        return localArrayList;
    }

    private static void getAllInterfaces(Class paramClass, List paramList) {
        while (paramClass != null) {
            Class[] arrayOfClass = paramClass.getInterfaces();
            int i = 0;
            while (i < arrayOfClass.length) {
                if (!paramList.contains(arrayOfClass[i])) {
                    paramList.add(arrayOfClass[i]);
                    getAllInterfaces(arrayOfClass[i], paramList);
                }
                i += 1;
            }
            paramClass = paramClass.getSuperclass();
        }
    }

    public static List getAllSuperclasses(Class paramClass) {
        if (paramClass == null) {
            paramClass = null;
            return paramClass;
        }
        ArrayList localArrayList = new ArrayList();
        for (Class localClass = paramClass.getSuperclass(); ; localClass = localClass.getSuperclass()) {
            paramClass = localArrayList;
            if (localClass == null) {
                break;
            }
            localArrayList.add(localClass);
        }
    }

    private static String getCanonicalName(String paramString) {
        paramString = StringUtils.deleteWhitespace(paramString);
        String str;
        if (paramString == null) {
            str = null;
        }
        int i;
        do {
            return str;
            i = 0;
            while (paramString.startsWith("[")) {
                i += 1;
                paramString = paramString.substring(1);
            }
            str = paramString;
        } while (i < 1);
        int j;
        if (paramString.startsWith("L")) {
            if (paramString.endsWith(";")) {
                j = paramString.length() - 1;
                str = paramString.substring(1, j);
            }
        }
        for (; ; ) {
            paramString = new StringBuffer(str);
            j = 0;
            while (j < i) {
                paramString.append("[]");
                j += 1;
            }
            j = paramString.length();
            break;
            str = paramString;
            if (paramString.length() > 0) {
                str = (String) reverseAbbreviationMap.get(paramString.substring(0, 1));
            }
        }
        return paramString.toString();
    }

    public static Class getClass(ClassLoader paramClassLoader, String paramString)
            throws ClassNotFoundException {
        return getClass(paramClassLoader, paramString, true);
    }

    public static Class getClass(ClassLoader paramClassLoader, String paramString, boolean paramBoolean)
            throws ClassNotFoundException {
        if (abbreviationMap.containsKey(paramString)) {
            return Class.forName("[" + abbreviationMap.get(paramString), paramBoolean, paramClassLoader).getComponentType();
        }
        return Class.forName(toCanonicalName(paramString), paramBoolean, paramClassLoader);
    }

    public static Class getClass(String paramString)
            throws ClassNotFoundException {
        return getClass(paramString, true);
    }

    public static Class getClass(String paramString, boolean paramBoolean)
            throws ClassNotFoundException {
        Object localObject = Thread.currentThread().getContextClassLoader();
        if (localObject == null) {
            if (class$org$apache$commons$lang$ClassUtils == null) {
                localObject = class$("org.apache.commons.lang.ClassUtils");
                class$org$apache$commons$lang$ClassUtils = (Class) localObject;
                localObject = ((Class) localObject).getClassLoader();
            }
        }
        for (; ; ) {
            return getClass((ClassLoader) localObject, paramString, paramBoolean);
            localObject = class$org$apache$commons$lang$ClassUtils;
            break;
        }
    }

    public static String getPackageCanonicalName(Class paramClass) {
        if (paramClass == null) {
            return "";
        }
        return getPackageCanonicalName(paramClass.getName());
    }

    public static String getPackageCanonicalName(Object paramObject, String paramString) {
        if (paramObject == null) {
            return paramString;
        }
        return getPackageCanonicalName(paramObject.getClass().getName());
    }

    public static String getPackageCanonicalName(String paramString) {
        return getPackageName(getCanonicalName(paramString));
    }

    public static String getPackageName(Class paramClass) {
        if (paramClass == null) {
            return "";
        }
        return getPackageName(paramClass.getName());
    }

    public static String getPackageName(Object paramObject, String paramString) {
        if (paramObject == null) {
            return paramString;
        }
        return getPackageName(paramObject.getClass());
    }

    public static String getPackageName(String paramString) {
        String str;
        if (paramString != null) {
            str = paramString;
            if (paramString.length() != 0) {
            }
        } else {
            return "";
        }
        while (str.charAt(0) == '[') {
            str = str.substring(1);
        }
        paramString = str;
        if (str.charAt(0) == 'L') {
            paramString = str;
            if (str.charAt(str.length() - 1) == ';') {
                paramString = str.substring(1);
            }
        }
        int i = paramString.lastIndexOf('.');
        if (i == -1) {
            return "";
        }
        return paramString.substring(0, i);
    }

    public static Method getPublicMethod(Class paramClass, String paramString, Class[] paramArrayOfClass)
            throws SecurityException, NoSuchMethodException {
        Object localObject = paramClass.getMethod(paramString, paramArrayOfClass);
        if (Modifier.isPublic(((Method) localObject).getDeclaringClass().getModifiers())) {
            return (Method) localObject;
        }
        localObject = new ArrayList();
        ((List) localObject).addAll(getAllInterfaces(paramClass));
        ((List) localObject).addAll(getAllSuperclasses(paramClass));
        paramClass = ((List) localObject).iterator();
        while (paramClass.hasNext()) {
            localObject = (Class) paramClass.next();
            if (Modifier.isPublic(((Class) localObject).getModifiers())) {
                try {
                    localObject = ((Class) localObject).getMethod(paramString, paramArrayOfClass);
                    if (Modifier.isPublic(((Method) localObject).getDeclaringClass().getModifiers())) {
                        return (Method) localObject;
                    }
                } catch (NoSuchMethodException localNoSuchMethodException) {
                }
            }
        }
        throw new NoSuchMethodException("Can't find a public method for " + paramString + " " + ArrayUtils.toString(paramArrayOfClass));
    }

    public static String getShortCanonicalName(Class paramClass) {
        if (paramClass == null) {
            return "";
        }
        return getShortCanonicalName(paramClass.getName());
    }

    public static String getShortCanonicalName(Object paramObject, String paramString) {
        if (paramObject == null) {
            return paramString;
        }
        return getShortCanonicalName(paramObject.getClass().getName());
    }

    public static String getShortCanonicalName(String paramString) {
        return getShortClassName(getCanonicalName(paramString));
    }

    public static String getShortClassName(Class paramClass) {
        if (paramClass == null) {
            return "";
        }
        return getShortClassName(paramClass.getName());
    }

    public static String getShortClassName(Object paramObject, String paramString) {
        if (paramObject == null) {
            return paramString;
        }
        return getShortClassName(paramObject.getClass());
    }

    public static String getShortClassName(String paramString) {
        int i = 0;
        if (paramString == null) {
            return "";
        }
        if (paramString.length() == 0) {
            return "";
        }
        StringBuffer localStringBuffer = new StringBuffer();
        String str = paramString;
        if (paramString.startsWith("[")) {
            while (paramString.charAt(0) == '[') {
                paramString = paramString.substring(1);
                localStringBuffer.append("[]");
            }
            str = paramString;
            if (paramString.charAt(0) == 'L') {
                str = paramString;
                if (paramString.charAt(paramString.length() - 1) == ';') {
                    str = paramString.substring(1, paramString.length() - 1);
                }
            }
        }
        paramString = str;
        if (reverseAbbreviationMap.containsKey(str)) {
            paramString = (String) reverseAbbreviationMap.get(str);
        }
        int j = paramString.lastIndexOf('.');
        if (j == -1) {
        }
        for (; ; ) {
            i = paramString.indexOf('$', i);
            str = paramString.substring(j + 1);
            paramString = str;
            if (i != -1) {
                paramString = str.replace('$', '.');
            }
            return paramString + localStringBuffer;
            i = j + 1;
        }
    }

    public static boolean isAssignable(Class paramClass1, Class paramClass2) {
        return isAssignable(paramClass1, paramClass2, false);
    }

    public static boolean isAssignable(Class paramClass1, Class paramClass2, boolean paramBoolean) {
        boolean bool = true;
        if (paramClass2 == null) {
        }
        Object localObject;
        label101:
        do {
            do {
                do {
                    do {
                        do {
                            do {
                                do {
                                    do {
                                        Class localClass;
                                        do {
                                            return false;
                                            if (paramClass1 == null) {
                                                if (!paramClass2.isPrimitive()) {
                                                }
                                                for (paramBoolean = bool; ; paramBoolean = false) {
                                                    return paramBoolean;
                                                }
                                            }
                                            localObject = paramClass1;
                                            if (!paramBoolean) {
                                                break label101;
                                            }
                                            localClass = paramClass1;
                                            if (!paramClass1.isPrimitive()) {
                                                break;
                                            }
                                            localClass = paramClass1;
                                            if (paramClass2.isPrimitive()) {
                                                break;
                                            }
                                            localClass = primitiveToWrapper(paramClass1);
                                        } while (localClass == null);
                                        localObject = localClass;
                                        if (!paramClass2.isPrimitive()) {
                                            break;
                                        }
                                        localObject = localClass;
                                        if (localClass.isPrimitive()) {
                                            break;
                                        }
                                        localObject = wrapperToPrimitive(localClass);
                                    } while (localObject == null);
                                    if (localObject.equals(paramClass2)) {
                                        return true;
                                    }
                                    if (!((Class) localObject).isPrimitive()) {
                                        break;
                                    }
                                } while (!paramClass2.isPrimitive());
                                if (!Integer.TYPE.equals(localObject)) {
                                    break;
                                }
                            }
                            while ((!Long.TYPE.equals(paramClass2)) && (!Float.TYPE.equals(paramClass2)) && (!Double.TYPE.equals(paramClass2)));
                            return true;
                            if (!Long.TYPE.equals(localObject)) {
                                break;
                            }
                        } while ((!Float.TYPE.equals(paramClass2)) && (!Double.TYPE.equals(paramClass2)));
                        return true;
                    } while ((Boolean.TYPE.equals(localObject)) || (Double.TYPE.equals(localObject)));
                    if (Float.TYPE.equals(localObject)) {
                        return Double.TYPE.equals(paramClass2);
                    }
                    if (!Character.TYPE.equals(localObject)) {
                        break;
                    }
                }
                while ((!Integer.TYPE.equals(paramClass2)) && (!Long.TYPE.equals(paramClass2)) && (!Float.TYPE.equals(paramClass2)) && (!Double.TYPE.equals(paramClass2)));
                return true;
                if (!Short.TYPE.equals(localObject)) {
                    break;
                }
            }
            while ((!Integer.TYPE.equals(paramClass2)) && (!Long.TYPE.equals(paramClass2)) && (!Float.TYPE.equals(paramClass2)) && (!Double.TYPE.equals(paramClass2)));
            return true;
        }
        while ((!Byte.TYPE.equals(localObject)) || ((!Short.TYPE.equals(paramClass2)) && (!Integer.TYPE.equals(paramClass2)) && (!Long.TYPE.equals(paramClass2)) && (!Float.TYPE.equals(paramClass2)) && (!Double.TYPE.equals(paramClass2))));
        return true;
        return paramClass2.isAssignableFrom((Class) localObject);
    }

    public static boolean isAssignable(Class[] paramArrayOfClass1, Class[] paramArrayOfClass2) {
        return isAssignable(paramArrayOfClass1, paramArrayOfClass2, false);
    }

    public static boolean isAssignable(Class[] paramArrayOfClass1, Class[] paramArrayOfClass2, boolean paramBoolean) {
        if (!ArrayUtils.isSameLength(paramArrayOfClass1, paramArrayOfClass2)) {
            return false;
        }
        Class[] arrayOfClass = paramArrayOfClass1;
        if (paramArrayOfClass1 == null) {
            arrayOfClass = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        paramArrayOfClass1 = paramArrayOfClass2;
        if (paramArrayOfClass2 == null) {
            paramArrayOfClass1 = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        int i = 0;
        for (; ; ) {
            if (i >= arrayOfClass.length) {
                break label62;
            }
            if (!isAssignable(arrayOfClass[i], paramArrayOfClass1[i], paramBoolean)) {
                break;
            }
            i += 1;
        }
        label62:
        return true;
    }

    public static boolean isInnerClass(Class paramClass) {
        if (paramClass == null) {
        }
        while (paramClass.getName().indexOf('$') < 0) {
            return false;
        }
        return true;
    }

    public static Class primitiveToWrapper(Class paramClass) {
        Class localClass1 = paramClass;
        Class localClass2 = localClass1;
        if (paramClass != null) {
            localClass2 = localClass1;
            if (paramClass.isPrimitive()) {
                localClass2 = (Class) primitiveWrapperMap.get(paramClass);
            }
        }
        return localClass2;
    }

    public static Class[] primitivesToWrappers(Class[] paramArrayOfClass) {
        if (paramArrayOfClass == null) {
            arrayOfClass = null;
        }
        do {
            return arrayOfClass;
            arrayOfClass = paramArrayOfClass;
        } while (paramArrayOfClass.length == 0);
        Class[] arrayOfClass = new Class[paramArrayOfClass.length];
        int i = 0;
        while (i < paramArrayOfClass.length) {
            arrayOfClass[i] = primitiveToWrapper(paramArrayOfClass[i]);
            i += 1;
        }
        return arrayOfClass;
    }

    private static String toCanonicalName(String paramString) {
        paramString = StringUtils.deleteWhitespace(paramString);
        if (paramString == null) {
            throw new NullArgumentException("className");
        }
        Object localObject = paramString;
        if (paramString.endsWith("[]")) {
            localObject = new StringBuffer();
            while (paramString.endsWith("[]")) {
                paramString = paramString.substring(0, paramString.length() - 2);
                ((StringBuffer) localObject).append("[");
            }
            String str = (String) abbreviationMap.get(paramString);
            if (str == null) {
                break label102;
            }
            ((StringBuffer) localObject).append(str);
        }
        for (; ; ) {
            localObject = ((StringBuffer) localObject).toString();
            return (String) localObject;
            label102:
            ((StringBuffer) localObject).append("L").append(paramString).append(";");
        }
    }

    public static Class[] toClass(Object[] paramArrayOfObject) {
        if (paramArrayOfObject == null) {
            return null;
        }
        if (paramArrayOfObject.length == 0) {
            return ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        Class[] arrayOfClass = new Class[paramArrayOfObject.length];
        int i = 0;
        if (i < paramArrayOfObject.length) {
            if (paramArrayOfObject[i] == null) {
            }
            for (Class localClass = null; ; localClass = paramArrayOfObject[i].getClass()) {
                arrayOfClass[i] = localClass;
                i += 1;
                break;
            }
        }
        return arrayOfClass;
    }

    public static Class wrapperToPrimitive(Class paramClass) {
        return (Class) wrapperPrimitiveMap.get(paramClass);
    }

    public static Class[] wrappersToPrimitives(Class[] paramArrayOfClass) {
        if (paramArrayOfClass == null) {
            arrayOfClass = null;
        }
        do {
            return arrayOfClass;
            arrayOfClass = paramArrayOfClass;
        } while (paramArrayOfClass.length == 0);
        Class[] arrayOfClass = new Class[paramArrayOfClass.length];
        int i = 0;
        while (i < paramArrayOfClass.length) {
            arrayOfClass[i] = wrapperToPrimitive(paramArrayOfClass[i]);
            i += 1;
        }
        return arrayOfClass;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/ClassUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */