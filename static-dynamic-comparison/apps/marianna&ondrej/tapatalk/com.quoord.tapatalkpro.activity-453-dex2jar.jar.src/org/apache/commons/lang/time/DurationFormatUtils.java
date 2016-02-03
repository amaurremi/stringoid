package org.apache.commons.lang.time;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;

public class DurationFormatUtils {
    static final Object H;
    public static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'";
    static final Object M;
    static final Object S = "S";
    static final Object d;
    static final Object m;
    static final Object s;
    static final Object y = "y";

    static {
        M = "M";
        d = "d";
        H = "H";
        m = "m";
        s = "s";
    }

    static String format(Token[] paramArrayOfToken, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean) {
        StringBuffer localStringBuffer = new StringBuffer();
        int k = 0;
        int i1 = paramArrayOfToken.length;
        int j = 0;
        int i = paramInt7;
        if (j < i1) {
            Object localObject1 = paramArrayOfToken[j];
            Object localObject2 = ((Token) localObject1).getValue();
            int i2 = ((Token) localObject1).getCount();
            int n;
            if ((localObject2 instanceof StringBuffer)) {
                localStringBuffer.append(localObject2.toString());
                n = i;
                paramInt7 = k;
            }
            do {
                j += 1;
                k = paramInt7;
                i = n;
                break;
                if (localObject2 == y) {
                    if (paramBoolean) {
                    }
                    for (localObject1 = StringUtils.leftPad(Integer.toString(paramInt1), i2, '0'); ; localObject1 = Integer.toString(paramInt1)) {
                        localStringBuffer.append((String) localObject1);
                        paramInt7 = 0;
                        n = i;
                        break;
                    }
                }
                if (localObject2 == M) {
                    if (paramBoolean) {
                    }
                    for (localObject1 = StringUtils.leftPad(Integer.toString(paramInt2), i2, '0'); ; localObject1 = Integer.toString(paramInt2)) {
                        localStringBuffer.append((String) localObject1);
                        paramInt7 = 0;
                        n = i;
                        break;
                    }
                }
                if (localObject2 == d) {
                    if (paramBoolean) {
                    }
                    for (localObject1 = StringUtils.leftPad(Integer.toString(paramInt3), i2, '0'); ; localObject1 = Integer.toString(paramInt3)) {
                        localStringBuffer.append((String) localObject1);
                        paramInt7 = 0;
                        n = i;
                        break;
                    }
                }
                if (localObject2 == H) {
                    if (paramBoolean) {
                    }
                    for (localObject1 = StringUtils.leftPad(Integer.toString(paramInt4), i2, '0'); ; localObject1 = Integer.toString(paramInt4)) {
                        localStringBuffer.append((String) localObject1);
                        paramInt7 = 0;
                        n = i;
                        break;
                    }
                }
                if (localObject2 == m) {
                    if (paramBoolean) {
                    }
                    for (localObject1 = StringUtils.leftPad(Integer.toString(paramInt5), i2, '0'); ; localObject1 = Integer.toString(paramInt5)) {
                        localStringBuffer.append((String) localObject1);
                        paramInt7 = 0;
                        n = i;
                        break;
                    }
                }
                if (localObject2 == s) {
                    if (paramBoolean) {
                    }
                    for (localObject1 = StringUtils.leftPad(Integer.toString(paramInt6), i2, '0'); ; localObject1 = Integer.toString(paramInt6)) {
                        localStringBuffer.append((String) localObject1);
                        paramInt7 = 1;
                        n = i;
                        break;
                    }
                }
                paramInt7 = k;
                n = i;
            } while (localObject2 != S);
            if (k != 0) {
                i += 1000;
                if (paramBoolean) {
                }
                for (localObject1 = StringUtils.leftPad(Integer.toString(i), i2, '0'); ; localObject1 = Integer.toString(i)) {
                    localStringBuffer.append(((String) localObject1).substring(1));
                    paramInt7 = 0;
                    n = i;
                    break;
                }
            }
            if (paramBoolean) {
            }
            for (localObject1 = StringUtils.leftPad(Integer.toString(i), i2, '0'); ; localObject1 = Integer.toString(i)) {
                localStringBuffer.append((String) localObject1);
                break;
            }
        }
        return localStringBuffer.toString();
    }

    public static String formatDuration(long paramLong, String paramString) {
        return formatDuration(paramLong, paramString, true);
    }

    public static String formatDuration(long paramLong, String paramString, boolean paramBoolean) {
        paramString = lexx(paramString);
        int i = 0;
        int j = 0;
        int k = 0;
        int n = 0;
        int i1 = 0;
        long l = paramLong;
        if (Token.containsTokenWithValue(paramString, d)) {
            i = (int) (paramLong / 86400000L);
            l = paramLong - i * 86400000L;
        }
        paramLong = l;
        if (Token.containsTokenWithValue(paramString, H)) {
            j = (int) (l / 3600000L);
            paramLong = l - j * 3600000L;
        }
        l = paramLong;
        if (Token.containsTokenWithValue(paramString, m)) {
            k = (int) (paramLong / 60000L);
            l = paramLong - k * 60000L;
        }
        paramLong = l;
        if (Token.containsTokenWithValue(paramString, s)) {
            n = (int) (l / 1000L);
            paramLong = l - n * 1000L;
        }
        if (Token.containsTokenWithValue(paramString, S)) {
            i1 = (int) paramLong;
        }
        return format(paramString, 0, 0, i, j, k, n, i1, paramBoolean);
    }

    public static String formatDurationHMS(long paramLong) {
        return formatDuration(paramLong, "H:mm:ss.SSS");
    }

    public static String formatDurationISO(long paramLong) {
        return formatDuration(paramLong, "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'", false);
    }

    public static String formatDurationWords(long paramLong, boolean paramBoolean1, boolean paramBoolean2) {
        Object localObject1 = formatDuration(paramLong, "d' days 'H' hours 'm' minutes 's' seconds'");
        Object localObject2 = localObject1;
        String str;
        if (paramBoolean1) {
            localObject2 = " " + (String) localObject1;
            str = StringUtils.replaceOnce((String) localObject2, " 0 days", "");
            localObject1 = localObject2;
            if (str.length() != ((String) localObject2).length()) {
                localObject2 = str;
                str = StringUtils.replaceOnce((String) localObject2, " 0 hours", "");
                localObject1 = localObject2;
                if (str.length() != ((String) localObject2).length()) {
                    str = StringUtils.replaceOnce(str, " 0 minutes", "");
                    localObject2 = str;
                    localObject1 = localObject2;
                    if (str.length() != ((String) localObject2).length()) {
                        localObject1 = StringUtils.replaceOnce(str, " 0 seconds", "");
                    }
                }
            }
            localObject2 = localObject1;
            if (((String) localObject1).length() != 0) {
                localObject2 = ((String) localObject1).substring(1);
            }
        }
        localObject1 = localObject2;
        if (paramBoolean2) {
            str = StringUtils.replaceOnce((String) localObject2, " 0 seconds", "");
            localObject1 = localObject2;
            if (str.length() != ((String) localObject2).length()) {
                localObject2 = str;
                str = StringUtils.replaceOnce((String) localObject2, " 0 minutes", "");
                localObject1 = localObject2;
                if (str.length() != ((String) localObject2).length()) {
                    localObject2 = str;
                    str = StringUtils.replaceOnce((String) localObject2, " 0 hours", "");
                    localObject1 = localObject2;
                    if (str.length() != ((String) localObject2).length()) {
                        localObject1 = StringUtils.replaceOnce(str, " 0 days", "");
                    }
                }
            }
        }
        return StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(" " + (String) localObject1, " 1 seconds", " 1 second"), " 1 minutes", " 1 minute"), " 1 hours", " 1 hour"), " 1 days", " 1 day").trim();
    }

    public static String formatPeriod(long paramLong1, long paramLong2, String paramString) {
        return formatPeriod(paramLong1, paramLong2, paramString, true, TimeZone.getDefault());
    }

    public static String formatPeriod(long paramLong1, long paramLong2, String paramString, boolean paramBoolean, TimeZone paramTimeZone) {
        paramString = lexx(paramString);
        Calendar localCalendar = Calendar.getInstance(paramTimeZone);
        localCalendar.setTime(new Date(paramLong1));
        paramTimeZone = Calendar.getInstance(paramTimeZone);
        paramTimeZone.setTime(new Date(paramLong2));
        int k = paramTimeZone.get(14) - localCalendar.get(14);
        int j = paramTimeZone.get(13) - localCalendar.get(13);
        int i1 = paramTimeZone.get(12) - localCalendar.get(12);
        int i2 = paramTimeZone.get(11) - localCalendar.get(11);
        int i3 = paramTimeZone.get(5) - localCalendar.get(5);
        int i6 = paramTimeZone.get(2) - localCalendar.get(2);
        int i4 = paramTimeZone.get(1) - localCalendar.get(1);
        for (; ; ) {
            i = i1;
            n = j;
            if (k >= 0) {
                break;
            }
            k += 1000;
            j -= 1;
        }
        for (; ; ) {
            j = i2;
            i1 = i;
            if (n >= 0) {
                break;
            }
            n += 60;
            i -= 1;
        }
        for (; ; ) {
            i = i3;
            i2 = j;
            if (i1 >= 0) {
                break;
            }
            i1 += 60;
            j -= 1;
        }
        while (i2 < 0) {
            i2 += 24;
            i -= 1;
        }
        if (Token.containsTokenWithValue(paramString, M)) {
            i5 = i;
            i3 = i6;
            for (; ; ) {
                i = i4;
                j = i3;
                if (i5 >= 0) {
                    break;
                }
                i5 += localCalendar.getActualMaximum(5);
                i3 -= 1;
                localCalendar.add(2, 1);
            }
            while (j < 0) {
                j += 12;
                i -= 1;
            }
            i3 = i;
            i4 = j;
            i6 = i5;
            if (!Token.containsTokenWithValue(paramString, y)) {
                i3 = i;
                i4 = j;
                i6 = i5;
                if (i != 0) {
                    for (; ; ) {
                        i3 = i;
                        i4 = j;
                        i6 = i5;
                        if (i == 0) {
                            break;
                        }
                        j += i * 12;
                        i = 0;
                    }
                }
            }
        } else {
            i5 = i4;
            j = i;
            if (!Token.containsTokenWithValue(paramString, y)) {
                i4 = paramTimeZone.get(1);
                j = i;
                i3 = i4;
                if (i6 < 0) {
                    i3 = i4 - 1;
                }
                for (j = i; localCalendar.get(1) != i3; j = i + localCalendar.get(6)) {
                    j += localCalendar.getActualMaximum(6) - localCalendar.get(6);
                    i = j;
                    if ((localCalendar instanceof GregorianCalendar)) {
                        i = j;
                        if (localCalendar.get(2) == 1) {
                            i = j;
                            if (localCalendar.get(5) == 29) {
                                i = j + 1;
                            }
                        }
                    }
                    localCalendar.add(1, 1);
                }
                i5 = 0;
            }
            while (localCalendar.get(2) != paramTimeZone.get(2)) {
                j += localCalendar.getActualMaximum(5);
                localCalendar.add(2, 1);
            }
            i = 0;
            for (; ; ) {
                i3 = i5;
                i4 = i;
                i6 = j;
                if (j >= 0) {
                    break;
                }
                j += localCalendar.getActualMaximum(5);
                i -= 1;
                localCalendar.add(2, 1);
            }
        }
        int i5 = i6;
        int i = i2;
        if (!Token.containsTokenWithValue(paramString, d)) {
            i = i2 + i6 * 24;
            i5 = 0;
        }
        i2 = i;
        j = i1;
        if (!Token.containsTokenWithValue(paramString, H)) {
            j = i1 + i * 60;
            i2 = 0;
        }
        i1 = j;
        i = n;
        if (!Token.containsTokenWithValue(paramString, m)) {
            i = n + j * 60;
            i1 = 0;
        }
        int n = i;
        j = k;
        if (!Token.containsTokenWithValue(paramString, s)) {
            j = k + i * 1000;
            n = 0;
        }
        return format(paramString, i3, i4, i5, i2, i1, n, j, paramBoolean);
    }

    public static String formatPeriodISO(long paramLong1, long paramLong2) {
        return formatPeriod(paramLong1, paramLong2, "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'", false, TimeZone.getDefault());
    }

    static Token[] lexx(String paramString) {
        char[] arrayOfChar = paramString.toCharArray();
        ArrayList localArrayList = new ArrayList(arrayOfChar.length);
        int i = 0;
        Object localObject1 = null;
        Object localObject2 = null;
        int n = arrayOfChar.length;
        int j = 0;
        if (j < n) {
            char c = arrayOfChar[j];
            Object localObject3;
            int k;
            if ((i != 0) && (c != '\'')) {
                ((StringBuffer) localObject1).append(c);
                localObject3 = localObject2;
                k = i;
            }
            label204:
            do {
                j += 1;
                i = k;
                localObject2 = localObject3;
                break;
                paramString = null;
                switch (c) {
                    default:
                        localObject3 = localObject1;
                        if (localObject1 == null) {
                            localObject3 = new StringBuffer();
                            localArrayList.add(new Token(localObject3));
                        }
                        ((StringBuffer) localObject3).append(c);
                        localObject1 = localObject3;
                        k = i;
                        localObject3 = localObject2;
                }
            } while (paramString == null);
            if ((localObject2 != null) && (((Token) localObject2).getValue() == paramString)) {
                ((Token) localObject2).increment();
            }
            for (; ; ) {
                localObject1 = null;
                k = i;
                localObject3 = localObject2;
                break;
                if (i != 0) {
                    localObject1 = null;
                    i = 0;
                    break label204;
                }
                localObject1 = new StringBuffer();
                localArrayList.add(new Token(localObject1));
                i = 1;
                break label204;
                paramString = y;
                break label204;
                paramString = M;
                break label204;
                paramString = d;
                break label204;
                paramString = H;
                break label204;
                paramString = m;
                break label204;
                paramString = s;
                break label204;
                paramString = S;
                break label204;
                localObject2 = new Token(paramString);
                localArrayList.add(localObject2);
            }
        }
        return (Token[]) localArrayList.toArray(new Token[localArrayList.size()]);
    }

    static class Token {
        private int count;
        private Object value;

        Token(Object paramObject) {
            this.value = paramObject;
            this.count = 1;
        }

        Token(Object paramObject, int paramInt) {
            this.value = paramObject;
            this.count = paramInt;
        }

        static boolean containsTokenWithValue(Token[] paramArrayOfToken, Object paramObject) {
            int j = paramArrayOfToken.length;
            int i = 0;
            while (i < j) {
                if (paramArrayOfToken[i].getValue() == paramObject) {
                    return true;
                }
                i += 1;
            }
            return false;
        }

        public boolean equals(Object paramObject) {
            if ((paramObject instanceof Token)) {
                paramObject = (Token) paramObject;
                if (this.value.getClass() == ((Token) paramObject).value.getClass()) {
                    break label31;
                }
            }
            label31:
            do {
                do {
                    return false;
                } while (this.count != ((Token) paramObject).count);
                if ((this.value instanceof StringBuffer)) {
                    return this.value.toString().equals(((Token) paramObject).value.toString());
                }
                if ((this.value instanceof Number)) {
                    return this.value.equals(((Token) paramObject).value);
                }
            } while (this.value != ((Token) paramObject).value);
            return true;
        }

        int getCount() {
            return this.count;
        }

        Object getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        void increment() {
            this.count += 1;
        }

        public String toString() {
            return StringUtils.repeat(this.value.toString(), this.count);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/time/DurationFormatUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */