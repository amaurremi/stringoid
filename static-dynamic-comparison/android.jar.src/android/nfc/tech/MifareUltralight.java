/*    */
package android.nfc.tech;
/*    */ 
/*    */

import java.io.IOException;

/*    */
/*  5 */ public final class MifareUltralight extends BasicTagTechnology {
    MifareUltralight() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public static MifareUltralight get(android.nfc.Tag tag) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public int getType() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public byte[] readPages(int pageOffset) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void writePage(int pageOffset, byte[] data) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public byte[] transceive(byte[] data) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int getMaxTransceiveLength() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void setTimeout(int timeout) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int getTimeout() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int TYPE_UNKNOWN = -1;
    /*    */   public static final int TYPE_ULTRALIGHT = 1;
    /*    */   public static final int TYPE_ULTRALIGHT_C = 2;
    /*    */   public static final int PAGE_SIZE = 4;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/nfc/tech/MifareUltralight.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */