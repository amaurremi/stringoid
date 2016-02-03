/*    */
package android.util;

/*    */
/*    */ public class Base64 {
    /*  4 */   Base64() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public static byte[] decode(String str, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public static byte[] decode(byte[] input, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public static byte[] decode(byte[] input, int offset, int len, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public static String encodeToString(byte[] input, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public static String encodeToString(byte[] input, int offset, int len, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public static byte[] encode(byte[] input, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public static byte[] encode(byte[] input, int offset, int len, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int DEFAULT = 0;
    /*    */   public static final int NO_PADDING = 1;
    /*    */   public static final int NO_WRAP = 2;
    /*    */   public static final int CRLF = 4;
    /*    */   public static final int URL_SAFE = 8;
    /*    */   public static final int NO_CLOSE = 16;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/util/Base64.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */