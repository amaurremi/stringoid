package org.apache.commons.lang;

public class WordUtils {
    public static String abbreviate(String paramString1, int paramInt1, int paramInt2, String paramString2) {
        if (paramString1 == null) {
            return null;
        }
        if (paramString1.length() == 0) {
            return "";
        }
        int i = paramInt1;
        if (paramInt1 > paramString1.length()) {
            i = paramString1.length();
        }
        if (paramInt2 != -1) {
            paramInt1 = paramInt2;
            if (paramInt2 <= paramString1.length()) {
            }
        } else {
            paramInt1 = paramString1.length();
        }
        paramInt2 = paramInt1;
        if (paramInt1 < i) {
            paramInt2 = i;
        }
        StringBuffer localStringBuffer = new StringBuffer();
        paramInt1 = StringUtils.indexOf(paramString1, " ", i);
        if (paramInt1 == -1) {
            localStringBuffer.append(paramString1.substring(0, paramInt2));
            if (paramInt2 != paramString1.length()) {
                localStringBuffer.append(StringUtils.defaultString(paramString2));
            }
        }
        for (; ; ) {
            return localStringBuffer.toString();
            if (paramInt1 > paramInt2) {
                localStringBuffer.append(paramString1.substring(0, paramInt2));
                localStringBuffer.append(StringUtils.defaultString(paramString2));
            } else {
                localStringBuffer.append(paramString1.substring(0, paramInt1));
                localStringBuffer.append(StringUtils.defaultString(paramString2));
            }
        }
    }

    public static String capitalize(String paramString) {
        return capitalize(paramString, null);
    }

    public static String capitalize(String paramString, char[] paramArrayOfChar) {
        if (paramArrayOfChar == null) {
        }
        for (int i = -1; (paramString == null) || (paramString.length() == 0) || (i == 0); i = paramArrayOfChar.length) {
            return paramString;
        }
        int k = paramString.length();
        StringBuffer localStringBuffer = new StringBuffer(k);
        i = 1;
        int j = 0;
        if (j < k) {
            char c = paramString.charAt(j);
            if (isDelimiter(c, paramArrayOfChar)) {
                localStringBuffer.append(c);
                i = 1;
            }
            for (; ; ) {
                j += 1;
                break;
                if (i != 0) {
                    localStringBuffer.append(Character.toTitleCase(c));
                    i = 0;
                } else {
                    localStringBuffer.append(c);
                }
            }
        }
        return localStringBuffer.toString();
    }

    public static String capitalizeFully(String paramString) {
        return capitalizeFully(paramString, null);
    }

    public static String capitalizeFully(String paramString, char[] paramArrayOfChar) {
        if (paramArrayOfChar == null) {
        }
        for (int i = -1; (paramString == null) || (paramString.length() == 0) || (i == 0); i = paramArrayOfChar.length) {
            return paramString;
        }
        return capitalize(paramString.toLowerCase(), paramArrayOfChar);
    }

    public static String initials(String paramString) {
        return initials(paramString, null);
    }

    public static String initials(String paramString, char[] paramArrayOfChar) {
        if ((paramString == null) || (paramString.length() == 0)) {
            return paramString;
        }
        if ((paramArrayOfChar != null) && (paramArrayOfChar.length == 0)) {
            return "";
        }
        int n = paramString.length();
        char[] arrayOfChar = new char[n / 2 + 1];
        int j = 1;
        int k = 0;
        int i = 0;
        char c;
        if (k < n) {
            c = paramString.charAt(k);
            if (isDelimiter(c, paramArrayOfChar)) {
                j = 1;
            }
        }
        for (; ; ) {
            k += 1;
            break;
            if (j != 0) {
                j = i + 1;
                arrayOfChar[i] = c;
                int m = 0;
                i = j;
                j = m;
                continue;
                return new String(arrayOfChar, 0, i);
            }
        }
    }

    private static boolean isDelimiter(char paramChar, char[] paramArrayOfChar) {
        if (paramArrayOfChar == null) {
            return Character.isWhitespace(paramChar);
        }
        int i = 0;
        int j = paramArrayOfChar.length;
        while (i < j) {
            if (paramChar == paramArrayOfChar[i]) {
                return true;
            }
            i += 1;
        }
        return false;
    }

    public static String swapCase(String paramString) {
        int j;
        if (paramString != null) {
            j = paramString.length();
            if (j != 0) {
            }
        } else {
            return paramString;
        }
        StringBuffer localStringBuffer = new StringBuffer(j);
        boolean bool = true;
        int i = 0;
        if (i < j) {
            char c2 = paramString.charAt(i);
            char c1;
            if (Character.isUpperCase(c2)) {
                c1 = Character.toLowerCase(c2);
            }
            for (; ; ) {
                localStringBuffer.append(c1);
                bool = Character.isWhitespace(c2);
                i += 1;
                break;
                if (Character.isTitleCase(c2)) {
                    c1 = Character.toLowerCase(c2);
                } else if (Character.isLowerCase(c2)) {
                    if (bool) {
                        c1 = Character.toTitleCase(c2);
                    } else {
                        c1 = Character.toUpperCase(c2);
                    }
                } else {
                    c1 = c2;
                }
            }
        }
        return localStringBuffer.toString();
    }

    public static String uncapitalize(String paramString) {
        return uncapitalize(paramString, null);
    }

    public static String uncapitalize(String paramString, char[] paramArrayOfChar) {
        if (paramArrayOfChar == null) {
        }
        for (int i = -1; (paramString == null) || (paramString.length() == 0) || (i == 0); i = paramArrayOfChar.length) {
            return paramString;
        }
        int k = paramString.length();
        StringBuffer localStringBuffer = new StringBuffer(k);
        i = 1;
        int j = 0;
        if (j < k) {
            char c = paramString.charAt(j);
            if (isDelimiter(c, paramArrayOfChar)) {
                localStringBuffer.append(c);
                i = 1;
            }
            for (; ; ) {
                j += 1;
                break;
                if (i != 0) {
                    localStringBuffer.append(Character.toLowerCase(c));
                    i = 0;
                } else {
                    localStringBuffer.append(c);
                }
            }
        }
        return localStringBuffer.toString();
    }

    public static String wrap(String paramString, int paramInt) {
        return wrap(paramString, paramInt, null, false);
    }

    public static String wrap(String paramString1, int paramInt, String paramString2, boolean paramBoolean) {
        if (paramString1 == null) {
            return null;
        }
        String str = paramString2;
        if (paramString2 == null) {
            str = SystemUtils.LINE_SEPARATOR;
        }
        int i = paramInt;
        if (paramInt < 1) {
            i = 1;
        }
        int j = paramString1.length();
        paramInt = 0;
        paramString2 = new StringBuffer(j + 32);
        while (j - paramInt > i) {
            if (paramString1.charAt(paramInt) == ' ') {
                paramInt += 1;
            } else {
                int k = paramString1.lastIndexOf(' ', i + paramInt);
                if (k >= paramInt) {
                    paramString2.append(paramString1.substring(paramInt, k));
                    paramString2.append(str);
                    paramInt = k + 1;
                } else if (paramBoolean) {
                    paramString2.append(paramString1.substring(paramInt, i + paramInt));
                    paramString2.append(str);
                    paramInt += i;
                } else {
                    k = paramString1.indexOf(' ', i + paramInt);
                    if (k >= 0) {
                        paramString2.append(paramString1.substring(paramInt, k));
                        paramString2.append(str);
                        paramInt = k + 1;
                    } else {
                        paramString2.append(paramString1.substring(paramInt));
                        paramInt = j;
                    }
                }
            }
        }
        paramString2.append(paramString1.substring(paramInt));
        return paramString2.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/WordUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */