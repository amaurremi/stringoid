/*   */
package android.os;
/*   */ 
/*   */

import android.util.AndroidRuntimeException;

/*   */
/* 5 */ public class BadParcelableException extends AndroidRuntimeException {
    public BadParcelableException(String msg) {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public BadParcelableException(Exception cause) {
        throw new RuntimeException("Stub!");
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/BadParcelableException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */