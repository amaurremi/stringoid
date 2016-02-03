/*    */
package android.text.format;

/*    */
/*    */ public class Time {
    /*  4 */
    public Time(String timezone) {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public Time() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public Time(Time other) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public native long normalize(boolean paramBoolean);

    /*    */
    public native void switchTimezone(String paramString);

    /*  9 */
    public int getActualMaximum(int field) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void clear(String timezone) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public static int compare(Time a, Time b) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public String format(String format) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public native String toString();

    /* 14 */
    public boolean parse(String s) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public boolean parse3339(String s) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public static String getCurrentTimezone() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public native void setToNow();

    /*    */
    public native long toMillis(boolean paramBoolean);

    /*    */
    public native void set(long paramLong);

    /*    */
    public native String format2445();

    /* 21 */
    public void set(Time that) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void set(int second, int minute, int hour, int monthDay, int month, int year) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void set(int monthDay, int month, int year) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public boolean before(Time that) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public boolean after(Time that) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public int getWeekNumber() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public String format3339(boolean allDay) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public static boolean isEpoch(Time time) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public static int getJulianDay(long millis, long gmtoff) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public long setJulianDay(int julianDay) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public static int getWeeksSinceEpochFromJulianDay(int julianDay, int firstDayOfWeek) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public static int getJulianMondayFromWeeksSinceEpoch(int week) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final String TIMEZONE_UTC = "UTC";
    /*    */   public static final int EPOCH_JULIAN_DAY = 2440588;
    /*    */   public static final int MONDAY_BEFORE_JULIAN_EPOCH = 2440585;
    /*    */   public boolean allDay;
    /*    */   public int second;
    /*    */   public int minute;
    /*    */   public int hour;
    /*    */   public int monthDay;
    /*    */   public int month;
    /*    */   public int year;
    /*    */   public int weekDay;
    /*    */   public int yearDay;
    /*    */   public int isDst;
    /*    */   public long gmtoff;
    /*    */   public String timezone;
    /*    */   public static final int SECOND = 1;
    /*    */   public static final int MINUTE = 2;
    /*    */   public static final int HOUR = 3;
    /*    */   public static final int MONTH_DAY = 4;
    /*    */   public static final int MONTH = 5;
    /*    */   public static final int YEAR = 6;
    /*    */   public static final int WEEK_DAY = 7;
    /*    */   public static final int YEAR_DAY = 8;
    /*    */   public static final int WEEK_NUM = 9;
    /*    */   public static final int SUNDAY = 0;
    /*    */   public static final int MONDAY = 1;
    /*    */   public static final int TUESDAY = 2;
    /*    */   public static final int WEDNESDAY = 3;
    /*    */   public static final int THURSDAY = 4;
    /*    */   public static final int FRIDAY = 5;
    /*    */   public static final int SATURDAY = 6;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/format/Time.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */