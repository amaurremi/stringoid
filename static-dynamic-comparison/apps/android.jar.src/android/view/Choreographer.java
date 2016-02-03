/*    */
package android.view;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class Choreographer
/*    */ {
    /*  8 */   Choreographer() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public static Choreographer getInstance() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void postFrameCallback(FrameCallback callback) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void postFrameCallbackDelayed(FrameCallback callback, long delayMillis) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void removeFrameCallback(FrameCallback callback) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface FrameCallback
/*    */ {
        /*    */
        public abstract void doFrame(long paramLong);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/Choreographer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */