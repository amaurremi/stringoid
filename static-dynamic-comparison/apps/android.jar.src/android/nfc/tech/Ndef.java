/*    */
package android.nfc.tech;
/*    */ 
/*    */

import android.nfc.NdefMessage;

/*    */
/*  5 */ public final class Ndef extends BasicTagTechnology {
    Ndef() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public static Ndef get(android.nfc.Tag tag) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public NdefMessage getCachedNdefMessage() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public String getType() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int getMaxSize() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public boolean isWritable() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public NdefMessage getNdefMessage() throws java.io.IOException, android.nfc.FormatException {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void writeNdefMessage(NdefMessage msg) throws java.io.IOException, android.nfc.FormatException {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public boolean canMakeReadOnly() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public boolean makeReadOnly() throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final String NFC_FORUM_TYPE_1 = "org.nfcforum.ndef.type1";
    /*    */   public static final String NFC_FORUM_TYPE_2 = "org.nfcforum.ndef.type2";
    /*    */   public static final String NFC_FORUM_TYPE_3 = "org.nfcforum.ndef.type3";
    /*    */   public static final String NFC_FORUM_TYPE_4 = "org.nfcforum.ndef.type4";
    /*    */   public static final String MIFARE_CLASSIC = "com.nxp.ndef.mifareclassic";
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/nfc/tech/Ndef.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */