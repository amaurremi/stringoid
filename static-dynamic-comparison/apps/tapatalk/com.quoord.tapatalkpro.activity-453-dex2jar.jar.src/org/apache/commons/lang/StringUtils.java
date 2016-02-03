package org.apache.commons.lang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class StringUtils {
    public static final String EMPTY = "";
    public static final int INDEX_NOT_FOUND = -1;
    private static final int PAD_LIMIT = 8192;

    public static String abbreviate(String paramString, int paramInt) {
        return abbreviate(paramString, 0, paramInt);
    }

    public static String abbreviate(String paramString, int paramInt1, int paramInt2) {
        String str;
        if (paramString == null) {
            str = null;
        }
        do {
            return str;
            if (paramInt2 < 4) {
                throw new IllegalArgumentException("Minimum abbreviation width is 4");
            }
            str = paramString;
        } while (paramString.length() <= paramInt2);
        int i = paramInt1;
        if (paramInt1 > paramString.length()) {
            i = paramString.length();
        }
        paramInt1 = i;
        if (paramString.length() - i < paramInt2 - 3) {
            paramInt1 = paramString.length() - (paramInt2 - 3);
        }
        if (paramInt1 <= 4) {
            return paramString.substring(0, paramInt2 - 3) + "...";
        }
        if (paramInt2 < 7) {
            throw new IllegalArgumentException("Minimum abbreviation width with offset is 7");
        }
        if (paramInt2 - 3 + paramInt1 < paramString.length()) {
            return "..." + abbreviate(paramString.substring(paramInt1), paramInt2 - 3);
        }
        return "..." + paramString.substring(paramString.length() - (paramInt2 - 3));
    }

    public static String abbreviateMiddle(String paramString1, String paramString2, int paramInt) {
        if ((isEmpty(paramString1)) || (isEmpty(paramString2))) {
        }
        while ((paramInt >= paramString1.length()) || (paramInt < paramString2.length() + 2)) {
            return paramString1;
        }
        int i = paramInt - paramString2.length();
        int j = i / 2;
        int k = paramString1.length();
        int m = i / 2;
        StringBuffer localStringBuffer = new StringBuffer(paramInt);
        localStringBuffer.append(paramString1.substring(0, j + i % 2));
        localStringBuffer.append(paramString2);
        localStringBuffer.append(paramString1.substring(k - m));
        return localStringBuffer.toString();
    }

    public static String capitalise(String paramString) {
        return capitalize(paramString);
    }

    public static String capitaliseAllWords(String paramString) {
        return WordUtils.capitalize(paramString);
    }

    public static String capitalize(String paramString) {
        int i;
        if (paramString != null) {
            i = paramString.length();
            if (i != 0) {
            }
        } else {
            return paramString;
        }
        return i + Character.toTitleCase(paramString.charAt(0)) + paramString.substring(1);
    }

    public static String center(String paramString, int paramInt) {
        return center(paramString, paramInt, ' ');
    }

    public static String center(String paramString, int paramInt, char paramChar) {
        if ((paramString == null) || (paramInt <= 0)) {
        }
        int i;
        int j;
        do {
            return paramString;
            i = paramString.length();
            j = paramInt - i;
        } while (j <= 0);
        return rightPad(leftPad(paramString, j / 2 + i, paramChar), paramInt, paramChar);
    }

    public static String center(String paramString1, int paramInt, String paramString2) {
        if ((paramString1 == null) || (paramInt <= 0)) {
        }
        String str;
        int i;
        int j;
        do {
            return paramString1;
            str = paramString2;
            if (isEmpty(paramString2)) {
                str = " ";
            }
            i = paramString1.length();
            j = paramInt - i;
        } while (j <= 0);
        return rightPad(leftPad(paramString1, j / 2 + i, str), paramInt, str);
    }

    public static String chomp(String paramString) {
        if (isEmpty(paramString)) {
        }
        int i;
        do {
            return paramString;
            if (paramString.length() != 1) {
                break;
            }
            i = paramString.charAt(0);
        } while ((i != 13) && (i != 10));
        return "";
        int j = paramString.length() - 1;
        int k = paramString.charAt(j);
        if (k == 10) {
            i = j;
            if (paramString.charAt(j - 1) == '\r') {
                i = j - 1;
            }
        }
        for (; ; ) {
            return paramString.substring(0, i);
            i = j;
            if (k != 13) {
                i = j + 1;
            }
        }
    }

    public static String chomp(String paramString1, String paramString2) {
        if ((isEmpty(paramString1)) || (paramString2 == null)) {
        }
        while (!paramString1.endsWith(paramString2)) {
            return paramString1;
        }
        return paramString1.substring(0, paramString1.length() - paramString2.length());
    }

    public static String chompLast(String paramString) {
        return chompLast(paramString, "\n");
    }

    public static String chompLast(String paramString1, String paramString2) {
        if (paramString1.length() == 0) {
        }
        while (!paramString2.equals(paramString1.substring(paramString1.length() - paramString2.length()))) {
            return paramString1;
        }
        return paramString1.substring(0, paramString1.length() - paramString2.length());
    }

    public static String chop(String paramString) {
        Object localObject;
        if (paramString == null) {
            localObject = null;
        }
        int i;
        String str;
        do {
            do {
                return (String) localObject;
                i = paramString.length();
                if (i < 2) {
                    return "";
                }
                i -= 1;
                str = paramString.substring(0, i);
                localObject = str;
            } while (paramString.charAt(i) != '\n');
            localObject = str;
        } while (str.charAt(i - 1) != '\r');
        return str.substring(0, i - 1);
    }

    public static String chopNewline(String paramString) {
        int j = paramString.length() - 1;
        if (j <= 0) {
            return "";
        }
        if (paramString.charAt(j) == '\n') {
            i = j;
            if (paramString.charAt(j - 1) != '\r') {
            }
        }
        for (int i = j - 1; ; i = j + 1) {
            return paramString.substring(0, i);
        }
    }

    public static String clean(String paramString) {
        if (paramString == null) {
            return "";
        }
        return paramString.trim();
    }

    public static String concatenate(Object[] paramArrayOfObject) {
        return join(paramArrayOfObject, null);
    }

    public static boolean contains(String paramString, char paramChar) {
        if (isEmpty(paramString)) {
        }
        while (paramString.indexOf(paramChar) < 0) {
            return false;
        }
        return true;
    }

    public static boolean contains(String paramString1, String paramString2) {
        if ((paramString1 == null) || (paramString2 == null)) {
        }
        while (paramString1.indexOf(paramString2) < 0) {
            return false;
        }
        return true;
    }

    public static boolean containsAny(String paramString1, String paramString2) {
        if (paramString2 == null) {
            return false;
        }
        return containsAny(paramString1, paramString2.toCharArray());
    }

    public static boolean containsAny(String paramString, char[] paramArrayOfChar) {
        if ((paramString == null) || (paramString.length() == 0) || (paramArrayOfChar == null) || (paramArrayOfChar.length == 0)) {
        }
        for (; ; ) {
            return false;
            int i = 0;
            while (i < paramString.length()) {
                int k = paramString.charAt(i);
                int j = 0;
                while (j < paramArrayOfChar.length) {
                    if (paramArrayOfChar[j] == k) {
                        return true;
                    }
                    j += 1;
                }
                i += 1;
            }
        }
    }

    public static boolean containsIgnoreCase(String paramString1, String paramString2) {
        if ((paramString1 == null) || (paramString2 == null)) {
        }
        for (; ; ) {
            return false;
            int j = paramString2.length();
            int k = paramString1.length();
            int i = 0;
            while (i <= k - j) {
                if (paramString1.regionMatches(true, i, paramString2, 0, j)) {
                    return true;
                }
                i += 1;
            }
        }
    }

    public static boolean containsNone(String paramString1, String paramString2) {
        if ((paramString1 == null) || (paramString2 == null)) {
            return true;
        }
        return containsNone(paramString1, paramString2.toCharArray());
    }

    public static boolean containsNone(String paramString, char[] paramArrayOfChar) {
        if ((paramString == null) || (paramArrayOfChar == null)) {
        }
        for (; ; ) {
            return true;
            int k = paramString.length();
            int m = paramArrayOfChar.length;
            int i = 0;
            while (i < k) {
                int n = paramString.charAt(i);
                int j = 0;
                while (j < m) {
                    if (paramArrayOfChar[j] == n) {
                        return false;
                    }
                    j += 1;
                }
                i += 1;
            }
        }
    }

    public static boolean containsOnly(String paramString1, String paramString2) {
        if ((paramString1 == null) || (paramString2 == null)) {
            return false;
        }
        return containsOnly(paramString1, paramString2.toCharArray());
    }

    public static boolean containsOnly(String paramString, char[] paramArrayOfChar) {
        boolean bool2 = true;
        boolean bool1;
        if ((paramArrayOfChar == null) || (paramString == null)) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (paramString.length() == 0);
            if (paramArrayOfChar.length == 0) {
                return false;
            }
            bool1 = bool2;
        } while (indexOfAnyBut(paramString, paramArrayOfChar) == -1);
        return false;
    }

    public static int countMatches(String paramString1, String paramString2) {
        if ((isEmpty(paramString1)) || (isEmpty(paramString2))) {
            j = 0;
            return j;
        }
        int i = 0;
        int k;
        for (int j = 0; ; j = k + paramString2.length()) {
            k = paramString1.indexOf(paramString2, j);
            j = i;
            if (k == -1) {
                break;
            }
            i += 1;
        }
    }

    public static String defaultIfEmpty(String paramString1, String paramString2) {
        if (isEmpty(paramString1)) {
            return paramString2;
        }
        return paramString1;
    }

    public static String defaultString(String paramString) {
        String str = paramString;
        if (paramString == null) {
            str = "";
        }
        return str;
    }

    public static String defaultString(String paramString1, String paramString2) {
        if (paramString1 == null) {
            return paramString2;
        }
        return paramString1;
    }

    public static String deleteSpaces(String paramString) {
        if (paramString == null) {
            return null;
        }
        return CharSetUtils.delete(paramString, " \t\r\n\b");
    }

    public static String deleteWhitespace(String paramString) {
        if (isEmpty(paramString)) {
            return paramString;
        }
        int m = paramString.length();
        char[] arrayOfChar = new char[m];
        int j = 0;
        int i = 0;
        label25:
        if (j < m) {
            if (Character.isWhitespace(paramString.charAt(j))) {
                break label82;
            }
            int k = i + 1;
            arrayOfChar[i] = paramString.charAt(j);
            i = k;
        }
        label82:
        for (; ; ) {
            j += 1;
            break label25;
            if (i == m) {
                break;
            }
            return new String(arrayOfChar, 0, i);
        }
    }

    public static String difference(String paramString1, String paramString2) {
        if (paramString1 == null) {
            return paramString2;
        }
        if (paramString2 == null) {
            return paramString1;
        }
        int i = indexOfDifference(paramString1, paramString2);
        if (i == -1) {
            return "";
        }
        return paramString2.substring(i);
    }

    public static boolean endsWith(String paramString1, String paramString2) {
        return endsWith(paramString1, paramString2, false);
    }

    private static boolean endsWith(String paramString1, String paramString2, boolean paramBoolean) {
        boolean bool2 = false;
        boolean bool1;
        if ((paramString1 == null) || (paramString2 == null)) {
            bool1 = bool2;
            if (paramString1 == null) {
                bool1 = bool2;
                if (paramString2 == null) {
                    bool1 = true;
                }
            }
        }
        do {
            return bool1;
            bool1 = bool2;
        } while (paramString2.length() > paramString1.length());
        return paramString1.regionMatches(paramBoolean, paramString1.length() - paramString2.length(), paramString2, 0, paramString2.length());
    }

    public static boolean endsWithIgnoreCase(String paramString1, String paramString2) {
        return endsWith(paramString1, paramString2, true);
    }

    public static boolean equals(String paramString1, String paramString2) {
        if (paramString1 == null) {
            return paramString2 == null;
        }
        return paramString1.equals(paramString2);
    }

    public static boolean equalsIgnoreCase(String paramString1, String paramString2) {
        if (paramString1 == null) {
            return paramString2 == null;
        }
        return paramString1.equalsIgnoreCase(paramString2);
    }

    public static String escape(String paramString) {
        return StringEscapeUtils.escapeJava(paramString);
    }

    public static String getChomp(String paramString1, String paramString2) {
        int i = paramString1.lastIndexOf(paramString2);
        if (i == paramString1.length() - paramString2.length()) {
            return paramString2;
        }
        if (i != -1) {
            return paramString1.substring(i);
        }
        return "";
    }

    public static String getCommonPrefix(String[] paramArrayOfString) {
        if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
            return "";
        }
        int i = indexOfDifference(paramArrayOfString);
        if (i == -1) {
            if (paramArrayOfString[0] == null) {
                return "";
            }
            return paramArrayOfString[0];
        }
        if (i == 0) {
            return "";
        }
        return paramArrayOfString[0].substring(0, i);
    }

    public static int getLevenshteinDistance(String paramString1, String paramString2) {
        if ((paramString1 == null) || (paramString2 == null)) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        int m = paramString1.length();
        int k = paramString2.length();
        if (m == 0) {
            return k;
        }
        if (k == 0) {
            return m;
        }
        int j = k;
        int i = m;
        String str2 = paramString1;
        String str1 = paramString2;
        if (m > k) {
            i = k;
            j = paramString1.length();
            str1 = paramString1;
            str2 = paramString2;
        }
        paramString2 = new int[i + 1];
        paramString1 = new int[i + 1];
        k = 0;
        while (k <= i) {
            paramString2[k] = k;
            k += 1;
        }
        k = 1;
        String str3;
        for (; ; ) {
            str3 = paramString2;
            if (k > j) {
                break;
            }
            int i1 = str1.charAt(k - 1);
            paramString1[0] = k;
            m = 1;
            if (m <= i) {
                if (str2.charAt(m - 1) == i1) {
                }
                for (int n = 0; ; n = 1) {
                    paramString1[m] = Math.min(Math.min(paramString1[(m - 1)] + 1, str3[m] + 1), str3[(m - 1)] + n);
                    m += 1;
                    break;
                }
            }
            paramString2 = paramString1;
            paramString1 = str3;
            k += 1;
        }
        return str3[i];
    }

    public static String getNestedString(String paramString1, String paramString2) {
        return substringBetween(paramString1, paramString2, paramString2);
    }

    public static String getNestedString(String paramString1, String paramString2, String paramString3) {
        return substringBetween(paramString1, paramString2, paramString3);
    }

    public static String getPrechomp(String paramString1, String paramString2) {
        int i = paramString1.indexOf(paramString2);
        if (i == -1) {
            return "";
        }
        return paramString1.substring(0, paramString2.length() + i);
    }

    public static int indexOf(String paramString, char paramChar) {
        if (isEmpty(paramString)) {
            return -1;
        }
        return paramString.indexOf(paramChar);
    }

    public static int indexOf(String paramString, char paramChar, int paramInt) {
        if (isEmpty(paramString)) {
            return -1;
        }
        return paramString.indexOf(paramChar, paramInt);
    }

    public static int indexOf(String paramString1, String paramString2) {
        if ((paramString1 == null) || (paramString2 == null)) {
            return -1;
        }
        return paramString1.indexOf(paramString2);
    }

    public static int indexOf(String paramString1, String paramString2, int paramInt) {
        if ((paramString1 == null) || (paramString2 == null)) {
            return -1;
        }
        if ((paramString2.length() == 0) && (paramInt >= paramString1.length())) {
            return paramString1.length();
        }
        return paramString1.indexOf(paramString2, paramInt);
    }

    public static int indexOfAny(String paramString1, String paramString2) {
        if ((isEmpty(paramString1)) || (isEmpty(paramString2))) {
            return -1;
        }
        return indexOfAny(paramString1, paramString2.toCharArray());
    }

    public static int indexOfAny(String paramString, char[] paramArrayOfChar) {
        int j;
        if ((isEmpty(paramString)) || (ArrayUtils.isEmpty(paramArrayOfChar))) {
            j = -1;
            return j;
        }
        int i = 0;
        for (; ; ) {
            if (i >= paramString.length()) {
                break label72;
            }
            int m = paramString.charAt(i);
            int k = 0;
            for (; ; ) {
                if (k >= paramArrayOfChar.length) {
                    break label65;
                }
                j = i;
                if (paramArrayOfChar[k] == m) {
                    break;
                }
                k += 1;
            }
            label65:
            i += 1;
        }
        label72:
        return -1;
    }

    public static int indexOfAny(String paramString, String[] paramArrayOfString) {
        int j;
        if ((paramString == null) || (paramArrayOfString == null)) {
            j = -1;
        }
        int i;
        do {
            return j;
            int n = paramArrayOfString.length;
            i = Integer.MAX_VALUE;
            j = 0;
            if (j < n) {
                String str = paramArrayOfString[j];
                int k;
                if (str == null) {
                    k = i;
                }
                for (; ; ) {
                    j += 1;
                    i = k;
                    break;
                    int m = paramString.indexOf(str);
                    k = i;
                    if (m != -1) {
                        k = i;
                        if (m < i) {
                            k = m;
                        }
                    }
                }
            }
            j = i;
        } while (i != Integer.MAX_VALUE);
        return -1;
    }

    public static int indexOfAnyBut(String paramString1, String paramString2) {
        int j;
        if ((isEmpty(paramString1)) || (isEmpty(paramString2))) {
            j = -1;
            return j;
        }
        int i = 0;
        for (; ; ) {
            if (i >= paramString1.length()) {
                break label49;
            }
            j = i;
            if (paramString2.indexOf(paramString1.charAt(i)) < 0) {
                break;
            }
            i += 1;
        }
        label49:
        return -1;
    }

    public static int indexOfAnyBut(String paramString, char[] paramArrayOfChar) {
        int j;
        if ((isEmpty(paramString)) || (ArrayUtils.isEmpty(paramArrayOfChar))) {
            j = -1;
            return j;
        }
        int i = 0;
        label20:
        if (i < paramString.length()) {
            int m = paramString.charAt(i);
            int k = 0;
            for (; ; ) {
                j = i;
                if (k >= paramArrayOfChar.length) {
                    break;
                }
                if (paramArrayOfChar[k] == m) {
                    i += 1;
                    break label20;
                }
                k += 1;
            }
        }
        return -1;
    }

    public static int indexOfDifference(String paramString1, String paramString2) {
        int j;
        if (paramString1 == paramString2) {
            j = -1;
            return j;
        }
        if ((paramString1 == null) || (paramString2 == null)) {
            return 0;
        }
        int i = 0;
        for (; ; ) {
            if ((i >= paramString1.length()) || (i >= paramString2.length()) || (paramString1.charAt(i) != paramString2.charAt(i))) {
                j = i;
                if (i < paramString2.length()) {
                    break;
                }
                j = i;
                if (i < paramString1.length()) {
                    break;
                }
                return -1;
            }
            i += 1;
        }
    }

    public static int indexOfDifference(String[] paramArrayOfString) {
        if ((paramArrayOfString == null) || (paramArrayOfString.length <= 1)) {
            j = -1;
            return j;
        }
        int k = 0;
        int m = 1;
        int i2 = paramArrayOfString.length;
        int i = Integer.MAX_VALUE;
        int n = 0;
        int j = 0;
        if (j < i2) {
            if (paramArrayOfString[j] == null) {
                k = 1;
                i = 0;
            }
            for (; ; ) {
                j += 1;
                break;
                m = 0;
                i = Math.min(paramArrayOfString[j].length(), i);
                n = Math.max(paramArrayOfString[j].length(), n);
            }
        }
        if ((m != 0) || ((n == 0) && (k == 0))) {
            return -1;
        }
        if (i == 0) {
            return 0;
        }
        k = -1;
        j = 0;
        for (; ; ) {
            m = k;
            int i3;
            int i1;
            if (j < i) {
                i3 = paramArrayOfString[0].charAt(j);
                i1 = 1;
            }
            for (; ; ) {
                m = k;
                if (i1 < i2) {
                    if (paramArrayOfString[i1].charAt(j) != i3) {
                        m = j;
                    }
                } else {
                    if (m == -1) {
                        break label188;
                    }
                    if (m == -1) {
                        j = i;
                        if (i != n) {
                            break;
                        }
                    }
                    return m;
                }
                i1 += 1;
            }
            label188:
            j += 1;
            k = m;
        }
    }

    public static int indexOfIgnoreCase(String paramString1, String paramString2) {
        return indexOfIgnoreCase(paramString1, paramString2, 0);
    }

    public static int indexOfIgnoreCase(String paramString1, String paramString2, int paramInt) {
        if ((paramString1 == null) || (paramString2 == null)) {
            i = -1;
            return i;
        }
        int i = paramInt;
        if (paramInt < 0) {
            i = 0;
        }
        int j = paramString1.length() - paramString2.length() + 1;
        if (i > j) {
            return -1;
        }
        if (paramString2.length() == 0) {
            return i;
        }
        paramInt = i;
        for (; ; ) {
            if (paramInt >= j) {
                break label82;
            }
            i = paramInt;
            if (paramString1.regionMatches(true, paramInt, paramString2, 0, paramString2.length())) {
                break;
            }
            paramInt += 1;
        }
        label82:
        return -1;
    }

    public static boolean isAllLowerCase(String paramString) {
        if ((paramString == null) || (isEmpty(paramString))) {
            return false;
        }
        int j = paramString.length();
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                break label43;
            }
            if (!Character.isLowerCase(paramString.charAt(i))) {
                break;
            }
            i += 1;
        }
        label43:
        return true;
    }

    public static boolean isAllUpperCase(String paramString) {
        if ((paramString == null) || (isEmpty(paramString))) {
            return false;
        }
        int j = paramString.length();
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                break label43;
            }
            if (!Character.isUpperCase(paramString.charAt(i))) {
                break;
            }
            i += 1;
        }
        label43:
        return true;
    }

    public static boolean isAlpha(String paramString) {
        if (paramString == null) {
            return false;
        }
        int j = paramString.length();
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                break label36;
            }
            if (!Character.isLetter(paramString.charAt(i))) {
                break;
            }
            i += 1;
        }
        label36:
        return true;
    }

    public static boolean isAlphaSpace(String paramString) {
        if (paramString == null) {
            return false;
        }
        int j = paramString.length();
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                break label46;
            }
            if ((!Character.isLetter(paramString.charAt(i))) && (paramString.charAt(i) != ' ')) {
                break;
            }
            i += 1;
        }
        label46:
        return true;
    }

    public static boolean isAlphanumeric(String paramString) {
        if (paramString == null) {
            return false;
        }
        int j = paramString.length();
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                break label36;
            }
            if (!Character.isLetterOrDigit(paramString.charAt(i))) {
                break;
            }
            i += 1;
        }
        label36:
        return true;
    }

    public static boolean isAlphanumericSpace(String paramString) {
        if (paramString == null) {
            return false;
        }
        int j = paramString.length();
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                break label46;
            }
            if ((!Character.isLetterOrDigit(paramString.charAt(i))) && (paramString.charAt(i) != ' ')) {
                break;
            }
            i += 1;
        }
        label46:
        return true;
    }

    public static boolean isAsciiPrintable(String paramString) {
        if (paramString == null) {
            return false;
        }
        int j = paramString.length();
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                break label36;
            }
            if (!CharUtils.isAsciiPrintable(paramString.charAt(i))) {
                break;
            }
            i += 1;
        }
        label36:
        return true;
    }

    public static boolean isBlank(String paramString) {
        int j;
        if (paramString != null) {
            j = paramString.length();
            if (j != 0) {
                break label15;
            }
        }
        for (; ; ) {
            return true;
            label15:
            int i = 0;
            while (i < j) {
                if (!Character.isWhitespace(paramString.charAt(i))) {
                    return false;
                }
                i += 1;
            }
        }
    }

    public static boolean isEmpty(String paramString) {
        return (paramString == null) || (paramString.length() == 0);
    }

    public static boolean isNotBlank(String paramString) {
        return !isBlank(paramString);
    }

    public static boolean isNotEmpty(String paramString) {
        return !isEmpty(paramString);
    }

    public static boolean isNumeric(String paramString) {
        if (paramString == null) {
            return false;
        }
        int j = paramString.length();
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                break label36;
            }
            if (!Character.isDigit(paramString.charAt(i))) {
                break;
            }
            i += 1;
        }
        label36:
        return true;
    }

    public static boolean isNumericSpace(String paramString) {
        if (paramString == null) {
            return false;
        }
        int j = paramString.length();
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                break label46;
            }
            if ((!Character.isDigit(paramString.charAt(i))) && (paramString.charAt(i) != ' ')) {
                break;
            }
            i += 1;
        }
        label46:
        return true;
    }

    public static boolean isWhitespace(String paramString) {
        if (paramString == null) {
            return false;
        }
        int j = paramString.length();
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                break label36;
            }
            if (!Character.isWhitespace(paramString.charAt(i))) {
                break;
            }
            i += 1;
        }
        label36:
        return true;
    }

    public static String join(Collection paramCollection, char paramChar) {
        if (paramCollection == null) {
            return null;
        }
        return join(paramCollection.iterator(), paramChar);
    }

    public static String join(Collection paramCollection, String paramString) {
        if (paramCollection == null) {
            return null;
        }
        return join(paramCollection.iterator(), paramString);
    }

    public static String join(Iterator paramIterator, char paramChar) {
        if (paramIterator == null) {
            return null;
        }
        if (!paramIterator.hasNext()) {
            return "";
        }
        Object localObject = paramIterator.next();
        if (!paramIterator.hasNext()) {
            return ObjectUtils.toString(localObject);
        }
        StringBuffer localStringBuffer = new StringBuffer(256);
        if (localObject != null) {
            localStringBuffer.append(localObject);
        }
        while (paramIterator.hasNext()) {
            localStringBuffer.append(paramChar);
            localObject = paramIterator.next();
            if (localObject != null) {
                localStringBuffer.append(localObject);
            }
        }
        return localStringBuffer.toString();
    }

    public static String join(Iterator paramIterator, String paramString) {
        if (paramIterator == null) {
            return null;
        }
        if (!paramIterator.hasNext()) {
            return "";
        }
        Object localObject = paramIterator.next();
        if (!paramIterator.hasNext()) {
            return ObjectUtils.toString(localObject);
        }
        StringBuffer localStringBuffer = new StringBuffer(256);
        if (localObject != null) {
            localStringBuffer.append(localObject);
        }
        while (paramIterator.hasNext()) {
            if (paramString != null) {
                localStringBuffer.append(paramString);
            }
            localObject = paramIterator.next();
            if (localObject != null) {
                localStringBuffer.append(localObject);
            }
        }
        return localStringBuffer.toString();
    }

    public static String join(Object[] paramArrayOfObject) {
        return join(paramArrayOfObject, null);
    }

    public static String join(Object[] paramArrayOfObject, char paramChar) {
        if (paramArrayOfObject == null) {
            return null;
        }
        return join(paramArrayOfObject, paramChar, 0, paramArrayOfObject.length);
    }

    public static String join(Object[] paramArrayOfObject, char paramChar, int paramInt1, int paramInt2) {
        if (paramArrayOfObject == null) {
            return null;
        }
        int j = paramInt2 - paramInt1;
        if (j <= 0) {
            return "";
        }
        if (paramArrayOfObject[paramInt1] == null) {
        }
        StringBuffer localStringBuffer;
        for (int i = 16; ; i = paramArrayOfObject[paramInt1].toString().length()) {
            localStringBuffer = new StringBuffer(j * (i + 1));
            i = paramInt1;
            while (i < paramInt2) {
                if (i > paramInt1) {
                    localStringBuffer.append(paramChar);
                }
                if (paramArrayOfObject[i] != null) {
                    localStringBuffer.append(paramArrayOfObject[i]);
                }
                i += 1;
            }
        }
        return localStringBuffer.toString();
    }

    public static String join(Object[] paramArrayOfObject, String paramString) {
        if (paramArrayOfObject == null) {
            return null;
        }
        return join(paramArrayOfObject, paramString, 0, paramArrayOfObject.length);
    }

    public static String join(Object[] paramArrayOfObject, String paramString, int paramInt1, int paramInt2) {
        if (paramArrayOfObject == null) {
            return null;
        }
        String str = paramString;
        if (paramString == null) {
            str = "";
        }
        int j = paramInt2 - paramInt1;
        if (j <= 0) {
            return "";
        }
        if (paramArrayOfObject[paramInt1] == null) {
        }
        for (int i = 16; ; i = paramArrayOfObject[paramInt1].toString().length()) {
            paramString = new StringBuffer(j * (i + str.length()));
            i = paramInt1;
            while (i < paramInt2) {
                if (i > paramInt1) {
                    paramString.append(str);
                }
                if (paramArrayOfObject[i] != null) {
                    paramString.append(paramArrayOfObject[i]);
                }
                i += 1;
            }
        }
        return paramString.toString();
    }

    public static int lastIndexOf(String paramString, char paramChar) {
        if (isEmpty(paramString)) {
            return -1;
        }
        return paramString.lastIndexOf(paramChar);
    }

    public static int lastIndexOf(String paramString, char paramChar, int paramInt) {
        if (isEmpty(paramString)) {
            return -1;
        }
        return paramString.lastIndexOf(paramChar, paramInt);
    }

    public static int lastIndexOf(String paramString1, String paramString2) {
        if ((paramString1 == null) || (paramString2 == null)) {
            return -1;
        }
        return paramString1.lastIndexOf(paramString2);
    }

    public static int lastIndexOf(String paramString1, String paramString2, int paramInt) {
        if ((paramString1 == null) || (paramString2 == null)) {
            return -1;
        }
        return paramString1.lastIndexOf(paramString2, paramInt);
    }

    public static int lastIndexOfAny(String paramString, String[] paramArrayOfString) {
        int k;
        if ((paramString == null) || (paramArrayOfString == null)) {
            k = -1;
        }
        int n;
        int i;
        int j;
        do {
            return k;
            n = paramArrayOfString.length;
            i = -1;
            j = 0;
            k = i;
        } while (j >= n);
        String str = paramArrayOfString[j];
        if (str == null) {
            k = i;
        }
        for (; ; ) {
            j += 1;
            i = k;
            break;
            int m = paramString.lastIndexOf(str);
            k = i;
            if (m > i) {
                k = m;
            }
        }
    }

    public static int lastIndexOfIgnoreCase(String paramString1, String paramString2) {
        if ((paramString1 == null) || (paramString2 == null)) {
            return -1;
        }
        return lastIndexOfIgnoreCase(paramString1, paramString2, paramString1.length());
    }

    public static int lastIndexOfIgnoreCase(String paramString1, String paramString2, int paramInt) {
        if ((paramString1 == null) || (paramString2 == null)) {
            i = -1;
            return i;
        }
        int i = paramInt;
        if (paramInt > paramString1.length() - paramString2.length()) {
            i = paramString1.length() - paramString2.length();
        }
        if (i < 0) {
            return -1;
        }
        if (paramString2.length() == 0) {
            return i;
        }
        paramInt = i;
        for (; ; ) {
            if (paramInt < 0) {
                break label82;
            }
            i = paramInt;
            if (paramString1.regionMatches(true, paramInt, paramString2, 0, paramString2.length())) {
                break;
            }
            paramInt -= 1;
        }
        label82:
        return -1;
    }

    public static int lastOrdinalIndexOf(String paramString1, String paramString2, int paramInt) {
        return ordinalIndexOf(paramString1, paramString2, paramInt, true);
    }

    public static String left(String paramString, int paramInt) {
        String str;
        if (paramString == null) {
            str = null;
        }
        do {
            return str;
            if (paramInt < 0) {
                return "";
            }
            str = paramString;
        } while (paramString.length() <= paramInt);
        return paramString.substring(0, paramInt);
    }

    public static String leftPad(String paramString, int paramInt) {
        return leftPad(paramString, paramInt, ' ');
    }

    public static String leftPad(String paramString, int paramInt, char paramChar) {
        String str;
        if (paramString == null) {
            str = null;
        }
        int i;
        do {
            return str;
            i = paramInt - paramString.length();
            str = paramString;
        } while (i <= 0);
        if (i > 8192) {
            return leftPad(paramString, paramInt, String.valueOf(paramChar));
        }
        return padding(i, paramChar).concat(paramString);
    }

    public static String leftPad(String paramString1, int paramInt, String paramString2) {
        if (paramString1 == null) {
            paramString2 = null;
        }
        int i;
        int j;
        do {
            return paramString2;
            localObject = paramString2;
            if (isEmpty(paramString2)) {
                localObject = " ";
            }
            i = ((String) localObject).length();
            j = paramInt - paramString1.length();
            paramString2 = paramString1;
        } while (j <= 0);
        if ((i == 1) && (j <= 8192)) {
            return leftPad(paramString1, paramInt, ((String) localObject).charAt(0));
        }
        if (j == i) {
            return ((String) localObject).concat(paramString1);
        }
        if (j < i) {
            return ((String) localObject).substring(0, j).concat(paramString1);
        }
        paramString2 = new char[j];
        Object localObject = ((String) localObject).toCharArray();
        paramInt = 0;
        while (paramInt < j) {
            paramString2[paramInt] = localObject[(paramInt % i)];
            paramInt += 1;
        }
        return new String(paramString2).concat(paramString1);
    }

    public static int length(String paramString) {
        if (paramString == null) {
            return 0;
        }
        return paramString.length();
    }

    public static String lowerCase(String paramString) {
        if (paramString == null) {
            return null;
        }
        return paramString.toLowerCase();
    }

    public static String lowerCase(String paramString, Locale paramLocale) {
        if (paramString == null) {
            return null;
        }
        return paramString.toLowerCase(paramLocale);
    }

    public static String mid(String paramString, int paramInt1, int paramInt2) {
        if (paramString == null) {
            return null;
        }
        if ((paramInt2 < 0) || (paramInt1 > paramString.length())) {
            return "";
        }
        int i = paramInt1;
        if (paramInt1 < 0) {
            i = 0;
        }
        if (paramString.length() <= i + paramInt2) {
            return paramString.substring(i);
        }
        return paramString.substring(i, i + paramInt2);
    }

    public static int ordinalIndexOf(String paramString1, String paramString2, int paramInt) {
        return ordinalIndexOf(paramString1, paramString2, paramInt, false);
    }

    private static int ordinalIndexOf(String paramString1, String paramString2, int paramInt, boolean paramBoolean) {
        int j = -1;
        int m = j;
        if (paramString1 != null) {
            m = j;
            if (paramString2 != null) {
                if (paramInt > 0) {
                    break label30;
                }
                m = j;
            }
        }
        return m;
        label30:
        if (paramString2.length() == 0) {
            if (paramBoolean) {
            }
            for (paramInt = paramString1.length(); ; paramInt = 0) {
                return paramInt;
            }
        }
        int i = 0;
        int k = i;
        if (paramBoolean) {
            j = paramString1.length();
            k = i;
        }
        label74:
        if (paramBoolean) {
        }
        for (i = paramString1.lastIndexOf(paramString2, j - 1); ; i = paramString1.indexOf(paramString2, j + 1)) {
            m = i;
            if (i < 0) {
                break;
            }
            m = k + 1;
            k = m;
            j = i;
            if (m < paramInt) {
                break label74;
            }
            return i;
        }
    }

    public static String overlay(String paramString1, String paramString2, int paramInt1, int paramInt2) {
        if (paramString1 == null) {
            return null;
        }
        String str = paramString2;
        if (paramString2 == null) {
            str = "";
        }
        int j = paramString1.length();
        int i = paramInt1;
        if (paramInt1 < 0) {
            i = 0;
        }
        paramInt1 = i;
        if (i > j) {
            paramInt1 = j;
        }
        i = paramInt2;
        if (paramInt2 < 0) {
            i = 0;
        }
        paramInt2 = i;
        if (i > j) {
            paramInt2 = j;
        }
        int k = paramInt1;
        i = paramInt2;
        if (paramInt1 > paramInt2) {
            i = paramInt1;
            k = paramInt2;
        }
        return j + k - i + str.length() + 1 + paramString1.substring(0, k) + str + paramString1.substring(i);
    }

    public static String overlayString(String paramString1, String paramString2, int paramInt1, int paramInt2) {
        return paramString2.length() + paramInt1 + paramString1.length() - paramInt2 + 1 + paramString1.substring(0, paramInt1) + paramString2 + paramString1.substring(paramInt2);
    }

    private static String padding(int paramInt, char paramChar)
            throws IndexOutOfBoundsException {
        if (paramInt < 0) {
            throw new IndexOutOfBoundsException("Cannot pad a negative amount: " + paramInt);
        }
        char[] arrayOfChar = new char[paramInt];
        paramInt = 0;
        while (paramInt < arrayOfChar.length) {
            arrayOfChar[paramInt] = paramChar;
            paramInt += 1;
        }
        return new String(arrayOfChar);
    }

    public static String prechomp(String paramString1, String paramString2) {
        int i = paramString1.indexOf(paramString2);
        if (i == -1) {
            return paramString1;
        }
        return paramString1.substring(paramString2.length() + i);
    }

    public static String remove(String paramString, char paramChar) {
        if ((isEmpty(paramString)) || (paramString.indexOf(paramChar) == -1)) {
            return paramString;
        }
        paramString = paramString.toCharArray();
        int j = 0;
        int i = 0;
        while (i < paramString.length) {
            int k = j;
            if (paramString[i] != paramChar) {
                paramString[j] = paramString[i];
                k = j + 1;
            }
            i += 1;
            j = k;
        }
        return new String(paramString, 0, j);
    }

    public static String remove(String paramString1, String paramString2) {
        if ((isEmpty(paramString1)) || (isEmpty(paramString2))) {
            return paramString1;
        }
        return replace(paramString1, paramString2, "", -1);
    }

    public static String removeEnd(String paramString1, String paramString2) {
        if ((isEmpty(paramString1)) || (isEmpty(paramString2))) {
        }
        while (!paramString1.endsWith(paramString2)) {
            return paramString1;
        }
        return paramString1.substring(0, paramString1.length() - paramString2.length());
    }

    public static String removeEndIgnoreCase(String paramString1, String paramString2) {
        if ((isEmpty(paramString1)) || (isEmpty(paramString2))) {
        }
        while (!endsWithIgnoreCase(paramString1, paramString2)) {
            return paramString1;
        }
        return paramString1.substring(0, paramString1.length() - paramString2.length());
    }

    public static String removeStart(String paramString1, String paramString2) {
        if ((isEmpty(paramString1)) || (isEmpty(paramString2))) {
        }
        while (!paramString1.startsWith(paramString2)) {
            return paramString1;
        }
        return paramString1.substring(paramString2.length());
    }

    public static String removeStartIgnoreCase(String paramString1, String paramString2) {
        if ((isEmpty(paramString1)) || (isEmpty(paramString2))) {
        }
        while (!startsWithIgnoreCase(paramString1, paramString2)) {
            return paramString1;
        }
        return paramString1.substring(paramString2.length());
    }

    public static String repeat(String paramString, int paramInt) {
        Object localObject;
        if (paramString == null) {
            localObject = null;
        }
        int k;
        do {
            do {
                return (String) localObject;
                if (paramInt <= 0) {
                    return "";
                }
                k = paramString.length();
                localObject = paramString;
            } while (paramInt == 1);
            localObject = paramString;
        } while (k == 0);
        if ((k == 1) && (paramInt <= 8192)) {
            return padding(paramInt, paramString.charAt(0));
        }
        int m = k * paramInt;
        switch (k) {
            default:
                localObject = new StringBuffer(m);
                k = 0;
        }
        while (k < paramInt) {
            ((StringBuffer) localObject).append(paramString);
            k += 1;
            continue;
            int i = paramString.charAt(0);
            paramString = new char[m];
            paramInt -= 1;
            while (paramInt >= 0) {
                paramString[paramInt] = i;
                paramInt -= 1;
            }
            return new String(paramString);
            i = paramString.charAt(0);
            int j = paramString.charAt(1);
            paramString = new char[m];
            for (paramInt = paramInt * 2 - 2; paramInt >= 0; paramInt = paramInt - 1 - 1) {
                paramString[paramInt] = i;
                paramString[(paramInt + 1)] = j;
            }
            return new String(paramString);
        }
        return ((StringBuffer) localObject).toString();
    }

    public static String repeat(String paramString1, String paramString2, int paramInt) {
        if ((paramString1 == null) || (paramString2 == null)) {
            return repeat(paramString1, paramInt);
        }
        return removeEnd(repeat(paramString1 + paramString2, paramInt), paramString2);
    }

    public static String replace(String paramString1, String paramString2, String paramString3) {
        return replace(paramString1, paramString2, paramString3, -1);
    }

    public static String replace(String paramString1, String paramString2, String paramString3, int paramInt) {
        int i = 64;
        if ((isEmpty(paramString1)) || (isEmpty(paramString2)) || (paramString3 == null) || (paramInt == 0)) {
        }
        int m;
        int k;
        do {
            return paramString1;
            m = 0;
            k = paramString1.indexOf(paramString2, 0);
        } while (k == -1);
        int i1 = paramString2.length();
        int n = paramString3.length() - i1;
        int j = n;
        if (n < 0) {
            j = 0;
        }
        StringBuffer localStringBuffer;
        if (paramInt < 0) {
            i = 16;
            localStringBuffer = new StringBuffer(paramString1.length() + j * i);
            i = paramInt;
            paramInt = m;
        }
        for (j = k; ; j = paramString1.indexOf(paramString2, paramInt)) {
            k = paramInt;
            if (j != -1) {
                localStringBuffer.append(paramString1.substring(paramInt, j)).append(paramString3);
                paramInt = j + i1;
                i -= 1;
                if (i == 0) {
                    k = paramInt;
                }
            } else {
                localStringBuffer.append(paramString1.substring(k));
                return localStringBuffer.toString();
                if (paramInt > 64) {
                    break;
                }
                i = paramInt;
                break;
            }
        }
    }

    public static String replaceChars(String paramString, char paramChar1, char paramChar2) {
        if (paramString == null) {
            return null;
        }
        return paramString.replace(paramChar1, paramChar2);
    }

    public static String replaceChars(String paramString1, String paramString2, String paramString3) {
        if ((isEmpty(paramString1)) || (isEmpty(paramString2))) {
        }
        int j;
        do {
            return paramString1;
            String str = paramString3;
            if (paramString3 == null) {
                str = "";
            }
            j = 0;
            int m = str.length();
            int n = paramString1.length();
            paramString3 = new StringBuffer(n);
            int i = 0;
            if (i < n) {
                char c = paramString1.charAt(i);
                int i1 = paramString2.indexOf(c);
                if (i1 >= 0) {
                    int k = 1;
                    j = k;
                    if (i1 < m) {
                        paramString3.append(str.charAt(i1));
                        j = k;
                    }
                }
                for (; ; ) {
                    i += 1;
                    break;
                    paramString3.append(c);
                }
            }
        } while (j == 0);
        return paramString3.toString();
    }

    public static String replaceEach(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2) {
        return replaceEach(paramString, paramArrayOfString1, paramArrayOfString2, false, 0);
    }

    private static String replaceEach(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean, int paramInt) {
        if ((paramString == null) || (paramString.length() == 0) || (paramArrayOfString1 == null) || (paramArrayOfString1.length == 0) || (paramArrayOfString2 == null) || (paramArrayOfString2.length == 0)) {
        }
        int i3;
        boolean[] arrayOfBoolean;
        label233:
        do {
            return paramString;
            if (paramInt < 0) {
                throw new IllegalStateException("TimeToLive of " + paramInt + " is less than 0: " + paramString);
            }
            i3 = paramArrayOfString1.length;
            i = paramArrayOfString2.length;
            if (i3 != i) {
                throw new IllegalArgumentException("Search and Replace array lengths don't match: " + i3 + " vs " + i);
            }
            arrayOfBoolean = new boolean[i3];
            i = -1;
            j = -1;
            k = 0;
            if (k < i3) {
                m = j;
                n = i;
                if (arrayOfBoolean[k] == 0) {
                    m = j;
                    n = i;
                    if (paramArrayOfString1[k] != null) {
                        m = j;
                        n = i;
                        if (paramArrayOfString1[k].length() != 0) {
                            if (paramArrayOfString2[k] != null) {
                                break label233;
                            }
                            n = i;
                            m = j;
                        }
                    }
                }
                for (; ; ) {
                    k += 1;
                    j = m;
                    i = n;
                    break;
                    i1 = paramString.indexOf(paramArrayOfString1[k]);
                    if (i1 == -1) {
                        arrayOfBoolean[k] = true;
                        m = j;
                        n = i;
                    } else if (i != -1) {
                        m = j;
                        n = i;
                        if (i1 >= i) {
                        }
                    } else {
                        n = i1;
                        m = k;
                    }
                }
            }
        } while (i == -1);
        int i1 = 0;
        int m = 0;
        int k = 0;
        label355:
        int i2;
        if (k < paramArrayOfString1.length) {
            n = m;
            if (paramArrayOfString1[k] != null) {
                if (paramArrayOfString2[k] != null) {
                    break label355;
                }
                n = m;
            }
            for (; ; ) {
                k += 1;
                m = n;
                break;
                i2 = paramArrayOfString2[k].length() - paramArrayOfString1[k].length();
                n = m;
                if (i2 > 0) {
                    n = m + i2 * 3;
                }
            }
        }
        k = Math.min(m, paramString.length() / 5);
        StringBuffer localStringBuffer = new StringBuffer(paramString.length() + k);
        int n = i;
        int i = i1;
        i1 = j;
        while (n != -1) {
            while (i < n) {
                localStringBuffer.append(paramString.charAt(i));
                i += 1;
            }
            localStringBuffer.append(paramArrayOfString2[i1]);
            i2 = n + paramArrayOfString1[i1].length();
            k = -1;
            m = -1;
            j = 0;
            i1 = m;
            i = i2;
            n = k;
            if (j < i3) {
                i = m;
                n = k;
                if (arrayOfBoolean[j] == 0) {
                    i = m;
                    n = k;
                    if (paramArrayOfString1[j] != null) {
                        i = m;
                        n = k;
                        if (paramArrayOfString1[j].length() != 0) {
                            if (paramArrayOfString2[j] != null) {
                                break label599;
                            }
                            n = k;
                            i = m;
                        }
                    }
                }
                for (; ; ) {
                    j += 1;
                    m = i;
                    k = n;
                    break;
                    label599:
                    i1 = paramString.indexOf(paramArrayOfString1[j], i2);
                    if (i1 == -1) {
                        arrayOfBoolean[j] = true;
                        i = m;
                        n = k;
                    } else if (k != -1) {
                        i = m;
                        n = k;
                        if (i1 >= k) {
                        }
                    } else {
                        n = i1;
                        i = j;
                    }
                }
            }
        }
        int j = paramString.length();
        while (i < j) {
            localStringBuffer.append(paramString.charAt(i));
            i += 1;
        }
        paramString = localStringBuffer.toString();
        if (!paramBoolean) {
            return paramString;
        }
        return replaceEach(paramString, paramArrayOfString1, paramArrayOfString2, paramBoolean, paramInt - 1);
    }

    public static String replaceEachRepeatedly(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2) {
        if (paramArrayOfString1 == null) {
        }
        for (int i = 0; ; i = paramArrayOfString1.length) {
            return replaceEach(paramString, paramArrayOfString1, paramArrayOfString2, true, i);
        }
    }

    public static String replaceOnce(String paramString1, String paramString2, String paramString3) {
        return replace(paramString1, paramString2, paramString3, 1);
    }

    public static String reverse(String paramString) {
        if (paramString == null) {
            return null;
        }
        return new StringBuffer(paramString).reverse().toString();
    }

    public static String reverseDelimited(String paramString, char paramChar) {
        if (paramString == null) {
            return null;
        }
        paramString = split(paramString, paramChar);
        ArrayUtils.reverse(paramString);
        return join(paramString, paramChar);
    }

    public static String reverseDelimitedString(String paramString1, String paramString2) {
        if (paramString1 == null) {
            return null;
        }
        paramString1 = split(paramString1, paramString2);
        ArrayUtils.reverse(paramString1);
        if (paramString2 == null) {
            return join(paramString1, ' ');
        }
        return join(paramString1, paramString2);
    }

    public static String right(String paramString, int paramInt) {
        String str;
        if (paramString == null) {
            str = null;
        }
        do {
            return str;
            if (paramInt < 0) {
                return "";
            }
            str = paramString;
        } while (paramString.length() <= paramInt);
        return paramString.substring(paramString.length() - paramInt);
    }

    public static String rightPad(String paramString, int paramInt) {
        return rightPad(paramString, paramInt, ' ');
    }

    public static String rightPad(String paramString, int paramInt, char paramChar) {
        String str;
        if (paramString == null) {
            str = null;
        }
        int i;
        do {
            return str;
            i = paramInt - paramString.length();
            str = paramString;
        } while (i <= 0);
        if (i > 8192) {
            return rightPad(paramString, paramInt, String.valueOf(paramChar));
        }
        return paramString.concat(padding(i, paramChar));
    }

    public static String rightPad(String paramString1, int paramInt, String paramString2) {
        if (paramString1 == null) {
            paramString2 = null;
        }
        int i;
        int j;
        do {
            return paramString2;
            localObject = paramString2;
            if (isEmpty(paramString2)) {
                localObject = " ";
            }
            i = ((String) localObject).length();
            j = paramInt - paramString1.length();
            paramString2 = paramString1;
        } while (j <= 0);
        if ((i == 1) && (j <= 8192)) {
            return rightPad(paramString1, paramInt, ((String) localObject).charAt(0));
        }
        if (j == i) {
            return paramString1.concat((String) localObject);
        }
        if (j < i) {
            return paramString1.concat(((String) localObject).substring(0, j));
        }
        paramString2 = new char[j];
        Object localObject = ((String) localObject).toCharArray();
        paramInt = 0;
        while (paramInt < j) {
            paramString2[paramInt] = localObject[(paramInt % i)];
            paramInt += 1;
        }
        return paramString1.concat(new String(paramString2));
    }

    public static String[] split(String paramString) {
        return split(paramString, null, -1);
    }

    public static String[] split(String paramString, char paramChar) {
        return splitWorker(paramString, paramChar, false);
    }

    public static String[] split(String paramString1, String paramString2) {
        return splitWorker(paramString1, paramString2, -1, false);
    }

    public static String[] split(String paramString1, String paramString2, int paramInt) {
        return splitWorker(paramString1, paramString2, paramInt, false);
    }

    public static String[] splitByCharacterType(String paramString) {
        return splitByCharacterType(paramString, false);
    }

    private static String[] splitByCharacterType(String paramString, boolean paramBoolean) {
        if (paramString == null) {
            return null;
        }
        if (paramString.length() == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        paramString = paramString.toCharArray();
        ArrayList localArrayList = new ArrayList();
        int k = 0;
        int i = Character.getType(paramString[0]);
        int j = 0 + 1;
        while (j < paramString.length) {
            int m = Character.getType(paramString[j]);
            if (m == i) {
                m = k;
                k = i;
                j += 1;
                i = k;
                k = m;
            } else {
                int n;
                if ((paramBoolean) && (m == 2) && (i == 1)) {
                    n = j - 1;
                    i = k;
                    if (n != k) {
                        localArrayList.add(new String(paramString, k, n - k));
                    }
                }
                for (i = n; ; i = j) {
                    k = m;
                    m = i;
                    break;
                    localArrayList.add(new String(paramString, k, j - k));
                }
            }
        }
        localArrayList.add(new String(paramString, k, paramString.length - k));
        return (String[]) localArrayList.toArray(new String[localArrayList.size()]);
    }

    public static String[] splitByCharacterTypeCamelCase(String paramString) {
        return splitByCharacterType(paramString, true);
    }

    public static String[] splitByWholeSeparator(String paramString1, String paramString2) {
        return splitByWholeSeparatorWorker(paramString1, paramString2, -1, false);
    }

    public static String[] splitByWholeSeparator(String paramString1, String paramString2, int paramInt) {
        return splitByWholeSeparatorWorker(paramString1, paramString2, paramInt, false);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String paramString1, String paramString2) {
        return splitByWholeSeparatorWorker(paramString1, paramString2, -1, true);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String paramString1, String paramString2, int paramInt) {
        return splitByWholeSeparatorWorker(paramString1, paramString2, paramInt, true);
    }

    private static String[] splitByWholeSeparatorWorker(String paramString1, String paramString2, int paramInt, boolean paramBoolean) {
        if (paramString1 == null) {
            return null;
        }
        int j = paramString1.length();
        if (j == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        if ((paramString2 == null) || ("".equals(paramString2))) {
            return splitWorker(paramString1, null, paramInt, paramBoolean);
        }
        int i2 = paramString2.length();
        ArrayList localArrayList = new ArrayList();
        int m = 0;
        int k = 0;
        int i = 0;
        while (i < j) {
            int n = paramString1.indexOf(paramString2, k);
            if (n > -1) {
                if (n > k) {
                    m += 1;
                    if (m == paramInt) {
                        i = j;
                        localArrayList.add(paramString1.substring(k));
                    } else {
                        localArrayList.add(paramString1.substring(k, n));
                        k = n + i2;
                        i = n;
                    }
                } else {
                    i = n;
                    int i1 = m;
                    if (paramBoolean) {
                        i1 = m + 1;
                        if (i1 != paramInt) {
                            break label208;
                        }
                        i = j;
                        localArrayList.add(paramString1.substring(k));
                    }
                    for (; ; ) {
                        k = i + i2;
                        m = i1;
                        break;
                        label208:
                        localArrayList.add("");
                        i = n;
                    }
                }
            } else {
                localArrayList.add(paramString1.substring(k));
                i = j;
            }
        }
        return (String[]) localArrayList.toArray(new String[localArrayList.size()]);
    }

    public static String[] splitPreserveAllTokens(String paramString) {
        return splitWorker(paramString, null, -1, true);
    }

    public static String[] splitPreserveAllTokens(String paramString, char paramChar) {
        return splitWorker(paramString, paramChar, true);
    }

    public static String[] splitPreserveAllTokens(String paramString1, String paramString2) {
        return splitWorker(paramString1, paramString2, -1, true);
    }

    public static String[] splitPreserveAllTokens(String paramString1, String paramString2, int paramInt) {
        return splitWorker(paramString1, paramString2, paramInt, true);
    }

    private static String[] splitWorker(String paramString, char paramChar, boolean paramBoolean) {
        if (paramString == null) {
            return null;
        }
        int n = paramString.length();
        if (n == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        int m = 0;
        int k = 0;
        int j = 0;
        while (i < n) {
            if (paramString.charAt(i) == paramChar) {
                if ((k != 0) || (paramBoolean)) {
                    localArrayList.add(paramString.substring(m, i));
                    k = 0;
                    j = 1;
                }
                i += 1;
                m = i;
            } else {
                j = 0;
                k = 1;
                i += 1;
            }
        }
        if ((k != 0) || ((paramBoolean) && (j != 0))) {
            localArrayList.add(paramString.substring(m, i));
        }
        return (String[]) localArrayList.toArray(new String[localArrayList.size()]);
    }

    private static String[] splitWorker(String paramString1, String paramString2, int paramInt, boolean paramBoolean) {
        if (paramString1 == null) {
            return null;
        }
        int n = paramString1.length();
        if (n == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        int i8 = 0;
        int i2 = 0;
        int i5 = 0;
        int i1 = 0;
        int i7 = 0;
        int i3 = 0;
        int i4 = 0;
        int m = 0;
        int j = 0;
        int i6 = 0;
        int k = 0;
        if (paramString2 == null) {
            j = 1;
            i1 = i7;
            i = i2;
            i5 = i;
            i4 = k;
            i2 = m;
            i3 = j;
            i3 = i1;
            if (i >= n) {
                break label523;
            }
            if (Character.isWhitespace(paramString1.charAt(i))) {
                if ((m == 0) && (!paramBoolean)) {
                    break label571;
                }
                k = 1;
                m = j + 1;
                if (j == paramInt) {
                    i = n;
                    k = 0;
                }
                localArrayList.add(paramString1.substring(i1, i));
                i1 = 0;
                j = m;
                m = i1;
            }
        }
        label340:
        label520:
        label523:
        label542:
        label571:
        for (; ; ) {
            i += 1;
            i1 = i;
            break;
            k = 0;
            m = 1;
            i += 1;
            break;
            if (paramString2.length() == 1) {
                i4 = paramString2.charAt(0);
                i1 = 1;
                m = i5;
                k = i3;
                while (i < n) {
                    if (paramString1.charAt(i) == i4) {
                        if ((k == 0) && (!paramBoolean)) {
                            break label542;
                        }
                        j = 1;
                        k = i1 + 1;
                        if (i1 == paramInt) {
                            i = n;
                            j = 0;
                        }
                        localArrayList.add(paramString1.substring(m, i));
                        m = 0;
                        i += 1;
                        i2 = i;
                        i1 = k;
                        k = m;
                        m = i2;
                    } else {
                        j = 0;
                        k = 1;
                        i += 1;
                    }
                }
                if ((k != 0) || ((paramBoolean) && (j != 0))) {
                    localArrayList.add(paramString1.substring(m, i));
                }
                return (String[]) localArrayList.toArray(new String[localArrayList.size()]);
            }
            for (; ; ) {
                i5 = i;
                i4 = j;
                i2 = m;
                i3 = k;
                i3 = i1;
                if (i < n) {
                    if (paramString2.indexOf(paramString1.charAt(i)) >= 0) {
                        if ((m == 0) && (!paramBoolean)) {
                            break label520;
                        }
                        j = 1;
                        m = k + 1;
                        if (k == paramInt) {
                            i = n;
                            j = 0;
                        }
                        localArrayList.add(paramString1.substring(i1, i));
                        i1 = 0;
                        k = m;
                        m = i1;
                    }
                    for (; ; ) {
                        i += 1;
                        i1 = i;
                        break;
                        j = 0;
                        m = 1;
                        i += 1;
                        break;
                    }
                }
                i = i5;
                j = i4;
                k = i2;
                m = i3;
                break label340;
                m = k;
                k = i1;
                break;
                k = 1;
                i = i8;
                j = i6;
                m = i4;
            }
        }
    }

    public static boolean startsWith(String paramString1, String paramString2) {
        return startsWith(paramString1, paramString2, false);
    }

    private static boolean startsWith(String paramString1, String paramString2, boolean paramBoolean) {
        boolean bool2 = false;
        boolean bool1;
        if ((paramString1 == null) || (paramString2 == null)) {
            bool1 = bool2;
            if (paramString1 == null) {
                bool1 = bool2;
                if (paramString2 == null) {
                    bool1 = true;
                }
            }
        }
        do {
            return bool1;
            bool1 = bool2;
        } while (paramString2.length() > paramString1.length());
        return paramString1.regionMatches(paramBoolean, 0, paramString2, 0, paramString2.length());
    }

    public static boolean startsWithAny(String paramString, String[] paramArrayOfString) {
        if ((isEmpty(paramString)) || (ArrayUtils.isEmpty(paramArrayOfString))) {
        }
        for (; ; ) {
            return false;
            int i = 0;
            while (i < paramArrayOfString.length) {
                if (startsWith(paramString, paramArrayOfString[i])) {
                    return true;
                }
                i += 1;
            }
        }
    }

    public static boolean startsWithIgnoreCase(String paramString1, String paramString2) {
        return startsWith(paramString1, paramString2, true);
    }

    public static String strip(String paramString) {
        return strip(paramString, null);
    }

    public static String strip(String paramString1, String paramString2) {
        if (isEmpty(paramString1)) {
            return paramString1;
        }
        return stripEnd(stripStart(paramString1, paramString2), paramString2);
    }

    public static String[] stripAll(String[] paramArrayOfString) {
        return stripAll(paramArrayOfString, null);
    }

    public static String[] stripAll(String[] paramArrayOfString, String paramString) {
        int j;
        Object localObject;
        if (paramArrayOfString != null) {
            j = paramArrayOfString.length;
            if (j != 0) {
            }
        } else {
            localObject = paramArrayOfString;
            return (String[]) localObject;
        }
        String[] arrayOfString = new String[j];
        int i = 0;
        for (; ; ) {
            localObject = arrayOfString;
            if (i >= j) {
                break;
            }
            arrayOfString[i] = strip(paramArrayOfString[i], paramString);
            i += 1;
        }
    }

    public static String stripEnd(String paramString1, String paramString2) {
        int i;
        if (paramString1 != null) {
            i = paramString1.length();
            if (i != 0) {
                break label15;
            }
        }
        label15:
        int j;
        do {
            return paramString1;
            if (paramString2 == null) {
                for (; ; ) {
                    j = i;
                    if (i == 0) {
                        break;
                    }
                    j = i;
                    if (!Character.isWhitespace(paramString1.charAt(i - 1))) {
                        break;
                    }
                    i -= 1;
                }
            }
        } while (paramString2.length() == 0);
        for (; ; ) {
            j = i;
            if (i == 0) {
                break;
            }
            j = i;
            if (paramString2.indexOf(paramString1.charAt(i - 1)) == -1) {
                break;
            }
            i -= 1;
        }
        return paramString1.substring(0, j);
    }

    public static String stripStart(String paramString1, String paramString2) {
        int k;
        if (paramString1 != null) {
            k = paramString1.length();
            if (k != 0) {
                break label17;
            }
        }
        label17:
        int j;
        do {
            return paramString1;
            j = 0;
            i = 0;
            if (paramString2 == null) {
                for (; ; ) {
                    j = i;
                    if (i == k) {
                        break;
                    }
                    j = i;
                    if (!Character.isWhitespace(paramString1.charAt(i))) {
                        break;
                    }
                    i += 1;
                }
            }
        } while (paramString2.length() == 0);
        int i = j;
        for (; ; ) {
            j = i;
            if (i == k) {
                break;
            }
            j = i;
            if (paramString2.indexOf(paramString1.charAt(i)) == -1) {
                break;
            }
            i += 1;
        }
        return paramString1.substring(j);
    }

    public static String stripToEmpty(String paramString) {
        if (paramString == null) {
            return "";
        }
        return strip(paramString, null);
    }

    public static String stripToNull(String paramString) {
        if (paramString == null) {
            return null;
        }
        String str = strip(paramString, null);
        paramString = str;
        if (str.length() == 0) {
            paramString = null;
        }
        return paramString;
    }

    public static String substring(String paramString, int paramInt) {
        if (paramString == null) {
            return null;
        }
        int i = paramInt;
        if (paramInt < 0) {
            i = paramInt + paramString.length();
        }
        paramInt = i;
        if (i < 0) {
            paramInt = 0;
        }
        if (paramInt > paramString.length()) {
            return "";
        }
        return paramString.substring(paramInt);
    }

    public static String substring(String paramString, int paramInt1, int paramInt2) {
        if (paramString == null) {
            return null;
        }
        int i = paramInt2;
        if (paramInt2 < 0) {
            i = paramInt2 + paramString.length();
        }
        paramInt2 = paramInt1;
        if (paramInt1 < 0) {
            paramInt2 = paramInt1 + paramString.length();
        }
        paramInt1 = i;
        if (i > paramString.length()) {
            paramInt1 = paramString.length();
        }
        if (paramInt2 > paramInt1) {
            return "";
        }
        i = paramInt2;
        if (paramInt2 < 0) {
            i = 0;
        }
        paramInt2 = paramInt1;
        if (paramInt1 < 0) {
            paramInt2 = 0;
        }
        return paramString.substring(i, paramInt2);
    }

    public static String substringAfter(String paramString1, String paramString2) {
        if (isEmpty(paramString1)) {
            return paramString1;
        }
        if (paramString2 == null) {
            return "";
        }
        int i = paramString1.indexOf(paramString2);
        if (i == -1) {
            return "";
        }
        return paramString1.substring(paramString2.length() + i);
    }

    public static String substringAfterLast(String paramString1, String paramString2) {
        if (isEmpty(paramString1)) {
            return paramString1;
        }
        if (isEmpty(paramString2)) {
            return "";
        }
        int i = paramString1.lastIndexOf(paramString2);
        if ((i == -1) || (i == paramString1.length() - paramString2.length())) {
            return "";
        }
        return paramString1.substring(paramString2.length() + i);
    }

    public static String substringBefore(String paramString1, String paramString2) {
        if ((isEmpty(paramString1)) || (paramString2 == null)) {
        }
        int i;
        do {
            return paramString1;
            if (paramString2.length() == 0) {
                return "";
            }
            i = paramString1.indexOf(paramString2);
        } while (i == -1);
        return paramString1.substring(0, i);
    }

    public static String substringBeforeLast(String paramString1, String paramString2) {
        if ((isEmpty(paramString1)) || (isEmpty(paramString2))) {
        }
        int i;
        do {
            return paramString1;
            i = paramString1.lastIndexOf(paramString2);
        } while (i == -1);
        return paramString1.substring(0, i);
    }

    public static String substringBetween(String paramString1, String paramString2) {
        return substringBetween(paramString1, paramString2, paramString2);
    }

    public static String substringBetween(String paramString1, String paramString2, String paramString3) {
        if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
        }
        int i;
        int j;
        do {
            do {
                return null;
                i = paramString1.indexOf(paramString2);
            } while (i == -1);
            j = paramString1.indexOf(paramString3, paramString2.length() + i);
        } while (j == -1);
        return paramString1.substring(paramString2.length() + i, j);
    }

    public static String[] substringsBetween(String paramString1, String paramString2, String paramString3) {
        label18:
        int j;
        int k;
        int m;
        ArrayList localArrayList;
        if ((paramString1 == null) || (isEmpty(paramString2)) || (isEmpty(paramString3))) {
            break label78;
            return null;
        } else {
            j = paramString1.length();
            if (j == 0) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            }
            k = paramString3.length();
            m = paramString2.length();
            localArrayList = new ArrayList();
        }
        label78:
        int n;
        for (int i = 0; ; i = n + k) {
            if (i < j - k) {
                i = paramString1.indexOf(paramString2, i);
                if (i >= 0) {
                }
            } else {
                if (localArrayList.isEmpty()) {
                    break label18;
                }
                return (String[]) localArrayList.toArray(new String[localArrayList.size()]);
            }
            i += m;
            n = paramString1.indexOf(paramString3, i);
            if (n < 0) {
                break;
            }
            localArrayList.add(paramString1.substring(i, n));
        }
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
        int i = 0;
        if (i < j) {
            char c2 = paramString.charAt(i);
            char c1;
            if (Character.isUpperCase(c2)) {
                c1 = Character.toLowerCase(c2);
            }
            for (; ; ) {
                localStringBuffer.append(c1);
                i += 1;
                break;
                if (Character.isTitleCase(c2)) {
                    c1 = Character.toLowerCase(c2);
                } else {
                    c1 = c2;
                    if (Character.isLowerCase(c2)) {
                        c1 = Character.toUpperCase(c2);
                    }
                }
            }
        }
        return localStringBuffer.toString();
    }

    public static String trim(String paramString) {
        if (paramString == null) {
            return null;
        }
        return paramString.trim();
    }

    public static String trimToEmpty(String paramString) {
        if (paramString == null) {
            return "";
        }
        return paramString.trim();
    }

    public static String trimToNull(String paramString) {
        String str = trim(paramString);
        paramString = str;
        if (isEmpty(str)) {
            paramString = null;
        }
        return paramString;
    }

    public static String uncapitalise(String paramString) {
        return uncapitalize(paramString);
    }

    public static String uncapitalize(String paramString) {
        int i;
        if (paramString != null) {
            i = paramString.length();
            if (i != 0) {
            }
        } else {
            return paramString;
        }
        return i + Character.toLowerCase(paramString.charAt(0)) + paramString.substring(1);
    }

    public static String upperCase(String paramString) {
        if (paramString == null) {
            return null;
        }
        return paramString.toUpperCase();
    }

    public static String upperCase(String paramString, Locale paramLocale) {
        if (paramString == null) {
            return null;
        }
        return paramString.toUpperCase(paramLocale);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/StringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */