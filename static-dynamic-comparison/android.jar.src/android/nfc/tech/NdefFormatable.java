/*   */
package android.nfc.tech;
/*   */ 
/*   */

import android.nfc.NdefMessage;

/*   */
/* 5 */ public final class NdefFormatable extends BasicTagTechnology {
    NdefFormatable() {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public static NdefFormatable get(android.nfc.Tag tag) {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public void format(NdefMessage firstMessage) throws java.io.IOException, android.nfc.FormatException {
        throw new RuntimeException("Stub!");
    }

    /* 8 */
    public void formatReadOnly(NdefMessage firstMessage) throws java.io.IOException, android.nfc.FormatException {
        throw new RuntimeException("Stub!");
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/nfc/tech/NdefFormatable.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */