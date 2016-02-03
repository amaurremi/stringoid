/*   */
package android.os;

/*   */
/*   */ public final class SystemClock {
    /* 4 */   SystemClock() {
        throw new RuntimeException("Stub!");
    }

    /* 5 */
    public static void sleep(long ms) {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */
    public static native boolean setCurrentTimeMillis(long paramLong);

    /*   */
/*   */
    public static native long uptimeMillis();

    /*   */
/*   */
    public static native long elapsedRealtime();

    /*   */
/*   */
    public static native long currentThreadTimeMillis();
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/SystemClock.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */