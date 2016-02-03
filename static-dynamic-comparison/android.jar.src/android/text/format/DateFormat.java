/*    */
package android.text.format;
/*    */

import android.content.Context;

/*    */
/*  4 */ public class DateFormat {
    public DateFormat() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public static boolean is24HourFormat(Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public static final java.text.DateFormat getTimeFormat(Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public static final java.text.DateFormat getDateFormat(Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public static final java.text.DateFormat getLongDateFormat(Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public static final java.text.DateFormat getMediumDateFormat(Context context) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public static final char[] getDateFormatOrder(Context context) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public static final CharSequence format(CharSequence inFormat, long inTimeInMillis) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public static final CharSequence format(CharSequence inFormat, java.util.Date inDate) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public static final CharSequence format(CharSequence inFormat, java.util.Calendar inDate) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final char QUOTE = '\'';
    /*    */   public static final char AM_PM = 'a';
    /*    */   public static final char CAPITAL_AM_PM = 'A';
    /*    */   public static final char DATE = 'd';
    /*    */   public static final char DAY = 'E';
    /*    */   public static final char HOUR = 'h';
    /*    */   public static final char HOUR_OF_DAY = 'k';
    /*    */   public static final char MINUTE = 'm';
    /*    */   public static final char MONTH = 'M';
    /*    */   public static final char SECONDS = 's';
    /*    */   public static final char TIME_ZONE = 'z';
    /*    */   public static final char YEAR = 'y';
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/format/DateFormat.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */