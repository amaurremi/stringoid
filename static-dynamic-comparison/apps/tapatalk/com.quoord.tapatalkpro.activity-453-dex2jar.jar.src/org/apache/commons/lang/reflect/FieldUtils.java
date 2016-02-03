package org.apache.commons.lang.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.ClassUtils;

public class FieldUtils {
    public static Field getDeclaredField(Class paramClass, String paramString) {
        return getDeclaredField(paramClass, paramString, false);
    }

    public static Field getDeclaredField(Class paramClass, String paramString, boolean paramBoolean) {
        if (paramClass == null) {
            throw new IllegalArgumentException("The class must not be null");
        }
        if (paramString == null) {
            throw new IllegalArgumentException("The field name must not be null");
        }
        try {
            paramClass = paramClass.getDeclaredField(paramString);
            if (!MemberUtils.isAccessible(paramClass)) {
                if (paramBoolean) {
                    paramClass.setAccessible(true);
                }
            } else {
                return paramClass;
            }
            return null;
        } catch (NoSuchFieldException paramClass) {
        }
        return null;
    }

    public static Field getField(Class paramClass, String paramString) {
        paramClass = getField(paramClass, paramString, false);
        MemberUtils.setAccessibleWorkaround(paramClass);
        return paramClass;
    }

    public static Field getField(Class paramClass, String paramString, boolean paramBoolean) {
        if (paramClass == null) {
            throw new IllegalArgumentException("The class must not be null");
        }
        if (paramString == null) {
            throw new IllegalArgumentException("The field name must not be null");
        }
        Object localObject = paramClass;
        while (localObject != null) {
            try {
                Field localField1 = ((Class) localObject).getDeclaredField(paramString);
                if (!Modifier.isPublic(localField1.getModifiers())) {
                    if (paramBoolean) {
                        localField1.setAccessible(true);
                    }
                } else {
                    return localField1;
                }
            } catch (NoSuchFieldException localNoSuchFieldException1) {
                localObject = ((Class) localObject).getSuperclass();
            }
        }
        localObject = null;
        Iterator localIterator = ClassUtils.getAllInterfaces(paramClass).iterator();
        while (localIterator.hasNext()) {
            try {
                Field localField2 = ((Class) localIterator.next()).getField(paramString);
                if (localObject == null) {
                    break label164;
                }
                throw new IllegalArgumentException("Reference to field " + paramString + " is ambiguous relative to " + paramClass + "; a matching field exists on two or more implemented interfaces.");
            } catch (NoSuchFieldException localNoSuchFieldException2) {
            }
            continue;
            label164:
            localObject = localNoSuchFieldException2;
        }
        return (Field) localObject;
    }

    public static Object readDeclaredField(Object paramObject, String paramString)
            throws IllegalAccessException {
        return readDeclaredField(paramObject, paramString, false);
    }

    public static Object readDeclaredField(Object paramObject, String paramString, boolean paramBoolean)
            throws IllegalAccessException {
        if (paramObject == null) {
            throw new IllegalArgumentException("target object must not be null");
        }
        Class localClass = paramObject.getClass();
        Field localField = getDeclaredField(localClass, paramString, paramBoolean);
        if (localField == null) {
            throw new IllegalArgumentException("Cannot locate declared field " + localClass.getName() + "." + paramString);
        }
        return readField(localField, paramObject);
    }

    public static Object readDeclaredStaticField(Class paramClass, String paramString)
            throws IllegalAccessException {
        return readDeclaredStaticField(paramClass, paramString, false);
    }

    public static Object readDeclaredStaticField(Class paramClass, String paramString, boolean paramBoolean)
            throws IllegalAccessException {
        Field localField = getDeclaredField(paramClass, paramString, paramBoolean);
        if (localField == null) {
            throw new IllegalArgumentException("Cannot locate declared field " + paramClass.getName() + "." + paramString);
        }
        return readStaticField(localField, false);
    }

    public static Object readField(Object paramObject, String paramString)
            throws IllegalAccessException {
        return readField(paramObject, paramString, false);
    }

    public static Object readField(Object paramObject, String paramString, boolean paramBoolean)
            throws IllegalAccessException {
        if (paramObject == null) {
            throw new IllegalArgumentException("target object must not be null");
        }
        Class localClass = paramObject.getClass();
        Field localField = getField(localClass, paramString, paramBoolean);
        if (localField == null) {
            throw new IllegalArgumentException("Cannot locate field " + paramString + " on " + localClass);
        }
        return readField(localField, paramObject);
    }

    public static Object readField(Field paramField, Object paramObject)
            throws IllegalAccessException {
        return readField(paramField, paramObject, false);
    }

    public static Object readField(Field paramField, Object paramObject, boolean paramBoolean)
            throws IllegalAccessException {
        if (paramField == null) {
            throw new IllegalArgumentException("The field must not be null");
        }
        if ((paramBoolean) && (!paramField.isAccessible())) {
            paramField.setAccessible(true);
        }
        for (; ; ) {
            return paramField.get(paramObject);
            MemberUtils.setAccessibleWorkaround(paramField);
        }
    }

    public static Object readStaticField(Class paramClass, String paramString)
            throws IllegalAccessException {
        return readStaticField(paramClass, paramString, false);
    }

    public static Object readStaticField(Class paramClass, String paramString, boolean paramBoolean)
            throws IllegalAccessException {
        Field localField = getField(paramClass, paramString, paramBoolean);
        if (localField == null) {
            throw new IllegalArgumentException("Cannot locate field " + paramString + " on " + paramClass);
        }
        return readStaticField(localField, false);
    }

    public static Object readStaticField(Field paramField)
            throws IllegalAccessException {
        return readStaticField(paramField, false);
    }

    public static Object readStaticField(Field paramField, boolean paramBoolean)
            throws IllegalAccessException {
        if (paramField == null) {
            throw new IllegalArgumentException("The field must not be null");
        }
        if (!Modifier.isStatic(paramField.getModifiers())) {
            throw new IllegalArgumentException("The field '" + paramField.getName() + "' is not static");
        }
        return readField(paramField, (Object) null, paramBoolean);
    }

    public static void writeDeclaredField(Object paramObject1, String paramString, Object paramObject2)
            throws IllegalAccessException {
        writeDeclaredField(paramObject1, paramString, paramObject2, false);
    }

    public static void writeDeclaredField(Object paramObject1, String paramString, Object paramObject2, boolean paramBoolean)
            throws IllegalAccessException {
        if (paramObject1 == null) {
            throw new IllegalArgumentException("target object must not be null");
        }
        Class localClass = paramObject1.getClass();
        Field localField = getDeclaredField(localClass, paramString, paramBoolean);
        if (localField == null) {
            throw new IllegalArgumentException("Cannot locate declared field " + localClass.getName() + "." + paramString);
        }
        writeField(localField, paramObject1, paramObject2);
    }

    public static void writeDeclaredStaticField(Class paramClass, String paramString, Object paramObject)
            throws IllegalAccessException {
        writeDeclaredStaticField(paramClass, paramString, paramObject, false);
    }

    public static void writeDeclaredStaticField(Class paramClass, String paramString, Object paramObject, boolean paramBoolean)
            throws IllegalAccessException {
        Field localField = getDeclaredField(paramClass, paramString, paramBoolean);
        if (localField == null) {
            throw new IllegalArgumentException("Cannot locate declared field " + paramClass.getName() + "." + paramString);
        }
        writeField(localField, (Object) null, paramObject);
    }

    public static void writeField(Object paramObject1, String paramString, Object paramObject2)
            throws IllegalAccessException {
        writeField(paramObject1, paramString, paramObject2, false);
    }

    public static void writeField(Object paramObject1, String paramString, Object paramObject2, boolean paramBoolean)
            throws IllegalAccessException {
        if (paramObject1 == null) {
            throw new IllegalArgumentException("target object must not be null");
        }
        Class localClass = paramObject1.getClass();
        Field localField = getField(localClass, paramString, paramBoolean);
        if (localField == null) {
            throw new IllegalArgumentException("Cannot locate declared field " + localClass.getName() + "." + paramString);
        }
        writeField(localField, paramObject1, paramObject2);
    }

    public static void writeField(Field paramField, Object paramObject1, Object paramObject2)
            throws IllegalAccessException {
        writeField(paramField, paramObject1, paramObject2, false);
    }

    public static void writeField(Field paramField, Object paramObject1, Object paramObject2, boolean paramBoolean)
            throws IllegalAccessException {
        if (paramField == null) {
            throw new IllegalArgumentException("The field must not be null");
        }
        if ((paramBoolean) && (!paramField.isAccessible())) {
            paramField.setAccessible(true);
        }
        for (; ; ) {
            paramField.set(paramObject1, paramObject2);
            return;
            MemberUtils.setAccessibleWorkaround(paramField);
        }
    }

    public static void writeStaticField(Class paramClass, String paramString, Object paramObject)
            throws IllegalAccessException {
        writeStaticField(paramClass, paramString, paramObject, false);
    }

    public static void writeStaticField(Class paramClass, String paramString, Object paramObject, boolean paramBoolean)
            throws IllegalAccessException {
        Field localField = getField(paramClass, paramString, paramBoolean);
        if (localField == null) {
            throw new IllegalArgumentException("Cannot locate field " + paramString + " on " + paramClass);
        }
        writeStaticField(localField, paramObject);
    }

    public static void writeStaticField(Field paramField, Object paramObject)
            throws IllegalAccessException {
        writeStaticField(paramField, paramObject, false);
    }

    public static void writeStaticField(Field paramField, Object paramObject, boolean paramBoolean)
            throws IllegalAccessException {
        if (paramField == null) {
            throw new IllegalArgumentException("The field must not be null");
        }
        if (!Modifier.isStatic(paramField.getModifiers())) {
            throw new IllegalArgumentException("The field '" + paramField.getName() + "' is not static");
        }
        writeField(paramField, (Object) null, paramObject, paramBoolean);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/reflect/FieldUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */