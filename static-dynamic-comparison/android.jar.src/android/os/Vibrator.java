/*   */
package android.os;

/*   */
/*   */ public abstract class Vibrator {
    /* 4 */   Vibrator() {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */
    public abstract boolean hasVibrator();

    /*   */
/*   */
    public abstract void vibrate(long paramLong);

    /*   */
/*   */
    public abstract void vibrate(long[] paramArrayOfLong, int paramInt);

    /*   */
/*   */
    public abstract void cancel();
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/Vibrator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */