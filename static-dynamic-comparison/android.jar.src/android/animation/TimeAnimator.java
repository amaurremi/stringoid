/*    */
package android.animation;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TimeAnimator
/*    */ extends ValueAnimator
/*    */ {
    /*  9 */
    public TimeAnimator() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void setTimeListener(TimeListener listener) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface TimeListener
/*    */ {
        /*    */
        public abstract void onTimeUpdate(TimeAnimator paramTimeAnimator, long paramLong1, long paramLong2);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/animation/TimeAnimator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */