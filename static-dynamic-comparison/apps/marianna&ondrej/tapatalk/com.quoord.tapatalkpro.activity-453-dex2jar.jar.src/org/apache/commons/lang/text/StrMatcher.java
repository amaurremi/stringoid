package org.apache.commons.lang.text;

import java.util.Arrays;

public abstract class StrMatcher {
    private static final StrMatcher COMMA_MATCHER = new CharMatcher(',');
    private static final StrMatcher DOUBLE_QUOTE_MATCHER;
    private static final StrMatcher NONE_MATCHER = new NoMatcher();
    private static final StrMatcher QUOTE_MATCHER;
    private static final StrMatcher SINGLE_QUOTE_MATCHER;
    private static final StrMatcher SPACE_MATCHER;
    private static final StrMatcher SPLIT_MATCHER;
    private static final StrMatcher TAB_MATCHER = new CharMatcher('\t');
    private static final StrMatcher TRIM_MATCHER;

    static {
        SPACE_MATCHER = new CharMatcher(' ');
        SPLIT_MATCHER = new CharSetMatcher(" \t\n\r\f".toCharArray());
        TRIM_MATCHER = new TrimMatcher();
        SINGLE_QUOTE_MATCHER = new CharMatcher('\'');
        DOUBLE_QUOTE_MATCHER = new CharMatcher('"');
        QUOTE_MATCHER = new CharSetMatcher("'\"".toCharArray());
    }

    public static StrMatcher charMatcher(char paramChar) {
        return new CharMatcher(paramChar);
    }

    public static StrMatcher charSetMatcher(String paramString) {
        if ((paramString == null) || (paramString.length() == 0)) {
            return NONE_MATCHER;
        }
        if (paramString.length() == 1) {
            return new CharMatcher(paramString.charAt(0));
        }
        return new CharSetMatcher(paramString.toCharArray());
    }

    public static StrMatcher charSetMatcher(char[] paramArrayOfChar) {
        if ((paramArrayOfChar == null) || (paramArrayOfChar.length == 0)) {
            return NONE_MATCHER;
        }
        if (paramArrayOfChar.length == 1) {
            return new CharMatcher(paramArrayOfChar[0]);
        }
        return new CharSetMatcher(paramArrayOfChar);
    }

    public static StrMatcher commaMatcher() {
        return COMMA_MATCHER;
    }

    public static StrMatcher doubleQuoteMatcher() {
        return DOUBLE_QUOTE_MATCHER;
    }

    public static StrMatcher noneMatcher() {
        return NONE_MATCHER;
    }

    public static StrMatcher quoteMatcher() {
        return QUOTE_MATCHER;
    }

    public static StrMatcher singleQuoteMatcher() {
        return SINGLE_QUOTE_MATCHER;
    }

    public static StrMatcher spaceMatcher() {
        return SPACE_MATCHER;
    }

    public static StrMatcher splitMatcher() {
        return SPLIT_MATCHER;
    }

    public static StrMatcher stringMatcher(String paramString) {
        if ((paramString == null) || (paramString.length() == 0)) {
            return NONE_MATCHER;
        }
        return new StringMatcher(paramString);
    }

    public static StrMatcher tabMatcher() {
        return TAB_MATCHER;
    }

    public static StrMatcher trimMatcher() {
        return TRIM_MATCHER;
    }

    public int isMatch(char[] paramArrayOfChar, int paramInt) {
        return isMatch(paramArrayOfChar, paramInt, 0, paramArrayOfChar.length);
    }

    public abstract int isMatch(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3);

    static final class CharMatcher
            extends StrMatcher {
        private final char ch;

        CharMatcher(char paramChar) {
            this.ch = paramChar;
        }

        public int isMatch(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3) {
            if (this.ch == paramArrayOfChar[paramInt1]) {
                return 1;
            }
            return 0;
        }
    }

    static final class CharSetMatcher
            extends StrMatcher {
        private final char[] chars;

        CharSetMatcher(char[] paramArrayOfChar) {
            this.chars = ((char[]) paramArrayOfChar.clone());
            Arrays.sort(this.chars);
        }

        public int isMatch(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3) {
            if (Arrays.binarySearch(this.chars, paramArrayOfChar[paramInt1]) >= 0) {
                return 1;
            }
            return 0;
        }
    }

    static final class NoMatcher
            extends StrMatcher {
        public int isMatch(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3) {
            return 0;
        }
    }

    static final class StringMatcher
            extends StrMatcher {
        private final char[] chars;

        StringMatcher(String paramString) {
            this.chars = paramString.toCharArray();
        }

        public int isMatch(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3) {
            int i = this.chars.length;
            if (paramInt1 + i > paramInt3) {
                paramInt3 = 0;
                return paramInt3;
            }
            paramInt2 = 0;
            for (; ; ) {
                paramInt3 = i;
                if (paramInt2 >= this.chars.length) {
                    break;
                }
                if (this.chars[paramInt2] != paramArrayOfChar[paramInt1]) {
                    return 0;
                }
                paramInt2 += 1;
                paramInt1 += 1;
            }
        }
    }

    static final class TrimMatcher
            extends StrMatcher {
        public int isMatch(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3) {
            if (paramArrayOfChar[paramInt1] <= ' ') {
                return 1;
            }
            return 0;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/text/StrMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */