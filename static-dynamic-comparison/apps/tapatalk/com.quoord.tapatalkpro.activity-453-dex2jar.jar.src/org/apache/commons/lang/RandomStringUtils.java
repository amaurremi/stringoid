package org.apache.commons.lang;

import java.util.Random;

public class RandomStringUtils {
    private static final Random RANDOM = new Random();

    public static String random(int paramInt) {
        return random(paramInt, false, false);
    }

    public static String random(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2) {
        return random(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, null, RANDOM);
    }

    public static String random(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, char[] paramArrayOfChar) {
        return random(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, paramArrayOfChar, RANDOM);
    }

    public static String random(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, char[] paramArrayOfChar, Random paramRandom) {
        if (paramInt1 == 0) {
            return "";
        }
        if (paramInt1 < 0) {
            throw new IllegalArgumentException("Requested random string length " + paramInt1 + " is less than 0.");
        }
        int k = paramInt2;
        int m = paramInt3;
        if (paramInt2 == 0) {
            k = paramInt2;
            m = paramInt3;
            if (paramInt3 == 0) {
                paramInt2 = 123;
                paramInt3 = 32;
                k = paramInt3;
                m = paramInt2;
                if (!paramBoolean1) {
                    k = paramInt3;
                    m = paramInt2;
                    if (!paramBoolean2) {
                        k = 0;
                        m = Integer.MAX_VALUE;
                    }
                }
            }
        }
        char[] arrayOfChar = new char[paramInt1];
        paramInt3 = m - k;
        paramInt2 = paramInt1 - 1;
        if (paramInt1 != 0) {
            if (paramArrayOfChar == null) {
                int i = (char) (paramRandom.nextInt(paramInt3) + k);
                label133:
                if (((!paramBoolean1) || (!Character.isLetter(i))) && ((!paramBoolean2) || (!Character.isDigit(i))) && ((paramBoolean1) || (paramBoolean2))) {
                    break label324;
                }
                if ((i < 56320) || (i > 57343)) {
                    break label238;
                }
                if (paramInt2 != 0) {
                    break label209;
                }
                paramInt1 = paramInt2 + 1;
            }
            for (; ; ) {
                break;
                int j = paramArrayOfChar[(paramRandom.nextInt(paramInt3) + k)];
                break label133;
                label209:
                arrayOfChar[paramInt2] = j;
                paramInt1 = paramInt2 - 1;
                arrayOfChar[paramInt1] = ((char) (paramRandom.nextInt(128) + 55296));
                continue;
                label238:
                if ((j >= 55296) && (j <= 56191)) {
                    if (paramInt2 == 0) {
                        paramInt1 = paramInt2 + 1;
                    } else {
                        arrayOfChar[paramInt2] = ((char) (paramRandom.nextInt(128) + 56320));
                        paramInt1 = paramInt2 - 1;
                        arrayOfChar[paramInt1] = j;
                    }
                } else if ((j >= 56192) && (j <= 56319)) {
                    paramInt1 = paramInt2 + 1;
                } else {
                    arrayOfChar[paramInt2] = j;
                    paramInt1 = paramInt2;
                    continue;
                    label324:
                    paramInt1 = paramInt2 + 1;
                }
            }
        }
        return new String(arrayOfChar);
    }

    public static String random(int paramInt, String paramString) {
        if (paramString == null) {
            return random(paramInt, 0, 0, false, false, null, RANDOM);
        }
        return random(paramInt, paramString.toCharArray());
    }

    public static String random(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
        return random(paramInt, 0, 0, paramBoolean1, paramBoolean2);
    }

    public static String random(int paramInt, char[] paramArrayOfChar) {
        if (paramArrayOfChar == null) {
            return random(paramInt, 0, 0, false, false, null, RANDOM);
        }
        return random(paramInt, 0, paramArrayOfChar.length, false, false, paramArrayOfChar, RANDOM);
    }

    public static String randomAlphabetic(int paramInt) {
        return random(paramInt, true, false);
    }

    public static String randomAlphanumeric(int paramInt) {
        return random(paramInt, true, true);
    }

    public static String randomAscii(int paramInt) {
        return random(paramInt, 32, 127, false, false);
    }

    public static String randomNumeric(int paramInt) {
        return random(paramInt, false, true);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/RandomStringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */