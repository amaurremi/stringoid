/*   */
package android.os;
/*   */ 
/*   */

import android.util.AndroidException;

/*   */
/* 5 */ public class RemoteException extends AndroidException {
    public RemoteException() {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public RemoteException(String message) {
        throw new RuntimeException("Stub!");
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/RemoteException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */