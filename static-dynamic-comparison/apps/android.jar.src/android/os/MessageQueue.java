/*    */
package android.os;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MessageQueue
/*    */ {
    /*  8 */   MessageQueue() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public final void addIdleHandler(IdleHandler handler) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public final void removeIdleHandler(IdleHandler handler) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface IdleHandler
/*    */ {
        /*    */
        public abstract boolean queueIdle();
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/MessageQueue.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */