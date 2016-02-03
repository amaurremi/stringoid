/*    */
package android.nfc.tech;
/*    */ 
/*    */

import android.nfc.Tag;

/*    */
/*  5 */ public final class NfcF extends BasicTagTechnology {
    NfcF() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public static NfcF get(Tag tag) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public byte[] getSystemCode() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public byte[] getManufacturer() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public byte[] transceive(byte[] data) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int getMaxTransceiveLength() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void setTimeout(int timeout) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public int getTimeout() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/nfc/tech/NfcF.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */