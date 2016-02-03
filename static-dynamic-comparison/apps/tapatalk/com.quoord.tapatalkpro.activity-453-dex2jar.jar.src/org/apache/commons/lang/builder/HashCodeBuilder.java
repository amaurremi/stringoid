package org.apache.commons.lang.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;

public class HashCodeBuilder {
    private static final ThreadLocal REGISTRY = new ThreadLocal();
    static Class class$org$apache$commons$lang$builder$HashCodeBuilder;
    private final int iConstant;
    private int iTotal = 0;

    public HashCodeBuilder() {
        this.iConstant = 37;
        this.iTotal = 17;
    }

    public HashCodeBuilder(int paramInt1, int paramInt2) {
        if (paramInt1 == 0) {
            throw new IllegalArgumentException("HashCodeBuilder requires a non zero initial value");
        }
        if (paramInt1 % 2 == 0) {
            throw new IllegalArgumentException("HashCodeBuilder requires an odd initial value");
        }
        if (paramInt2 == 0) {
            throw new IllegalArgumentException("HashCodeBuilder requires a non zero multiplier");
        }
        if (paramInt2 % 2 == 0) {
            throw new IllegalArgumentException("HashCodeBuilder requires an odd multiplier");
        }
        this.iConstant = paramInt2;
        this.iTotal = paramInt1;
    }

    static Class class$(String paramString) {
        try {
            paramString = Class.forName(paramString);
            return paramString;
        } catch (ClassNotFoundException paramString) {
            throw new NoClassDefFoundError(paramString.getMessage());
        }
    }

    static Set getRegistry() {
        return (Set) REGISTRY.get();
    }

    static boolean isRegistered(Object paramObject) {
        Set localSet = getRegistry();
        return (localSet != null) && (localSet.contains(new IDKey(paramObject)));
    }

    private static void reflectionAppend(Object paramObject, Class paramClass, HashCodeBuilder paramHashCodeBuilder, boolean paramBoolean, String[] paramArrayOfString) {
        if (isRegistered(paramObject)) {
            return;
        }
        try {
            register(paramObject);
            paramClass = paramClass.getDeclaredFields();
            AccessibleObject.setAccessible(paramClass, true);
            int i = 0;
            for (; ; ) {
                if (i < paramClass.length) {
                    Object localObject = paramClass[i];
                    if ((!ArrayUtils.contains(paramArrayOfString, ((Field) localObject).getName())) && (((Field) localObject).getName().indexOf('$') == -1) && ((paramBoolean) || (!Modifier.isTransient(((Field) localObject).getModifiers())))) {
                        boolean bool = Modifier.isStatic(((Field) localObject).getModifiers());
                        if (bool) {
                        }
                    }
                    try {
                        paramHashCodeBuilder.append(((Field) localObject).get(paramObject));
                        i += 1;
                    } catch (IllegalAccessException paramClass) {
                        throw new InternalError("Unexpected IllegalAccessException");
                    }
                }
            }
        } finally {
            unregister(paramObject);
        }
    }

    public static int reflectionHashCode(int paramInt1, int paramInt2, Object paramObject) {
        return reflectionHashCode(paramInt1, paramInt2, paramObject, false, null, null);
    }

    public static int reflectionHashCode(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean) {
        return reflectionHashCode(paramInt1, paramInt2, paramObject, paramBoolean, null, null);
    }

    public static int reflectionHashCode(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean, Class paramClass) {
        return reflectionHashCode(paramInt1, paramInt2, paramObject, paramBoolean, paramClass, null);
    }

    public static int reflectionHashCode(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean, Class paramClass, String[] paramArrayOfString) {
        if (paramObject == null) {
            throw new IllegalArgumentException("The object to build a hash code for must not be null");
        }
        HashCodeBuilder localHashCodeBuilder = new HashCodeBuilder(paramInt1, paramInt2);
        Class localClass = paramObject.getClass();
        reflectionAppend(paramObject, localClass, localHashCodeBuilder, paramBoolean, paramArrayOfString);
        while ((localClass.getSuperclass() != null) && (localClass != paramClass)) {
            localClass = localClass.getSuperclass();
            reflectionAppend(paramObject, localClass, localHashCodeBuilder, paramBoolean, paramArrayOfString);
        }
        return localHashCodeBuilder.toHashCode();
    }

    public static int reflectionHashCode(Object paramObject) {
        return reflectionHashCode(17, 37, paramObject, false, null, null);
    }

    public static int reflectionHashCode(Object paramObject, Collection paramCollection) {
        return reflectionHashCode(paramObject, ReflectionToStringBuilder.toNoNullStringArray(paramCollection));
    }

    public static int reflectionHashCode(Object paramObject, boolean paramBoolean) {
        return reflectionHashCode(17, 37, paramObject, paramBoolean, null, null);
    }

    public static int reflectionHashCode(Object paramObject, String[] paramArrayOfString) {
        return reflectionHashCode(17, 37, paramObject, false, null, paramArrayOfString);
    }

    static void register(Object paramObject) {
        if (class$org$apache$commons$lang$builder$HashCodeBuilder == null) {
            localClass = class$("org.apache.commons.lang.builder.HashCodeBuilder");
            class$org$apache$commons$lang$builder$HashCodeBuilder = localClass;
        }
        for (; ; ) {
            try {
                if (getRegistry() == null) {
                    REGISTRY.set(new HashSet());
                }
                getRegistry().add(new IDKey(paramObject));
                return;
            } finally {
            }
            localClass = class$org$apache$commons$lang$builder$HashCodeBuilder;
        }
    }

    static void unregister(Object paramObject) {
        Set localSet = getRegistry();
        if (localSet != null) {
            localSet.remove(new IDKey(paramObject));
            if (class$org$apache$commons$lang$builder$HashCodeBuilder != null) {
                break label68;
            }
            paramObject = class$("org.apache.commons.lang.builder.HashCodeBuilder");
            class$org$apache$commons$lang$builder$HashCodeBuilder = (Class) paramObject;
        }
        for (; ; ) {
            label68:
            try {
                localSet = getRegistry();
                if ((localSet != null) && (localSet.isEmpty())) {
                    REGISTRY.set(null);
                }
                return;
            } finally {
            }
            paramObject = class$org$apache$commons$lang$builder$HashCodeBuilder;
        }
    }

    public HashCodeBuilder append(byte paramByte) {
        this.iTotal = (this.iTotal * this.iConstant + paramByte);
        return this;
    }

    public HashCodeBuilder append(char paramChar) {
        this.iTotal = (this.iTotal * this.iConstant + paramChar);
        return this;
    }

    public HashCodeBuilder append(double paramDouble) {
        return append(Double.doubleToLongBits(paramDouble));
    }

    public HashCodeBuilder append(float paramFloat) {
        this.iTotal = (this.iTotal * this.iConstant + Float.floatToIntBits(paramFloat));
        return this;
    }

    public HashCodeBuilder append(int paramInt) {
        this.iTotal = (this.iTotal * this.iConstant + paramInt);
        return this;
    }

    public HashCodeBuilder append(long paramLong) {
        this.iTotal = (this.iTotal * this.iConstant + (int) (paramLong >> 32 ^ paramLong));
        return this;
    }

    public HashCodeBuilder append(Object paramObject) {
        if (paramObject == null) {
            this.iTotal *= this.iConstant;
            return this;
        }
        if (paramObject.getClass().isArray()) {
            if ((paramObject instanceof long[])) {
                append((long[]) paramObject);
                return this;
            }
            if ((paramObject instanceof int[])) {
                append((int[]) paramObject);
                return this;
            }
            if ((paramObject instanceof short[])) {
                append((short[]) paramObject);
                return this;
            }
            if ((paramObject instanceof char[])) {
                append((char[]) paramObject);
                return this;
            }
            if ((paramObject instanceof byte[])) {
                append((byte[]) paramObject);
                return this;
            }
            if ((paramObject instanceof double[])) {
                append((double[]) paramObject);
                return this;
            }
            if ((paramObject instanceof float[])) {
                append((float[]) paramObject);
                return this;
            }
            if ((paramObject instanceof boolean[])) {
                append((boolean[]) paramObject);
                return this;
            }
            append((Object[]) paramObject);
            return this;
        }
        this.iTotal = (this.iTotal * this.iConstant + paramObject.hashCode());
        return this;
    }

    public HashCodeBuilder append(short paramShort) {
        this.iTotal = (this.iTotal * this.iConstant + paramShort);
        return this;
    }

    public HashCodeBuilder append(boolean paramBoolean) {
        int j = this.iTotal;
        int k = this.iConstant;
        if (paramBoolean) {
        }
        for (int i = 0; ; i = 1) {
            this.iTotal = (i + k * j);
            return this;
        }
    }

    public HashCodeBuilder append(byte[] paramArrayOfByte) {
        if (paramArrayOfByte == null) {
            this.iTotal *= this.iConstant;
        }
        for (; ; ) {
            return this;
            int i = 0;
            while (i < paramArrayOfByte.length) {
                append(paramArrayOfByte[i]);
                i += 1;
            }
        }
    }

    public HashCodeBuilder append(char[] paramArrayOfChar) {
        if (paramArrayOfChar == null) {
            this.iTotal *= this.iConstant;
        }
        for (; ; ) {
            return this;
            int i = 0;
            while (i < paramArrayOfChar.length) {
                append(paramArrayOfChar[i]);
                i += 1;
            }
        }
    }

    public HashCodeBuilder append(double[] paramArrayOfDouble) {
        if (paramArrayOfDouble == null) {
            this.iTotal *= this.iConstant;
        }
        for (; ; ) {
            return this;
            int i = 0;
            while (i < paramArrayOfDouble.length) {
                append(paramArrayOfDouble[i]);
                i += 1;
            }
        }
    }

    public HashCodeBuilder append(float[] paramArrayOfFloat) {
        if (paramArrayOfFloat == null) {
            this.iTotal *= this.iConstant;
        }
        for (; ; ) {
            return this;
            int i = 0;
            while (i < paramArrayOfFloat.length) {
                append(paramArrayOfFloat[i]);
                i += 1;
            }
        }
    }

    public HashCodeBuilder append(int[] paramArrayOfInt) {
        if (paramArrayOfInt == null) {
            this.iTotal *= this.iConstant;
        }
        for (; ; ) {
            return this;
            int i = 0;
            while (i < paramArrayOfInt.length) {
                append(paramArrayOfInt[i]);
                i += 1;
            }
        }
    }

    public HashCodeBuilder append(long[] paramArrayOfLong) {
        if (paramArrayOfLong == null) {
            this.iTotal *= this.iConstant;
        }
        for (; ; ) {
            return this;
            int i = 0;
            while (i < paramArrayOfLong.length) {
                append(paramArrayOfLong[i]);
                i += 1;
            }
        }
    }

    public HashCodeBuilder append(Object[] paramArrayOfObject) {
        if (paramArrayOfObject == null) {
            this.iTotal *= this.iConstant;
        }
        for (; ; ) {
            return this;
            int i = 0;
            while (i < paramArrayOfObject.length) {
                append(paramArrayOfObject[i]);
                i += 1;
            }
        }
    }

    public HashCodeBuilder append(short[] paramArrayOfShort) {
        if (paramArrayOfShort == null) {
            this.iTotal *= this.iConstant;
        }
        for (; ; ) {
            return this;
            int i = 0;
            while (i < paramArrayOfShort.length) {
                append(paramArrayOfShort[i]);
                i += 1;
            }
        }
    }

    public HashCodeBuilder append(boolean[] paramArrayOfBoolean) {
        if (paramArrayOfBoolean == null) {
            this.iTotal *= this.iConstant;
        }
        for (; ; ) {
            return this;
            int i = 0;
            while (i < paramArrayOfBoolean.length) {
                append(paramArrayOfBoolean[i]);
                i += 1;
            }
        }
    }

    public HashCodeBuilder appendSuper(int paramInt) {
        this.iTotal = (this.iTotal * this.iConstant + paramInt);
        return this;
    }

    public int hashCode() {
        return toHashCode();
    }

    public int toHashCode() {
        return this.iTotal;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/builder/HashCodeBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */