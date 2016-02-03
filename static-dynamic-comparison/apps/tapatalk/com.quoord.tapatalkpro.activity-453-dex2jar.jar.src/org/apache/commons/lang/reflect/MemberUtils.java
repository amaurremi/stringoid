package org.apache.commons.lang.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.SystemUtils;

abstract class MemberUtils {
    private static final int ACCESS_TEST = 7;
    private static final Method IS_SYNTHETIC;
    private static final Class[] ORDERED_PRIMITIVE_TYPES;
    static Class class$java$lang$reflect$Member;

    static {
        localObject3 = null;
        Object localObject1 = localObject3;
        if (SystemUtils.isJavaVersionAtLeast(1.5F)) {
        }
        for (; ; ) {
            try {
                if (class$java$lang$reflect$Member != null) {
                    continue;
                }
                localObject1 = class$("java.lang.reflect.Member");
                class$java$lang$reflect$Member = (Class) localObject1;
                localObject1 = ((Class) localObject1).getMethod("isSynthetic", ArrayUtils.EMPTY_CLASS_ARRAY);
            } catch (Exception localException) {
                Object localObject2 = localObject3;
                continue;
            }
            IS_SYNTHETIC = (Method) localObject1;
            ORDERED_PRIMITIVE_TYPES = new Class[]{Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};
            return;
            localObject1 = class$java$lang$reflect$Member;
        }
    }

    static Class class$(String paramString) {
        try {
            paramString = Class.forName(paramString);
            return paramString;
        } catch (ClassNotFoundException paramString) {
            throw new NoClassDefFoundError(paramString.getMessage());
        }
    }

    static int compareParameterTypes(Class[] paramArrayOfClass1, Class[] paramArrayOfClass2, Class[] paramArrayOfClass3) {
        float f1 = getTotalTransformationCost(paramArrayOfClass3, paramArrayOfClass1);
        float f2 = getTotalTransformationCost(paramArrayOfClass3, paramArrayOfClass2);
        if (f1 < f2) {
            return -1;
        }
        if (f2 < f1) {
            return 1;
        }
        return 0;
    }

    private static float getObjectTransformationCost(Class paramClass1, Class paramClass2) {
        if (paramClass2.isPrimitive()) {
            f2 = getPrimitivePromotionCost(paramClass1, paramClass2);
            return f2;
        }
        float f2 = 0.0F;
        for (; ; ) {
            float f1 = f2;
            if (paramClass2 != null) {
                f1 = f2;
                if (!paramClass2.equals(paramClass1)) {
                    if ((!paramClass2.isInterface()) || (!ClassUtils.isAssignable(paramClass1, paramClass2))) {
                        break label64;
                    }
                    f1 = f2 + 0.25F;
                }
            }
            f2 = f1;
            if (paramClass2 != null) {
                break;
            }
            return f1 + 1.5F;
            label64:
            f2 += 1.0F;
            paramClass2 = paramClass2.getSuperclass();
        }
    }

    private static float getPrimitivePromotionCost(Class paramClass1, Class paramClass2) {
        float f1 = 0.0F;
        Class localClass = paramClass1;
        paramClass1 = localClass;
        if (!localClass.isPrimitive()) {
            f1 = 0.0F + 0.1F;
            paramClass1 = ClassUtils.wrapperToPrimitive(localClass);
        }
        int i = 0;
        for (float f2 = f1; (paramClass1 != paramClass2) && (i < ORDERED_PRIMITIVE_TYPES.length); f2 = f1) {
            localClass = paramClass1;
            f1 = f2;
            if (paramClass1 == ORDERED_PRIMITIVE_TYPES[i]) {
                f2 += 0.1F;
                localClass = paramClass1;
                f1 = f2;
                if (i < ORDERED_PRIMITIVE_TYPES.length - 1) {
                    localClass = ORDERED_PRIMITIVE_TYPES[(i + 1)];
                    f1 = f2;
                }
            }
            i += 1;
            paramClass1 = localClass;
        }
        return f2;
    }

    private static float getTotalTransformationCost(Class[] paramArrayOfClass1, Class[] paramArrayOfClass2) {
        float f = 0.0F;
        int i = 0;
        while (i < paramArrayOfClass1.length) {
            f += getObjectTransformationCost(paramArrayOfClass1[i], paramArrayOfClass2[i]);
            i += 1;
        }
        return f;
    }

    static boolean isAccessible(Member paramMember) {
        return (paramMember != null) && (Modifier.isPublic(paramMember.getModifiers())) && (!isSynthetic(paramMember));
    }

    static boolean isPackageAccess(int paramInt) {
        return (paramInt & 0x7) == 0;
    }

    static boolean isSynthetic(Member paramMember) {
        if (IS_SYNTHETIC != null) {
            try {
                boolean bool = ((Boolean) IS_SYNTHETIC.invoke(paramMember, null)).booleanValue();
                return bool;
            } catch (Exception paramMember) {
            }
        }
        return false;
    }

    static void setAccessibleWorkaround(AccessibleObject paramAccessibleObject) {
        if ((paramAccessibleObject == null) || (paramAccessibleObject.isAccessible())) {
        }
        Member localMember;
        do {
            return;
            localMember = (Member) paramAccessibleObject;
        }
        while ((!Modifier.isPublic(localMember.getModifiers())) || (!isPackageAccess(localMember.getDeclaringClass().getModifiers())));
        try {
            paramAccessibleObject.setAccessible(true);
            return;
        } catch (SecurityException paramAccessibleObject) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/reflect/MemberUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */