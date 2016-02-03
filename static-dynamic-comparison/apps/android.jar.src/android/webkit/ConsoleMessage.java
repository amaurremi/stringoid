/*    */
package android.webkit;

/*    */
/*    */ public class ConsoleMessage
/*    */ {
    /*    */   public static enum MessageLevel {
        /*  6 */     DEBUG,
        /*  7 */     ERROR,
        /*  8 */     LOG,
        /*  9 */     TIP,
        /* 10 */     WARNING;

        /*    */
        private MessageLevel() {
        }
    }

    /* 12 */
    public ConsoleMessage(String message, String sourceId, int lineNumber, MessageLevel msgLevel) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public MessageLevel messageLevel() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public String message() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public String sourceId() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public int lineNumber() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/webkit/ConsoleMessage.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */