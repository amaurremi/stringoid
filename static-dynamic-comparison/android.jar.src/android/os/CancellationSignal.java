/*    */
package android.os;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class CancellationSignal
/*    */ {
    /*  8 */
    public CancellationSignal() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public boolean isCanceled() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void throwIfCanceled() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void cancel() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void setOnCancelListener(OnCancelListener listener) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnCancelListener
/*    */ {
        /*    */
        public abstract void onCancel();
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/CancellationSignal.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */