/*    */
package android.net;

/*    */
/*    */ public class LocalSocketAddress
/*    */ {
    /*    */   public static enum Namespace {
        /*  6 */     ABSTRACT,
        /*  7 */     FILESYSTEM,
        /*  8 */     RESERVED;

        /*    */
        private Namespace() {
        }
    }

    /* 10 */
    public LocalSocketAddress(String name, Namespace namespace) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public LocalSocketAddress(String name) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public String getName() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public Namespace getNamespace() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/LocalSocketAddress.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */