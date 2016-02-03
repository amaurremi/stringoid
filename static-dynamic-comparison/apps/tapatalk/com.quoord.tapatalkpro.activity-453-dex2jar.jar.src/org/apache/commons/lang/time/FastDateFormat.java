package org.apache.commons.lang.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.lang.Validate;

public class FastDateFormat
        extends Format {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static final Map cDateInstanceCache;
    private static final Map cDateTimeInstanceCache = new HashMap(7);
    private static String cDefaultPattern;
    private static final Map cInstanceCache = new HashMap(7);
    private static final Map cTimeInstanceCache;
    private static final Map cTimeZoneDisplayCache = new HashMap(7);
    private static final long serialVersionUID = 1L;
    private final Locale mLocale;
    private final boolean mLocaleForced;
    private transient int mMaxLengthEstimate;
    private final String mPattern;
    private transient Rule[] mRules;
    private final TimeZone mTimeZone;
    private final boolean mTimeZoneForced;

    static {
        cDateInstanceCache = new HashMap(7);
        cTimeInstanceCache = new HashMap(7);
    }

    protected FastDateFormat(String paramString, TimeZone paramTimeZone, Locale paramLocale) {
        if (paramString == null) {
            throw new IllegalArgumentException("The pattern must not be null");
        }
        this.mPattern = paramString;
        if (paramTimeZone != null) {
            bool1 = true;
            this.mTimeZoneForced = bool1;
            paramString = paramTimeZone;
            if (paramTimeZone == null) {
                paramString = TimeZone.getDefault();
            }
            this.mTimeZone = paramString;
            if (paramLocale == null) {
                break label90;
            }
        }
        label90:
        for (boolean bool1 = bool2; ; bool1 = false) {
            this.mLocaleForced = bool1;
            paramString = paramLocale;
            if (paramLocale == null) {
                paramString = Locale.getDefault();
            }
            this.mLocale = paramString;
            return;
            bool1 = false;
            break;
        }
    }

    public static FastDateFormat getDateInstance(int paramInt) {
        return getDateInstance(paramInt, null, null);
    }

    public static FastDateFormat getDateInstance(int paramInt, Locale paramLocale) {
        return getDateInstance(paramInt, null, paramLocale);
    }

    public static FastDateFormat getDateInstance(int paramInt, TimeZone paramTimeZone) {
        return getDateInstance(paramInt, paramTimeZone, null);
    }

    public static FastDateFormat getDateInstance(int paramInt, TimeZone paramTimeZone, Locale paramLocale) {
        try {
            Object localObject = new Integer(paramInt);
            if (paramTimeZone != null) {
                localObject = new Pair(localObject, paramTimeZone);
            }
            for (; ; ) {
                Locale localLocale = paramLocale;
                if (paramLocale == null) {
                    localLocale = Locale.getDefault();
                }
                Pair localPair = new Pair(localObject, localLocale);
                localObject = (FastDateFormat) cDateInstanceCache.get(localPair);
                paramLocale = (Locale) localObject;
                if (localObject == null) {
                }
                try {
                    paramLocale = getInstance(((SimpleDateFormat) DateFormat.getDateInstance(paramInt, localLocale)).toPattern(), paramTimeZone, localLocale);
                    cDateInstanceCache.put(localPair, paramLocale);
                    return paramLocale;
                } catch (ClassCastException paramTimeZone) {
                    throw new IllegalArgumentException("No date pattern for locale: " + localLocale);
                }
            }
        } finally {
        }
    }

    public static FastDateFormat getDateTimeInstance(int paramInt1, int paramInt2) {
        return getDateTimeInstance(paramInt1, paramInt2, null, null);
    }

    public static FastDateFormat getDateTimeInstance(int paramInt1, int paramInt2, Locale paramLocale) {
        return getDateTimeInstance(paramInt1, paramInt2, null, paramLocale);
    }

    public static FastDateFormat getDateTimeInstance(int paramInt1, int paramInt2, TimeZone paramTimeZone) {
        return getDateTimeInstance(paramInt1, paramInt2, paramTimeZone, null);
    }

    public static FastDateFormat getDateTimeInstance(int paramInt1, int paramInt2, TimeZone paramTimeZone, Locale paramLocale) {
        try {
            Object localObject = new Pair(new Integer(paramInt1), new Integer(paramInt2));
            if (paramTimeZone != null) {
                localObject = new Pair(localObject, paramTimeZone);
            }
            for (; ; ) {
                Locale localLocale = paramLocale;
                if (paramLocale == null) {
                    localLocale = Locale.getDefault();
                }
                Pair localPair = new Pair(localObject, localLocale);
                localObject = (FastDateFormat) cDateTimeInstanceCache.get(localPair);
                paramLocale = (Locale) localObject;
                if (localObject == null) {
                }
                try {
                    paramLocale = getInstance(((SimpleDateFormat) DateFormat.getDateTimeInstance(paramInt1, paramInt2, localLocale)).toPattern(), paramTimeZone, localLocale);
                    cDateTimeInstanceCache.put(localPair, paramLocale);
                    return paramLocale;
                } catch (ClassCastException paramTimeZone) {
                    throw new IllegalArgumentException("No date time pattern for locale: " + localLocale);
                }
            }
        } finally {
        }
    }

    private static String getDefaultPattern() {
        try {
            if (cDefaultPattern == null) {
                cDefaultPattern = new SimpleDateFormat().toPattern();
            }
            String str = cDefaultPattern;
            return str;
        } finally {
        }
    }

    public static FastDateFormat getInstance() {
        return getInstance(getDefaultPattern(), null, null);
    }

    public static FastDateFormat getInstance(String paramString) {
        return getInstance(paramString, null, null);
    }

    public static FastDateFormat getInstance(String paramString, Locale paramLocale) {
        return getInstance(paramString, null, paramLocale);
    }

    public static FastDateFormat getInstance(String paramString, TimeZone paramTimeZone) {
        return getInstance(paramString, paramTimeZone, null);
    }

    public static FastDateFormat getInstance(String paramString, TimeZone paramTimeZone, Locale paramLocale) {
        try {
            paramTimeZone = new FastDateFormat(paramString, paramTimeZone, paramLocale);
            paramLocale = (FastDateFormat) cInstanceCache.get(paramTimeZone);
            paramString = paramLocale;
            if (paramLocale == null) {
                paramString = paramTimeZone;
                paramString.init();
                cInstanceCache.put(paramString, paramString);
            }
            return paramString;
        } finally {
        }
    }

    public static FastDateFormat getTimeInstance(int paramInt) {
        return getTimeInstance(paramInt, null, null);
    }

    public static FastDateFormat getTimeInstance(int paramInt, Locale paramLocale) {
        return getTimeInstance(paramInt, null, paramLocale);
    }

    public static FastDateFormat getTimeInstance(int paramInt, TimeZone paramTimeZone) {
        return getTimeInstance(paramInt, paramTimeZone, null);
    }

    public static FastDateFormat getTimeInstance(int paramInt, TimeZone paramTimeZone, Locale paramLocale) {
        for (; ; ) {
            try {
                Object localObject1 = new Integer(paramInt);
                if (paramTimeZone != null) {
                    localObject1 = new Pair(localObject1, paramTimeZone);
                    if (paramLocale != null) {
                        localObject1 = new Pair(localObject1, paramLocale);
                        FastDateFormat localFastDateFormat = (FastDateFormat) cTimeInstanceCache.get(localObject1);
                        Object localObject2 = localFastDateFormat;
                        if (localFastDateFormat == null) {
                            localObject2 = paramLocale;
                            if (paramLocale == null) {
                                localObject2 = Locale.getDefault();
                            }
                        }
                        try {
                            paramTimeZone = getInstance(((SimpleDateFormat) DateFormat.getTimeInstance(paramInt, (Locale) localObject2)).toPattern(), paramTimeZone, (Locale) localObject2);
                            cTimeInstanceCache.put(localObject1, paramTimeZone);
                            localObject2 = paramTimeZone;
                            return (FastDateFormat) localObject2;
                        } catch (ClassCastException paramTimeZone) {
                            throw new IllegalArgumentException("No date pattern for locale: " + localObject2);
                        }
                    }
                }
            } finally {
            }
        }
    }

    static String getTimeZoneDisplay(TimeZone paramTimeZone, boolean paramBoolean, int paramInt, Locale paramLocale) {
        try {
            TimeZoneDisplayKey localTimeZoneDisplayKey = new TimeZoneDisplayKey(paramTimeZone, paramBoolean, paramInt, paramLocale);
            String str2 = (String) cTimeZoneDisplayCache.get(localTimeZoneDisplayKey);
            String str1 = str2;
            if (str2 == null) {
                str1 = paramTimeZone.getDisplayName(paramBoolean, paramInt, paramLocale);
                cTimeZoneDisplayCache.put(localTimeZoneDisplayKey, str1);
            }
            return str1;
        } finally {
        }
    }

    private void readObject(ObjectInputStream paramObjectInputStream)
            throws IOException, ClassNotFoundException {
        paramObjectInputStream.defaultReadObject();
        init();
    }

    protected StringBuffer applyRules(Calendar paramCalendar, StringBuffer paramStringBuffer) {
        Rule[] arrayOfRule = this.mRules;
        int j = this.mRules.length;
        int i = 0;
        while (i < j) {
            arrayOfRule[i].appendTo(paramStringBuffer, paramCalendar);
            i += 1;
        }
        return paramStringBuffer;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof FastDateFormat)) {
        }
        do {
            return false;
            paramObject = (FastDateFormat) paramObject;
        }
        while (((this.mPattern != ((FastDateFormat) paramObject).mPattern) && (!this.mPattern.equals(((FastDateFormat) paramObject).mPattern))) || ((this.mTimeZone != ((FastDateFormat) paramObject).mTimeZone) && (!this.mTimeZone.equals(((FastDateFormat) paramObject).mTimeZone))) || ((this.mLocale != ((FastDateFormat) paramObject).mLocale) && (!this.mLocale.equals(((FastDateFormat) paramObject).mLocale))) || (this.mTimeZoneForced != ((FastDateFormat) paramObject).mTimeZoneForced) || (this.mLocaleForced != ((FastDateFormat) paramObject).mLocaleForced));
        return true;
    }

    public String format(long paramLong) {
        return format(new Date(paramLong));
    }

    public String format(Calendar paramCalendar) {
        return format(paramCalendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
    }

    public String format(Date paramDate) {
        GregorianCalendar localGregorianCalendar = new GregorianCalendar(this.mTimeZone);
        localGregorianCalendar.setTime(paramDate);
        return applyRules(localGregorianCalendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
    }

    public StringBuffer format(long paramLong, StringBuffer paramStringBuffer) {
        return format(new Date(paramLong), paramStringBuffer);
    }

    public StringBuffer format(Object paramObject, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition) {
        if ((paramObject instanceof Date)) {
            return format((Date) paramObject, paramStringBuffer);
        }
        if ((paramObject instanceof Calendar)) {
            return format((Calendar) paramObject, paramStringBuffer);
        }
        if ((paramObject instanceof Long)) {
            return format(((Long) paramObject).longValue(), paramStringBuffer);
        }
        paramStringBuffer = new StringBuffer().append("Unknown class: ");
        if (paramObject == null) {
        }
        for (paramObject = "<null>"; ; paramObject = paramObject.getClass().getName()) {
            throw new IllegalArgumentException((String) paramObject);
        }
    }

    public StringBuffer format(Calendar paramCalendar, StringBuffer paramStringBuffer) {
        Calendar localCalendar = paramCalendar;
        if (this.mTimeZoneForced) {
            paramCalendar.getTime();
            localCalendar = (Calendar) paramCalendar.clone();
            localCalendar.setTimeZone(this.mTimeZone);
        }
        return applyRules(localCalendar, paramStringBuffer);
    }

    public StringBuffer format(Date paramDate, StringBuffer paramStringBuffer) {
        GregorianCalendar localGregorianCalendar = new GregorianCalendar(this.mTimeZone);
        localGregorianCalendar.setTime(paramDate);
        return applyRules(localGregorianCalendar, paramStringBuffer);
    }

    public Locale getLocale() {
        return this.mLocale;
    }

    public int getMaxLengthEstimate() {
        return this.mMaxLengthEstimate;
    }

    public String getPattern() {
        return this.mPattern;
    }

    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    public boolean getTimeZoneOverridesCalendar() {
        return this.mTimeZoneForced;
    }

    public int hashCode() {
        int j = 1;
        int k = this.mPattern.hashCode();
        int m = this.mTimeZone.hashCode();
        int i;
        int n;
        if (this.mTimeZoneForced) {
            i = 1;
            n = this.mLocale.hashCode();
            if (!this.mLocaleForced) {
                break label63;
            }
        }
        for (; ; ) {
            return 0 + k + m + i + n + j;
            i = 0;
            break;
            label63:
            j = 0;
        }
    }

    protected void init() {
        List localList = parsePattern();
        this.mRules = ((Rule[]) localList.toArray(new Rule[localList.size()]));
        int i = 0;
        int j = this.mRules.length;
        for (; ; ) {
            j -= 1;
            if (j < 0) {
                break;
            }
            i += this.mRules[j].estimateLength();
        }
        this.mMaxLengthEstimate = i;
    }

    public Object parseObject(String paramString, ParsePosition paramParsePosition) {
        paramParsePosition.setIndex(0);
        paramParsePosition.setErrorIndex(0);
        return null;
    }

    protected List parsePattern() {
        Object localObject = new DateFormatSymbols(this.mLocale);
        ArrayList localArrayList = new ArrayList();
        String[] arrayOfString3 = ((DateFormatSymbols) localObject).getEras();
        String[] arrayOfString4 = ((DateFormatSymbols) localObject).getMonths();
        String[] arrayOfString5 = ((DateFormatSymbols) localObject).getShortMonths();
        String[] arrayOfString1 = ((DateFormatSymbols) localObject).getWeekdays();
        String[] arrayOfString2 = ((DateFormatSymbols) localObject).getShortWeekdays();
        String[] arrayOfString6 = ((DateFormatSymbols) localObject).getAmPmStrings();
        int j = this.mPattern.length();
        int[] arrayOfInt = new int[1];
        int i = 0;
        int k;
        if (i < j) {
            arrayOfInt[0] = i;
            localObject = parseToken(this.mPattern, arrayOfInt);
            i = arrayOfInt[0];
            k = ((String) localObject).length();
            if (k != 0) {
            }
        } else {
            return localArrayList;
        }
        switch (((String) localObject).charAt(0)) {
            default:
                throw new IllegalArgumentException("Illegal pattern component: " + (String) localObject);
            case 'G':
                localObject = new TextField(0, arrayOfString3);
        }
        for (; ; ) {
            localArrayList.add(localObject);
            i += 1;
            break;
            if (k >= 4) {
                localObject = selectNumberRule(1, k);
            } else {
                localObject = TwoDigitYearField.INSTANCE;
                continue;
                if (k >= 4) {
                    localObject = new TextField(2, arrayOfString4);
                } else if (k == 3) {
                    localObject = new TextField(2, arrayOfString5);
                } else if (k == 2) {
                    localObject = TwoDigitMonthField.INSTANCE;
                } else {
                    localObject = UnpaddedMonthField.INSTANCE;
                    continue;
                    localObject = selectNumberRule(5, k);
                    continue;
                    localObject = new TwelveHourField(selectNumberRule(10, k));
                    continue;
                    localObject = selectNumberRule(11, k);
                    continue;
                    localObject = selectNumberRule(12, k);
                    continue;
                    localObject = selectNumberRule(13, k);
                    continue;
                    localObject = selectNumberRule(14, k);
                    continue;
                    if (k < 4) {
                    }
                    for (localObject = arrayOfString2; ; localObject = arrayOfString1) {
                        localObject = new TextField(7, (String[]) localObject);
                        break;
                    }
                    localObject = selectNumberRule(6, k);
                    continue;
                    localObject = selectNumberRule(8, k);
                    continue;
                    localObject = selectNumberRule(3, k);
                    continue;
                    localObject = selectNumberRule(4, k);
                    continue;
                    localObject = new TextField(9, arrayOfString6);
                    continue;
                    localObject = new TwentyFourHourField(selectNumberRule(11, k));
                    continue;
                    localObject = selectNumberRule(10, k);
                    continue;
                    if (k >= 4) {
                        localObject = new TimeZoneNameRule(this.mTimeZone, this.mTimeZoneForced, this.mLocale, 1);
                    } else {
                        localObject = new TimeZoneNameRule(this.mTimeZone, this.mTimeZoneForced, this.mLocale, 0);
                        continue;
                        if (k == 1) {
                            localObject = TimeZoneNumberRule.INSTANCE_NO_COLON;
                        } else {
                            localObject = TimeZoneNumberRule.INSTANCE_COLON;
                            continue;
                            localObject = ((String) localObject).substring(1);
                            if (((String) localObject).length() == 1) {
                                localObject = new CharacterLiteral(((String) localObject).charAt(0));
                            } else {
                                localObject = new StringLiteral((String) localObject);
                            }
                        }
                    }
                }
            }
        }
    }

    protected String parseToken(String paramString, int[] paramArrayOfInt) {
        StringBuffer localStringBuffer = new StringBuffer();
        int i = paramArrayOfInt[0];
        int m = paramString.length();
        char c = paramString.charAt(i);
        if (((c >= 'A') && (c <= 'Z')) || ((c >= 'a') && (c <= 'z'))) {
            localStringBuffer.append(c);
            for (; ; ) {
                j = i;
                if (i + 1 >= m) {
                    break;
                }
                j = i;
                if (paramString.charAt(i + 1) != c) {
                    break;
                }
                localStringBuffer.append(c);
                i += 1;
            }
        }
        localStringBuffer.append('\'');
        int k = 0;
        int j = i;
        if (i < m) {
            c = paramString.charAt(i);
            if (c == '\'') {
                if ((i + 1 < m) && (paramString.charAt(i + 1) == '\'')) {
                    i += 1;
                    localStringBuffer.append(c);
                    j = k;
                }
            }
        }
        for (; ; ) {
            i += 1;
            k = j;
            break;
            if (k == 0) {
            }
            for (j = 1; ; j = 0) {
                break;
            }
            if ((k == 0) && (((c >= 'A') && (c <= 'Z')) || ((c >= 'a') && (c <= 'z')))) {
                j = i - 1;
                paramArrayOfInt[0] = j;
                return localStringBuffer.toString();
            }
            localStringBuffer.append(c);
            j = k;
        }
    }

    protected NumberRule selectNumberRule(int paramInt1, int paramInt2) {
        switch (paramInt2) {
            default:
                return new PaddedNumberField(paramInt1, paramInt2);
            case 1:
                return new UnpaddedNumberField(paramInt1);
        }
        return new TwoDigitNumberField(paramInt1);
    }

    public String toString() {
        return "FastDateFormat[" + this.mPattern + "]";
    }

    private static class CharacterLiteral
            implements FastDateFormat.Rule {
        private final char mValue;

        CharacterLiteral(char paramChar) {
            this.mValue = paramChar;
        }

        public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar) {
            paramStringBuffer.append(this.mValue);
        }

        public int estimateLength() {
            return 1;
        }
    }

    private static abstract interface NumberRule
            extends FastDateFormat.Rule {
        public abstract void appendTo(StringBuffer paramStringBuffer, int paramInt);
    }

    private static class PaddedNumberField
            implements FastDateFormat.NumberRule {
        private final int mField;
        private final int mSize;

        PaddedNumberField(int paramInt1, int paramInt2) {
            if (paramInt2 < 3) {
                throw new IllegalArgumentException();
            }
            this.mField = paramInt1;
            this.mSize = paramInt2;
        }

        public final void appendTo(StringBuffer paramStringBuffer, int paramInt) {
            int i;
            if (paramInt < 100) {
                i = this.mSize;
                for (; ; ) {
                    i -= 1;
                    if (i < 2) {
                        break;
                    }
                    paramStringBuffer.append('0');
                }
                paramStringBuffer.append((char) (paramInt / 10 + 48));
                paramStringBuffer.append((char) (paramInt % 10 + 48));
                return;
            }
            if (paramInt < 1000) {
                i = 3;
                int j = this.mSize;
                for (; ; ) {
                    j -= 1;
                    if (j < i) {
                        break;
                    }
                    paramStringBuffer.append('0');
                }
            }
            if (paramInt > -1) {
            }
            for (boolean bool = true; ; bool = false) {
                Validate.isTrue(bool, "Negative values should not be possible", paramInt);
                i = Integer.toString(paramInt).length();
                break;
            }
            paramStringBuffer.append(Integer.toString(paramInt));
        }

        public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar) {
            appendTo(paramStringBuffer, paramCalendar.get(this.mField));
        }

        public int estimateLength() {
            return 4;
        }
    }

    private static class Pair {
        private final Object mObj1;
        private final Object mObj2;

        public Pair(Object paramObject1, Object paramObject2) {
            this.mObj1 = paramObject1;
            this.mObj2 = paramObject2;
        }

        public boolean equals(Object paramObject) {
            if (this == paramObject) {
            }
            do {
                return true;
                if (!(paramObject instanceof Pair)) {
                    return false;
                }
                paramObject = (Pair) paramObject;
                if (this.mObj1 != null) {
                    break label51;
                }
                if (((Pair) paramObject).mObj1 != null) {
                    break;
                }
                if (this.mObj2 != null) {
                    break label68;
                }
            } while (((Pair) paramObject).mObj2 == null);
            label51:
            label68:
            while (!this.mObj2.equals(((Pair) paramObject).mObj2)) {
                do {
                    return false;
                } while (!this.mObj1.equals(((Pair) paramObject).mObj1));
                break;
            }
            return true;
        }

        public int hashCode() {
            int j = 0;
            int i;
            if (this.mObj1 == null) {
                i = 0;
                if (this.mObj2 != null) {
                    break label33;
                }
            }
            for (; ; ) {
                return i + j;
                i = this.mObj1.hashCode();
                break;
                label33:
                j = this.mObj2.hashCode();
            }
        }

        public String toString() {
            return "[" + this.mObj1 + ':' + this.mObj2 + ']';
        }
    }

    private static abstract interface Rule {
        public abstract void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar);

        public abstract int estimateLength();
    }

    private static class StringLiteral
            implements FastDateFormat.Rule {
        private final String mValue;

        StringLiteral(String paramString) {
            this.mValue = paramString;
        }

        public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar) {
            paramStringBuffer.append(this.mValue);
        }

        public int estimateLength() {
            return this.mValue.length();
        }
    }

    private static class TextField
            implements FastDateFormat.Rule {
        private final int mField;
        private final String[] mValues;

        TextField(int paramInt, String[] paramArrayOfString) {
            this.mField = paramInt;
            this.mValues = paramArrayOfString;
        }

        public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar) {
            paramStringBuffer.append(this.mValues[paramCalendar.get(this.mField)]);
        }

        public int estimateLength() {
            int j = 0;
            int i = this.mValues.length;
            for (; ; ) {
                int k = i - 1;
                if (k < 0) {
                    break;
                }
                int m = this.mValues[k].length();
                i = k;
                if (m > j) {
                    j = m;
                    i = k;
                }
            }
            return j;
        }
    }

    private static class TimeZoneDisplayKey {
        private final Locale mLocale;
        private final int mStyle;
        private final TimeZone mTimeZone;

        TimeZoneDisplayKey(TimeZone paramTimeZone, boolean paramBoolean, int paramInt, Locale paramLocale) {
            this.mTimeZone = paramTimeZone;
            int i = paramInt;
            if (paramBoolean) {
                i = paramInt | 0x80000000;
            }
            this.mStyle = i;
            this.mLocale = paramLocale;
        }

        public boolean equals(Object paramObject) {
            if (this == paramObject) {
            }
            do {
                return true;
                if (!(paramObject instanceof TimeZoneDisplayKey)) {
                    break;
                }
                paramObject = (TimeZoneDisplayKey) paramObject;
            }
            while ((this.mTimeZone.equals(((TimeZoneDisplayKey) paramObject).mTimeZone)) && (this.mStyle == ((TimeZoneDisplayKey) paramObject).mStyle) && (this.mLocale.equals(((TimeZoneDisplayKey) paramObject).mLocale)));
            return false;
            return false;
        }

        public int hashCode() {
            return this.mStyle * 31 + this.mLocale.hashCode();
        }
    }

    private static class TimeZoneNameRule
            implements FastDateFormat.Rule {
        private final String mDaylight;
        private final Locale mLocale;
        private final String mStandard;
        private final int mStyle;
        private final TimeZone mTimeZone;
        private final boolean mTimeZoneForced;

        TimeZoneNameRule(TimeZone paramTimeZone, boolean paramBoolean, Locale paramLocale, int paramInt) {
            this.mTimeZone = paramTimeZone;
            this.mTimeZoneForced = paramBoolean;
            this.mLocale = paramLocale;
            this.mStyle = paramInt;
            if (paramBoolean) {
                this.mStandard = FastDateFormat.getTimeZoneDisplay(paramTimeZone, false, paramInt, paramLocale);
                this.mDaylight = FastDateFormat.getTimeZoneDisplay(paramTimeZone, true, paramInt, paramLocale);
                return;
            }
            this.mStandard = null;
            this.mDaylight = null;
        }

        public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar) {
            if (this.mTimeZoneForced) {
                if ((this.mTimeZone.useDaylightTime()) && (paramCalendar.get(16) != 0)) {
                    paramStringBuffer.append(this.mDaylight);
                    return;
                }
                paramStringBuffer.append(this.mStandard);
                return;
            }
            TimeZone localTimeZone = paramCalendar.getTimeZone();
            if ((localTimeZone.useDaylightTime()) && (paramCalendar.get(16) != 0)) {
                paramStringBuffer.append(FastDateFormat.getTimeZoneDisplay(localTimeZone, true, this.mStyle, this.mLocale));
                return;
            }
            paramStringBuffer.append(FastDateFormat.getTimeZoneDisplay(localTimeZone, false, this.mStyle, this.mLocale));
        }

        public int estimateLength() {
            if (this.mTimeZoneForced) {
                return Math.max(this.mStandard.length(), this.mDaylight.length());
            }
            if (this.mStyle == 0) {
                return 4;
            }
            return 40;
        }
    }

    private static class TimeZoneNumberRule
            implements FastDateFormat.Rule {
        static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
        static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
        final boolean mColon;

        TimeZoneNumberRule(boolean paramBoolean) {
            this.mColon = paramBoolean;
        }

        public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar) {
            int i = paramCalendar.get(15) + paramCalendar.get(16);
            if (i < 0) {
                paramStringBuffer.append('-');
                i = -i;
            }
            for (; ; ) {
                int j = i / 3600000;
                paramStringBuffer.append((char) (j / 10 + 48));
                paramStringBuffer.append((char) (j % 10 + 48));
                if (this.mColon) {
                    paramStringBuffer.append(':');
                }
                i = i / 60000 - j * 60;
                paramStringBuffer.append((char) (i / 10 + 48));
                paramStringBuffer.append((char) (i % 10 + 48));
                return;
                paramStringBuffer.append('+');
            }
        }

        public int estimateLength() {
            return 5;
        }
    }

    private static class TwelveHourField
            implements FastDateFormat.NumberRule {
        private final FastDateFormat.NumberRule mRule;

        TwelveHourField(FastDateFormat.NumberRule paramNumberRule) {
            this.mRule = paramNumberRule;
        }

        public void appendTo(StringBuffer paramStringBuffer, int paramInt) {
            this.mRule.appendTo(paramStringBuffer, paramInt);
        }

        public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar) {
            int j = paramCalendar.get(10);
            int i = j;
            if (j == 0) {
                i = paramCalendar.getLeastMaximum(10) + 1;
            }
            this.mRule.appendTo(paramStringBuffer, i);
        }

        public int estimateLength() {
            return this.mRule.estimateLength();
        }
    }

    private static class TwentyFourHourField
            implements FastDateFormat.NumberRule {
        private final FastDateFormat.NumberRule mRule;

        TwentyFourHourField(FastDateFormat.NumberRule paramNumberRule) {
            this.mRule = paramNumberRule;
        }

        public void appendTo(StringBuffer paramStringBuffer, int paramInt) {
            this.mRule.appendTo(paramStringBuffer, paramInt);
        }

        public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar) {
            int j = paramCalendar.get(11);
            int i = j;
            if (j == 0) {
                i = paramCalendar.getMaximum(11) + 1;
            }
            this.mRule.appendTo(paramStringBuffer, i);
        }

        public int estimateLength() {
            return this.mRule.estimateLength();
        }
    }

    private static class TwoDigitMonthField
            implements FastDateFormat.NumberRule {
        static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();

        public final void appendTo(StringBuffer paramStringBuffer, int paramInt) {
            paramStringBuffer.append((char) (paramInt / 10 + 48));
            paramStringBuffer.append((char) (paramInt % 10 + 48));
        }

        public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar) {
            appendTo(paramStringBuffer, paramCalendar.get(2) + 1);
        }

        public int estimateLength() {
            return 2;
        }
    }

    private static class TwoDigitNumberField
            implements FastDateFormat.NumberRule {
        private final int mField;

        TwoDigitNumberField(int paramInt) {
            this.mField = paramInt;
        }

        public final void appendTo(StringBuffer paramStringBuffer, int paramInt) {
            if (paramInt < 100) {
                paramStringBuffer.append((char) (paramInt / 10 + 48));
                paramStringBuffer.append((char) (paramInt % 10 + 48));
                return;
            }
            paramStringBuffer.append(Integer.toString(paramInt));
        }

        public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar) {
            appendTo(paramStringBuffer, paramCalendar.get(this.mField));
        }

        public int estimateLength() {
            return 2;
        }
    }

    private static class TwoDigitYearField
            implements FastDateFormat.NumberRule {
        static final TwoDigitYearField INSTANCE = new TwoDigitYearField();

        public final void appendTo(StringBuffer paramStringBuffer, int paramInt) {
            paramStringBuffer.append((char) (paramInt / 10 + 48));
            paramStringBuffer.append((char) (paramInt % 10 + 48));
        }

        public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar) {
            appendTo(paramStringBuffer, paramCalendar.get(1) % 100);
        }

        public int estimateLength() {
            return 2;
        }
    }

    private static class UnpaddedMonthField
            implements FastDateFormat.NumberRule {
        static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();

        public final void appendTo(StringBuffer paramStringBuffer, int paramInt) {
            if (paramInt < 10) {
                paramStringBuffer.append((char) (paramInt + 48));
                return;
            }
            paramStringBuffer.append((char) (paramInt / 10 + 48));
            paramStringBuffer.append((char) (paramInt % 10 + 48));
        }

        public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar) {
            appendTo(paramStringBuffer, paramCalendar.get(2) + 1);
        }

        public int estimateLength() {
            return 2;
        }
    }

    private static class UnpaddedNumberField
            implements FastDateFormat.NumberRule {
        private final int mField;

        UnpaddedNumberField(int paramInt) {
            this.mField = paramInt;
        }

        public final void appendTo(StringBuffer paramStringBuffer, int paramInt) {
            if (paramInt < 10) {
                paramStringBuffer.append((char) (paramInt + 48));
                return;
            }
            if (paramInt < 100) {
                paramStringBuffer.append((char) (paramInt / 10 + 48));
                paramStringBuffer.append((char) (paramInt % 10 + 48));
                return;
            }
            paramStringBuffer.append(Integer.toString(paramInt));
        }

        public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar) {
            appendTo(paramStringBuffer, paramCalendar.get(this.mField));
        }

        public int estimateLength() {
            return 4;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/time/FastDateFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */