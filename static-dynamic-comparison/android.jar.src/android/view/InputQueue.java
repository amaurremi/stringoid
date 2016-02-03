/*   */
package android.view;

/*   */
/*   */ 
/*   */ 
/*   */ public final class InputQueue
/*   */ {
    /*   */   InputQueue()
/*   */ {
/* 9 */
        throw new RuntimeException("Stub!");
/*   */
    }

    /*   */
/*   */   public static abstract interface Callback
/*   */ {
        /*   */
        public abstract void onInputQueueCreated(InputQueue paramInputQueue);

        /*   */
/*   */
        public abstract void onInputQueueDestroyed(InputQueue paramInputQueue);
/*   */
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/InputQueue.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */