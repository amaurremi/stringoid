package org.apache.commons.lang;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ArrayUtils {
    public static final boolean[] EMPTY_BOOLEAN_ARRAY;
    public static final Boolean[] EMPTY_BOOLEAN_OBJECT_ARRAY;
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final Byte[] EMPTY_BYTE_OBJECT_ARRAY;
    public static final Character[] EMPTY_CHARACTER_OBJECT_ARRAY = new Character[0];
    public static final char[] EMPTY_CHAR_ARRAY;
    public static final Class[] EMPTY_CLASS_ARRAY;
    public static final double[] EMPTY_DOUBLE_ARRAY;
    public static final Double[] EMPTY_DOUBLE_OBJECT_ARRAY;
    public static final float[] EMPTY_FLOAT_ARRAY;
    public static final Float[] EMPTY_FLOAT_OBJECT_ARRAY;
    public static final Integer[] EMPTY_INTEGER_OBJECT_ARRAY;
    public static final int[] EMPTY_INT_ARRAY;
    public static final long[] EMPTY_LONG_ARRAY;
    public static final Long[] EMPTY_LONG_OBJECT_ARRAY;
    public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    public static final short[] EMPTY_SHORT_ARRAY;
    public static final Short[] EMPTY_SHORT_OBJECT_ARRAY;
    public static final String[] EMPTY_STRING_ARRAY;
    public static final int INDEX_NOT_FOUND = -1;
    static Class class$java$lang$Object;

    static {
        EMPTY_CLASS_ARRAY = new Class[0];
        EMPTY_STRING_ARRAY = new String[0];
        EMPTY_LONG_ARRAY = new long[0];
        EMPTY_LONG_OBJECT_ARRAY = new Long[0];
        EMPTY_INT_ARRAY = new int[0];
        EMPTY_INTEGER_OBJECT_ARRAY = new Integer[0];
        EMPTY_SHORT_ARRAY = new short[0];
        EMPTY_SHORT_OBJECT_ARRAY = new Short[0];
        EMPTY_BYTE_ARRAY = new byte[0];
        EMPTY_BYTE_OBJECT_ARRAY = new Byte[0];
        EMPTY_DOUBLE_ARRAY = new double[0];
        EMPTY_DOUBLE_OBJECT_ARRAY = new Double[0];
        EMPTY_FLOAT_ARRAY = new float[0];
        EMPTY_FLOAT_OBJECT_ARRAY = new Float[0];
        EMPTY_BOOLEAN_ARRAY = new boolean[0];
        EMPTY_BOOLEAN_OBJECT_ARRAY = new Boolean[0];
        EMPTY_CHAR_ARRAY = new char[0];
    }

    private static Object add(Object paramObject1, int paramInt, Object paramObject2, Class paramClass) {
        if (paramObject1 == null) {
            if (paramInt != 0) {
                throw new IndexOutOfBoundsException("Index: " + paramInt + ", Length: 0");
            }
            paramObject1 = Array.newInstance(paramClass, 1);
            Array.set(paramObject1, 0, paramObject2);
            return paramObject1;
        }
        int i = Array.getLength(paramObject1);
        if ((paramInt > i) || (paramInt < 0)) {
            throw new IndexOutOfBoundsException("Index: " + paramInt + ", Length: " + i);
        }
        paramClass = Array.newInstance(paramClass, i + 1);
        System.arraycopy(paramObject1, 0, paramClass, 0, paramInt);
        Array.set(paramClass, paramInt, paramObject2);
        if (paramInt < i) {
            System.arraycopy(paramObject1, paramInt, paramClass, paramInt + 1, i - paramInt);
        }
        return paramClass;
    }

    public static byte[] add(byte[] paramArrayOfByte, byte paramByte) {
        paramArrayOfByte = (byte[]) copyArrayGrow1(paramArrayOfByte, Byte.TYPE);
        paramArrayOfByte[(paramArrayOfByte.length - 1)] = paramByte;
        return paramArrayOfByte;
    }

    public static byte[] add(byte[] paramArrayOfByte, int paramInt, byte paramByte) {
        return (byte[]) add(paramArrayOfByte, paramInt, new Byte(paramByte), Byte.TYPE);
    }

    public static char[] add(char[] paramArrayOfChar, char paramChar) {
        paramArrayOfChar = (char[]) copyArrayGrow1(paramArrayOfChar, Character.TYPE);
        paramArrayOfChar[(paramArrayOfChar.length - 1)] = paramChar;
        return paramArrayOfChar;
    }

    public static char[] add(char[] paramArrayOfChar, int paramInt, char paramChar) {
        return (char[]) add(paramArrayOfChar, paramInt, new Character(paramChar), Character.TYPE);
    }

    public static double[] add(double[] paramArrayOfDouble, double paramDouble) {
        paramArrayOfDouble = (double[]) copyArrayGrow1(paramArrayOfDouble, Double.TYPE);
        paramArrayOfDouble[(paramArrayOfDouble.length - 1)] = paramDouble;
        return paramArrayOfDouble;
    }

    public static double[] add(double[] paramArrayOfDouble, int paramInt, double paramDouble) {
        return (double[]) add(paramArrayOfDouble, paramInt, new Double(paramDouble), Double.TYPE);
    }

    public static float[] add(float[] paramArrayOfFloat, float paramFloat) {
        paramArrayOfFloat = (float[]) copyArrayGrow1(paramArrayOfFloat, Float.TYPE);
        paramArrayOfFloat[(paramArrayOfFloat.length - 1)] = paramFloat;
        return paramArrayOfFloat;
    }

    public static float[] add(float[] paramArrayOfFloat, int paramInt, float paramFloat) {
        return (float[]) add(paramArrayOfFloat, paramInt, new Float(paramFloat), Float.TYPE);
    }

    public static int[] add(int[] paramArrayOfInt, int paramInt) {
        paramArrayOfInt = (int[]) copyArrayGrow1(paramArrayOfInt, Integer.TYPE);
        paramArrayOfInt[(paramArrayOfInt.length - 1)] = paramInt;
        return paramArrayOfInt;
    }

    public static int[] add(int[] paramArrayOfInt, int paramInt1, int paramInt2) {
        return (int[]) add(paramArrayOfInt, paramInt1, new Integer(paramInt2), Integer.TYPE);
    }

    public static long[] add(long[] paramArrayOfLong, int paramInt, long paramLong) {
        return (long[]) add(paramArrayOfLong, paramInt, new Long(paramLong), Long.TYPE);
    }

    public static long[] add(long[] paramArrayOfLong, long paramLong) {
        paramArrayOfLong = (long[]) copyArrayGrow1(paramArrayOfLong, Long.TYPE);
        paramArrayOfLong[(paramArrayOfLong.length - 1)] = paramLong;
        return paramArrayOfLong;
    }

    public static Object[] add(Object[] paramArrayOfObject, int paramInt, Object paramObject) {
        if (paramArrayOfObject != null) {
        }
        for (Class localClass = paramArrayOfObject.getClass().getComponentType(); ; localClass = paramObject.getClass()) {
            return (Object[]) add(paramArrayOfObject, paramInt, paramObject, localClass);
            if (paramObject == null) {
                break;
            }
        }
        return new Object[]{null};
    }

    public static Object[] add(Object[] paramArrayOfObject, Object paramObject) {
        if (paramArrayOfObject != null) {
        }
        for (Class localClass = paramArrayOfObject.getClass(); ; localClass = paramObject.getClass()) {
            paramArrayOfObject = (Object[]) copyArrayGrow1(paramArrayOfObject, localClass);
            paramArrayOfObject[(paramArrayOfObject.length - 1)] = paramObject;
            return paramArrayOfObject;
            if (paramObject == null) {
                break;
            }
        }
        if (class$java$lang$Object == null) {
            localClass = class$("java.lang.Object");
            class$java$lang$Object = localClass;
        }
        for (; ; ) {
            break;
            localClass = class$java$lang$Object;
        }
    }

    public static short[] add(short[] paramArrayOfShort, int paramInt, short paramShort) {
        return (short[]) add(paramArrayOfShort, paramInt, new Short(paramShort), Short.TYPE);
    }

    public static short[] add(short[] paramArrayOfShort, short paramShort) {
        paramArrayOfShort = (short[]) copyArrayGrow1(paramArrayOfShort, Short.TYPE);
        paramArrayOfShort[(paramArrayOfShort.length - 1)] = paramShort;
        return paramArrayOfShort;
    }

    public static boolean[] add(boolean[] paramArrayOfBoolean, int paramInt, boolean paramBoolean) {
        return (boolean[]) add(paramArrayOfBoolean, paramInt, BooleanUtils.toBooleanObject(paramBoolean), Boolean.TYPE);
    }

    public static boolean[] add(boolean[] paramArrayOfBoolean, boolean paramBoolean) {
        paramArrayOfBoolean = (boolean[]) copyArrayGrow1(paramArrayOfBoolean, Boolean.TYPE);
        paramArrayOfBoolean[(paramArrayOfBoolean.length - 1)] = paramBoolean;
        return paramArrayOfBoolean;
    }

    public static byte[] addAll(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {
        if (paramArrayOfByte1 == null) {
            return clone(paramArrayOfByte2);
        }
        if (paramArrayOfByte2 == null) {
            return clone(paramArrayOfByte1);
        }
        byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
        System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
        return arrayOfByte;
    }

    public static char[] addAll(char[] paramArrayOfChar1, char[] paramArrayOfChar2) {
        if (paramArrayOfChar1 == null) {
            return clone(paramArrayOfChar2);
        }
        if (paramArrayOfChar2 == null) {
            return clone(paramArrayOfChar1);
        }
        char[] arrayOfChar = new char[paramArrayOfChar1.length + paramArrayOfChar2.length];
        System.arraycopy(paramArrayOfChar1, 0, arrayOfChar, 0, paramArrayOfChar1.length);
        System.arraycopy(paramArrayOfChar2, 0, arrayOfChar, paramArrayOfChar1.length, paramArrayOfChar2.length);
        return arrayOfChar;
    }

    public static double[] addAll(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2) {
        if (paramArrayOfDouble1 == null) {
            return clone(paramArrayOfDouble2);
        }
        if (paramArrayOfDouble2 == null) {
            return clone(paramArrayOfDouble1);
        }
        double[] arrayOfDouble = new double[paramArrayOfDouble1.length + paramArrayOfDouble2.length];
        System.arraycopy(paramArrayOfDouble1, 0, arrayOfDouble, 0, paramArrayOfDouble1.length);
        System.arraycopy(paramArrayOfDouble2, 0, arrayOfDouble, paramArrayOfDouble1.length, paramArrayOfDouble2.length);
        return arrayOfDouble;
    }

    public static float[] addAll(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2) {
        if (paramArrayOfFloat1 == null) {
            return clone(paramArrayOfFloat2);
        }
        if (paramArrayOfFloat2 == null) {
            return clone(paramArrayOfFloat1);
        }
        float[] arrayOfFloat = new float[paramArrayOfFloat1.length + paramArrayOfFloat2.length];
        System.arraycopy(paramArrayOfFloat1, 0, arrayOfFloat, 0, paramArrayOfFloat1.length);
        System.arraycopy(paramArrayOfFloat2, 0, arrayOfFloat, paramArrayOfFloat1.length, paramArrayOfFloat2.length);
        return arrayOfFloat;
    }

    public static int[] addAll(int[] paramArrayOfInt1, int[] paramArrayOfInt2) {
        if (paramArrayOfInt1 == null) {
            return clone(paramArrayOfInt2);
        }
        if (paramArrayOfInt2 == null) {
            return clone(paramArrayOfInt1);
        }
        int[] arrayOfInt = new int[paramArrayOfInt1.length + paramArrayOfInt2.length];
        System.arraycopy(paramArrayOfInt1, 0, arrayOfInt, 0, paramArrayOfInt1.length);
        System.arraycopy(paramArrayOfInt2, 0, arrayOfInt, paramArrayOfInt1.length, paramArrayOfInt2.length);
        return arrayOfInt;
    }

    public static long[] addAll(long[] paramArrayOfLong1, long[] paramArrayOfLong2) {
        if (paramArrayOfLong1 == null) {
            return clone(paramArrayOfLong2);
        }
        if (paramArrayOfLong2 == null) {
            return clone(paramArrayOfLong1);
        }
        long[] arrayOfLong = new long[paramArrayOfLong1.length + paramArrayOfLong2.length];
        System.arraycopy(paramArrayOfLong1, 0, arrayOfLong, 0, paramArrayOfLong1.length);
        System.arraycopy(paramArrayOfLong2, 0, arrayOfLong, paramArrayOfLong1.length, paramArrayOfLong2.length);
        return arrayOfLong;
    }

    public static Object[] addAll(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2) {
        if (paramArrayOfObject1 == null) {
            return clone(paramArrayOfObject2);
        }
        if (paramArrayOfObject2 == null) {
            return clone(paramArrayOfObject1);
        }
        Object[] arrayOfObject = (Object[]) Array.newInstance(paramArrayOfObject1.getClass().getComponentType(), paramArrayOfObject1.length + paramArrayOfObject2.length);
        System.arraycopy(paramArrayOfObject1, 0, arrayOfObject, 0, paramArrayOfObject1.length);
        try {
            System.arraycopy(paramArrayOfObject2, 0, arrayOfObject, paramArrayOfObject1.length, paramArrayOfObject2.length);
            return arrayOfObject;
        } catch (ArrayStoreException localArrayStoreException) {
            paramArrayOfObject1 = paramArrayOfObject1.getClass().getComponentType();
            paramArrayOfObject2 = paramArrayOfObject2.getClass().getComponentType();
            if (!paramArrayOfObject1.isAssignableFrom(paramArrayOfObject2)) {
                throw new IllegalArgumentException("Cannot store " + paramArrayOfObject2.getName() + " in an array of " + paramArrayOfObject1.getName());
            }
            throw localArrayStoreException;
        }
    }

    public static short[] addAll(short[] paramArrayOfShort1, short[] paramArrayOfShort2) {
        if (paramArrayOfShort1 == null) {
            return clone(paramArrayOfShort2);
        }
        if (paramArrayOfShort2 == null) {
            return clone(paramArrayOfShort1);
        }
        short[] arrayOfShort = new short[paramArrayOfShort1.length + paramArrayOfShort2.length];
        System.arraycopy(paramArrayOfShort1, 0, arrayOfShort, 0, paramArrayOfShort1.length);
        System.arraycopy(paramArrayOfShort2, 0, arrayOfShort, paramArrayOfShort1.length, paramArrayOfShort2.length);
        return arrayOfShort;
    }

    public static boolean[] addAll(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2) {
        if (paramArrayOfBoolean1 == null) {
            return clone(paramArrayOfBoolean2);
        }
        if (paramArrayOfBoolean2 == null) {
            return clone(paramArrayOfBoolean1);
        }
        boolean[] arrayOfBoolean = new boolean[paramArrayOfBoolean1.length + paramArrayOfBoolean2.length];
        System.arraycopy(paramArrayOfBoolean1, 0, arrayOfBoolean, 0, paramArrayOfBoolean1.length);
        System.arraycopy(paramArrayOfBoolean2, 0, arrayOfBoolean, paramArrayOfBoolean1.length, paramArrayOfBoolean2.length);
        return arrayOfBoolean;
    }

    static Class class$(String paramString) {
        try {
            paramString = Class.forName(paramString);
            return paramString;
        } catch (ClassNotFoundException paramString) {
            throw new NoClassDefFoundError(paramString.getMessage());
        }
    }

    public static byte[] clone(byte[] paramArrayOfByte) {
        if (paramArrayOfByte == null) {
            return null;
        }
        return (byte[]) paramArrayOfByte.clone();
    }

    public static char[] clone(char[] paramArrayOfChar) {
        if (paramArrayOfChar == null) {
            return null;
        }
        return (char[]) paramArrayOfChar.clone();
    }

    public static double[] clone(double[] paramArrayOfDouble) {
        if (paramArrayOfDouble == null) {
            return null;
        }
        return (double[]) paramArrayOfDouble.clone();
    }

    public static float[] clone(float[] paramArrayOfFloat) {
        if (paramArrayOfFloat == null) {
            return null;
        }
        return (float[]) paramArrayOfFloat.clone();
    }

    public static int[] clone(int[] paramArrayOfInt) {
        if (paramArrayOfInt == null) {
            return null;
        }
        return (int[]) paramArrayOfInt.clone();
    }

    public static long[] clone(long[] paramArrayOfLong) {
        if (paramArrayOfLong == null) {
            return null;
        }
        return (long[]) paramArrayOfLong.clone();
    }

    public static Object[] clone(Object[] paramArrayOfObject) {
        if (paramArrayOfObject == null) {
            return null;
        }
        return (Object[]) paramArrayOfObject.clone();
    }

    public static short[] clone(short[] paramArrayOfShort) {
        if (paramArrayOfShort == null) {
            return null;
        }
        return (short[]) paramArrayOfShort.clone();
    }

    public static boolean[] clone(boolean[] paramArrayOfBoolean) {
        if (paramArrayOfBoolean == null) {
            return null;
        }
        return (boolean[]) paramArrayOfBoolean.clone();
    }

    public static boolean contains(byte[] paramArrayOfByte, byte paramByte) {
        return indexOf(paramArrayOfByte, paramByte) != -1;
    }

    public static boolean contains(char[] paramArrayOfChar, char paramChar) {
        return indexOf(paramArrayOfChar, paramChar) != -1;
    }

    public static boolean contains(double[] paramArrayOfDouble, double paramDouble) {
        return indexOf(paramArrayOfDouble, paramDouble) != -1;
    }

    public static boolean contains(double[] paramArrayOfDouble, double paramDouble1, double paramDouble2) {
        boolean bool = false;
        if (indexOf(paramArrayOfDouble, paramDouble1, 0, paramDouble2) != -1) {
            bool = true;
        }
        return bool;
    }

    public static boolean contains(float[] paramArrayOfFloat, float paramFloat) {
        return indexOf(paramArrayOfFloat, paramFloat) != -1;
    }

    public static boolean contains(int[] paramArrayOfInt, int paramInt) {
        return indexOf(paramArrayOfInt, paramInt) != -1;
    }

    public static boolean contains(long[] paramArrayOfLong, long paramLong) {
        return indexOf(paramArrayOfLong, paramLong) != -1;
    }

    public static boolean contains(Object[] paramArrayOfObject, Object paramObject) {
        return indexOf(paramArrayOfObject, paramObject) != -1;
    }

    public static boolean contains(short[] paramArrayOfShort, short paramShort) {
        return indexOf(paramArrayOfShort, paramShort) != -1;
    }

    public static boolean contains(boolean[] paramArrayOfBoolean, boolean paramBoolean) {
        return indexOf(paramArrayOfBoolean, paramBoolean) != -1;
    }

    private static Object copyArrayGrow1(Object paramObject, Class paramClass) {
        if (paramObject != null) {
            int i = Array.getLength(paramObject);
            paramClass = Array.newInstance(paramObject.getClass().getComponentType(), i + 1);
            System.arraycopy(paramObject, 0, paramClass, 0, i);
            return paramClass;
        }
        return Array.newInstance(paramClass, 1);
    }

    public static int getLength(Object paramObject) {
        if (paramObject == null) {
            return 0;
        }
        return Array.getLength(paramObject);
    }

    public static int hashCode(Object paramObject) {
        return new HashCodeBuilder().append(paramObject).toHashCode();
    }

    public static int indexOf(byte[] paramArrayOfByte, byte paramByte) {
        return indexOf(paramArrayOfByte, paramByte, 0);
    }

    public static int indexOf(byte[] paramArrayOfByte, byte paramByte, int paramInt) {
        if (paramArrayOfByte == null) {
            i = -1;
            return i;
        }
        int i = paramInt;
        if (paramInt < 0) {
            i = 0;
        }
        paramInt = i;
        for (; ; ) {
            if (paramInt >= paramArrayOfByte.length) {
                break label40;
            }
            i = paramInt;
            if (paramByte == paramArrayOfByte[paramInt]) {
                break;
            }
            paramInt += 1;
        }
        label40:
        return -1;
    }

    public static int indexOf(char[] paramArrayOfChar, char paramChar) {
        return indexOf(paramArrayOfChar, paramChar, 0);
    }

    public static int indexOf(char[] paramArrayOfChar, char paramChar, int paramInt) {
        if (paramArrayOfChar == null) {
            i = -1;
            return i;
        }
        int i = paramInt;
        if (paramInt < 0) {
            i = 0;
        }
        paramInt = i;
        for (; ; ) {
            if (paramInt >= paramArrayOfChar.length) {
                break label40;
            }
            i = paramInt;
            if (paramChar == paramArrayOfChar[paramInt]) {
                break;
            }
            paramInt += 1;
        }
        label40:
        return -1;
    }

    public static int indexOf(double[] paramArrayOfDouble, double paramDouble) {
        return indexOf(paramArrayOfDouble, paramDouble, 0);
    }

    public static int indexOf(double[] paramArrayOfDouble, double paramDouble1, double paramDouble2) {
        return indexOf(paramArrayOfDouble, paramDouble1, 0, paramDouble2);
    }

    public static int indexOf(double[] paramArrayOfDouble, double paramDouble, int paramInt) {
        if (isEmpty(paramArrayOfDouble)) {
            i = -1;
            return i;
        }
        int i = paramInt;
        if (paramInt < 0) {
            i = 0;
        }
        paramInt = i;
        for (; ; ) {
            if (paramInt >= paramArrayOfDouble.length) {
                break label50;
            }
            i = paramInt;
            if (paramDouble == paramArrayOfDouble[paramInt]) {
                break;
            }
            paramInt += 1;
        }
        label50:
        return -1;
    }

    public static int indexOf(double[] paramArrayOfDouble, double paramDouble1, int paramInt, double paramDouble2) {
        if (isEmpty(paramArrayOfDouble)) {
            i = -1;
            return i;
        }
        int i = paramInt;
        if (paramInt < 0) {
            i = 0;
        }
        paramInt = i;
        for (; ; ) {
            if (paramInt >= paramArrayOfDouble.length) {
                break label64;
            }
            if (paramArrayOfDouble[paramInt] >= paramDouble1 - paramDouble2) {
                i = paramInt;
                if (paramArrayOfDouble[paramInt] <= paramDouble1 + paramDouble2) {
                    break;
                }
            }
            paramInt += 1;
        }
        label64:
        return -1;
    }

    public static int indexOf(float[] paramArrayOfFloat, float paramFloat) {
        return indexOf(paramArrayOfFloat, paramFloat, 0);
    }

    public static int indexOf(float[] paramArrayOfFloat, float paramFloat, int paramInt) {
        if (isEmpty(paramArrayOfFloat)) {
            i = -1;
            return i;
        }
        int i = paramInt;
        if (paramInt < 0) {
            i = 0;
        }
        paramInt = i;
        for (; ; ) {
            if (paramInt >= paramArrayOfFloat.length) {
                break label44;
            }
            i = paramInt;
            if (paramFloat == paramArrayOfFloat[paramInt]) {
                break;
            }
            paramInt += 1;
        }
        label44:
        return -1;
    }

    public static int indexOf(int[] paramArrayOfInt, int paramInt) {
        return indexOf(paramArrayOfInt, paramInt, 0);
    }

    public static int indexOf(int[] paramArrayOfInt, int paramInt1, int paramInt2) {
        if (paramArrayOfInt == null) {
            i = -1;
            return i;
        }
        int i = paramInt2;
        if (paramInt2 < 0) {
            i = 0;
        }
        paramInt2 = i;
        for (; ; ) {
            if (paramInt2 >= paramArrayOfInt.length) {
                break label40;
            }
            i = paramInt2;
            if (paramInt1 == paramArrayOfInt[paramInt2]) {
                break;
            }
            paramInt2 += 1;
        }
        label40:
        return -1;
    }

    public static int indexOf(long[] paramArrayOfLong, long paramLong) {
        return indexOf(paramArrayOfLong, paramLong, 0);
    }

    public static int indexOf(long[] paramArrayOfLong, long paramLong, int paramInt) {
        if (paramArrayOfLong == null) {
            i = -1;
            return i;
        }
        int i = paramInt;
        if (paramInt < 0) {
            i = 0;
        }
        paramInt = i;
        for (; ; ) {
            if (paramInt >= paramArrayOfLong.length) {
                break label47;
            }
            i = paramInt;
            if (paramLong == paramArrayOfLong[paramInt]) {
                break;
            }
            paramInt += 1;
        }
        label47:
        return -1;
    }

    public static int indexOf(Object[] paramArrayOfObject, Object paramObject) {
        return indexOf(paramArrayOfObject, paramObject, 0);
    }

    public static int indexOf(Object[] paramArrayOfObject, Object paramObject, int paramInt) {
        if (paramArrayOfObject == null) {
            paramInt = -1;
            return paramInt;
        }
        int i = paramInt;
        if (paramInt < 0) {
            i = 0;
        }
        if (paramObject == null) {
            for (; ; ) {
                if (i >= paramArrayOfObject.length) {
                    break label66;
                }
                paramInt = i;
                if (paramArrayOfObject[i] == null) {
                    break;
                }
                i += 1;
            }
        }
        for (; ; ) {
            if (i >= paramArrayOfObject.length) {
                break label66;
            }
            paramInt = i;
            if (paramObject.equals(paramArrayOfObject[i])) {
                break;
            }
            i += 1;
        }
        label66:
        return -1;
    }

    public static int indexOf(short[] paramArrayOfShort, short paramShort) {
        return indexOf(paramArrayOfShort, paramShort, 0);
    }

    public static int indexOf(short[] paramArrayOfShort, short paramShort, int paramInt) {
        if (paramArrayOfShort == null) {
            i = -1;
            return i;
        }
        int i = paramInt;
        if (paramInt < 0) {
            i = 0;
        }
        paramInt = i;
        for (; ; ) {
            if (paramInt >= paramArrayOfShort.length) {
                break label40;
            }
            i = paramInt;
            if (paramShort == paramArrayOfShort[paramInt]) {
                break;
            }
            paramInt += 1;
        }
        label40:
        return -1;
    }

    public static int indexOf(boolean[] paramArrayOfBoolean, boolean paramBoolean) {
        return indexOf(paramArrayOfBoolean, paramBoolean, 0);
    }

    public static int indexOf(boolean[] paramArrayOfBoolean, boolean paramBoolean, int paramInt) {
        if (isEmpty(paramArrayOfBoolean)) {
            i = -1;
            return i;
        }
        int i = paramInt;
        if (paramInt < 0) {
            i = 0;
        }
        paramInt = i;
        for (; ; ) {
            if (paramInt >= paramArrayOfBoolean.length) {
                break label43;
            }
            i = paramInt;
            if (paramBoolean == paramArrayOfBoolean[paramInt]) {
                break;
            }
            paramInt += 1;
        }
        label43:
        return -1;
    }

    public static boolean isEmpty(byte[] paramArrayOfByte) {
        return (paramArrayOfByte == null) || (paramArrayOfByte.length == 0);
    }

    public static boolean isEmpty(char[] paramArrayOfChar) {
        return (paramArrayOfChar == null) || (paramArrayOfChar.length == 0);
    }

    public static boolean isEmpty(double[] paramArrayOfDouble) {
        return (paramArrayOfDouble == null) || (paramArrayOfDouble.length == 0);
    }

    public static boolean isEmpty(float[] paramArrayOfFloat) {
        return (paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0);
    }

    public static boolean isEmpty(int[] paramArrayOfInt) {
        return (paramArrayOfInt == null) || (paramArrayOfInt.length == 0);
    }

    public static boolean isEmpty(long[] paramArrayOfLong) {
        return (paramArrayOfLong == null) || (paramArrayOfLong.length == 0);
    }

    public static boolean isEmpty(Object[] paramArrayOfObject) {
        return (paramArrayOfObject == null) || (paramArrayOfObject.length == 0);
    }

    public static boolean isEmpty(short[] paramArrayOfShort) {
        return (paramArrayOfShort == null) || (paramArrayOfShort.length == 0);
    }

    public static boolean isEmpty(boolean[] paramArrayOfBoolean) {
        return (paramArrayOfBoolean == null) || (paramArrayOfBoolean.length == 0);
    }

    public static boolean isEquals(Object paramObject1, Object paramObject2) {
        return new EqualsBuilder().append(paramObject1, paramObject2).isEquals();
    }

    public static boolean isNotEmpty(byte[] paramArrayOfByte) {
        return (paramArrayOfByte != null) && (paramArrayOfByte.length != 0);
    }

    public static boolean isNotEmpty(char[] paramArrayOfChar) {
        return (paramArrayOfChar != null) && (paramArrayOfChar.length != 0);
    }

    public static boolean isNotEmpty(double[] paramArrayOfDouble) {
        return (paramArrayOfDouble != null) && (paramArrayOfDouble.length != 0);
    }

    public static boolean isNotEmpty(float[] paramArrayOfFloat) {
        return (paramArrayOfFloat != null) && (paramArrayOfFloat.length != 0);
    }

    public static boolean isNotEmpty(int[] paramArrayOfInt) {
        return (paramArrayOfInt != null) && (paramArrayOfInt.length != 0);
    }

    public static boolean isNotEmpty(long[] paramArrayOfLong) {
        return (paramArrayOfLong != null) && (paramArrayOfLong.length != 0);
    }

    public static boolean isNotEmpty(Object[] paramArrayOfObject) {
        return (paramArrayOfObject != null) && (paramArrayOfObject.length != 0);
    }

    public static boolean isNotEmpty(short[] paramArrayOfShort) {
        return (paramArrayOfShort != null) && (paramArrayOfShort.length != 0);
    }

    public static boolean isNotEmpty(boolean[] paramArrayOfBoolean) {
        return (paramArrayOfBoolean != null) && (paramArrayOfBoolean.length != 0);
    }

    public static boolean isSameLength(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {
        return ((paramArrayOfByte1 != null) || (paramArrayOfByte2 == null) || (paramArrayOfByte2.length <= 0)) && ((paramArrayOfByte2 != null) || (paramArrayOfByte1 == null) || (paramArrayOfByte1.length <= 0)) && ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null) || (paramArrayOfByte1.length == paramArrayOfByte2.length));
    }

    public static boolean isSameLength(char[] paramArrayOfChar1, char[] paramArrayOfChar2) {
        return ((paramArrayOfChar1 != null) || (paramArrayOfChar2 == null) || (paramArrayOfChar2.length <= 0)) && ((paramArrayOfChar2 != null) || (paramArrayOfChar1 == null) || (paramArrayOfChar1.length <= 0)) && ((paramArrayOfChar1 == null) || (paramArrayOfChar2 == null) || (paramArrayOfChar1.length == paramArrayOfChar2.length));
    }

    public static boolean isSameLength(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2) {
        return ((paramArrayOfDouble1 != null) || (paramArrayOfDouble2 == null) || (paramArrayOfDouble2.length <= 0)) && ((paramArrayOfDouble2 != null) || (paramArrayOfDouble1 == null) || (paramArrayOfDouble1.length <= 0)) && ((paramArrayOfDouble1 == null) || (paramArrayOfDouble2 == null) || (paramArrayOfDouble1.length == paramArrayOfDouble2.length));
    }

    public static boolean isSameLength(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2) {
        return ((paramArrayOfFloat1 != null) || (paramArrayOfFloat2 == null) || (paramArrayOfFloat2.length <= 0)) && ((paramArrayOfFloat2 != null) || (paramArrayOfFloat1 == null) || (paramArrayOfFloat1.length <= 0)) && ((paramArrayOfFloat1 == null) || (paramArrayOfFloat2 == null) || (paramArrayOfFloat1.length == paramArrayOfFloat2.length));
    }

    public static boolean isSameLength(int[] paramArrayOfInt1, int[] paramArrayOfInt2) {
        return ((paramArrayOfInt1 != null) || (paramArrayOfInt2 == null) || (paramArrayOfInt2.length <= 0)) && ((paramArrayOfInt2 != null) || (paramArrayOfInt1 == null) || (paramArrayOfInt1.length <= 0)) && ((paramArrayOfInt1 == null) || (paramArrayOfInt2 == null) || (paramArrayOfInt1.length == paramArrayOfInt2.length));
    }

    public static boolean isSameLength(long[] paramArrayOfLong1, long[] paramArrayOfLong2) {
        return ((paramArrayOfLong1 != null) || (paramArrayOfLong2 == null) || (paramArrayOfLong2.length <= 0)) && ((paramArrayOfLong2 != null) || (paramArrayOfLong1 == null) || (paramArrayOfLong1.length <= 0)) && ((paramArrayOfLong1 == null) || (paramArrayOfLong2 == null) || (paramArrayOfLong1.length == paramArrayOfLong2.length));
    }

    public static boolean isSameLength(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2) {
        return ((paramArrayOfObject1 != null) || (paramArrayOfObject2 == null) || (paramArrayOfObject2.length <= 0)) && ((paramArrayOfObject2 != null) || (paramArrayOfObject1 == null) || (paramArrayOfObject1.length <= 0)) && ((paramArrayOfObject1 == null) || (paramArrayOfObject2 == null) || (paramArrayOfObject1.length == paramArrayOfObject2.length));
    }

    public static boolean isSameLength(short[] paramArrayOfShort1, short[] paramArrayOfShort2) {
        return ((paramArrayOfShort1 != null) || (paramArrayOfShort2 == null) || (paramArrayOfShort2.length <= 0)) && ((paramArrayOfShort2 != null) || (paramArrayOfShort1 == null) || (paramArrayOfShort1.length <= 0)) && ((paramArrayOfShort1 == null) || (paramArrayOfShort2 == null) || (paramArrayOfShort1.length == paramArrayOfShort2.length));
    }

    public static boolean isSameLength(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2) {
        return ((paramArrayOfBoolean1 != null) || (paramArrayOfBoolean2 == null) || (paramArrayOfBoolean2.length <= 0)) && ((paramArrayOfBoolean2 != null) || (paramArrayOfBoolean1 == null) || (paramArrayOfBoolean1.length <= 0)) && ((paramArrayOfBoolean1 == null) || (paramArrayOfBoolean2 == null) || (paramArrayOfBoolean1.length == paramArrayOfBoolean2.length));
    }

    public static boolean isSameType(Object paramObject1, Object paramObject2) {
        if ((paramObject1 == null) || (paramObject2 == null)) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        return paramObject1.getClass().getName().equals(paramObject2.getClass().getName());
    }

    public static int lastIndexOf(byte[] paramArrayOfByte, byte paramByte) {
        return lastIndexOf(paramArrayOfByte, paramByte, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(byte[] paramArrayOfByte, byte paramByte, int paramInt) {
        if (paramArrayOfByte == null) {
            i = -1;
            return i;
        }
        if (paramInt < 0) {
            return -1;
        }
        int i = paramInt;
        if (paramInt >= paramArrayOfByte.length) {
            i = paramArrayOfByte.length - 1;
        }
        paramInt = i;
        for (; ; ) {
            if (paramInt < 0) {
                break label49;
            }
            i = paramInt;
            if (paramByte == paramArrayOfByte[paramInt]) {
                break;
            }
            paramInt -= 1;
        }
        label49:
        return -1;
    }

    public static int lastIndexOf(char[] paramArrayOfChar, char paramChar) {
        return lastIndexOf(paramArrayOfChar, paramChar, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(char[] paramArrayOfChar, char paramChar, int paramInt) {
        if (paramArrayOfChar == null) {
            i = -1;
            return i;
        }
        if (paramInt < 0) {
            return -1;
        }
        int i = paramInt;
        if (paramInt >= paramArrayOfChar.length) {
            i = paramArrayOfChar.length - 1;
        }
        paramInt = i;
        for (; ; ) {
            if (paramInt < 0) {
                break label49;
            }
            i = paramInt;
            if (paramChar == paramArrayOfChar[paramInt]) {
                break;
            }
            paramInt -= 1;
        }
        label49:
        return -1;
    }

    public static int lastIndexOf(double[] paramArrayOfDouble, double paramDouble) {
        return lastIndexOf(paramArrayOfDouble, paramDouble, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(double[] paramArrayOfDouble, double paramDouble1, double paramDouble2) {
        return lastIndexOf(paramArrayOfDouble, paramDouble1, Integer.MAX_VALUE, paramDouble2);
    }

    public static int lastIndexOf(double[] paramArrayOfDouble, double paramDouble, int paramInt) {
        if (isEmpty(paramArrayOfDouble)) {
            i = -1;
            return i;
        }
        if (paramInt < 0) {
            return -1;
        }
        int i = paramInt;
        if (paramInt >= paramArrayOfDouble.length) {
            i = paramArrayOfDouble.length - 1;
        }
        paramInt = i;
        for (; ; ) {
            if (paramInt < 0) {
                break label59;
            }
            i = paramInt;
            if (paramDouble == paramArrayOfDouble[paramInt]) {
                break;
            }
            paramInt -= 1;
        }
        label59:
        return -1;
    }

    public static int lastIndexOf(double[] paramArrayOfDouble, double paramDouble1, int paramInt, double paramDouble2) {
        if (isEmpty(paramArrayOfDouble)) {
            i = -1;
            return i;
        }
        if (paramInt < 0) {
            return -1;
        }
        int i = paramInt;
        if (paramInt >= paramArrayOfDouble.length) {
            i = paramArrayOfDouble.length - 1;
        }
        paramInt = i;
        for (; ; ) {
            if (paramInt < 0) {
                break label73;
            }
            if (paramArrayOfDouble[paramInt] >= paramDouble1 - paramDouble2) {
                i = paramInt;
                if (paramArrayOfDouble[paramInt] <= paramDouble1 + paramDouble2) {
                    break;
                }
            }
            paramInt -= 1;
        }
        label73:
        return -1;
    }

    public static int lastIndexOf(float[] paramArrayOfFloat, float paramFloat) {
        return lastIndexOf(paramArrayOfFloat, paramFloat, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(float[] paramArrayOfFloat, float paramFloat, int paramInt) {
        if (isEmpty(paramArrayOfFloat)) {
            i = -1;
            return i;
        }
        if (paramInt < 0) {
            return -1;
        }
        int i = paramInt;
        if (paramInt >= paramArrayOfFloat.length) {
            i = paramArrayOfFloat.length - 1;
        }
        paramInt = i;
        for (; ; ) {
            if (paramInt < 0) {
                break label53;
            }
            i = paramInt;
            if (paramFloat == paramArrayOfFloat[paramInt]) {
                break;
            }
            paramInt -= 1;
        }
        label53:
        return -1;
    }

    public static int lastIndexOf(int[] paramArrayOfInt, int paramInt) {
        return lastIndexOf(paramArrayOfInt, paramInt, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(int[] paramArrayOfInt, int paramInt1, int paramInt2) {
        if (paramArrayOfInt == null) {
            i = -1;
            return i;
        }
        if (paramInt2 < 0) {
            return -1;
        }
        int i = paramInt2;
        if (paramInt2 >= paramArrayOfInt.length) {
            i = paramArrayOfInt.length - 1;
        }
        paramInt2 = i;
        for (; ; ) {
            if (paramInt2 < 0) {
                break label49;
            }
            i = paramInt2;
            if (paramInt1 == paramArrayOfInt[paramInt2]) {
                break;
            }
            paramInt2 -= 1;
        }
        label49:
        return -1;
    }

    public static int lastIndexOf(long[] paramArrayOfLong, long paramLong) {
        return lastIndexOf(paramArrayOfLong, paramLong, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(long[] paramArrayOfLong, long paramLong, int paramInt) {
        if (paramArrayOfLong == null) {
            i = -1;
            return i;
        }
        if (paramInt < 0) {
            return -1;
        }
        int i = paramInt;
        if (paramInt >= paramArrayOfLong.length) {
            i = paramArrayOfLong.length - 1;
        }
        paramInt = i;
        for (; ; ) {
            if (paramInt < 0) {
                break label56;
            }
            i = paramInt;
            if (paramLong == paramArrayOfLong[paramInt]) {
                break;
            }
            paramInt -= 1;
        }
        label56:
        return -1;
    }

    public static int lastIndexOf(Object[] paramArrayOfObject, Object paramObject) {
        return lastIndexOf(paramArrayOfObject, paramObject, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(Object[] paramArrayOfObject, Object paramObject, int paramInt) {
        if (paramArrayOfObject == null) {
            paramInt = -1;
            return paramInt;
        }
        if (paramInt < 0) {
            return -1;
        }
        int i = paramInt;
        if (paramInt >= paramArrayOfObject.length) {
            i = paramArrayOfObject.length - 1;
        }
        if (paramObject == null) {
            for (; ; ) {
                if (i < 0) {
                    break label73;
                }
                paramInt = i;
                if (paramArrayOfObject[i] == null) {
                    break;
                }
                i -= 1;
            }
        }
        for (; ; ) {
            if (i < 0) {
                break label73;
            }
            paramInt = i;
            if (paramObject.equals(paramArrayOfObject[i])) {
                break;
            }
            i -= 1;
        }
        label73:
        return -1;
    }

    public static int lastIndexOf(short[] paramArrayOfShort, short paramShort) {
        return lastIndexOf(paramArrayOfShort, paramShort, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(short[] paramArrayOfShort, short paramShort, int paramInt) {
        if (paramArrayOfShort == null) {
            i = -1;
            return i;
        }
        if (paramInt < 0) {
            return -1;
        }
        int i = paramInt;
        if (paramInt >= paramArrayOfShort.length) {
            i = paramArrayOfShort.length - 1;
        }
        paramInt = i;
        for (; ; ) {
            if (paramInt < 0) {
                break label49;
            }
            i = paramInt;
            if (paramShort == paramArrayOfShort[paramInt]) {
                break;
            }
            paramInt -= 1;
        }
        label49:
        return -1;
    }

    public static int lastIndexOf(boolean[] paramArrayOfBoolean, boolean paramBoolean) {
        return lastIndexOf(paramArrayOfBoolean, paramBoolean, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(boolean[] paramArrayOfBoolean, boolean paramBoolean, int paramInt) {
        if (isEmpty(paramArrayOfBoolean)) {
            i = -1;
            return i;
        }
        if (paramInt < 0) {
            return -1;
        }
        int i = paramInt;
        if (paramInt >= paramArrayOfBoolean.length) {
            i = paramArrayOfBoolean.length - 1;
        }
        paramInt = i;
        for (; ; ) {
            if (paramInt < 0) {
                break label52;
            }
            i = paramInt;
            if (paramBoolean == paramArrayOfBoolean[paramInt]) {
                break;
            }
            paramInt -= 1;
        }
        label52:
        return -1;
    }

    public static byte[] nullToEmpty(byte[] paramArrayOfByte) {
        byte[] arrayOfByte;
        if (paramArrayOfByte != null) {
            arrayOfByte = paramArrayOfByte;
            if (paramArrayOfByte.length != 0) {
            }
        } else {
            arrayOfByte = EMPTY_BYTE_ARRAY;
        }
        return arrayOfByte;
    }

    public static char[] nullToEmpty(char[] paramArrayOfChar) {
        char[] arrayOfChar;
        if (paramArrayOfChar != null) {
            arrayOfChar = paramArrayOfChar;
            if (paramArrayOfChar.length != 0) {
            }
        } else {
            arrayOfChar = EMPTY_CHAR_ARRAY;
        }
        return arrayOfChar;
    }

    public static double[] nullToEmpty(double[] paramArrayOfDouble) {
        double[] arrayOfDouble;
        if (paramArrayOfDouble != null) {
            arrayOfDouble = paramArrayOfDouble;
            if (paramArrayOfDouble.length != 0) {
            }
        } else {
            arrayOfDouble = EMPTY_DOUBLE_ARRAY;
        }
        return arrayOfDouble;
    }

    public static float[] nullToEmpty(float[] paramArrayOfFloat) {
        float[] arrayOfFloat;
        if (paramArrayOfFloat != null) {
            arrayOfFloat = paramArrayOfFloat;
            if (paramArrayOfFloat.length != 0) {
            }
        } else {
            arrayOfFloat = EMPTY_FLOAT_ARRAY;
        }
        return arrayOfFloat;
    }

    public static int[] nullToEmpty(int[] paramArrayOfInt) {
        int[] arrayOfInt;
        if (paramArrayOfInt != null) {
            arrayOfInt = paramArrayOfInt;
            if (paramArrayOfInt.length != 0) {
            }
        } else {
            arrayOfInt = EMPTY_INT_ARRAY;
        }
        return arrayOfInt;
    }

    public static long[] nullToEmpty(long[] paramArrayOfLong) {
        long[] arrayOfLong;
        if (paramArrayOfLong != null) {
            arrayOfLong = paramArrayOfLong;
            if (paramArrayOfLong.length != 0) {
            }
        } else {
            arrayOfLong = EMPTY_LONG_ARRAY;
        }
        return arrayOfLong;
    }

    public static Boolean[] nullToEmpty(Boolean[] paramArrayOfBoolean) {
        Boolean[] arrayOfBoolean;
        if (paramArrayOfBoolean != null) {
            arrayOfBoolean = paramArrayOfBoolean;
            if (paramArrayOfBoolean.length != 0) {
            }
        } else {
            arrayOfBoolean = EMPTY_BOOLEAN_OBJECT_ARRAY;
        }
        return arrayOfBoolean;
    }

    public static Byte[] nullToEmpty(Byte[] paramArrayOfByte) {
        Byte[] arrayOfByte;
        if (paramArrayOfByte != null) {
            arrayOfByte = paramArrayOfByte;
            if (paramArrayOfByte.length != 0) {
            }
        } else {
            arrayOfByte = EMPTY_BYTE_OBJECT_ARRAY;
        }
        return arrayOfByte;
    }

    public static Character[] nullToEmpty(Character[] paramArrayOfCharacter) {
        Character[] arrayOfCharacter;
        if (paramArrayOfCharacter != null) {
            arrayOfCharacter = paramArrayOfCharacter;
            if (paramArrayOfCharacter.length != 0) {
            }
        } else {
            arrayOfCharacter = EMPTY_CHARACTER_OBJECT_ARRAY;
        }
        return arrayOfCharacter;
    }

    public static Double[] nullToEmpty(Double[] paramArrayOfDouble) {
        Double[] arrayOfDouble;
        if (paramArrayOfDouble != null) {
            arrayOfDouble = paramArrayOfDouble;
            if (paramArrayOfDouble.length != 0) {
            }
        } else {
            arrayOfDouble = EMPTY_DOUBLE_OBJECT_ARRAY;
        }
        return arrayOfDouble;
    }

    public static Float[] nullToEmpty(Float[] paramArrayOfFloat) {
        Float[] arrayOfFloat;
        if (paramArrayOfFloat != null) {
            arrayOfFloat = paramArrayOfFloat;
            if (paramArrayOfFloat.length != 0) {
            }
        } else {
            arrayOfFloat = EMPTY_FLOAT_OBJECT_ARRAY;
        }
        return arrayOfFloat;
    }

    public static Integer[] nullToEmpty(Integer[] paramArrayOfInteger) {
        Integer[] arrayOfInteger;
        if (paramArrayOfInteger != null) {
            arrayOfInteger = paramArrayOfInteger;
            if (paramArrayOfInteger.length != 0) {
            }
        } else {
            arrayOfInteger = EMPTY_INTEGER_OBJECT_ARRAY;
        }
        return arrayOfInteger;
    }

    public static Long[] nullToEmpty(Long[] paramArrayOfLong) {
        Long[] arrayOfLong;
        if (paramArrayOfLong != null) {
            arrayOfLong = paramArrayOfLong;
            if (paramArrayOfLong.length != 0) {
            }
        } else {
            arrayOfLong = EMPTY_LONG_OBJECT_ARRAY;
        }
        return arrayOfLong;
    }

    public static Object[] nullToEmpty(Object[] paramArrayOfObject) {
        Object[] arrayOfObject;
        if (paramArrayOfObject != null) {
            arrayOfObject = paramArrayOfObject;
            if (paramArrayOfObject.length != 0) {
            }
        } else {
            arrayOfObject = EMPTY_OBJECT_ARRAY;
        }
        return arrayOfObject;
    }

    public static Short[] nullToEmpty(Short[] paramArrayOfShort) {
        Short[] arrayOfShort;
        if (paramArrayOfShort != null) {
            arrayOfShort = paramArrayOfShort;
            if (paramArrayOfShort.length != 0) {
            }
        } else {
            arrayOfShort = EMPTY_SHORT_OBJECT_ARRAY;
        }
        return arrayOfShort;
    }

    public static String[] nullToEmpty(String[] paramArrayOfString) {
        String[] arrayOfString;
        if (paramArrayOfString != null) {
            arrayOfString = paramArrayOfString;
            if (paramArrayOfString.length != 0) {
            }
        } else {
            arrayOfString = EMPTY_STRING_ARRAY;
        }
        return arrayOfString;
    }

    public static short[] nullToEmpty(short[] paramArrayOfShort) {
        short[] arrayOfShort;
        if (paramArrayOfShort != null) {
            arrayOfShort = paramArrayOfShort;
            if (paramArrayOfShort.length != 0) {
            }
        } else {
            arrayOfShort = EMPTY_SHORT_ARRAY;
        }
        return arrayOfShort;
    }

    public static boolean[] nullToEmpty(boolean[] paramArrayOfBoolean) {
        boolean[] arrayOfBoolean;
        if (paramArrayOfBoolean != null) {
            arrayOfBoolean = paramArrayOfBoolean;
            if (paramArrayOfBoolean.length != 0) {
            }
        } else {
            arrayOfBoolean = EMPTY_BOOLEAN_ARRAY;
        }
        return arrayOfBoolean;
    }

    private static Object remove(Object paramObject, int paramInt) {
        int i = getLength(paramObject);
        if ((paramInt < 0) || (paramInt >= i)) {
            throw new IndexOutOfBoundsException("Index: " + paramInt + ", Length: " + i);
        }
        Object localObject = Array.newInstance(paramObject.getClass().getComponentType(), i - 1);
        System.arraycopy(paramObject, 0, localObject, 0, paramInt);
        if (paramInt < i - 1) {
            System.arraycopy(paramObject, paramInt + 1, localObject, paramInt, i - paramInt - 1);
        }
        return localObject;
    }

    public static byte[] remove(byte[] paramArrayOfByte, int paramInt) {
        return (byte[]) remove(paramArrayOfByte, paramInt);
    }

    public static char[] remove(char[] paramArrayOfChar, int paramInt) {
        return (char[]) remove(paramArrayOfChar, paramInt);
    }

    public static double[] remove(double[] paramArrayOfDouble, int paramInt) {
        return (double[]) remove(paramArrayOfDouble, paramInt);
    }

    public static float[] remove(float[] paramArrayOfFloat, int paramInt) {
        return (float[]) remove(paramArrayOfFloat, paramInt);
    }

    public static int[] remove(int[] paramArrayOfInt, int paramInt) {
        return (int[]) remove(paramArrayOfInt, paramInt);
    }

    public static long[] remove(long[] paramArrayOfLong, int paramInt) {
        return (long[]) remove(paramArrayOfLong, paramInt);
    }

    public static Object[] remove(Object[] paramArrayOfObject, int paramInt) {
        return (Object[]) remove(paramArrayOfObject, paramInt);
    }

    public static short[] remove(short[] paramArrayOfShort, int paramInt) {
        return (short[]) remove(paramArrayOfShort, paramInt);
    }

    public static boolean[] remove(boolean[] paramArrayOfBoolean, int paramInt) {
        return (boolean[]) remove(paramArrayOfBoolean, paramInt);
    }

    public static byte[] removeElement(byte[] paramArrayOfByte, byte paramByte) {
        int i = indexOf(paramArrayOfByte, paramByte);
        if (i == -1) {
            return clone(paramArrayOfByte);
        }
        return remove(paramArrayOfByte, i);
    }

    public static char[] removeElement(char[] paramArrayOfChar, char paramChar) {
        int i = indexOf(paramArrayOfChar, paramChar);
        if (i == -1) {
            return clone(paramArrayOfChar);
        }
        return remove(paramArrayOfChar, i);
    }

    public static double[] removeElement(double[] paramArrayOfDouble, double paramDouble) {
        int i = indexOf(paramArrayOfDouble, paramDouble);
        if (i == -1) {
            return clone(paramArrayOfDouble);
        }
        return remove(paramArrayOfDouble, i);
    }

    public static float[] removeElement(float[] paramArrayOfFloat, float paramFloat) {
        int i = indexOf(paramArrayOfFloat, paramFloat);
        if (i == -1) {
            return clone(paramArrayOfFloat);
        }
        return remove(paramArrayOfFloat, i);
    }

    public static int[] removeElement(int[] paramArrayOfInt, int paramInt) {
        paramInt = indexOf(paramArrayOfInt, paramInt);
        if (paramInt == -1) {
            return clone(paramArrayOfInt);
        }
        return remove(paramArrayOfInt, paramInt);
    }

    public static long[] removeElement(long[] paramArrayOfLong, long paramLong) {
        int i = indexOf(paramArrayOfLong, paramLong);
        if (i == -1) {
            return clone(paramArrayOfLong);
        }
        return remove(paramArrayOfLong, i);
    }

    public static Object[] removeElement(Object[] paramArrayOfObject, Object paramObject) {
        int i = indexOf(paramArrayOfObject, paramObject);
        if (i == -1) {
            return clone(paramArrayOfObject);
        }
        return remove(paramArrayOfObject, i);
    }

    public static short[] removeElement(short[] paramArrayOfShort, short paramShort) {
        int i = indexOf(paramArrayOfShort, paramShort);
        if (i == -1) {
            return clone(paramArrayOfShort);
        }
        return remove(paramArrayOfShort, i);
    }

    public static boolean[] removeElement(boolean[] paramArrayOfBoolean, boolean paramBoolean) {
        int i = indexOf(paramArrayOfBoolean, paramBoolean);
        if (i == -1) {
            return clone(paramArrayOfBoolean);
        }
        return remove(paramArrayOfBoolean, i);
    }

    public static void reverse(byte[] paramArrayOfByte) {
        if (paramArrayOfByte == null) {
        }
        for (; ; ) {
            return;
            int j = 0;
            int k = paramArrayOfByte.length - 1;
            while (k > j) {
                int i = paramArrayOfByte[k];
                paramArrayOfByte[k] = paramArrayOfByte[j];
                paramArrayOfByte[j] = i;
                k -= 1;
                j += 1;
            }
        }
    }

    public static void reverse(char[] paramArrayOfChar) {
        if (paramArrayOfChar == null) {
        }
        for (; ; ) {
            return;
            int j = 0;
            int k = paramArrayOfChar.length - 1;
            while (k > j) {
                int i = paramArrayOfChar[k];
                paramArrayOfChar[k] = paramArrayOfChar[j];
                paramArrayOfChar[j] = i;
                k -= 1;
                j += 1;
            }
        }
    }

    public static void reverse(double[] paramArrayOfDouble) {
        if (paramArrayOfDouble == null) {
        }
        for (; ; ) {
            return;
            int i = 0;
            int j = paramArrayOfDouble.length - 1;
            while (j > i) {
                double d = paramArrayOfDouble[j];
                paramArrayOfDouble[j] = paramArrayOfDouble[i];
                paramArrayOfDouble[i] = d;
                j -= 1;
                i += 1;
            }
        }
    }

    public static void reverse(float[] paramArrayOfFloat) {
        if (paramArrayOfFloat == null) {
        }
        for (; ; ) {
            return;
            int i = 0;
            int j = paramArrayOfFloat.length - 1;
            while (j > i) {
                float f = paramArrayOfFloat[j];
                paramArrayOfFloat[j] = paramArrayOfFloat[i];
                paramArrayOfFloat[i] = f;
                j -= 1;
                i += 1;
            }
        }
    }

    public static void reverse(int[] paramArrayOfInt) {
        if (paramArrayOfInt == null) {
        }
        for (; ; ) {
            return;
            int i = 0;
            int j = paramArrayOfInt.length - 1;
            while (j > i) {
                int k = paramArrayOfInt[j];
                paramArrayOfInt[j] = paramArrayOfInt[i];
                paramArrayOfInt[i] = k;
                j -= 1;
                i += 1;
            }
        }
    }

    public static void reverse(long[] paramArrayOfLong) {
        if (paramArrayOfLong == null) {
        }
        for (; ; ) {
            return;
            int i = 0;
            int j = paramArrayOfLong.length - 1;
            while (j > i) {
                long l = paramArrayOfLong[j];
                paramArrayOfLong[j] = paramArrayOfLong[i];
                paramArrayOfLong[i] = l;
                j -= 1;
                i += 1;
            }
        }
    }

    public static void reverse(Object[] paramArrayOfObject) {
        if (paramArrayOfObject == null) {
        }
        for (; ; ) {
            return;
            int i = 0;
            int j = paramArrayOfObject.length - 1;
            while (j > i) {
                Object localObject = paramArrayOfObject[j];
                paramArrayOfObject[j] = paramArrayOfObject[i];
                paramArrayOfObject[i] = localObject;
                j -= 1;
                i += 1;
            }
        }
    }

    public static void reverse(short[] paramArrayOfShort) {
        if (paramArrayOfShort == null) {
        }
        for (; ; ) {
            return;
            int j = 0;
            int k = paramArrayOfShort.length - 1;
            while (k > j) {
                int i = paramArrayOfShort[k];
                paramArrayOfShort[k] = paramArrayOfShort[j];
                paramArrayOfShort[j] = i;
                k -= 1;
                j += 1;
            }
        }
    }

    public static void reverse(boolean[] paramArrayOfBoolean) {
        if (paramArrayOfBoolean == null) {
        }
        for (; ; ) {
            return;
            int i = 0;
            int j = paramArrayOfBoolean.length - 1;
            while (j > i) {
                int k = paramArrayOfBoolean[j];
                paramArrayOfBoolean[j] = paramArrayOfBoolean[i];
                paramArrayOfBoolean[i] = k;
                j -= 1;
                i += 1;
            }
        }
    }

    public static byte[] subarray(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        if (paramArrayOfByte == null) {
            return null;
        }
        int i = paramInt1;
        if (paramInt1 < 0) {
            i = 0;
        }
        paramInt1 = paramInt2;
        if (paramInt2 > paramArrayOfByte.length) {
            paramInt1 = paramArrayOfByte.length;
        }
        paramInt1 -= i;
        if (paramInt1 <= 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] arrayOfByte = new byte[paramInt1];
        System.arraycopy(paramArrayOfByte, i, arrayOfByte, 0, paramInt1);
        return arrayOfByte;
    }

    public static char[] subarray(char[] paramArrayOfChar, int paramInt1, int paramInt2) {
        if (paramArrayOfChar == null) {
            return null;
        }
        int i = paramInt1;
        if (paramInt1 < 0) {
            i = 0;
        }
        paramInt1 = paramInt2;
        if (paramInt2 > paramArrayOfChar.length) {
            paramInt1 = paramArrayOfChar.length;
        }
        paramInt1 -= i;
        if (paramInt1 <= 0) {
            return EMPTY_CHAR_ARRAY;
        }
        char[] arrayOfChar = new char[paramInt1];
        System.arraycopy(paramArrayOfChar, i, arrayOfChar, 0, paramInt1);
        return arrayOfChar;
    }

    public static double[] subarray(double[] paramArrayOfDouble, int paramInt1, int paramInt2) {
        if (paramArrayOfDouble == null) {
            return null;
        }
        int i = paramInt1;
        if (paramInt1 < 0) {
            i = 0;
        }
        paramInt1 = paramInt2;
        if (paramInt2 > paramArrayOfDouble.length) {
            paramInt1 = paramArrayOfDouble.length;
        }
        paramInt1 -= i;
        if (paramInt1 <= 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        double[] arrayOfDouble = new double[paramInt1];
        System.arraycopy(paramArrayOfDouble, i, arrayOfDouble, 0, paramInt1);
        return arrayOfDouble;
    }

    public static float[] subarray(float[] paramArrayOfFloat, int paramInt1, int paramInt2) {
        if (paramArrayOfFloat == null) {
            return null;
        }
        int i = paramInt1;
        if (paramInt1 < 0) {
            i = 0;
        }
        paramInt1 = paramInt2;
        if (paramInt2 > paramArrayOfFloat.length) {
            paramInt1 = paramArrayOfFloat.length;
        }
        paramInt1 -= i;
        if (paramInt1 <= 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        float[] arrayOfFloat = new float[paramInt1];
        System.arraycopy(paramArrayOfFloat, i, arrayOfFloat, 0, paramInt1);
        return arrayOfFloat;
    }

    public static int[] subarray(int[] paramArrayOfInt, int paramInt1, int paramInt2) {
        if (paramArrayOfInt == null) {
            return null;
        }
        int i = paramInt1;
        if (paramInt1 < 0) {
            i = 0;
        }
        paramInt1 = paramInt2;
        if (paramInt2 > paramArrayOfInt.length) {
            paramInt1 = paramArrayOfInt.length;
        }
        paramInt1 -= i;
        if (paramInt1 <= 0) {
            return EMPTY_INT_ARRAY;
        }
        int[] arrayOfInt = new int[paramInt1];
        System.arraycopy(paramArrayOfInt, i, arrayOfInt, 0, paramInt1);
        return arrayOfInt;
    }

    public static long[] subarray(long[] paramArrayOfLong, int paramInt1, int paramInt2) {
        if (paramArrayOfLong == null) {
            return null;
        }
        int i = paramInt1;
        if (paramInt1 < 0) {
            i = 0;
        }
        paramInt1 = paramInt2;
        if (paramInt2 > paramArrayOfLong.length) {
            paramInt1 = paramArrayOfLong.length;
        }
        paramInt1 -= i;
        if (paramInt1 <= 0) {
            return EMPTY_LONG_ARRAY;
        }
        long[] arrayOfLong = new long[paramInt1];
        System.arraycopy(paramArrayOfLong, i, arrayOfLong, 0, paramInt1);
        return arrayOfLong;
    }

    public static Object[] subarray(Object[] paramArrayOfObject, int paramInt1, int paramInt2) {
        if (paramArrayOfObject == null) {
            return null;
        }
        int i = paramInt1;
        if (paramInt1 < 0) {
            i = 0;
        }
        paramInt1 = paramInt2;
        if (paramInt2 > paramArrayOfObject.length) {
            paramInt1 = paramArrayOfObject.length;
        }
        paramInt1 -= i;
        Object localObject = paramArrayOfObject.getClass().getComponentType();
        if (paramInt1 <= 0) {
            return (Object[]) Array.newInstance((Class) localObject, 0);
        }
        localObject = (Object[]) Array.newInstance((Class) localObject, paramInt1);
        System.arraycopy(paramArrayOfObject, i, localObject, 0, paramInt1);
        return (Object[]) localObject;
    }

    public static short[] subarray(short[] paramArrayOfShort, int paramInt1, int paramInt2) {
        if (paramArrayOfShort == null) {
            return null;
        }
        int i = paramInt1;
        if (paramInt1 < 0) {
            i = 0;
        }
        paramInt1 = paramInt2;
        if (paramInt2 > paramArrayOfShort.length) {
            paramInt1 = paramArrayOfShort.length;
        }
        paramInt1 -= i;
        if (paramInt1 <= 0) {
            return EMPTY_SHORT_ARRAY;
        }
        short[] arrayOfShort = new short[paramInt1];
        System.arraycopy(paramArrayOfShort, i, arrayOfShort, 0, paramInt1);
        return arrayOfShort;
    }

    public static boolean[] subarray(boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2) {
        if (paramArrayOfBoolean == null) {
            return null;
        }
        int i = paramInt1;
        if (paramInt1 < 0) {
            i = 0;
        }
        paramInt1 = paramInt2;
        if (paramInt2 > paramArrayOfBoolean.length) {
            paramInt1 = paramArrayOfBoolean.length;
        }
        paramInt1 -= i;
        if (paramInt1 <= 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        boolean[] arrayOfBoolean = new boolean[paramInt1];
        System.arraycopy(paramArrayOfBoolean, i, arrayOfBoolean, 0, paramInt1);
        return arrayOfBoolean;
    }

    public static Map toMap(Object[] paramArrayOfObject) {
        if (paramArrayOfObject == null) {
            localObject = null;
        }
        HashMap localHashMap;
        int i;
        do {
            return (Map) localObject;
            localHashMap = new HashMap((int) (paramArrayOfObject.length * 1.5D));
            i = 0;
            localObject = localHashMap;
        } while (i >= paramArrayOfObject.length);
        Object localObject = paramArrayOfObject[i];
        if ((localObject instanceof Map.Entry)) {
            localObject = (Map.Entry) localObject;
            localHashMap.put(((Map.Entry) localObject).getKey(), ((Map.Entry) localObject).getValue());
        }
        for (; ; ) {
            i += 1;
            break;
            if (!(localObject instanceof Object[])) {
                break label161;
            }
            Object[] arrayOfObject = (Object[]) localObject;
            if (arrayOfObject.length < 2) {
                throw new IllegalArgumentException("Array element " + i + ", '" + localObject + "', has a length less than 2");
            }
            localHashMap.put(arrayOfObject[0], arrayOfObject[1]);
        }
        label161:
        throw new IllegalArgumentException("Array element " + i + ", '" + localObject + "', is neither of type Map.Entry nor an Array");
    }

    public static Boolean[] toObject(boolean[] paramArrayOfBoolean) {
        if (paramArrayOfBoolean == null) {
            localObject = null;
        }
        Boolean[] arrayOfBoolean;
        int i;
        do {
            return (Boolean[]) localObject;
            if (paramArrayOfBoolean.length == 0) {
                return EMPTY_BOOLEAN_OBJECT_ARRAY;
            }
            arrayOfBoolean = new Boolean[paramArrayOfBoolean.length];
            i = 0;
            localObject = arrayOfBoolean;
        } while (i >= paramArrayOfBoolean.length);
        if (paramArrayOfBoolean[i] != 0) {
        }
        for (Object localObject = Boolean.TRUE; ; localObject = Boolean.FALSE) {
            arrayOfBoolean[i] = localObject;
            i += 1;
            break;
        }
    }

    public static Byte[] toObject(byte[] paramArrayOfByte) {
        Object localObject;
        if (paramArrayOfByte == null) {
            localObject = null;
            return (Byte[]) localObject;
        }
        if (paramArrayOfByte.length == 0) {
            return EMPTY_BYTE_OBJECT_ARRAY;
        }
        Byte[] arrayOfByte = new Byte[paramArrayOfByte.length];
        int i = 0;
        for (; ; ) {
            localObject = arrayOfByte;
            if (i >= paramArrayOfByte.length) {
                break;
            }
            arrayOfByte[i] = new Byte(paramArrayOfByte[i]);
            i += 1;
        }
    }

    public static Character[] toObject(char[] paramArrayOfChar) {
        Object localObject;
        if (paramArrayOfChar == null) {
            localObject = null;
            return (Character[]) localObject;
        }
        if (paramArrayOfChar.length == 0) {
            return EMPTY_CHARACTER_OBJECT_ARRAY;
        }
        Character[] arrayOfCharacter = new Character[paramArrayOfChar.length];
        int i = 0;
        for (; ; ) {
            localObject = arrayOfCharacter;
            if (i >= paramArrayOfChar.length) {
                break;
            }
            arrayOfCharacter[i] = new Character(paramArrayOfChar[i]);
            i += 1;
        }
    }

    public static Double[] toObject(double[] paramArrayOfDouble) {
        Object localObject;
        if (paramArrayOfDouble == null) {
            localObject = null;
            return (Double[]) localObject;
        }
        if (paramArrayOfDouble.length == 0) {
            return EMPTY_DOUBLE_OBJECT_ARRAY;
        }
        Double[] arrayOfDouble = new Double[paramArrayOfDouble.length];
        int i = 0;
        for (; ; ) {
            localObject = arrayOfDouble;
            if (i >= paramArrayOfDouble.length) {
                break;
            }
            arrayOfDouble[i] = new Double(paramArrayOfDouble[i]);
            i += 1;
        }
    }

    public static Float[] toObject(float[] paramArrayOfFloat) {
        Object localObject;
        if (paramArrayOfFloat == null) {
            localObject = null;
            return (Float[]) localObject;
        }
        if (paramArrayOfFloat.length == 0) {
            return EMPTY_FLOAT_OBJECT_ARRAY;
        }
        Float[] arrayOfFloat = new Float[paramArrayOfFloat.length];
        int i = 0;
        for (; ; ) {
            localObject = arrayOfFloat;
            if (i >= paramArrayOfFloat.length) {
                break;
            }
            arrayOfFloat[i] = new Float(paramArrayOfFloat[i]);
            i += 1;
        }
    }

    public static Integer[] toObject(int[] paramArrayOfInt) {
        Object localObject;
        if (paramArrayOfInt == null) {
            localObject = null;
            return (Integer[]) localObject;
        }
        if (paramArrayOfInt.length == 0) {
            return EMPTY_INTEGER_OBJECT_ARRAY;
        }
        Integer[] arrayOfInteger = new Integer[paramArrayOfInt.length];
        int i = 0;
        for (; ; ) {
            localObject = arrayOfInteger;
            if (i >= paramArrayOfInt.length) {
                break;
            }
            arrayOfInteger[i] = new Integer(paramArrayOfInt[i]);
            i += 1;
        }
    }

    public static Long[] toObject(long[] paramArrayOfLong) {
        Object localObject;
        if (paramArrayOfLong == null) {
            localObject = null;
            return (Long[]) localObject;
        }
        if (paramArrayOfLong.length == 0) {
            return EMPTY_LONG_OBJECT_ARRAY;
        }
        Long[] arrayOfLong = new Long[paramArrayOfLong.length];
        int i = 0;
        for (; ; ) {
            localObject = arrayOfLong;
            if (i >= paramArrayOfLong.length) {
                break;
            }
            arrayOfLong[i] = new Long(paramArrayOfLong[i]);
            i += 1;
        }
    }

    public static Short[] toObject(short[] paramArrayOfShort) {
        Object localObject;
        if (paramArrayOfShort == null) {
            localObject = null;
            return (Short[]) localObject;
        }
        if (paramArrayOfShort.length == 0) {
            return EMPTY_SHORT_OBJECT_ARRAY;
        }
        Short[] arrayOfShort = new Short[paramArrayOfShort.length];
        int i = 0;
        for (; ; ) {
            localObject = arrayOfShort;
            if (i >= paramArrayOfShort.length) {
                break;
            }
            arrayOfShort[i] = new Short(paramArrayOfShort[i]);
            i += 1;
        }
    }

    public static byte[] toPrimitive(Byte[] paramArrayOfByte) {
        Object localObject;
        if (paramArrayOfByte == null) {
            localObject = null;
            return (byte[]) localObject;
        }
        if (paramArrayOfByte.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] arrayOfByte = new byte[paramArrayOfByte.length];
        int i = 0;
        for (; ; ) {
            localObject = arrayOfByte;
            if (i >= paramArrayOfByte.length) {
                break;
            }
            arrayOfByte[i] = paramArrayOfByte[i].byteValue();
            i += 1;
        }
    }

    public static byte[] toPrimitive(Byte[] paramArrayOfByte, byte paramByte) {
        if (paramArrayOfByte == null) {
            localObject = null;
        }
        byte[] arrayOfByte;
        int j;
        do {
            return (byte[]) localObject;
            if (paramArrayOfByte.length == 0) {
                return EMPTY_BYTE_ARRAY;
            }
            arrayOfByte = new byte[paramArrayOfByte.length];
            j = 0;
            localObject = arrayOfByte;
        } while (j >= paramArrayOfByte.length);
        Object localObject = paramArrayOfByte[j];
        if (localObject == null) {
        }
        for (int i = paramByte; ; i = ((Byte) localObject).byteValue()) {
            arrayOfByte[j] = i;
            j += 1;
            break;
        }
    }

    public static char[] toPrimitive(Character[] paramArrayOfCharacter) {
        Object localObject;
        if (paramArrayOfCharacter == null) {
            localObject = null;
            return (char[]) localObject;
        }
        if (paramArrayOfCharacter.length == 0) {
            return EMPTY_CHAR_ARRAY;
        }
        char[] arrayOfChar = new char[paramArrayOfCharacter.length];
        int i = 0;
        for (; ; ) {
            localObject = arrayOfChar;
            if (i >= paramArrayOfCharacter.length) {
                break;
            }
            arrayOfChar[i] = paramArrayOfCharacter[i].charValue();
            i += 1;
        }
    }

    public static char[] toPrimitive(Character[] paramArrayOfCharacter, char paramChar) {
        if (paramArrayOfCharacter == null) {
            localObject = null;
        }
        char[] arrayOfChar;
        int j;
        do {
            return (char[]) localObject;
            if (paramArrayOfCharacter.length == 0) {
                return EMPTY_CHAR_ARRAY;
            }
            arrayOfChar = new char[paramArrayOfCharacter.length];
            j = 0;
            localObject = arrayOfChar;
        } while (j >= paramArrayOfCharacter.length);
        Object localObject = paramArrayOfCharacter[j];
        if (localObject == null) {
        }
        for (int i = paramChar; ; i = ((Character) localObject).charValue()) {
            arrayOfChar[j] = i;
            j += 1;
            break;
        }
    }

    public static double[] toPrimitive(Double[] paramArrayOfDouble) {
        Object localObject;
        if (paramArrayOfDouble == null) {
            localObject = null;
            return (double[]) localObject;
        }
        if (paramArrayOfDouble.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        double[] arrayOfDouble = new double[paramArrayOfDouble.length];
        int i = 0;
        for (; ; ) {
            localObject = arrayOfDouble;
            if (i >= paramArrayOfDouble.length) {
                break;
            }
            arrayOfDouble[i] = paramArrayOfDouble[i].doubleValue();
            i += 1;
        }
    }

    public static double[] toPrimitive(Double[] paramArrayOfDouble, double paramDouble) {
        if (paramArrayOfDouble == null) {
            localObject = null;
        }
        double[] arrayOfDouble;
        int i;
        do {
            return (double[]) localObject;
            if (paramArrayOfDouble.length == 0) {
                return EMPTY_DOUBLE_ARRAY;
            }
            arrayOfDouble = new double[paramArrayOfDouble.length];
            i = 0;
            localObject = arrayOfDouble;
        } while (i >= paramArrayOfDouble.length);
        Object localObject = paramArrayOfDouble[i];
        if (localObject == null) {
        }
        for (double d = paramDouble; ; d = ((Double) localObject).doubleValue()) {
            arrayOfDouble[i] = d;
            i += 1;
            break;
        }
    }

    public static float[] toPrimitive(Float[] paramArrayOfFloat) {
        Object localObject;
        if (paramArrayOfFloat == null) {
            localObject = null;
            return (float[]) localObject;
        }
        if (paramArrayOfFloat.length == 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        float[] arrayOfFloat = new float[paramArrayOfFloat.length];
        int i = 0;
        for (; ; ) {
            localObject = arrayOfFloat;
            if (i >= paramArrayOfFloat.length) {
                break;
            }
            arrayOfFloat[i] = paramArrayOfFloat[i].floatValue();
            i += 1;
        }
    }

    public static float[] toPrimitive(Float[] paramArrayOfFloat, float paramFloat) {
        if (paramArrayOfFloat == null) {
            localObject = null;
        }
        float[] arrayOfFloat;
        int i;
        do {
            return (float[]) localObject;
            if (paramArrayOfFloat.length == 0) {
                return EMPTY_FLOAT_ARRAY;
            }
            arrayOfFloat = new float[paramArrayOfFloat.length];
            i = 0;
            localObject = arrayOfFloat;
        } while (i >= paramArrayOfFloat.length);
        Object localObject = paramArrayOfFloat[i];
        if (localObject == null) {
        }
        for (float f = paramFloat; ; f = ((Float) localObject).floatValue()) {
            arrayOfFloat[i] = f;
            i += 1;
            break;
        }
    }

    public static int[] toPrimitive(Integer[] paramArrayOfInteger) {
        Object localObject;
        if (paramArrayOfInteger == null) {
            localObject = null;
            return (int[]) localObject;
        }
        if (paramArrayOfInteger.length == 0) {
            return EMPTY_INT_ARRAY;
        }
        int[] arrayOfInt = new int[paramArrayOfInteger.length];
        int i = 0;
        for (; ; ) {
            localObject = arrayOfInt;
            if (i >= paramArrayOfInteger.length) {
                break;
            }
            arrayOfInt[i] = paramArrayOfInteger[i].intValue();
            i += 1;
        }
    }

    public static int[] toPrimitive(Integer[] paramArrayOfInteger, int paramInt) {
        if (paramArrayOfInteger == null) {
            localObject = null;
        }
        int[] arrayOfInt;
        int i;
        do {
            return (int[]) localObject;
            if (paramArrayOfInteger.length == 0) {
                return EMPTY_INT_ARRAY;
            }
            arrayOfInt = new int[paramArrayOfInteger.length];
            i = 0;
            localObject = arrayOfInt;
        } while (i >= paramArrayOfInteger.length);
        Object localObject = paramArrayOfInteger[i];
        if (localObject == null) {
        }
        for (int j = paramInt; ; j = ((Integer) localObject).intValue()) {
            arrayOfInt[i] = j;
            i += 1;
            break;
        }
    }

    public static long[] toPrimitive(Long[] paramArrayOfLong) {
        Object localObject;
        if (paramArrayOfLong == null) {
            localObject = null;
            return (long[]) localObject;
        }
        if (paramArrayOfLong.length == 0) {
            return EMPTY_LONG_ARRAY;
        }
        long[] arrayOfLong = new long[paramArrayOfLong.length];
        int i = 0;
        for (; ; ) {
            localObject = arrayOfLong;
            if (i >= paramArrayOfLong.length) {
                break;
            }
            arrayOfLong[i] = paramArrayOfLong[i].longValue();
            i += 1;
        }
    }

    public static long[] toPrimitive(Long[] paramArrayOfLong, long paramLong) {
        if (paramArrayOfLong == null) {
            localObject = null;
        }
        long[] arrayOfLong;
        int i;
        do {
            return (long[]) localObject;
            if (paramArrayOfLong.length == 0) {
                return EMPTY_LONG_ARRAY;
            }
            arrayOfLong = new long[paramArrayOfLong.length];
            i = 0;
            localObject = arrayOfLong;
        } while (i >= paramArrayOfLong.length);
        Object localObject = paramArrayOfLong[i];
        if (localObject == null) {
        }
        for (long l = paramLong; ; l = ((Long) localObject).longValue()) {
            arrayOfLong[i] = l;
            i += 1;
            break;
        }
    }

    public static short[] toPrimitive(Short[] paramArrayOfShort) {
        Object localObject;
        if (paramArrayOfShort == null) {
            localObject = null;
            return (short[]) localObject;
        }
        if (paramArrayOfShort.length == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        short[] arrayOfShort = new short[paramArrayOfShort.length];
        int i = 0;
        for (; ; ) {
            localObject = arrayOfShort;
            if (i >= paramArrayOfShort.length) {
                break;
            }
            arrayOfShort[i] = paramArrayOfShort[i].shortValue();
            i += 1;
        }
    }

    public static short[] toPrimitive(Short[] paramArrayOfShort, short paramShort) {
        if (paramArrayOfShort == null) {
            localObject = null;
        }
        short[] arrayOfShort;
        int j;
        do {
            return (short[]) localObject;
            if (paramArrayOfShort.length == 0) {
                return EMPTY_SHORT_ARRAY;
            }
            arrayOfShort = new short[paramArrayOfShort.length];
            j = 0;
            localObject = arrayOfShort;
        } while (j >= paramArrayOfShort.length);
        Object localObject = paramArrayOfShort[j];
        if (localObject == null) {
        }
        for (int i = paramShort; ; i = ((Short) localObject).shortValue()) {
            arrayOfShort[j] = i;
            j += 1;
            break;
        }
    }

    public static boolean[] toPrimitive(Boolean[] paramArrayOfBoolean) {
        Object localObject;
        if (paramArrayOfBoolean == null) {
            localObject = null;
            return (boolean[]) localObject;
        }
        if (paramArrayOfBoolean.length == 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        boolean[] arrayOfBoolean = new boolean[paramArrayOfBoolean.length];
        int i = 0;
        for (; ; ) {
            localObject = arrayOfBoolean;
            if (i >= paramArrayOfBoolean.length) {
                break;
            }
            arrayOfBoolean[i] = paramArrayOfBoolean[i].booleanValue();
            i += 1;
        }
    }

    public static boolean[] toPrimitive(Boolean[] paramArrayOfBoolean, boolean paramBoolean) {
        if (paramArrayOfBoolean == null) {
            localObject = null;
        }
        boolean[] arrayOfBoolean;
        int i;
        do {
            return (boolean[]) localObject;
            if (paramArrayOfBoolean.length == 0) {
                return EMPTY_BOOLEAN_ARRAY;
            }
            arrayOfBoolean = new boolean[paramArrayOfBoolean.length];
            i = 0;
            localObject = arrayOfBoolean;
        } while (i >= paramArrayOfBoolean.length);
        Object localObject = paramArrayOfBoolean[i];
        if (localObject == null) {
        }
        for (boolean bool = paramBoolean; ; bool = ((Boolean) localObject).booleanValue()) {
            arrayOfBoolean[i] = bool;
            i += 1;
            break;
        }
    }

    public static String toString(Object paramObject) {
        return toString(paramObject, "{}");
    }

    public static String toString(Object paramObject, String paramString) {
        if (paramObject == null) {
            return paramString;
        }
        return new ToStringBuilder(paramObject, ToStringStyle.SIMPLE_STYLE).append(paramObject).toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/ArrayUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */