/*   */
package android.os;

/*   */
/*   */ public abstract class CountDownTimer {
    /* 4 */
    public CountDownTimer(long millisInFuture, long countDownInterval) {
        throw new RuntimeException("Stub!");
    }

    /* 5 */
    public final void cancel() {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public final synchronized CountDownTimer start() {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */
    public abstract void onTick(long paramLong);

    /*   */
/*   */
    public abstract void onFinish();
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/CountDownTimer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */