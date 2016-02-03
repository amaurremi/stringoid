package org.apache.commons.lang;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class NumberUtils {
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
        return new BigDecimal(paramString);
    }

    public static BigInteger createBigInteger(String paramString) {
        return new BigInteger(paramString);
    }

    public static Double createDouble(String paramString) {
        return Double.valueOf(paramString);
    }

    public static Float createFloat(String paramString) {
        return Float.valueOf(paramString);
    }

    public static Integer createInteger(String paramString) {
        return Integer.decode(paramString);
    }

    public static Long createLong(String paramString) {
        return Long.valueOf(paramString);
    }

    public static Number createNumber(String paramString)
            throws NumberFormatException {
        Object localObject1;
        if (paramString == null) {
            localObject1 = null;
            return (Number) localObject1;
        }
        if (paramString.length() == 0) {
            throw new NumberFormatException("\"\" is not a valid number.");
        }
        if ((paramString.length() == 1) && (!Character.isDigit(paramString.charAt(0)))) {
            throw new NumberFormatException(paramString + " is not a valid number.");
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
        label201:
        Object localObject5;
        Object localObject4;
        label254:
        String str;
        if (i > -1) {
            if (j > -1) {
                if (j < i) {
                    throw new NumberFormatException(paramString + " is not a valid number.");
                }
                localObject1 = paramString.substring(i + 1, j);
                localObject5 = paramString.substring(0, i);
                localObject4 = localObject1;
                if (Character.isDigit(c)) {
                    break label602;
                }
                if ((j <= -1) || (j >= paramString.length() - 1)) {
                    break label415;
                }
                localObject1 = paramString.substring(j + 1, paramString.length() - 1);
                str = paramString.substring(0, paramString.length() - 1);
                if ((!isAllZeros((String) localObject5)) || (!isAllZeros((String) localObject1))) {
                    break label421;
                }
                i = 1;
                label286:
                switch (c) {
                }
            }
        }
        for (; ; ) {
            throw new NumberFormatException(paramString + " is not a valid number.");
            localObject1 = paramString.substring(i + 1);
            break label201;
            if (j > -1) {
            }
            for (localObject1 = paramString.substring(0, j); ; localObject1 = paramString) {
                localObject4 = null;
                localObject5 = localObject1;
                break;
            }
            label415:
            localObject1 = null;
            break label254;
            label421:
            i = 0;
            break label286;
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
            label602:
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
        if ((paramString == null) || (paramString.length() == 0)) {
            return false;
        }
        int i = 0;
        for (; ; ) {
            if (i >= paramString.length()) {
                break label41;
            }
            if (!Character.isDigit(paramString.charAt(i))) {
                break;
            }
            i += 1;
        }
        label41:
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
            do {
                return false;
                paramString = paramString.toCharArray();
                j = paramString.length;
                m = 0;
                int k = 0;
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

    public static int maximum(int paramInt1, int paramInt2, int paramInt3) {
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

    public static long maximum(long paramLong1, long paramLong2, long paramLong3) {
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

    public static int minimum(int paramInt1, int paramInt2, int paramInt3) {
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

    public static long minimum(long paramLong1, long paramLong2, long paramLong3) {
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

    public static int stringToInt(String paramString) {
        return stringToInt(paramString, 0);
    }

    public static int stringToInt(String paramString, int paramInt) {
        try {
            int i = Integer.parseInt(paramString);
            return i;
        } catch (NumberFormatException paramString) {
        }
        return paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/NumberUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */