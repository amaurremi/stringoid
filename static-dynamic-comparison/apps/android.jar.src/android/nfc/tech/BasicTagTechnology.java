/*   */
package android.nfc.tech;
/*   */ 
/*   */

import java.io.IOException;

/*   */
/* 5 */ abstract class BasicTagTechnology implements TagTechnology {
    BasicTagTechnology() {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public android.nfc.Tag getTag() {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public boolean isConnected() {
        throw new RuntimeException("Stub!");
    }

    /* 8 */
    public void connect() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 9 */
    public void close() throws IOException {
        throw new RuntimeException("Stub!");
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/nfc/tech/BasicTagTechnology.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */