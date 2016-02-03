package org.apache.commons.lang.math;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.apache.commons.lang.StringUtils;

public class NumberUtils {
    public static final Byte BYTE_MINUS_ONE;
    public static final Byte BYTE_ONE;
    public static final Byte BYTE_ZERO;
    public static final Double DOUBLE_MINUS_ONE;
    public static final Double DOUBLE_ONE;
    public static final Double DOUBLE_ZERO;
    public static final Float FLOAT_MINUS_ONE = new Float(-1.0F);
    public static final Float FLOAT_ONE;
    public static final Float FLOAT_ZERO;
    public static final Integer INTEGER_MINUS_ONE;
    public static final Integer INTEGER_ONE;
    public static final Integer INTEGER_ZERO;
    public static final Long LONG_MINUS_ONE;
    public static final Long LONG_ONE;
    public static final Long LONG_ZERO = new Long(0L);
    public static final Short SHORT_MINUS_ONE;
    public static final Short SHORT_ONE;
    public static final Short SHORT_ZERO;

    static {
        LONG_ONE = new Long(1L);
        LONG_MINUS_ONE = new Long(-1L);
        INTEGER_ZERO = new Integer(0);
        INTEGER_ONE = new Integer(1);
        INTEGER_MINUS_ONE = new Integer(-1);
        SHORT_ZERO = new Short((short) 0);
        SHORT_ONE = new Short((short) 1);
        SHORT_MINUS_ONE = new Short((short) -1);
        BYTE_ZERO = new Byte((byte) 0);
        BYTE_ONE = new Byte((byte) 1);
        BYTE_MINUS_ONE = new Byte((byte) -1);
        DOUBLE_ZERO = new Double(0.0D);
        DOUBLE_ONE = new Double(1.0D);
        DOUBLE_MINUS_ONE = new Double(-1.0D);
        FLOAT_ZERO = new Float(0.0F);
        FLOAT_ONE = new Float(1.0F);
    }

    public static int compare(double paramDouble1, double paramDouble2) {
        if (paramDouble1 < paramDouble2) {
        }
        long l1;
        long l2;
        do {
            return -1;
            if (paramDouble1 > paramDouble2) {
                return 1;
            }
            l1 = Double.doubleToLongBits(paramDouble1);
            l2 = Double.doubleToLongBits(paramDouble2);
            if (l1 == l2) {
                return 0;
            }
        } while (l1 < l2);
        return 1;
    }

    public static int compare(float paramFloat1, float paramFloat2) {
        if (paramFloat1 < paramFloat2) {
        }
        int i;
        int j;
        do {
            return -1;
            if (paramFloat1 > paramFloat2) {
                return 1;
            }
            i = Float.floatToIntBits(paramFloat1);
            j = Float.floatToIntBits(paramFloat2);
            if (i == j) {
                return 0;
            }
        } while (i < j);
        return 1;
    }

    public static BigDecimal createBigDecimal(String paramString) {
        if (paramString == null) {
            return null;
        }
        if (StringUtils.isBlank(paramString)) {
            throw new NumberFormatException("A blank string is not a valid number");
        }
        return new BigDecimal(paramString);
    }

    public static BigInteger createBigInteger(String paramString) {
        if (paramString == null) {
            return null;
        }
        return new BigInteger(paramString);
    }

    public static Double createDouble(String paramString) {
        if (paramString == null) {
            return null;
        }
        return Double.valueOf(paramString);
    }

    public static Float createFloat(String paramString) {
        if (paramString == null) {
            return null;
        }
        return Float.valueOf(paramString);
    }

    public static Integer createInteger(String paramString) {
        if (paramString == null) {
            return null;
        }
        return Integer.decode(paramString);
    }

    public static Long createLong(String paramString) {
        if (paramString == null) {
            return null;
        }
        return Long.valueOf(paramString);
    }

    public static Number createNumber(String paramString)
            throws NumberFormatException {
        Object localObject1;
        if (paramString == null) {
            localObject1 = null;
            return (Number) localObject1;
        }
        if (StringUtils.isBlank(paramString)) {
            throw new NumberFormatException("A blank string is not a valid number");
        }
        if (paramString.startsWith("--")) {
            return null;
        }
        if ((paramString.startsWith("0x")) || (paramString.startsWith("-0x"))) {
            return createInteger(paramString);
        }
        char c = paramString.charAt(paramString.length() - 1);
        int i = paramString.indexOf('.');
        int j = paramString.indexOf('e') + paramString.indexOf('E') + 1;
        label155:
        Object localObject5;
        Object localObject4;
        label214:
        String str;
        if (i > -1) {
            if (j > -1) {
                if (j < i) {
                    throw new NumberFormatException(paramString + " is not a valid number.");
                }
                localObject1 = paramString.substring(i + 1, j);
                localObject5 = paramString.substring(0, i);
                localObject4 = localObject1;
                if ((Character.isDigit(c)) || (c == '.')) {
                    break label562;
                }
                if ((j <= -1) || (j >= paramString.length() - 1)) {
                    break label375;
                }
                localObject1 = paramString.substring(j + 1, paramString.length() - 1);
                str = paramString.substring(0, paramString.length() - 1);
                if ((!isAllZeros((String) localObject5)) || (!isAllZeros((String) localObject1))) {
                    break label381;
                }
                i = 1;
                label246:
                switch (c) {
                }
            }
        }
        for (; ; ) {
            throw new NumberFormatException(paramString + " is not a valid number.");
            localObject1 = paramString.substring(i + 1);
            break label155;
            if (j > -1) {
            }
            for (localObject1 = paramString.substring(0, j); ; localObject1 = paramString) {
                localObject4 = null;
                localObject5 = localObject1;
                break;
            }
            label375:
            localObject1 = null;
            break label214;
            label381:
            i = 0;
            break label246;
            if ((localObject4 == null) && (localObject1 == null) && (((str.charAt(0) == '-') && (isDigits(str.substring(1)))) || (isDigits(str)))) {
                try {
                    paramString = createLong(str);
                    return paramString;
                } catch (NumberFormatException paramString) {
                    return createBigInteger(str);
                }
            }
            throw new NumberFormatException(paramString + " is not a valid number.");
            for (; ; ) {
                try {
                    localObject4 = createFloat(str);
                    if (!((Float) localObject4).isInfinite()) {
                        f = ((Float) localObject4).floatValue();
                        localObject1 = localObject4;
                        if (f != 0.0F) {
                            break;
                        }
                        localObject1 = localObject4;
                        if (i != 0) {
                            break;
                        }
                    }
                } catch (NumberFormatException localNumberFormatException7) {
                    float f;
                    Object localObject2;
                    continue;
                }
                try {
                    localObject1 = createDouble(str);
                    if (!((Double) localObject1).isInfinite()) {
                        f = ((Double) localObject1).floatValue();
                        if ((f != 0.0D) || (i != 0)) {
                            return (Number) localObject1;
                        }
                    }
                } catch (NumberFormatException localNumberFormatException1) {
                }
            }
            label562:
            try {
                localObject2 = createBigDecimal(str);
                return (Number) localObject2;
            } catch (NumberFormatException localNumberFormatException5) {
            }
            if ((j > -1) && (j < paramString.length() - 1)) {
            }
            for (localObject2 = paramString.substring(j + 1, paramString.length()); (localObject4 == null) && (localObject2 == null); localObject2 = null) {
                try {
                    localObject2 = createInteger(paramString);
                    return (Number) localObject2;
                } catch (NumberFormatException localNumberFormatException2) {
                    try {
                        Long localLong = createLong(paramString);
                        return localLong;
                    } catch (NumberFormatException localNumberFormatException3) {
                        return createBigInteger(paramString);
                    }
                }
            }
            if ((isAllZeros((String) localObject5)) && (isAllZeros(localNumberFormatException3))) {
            }
            for (i = 1; ; i = 0) {
                for (; ; ) {
                    try {
                        localObject4 = createFloat(paramString);
                        if (!((Float) localObject4).isInfinite()) {
                            f = ((Float) localObject4).floatValue();
                            localObject3 = localObject4;
                            if (f != 0.0F) {
                                break;
                            }
                            localObject3 = localObject4;
                            if (i != 0) {
                                break;
                            }
                        }
                    } catch (NumberFormatException localNumberFormatException6) {
                        Object localObject3;
                        double d;
                        continue;
                    }
                    try {
                        localObject3 = createDouble(paramString);
                        if (((Double) localObject3).isInfinite()) {
                            continue;
                        }
                        d = ((Double) localObject3).doubleValue();
                        if ((d == 0.0D) && (i == 0)) {
                            continue;
                        }
                        return (Number) localObject3;
                    } catch (NumberFormatException localNumberFormatException4) {
                    }
                }
            }
            return createBigDecimal(paramString);
        }
    }

    private static boolean isAllZeros(String paramString) {
        if (paramString == null) {
        }
        do {
            return true;
            int i = paramString.length() - 1;
            while (i >= 0) {
                if (paramString.charAt(i) != '0') {
                    return false;
                }
                i -= 1;
            }
        } while (paramString.length() > 0);
        return false;
    }

    public static boolean isDigits(String paramString) {
        if (StringUtils.isEmpty(paramString)) {
            return false;
        }
        int i = 0;
        for (; ; ) {
            if (i >= paramString.length()) {
                break label37;
            }
            if (!Character.isDigit(paramString.charAt(i))) {
                break;
            }
            i += 1;
        }
        label37:
        return true;
    }

    public static boolean isNumber(String paramString) {
        boolean bool3 = true;
        boolean bool2 = true;
        if (StringUtils.isEmpty(paramString)) {
        }
        int j;
        int m;
        int i;
        label44:
        label156:
        do {
            int k;
            do {
                do {
                    return false;
                    paramString = paramString.toCharArray();
                    j = paramString.length;
                    m = 0;
                    k = 0;
                    int n = 0;
                    bool1 = false;
                    if (paramString[0] == '-') {
                        i = 1;
                    }
                    for (; ; ) {
                        if ((j > i + 1) && (paramString[i] == '0') && (paramString[(i + 1)] == 'x')) {
                            i += 2;
                            if (i == j) {
                                break;
                            }
                            for (; ; ) {
                                if (i < paramString.length) {
                                    if (((paramString[i] < '0') || (paramString[i] > '9')) && ((paramString[i] < 'a') || (paramString[i] > 'f')) && ((paramString[i] < 'A') || (paramString[i] > 'F'))) {
                                        break;
                                    }
                                    i += 1;
                                    continue;
                                    i = 0;
                                    break label44;
                                }
                            }
                            return true;
                        }
                    }
                    int i1 = j - 1;
                    j = i;
                    i = n;
                    if ((j < i1) || ((j < i1 + 1) && (i != 0) && (!bool1))) {
                        if ((paramString[j] >= '0') && (paramString[j] <= '9')) {
                            bool1 = true;
                            i = 0;
                        }
                        for (; ; ) {
                            j += 1;
                            break label156;
                            if (paramString[j] == '.') {
                                if ((k != 0) || (m != 0)) {
                                    break;
                                }
                                k = 1;
                                continue;
                            }
                            if ((paramString[j] == 'e') || (paramString[j] == 'E')) {
                                if ((m != 0) || (!bool1)) {
                                    break;
                                }
                                m = 1;
                                i = 1;
                                continue;
                            }
                            if (((paramString[j] != '+') && (paramString[j] != '-')) || (i == 0)) {
                                break;
                            }
                            i = 0;
                            bool1 = false;
                        }
                    }
                    if (j >= paramString.length) {
                        break;
                    }
                    if ((paramString[j] >= '0') && (paramString[j] <= '9')) {
                        return true;
                    }
                } while ((paramString[j] == 'e') || (paramString[j] == 'E'));
                if (paramString[j] != '.') {
                    break;
                }
            } while ((k != 0) || (m != 0));
            return bool1;
            if ((i == 0) && ((paramString[j] == 'd') || (paramString[j] == 'D') || (paramString[j] == 'f') || (paramString[j] == 'F'))) {
                return bool1;
            }
        } while ((paramString[j] != 'l') && (paramString[j] != 'L'));
        if ((bool1) && (m == 0)) {
        }
        for (boolean bool1 = bool2; ; bool1 = false) {
            return bool1;
        }
        if ((i == 0) && (bool1)) {
        }
        for (bool1 = bool3; ; bool1 = false) {
            return bool1;
        }
    }

    public static byte max(byte paramByte1, byte paramByte2, byte paramByte3) {
        byte b = paramByte1;
        if (paramByte2 > paramByte1) {
            b = paramByte2;
        }
        paramByte1 = b;
        if (paramByte3 > b) {
            paramByte1 = paramByte3;
        }
        return paramByte1;
    }

    public static byte max(byte[] paramArrayOfByte) {
        if (paramArrayOfByte == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        if (paramArrayOfByte.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        byte b1 = paramArrayOfByte[0];
        int i = 1;
        while (i < paramArrayOfByte.length) {
            byte b2 = b1;
            if (paramArrayOfByte[i] > b1) {
                b2 = paramArrayOfByte[i];
            }
            i += 1;
            b1 = b2;
        }
        return b1;
    }

    public static double max(double paramDouble1, double paramDouble2, double paramDouble3) {
        return Math.max(Math.max(paramDouble1, paramDouble2), paramDouble3);
    }

    public static double max(double[] paramArrayOfDouble) {
        if (paramArrayOfDouble == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        if (paramArrayOfDouble.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        double d1 = paramArrayOfDouble[0];
        int i = 1;
        for (; ; ) {
            double d2 = d1;
            if (i < paramArrayOfDouble.length) {
                if (Double.isNaN(paramArrayOfDouble[i])) {
                    d2 = NaN .0D;
                }
            } else {
                return d2;
            }
            d2 = d1;
            if (paramArrayOfDouble[i] > d1) {
                d2 = paramArrayOfDouble[i];
            }
            i += 1;
            d1 = d2;
        }
    }

    public static float max(float paramFloat1, float paramFloat2, float paramFloat3) {
        return Math.max(Math.max(paramFloat1, paramFloat2), paramFloat3);
    }

    public static float max(float[] paramArrayOfFloat) {
        if (paramArrayOfFloat == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        if (paramArrayOfFloat.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        float f1 = paramArrayOfFloat[0];
        int i = 1;
        for (; ; ) {
            float f2 = f1;
            if (i < paramArrayOfFloat.length) {
                if (Float.isNaN(paramArrayOfFloat[i])) {
                    f2 = NaN .0F;
                }
            } else {
                return f2;
            }
            f2 = f1;
            if (paramArrayOfFloat[i] > f1) {
                f2 = paramArrayOfFloat[i];
            }
            i += 1;
            f1 = f2;
        }
    }

    public static int max(int paramInt1, int paramInt2, int paramInt3) {
        int i = paramInt1;
        if (paramInt2 > paramInt1) {
            i = paramInt2;
        }
        paramInt1 = i;
        if (paramInt3 > i) {
            paramInt1 = paramInt3;
        }
        return paramInt1;
    }

    public static int max(int[] paramArrayOfInt) {
        if (paramArrayOfInt == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        if (paramArrayOfInt.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        int j = paramArrayOfInt[0];
        int i = 1;
        while (i < paramArrayOfInt.length) {
            int k = j;
            if (paramArrayOfInt[i] > j) {
                k = paramArrayOfInt[i];
            }
            i += 1;
            j = k;
        }
        return j;
    }

    public static long max(long paramLong1, long paramLong2, long paramLong3) {
        long l = paramLong1;
        if (paramLong2 > paramLong1) {
            l = paramLong2;
        }
        paramLong1 = l;
        if (paramLong3 > l) {
            paramLong1 = paramLong3;
        }
        return paramLong1;
    }

    public static long max(long[] paramArrayOfLong) {
        if (paramArrayOfLong == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        if (paramArrayOfLong.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        long l1 = paramArrayOfLong[0];
        int i = 1;
        while (i < paramArrayOfLong.length) {
            long l2 = l1;
            if (paramArrayOfLong[i] > l1) {
                l2 = paramArrayOfLong[i];
            }
            i += 1;
            l1 = l2;
        }
        return l1;
    }

    public static short max(short paramShort1, short paramShort2, short paramShort3) {
        short s = paramShort1;
        if (paramShort2 > paramShort1) {
            s = paramShort2;
        }
        paramShort1 = s;
        if (paramShort3 > s) {
            paramShort1 = paramShort3;
        }
        return paramShort1;
    }

    public static short max(short[] paramArrayOfShort) {
        if (paramArrayOfShort == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        if (paramArrayOfShort.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        short s1 = paramArrayOfShort[0];
        int i = 1;
        while (i < paramArrayOfShort.length) {
            short s2 = s1;
            if (paramArrayOfShort[i] > s1) {
                s2 = paramArrayOfShort[i];
            }
            i += 1;
            s1 = s2;
        }
        return s1;
    }

    public static byte min(byte paramByte1, byte paramByte2, byte paramByte3) {
        byte b = paramByte1;
        if (paramByte2 < paramByte1) {
            b = paramByte2;
        }
        paramByte1 = b;
        if (paramByte3 < b) {
            paramByte1 = paramByte3;
        }
        return paramByte1;
    }

    public static byte min(byte[] paramArrayOfByte) {
        if (paramArrayOfByte == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        if (paramArrayOfByte.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        byte b1 = paramArrayOfByte[0];
        int i = 1;
        while (i < paramArrayOfByte.length) {
            byte b2 = b1;
            if (paramArrayOfByte[i] < b1) {
                b2 = paramArrayOfByte[i];
            }
            i += 1;
            b1 = b2;
        }
        return b1;
    }

    public static double min(double paramDouble1, double paramDouble2, double paramDouble3) {
        return Math.min(Math.min(paramDouble1, paramDouble2), paramDouble3);
    }

    public static double min(double[] paramArrayOfDouble) {
        if (paramArrayOfDouble == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        if (paramArrayOfDouble.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        double d1 = paramArrayOfDouble[0];
        int i = 1;
        for (; ; ) {
            double d2 = d1;
            if (i < paramArrayOfDouble.length) {
                if (Double.isNaN(paramArrayOfDouble[i])) {
                    d2 = NaN .0D;
                }
            } else {
                return d2;
            }
            d2 = d1;
            if (paramArrayOfDouble[i] < d1) {
                d2 = paramArrayOfDouble[i];
            }
            i += 1;
            d1 = d2;
        }
    }

    public static float min(float paramFloat1, float paramFloat2, float paramFloat3) {
        return Math.min(Math.min(paramFloat1, paramFloat2), paramFloat3);
    }

    public static float min(float[] paramArrayOfFloat) {
        if (paramArrayOfFloat == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        if (paramArrayOfFloat.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        float f1 = paramArrayOfFloat[0];
        int i = 1;
        for (; ; ) {
            float f2 = f1;
            if (i < paramArrayOfFloat.length) {
                if (Float.isNaN(paramArrayOfFloat[i])) {
                    f2 = NaN .0F;
                }
            } else {
                return f2;
            }
            f2 = f1;
            if (paramArrayOfFloat[i] < f1) {
                f2 = paramArrayOfFloat[i];
            }
            i += 1;
            f1 = f2;
        }
    }

    public static int min(int paramInt1, int paramInt2, int paramInt3) {
        int i = paramInt1;
        if (paramInt2 < paramInt1) {
            i = paramInt2;
        }
        paramInt1 = i;
        if (paramInt3 < i) {
            paramInt1 = paramInt3;
        }
        return paramInt1;
    }

    public static int min(int[] paramArrayOfInt) {
        if (paramArrayOfInt == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        if (paramArrayOfInt.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        int j = paramArrayOfInt[0];
        int i = 1;
        while (i < paramArrayOfInt.length) {
            int k = j;
            if (paramArrayOfInt[i] < j) {
                k = paramArrayOfInt[i];
            }
            i += 1;
            j = k;
        }
        return j;
    }

    public static long min(long paramLong1, long paramLong2, long paramLong3) {
        long l = paramLong1;
        if (paramLong2 < paramLong1) {
            l = paramLong2;
        }
        paramLong1 = l;
        if (paramLong3 < l) {
            paramLong1 = paramLong3;
        }
        return paramLong1;
    }

    public static long min(long[] paramArrayOfLong) {
        if (paramArrayOfLong == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        if (paramArrayOfLong.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        long l1 = paramArrayOfLong[0];
        int i = 1;
        while (i < paramArrayOfLong.length) {
            long l2 = l1;
            if (paramArrayOfLong[i] < l1) {
                l2 = paramArrayOfLong[i];
            }
            i += 1;
            l1 = l2;
        }
        return l1;
    }

    public static short min(short paramShort1, short paramShort2, short paramShort3) {
        short s = paramShort1;
        if (paramShort2 < paramShort1) {
            s = paramShort2;
        }
        paramShort1 = s;
        if (paramShort3 < s) {
            paramShort1 = paramShort3;
        }
        return paramShort1;
    }

    public static short min(short[] paramArrayOfShort) {
        if (paramArrayOfShort == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        if (paramArrayOfShort.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        short s1 = paramArrayOfShort[0];
        int i = 1;
        while (i < paramArrayOfShort.length) {
            short s2 = s1;
            if (paramArrayOfShort[i] < s1) {
                s2 = paramArrayOfShort[i];
            }
            i += 1;
            s1 = s2;
        }
        return s1;
    }

    public static int stringToInt(String paramString) {
        return toInt(paramString);
    }

    public static int stringToInt(String paramString, int paramInt) {
        return toInt(paramString, paramInt);
    }

    public static byte toByte(String paramString) {
        return toByte(paramString, (byte) 0);
    }

    public static byte toByte(String paramString, byte paramByte) {
        if (paramString == null) {
            return paramByte;
        }
        try {
            byte b = Byte.parseByte(paramString);
            return b;
        } catch (NumberFormatException paramString) {
        }
        return paramByte;
    }

    public static double toDouble(String paramString) {
        return toDouble(paramString, 0.0D);
    }

    public static double toDouble(String paramString, double paramDouble) {
        if (paramString == null) {
            return paramDouble;
        }
        try {
            double d = Double.parseDouble(paramString);
            return d;
        } catch (NumberFormatException paramString) {
        }
        return paramDouble;
    }

    public static float toFloat(String paramString) {
        return toFloat(paramString, 0.0F);
    }

    public static float toFloat(String paramString, float paramFloat) {
        if (paramString == null) {
            return paramFloat;
        }
        try {
            float f = Float.parseFloat(paramString);
            return f;
        } catch (NumberFormatException paramString) {
        }
        return paramFloat;
    }

    public static int toInt(String paramString) {
        return toInt(paramString, 0);
    }

    public static int toInt(String paramString, int paramInt) {
        if (paramString == null) {
            return paramInt;
        }
        try {
            int i = Integer.parseInt(paramString);
            return i;
        } catch (NumberFormatException paramString) {
        }
        return paramInt;
    }

    public static long toLong(String paramString) {
        return toLong(paramString, 0L);
    }

    public static long toLong(String paramString, long paramLong) {
        if (paramString == null) {
            return paramLong;
        }
        try {
            long l = Long.parseLong(paramString);
            return l;
        } catch (NumberFormatException paramString) {
        }
        return paramLong;
    }

    public static short toShort(String paramString) {
        return toShort(paramString, (short) 0);
    }

    public static short toShort(String paramString, short paramShort) {
        if (paramString == null) {
            return paramShort;
        }
        try {
            short s = Short.parseShort(paramString);
            return s;
        } catch (NumberFormatException paramString) {
        }
        return paramShort;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/math/NumberUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */