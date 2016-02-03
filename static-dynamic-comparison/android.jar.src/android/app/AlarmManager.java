/*    */
package android.app;

/*    */
/*    */ public class AlarmManager {
    /*  4 */   AlarmManager() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public void set(int type, long triggerAtMillis, PendingIntent operation) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public void setRepeating(int type, long triggerAtMillis, long intervalMillis, PendingIntent operation) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void setInexactRepeating(int type, long triggerAtMillis, long intervalMillis, PendingIntent operation) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void cancel(PendingIntent operation) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void setTime(long millis) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void setTimeZone(String timeZone) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int RTC_WAKEUP = 0;
    /*    */   public static final int RTC = 1;
    /*    */   public static final int ELAPSED_REALTIME_WAKEUP = 2;
    /*    */   public static final int ELAPSED_REALTIME = 3;
    /*    */   public static final long INTERVAL_FIFTEEN_MINUTES = 900000L;
    /*    */   public static final long INTERVAL_HALF_HOUR = 1800000L;
    /*    */   public static final long INTERVAL_HOUR = 3600000L;
    /*    */   public static final long INTERVAL_HALF_DAY = 43200000L;
    /*    */   public static final long INTERVAL_DAY = 86400000L;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/AlarmManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */